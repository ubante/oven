package com.ubante.oven.desktopfetching;


//import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;

/**
 * ubante 4/4/14 1:22 PM
 * This is very serious business.
 */
public class StubXmlParser {
//    String string;
//
//    StubXmlParser(String s) { this.string = s; }
//
//    Document toDocument() {
//        DOMParser parser = new DOMParser();
//        try {
//            parser.parse(new InputSource(new java.io.StringReader(string)));
//            Document doc = parser.getDocument();
//            return doc;
//        } catch (SAXException e) {
//            // handle SAXException
//        } catch (IOException e) {
//            // handle IOException
//        }
//
//        return null;
//    }
//
//    public static void main(String[] args) {
//        String xml;
//
//        xml = "<manifest >" +
//                "  <file\n" +
//                "    type=\"manifest_v1\"\n" +
//                "    fileId=\"download.aspx?fileId=n.ini\"\n" +
//                "    created=\"2014-04-02 22:40:40Z\"\n" +
//                "    expires=\"2014-04-05 22:40:40Z\"\n" +
//                "    signature=\"0\"\n" +
//                "    size=\"0\">\n" +
//                "    <location\n" +
//                "      site=\"https://cnn.com\" />\n" +
//                "  </file>\n" +
//                "  <file\n" +
//                "    type=\"manifest_v1\"\n" +
//                "    fileId=\"download.aspx?fileId=manifest.xml\"\n" +
//                "    created=\"2014-04-02 22:40:16Z\"\n" +
//                "    expires=\"2014-04-05 22:40:16Z\"\n" +
//                "    signature=\"4948d8ad01dd05d28241d2053b6f0426\"\n" +
//                "    size=\"512\">\n" +
//                "    <location\n" +
//                "      site=\"https://cnn.com\" />\n" +
//                "  </file>\n" +
//                "</manifest>";
//
//
//
//        System.out.println("\n\nHere is the xml string: \n"+xml);
//
//        StubXmlParser stub = new StubXmlParser(xml);
//        Document d = stub.toDocument();
//        System.out.println("\n----------- Here is the stuff we want:");
////        System.out.println(d.getDocumentElement().getTextContent());
//
//        NodeList nodeList = d.getElementsByTagName("file");
//        System.out.println("----------- or 5");
//        for (int i=0; i<nodeList.getLength(); i++) {
//            Node node = nodeList.item(i);
//            String location = "https://cnn.com"; // Assume this doesn't change
//
//            if (node.hasAttributes()) {
//                Attr attr = (Attr) node.getAttributes().getNamedItem("fileId");
//                if (attr == null) { continue; }
//                String attribute = attr.getValue();
//                if (attribute.contains("version.ini")) { continue; }
//                System.out.println(location+"/"+attribute);
//
//
//            }
//        }
//
//
//
//
//        // We want the site attribute for the location tag
//        // And the fileId attribute for the file tag
//
//    }
}
