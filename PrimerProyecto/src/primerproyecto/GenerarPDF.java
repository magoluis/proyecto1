

package primerproyecto;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.sun.jmx.snmp.BerDecoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static primerproyecto.Analizador1.lista1;




public class GenerarPDF {
     String aux1 ;
       String aux2;
       String aux3;
       int estado=0;
       String rut;
     encabezado en=new encabezado();  
     int contador=0;
      
       
    
   
  //Ruta del archivo, esto es dentro del proyecto Netbeans
  public  String archivo=("C:\\Users\\User\\Desktop\\lenguajes formales\\Arbol.pdf");
 
  public void createPdf() throws BadElementException, IOException{
    /*Declaramos documento como un objeto Document
     *Asignamos el tamaño de hoja y los margenes 
    */    
    Document documento = new Document(PageSize.LETTER, 80, 80, 75, 75);
 
    //writer es declarado como el método utilizado para escribir en el archivo
    PdfWriter writer = null;
 
    try {      
      //Obtenemos la instancia del archivo a utilizar
      writer = PdfWriter.getInstance(documento, new FileOutputStream(archivo));
    } catch (FileNotFoundException|DocumentException ex) {
      ex.getMessage();
    }
 
    //Agregamos un titulo al archivo
    documento.addTitle("Archivo pdf generado desde Java");
 
    //Agregamos el autor del archivo
    documento.addAuthor("hug0");
 
    //Abrimos el documento para edición
    documento.open();
    infoencabezado in;
    for(int i=0;i<encabezado.info.size();i++){
        in=(infoencabezado) encabezado.info.get(i);
        
        
     Font fuente=new Font();
     
     if(in.ne.equals("ON")&&in.cu.equals("OFF")&&in.sub.equals("OFF")){
          fuente.setStyle(Font.BOLD);
     }
     else if(in.ne.equals("OFF")&&in.cu.equals("ON")&&in.sub.equals("OFF")){
          fuente.setStyle(Font.ITALIC);
     }
     else if(in.ne.equals("OFF")&&in.cu.equals("OFF")&&in.sub.equals("ON")){
          fuente.setStyle(Font.UNDERLINE);
     }
     else  if(in.ne.equals("ON")&&in.cu.equals("ON")&&in.sub.equals("ON")){
          fuente.setStyle(Font.UNDERLINE |Font.BOLD |Font.ITALIC);
     }
     else   if(in.ne.equals("ON")&&in.cu.equals("ON")&&in.sub.equals("OFF")){
          fuente.setStyle(Font.BOLD |Font.ITALIC);
     }
     else     if(in.ne.equals("ON")&&in.cu.equals("OFF")&&in.sub.equals("ON")){
          fuente.setStyle(Font.UNDERLINE |Font.BOLD);
     }
     else  if(in.ne.equals("OFF")&&in.cu.equals("OFF")&&in.sub.equals("OFF")){
          fuente.setStyle(Font.NORMAL);
     }
           else {
                 fuente.setStyle(Font.BOLDITALIC);
            }
  //  fuente.setStyle(Font.UNDERLINE |Font.BOLD |Font.ITALIC);
    fuente.setSize(17);
   
    
//Declaramos un texto como Paragraph
    //Le podemos dar formado como alineación, tamaño y color a la fuente.
    Paragraph parrafo = new Paragraph();
     parrafo.setAlignment(Paragraph.ALIGN_LEFT);
      parrafo.add(new Paragraph("Universidad De San Carlos",fuente));
       parrafo.add(new Paragraph("Facultad De Ingenieria",fuente));
        parrafo.add(new Paragraph("Escuela De ciencias",fuente));
  parrafo.add(new Paragraph("Ciencias y Sistemas",fuente));
 parrafo.add(new Paragraph("Lenguajes Formales De Programacion",fuente)); 
  parrafo.add(new Paragraph("\n"));
   parrafo.setAlignment(Paragraph.ALIGN_CENTER);
  parrafo.add(new Paragraph(in.tex,fuente));
   
    
    
    
      Image imagen = Image.getInstance("C:\\Users\\User\\Desktop\\lenguajes formales\\usac.JPG");
       imagen.setAbsolutePosition(500f, 650f);
     imagen.scaleAbsolute(Integer.parseInt(in.x),Integer.parseInt(in.y));
      
 
    try
{
    Image foto = Image.getInstance("C:\\Users\\User\\Desktop\\lenguajes formales\\Grafica1.jpg");
    foto.scaleToFit(300, 300);
    foto.setAlignment(Chunk.ALIGN_TOP);
    foto.setAbsolutePosition(160f, 150f);
    documento.add(foto);
}
catch ( Exception e )
{
    e.printStackTrace();
}
   // imagen.setAlignment(Element.ALIGN_CENTER);
     
    
    try {
      //Agregamos el texto al documento
      documento.add(parrafo);
      documento.add(imagen);
    } catch (DocumentException ex) {
      ex.getMessage();
    
    
    }
    break;
    }
    documento.close(); //Cerramos el documento
    writer.close(); //Cerramos writer
  
   
}
}