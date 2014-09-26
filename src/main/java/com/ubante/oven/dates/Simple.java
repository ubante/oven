package com.ubante.oven.dates;

import java.util.Date;

/**
 * ubante 8/20/14 4:30 PM
 * This is very serious business.
 */
public class Simple {

    public static String unixTime2HumanTime(long timeStamp) {
        Date d = new Date(timeStamp);
        return d.toString();
    }

    public static void main(String[] args) {
        long timeStamp = 1408547668000L;

        Date d = new Date(timeStamp);
        System.out.println(d.toString());

        StringBuilder docSB = new StringBuilder("");
        docSB.append(String.format("\t\t\t\"%s\":\"%s\",\r\n", "CrawlTimestampHumanReadable",
                        unixTime2HumanTime(timeStamp)));

        System.out.println(docSB);
    }
}
