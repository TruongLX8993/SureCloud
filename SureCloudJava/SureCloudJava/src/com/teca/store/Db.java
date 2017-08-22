package com.teca.store;

import com.teca.store.dao.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * Created by truonglx.
 */
public class Db {



    private static Db db;

    public static Db getDb(){
        if (db==null)
            db=new Db();
        return db;
    }




    private static final String PATH="myDb.db";

    private CodeSetDao codeSetDao;

    private IrCodeAcDao irCodeAcDao;

    private IrCodeDao irCodeDao;

    private TypeDao typeDao;

    private Type2BrandDao type2BrandDao;

    private App2CodeSetDao app2CodeSetDao;

    private FunctionDao functionDao;

    private BrandDao brandDao;








    private Db(){

    }

    public void init(){
        try {
            DbHelper helper=new DbHelper(PATH);
            helper.init();
            initDao(helper.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void recreateDb(){
        try {
            DbHelper helper=new DbHelper(PATH);
            helper.recreateDb();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initDao(Connection connection){

        brandDao=new BrandDao(connection);
        codeSetDao=new CodeSetDao(connection);
        irCodeAcDao=new IrCodeAcDao(connection);
        irCodeDao=new IrCodeDao(connection);
        typeDao=new TypeDao(connection);
        type2BrandDao=new Type2BrandDao(connection);
        app2CodeSetDao=new App2CodeSetDao(connection);
        functionDao=new FunctionDao(connection);

    }


    public CodeSetDao getCodeSetDao(){
        return codeSetDao;
    }


    public IrCodeAcDao getIrCodeAcDao() {
        return irCodeAcDao;
    }

    public IrCodeDao getIrCodeDao() {
        return irCodeDao;
    }

    public TypeDao getTypeDao() {
        return typeDao;
    }

    public Type2BrandDao getType2BrandDao() {
        return type2BrandDao;
    }

    public App2CodeSetDao getApp2CodeSetDao() {
        return app2CodeSetDao;
    }

    public FunctionDao getFunctionDao() {
        return functionDao;
    }

    public BrandDao getBrandDao() {
        return brandDao;
    }


}
