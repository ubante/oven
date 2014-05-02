package com.ubante.oven.xmlparsing;

import java.io.*;
import java.nio.charset.Charset;
import javax.xml.parsers.*;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ContentNotAllowedInProlog {
    private static void parse(InputStream stream) throws SAXException,
            ParserConfigurationException, IOException {
        SAXParserFactory.newInstance().newSAXParser().parse(stream,
                new DefaultHandler());
    }

    public static void main(String[] args) {
        String[] encodings = {"UTF-8", "UTF-16", "ISO-8859-1"};
        for (String actual : encodings) {
            for (String declared : encodings) {
                if (actual != declared) {
                    System.out.println();
                    String xml = "<?xml version='1.0' encoding='" + declared
                            + "'?><x/>";
                    byte[] encoded = xml.getBytes(Charset.forName(actual));
                    try {
                        parse(new ByteArrayInputStream(encoded));
                        System.out.println("HIDDEN ERROR! actual:" + actual + " " + xml);
                    } catch (Exception e) {
                        System.out.println("Error:");
                        System.out.println(e.getMessage() + " actual:" + actual + " xml:"
                                + xml);
                    }
                }
            }
        }

        String properlyFormedXml = "<?xml version='1.0' encoding='UTF-8'?>";
        properlyFormedXml += "<fake xml/>";
        System.out.println(properlyFormedXml);
    }

}

