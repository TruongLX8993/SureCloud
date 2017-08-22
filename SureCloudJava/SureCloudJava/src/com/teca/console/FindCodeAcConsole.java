package com.teca.console;

import com.teca.usecase.FinCodeAcUseCase;

import java.util.List;
import java.util.Scanner;

/**
 * Created by truonglx.
 */
public class FindCodeAcConsole {



    private static final int ID_EXIT=1;

    private static final int ID_SEARCH=2;




    private FinCodeAcUseCase.FindCodeAcInput  getInput(){

        Scanner scanner=new Scanner(System.in);

        String codeSetName;
        String functionName;
        String power;
        String mode;
        int tem;
        String fan;
        String swing;



        do {
            System.out.println("Enter code set name ");
            codeSetName = scanner.nextLine();
        }while (codeSetName==null);

        System.out.println("Enter code function name");
        functionName=scanner.nextLine();

        System.out.println("Enter power");
        power=scanner.nextLine();

        System.out.println("Enter mode");
        mode=scanner.nextLine();

        System.out.println("Enter temp");
        tem=scanner.nextInt();

        System.out.println("Enter fan");
        fan=scanner.nextLine();

        System.out.println("Enter swing");
        swing=scanner.nextLine();

        return new FinCodeAcUseCase.FindCodeAcInput(codeSetName,functionName,power,mode
        ,tem,fan,swing);


    }


    private void showMenu(){

        System.out.println("Enter 'quit' to come back main menu");
        System.out.println("Enter 'search' to searching");
    }

    private int getChoiceValue(){

        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter cmd: ");
        String cmd=scanner.nextLine();
        if (cmd.equalsIgnoreCase("quit"))
            return ID_EXIT;
        else if (cmd.equalsIgnoreCase("search"))
            return ID_SEARCH;
        return -1;
    }


    public void run(){


        while (true){
            showMenu();
            int choiceValue=getChoiceValue();
            if (choiceValue==ID_EXIT)
                return ;
            else if (choiceValue==ID_SEARCH){

                FinCodeAcUseCase.FindCodeAcInput input=getInput();

            }
            else{
                System.out.println("Don't know cmd");
            }
        }



    }




}
