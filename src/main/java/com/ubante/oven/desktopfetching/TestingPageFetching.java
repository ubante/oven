package com.ubante.oven.desktopfetching;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * ubante 4/3/14 3:42 PM
 * This is very serious business.
 */


public class TestingPageFetching {

    public static String executePost(String targetUrl, String urlParameters)
    {
        URL url;
        HttpURLConnection connection = null;
        try {
            //Create connection
            url = new URL(targetUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            connection.setRequestProperty("Content-Length", "" +
                    Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream content = new DataOutputStream (
                    connection.getOutputStream());
            content.writeBytes(urlParameters);
            content.flush();
            content.close();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer response = new StringBuffer();
            while((line = bufferedReader.readLine()) != null) {
                response.append(line);
                response.append("\n");
            }
            bufferedReader.close();
            return response.toString();

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        } finally {

            if(connection != null) {
                connection.disconnect();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Testing fetching from my desktop");
        String urlParameters = "";

        try {
            urlParameters =
                    "fName=" + URLEncoder.encode("???", "UTF-8") +
                            "&lName=" + URLEncoder.encode("???", "UTF-8");
            System.out.println("Url Params set");
        } catch (Exception e) {
            System.err.println("Encoding failed");
        }

        String homepage = executePost("http://www.cnn.com", urlParameters);
        System.out.println(homepage);
    }

}

