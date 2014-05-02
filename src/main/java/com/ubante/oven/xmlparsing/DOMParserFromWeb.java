package com.ubante.oven.xmlparsing;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * ubante 4/8/14 2:16 PM
 * From http://www.javacodegeeks.com/2013/05/parsing-xml-using-dom-sax-and-stax-parser-in-java.html
 */
public class DOMParserFromWeb {

    // This will parse an xml file on disk
    public static void main(String[] args) throws Exception {
        String employeeUrl = "http://localhost/employee.xml";
//        String employeeUrl = "http://www.w3schools.com/xml/note.xml";

        // Send the request to webserver
        URL url;
        HttpURLConnection connection = null;

        url = new URL(employeeUrl);
        connection = (HttpURLConnection) url.openConnection();

        InputStreamReader isr = new InputStreamReader(connection.getInputStream());
        BufferedReader in = new BufferedReader(isr);
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
//
//        connection.setRequestMethod("GET");
//        connection.setUseCaches(false);
//        connection.setDoInput(true);
//        connection.setDoOutput(true);
//        DataOutputStream content = new DataOutputStream(connection.getOutputStream());
//        content.flush();
//        content.close();
//
        // Get the inputstream for the response from webserver
        // The below line throws:
        // Exception in thread "main" java.io.IOException: Server returned HTTP response code: 405 for URL: http://www.w3schools.com/xml/note.xml
        InputStream is = connection.getInputStream();

        //Get the DOM Builder Factory
        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();

        //Get the DOM Builder
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Load and Parse the XML document
        //document contains the complete XML as a Tree.
//        Document document = builder.parse(
//                ClassLoader.getSystemResourceAsStream("employee.xml"));
        Document document = builder.parse(is);

        List<Employee> empList = new ArrayList<Employee>();

        //Iterating through the nodes and extracting the data.
        NodeList nodeList = document.getDocumentElement().getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {

            //We have encountered an <employee> tag.
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Employee emp = new Employee();
                emp.id = node.getAttributes().
                        getNamedItem("id").getNodeValue();

                NodeList childNodes = node.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node cNode = childNodes.item(j);

                    //Identifying the child tag of employee encountered.
                    if (cNode instanceof Element) {
                        String elementContent = cNode.getLastChild().
                                getTextContent().trim();

                        if (cNode.getNodeName().equals("firstname")) {
                            emp.firstName = elementContent;
                        } else if (cNode.getNodeName().equals("lastname")) {
                            emp.lastName = elementContent;
                        } else if (cNode.getNodeName().equals("location")) {
                            emp.location = elementContent;
                        }

                    }
                }
                empList.add(emp);
            }

        }

        //Printing the Employee list populated.
        System.out.println("This is from the web.");
        for (Employee emp : empList) {
            System.out.println(emp);
        }

    }
}

