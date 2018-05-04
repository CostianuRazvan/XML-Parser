/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.parser;

import Models.Comenzi;
import Models.Furnizor;
import Models.Produs;
import Validation.MyValidationEventHandler;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author razvan.costianu
 */
public class XMLParser {
    
    private static String[] columns = {"Furnizori", "NumeProdus", "Lot", "Data Expirare","Bucati","Unitate de masura"};
    private static Comenzi comenzi;
    /**
     * @param args the command line arguments
     */
    public static String parsare() {
        String output = "";
        try {
            
                SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); 
                Schema schema = sf.newSchema(new File("C:\\Users\\razvan.costianu\\Desktop\\xml\\XML-Parser\\XML-Parser\\src\\xml\\parser\\validation.xsd")); 
            
               
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Comenzi.class);
                XMLInputFactory xif = XMLInputFactory.newFactory();
                xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);
                XMLStreamReader xsr = xif.createXMLStreamReader(new StreamSource("C:\\Users\\razvan.costianu\\Desktop\\xml\\XML-Parser\\XML-Parser\\src\\xml\\parser\\furnizori.xml"));
                
                
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                jaxbUnmarshaller.setSchema(schema);
                jaxbUnmarshaller.setEventHandler(new MyValidationEventHandler());
		comenzi = (Comenzi) jaxbUnmarshaller.unmarshal(xsr);
                output += comenzi.toString();

	      } catch (Exception e) {
		e.printStackTrace();
	      }
        return output;
    }
    
    public static void viewXSL() {
        try{
      // Create Transformer
        TransformerFactory tf = TransformerFactory.newInstance();
        StreamSource xslt = new StreamSource(
                "C:\\Users\\razvan.costianu\\Desktop\\xml\\XML-Parser\\XML-Parser\\src\\xml\\parser\\furnizori.xsl");
        Transformer transformer = tf.newTransformer(xslt);
        // Source
        JAXBContext jc = JAXBContext.newInstance(Comenzi.class);
        JAXBSource source = new JAXBSource(jc, comenzi);
        File htmlFile = new File("C:\\Users\\razvan.costianu\\Desktop\\xml\\XML-Parser\\XML-Parser\\src\\xml\\parser\\furnizori.html");
        // Result
        StreamResult result = new StreamResult(htmlFile);
         
        
        // Transform
        transformer.transform(source, result);
        Desktop.getDesktop().browse(htmlFile.toURI());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
        

   }
    

