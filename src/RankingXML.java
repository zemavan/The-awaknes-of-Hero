import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

// Adaptado de CrearXML.java y LeerXML.java facilitados por el docente
public class RankingXML {

    // Devuelve el ranking cargado, un ranking vacio si el archivo no existe,
    // o null si el archivo existe pero no se puede leer o tiene datos incorrectos
    public static Ranking cargar(String ruta){
        Ranking ranking = new Ranking();
        File archivo = new File(ruta);
        if(!archivo.exists()){
            return ranking;
        }
        try {
            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
            // Permitimos DOCTYPE, pero no cargamos DTD ni entidades externas
            fabrica.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            fabrica.setFeature("http://xml.org/sax/features/external-general-entities", false);
            fabrica.setFeature("http://xml.org/sax/features/external-parameter-entities", false);

            DocumentBuilder constructor = fabrica.newDocumentBuilder();
            Document documento = constructor.parse(archivo);
            documento.getDocumentElement().normalize();

            NodeList lista = documento.getElementsByTagName("registro");
            if(lista.getLength() > Ranking.MAX_RANKING){
                throw new Exception("hay mas de " + Ranking.MAX_RANKING + " registros");
            }
            for(int i = 0; i < lista.getLength(); i++){
                Element registro = (Element) lista.item(i);
                String nombre = registro.getElementsByTagName("nombre").item(0).getTextContent().trim();
                int puntos = Integer.parseInt(
                        registro.getElementsByTagName("puntos").item(0).getTextContent().trim());
                if(nombre.isEmpty() || puntos < 0){
                    throw new Exception("registro " + (i + 1) + " con datos incorrectos");
                }
                ranking.add(nombre, puntos);
            }
            return ranking;
        } catch (Exception e) {
            System.out.println("Error al leer " + ruta + ": " + e);
            return null;
        }
    }

    public static boolean guardar(String ruta, Ranking ranking){
        try {
            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
            Document documento = fabrica.newDocumentBuilder().newDocument();

            Element raiz = documento.createElement("ranking");
            documento.appendChild(raiz);

            for(int i = 0; i < ranking.size(); i++){
                Reg r = ranking.get(i);
                Element registro = documento.createElement("registro");
                Element nombre = documento.createElement("nombre");
                nombre.setTextContent(r.getNombre());          // escapa & y < automaticamente
                Element puntos = documento.createElement("puntos");
                puntos.setTextContent(String.valueOf(r.getPuntos()));
                registro.appendChild(nombre);
                registro.appendChild(puntos);
                raiz.appendChild(registro);
            }

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "ranking.dtd");

            transformer.transform(new DOMSource(documento), new StreamResult(new File(ruta)));
            return true;
        } catch (Exception e) {
            System.out.println("Error al guardar " + ruta + ": " + e);
            return false;
        }
    }
}
