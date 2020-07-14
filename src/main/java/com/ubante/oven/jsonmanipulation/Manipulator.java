package com.ubante.oven.jsonmanipulation;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

/**
 * From www.mkyong.com.
 */
public class Manipulator {


    public static void main(String[] args) {
//        String beforeString = "{"Row":[{"key":"cjpvcmcjd2lraXBlZGlhI2VuIS93aWtpL0tyeW9nZW5pZmV4IWh0dHA=","Cell":[{"column":"bWV0YWRhdGE6cGFnZXJhbms=","timestamp":1400091685784,"$":"AQAAAfw="}]}]}"
        JSONObject obj = new JSONObject();
        obj.put("name", "mkyong.com");
        obj.put("age", 100);

        JSONArray list = new JSONArray();
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");

        obj.put("messages", list);

        try {
            FileWriter file = new FileWriter("/home/ubante/tmp/mkyong.out");
            file.write(obj.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(obj);

    }
}
