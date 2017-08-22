package com.teca.store.dao;


import com.teca.store.config.TBCodeSet;
import com.teca.store.orm.CodeSet;
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
public class CodeSetDao extends Dao<CodeSet>{


    public CodeSetDao(Connection connection) {
        super(connection);
    }

    public Object locked=new Object();

    @Override
    public  void add(CodeSet... objects) throws SQLException {

        String[] cols = new String[]{TBCodeSet.NAME};
        List<String[]> values = new ArrayList<String[]>();
        for (CodeSet codeSet : objects) {

            String[] val = new String[]{convertString(codeSet.getCodeSetName())};
            values.add(val);
        }
        add(TBCodeSet.TB_NAME, cols, values);
    }

    @Override
    public List<CodeSet> find(CodeSet sample) throws SQLException {

        List<CodeSet> res = new ArrayList<CodeSet>();
        QueryBuilder builder = new QueryBuilder();
        builder.addTable(TBCodeSet.TB_NAME);
        builder.addField("*");
        builder.addCondition(TBCodeSet.NAME, sample.getCodeSetName());
        String sql = builder.build();
        Statement statement = getStatement();
        ResultSet resultSet;
        synchronized (locked) {
            resultSet = statement.executeQuery(sql);
        }
        while (resultSet.next())
            res.add(new CodeSet(resultSet.getString(1)));

        return res;
    }



}
