package com.teca.test.db;

import com.teca.usecase.InitAppUseCase;

import java.sql.SQLException;

/**
 * Created by truonglx.
 */
public class InitAppUseCaseTest {
    public static void main(String[] args) {
        InitAppUseCase useCase;
        useCase = new InitAppUseCase();
        try {
            useCase.initApp();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
