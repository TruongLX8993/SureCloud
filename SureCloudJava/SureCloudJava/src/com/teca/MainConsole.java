package com.teca;


import com.teca.store.Db;
import com.teca.usecase.DownloadDbUseCase;
import com.teca.usecase.InitAppUseCase;
import org.json.JSONException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by truonglx.
 */
public class MainConsole {






    public static void main(String[] args) throws SQLException, IOException, JSONException {
        System.out.println("Khoi tao lai Db");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (line.equals("yes")) {
            Db db= Db.getDb();
            db.recreateDb();
            db.init();
            InitAppUseCase initAppUseCase = new InitAppUseCase();
            initAppUseCase.initApp();
            System.out.println("Recreated db");
        }
        else{
            Db db= Db.getDb();
            db.init();
        }
        new DownloadDbUseCase().download();
    }
}
