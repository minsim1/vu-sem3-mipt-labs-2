package com.example.mipt_lab_2;

import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

// Uses DOM
public class Parser {
    private static final String TAG = "Parser";

    public List<Currency> parse(String xmlData) {
        Log.i(TAG, "Called parse method");
        List<Currency> currencyList = new ArrayList<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new ByteArrayInputStream(xmlData.getBytes(StandardCharsets.UTF_8)));

            // All <Cube> elements with attributes "currency" and "rate"
            NodeList cubeNodes = doc.getElementsByTagName("Cube");

            for (int i = 0; i < cubeNodes.getLength(); i++) {
                Element element = (Element) cubeNodes.item(i);

                if (element.hasAttribute("currency") && element.hasAttribute("rate")) {
                    String code = element.getAttribute("currency");
                    String value = element.getAttribute("rate");
                    currencyList.add(new Currency(code, value));
                }
            }

        } catch (Exception e) {
            Log.e(TAG, "Error parsing XML", e);
        }

        return currencyList;
    }
}