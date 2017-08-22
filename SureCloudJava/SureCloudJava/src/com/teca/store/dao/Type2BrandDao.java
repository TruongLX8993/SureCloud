package com.teca.store.dao;

import com.teca.store.config.TBType2Brand;
import com.teca.store.orm.Type2Brand;
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
public class Type2BrandDao extends Dao<Type2Brand> {

    public Type2BrandDao(Connection connection) {
        super(connection);
    }

    @Override
    public synchronized void add(Type2Brand... objects) throws SQLException {

        String[] cols=new String[]{TBType2Brand.TYPE,TBType2Brand.BRAND};
        List<String[]> values=new ArrayList<String[]>();
        for (Type2Brand type2Brand:objects){

            String[] val=new String[]{convertString(type2Brand.getTypeName()),convertString(type2Brand.getBrandName())};
            values.add(val);

        }
        add(TBType2Brand.TB_NAME,cols,values);
    }


    @Override
    public List<Type2Brand> find(Type2Brand sample) {

        List<Type2Brand> res=new ArrayList<Type2Brand>();
        try {
            Statement statement=getStatement();
            QueryBuilder builder=new QueryBuilder();

            builder.addTable(TBType2Brand.TB_NAME);

            builder.addField("*");

            builder.addCondition(TBType2Brand.TYPE,sample.getTypeName());
            builder.addCondition(TBType2Brand.BRAND,sample.getBrandName());


            String sql=builder.build();
            ResultSet resultSet=statement.executeQuery(sql);

            while(resultSet.next()){

                String type=resultSet.getString(resultSet.findColumn(TBType2Brand.TYPE));

                int id=resultSet.getInt(resultSet.findColumn(TBType2Brand.ID));

                String brand=resultSet.getString(resultSet.findColumn(TBType2Brand.BRAND));

                res.add(new Type2Brand(type,brand,id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }


}
