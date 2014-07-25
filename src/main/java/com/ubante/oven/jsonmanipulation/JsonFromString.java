package com.ubante.oven.jsonmanipulation;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * ubante 5/27/14 3:29 PM
 * This is very serious business.
 */
public class JsonFromString {
    static void prettify(JSONObject o) {


    }

    public static void main(String[] args) {
        String aString = "{\"Row\":[{\"key\":\"cjpvcmcjd2lraXBlZGlhI2VuIS93aWtpL0tyeW9nZW5pZmV4IWh0dHA=\"," +
                "\"Cell\":[{\"column\":\"bWV0YWRhdGE6cGFnZXJhbms=\",\"timestamp\":1400091685784,\"$\":\"AQAAAfw=\"}]}]}";
        System.out.println("Using this as the test json string:");
        System.out.println(aString);

        JSONParser parser = new JSONParser();
        Object obj = null;
        try {
            obj = parser.parse(aString);
        } catch (ParseException e) {
            // Maybe we exit here?
            e.printStackTrace();
        }
        JSONObject responseJson = (JSONObject) obj;

        System.out.println("\nHere is the JSON string:");
        System.out.println(obj);
        System.out.println(responseJson);

        System.out.println("\nHere is the prettified JSON object:");
        JsonFromString.prettify(responseJson);
    }
}
