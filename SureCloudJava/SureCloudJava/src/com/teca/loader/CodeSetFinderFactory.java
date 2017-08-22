package com.teca.loader;

import com.teca.loader.codeset.*;

/**
 * Created by truonglx.
 */
public class CodeSetFinderFactory {

//    public static final Code

    public static final CodeSetFinder getCodeSetFinder(String brand,String type) {

        if (type.equals("Air Conditioner"))
            return new AcCodeSetFinder(brand);
        else if (type.equals("AV Receiver"))
            return new AvReceiverCodeSetFinder(brand);
        else if (type.equals("Disc Player"))
            return new DiscPlayerCodeSetFinder(brand);
//        else if (type.equals("Media Streamer"))
//            return new DiscPlayerCodeSetFinder(brand);
        else if (type.equals("Projector"))
            return new ProjectorCodeSetFinder(brand);
        else if (type.equals("TV"))
            return new TvCodeSetFinder(brand);
        return null;
    }
}
