package com.co.choucair.sap.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class UserLoombokData {

    String user;
    String pass;
    String server;
    String port;

    public static List<UserLoombokData> setData(DataTable dataTable) {
        List<UserLoombokData> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map, UserLoombokData.class));
        }
        return dates;
    }

}
