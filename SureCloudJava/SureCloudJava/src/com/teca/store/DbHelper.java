package com.teca.store;

import com.teca.store.config.*;

import java.io.File;
import java.io.IOException;
import java.sql.*;

/**
 * Created by truonglx.
 */
public class DbHelper {



    private String path;

    private Connection connection;


    public DbHelper(String path) throws SQLException, IOException {
        this.path = path;

    }


    public void init() throws IOException, SQLException {
        if (!isExitsDb())
            connection=recreateDb();
        else
            connection=openConnection();
    }
    public Connection recreateDb() throws SQLException, IOException {

        boolean res=false;
        File file=new File(path);
        if (file.exists())
            res=file.delete();
        createFileDb();
        connection=openConnection();
        createDb();
        return connection;
    }


    public Connection createDb() throws SQLException {


        createTbType(connection);
        createTbBrand(connection);
        createTbFunction(connection);
        createTbType2Brand(connection);
        createTbCodeSet(connection);
        createTbAppToCodeSet(connection);
        createTbIrCodeAc(connection);
        createTbIrCode(connection);
        return connection;
    }


    public Connection getConnection() {
        return connection;
    }

    private boolean isExitsDb(){
        return new File(path).exists();
    }


    private void createFileDb() throws IOException {
        File file=new File(path);
        file.createNewFile();
    }



    private Connection openConnection(){
        Connection c = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:"+path);
            return c;
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        return null;
    }



    private void createTbFunction(Connection connection) throws SQLException {

        String sql="create table "+TBFunction.TB_NAME+"(" +
                    TBFunction.NAME+" text primary key not null)";
        exe(connection,sql);
    }



    private void createTbType(Connection connection) throws SQLException {

        String sql="create table "+ TBType.TB_NAME+"("+
                TBType.NAME+" text primary key not null)";
        exe(connection, sql);
    }

    private void createTbBrand(Connection connection) throws SQLException {

        String sql="create table "+ TBBrand.TB_NAME+"("+
                TBBrand.BRAND_NAME+" text primary key not null)";
       exe(connection,sql);
    }

    private void createTbType2Brand(Connection connection) throws SQLException {

        String sql="create table "+ TBType2Brand.TB_NAME+"("
                +TBType2Brand.ID+" integer primary key autoincrement not null ,"
                +TBType2Brand.TYPE+" text not null,"
                +TBType2Brand.BRAND+" text not null)";
        exe(connection,sql);

    }


    private void createTbAppToCodeSet(Connection connection) throws SQLException {

        String sql="create table "+ TBApp2CodeSet.TB_NAME+"("
                +TBApp2CodeSet.ID+" integer primary key autoincrement not null,"
                +TBApp2CodeSet.TYPE_2_BRAND_ID+ " integral not null,"
                +TBApp2CodeSet.CODE_SET_NAME+ " text not null)";
        exe(connection,sql);
    }

    private void createTbIrCodeAc(Connection connection) throws SQLException {

        String sql="create table "+ TBIrCodeAc.TB_NAME+"("
                +TBIrCodeAc.CODE_SET+ " text not null,"
                +TBIrCodeAc.FUNCTION_NAME+" text not null,"
                +TBIrCodeAc.POWER+" text not null,"
                +TBIrCodeAc.MODE+" text not null,"
                +TBIrCodeAc.TEMP+" integral not null,"
                +TBIrCodeAc.FAN+" text not null,"
                +TBIrCodeAc.SWING+" text not null,"
                +TBIrCodeAc.IR_CODE+" text not null)";
        exe(connection,sql);
    }

    private void createTbIrCode(Connection connection) throws SQLException {

        String sql="create table "+TBIrCode.TB_NAME+"("
                +TBIrCode.CODE_SET+" text not null,"
                +TBIrCode.FUNCTION_NAME+" text not null,"
                +TBIrCode.IR1+" text, "
                +TBIrCode.IR2+" text,"
                +TBIrCode.IR3+" text,"
                +TBIrCode.IR4+" text)";
        exe(connection,sql);
    }

    private void createTbCodeSet(Connection connection) throws SQLException {

        String sql="create table "+TBCodeSet.TB_NAME+"("
                +TBCodeSet.NAME+" text primary key not null)";
        exe(connection,sql);
    }


    private void exe(Connection connection,String sql) throws SQLException {
        Statement statement=connection.createStatement();
        System.out.println(sql);
        statement.execute(sql);
        statement.close();

    }





}
