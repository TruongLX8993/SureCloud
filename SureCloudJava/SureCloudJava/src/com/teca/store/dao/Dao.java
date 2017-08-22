package com.teca.store.dao;

import com.teca.store.Utils;

import java.sql.*;
import java.util.List;

/**
 * Created by truonglx.
 */
public  abstract class Dao<T extends Object> {


    private Connection connection;

    public Dao(Connection connection) {
        this.connection = connection;
    }

    public abstract void add(T... objects) throws SQLException;

    public final boolean isExist(T sample) throws SQLException{
        return find(sample).size()>0;
    }

    public abstract List<T> find(T sample) throws SQLException;


    protected void add(String tableName,String[] cols,List<String[]> values) throws SQLException {

        String tem1="";
        String tem2="";

        for (int i=0;i<cols.length;i++){
            tem1 += cols[i];
            if (i<(cols.length-1))
                tem1+=",";
        }

        for (int i=0;i<values.size();i++) {
            String[] val=values.get(i);
            String s="(";
            for (int j = 0; j < val.length; j++) {
                s += val[j];
                if (j < (val.length - 1))
                    s += ",";
            }
            s+=")";

            if (i<values.size()-1)
                tem2+=s+",";
            else
                tem2+=s;
        }


        String sql="insert into "+tableName+"("+tem1+") "+"values "+tem2+";";
        Statement statement = connection.createStatement();
        try {
            statement.execute(sql);
        }catch (SQLException ex){
            statement.close();
            throw new SQLException();
        }
        statement.close();
    }

    protected int addAndGetId(String tableName,String[] cols,String[] val) throws SQLException {

        int id;

        String tem1="";
        String tem2="";

        for (int i=0;i<cols.length;i++){
            tem1 += cols[i];
            if (i<(cols.length-1))
                tem1+=",";
        }

        for (int i=0;i<val.length;i++){
            tem2 += val[i];
            if (i<(val.length-1))
                tem2+=",";
        }


        String sql="insert into "+tableName+"("+tem1+") "+"values "+tem2+"";
        Statement statement = connection.createStatement();
        statement.execute(sql);
        id=statement.getGeneratedKeys().getInt(1);
        statement.close();
        return id;
    }




    protected final Statement getStatement() throws SQLException {
        return connection.createStatement();
    }

    protected String convertString(String in){
        return Utils.convertString(in);
    }




}
