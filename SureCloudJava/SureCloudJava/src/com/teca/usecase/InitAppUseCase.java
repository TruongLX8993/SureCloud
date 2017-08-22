package com.teca.usecase;

import com.teca.store.Db;
import com.teca.store.orm.Brand;
import com.teca.store.orm.Type;
import com.teca.store.orm.Type2Brand;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by truonglx.
 */


public class InitAppUseCase {


    Db db;

    InitHelper helper;


    public InitAppUseCase() {
        try {
            helper = new InitHelper();
            db = Db.getDb();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void reInitApp() throws SQLException {

        copyTypes();
        copyBrand();
        copyType2BrandCodeSet();

    }
    public void initApp() throws SQLException {

        copyTypes();
        copyBrand();
        copyType2BrandCodeSet();
    }

    public boolean isInitApp() {

        return false;
    }


    private void copyType2BrandCodeSet() throws SQLException {

        final int NUMBER=300;

        CacheType2Brand tem;
        helper.queryType2Brand();
        List<Type2Brand> type2Brands=new ArrayList<Type2Brand>();

        while ((tem = helper.getType2Brand()) != null) {
            System.out.println("Copy type to brand "+ tem.toString());
            type2Brands.add(new Type2Brand(tem.getType(),tem.getBrand()));
            if (type2Brands.size()==NUMBER){
                Type2Brand[] aType2Brand=new Type2Brand[NUMBER];
                type2Brands.toArray(aType2Brand);
                db.getType2BrandDao().add(aType2Brand);
                type2Brands=new ArrayList<Type2Brand>();
            }
        }

        if (type2Brands.size()>0){
            Type2Brand[] aType2Brand=new Type2Brand[type2Brands.size()];
            type2Brands.toArray(aType2Brand);
            db.getType2BrandDao().add(aType2Brand);
        }

    }


    private void copyTypes() throws SQLException {

        helper.queryType();
        String type;
        List<Type> types=new ArrayList<Type>();
        while ((type=helper.getType())!=null) {
            System.out.println("Copy type "+type);
            types.add(new Type(type));
        }

        Type[] aTypes=new Type[types.size()];
        types.toArray(aTypes);
        db.getTypeDao().add(aTypes);
    }

    private void copyBrand() throws SQLException{

        helper.queryBrand();
        String brand;
        List<Brand> brands=new ArrayList<Brand>();

        while((brand=helper.getBrand())!=null){
            System.out.println("Copy bran "+brand);
            brands.add(new Brand(brand));
        }
        Brand[] aBrand=new Brand[brands.size()];
        brands.toArray(aBrand);
        db.getBrandDao().add(aBrand);
    }





    private class InitHelper {


        private final String PATH = "SureIrDb.db";


        private Connection connection;

        private ResultSet resultSet;

        private Statement statement;


        public InitHelper() throws SQLException {

            connection = openConnection();
        }


        public void queryBrand() throws SQLException {


            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM TBL_BRANDS");
        }

        public void queryType() throws SQLException {


            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM TBL_TYPES");
        }


        public ResultSet queryType2Brand() throws SQLException {


            String sql = "SELECT * " + "FROM " + "TBL_TYPE2BRAND";
            Statement statement = connection.createStatement();
            return resultSet=statement.executeQuery(sql);
        }

        public String getType() throws SQLException {

            if (resultSet.next())
                return resultSet.getString(1);
            return null;

        }

        public String getBrand() throws SQLException {

            if (resultSet.next())
                return resultSet.getString(1);
            return null;

        }


        public CacheType2Brand getType2Brand() throws SQLException {

            if (!resultSet.next())
                return null;
            String type;
            String brand;
            type = resultSet.getString(resultSet.findColumn("TYPE_NAME"));
            brand = resultSet.getString(resultSet.findColumn("BRAND_NAME"));
            return new CacheType2Brand(type, brand);


        }

        public void close() throws SQLException {
            if (statement != null)
                statement.close();
            connection.close();
        }


        private Connection openConnection() {
            try {
                Class.forName("org.sqlite.JDBC");
                return DriverManager.getConnection("jdbc:sqlite:" + PATH);

            } catch (Exception e) {
                return null;
            }
        }

    }


    private class CacheType2Brand {

        private String type;

        private String brand;


        public CacheType2Brand(String type, String brand) {
            this.type = type;
            this.brand = brand;
        }

        @Override
        public String toString() {

            return type + " | " + brand;

        }

        public String getBrand() {
            return brand;
        }

        public String getType() {
            return type;
        }
    }
}
