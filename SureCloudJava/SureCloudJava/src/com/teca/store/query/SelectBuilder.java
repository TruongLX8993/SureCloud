package com.teca.store.query;

/**
 * Created by truonglx.
 */
 class SelectBuilder {

    StringBuilder builder = new StringBuilder();

    public SelectBuilder addFields(String... fields) {
        for (String table : fields)
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
