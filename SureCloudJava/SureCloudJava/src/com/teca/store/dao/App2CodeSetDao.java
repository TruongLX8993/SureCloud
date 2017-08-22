package com.teca.store.dao;

import com.teca.store.config.TBApp2CodeSet;
import com.teca.store.orm.App2CodeSet;
import com.teca.store.query.QueryBuilder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by truonglx.
 */



public class App2CodeSetDao extends Dao<App2CodeSet>{


    public App2CodeSetDao(Connection connection) {
        super(connection);
    }

    @Override
    public synchronized void add(App2CodeSet... objects) throws SQLException {

        String[] cols=new String[]{
                TBApp2CodeSet.TYPE_2_BRAND_ID,
                TBApp2CodeSet.CODE_SET_NAME,
        };

        List<String[]> values=new ArrayList<String[]>();
        for (App2CodeSet app:objects){


            String[] val=new String[]{
                    String.valueOf(app.getType2BrandId()),
                    convertString(app.getCodeSetName()),
            };
            values.add(val);
        }
        add(TBApp2CodeSet.TB_NAME,cols,values);
    }

    @Override
    public List<App2CodeSet> find(App2CodeSet sample) throws SQLException {

        QueryBuilder builder=new QueryBuilder();
        List<App2CodeSet> res=new ArrayList<App2CodeSet>();
        builder.addTable(TBApp2CodeSet.TB_NAME);
        builder.addField("*");
        String sql;
        if (sample.getId()>0)
            sql=builder.addCondition(TBApp2CodeSet.ID,String.valueOf(sample.getId())).build();
        else
            sql=builder.addCondition(TBApp2CodeSet.CODE_SET_NAME,sample.getCodeSetName()).build();
        Statement statement=getStatement();
        ResultSet resultSet=statement.executeQuery(sql);
        while (resultSet.next()) {

            int id=resultSet.getInt(resultSet.findColumn(TBApp2CodeSet.ID));
            int type2BradId=resultSet.getInt(resultSet.findColumn(TBApp2CodeSet.TYPE_2_BRAND_ID));
            String codeSetName=resultSet.getString(resultSet.findColumn(TBApp2CodeSet.CODE_SET_NAME));
            res.add(new App2CodeSet(id,type2BradId,codeSetName));
        }
        return res;
    }


}
