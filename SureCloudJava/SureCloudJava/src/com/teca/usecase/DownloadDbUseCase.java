package com.teca.usecase;


import com.teca.loader.CodeSetFinderFactory;
import com.teca.loader.IrCodeFinderFactory;
import com.teca.loader.codeset.CodeSetFinder;
import com.teca.loader.ircode.IrCodeFinder;
import com.teca.loader.orm.IrCode;
import com.teca.loader.orm.IrCodeAc;
import com.teca.store.Db;
import com.teca.store.orm.App2CodeSet;
import com.teca.store.orm.CodeSet;
import com.teca.store.orm.Type;
import com.teca.store.orm.Type2Brand;
import org.json.JSONException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by truonglx.
 */
public class DownloadDbUseCase {


    private static final int NUMBER_TYPE_2BRAND = 10;

    private static final int NUMBER_THREAD=10;

    private DownloadThread[] threads;

    private Type2BrandConsumer consumer;

    public DownloadDbUseCase() {

        consumer=new Type2BrandConsumer();
        threads=new DownloadThread[NUMBER_THREAD];
        for (int i=0;i<threads.length;i++)
            threads[i]=new DownloadThread(NUMBER_TYPE_2BRAND,consumer);
    }

    public void download() throws IOException, JSONException {

        for (DownloadThread thread:threads)
            thread.start();
    }





    private static class Type2BrandConsumer{


        private List<Type2Brand> type2Brands;

        public Type2BrandConsumer() {
            type2Brands=Db.getDb().getType2BrandDao().find(new Type2Brand(null,null));
        }



        public synchronized List<Type2Brand> getType2Brand(int numberElement){

            List<Type2Brand> res=new ArrayList<Type2Brand>();
            for (int i=0;i<numberElement;i++){
                if (type2Brands.size()>0)
                    res.add(type2Brands.remove(0));
                else
                    return res;
            }
            return res;
        }


    }



    private static class DownloadThread extends Thread{

        int numberElement;

        Type2BrandConsumer consumer;

        public DownloadThread(int numberElement, Type2BrandConsumer consumer) {
            this.numberElement = numberElement;
            this.consumer = consumer;
        }

        @Override
        public void run() {
            super.run();
            List<Type2Brand> type2Brands;
            while ((type2Brands=consumer.getType2Brand(numberElement)).size()>0){


                for (Type2Brand type2Brand:type2Brands){


                    List<String> codeSets= null;
                    try {
                        codeSets = downloadListCodeSet(type2Brand.getBrandName(), type2Brand.getTypeName());
                        if (codeSets!=null) {
                            for (String codeSet : codeSets)
                                downloadIrCodeForCodeSet(type2Brand.getBrandName(), type2Brand.getTypeName(), codeSet);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }

            }
        }


        private List<String> downloadListCodeSet(String brand,String type) throws IOException, JSONException {
            System.out.println("Download List Code Set For "+brand+" | "+type);
            CodeSetFinder codeSetFinder=CodeSetFinderFactory.getCodeSetFinder(brand,type);
            if (codeSetFinder==null)
                return null;
            return codeSetFinder.load();
        }


        private List<IrCode> downloadIrCodeForCodeSet(String brand,String type,String codeSet) throws IOException, JSONException, SQLException {


            int type2BrandId=Db.getDb().getType2BrandDao().find(new Type2Brand(type,brand)).get(0).getId();
            Db.getDb().getApp2CodeSetDao().add(new App2CodeSet(codeSet, type2BrandId));
            Db.getDb().getCodeSetDao().add(new CodeSet(codeSet));
            IrCodeFinder irCodeFinder=IrCodeFinderFactory.getFinder(codeSet,type);
            List irCodes=irCodeFinder.load();

            System.out.println("Download Ir Code For "+type2BrandId+" | "+brand+" | "+type+" | "+codeSet+"|"+irCodeFinder.isCodeAc());

            if (irCodeFinder.isCodeAc()){

                List<IrCodeAc> irCodeAc=irCodes;
                com.teca.store.orm.IrCodeAc[] irCodeStore=mapIrCodeAc(irCodeAc);
                Db.getDb().getIrCodeAcDao().add(irCodeStore);
            }
            else{
                List<IrCode> irCodeAv=irCodes;
                com.teca.store.orm.IrCode[] irCodeStore=mapIrCode(irCodeAv);
                Db.getDb().getIrCodeDao().add(irCodeStore);
            }

            return irCodes;
        }


        private com.teca.store.orm.IrCodeAc[] mapIrCodeAc(List<IrCodeAc> irCodes){

            com.teca.store.orm.IrCodeAc[] res=new com.teca.store.orm.IrCodeAc[irCodes.size()];
            for (int i=0;i<irCodes.size();i++){
                IrCodeAc irCodeLoaded=irCodes.get(i);
                res[i]=new com.teca.store.orm.IrCodeAc(irCodeLoaded.getCodeSet(),irCodeLoaded.getFunctionName(),
                        irCodeLoaded.getPower(),irCodeLoaded.getMode(),irCodeLoaded.getTemp(),irCodeLoaded.getFan(),irCodeLoaded.getSwing(),irCodeLoaded.getIrCodes()[0]);
            }

            return res;
        }


        private com.teca.store.orm.IrCode[] mapIrCode(List<IrCode> irCodes){

            com.teca.store.orm.IrCode[] res=new com.teca.store.orm.IrCode[irCodes.size()];
            for (int i=0;i<res.length;i++){
                IrCode loaded=irCodes.get(i);
                res[i]=new com.teca.store.orm.IrCode(loaded.getCodeSet(),loaded.getFunctionName(),
                        loaded.getIrCodes()[0],
                        loaded.getIrCodes()[1],
                        loaded.getIrCodes()[2],
                        loaded.getIrCodes()[3]);

            }

            return res;

        }


    }




}
