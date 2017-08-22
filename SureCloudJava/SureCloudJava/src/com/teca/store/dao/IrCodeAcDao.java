package com.teca.store.dao;


import com.teca.store.config.TBIrCodeAc;
import com.teca.store.orm.IrCodeAc;
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
public class IrCodeAcDao extends Dao<IrCodeAc> {


    public IrCodeAcDao(Connection connection) {
        super(connection);
    }

    @Override
    public synchronized void add(IrCodeAc... objects) throws SQLException {


        String[] cols = new String[]{
                TBIrCodeAc.CODE_SET,
                TBIrCodeAc.FUNCTION_NAME,
                TBIrCodeAc.POWER,
                TBIrCodeAc.MODE,
                TBIrCodeAc.TEMP,
                TBIrCodeAc.FAN,
                TBIrCodeAc.SWING,
                TBIrCodeAc.IR_CODE,

        };

        List<String[]> values = new ArrayList<String[]>();
        for (IrCodeAc codeAc : objects) {

            String[] val = new String[]{
                    convertString(codeAc.getCodeSetName()),
                    convertString(codeAc.getFunctionName()),
                    convertString(codeAc.getPower()),
                    convertString(codeAc.getMode()),
                    String.valueOf(codeAc.getTemp()),
                    convertString(codeAc.getFan()),
                    convertString(codeAc.getSwing()),
                    convertString(codeAc.getIr())
            };

            values.add(val);
        }
        add(TBIrCodeAc.TB_NAME, cols, values);
    }


    @Override
    public List<IrCodeAc> find(IrCodeAc sample) throws SQLException {

        List<IrCodeAc> res = new ArrayList<IrCodeAc>();
        QueryBuilder builder = new QueryBuilder();


        builder.addField("*");
        builder.addTable(TBIrCodeAc.TB_NAME);
        builder.addCondition(TBIrCodeAc.CODE_SET, sample.getCodeSetName());
        builder.addCondition(TBIrCodeAc.FUNCTION_NAME, sample.getFunctionName());
        builder.addCondition(TBIrCodeAc.POWER, sample.getPower());
        builder.addCondition(TBIrCodeAc.MODE, sample.getMode());
        if (sample.getTemp() > 10)
            builder.addCondition(TBIrCodeAc.TEMP, String.valueOf(sample.getTemp()), true);
        builder.addCondition(TBIrCodeAc.FAN, sample.getFan());
        builder.addCondition(TBIrCodeAc.SWING, sample.getSwing());
        builder.addCondition(TBIrCodeAc.IR_CODE, sample.getIr());


        String sql = builder.build();
        Statement statement = getStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {


            String codeSet;
            String functionName;
            String power;
            String mode;
            int temp;
            String fan;
            String swing;
            String ir1;

            codeSet = resultSet.getString(1);
            functionName = resultSet.getString(2);
            power = resultSet.getString(3);
            mode = resultSet.getString(4);
            temp = resultSet.getInt(5);
            fan = resultSet.getString(6);
            swing = resultSet.getString(7);
            ir1 = resultSet.getString(8);

            res.add(new IrCodeAc(codeSet, functionName, power, mode, temp, fan, swing, ir1));
        }
        return res;
    }
}
