package com.teca.test.usecase;

import com.teca.usecase.InitAppUseCase;

import java.sql.SQLException;

/**
 * Created by truonglx.
 */
public class TestInitAppUseCase {

    public static void main(String[] args) throws SQLException {
        InitAppUseCase useCase=new InitAppUseCase();
        useCase.initApp();
    }
}
