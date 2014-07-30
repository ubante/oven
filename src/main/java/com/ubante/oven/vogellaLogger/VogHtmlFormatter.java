package com.ubante.oven.vogellaLogger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 * This is from www.vogella.com/tutorials
 */
public class VogHtmlFormatter extends Formatter {

    public String format(LogRecord record) {
        StringBuffer buffer = new StringBuffer(1000);
        buffer.append("<tr>\n");

        // colorize
        if (record.getLevel().intValue() >= Level.WARNING.intValue()) {
            buffer.append("\t<td style=\"color:red\">");
            buffer.append("<b>");
            buffer.append(record.getLevel());
            buffer.append("</b>");
        } else {
            buffer.append("\t<td>");
            buffer.append(record.getLevel());
        }

        buffer.append("</td>\n\t<td>");
        buffer.append(calcDate(record.getMillis()));
        buffer.append("</td>\n\t<td>");
        buffer.append(formatMessage(record));
        buffer.append("</td>\n\t<td>\n");

        return buffer.toString();
    }

    private String calcDate(long millisecs) {
        SimpleDateFormat date_format = new SimpleDateFormat("MM dd,yyyy HH:mm");
        Date resultDate = new Date(millisecs);
        return date_format.format(resultDate);
    }

    // this method is called just after the handler using this

    // formatter is created

    public String getHead(Handler h) {
        return "<!DOCTYPE html>\n<head>\n<style"
                + "type=\"text/css\">\n"
                + "table { width: 100% }\n"
                + "th { font:bold 10pt Tahoma; }\n"
                + "td { font:normal 10pt Tahoma; }\n"
                + "h1 {font:normal 11pt Tahoma;}\n"
                + "</style>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h1>" + (new Date()) + "</h1>\n"
                + "<table border=\"0\" cellpadding=\"5\" cellspacing=\"3\">\n"
                + "<tr align=\"left\">\n"
                + "\t<th style=\"width:10%\">Loglevel</th>\n"
                + "\t<th style=\"width:15%\">Time</th>\n"
                + "\t<th style=\"width:75%\">Log Message</th>\n"
                + "</tr>\n";
    }

    public String getTail(Handler h) { return "</table>\n</body>\n</html>"; }

}
