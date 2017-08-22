package com.teca.test.loader;

import com.teca.loader.codeset.*;
import com.teca.loader.IrCodeFinderFactory;
import com.teca.loader.ircode.IrCodeAvFinder;
import com.teca.loader.ircode.IrCodeFinder;
import com.teca.loader.orm.IrCode;
import com.teca.loader.orm.IrCodeAc;
import org.json.JSONException;

import java.io.IOException;
import java.util.List;

/**
 * Created by truonglx.
 */
public class TestLoader {


    // ok.
//    private static List<String> searchCodeSet(String type,String brand) throws IOException, JSONException {
//
//        AcCodeSetFinder codeSetFinder=new AcCodeSetFinder(brand,type);
//        return codeSetFinder.load();
//    }
//
//    private static List<String> searchCodeSetAv(String type,String brand) throws IOException, JSONException {
//
//        TvCodeSetFinder avCodeSetFinder=new TvCodeSetFinder(brand);
//        return avCodeSetFinder.load();
//    }
//
//    private static List<IrCodeAc> searchCodeAc(String codeSetName) throws IOException, JSONException {
//
//        IrCodeFinder<IrCodeAc> finder= IrCodeFinderFactory.getIrCodeAcFinder("Re_GLOBAL_463");
//        return finder.load();
//    }
//
//    private static List<IrCode> searchCode(String codeSetName) throws IOException, JSONException {
//
//        IrCodeFinder<IrCode> finder= IrCodeFinderFactory.getIrCodeFinder(codeSetName);
//        return finder.load();
//    }



    public static void main(String[] args) throws IOException, JSONException {

//        System.out.println(searchCodeSet("Air Conditioner", "Samsung").size());
//        searchCodeAc("Re_GLOBAL_463");
//        searchCode("Re_GLOBAL_171");
//        System.out.println(searchCodeSetAv("TV","Samsung").size());
//        System.out.println(new AvReceiverCodeSetFinder("LG").load().size());
//        System.out.println(new MediaStreamCodeSetFinder("Roku").load());
//        System.out.println(new DiscPlayerCodeSetFinder("Samsung").load().size());
//        System.out.println(new ProjectorCodeSetFinder("Acer").load().size());
//        System.out.println(new TvCodeSetFinder("LG").load().size());
//        System.out.println(searchCode("1R_US_1319_TOGGLE").size());
        System.out.println(new IrCodeAvFinder("Re_US_2771").load().size());
    }
}
