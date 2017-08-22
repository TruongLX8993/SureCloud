package teca.suredecompile.data;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by truonglxteca .
 */

public class IrFrameManipulator {



    public static String getIRProntoFrequency(String irCode){

        List<String> list;

        list = Arrays.asList(irCode.split(" "));
        return list.get(1);
    }

    public static List<String> getIRProntoCmd(String irCode){

        List<String> list = Arrays.asList(irCode.split("\\|"));
        List<String> res=new ArrayList<>();
        for (int i=0;i<list.size();i++){
            List<String> tem= new ArrayList<>(Arrays.asList(list.get(i).split(" ")));
            if (tem.size()>4){
                tem.remove(0);
                tem.remove(0);
                tem.remove(0);
                tem.remove(0);
            }

            StringBuilder builder=new StringBuilder();
            for (String s:tem)
                builder.append(s).append(" ");
            res.add(builder.toString());
        }
        return res;
    }

    public static List<String> getIrIntegerCmd(String irCode){

        String sub=irCode.substring(irCode.indexOf(",")+1);
        List<String> res=new ArrayList<>();
        res.add(sub);
        return res;
    }






    public static String getIRIntegerFrequency(String irCode){

        return irCode.substring(0,irCode.indexOf(","));
    }


    public static String getIrFrequency(String irCode) throws Exception {

        if (irCode.startsWith("0000 ")||irCode.startsWith("0100 "))
            return getIRProntoFrequency(irCode);
        if (irCode.contains(","))
            return getIRIntegerFrequency(irCode);
        throw new Exception();
    }


    public static List<String> getIrCmd(String irCode) throws Exception {

        if (irCode.contains("0000 ")||irCode.contains("0100 "))
            return getIRProntoCmd(irCode);
        else if (irCode.contains(","))
            return getIrIntegerCmd(irCode);
        throw new Exception();
    }



    public static String replicateIrFrameData(String plainDb, int repeat){

        List<String> terms = new ArrayList<>(Arrays.asList(plainDb.split(" ")));
        IrCodeHeader header = null;
        if (terms.size()>4){

            header=new IrCodeHeader(terms.get(0),terms.get(1),terms.get(2),terms.get(3),repeat);
            terms.remove(0);
            terms.remove(0);
            terms.remove(0);
            terms.remove(0);
        }
        String s1 = appendNewIrData(terms, header.seq1Length).toString().trim();
        String s2 = appendNewIrData(terms,header.seq2Length).toString().trim();



        StringBuilder s1Builder=new StringBuilder(s1);
        StringBuilder s2Builder=new StringBuilder(s2);
        for (int i=0;i<repeat-1;i++){
            if (s1.length()>0)
                s1Builder.append(" ").append(s1);
            if (s2.length()>0)
                s2Builder.append(" ").append(s2);
        }

        StringBuilder resBuilder=new StringBuilder();
        resBuilder.append(header.dummyHex).append(" ")
                    .append(header.freqHex).append(" ")
                    .append(header.seq1LengthHex).append(" ")
                    .append(header.seq2LengthHex);
        if (s1Builder.length()>0)
            resBuilder.append(" ").append(s1Builder);
        if (s2Builder.length()>0)
            resBuilder.append(" ").append(s2Builder);
        return resBuilder.toString().trim();
    }


    private static StringBuilder appendNewIrData(List<String> terms, int seq){

        StringBuilder res=new StringBuilder();
        int i=0;

        while (i!=seq*2){

            res.append(terms.get(0)).append(" ");
            terms.remove(0);
            i++;
        }
        return res;
    }
    private static class IrCodeHeader{


        String dummyHex = "";
        String freqHex = "";
        int seq1Length = 0;
        String seq1LengthHex = "";
        int seq2Length = 0;
        String seq2LengthHex = "";

        IrCodeHeader(String p1, String p2, String p3, String p4, int repeat){

            this.dummyHex=p1;
            this.freqHex=p2;

            Object[] calSeqResult=calSeqLength(p3,repeat);
            this.seq1Length= (int) calSeqResult[0];
            this.seq1LengthHex= (String) calSeqResult[1];

            calSeqResult=calSeqLength(p4,repeat);
            this.seq2Length= (int) calSeqResult[0];
            this.seq2LengthHex= (String) calSeqResult[1];
        }



        private Object[] calSeqLength(String p,int repeat){


            int i=Integer.parseInt(p,16);

            p=Integer.toHexString(i*repeat);
            String seq;
            switch (p.length()){
                case 1:
                    seq = "000"+p;
                    break;
                case 2:
                    seq = "00"+p;
                    break;
                case 3:
                    seq = "0"+p;
                    break;
                default:
                    seq = p;
            }
            return new Object[]{ Integer.valueOf(i),seq};
        }
    }
}
