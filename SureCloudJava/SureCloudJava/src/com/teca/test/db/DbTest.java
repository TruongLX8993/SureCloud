package com.teca.test.db;

import com.teca.store.Db;
import com.teca.store.dao.*;
import com.teca.store.orm.*;

import java.sql.SQLException;

/**
 * Created by truonglx.
 */
public class DbTest {


    // @1 ok
    private static void testBrandDao(BrandDao brandDao) throws SQLException {
        Brand brand=new Brand("Daikin");
        brandDao.add(brand);
        brandDao.find(brand);
    }

    // @2 ok
    private static void testFunctionDao(FunctionDao functionDao) throws SQLException{

        Function function=new Function("Volume Up");
        functionDao.add(function);
        functionDao.find(function);
    }

    // @3 ok
    private static void testCodeSetDao(CodeSetDao codeSetDao) throws SQLException{

        CodeSet codeSet=new CodeSet("qwerty");
        codeSetDao.add(codeSet);
        codeSetDao.find(codeSet);
    }


    // @4 ok
    private static void testTypeDao(TypeDao typeDao) throws SQLException{

        Type type=new Type("Air Condition");
        typeDao.add(type);
        typeDao.find(type);

    }

    // @5 test: ok
    private static void testType2BrandDao(Type2BrandDao dao) throws SQLException{

//        Type2Brand type2Brand=new Type2Brand("Air Conditioner","Daikin");
//        dao.add(type2Brand,type2Brand);
//        dao.find(new Type2Brand("Air Conditioner",null));
    }


    // @6 test: ok
    private static void testApp2CodeSetDao(App2CodeSetDao app2CodeSetDao) throws SQLException{

        App2CodeSet app2CodeSet=new App2CodeSet("qwert",1);
//        app2CodeSetDao.add(app2CodeSet);
        App2CodeSet sample=new App2CodeSet("qwert",-1);
        app2CodeSetDao.find(sample);
    }

   // @7 test:ok
    private static void testIrCode(IrCodeDao irCodeDao) throws SQLException {

        IrCode irCode=new IrCode("qwert","Volume Up","1","2","3","4");
        //irCodeDao.add(irCode);
        irCodeDao.find(new IrCode("qwert",null,null,null,null,null));
    }

    private static void testIrCodeAc(IrCodeAcDao dao) throws  SQLException{

        IrCodeAc irCodeAc=new IrCodeAc("qwert","Volume Up","On","COOL",25,"Medium","ON","12345");
//        dao.add(irCodeAc);
        dao.find(new IrCodeAc(null,"Volume Up",null,null,-1,null,null,null));
    }

    public static void main(String[] args) throws SQLException {
        Db db=Db.getDb();
//        testBrandDao(db.getBrandDao());
//        testFunctionDao(db.getFunctionDao());
//        testCodeSetDao(db.getCodeSetDao());
//        testTypeDao(db.getTypeDao());
//        testType2BrandDao(db.getType2BrandDao());
//        testApp2CodeSetDao(db.getApp2CodeSetDao());
//        testIrCode(db.getIrCodeDao());
        testIrCodeAc(db.getIrCodeAcDao());
    }



}
