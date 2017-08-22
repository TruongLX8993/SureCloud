package com.teca.store.query;

/**
 * Created by truonglx.
 */
 class WhereBuilder {

    StringBuilder builder = new StringBuilder();

    public WhereBuilder addCondition(String... conditions) {
        for (String condition : conditions)
            if (condition != null)
                builder.append(condition).append(" and ");
        return this;
    }

    public String build() {
        String res = builder.toString();
        if (res.length() > 0)
            res = res.substring(0, res.length() - 5);
        return res;
    }
}
