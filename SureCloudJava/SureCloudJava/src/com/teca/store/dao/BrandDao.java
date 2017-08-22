package com.teca.store.dao;

import com.teca.store.Utils;
import com.teca.store.config.TBBrand;
import com.teca.store.orm.Brand;
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
public class BrandDao extends Dao<Brand> {



    public BrandDao(Connection connection) {
        super(connection);
    }

    @Override
    public synchronized void add(Brand... objects) throws SQLException {

        String[] cols=new String[]{TBBrand.BRAND_NAME};

        List<String[]> values=new ArrayList<String[]>();
        for (Brand brand:objects){
            String[] val=new String[]{Utils.convertString(brand.getBrandName())};
            values.add(val);
        }
        add(TBBrand.TB_NAME,cols,values);
    }


    @Override
        public List<Brand> find(Brand sample) throws SQLException {

        List<Brand> res=new ArrayList<Brand>();

        QueryBuilder builder=new QueryBuilder();
        builder.addTable(TBBrand.TB_NAME);
        builder.addCondition(TBBrand.BRAND_NAME,sample.getBrandName());
        builder.addField("*");
        String sql=builder.build();
        Statement statement=getStatement();
        ResultSet resultSet=statement.executeQuery(sql);
        while (resultSet.next())
            res.add(new Brand(resultSet.getString(1)));
        return res;
    }
}
