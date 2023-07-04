/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoprático;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;

/**
 *
 * @author Leandro
 */
public class TrabalhoPrático {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        new NomeBemNotPodre().setVisible(true);

        // TODO code application logic here
    }

    public static void atualiza() {
        // apagar ficheiros
        try {
            File camarasXML = new File("fichs/camaras.xml");

            if (camarasXML.exists()) {
                camarasXML.delete();
            }

            File contratosXML = new File("fichs/contratos.xml");

            if (contratosXML.exists()) {
                contratosXML.delete();
            }

            File camaras = new File("fichs/camaras");

            if (camaras.exists()) {
                for (File f : camaras.listFiles()) {
                    f.delete();
                }
            }

            File contratos = new File("fichs/contratos");

            if (contratos.exists()) {
                for (File f : contratos.listFiles()) {
                    f.delete();
                }
            }

            File trans = new File("fichs/transformado");

            if (trans.exists()) {
                for (File f : trans.listFiles()) {
                    f.delete();
                }
            }
        } catch (Exception e) {
        }

        String[] municipios = {
            "Arganil",
            "Cantanhede",
            "Coimbra",
            "CondeixaANova",
            "FigueiradaFoz",
            "Gois",
            "Lousa",
            "Mealhada",
            "Mira",
            "MirandaDoCorvo",
            "MontemorOVelho",
            "Mortágua",
            "OliveiradoHospital",
            "PampilhosaDaSerra",
            "Penacova",
            "Penela",
            "Soure",
            "Tábua",
            "VilaNovadePoiares"
        };

        String[] nif = {
            "506833232",
            "506087000",
            "506415082",
            "501275380",
            "501305580",
            "506613399",
            "501121528",
            "506792382",
            "506724530",
            "506624200",
            "501272976",
            "506855368",
            "506818829",
            "506811883",
            "506657957",
            "506778037",
            "507103742",
            "506806944",
            "505371600"
        };

        String[] cods = {
            "3300",
            "3060",
            "3000",
            "3150",
            "3080",
            "3330",
            "3200",
            "3050",
            "3070",
            "3220",
            "3140",
            "3450",
            "3400",
            "3320",
            "3360",
            "3230",
            "3130",
            "3420",
            "3350"
        };
        for (int i = 0; i < cods.length; i++) {
            HttpRequestFunctions.httpRequest("https://www.anmp.pt/anmp/pro/mun1/mun101w3.php?cod=M", cods[i], "fichs/camaras/" + cods[i] + ".html", "windows-1252");
        }

        String[] cods2 = {
            "3106",
            "911",
            "3743",
            "898",
            "24242",
            "2251",
            "45",
            "11267",
            "1477",
            "15499",
            "8759",
            "1013",
            "658",
            "5416",
            "212",
            "15496",
            "671",
            "4497",
            "5938"
        };
        for (int i = 0; i < cods2.length; i++) {
            HttpRequestFunctions.httpRequest("http://www.base.gov.pt/Base/pt/ResultadosPesquisa?type=contratos&query=adjudicanteid%3D", cods2[i], "fichs/contratos/" + cods2[i] + ".html", "UTF-8");
        }
        try {
            reFormatContratos(cods2);
            adicionaContrato(cods2, nif, municipios);

            adicionaCamara(cods);
        } catch (Exception ex) {
            Logger.getLogger(TrabalhoPrático.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void adicionaContrato(String[] cods2, String[] nif2, String[] municipios) throws FileNotFoundException {
        Element raiz;
        //Falta os atributos
        Element municipio = null;
        Attribute nome;
        Element contrato = null;
        Attribute id;
        Element nif = null;
        Element objcontrato = null;
        Element preco = null;
        Element datapub = null;
        Element adjudicatario = null;
        int idNum = 0;

        Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/contratos.xml");
        if (doc == null) {
            raiz = new Element("contratos");
            doc = new Document(raiz);
        } else {
            raiz = doc.getRootElement();
        }

        String RegEx = "<td\\s*title=\"[A-Za-z\\ç\\Ç\\ã\\Ã\\+\\¬\\s\\'\\ó\\Ó\\,\\í\\Í\\\"\\.\\“\\õ\\Õ\\(\\)\\”\\ú\\Ú\\-\\à\\À0-9\\º\\á\\–\\’\\º\\:\\/\\é\\É\\è\\È\\â\\Â\\Á\\ê\\Ê\\ª\\;\\_\\\"\\%]*\">([A-Za-z\\ç\\Ç\\ã\\Ã\\'\\s\\ó\\Ó\\,\\í\\&\\Í\\\"\\.\\“\\õ\\Õ\\(\\)\\”\\ú\\Ú\\-\\à\\À0-9\\º\\á\\–\\’\\º\\:\\/\\é\\É\\è\\È\\â\\Â\\Á\\ê\\Ê\\ª\\;\\_\\\"\\%]+)<\\/td>\\s*<td\\s*style=\"white-space:\\s*nowrap\">([0-9\\.\\,\\€\\s]+)<\\/td>\\s*<td\\s*style=\"white-space:\\s*nowrap\">([0-9\\-\\s]+)<\\/td>\\s*<td>(Município[a-zA-Z\\s\\á\\ó\\-\\-\\ã]+)<\\/td>\\s*<td>([a-zA-Z\\s\\`\\í\\Í\\,\\–\\ã\\Ã\\ç\\Ç\\.\\-\\ú\\Ú\\á\\Á\\à\\À\\â\\Â\\õ\\Õ\\&\\ó\\Ó\\é\\É\\'\\/\\ª\\º\\(\\)\\ê\\;\\–0-9]*)<\\/td>\\s*<td><span\\s*class=\"";
        String linha;
        Pattern p = Pattern.compile(RegEx);

        for (int i = 0; i < cods2.length; i++) {
            municipio = new Element("municipio");
            nome = new Attribute("nome", municipios[i]);
            municipio.setAttribute(nome);
            if (nif == null) {
                nif = new Element("nif").addContent(nif2[i]);
                municipio.addContent(nif);
            }
            Scanner ler = new Scanner(new FileInputStream("fichs/contratos/" + cods2[i] + ".html"));
            while (ler.hasNextLine()) {
                int aux = 0;
                linha = ler.nextLine();
                Matcher mc = p.matcher(linha);
                while (mc.find()) {
                    contrato = new Element("contrato");
                    id = new Attribute("id", "id" + idNum);
                    contrato.setAttribute(id);
                    if (mc.group(1) != null) {
                        objcontrato = new Element("objcontrato").addContent(mc.group(1));
                        contrato.addContent(objcontrato);
                    }
                    if (mc.group(2) != null) {
                        preco = new Element("preco").addContent(mc.group(2));
                        contrato.addContent(preco);
                    }
                    if (mc.group(3) != null) {
                        datapub = new Element("datapub").addContent(mc.group(3));
                        contrato.addContent(datapub);
                    }
                    if (mc.group(5) != null) {
                        adjudicatario = new Element("adjudicatario").addContent(mc.group(5));
                        contrato.addContent(adjudicatario);
                        aux++;
                    }
                    if (aux > 0) {
                        idNum++;
                        municipio.addContent(contrato);
                        nif = null;
                    }
                }
            }
            raiz.addContent(municipio);
        }

        XMLJDomFunctions.escreverDocumentoParaFicheiro(doc, "fichs/contratos.xml");
    }

    public static void reFormatContratos(String[] cods2) throws FileNotFoundException, IOException {

        for (int i = 0; i < cods2.length; i++) {
            StringBuilder sb = new StringBuilder();
            Scanner ler = new Scanner(new FileInputStream("fichs/contratos/" + cods2[i] + ".html"));

            while (ler.hasNextLine()) {
                sb.append(ler.nextLine().replace('\n', ' '));
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("fichs/contratos/" + cods2[i] + ".html")));

            bw.write(sb.toString());

            bw.close();
            ler.close();
        }

    }

    public static void adicionaCamara(String[] cods) throws FileNotFoundException {
        Element raiz;
        Element camara = null;
        Attribute id;
        Element municipio = null;
        Element presidenteC = null;
        Element presidenteA = null;
        Element email = null;
        Element site = null;
        Element telefone = null;
        Element numFreg = null;
        Element area = null;
        Element numHab = null;
        Element feriado = null;
        Element brasao = null;

        Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/camaras.xml");
        //Document doc = new Document(pai); //usar o elemento raiz no construtor Document

        //escreverDocumentoParaFicheiro(doc,”pessoa.xml”);
        if (doc == null) {
            raiz = new Element("camaras");
            doc = new Document(raiz);
        } else {
            raiz = doc.getRootElement();
        }

        // 0 - Município
        // 1 - Presidente C
        // 2 - Presidente A
        // 3 - Email
        // 4 - Site
        // 5 - Telefone
        // 6 - Num Freg
        // 7 - Area
        // 8 - Num Hab
        // 9 - Feriado
        // 10 - Brasão
        String[] RegEx = {
            "class=\"sel3\">([a-zA-Z\\s\\ó\\ã\\á\\-]+)[\\s]*<\\/div>",
            "class=\"f3\">([a-zA-Z\\ó\\-\\í\\ã\\é\\É\\ú\\s\\â\\ç\\á\\Ã\\Í]+), Presidente da C",
            "<div\\s*class=\"f3\"\\s*>([a-zA-Z\\ó\\-\\í\\ã\\é\\É\\ú\\s\\â\\ç\\á\\Ã\\Í]+), Presidente da A",
            "<a href=\"mailto:([a-zA-Z\\@\\-\\.]+)\\s*\"\\s*class=\"f2\">",
            "gina\\sWeb:\\s([a-zA-Z\\:\\/\\.\\-]+)",
            "Telefone:\\s([0-9\\s]+)",
            "(\\d+) freguesias",
            "(\\d+\\,\\d+) km2",
            "([\\s\\d]+) habitantes",
            "<div\\s*class=\"f3\"\\s*>feriado municipal, ([0-9\\-]+)",
            "<IMG SRC=\"\\.\\.\\/\\.\\.\\/\\.\\.([a-zA-Z\\/\\.0-9]+b\\.jpg)\""
        };

        String linha;

        for (int i = 0; i < cods.length; i++) {
            camara = new Element("camara");
            id = new Attribute("id", "id" + i);
            camara.setAttribute(id);
            for (int j = 0; j < RegEx.length; j++) {

                Scanner ler = new Scanner(new FileInputStream("fichs/camaras/" + cods[i] + ".html"));

                while (ler.hasNextLine()) {
                    linha = ler.nextLine();
                    Pattern p = Pattern.compile(RegEx[j]);
                    Matcher mc = p.matcher(linha);
                    while (mc.find()) {
                        switch (j) {
                            case 0: {
                                municipio = new Element("municipio").addContent(mc.group(1));
                                camara.addContent(municipio);
                                break;
                            }
                            case 1: {
                                presidenteC = new Element("presidenteC").addContent(mc.group(1));
                                camara.addContent(presidenteC);
                                break;
                            }
                            case 2: {
                                presidenteA = new Element("presidenteA").addContent(mc.group(1));
                                camara.addContent(presidenteA);
                                break;
                            }
                            case 3: {
                                email = new Element("email").addContent(mc.group(1));
                                camara.addContent(email);
                                break;
                            }
                            case 4: {
                                site = new Element("site").addContent(mc.group(1));
                                camara.addContent(site);
                                break;
                            }
                            case 5: {
                                telefone = new Element("telefone").addContent(mc.group(1));
                                camara.addContent(telefone);
                                break;
                            }
                            case 6: {
                                numFreg = new Element("numfreguesias").addContent(mc.group(1));
                                camara.addContent(numFreg);
                                break;
                            }
                            case 7: {
                                area = new Element("area").addContent(mc.group(1));
                                camara.addContent(area);
                                break;
                            }
                            case 8: {
                                numHab = new Element("numhabitantes").addContent(mc.group(1));
                                camara.addContent(numHab);
                                break;
                            }
                            case 9: {
                                feriado = new Element("feriado").addContent(mc.group(1));
                                camara.addContent(feriado);
                                break;
                            }
                            case 10: {
                                brasao = new Element("brasao").addContent("https://www.anmp.pt" + mc.group(1));
                                camara.addContent(brasao);
                                break;
                            }
                            default:
                        }
                    }
                }
            }
            raiz.addContent(camara);
        }

        XMLJDomFunctions.escreverDocumentoParaFicheiro(doc, "fichs/camaras.xml");
        /*
        if (doc == null) {
         raiz = new Element("camaras");
         for(int i = 0; i < cods.length; i++){
             Element municipio = new Element("municipio").addContent();
             Element presidenteC = new Element("presidenteC").addContent();
             Element presidenteA = new Element("presidenteA").addContent();
             Element email = new Element("email").addContent();
             Element site = new Element("site").addContent();
             Element telefone = new Element("telefone").addContent();
             Element numfreguesias = new Element("numfreguesias").addContent();
             Element area = new Element("area").addConten();
             Element numhabitantes = new Element("numhabitantes").addContent();
             Element feriado = new Element("feriado").addContent();
             Element brasao = new Element("brasao").addContent();
             
             
             Attribute a = new Attribute("id", "cods[i]");
             Element camara = new Element("camara");
             //camara.addContent(a);
             camara.addContent(municipio);
             camara.addContent(presidenteC);
             camara.addContent(presidenteA);
             camara.addContent(email);
             camara.addContent(site);
             camara.addContent(telefone);
             camara.addContent(numfreguesias);
             camara.addContent(area);
             camara.addContent(numhabitantes);
             camara.addContent(feriado);
             camara.addContent(brasao);
             
             raiz.addContent(camara);
         }
         
         
         doc = new Document(raiz);
        } else {
         raiz = doc.getRootElement();
        }*/
    }

    public static void criaxsdcamaras(String xmlFile) {
        System.out.println("Passei aqui");
        Document doc = XMLJDomFunctions.lerDocumentoXML(xmlFile);
        File f = new File("fichs/camaras.xsd");
        //nao entra dentro do if
        if (doc != null && f.exists()) {//XSD e XML existem
            Element raiz = doc.getRootElement();
            //Atribuir XSD ao ficheiro XML
            Namespace XSI = Namespace.getNamespace("xsi", "http://www.w3.org/2001/XMLSchemainstance");
            raiz.addNamespaceDeclaration(XSI);
            raiz.setAttribute("noNamespaceSchemaLocation", "camaras.xsd", XSI);

            /*
            raiz.setAttribute(new Attribute("noNamespaceSchemaLocation","camaras.xsd",
            Namespace.getNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance")));*/
            //Gravar o XML com as alterações em disco
            //XMLJDomFunctions.escreverDocumentoParaFicheiro(doc, xmlFile);
            //CHAMAR A FUNÇÃO DE VALIDAÇÃO por XSD
            Document docXSD = JDOMFunctions_Validar.validarXSD(xmlFile);
            if (docXSD == null) {
                System.out.println("INVALIDO por XSD");
            } else {
                System.out.println("VALIDO por XSD");
            }
        }

    }

    public static void criaxsdcontratos(String xmlFile) {
        Document doc = XMLJDomFunctions.lerDocumentoXML(xmlFile);
        File f = new File("camaras.xsd");
        if (doc != null && f.exists()) {//XSD e XML existem
            Element raiz = doc.getRootElement();
            //Atribuir XSD ao ficheiro XML
            Namespace XSI = Namespace.getNamespace("xsi", "http://www.w3.org/2001/XMLSchemainstance");
            raiz.addNamespaceDeclaration(XSI);
            raiz.setAttribute(new Attribute("noNamespaceSchemaLocation", "produtos.xsd",
                    Namespace.getNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance")));
            //Gravar o XML com as alterações em disco
            XMLJDomFunctions.escreverDocumentoParaFicheiro(doc, xmlFile);

            //CHAMAR A FUNÇÃO DE VALIDAÇÃO por XSD
            Document docXSD = JDOMFunctions_Validar.validarXSD(xmlFile);
            if (docXSD == null) {
                System.out.println("INVALIDO por XSD");
            } else {
                System.out.println("VALIDO por XSD");
            }
        }

    }

}
