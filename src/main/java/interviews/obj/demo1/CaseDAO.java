package interviews.obj.demo1;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class CaseDAO {

    public static void main(String[] args) {

        URL fileUrl = Thread.currentThread().getContextClassLoader().getResource("interviews/obj/demo1/case1.xml");
        String filePath = fileUrl.getPath();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(filePath));
            NodeList testCase = doc.getElementsByTagName("testCase");
            NodeList items = testCase.item(0).getChildNodes();
            NodeList itemsList = items.item(1).getChildNodes();
            System.out.println(itemsList.getLength());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
