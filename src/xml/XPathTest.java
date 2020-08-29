package xml;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;

/**
 * mybatis技术内幕
 *
 * @author 97994
 * @since 2020-08-09
 */
public class XPathTest {
    public static void main(String[] args)
        throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(false);
        factory.setIgnoringComments(true);
        factory.setIgnoringElementContentWhitespace(false);
        factory.setCoalescing(false);
        factory.setExpandEntityReferences(true);

        DocumentBuilder documentBuilder = factory.newDocumentBuilder();

        documentBuilder.setErrorHandler(new ErrorHandler() {
            @Override
            public void warning(SAXParseException exception) throws SAXException {

            }

            @Override
            public void error(SAXParseException exception) throws SAXException {

            }

            @Override
            public void fatalError(SAXParseException exception) throws SAXException {

            }
        });

        Document document = documentBuilder.parse("resource/inventory.xml");

        XPathFactory xPathFactory = XPathFactory.newInstance();

        XPath xPath = xPathFactory.newXPath();
        // 多次使用同一个表达式，建议先编译
        XPathExpression compile = xPath.compile("//book[author='neal']/title/text()");
        Object evaluate = compile.evaluate(document, XPathConstants.NODESET);
        printNodeList((NodeList)evaluate);
        // 不正确
        // Object evaluate1 = xPath.evaluate("//book[@author!='eal']/title/text()", document, XPathConstants.NODESET);
//         Object evaluate1 = xPath.evaluate("//book[@year>2000]/title/text()", document, XPathConstants.NODESET);
         Object evaluate1 = xPath.evaluate("//book[@year>2000]/@*|//book[@year>2000]/title/text()", document, XPathConstants.NODESET);
        printNodeList((NodeList)evaluate1);
    }

    private static void printNodeList(NodeList evaluate) {
        NodeList nodeList = evaluate;
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println(nodeList.item(i));
        }
    }
}
