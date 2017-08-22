package com.teca.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by truonglx.
 */
public class IrInfo {
    private int frequency;

    private int[] counterPattern;

    public IrInfo(String irCode) {

        Object[] parseResult=parseIrCode(irCode);
        frequency= (Integer) parseResult[0];
        counterPattern=(int[])parseResult[1];
    }



    private static String hex2dec(String irData) {
        List<String> list = new ArrayList<String>(Arrays.asList(irData
                .split(" ")));
        list.remove(0); // dummy
        int frequency = Integer.parseInt(list.remove(0), 16); // frequency
        list.remove(0); // seq1
        list.remove(0); // seq2

        for (int i = 0; i < list.size(); i++) {
            list.set(i, Integer.toString(Integer.parseInt(list.get(i), 16)));
        }

        frequency = (int) (1000000 / (frequency * 0.241246));
        list.add(0, Integer.toString(frequency));

        irData = "";
        for (String s : list) {
            irData += s + ",";
        }
        return irData;
    }



    private Object[] parseIrCode(String in){


        in=hex2dec(in);
        List<String> list = new ArrayList<String>(Arrays.asList(in
                .split(",")));


        int frequency=Integer.parseInt(list.remove(0));
        int[] countPattern=new int[list.size()];
        for (int i=0;i<countPattern.length;i++)
            countPattern[i]=Integer.parseInt(list.get(i));
        return new Object[]{frequency,countPattern};
    }


    public int[] getDurationPattern(){
        int[] durationPattern=new int[counterPattern.length];
        for (int i=0;i<durationPattern.length;i++)
            durationPattern[i]=counterPattern[i]*1000000/frequency;
        return durationPattern;
    }

    public int getFrequency(){
        return frequency;
    }

    public int[] getCounterPattern() {
        return counterPattern;
    }

}
