package com.pirates.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ResponseRest {
    private final List<HashMap<String, String>> metaData = new ArrayList<>();

    public List<HashMap<String, String>> getMetaData() {
        return metaData;
    }

    public void setMetaData(String type, String code) {
        HashMap <String, String> mapa = new HashMap<>();

        mapa.put("Type", type);
        mapa.put("Code", code);

        metaData.add(mapa);
    }    
}
