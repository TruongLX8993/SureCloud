package com.teca.store.dao;

import com.teca.store.config.TBFunction;
import com.teca.store.orm.Function;
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
public class FunctionDao extends Dao<Function> {


    public FunctionDao(Connection connection) {
        super(connection);
    }

    @Override
    public synchronized void  add(Function... objects) throws SQLException {

        String[] cols=new String[]{TBFunction.NAME};
        List<String[]> values=new ArrayList<String[]>();

        for (Function function:objects){

            String[] val=new String[]{convertString(function.getName())};
            values.add(val);
        }
        add(TBFunction.TB_NAME,cols,values);
    }

    @Override
    public List<Function> find(Function sample) throws SQLException {

        List<Function> res=new ArrayList<Function>();
        QueryBuilder builder=new QueryBuilder();
        builder.addTable(TBFunction.TB_NAME);
        builder.addField("*");
        builder.addCondition(TBFunction.NAME,sample.getName());

        String sql=builder.build();
        Statement statement=getStatement();
        ResultSet resultSet=statement.executeQuery(sql);
        while (resultSet.next())
            res.add(new Function(resultSet.getString(1)));
        statement.close();
        return res;
    }
}
