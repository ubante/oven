package com.ubante.oven.strings;

/**
 * ubante 8/15/14 4:41 PM
 * This is very serious business.
 */
public class StringBuilderBuilder {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("start ");
        System.out.println(sb.toString());

        sb.append("and more");
        System.out.println(sb.toString());

        String morer = "morer";
        sb.append(" and").append(" " + morer + " " + "and" + " " + "evenmorer");
        System.out.println(sb.toString());

        StringBuilder sb2 = new StringBuilder();
        String dePaddedString = "nopads";
        sb2.append("\t" + dePaddedString + "\",\r\n");

        sb2.append("\t\"content_last_good\":\r\n\t\t\"").append(dePaddedString).
                append("\",\r\n");
        System.out.println(sb2);


        StringBuilder fullLine = new StringBuilder("line1\nline2\nline3\n");

        double dss = -1.4;
        double dssv4 = -3.4;
        double ss = 3.234;
        double ssv3 = 24.32;
        StringBuilder dpSB = new StringBuilder();
        dpSB.append("\t\"meta\":{");
        dpSB.append("\"SpamScore\":");
        dpSB.append(dss);
        dpSB.append(",\"SpamScoreV4\":");
        dpSB.append(dssv4);
        dpSB.append(",\"JunkScore\":");
        dpSB.append(ss);
        dpSB.append(",\"JunkScoreV3\":");
        dpSB.append(ssv3);
        dpSB.append("},\n");

        fullLine.append(dpSB);
        fullLine.append("line4\nline5");

        System.out.println(fullLine);

    }
}
