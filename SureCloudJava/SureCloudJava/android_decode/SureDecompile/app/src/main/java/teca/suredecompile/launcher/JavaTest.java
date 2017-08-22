package teca.suredecompile.launcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by truonglxteca .
 */

public class JavaTest {



    public static void main(String[] args) {
        String s="Con kec";
        List<String> stringList=new ArrayList<>(Arrays.asList(s));

        for (String tem:stringList)
            System.out.println(tem);
    }
}
