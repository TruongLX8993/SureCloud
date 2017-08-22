package com.teca.usecase;

import java.util.List;

/**
 * Created by truonglx.
 */
public class FinCodeAcUseCase {


    public static class FindCodeAcResult{


        private String codeSetName;

        private String functionName;

        private String power;

        private String mode;

        private int temp;

        private String fan;

        private String swing;




        public String getPlanCode(){

            return null;
        }


        public int[] getTimeToken(){

            return null;
        }

        public int[] getCounterToken(){

            return null;
        }







    }
    public static class FindCodeAcInput{

        private String codeSetName;

        private String functionName;

        private String power;

        private String mode;

        private int temp;

        private String fan;

        private String swing;


        public FindCodeAcInput(String codeSetName, String functionName, String power, String mode, int temp, String fan, String swing) {
            this.codeSetName = codeSetName.toUpperCase();
            this.functionName = functionName.toUpperCase();
            this.power = power.toUpperCase();
            this.mode = mode.toUpperCase();
            this.temp = temp;
            this.fan = fan.toUpperCase();
            this.swing = swing.toUpperCase();
        }




        public String getCodeSetName() {
            return codeSetName;
        }

        public String getFunctionName() {
            return functionName;
        }

        public String getPower() {
            return power;
        }

        public String getMode() {
            return mode;
        }

        public int getTemp() {
            return temp;
        }

        public String getFan() {
            return fan;
        }

        public String getSwing() {
            return swing;
        }
    }


    public List<FindCodeAcResult> search(FindCodeAcInput input){

        return null;
    }
}
