package com.teca.store.query;

/**
 * Created by truonglx.
 */
class FromBuilder {


    StringBuilder builder = new StringBuilder();

    public FromBuilder addTables(String... tables) {
        for (String table : tables)
            builder.append(table).append(",");
        return this;
    }

    public String build() {
        String res = builder.toString();
        if (res.length() > 0)
            res = res.substring(0, res.length() - 1);
        return res;
    }


}
