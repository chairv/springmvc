package xml;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Created by tancw on 2017/6/16.
 */
public class XmlUtils {

    public static Map streamToMap(InputStream fis) {
        Map<String, String> map = new HashMap<String, String>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder build = factory.newDocumentBuilder();
            Document doc = build.parse(fis);
            Element root = doc.getDocumentElement();
            NodeList nodes = root.getChildNodes();
            for (int i = 0, len = nodes.getLength(); i < len; i++) {
                Node node = nodes.item(i);
                if (node instanceof Element) {
                    map.put(node.getNodeName(), node.getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
