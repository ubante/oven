package com.ubante.oven.xmlparsing;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * ubante 4/8/14 2:16 PM
 * From http://www.javacodegeeks.com/2013/05/parsing-xml-using-dom-sax-and-stax-parser-in-java.html
 */
public class DOMParserDemo {

    // This will parse an xml file on disk
    public static void main(String[] args) throws Exception {
        //Get the DOM Builder Factory
        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();

        //Get the DOM Builder
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Load and Parse the XML document
        //document contains the complete XML as a Tree.
        Document document = builder.parse(
                ClassLoader.getSystemResourceAsStream("employee.xml"));

        List<Employee> empList = new ArrayList<Employee>();

        //Iterating through the nodes and extracting the data.
        NodeList nodeList = document.getDocumentElement().getChildNodes();

        System.out.printf("There are %d nodes\n", nodeList.getLength());

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
                        String content = cNode.getLastChild().
                                getTextContent().trim();

                        if (cNode.getNodeName().equals("firstname")) {
                            emp.firstName = content;
                        } else if (cNode.getNodeName().equals("lastname")) {
                            emp.lastName = content;
                        } else if (cNode.getNodeName().equals("location")) {
                            emp.location = content;
                        }

                    }
                }
                empList.add(emp);
            }
        }

        //Printing the Employee list populated.
        for (Employee emp : empList) {
            System.out.println(emp);
        }

    }
}
