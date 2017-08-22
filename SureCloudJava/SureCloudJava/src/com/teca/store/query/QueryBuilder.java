package com.teca.store.query;

import com.teca.store.Utils;

/**
 * Created by truonglx.
 */
public class QueryBuilder {


    FromBuilder fromBuilder;

    SelectBuilder selectBuilder;

    WhereBuilder whereBuilder;

    public QueryBuilder() {
        fromBuilder = new FromBuilder();
        selectBuilder = new SelectBuilder();
        whereBuilder = new WhereBuilder();
    }

    public QueryBuilder addTable(String... tables) {

        fromBuilder.addTables(tables);
        return this;
    }

    public QueryBuilder addField(String... fields) {

        selectBuilder.addFields(fields);
        return this;
    }

    public QueryBuilder addCondition(String fieldName, String value, boolean noConvert) {

        String condition;
        if (!noConvert)
            condition = fieldName + "=" + Utils.convertString(value);
        else
            condition = fieldName + "=" + value;

        whereBuilder.addCondition(condition);
        return this;
    }

    public QueryBuilder addCondition(String fieldName, String value) {

        if (value!=null)
            whereBuilder.addCondition(fieldName + "=" + Utils.convertString(value));
        return this;
    }

    public String build() {
        if (whereBuilder.build().length()>0)
            return "select " + selectBuilder.build() + " from " + fromBuilder.build() + " where " + whereBuilder.build();
        else
            return "select " + selectBuilder.build() + " from " + fromBuilder.build();
    }

}
