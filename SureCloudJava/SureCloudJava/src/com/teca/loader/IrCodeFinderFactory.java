package com.teca.loader;

import com.teca.loader.ircode.IrCodeAcFinder;
import com.teca.loader.ircode.IrCodeAvFinder;
import com.teca.loader.ircode.IrCodeFinder;

/**
 * Created by truonglx.
 */
public class IrCodeFinderFactory {

    public static IrCodeFinder getFinder(String codeSet,String type){

        if (type.equals("Air Conditioner"))
            return new IrCodeAcFinder(codeSet);
        else
            return new IrCodeAvFinder(codeSet);
    }

}
