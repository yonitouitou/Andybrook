package com.andybrook.api.rest.ctx;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GenericRequestByIds {

    private String[] ids;

    public List<Long> getIdsAsLong() {
        List<Long> list = new LinkedList<>();
        for (int i = 0; i < ids.length; i++) {
            list.add(Long.valueOf(ids[i]));
        }
        return list;
    }

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GenericRequestByIds{");
        sb.append("ids=").append(Arrays.toString(ids));
        sb.append('}');
        return sb.toString();
    }
}
