package trabalhoprático;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.*;
import org.jdom2.xpath.XPath;

//Executa pesquisa XPath e devolve lista de resultado
public class JaxenFunctions_XPATH {

    public static List pesquisaXPath(Document doc, String expXPath) {
        try {

            XPath xp = XPath.newInstance(expXPath);

            //devolve todos os nós que respeitam a expressão XPath
            List resultado = xp.selectNodes(doc);
            return resultado;
        } catch (JDOMException ex) {
            Logger.getLogger(JaxenFunctions_XPATH.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoClassDefFoundError a) {
            System.out.println("Erro : Classe não definida" + a);
        }
        return null;
    }
    public static String listarResultado(List res) {
        StringBuilder lista = new StringBuilder();
        //lista = null;
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i).getClass().getName().equals("org.jdom2.Element")) {
                Element x = (Element) res.get(i);
               // System.out.println("Elemento " + x.getName() + " = " + x.getValue());
                lista.append(x.getValue()).append("\n");
            }
            if (res.get(i).getClass().getName().equals("org.jdom2.Attribute")) {
                Attribute x = (Attribute) res.get(i);
               // System.out.println("Atributo " + x.getName() + " = " + x.getValue());
                lista.append(x.getValue() + "\n");
            }
            if (res.get(i).getClass().getName().equals("org.jdom2.Text")) {
                Text x = (Text) res.get(i);
              //  System.out.println("Texto " + x.getValue());
                lista.append(x.getValue() + "\n");
            }
            if (res.get(i).getClass().getName().equals("java.lang.Double")) {
                Double x = (Double) res.get(i);
                System.out.println("Double = " +  x);
                lista.append(x.toString() + "\n");
            }
         }
        if (res.isEmpty())
            return "Sem resultados";
        else
            return lista.toString();
}
}
