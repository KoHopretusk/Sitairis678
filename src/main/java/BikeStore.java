
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class BikeStore extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        List<Bicycle> bicycles = readBicyclesFromXML("src/main/java/Bicycles.xml");
        for (Bicycle bicycle : bicycles) {
            out.println(bicycle);
            out.println("<br>");
        }
    }

    public static List<Bicycle> readBicyclesFromXML(String filePath) {
        List<Bicycle> bicycles = new ArrayList<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(filePath);


            NodeList modelNodes = document.getElementsByTagName("model");
            for (int i = 0; i < modelNodes.getLength(); i++) {
                Element modelElement = (Element) modelNodes.item(i);
                String name = modelElement.getElementsByTagName("name").item(0).getTextContent();
                int price = Integer.parseInt(modelElement.getElementsByTagName("price").item(0).getTextContent());
                int quantity = Integer.parseInt(modelElement.getElementsByTagName("quantity").item(0).getTextContent());
                bicycles.add(new Bicycle(name, price, quantity));
            }


            NodeList discountedModelNodes = document.getElementsByTagName("discounted_model");
            for (int i = 0; i < discountedModelNodes.getLength(); i++) {
                Element discountedModelElement = (Element) discountedModelNodes.item(i);
                String name = discountedModelElement.getElementsByTagName("name").item(0).getTextContent();
                int price = Integer.parseInt(discountedModelElement.getElementsByTagName("price").item(0).getTextContent());
                int quantity = Integer.parseInt(discountedModelElement.getElementsByTagName("quantity").item(0).getTextContent());
                int discount = Integer.parseInt(discountedModelElement.getElementsByTagName("discount").item(0).getTextContent());
                bicycles.add(new DiscountedBicycle(name, price, quantity, discount));
            }


            NodeList usedModelNodes = document.getElementsByTagName("used_model");
            for (int i = 0; i < usedModelNodes.getLength(); i++) {
                Element usedModelElement = (Element) usedModelNodes.item(i);
                String name = usedModelElement.getElementsByTagName("name").item(0).getTextContent();
                int price = Integer.parseInt(usedModelElement.getElementsByTagName("price").item(0).getTextContent());
                int quantity = Integer.parseInt(usedModelElement.getElementsByTagName("quantity").item(0).getTextContent());
                String condition = usedModelElement.getElementsByTagName("condition").item(0).getTextContent();
                bicycles.add(new UsedBicycle(name, price, quantity, condition));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bicycles;
    }
}