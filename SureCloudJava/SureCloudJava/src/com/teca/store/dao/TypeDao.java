package com.teca.store.dao;

import com.teca.store.config.TBType;
import com.teca.store.orm.Type;
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
public class TypeDao extends Dao<Type> {



    public TypeDao(Connection connection) {
        super(connection);
    }

    @Override
    public synchronized void add(Type... objects) throws SQLException {

        String[] cols=new String[]{TBType.NAME};
        String[] val;
        List<String[]> values=new ArrayList<String[]>();
        for (Type type:objects){

            val=new String[]{convertString(type.getTypeName())};
            values.add(val);
        }
        add(TBType.TB_NAME,cols,values);
    }



    @Override
    public List<Type> find(Type sample) throws SQLException {

        List<Type> res=new ArrayList<Type>();

        QueryBuilder builder=new QueryBuilder();
        builder.addTable(TBType.TB_NAME);
        builder.addCondition(TBType.NAME,sample.getTypeName());
        builder.addField("*");

        String sql=builder.build();
        Statement statement=getStatement();
        ResultSet resultSet=statement.executeQuery(sql);

        while (resultSet.next()){

            String name=resultSet.getString(resultSet.findColumn(TBType.NAME));
            res.add(new Type(name));

        }
        return res;
    }
}
