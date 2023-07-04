/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoprático;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.Document;

/**
 *
 * @author Leandro
 */
public class ComboBoxUtil {

    public static class GuardarFicheiros {

        public static void guardarFich(String dados, String camiFich) throws IOException {
            File dir = new File("ficheiros guardados");
            
            if (!dir.exists())
                dir.mkdir();
            
            File fich = new File(dir + "/" + camiFich + "_0.txt");

            for (int i = 0; fich.exists(); i++) {
                fich = new File(fich.getAbsolutePath().replace("_" + (i - 1) + ".txt", "_" + i + ".txt"));
            }
            
            BufferedWriter BW = new BufferedWriter(new FileWriter(fich));
            
            BW.write(dados);
            
            BW.close();
        }
    }

    public static String pesquisaComboBoxCamaras(String combobox) {
        switch (combobox) {
            case "Arganil": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/camaras.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//camara[municipio='Arganil']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Cantanhede": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/camaras.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//camara[municipio='Cantanhede']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Coimbra": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/camaras.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//camara[municipio='Coimbra']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Condeixa a Nova": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/camaras.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//camara[municipio='Condeixa-a-Nova']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Figueira da Foz": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/camaras.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//camara[municipio='Figueira da Foz']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Góis": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/camaras.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//camara[municipio='Góis']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Lousã": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/camaras.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//camara[municipio='Lousã']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Mealhada": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/camaras.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//camara[municipio='Mealhada']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Mira": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/camaras.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//camara[municipio='Mira']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Miranda do Corvo": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/camaras.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//camara[municipio='Miranda do Corvo']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Montemor-o-Velho": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/camaras.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//camara[municipio='Montemor-o-Velho']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Mortágua": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/camaras.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//camara[municipio='Mortágua']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Oliveira do Hospital": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/camaras.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//camara[municipio='Oliveira do Hospital']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Pampilhosa da Serra": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/camaras.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//camara[municipio='Pampilhosa da Serra']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Penacova": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/camaras.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//camara[municipio='Penacova']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Penela": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/camaras.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//camara[municipio='Penela']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Soure": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/camaras.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//camara[municipio='Soure']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Tábua": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/camaras.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//camara[municipio='Tábua']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Vila Nova de Poiares": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/camaras.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//camara[municipio='Vila Nova de Poiares']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            default:
                return "Resultado Inválido!";

        }
    }

    public static String pesquisaComboBoxContratos(String combobox) {
        switch (combobox) {
            case "Arganil": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/contratos.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//municipio[@nome='Arganil']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Cantanhede": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/contratos.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//municipio[@nome='Cantanhede']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Coimbra": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/contratos.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//municipio[@nome='Coimbra']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Condeixa a Nova": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/contratos.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//municipio[@nome='CondeixaANova']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Figueira da Foz": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/contratos.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//municipio[@nome='FigueiradaFoz']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Góis": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/contratos.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//municipio[@nome='Gois']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Lousã": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/contratos.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//municipio[@nome='Lousa']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Mealhada": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/contratos.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//municipio[@nome='Mealhada']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Mira": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/contratos.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//municipio[@nome='Mira']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Miranda do Corvo": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/contratos.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//municipio[@nome='MirandaDoCorvo']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Montemor-o-Velho": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/contratos.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//municipio[@nome='MontemorOVelho']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Mortágua": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/contratos.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//municipio[@nome='Mortágua']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Oliveira do Hospital": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/contratos.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//municipio[@nome='OliveiradoHospital']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Pampilhosa da Serra": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/contratos.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//municipio[@nome='PampilhosaDaSerra']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Penacova": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/contratos.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//municipio[@nome='Penacova']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Penela": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/contratos.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//municipio[@nome='Penela']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Soure": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/contratos.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//municipio[@nome='Soure']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Tábua": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/contratos.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//municipio[@nome='Tábua']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            case "Vila Nova de Poiares": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/contratos.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//municipio[@nome='VilaNovadePoiares']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2;
            }
            default:
                return "Resultado Inválido!";
        }
    }

    public static String pesquisaTipoComboBoxCamaras(String combobox, String textfield) {
        textfield = textfield.trim();
        switch (combobox) {
            case "Email": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/camaras.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//camara[email='" + textfield + "']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2.trim();
            }
            case "Telefone": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/camaras.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//camara[telefone='" + textfield + "']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2.trim();
            }
            case "Número de Freguesias": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/camaras.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//camara[numfreguesias='" + textfield + "']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2.trim();
            }
            case "Número de Habitantes": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/camaras.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//camara[numhabitantes='" + textfield + "']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2.trim();
            }
            case "Top5": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/camaras.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2.trim();
            }
            case "Presidente da Camara": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/camaras.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//camara[presidenteC='" + textfield + "']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2.trim();
            }
            case "Presidente da Assembleia": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/camaras.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//camara[presidenteA='" + textfield + "']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2.trim();
            }
            case "Dois": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/camaras.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2.trim();
            }
            default:
                return "Resultado Inválido!";
        }
    }

    public static String pesquisaTipoComboBoxContratos(String combobox, String textfield) {
        textfield = textfield.trim();
        switch (combobox) {
            case "Data": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/contratos.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//municipio/contrato[datapub='" + textfield + "']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2.trim();
            }
            case "Municipio": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/contratos.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//municipio[@nome='" + textfield + "']/contrato");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2.trim();
            }
            case "Adjudicatário": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/contratos.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//municipio/contrato[adjudicatario='" + textfield + "']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2.trim();
            }
            case "Preço": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/contratos.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//municipio/contrato[preco='" + textfield + "']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2.trim();
            }
            case "Objeto Contrato": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/contratos.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "//municipio/contrato[objcontrato='" + textfield + "']");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2.trim();
            }
            case "Maior": {
                Document doc = XMLJDomFunctions.lerDocumentoXML("fichs/contratos.xml");
                List<String> list = new ArrayList<>();
                list = JaxenFunctions_XPATH.pesquisaXPath(doc, "");
                String str2 = "";
                str2 = JaxenFunctions_XPATH.listarResultado(list);
                return str2.trim();
            }
            default:
                return "Resultado Inválido!";
        }
    }
}
