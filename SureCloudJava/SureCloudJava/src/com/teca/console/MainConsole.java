package com.teca.console;

import java.util.Scanner;

/**
 * Created by truonglx.
 */
public class MainConsole {


    private static final int EXIT=1;

    private static final int FIND_CODE_SET=2;

    private static final int FIND_IR_CODE_AC=3;

    private static final int FIND_IR_CODE_AV=4;



    private void showMainMenu(){

        System.out.println("---------------------------------------------Main menu-------------------------------------------------");
        System.out.println("Press: 'quit' to exit");
        System.out.println("Press: 'fCodeSet' to find code set");
        System.out.println("Press: 'fIrAc' to find Ir Ac  ");
        System.out.println("Press: 'fIrAv' to find Ir Av  ");

    }


    private int getChoiceValue(){

        String cmd;

        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter command: ");
        cmd=scanner.nextLine();

        if (cmd.equalsIgnoreCase("fIrAc"))
            return FIND_IR_CODE_AC;
        else if (cmd.equalsIgnoreCase("fIrAv"))
            return FIND_IR_CODE_AV;
        else if (cmd.equalsIgnoreCase("fCodeSet"))
            return FIND_CODE_SET;
        else if (cmd.equalsIgnoreCase("quit"))
            return EXIT;

        return -1;
    }






    public void backConsole(){

    }


    public static void main(String[] args) {
        MainConsole mainConsole=new MainConsole();
        while (true) {

            mainConsole.showMainMenu();
            int choiceValue=mainConsole.getChoiceValue();
            if (choiceValue==EXIT)
                return;

        }
    }
}
