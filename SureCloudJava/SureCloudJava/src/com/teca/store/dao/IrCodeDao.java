package com.teca.store.dao;

import com.teca.store.config.TBIrCode;
import com.teca.store.orm.IrCode;
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
public class IrCodeDao extends Dao<IrCode> {


    public IrCodeDao(Connection connection) {
        super(connection);
    }

    @Override
    public synchronized void add(IrCode... objects) throws SQLException {

        String[] cols = new String[]{
                TBIrCode.CODE_SET,
                TBIrCode.FUNCTION_NAME,
                TBIrCode.IR1,
                TBIrCode.IR2,
                TBIrCode.IR3,
                TBIrCode.IR4,
        };

        List<String[]> values=new ArrayList<String[]>();
        for (IrCode irCode : objects) {

            String[] val = new String[]{
                    convertString(irCode.getCodeSetName()),
                    convertString(irCode.getFunctionName()),
                    convertString(irCode.getIr1()),
                    convertString(irCode.getIr2()),
                    convertString(irCode.getIr3()),
                    convertString(irCode.getIr4())
            };
            values.add(val);
        }
        add(TBIrCode.TB_NAME, cols, values);
    }


    @Override
    public List<IrCode> find(IrCode sample) throws SQLException {

        List<IrCode> res = new ArrayList<IrCode>();
        QueryBuilder queryBuilder = new QueryBuilder();

        queryBuilder.addField("*");

        queryBuilder.addTable(TBIrCode.TB_NAME);

        queryBuilder.addCondition(TBIrCode.CODE_SET, sample.getCodeSetName());
        queryBuilder.addCondition(TBIrCode.FUNCTION_NAME,sample.getFunctionName());
        queryBuilder.addCondition(TBIrCode.IR1, sample.getIr1());
        queryBuilder.addCondition(TBIrCode.IR2, sample.getIr2());
        queryBuilder.addCondition(TBIrCode.IR3, sample.getIr3());
        queryBuilder.addCondition(TBIrCode.IR4, sample.getIr4());

        String sql = queryBuilder.build();

        Statement statement = getStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {

            String codeSetName;
            String functionName;
            String ir1, ir2, ir3, ir4;

            codeSetName = resultSet.getString(resultSet.findColumn(TBIrCode.CODE_SET));
            functionName = resultSet.getString(resultSet.findColumn(TBIrCode.FUNCTION_NAME));
            ir1 = resultSet.getString(resultSet.findColumn(TBIrCode.IR1));
            ir2 = resultSet.getString(resultSet.findColumn(TBIrCode.IR2));
            ir3 = resultSet.getString(resultSet.findColumn(TBIrCode.IR3));
            ir4 = resultSet.getString(resultSet.findColumn(TBIrCode.IR4));
            res.add(new IrCode(codeSetName, functionName, ir1, ir2, ir3, ir4));
        }

        return res;
    }


}
