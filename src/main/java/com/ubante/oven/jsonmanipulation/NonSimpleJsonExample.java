package com.ubante.oven.jsonmanipulation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Too pro for simple.
 */
public class NonSimpleJsonExample {

    static void processCString(String c) throws JSONException {
        // Drill down to the inner inner lists
        JSONObject outer = new JSONObject(c);
        JSONObject inner = outer.getJSONObject("JObjects");
        JSONArray jsonArray = inner.getJSONArray("JArray1");
        for (int i = 0, size = jsonArray.length(); i< size; i++) {
            JSONObject arrayElement = jsonArray.getJSONObject(i);

            String[] elementNames = JSONObject.getNames(arrayElement);
            System.out.printf("%d elements\n", elementNames.length);
            for (String elementName : elementNames) {
                String value = arrayElement.getString(elementName);
                System.out.printf("name=%s, value=%s\n", elementName, value);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws JSONException {
        String aString = "{\"Row\":[{\"key\":\"cjpvcmcjd2lraXBlZGlhI2VuIS93aWtpL0tyeW9nZW5pZmV4IWh0dHA=\"," +
                "\"Cell\":[{\"column\":\"bWV0YWRhdGE6cGFnZXJhbms=\",\"timestamp\":1400091685784,\"$\":\"AQAAAfw=\"}]}]}";
        String cString = "{\"JObjects\":{\"JArray1\":[{\"A\":\"a\",\"B\":\"b\",\"C\":\"c\"}," +
                "{\"A\":\"a1\",\"B\":\"b2\",\"C\":\"c3\",\"D\":\"d4\",\"E\":\"e5\"}," +
                "{\"A\":\"aa\",\"B\":\"bb\",\"C\":\"cc\",\"D\":\"dd\"}]}}";
        String dString = "{\"Row\":[{\"key\":\"cjpvcmcjd2lraXBlZGlhI2VuIS93aWtpL0tyeW9nZW5pZmV4IWh0dHA=\"," +
                "\"Cell\":[{\"column\":\"Y29udGVudDpyYXc=\",\"timestamp\":1400381442000," +
                "\"$\":\"AgIAAAAhAAAAGXicC07MTVVILFZIzs8rSc0rscpJLC7RTc/PTwEAdlUJWg==\"}," +
                "{\"column\":\"aGlzdG9yeTpjcmF3bA==\",\"timestamp\":1400381442000," +
                "\"$\":\"AQAAAUYNPQfQAAABRg5C/o8AAAAAAAAAyA==\"},{\"column\":\"aGlzdG9yeTppbmRleA==\"," +
                "\"timestamp\":1400381442000,\"$\":\"AQAAAUYNPQfQAAABRi1Jj14=\"},{\"column\":\"bGlua3M6aW5saW5rcw==\"," +
                "\"timestamp\":1400381442000,\"$\":\"AQEAAAADKWh0dHA6Ly93d3cuZGlncGxhbmV0LmNvbS93aWtpL0tyeW9nZW5pZmV4AAAAAShodHRwOi8vZW4ud2lraXBlZGlhLm9yZy93aWtpL0tyeW9nZW5pZmV4N2h0dHA6Ly93d3cuY2V2Z3JvdXAub3JnL2NyeW9nZW5pY3MtYmFzaWNzLWFwcGxpY2F0aW9ucy8AAAABC0tyeW9nZW5pZmV4J2h0dHA6Ly93d3cuYXNraXZlcy5jb20va3J5b2dlbmlmZXguaHRtbAAAAAIwS3J5b2dlbmlmZXggLSAgV2lraXBlZGlhICwgdGhlIGZyZWUgZW5jeWNsb3BlZGlhCXJlYWQgbW9yZQ==\"}," +
                "{\"column\":\"bWV0YWRhdGE6bXVsdGltZWRpYQ==\",\"timestamp\":1400381442000," +
                "\"$\":\"AQEAAAABY2h0dHA6Ly91cGxvYWQud2lraW1lZGlhLm9yZy93aWtpcGVkaWEvZW4vdGh1bWIvOS85MS9LcnlvZ2VuaWZleF9sb2dvLmpwZy8yMjBweC1LcnlvZ2VuaWZleF9sb2dvLmpwZwFJDngvODJkWFFYUVVYaXBnATAgZDFiYzhmMzc3YjZmZmJhMDM3ZDllMjk2MTZjZDFkZWYEanBlZwMyMjADMjAzBDY2MjUCLTEBMA==\"}," +
                "{\"column\":\"bWV0YWRhdGE6cGFnZXJhbms=\",\"timestamp\":1400091685784,\"$\":\"AQAAAfw=\"}," +
                "{\"column\":\"bWV0YWRhdGE6dXJs\",\"timestamp\":1400381442000,\"$\":\"AQAoaHR0cDovL2VuLndpa2lwZWRpYS5vcmcvd2lraS9LcnlvZ2VuaWZleAAAAUYNPQfQ\"}," +
                "{\"column\":\"c2VjdXJlOkRQ\",\"timestamp\":1400381442000,\"$\":\"AT9eJsnAAAAJwCeSE/////I/gJa7n////sA+w0WgAAAHAAAAAA==\"}]}]}";

        JSONObject jObj = new JSONObject(aString);
//        System.out.println(jObj.toString(3));

        // HBase response
        JSONObject outerObject = new JSONObject(dString); // singleRow has one element
        JSONArray rowArray = outerObject.getJSONArray("Row"); // hash
        JSONObject cellAndKeyObject = rowArray.getJSONObject(0);
        JSONArray columnsArray = cellAndKeyObject.getJSONArray("Cell");
        System.out.println(columnsArray);

        int columnsCount = columnsArray.length();
        System.out.println("Found "+columnsCount+" columns");
        for (int i = 0; i<columnsCount; i++) {
            JSONObject columnObject = columnsArray.getJSONObject(i);
            for (String columnPartsKeyString : JSONObject.getNames(columnObject)) {
                String value = columnObject.getString(columnPartsKeyString);
//                byte[] decodedValue = DatatypeConverter.par
                System.out.printf("key=%-9s, value=%s\n",columnPartsKeyString,value);
            }
            System.out.println();
        }

//        processCString(cString);

        String bString = "{\"Row\":[{\"key\":\"hashedKeyValue\"," +
                "\"Cell\":[{\"column\":\"hashedColumnValue\"," +
                "\"timestamp\":1400091685784,\"$\":\"AQAAAfw=\"}]}]}";

    }
}

/* aString
{"Row": [{
   "Cell": [{
      "$": "AQAAAfw=",
      "column": "bWV0YWRhdGE6cGFnZXJhbms=",
      "timestamp": 1400091685784
   }],
   "key": "cjpvcmcjd2lraXBlZGlhI2VuIS93aWtpL0tyeW9nZW5pZmV4IWh0dHA="
}]}
 */

/* bString
{"Row": [{
   "Cell": [{
      "$": "AQAAAfw=",
      "column": "hashedColumnValue",
      "timestamp": 1400091685784
   }],
   "key": "hashedKeyValue"
}]}
 */

/* cString
{"JObjects": {"JArray1": [
   {
      "A": "a",
      "B": "b",
      "C": "c"
   },
   {
      "A": "a1",
      "B": "b2",
      "C": "c3",
      "D": "d4",
      "E": "e5"
   },
   {
      "A": "aa",
      "B": "bb",
      "C": "cc",
      "D": "dd"
   }
]}}
 */

/* dString
{"Row": [{
   "Cell": [
      {
         "$": "AgIAAAAhAAAAGXicC07MTVVILFZIzs8rSc0rscpJLC7RTc/PTwEAdlUJWg==",
         "column": "Y29udGVudDpyYXc=",
         "timestamp": 1400381442000
      },
      {
         "$": "AQAAAUYNPQfQAAABRg5C/o8AAAAAAAAAyA==",
         "column": "aGlzdG9yeTpjcmF3bA==",
         "timestamp": 1400381442000
      },
...
      {
         "$": "AT9eJsnAAAAJwCeSE/////I/gJa7n////sA+w0WgAAAHAAAAAA==",
         "column": "c2VjdXJlOkRQ",
         "timestamp": 1400381442000
      }
   ],
   "key": "cjpvcmcjd2lraXBlZGlhI2VuIS93aWtpL0tyeW9nZW5pZmV4IWh0dHA="
}]}
 */