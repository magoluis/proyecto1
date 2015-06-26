

package primerproyecto;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class generarhtml {
    
     public void Errores(ArrayList lista){
         
    int contador=1;
    int contador1=1;
    int contador2=1;
    char error;
        try{
     

            FileWriter archivo=new FileWriter("C:\\Users\\User\\Desktop\\lenguajes formales\\proyecto1.HTML");
            PrintWriter escribir=new PrintWriter(archivo);
     
            escribir.println("<html>");
            escribir.println("<body>");
             escribir.print("<img src=\"C:\\Users\\User\\Documents\\NetBeansProjects\\PrimerProyecto\\src\\primerproyecto\\usac.JPG\"  ALIGN=\"right\" width=\"300\" height=\"300\">");
            escribir.println("<h4><font color=green>UNIVERSIDAD DE SAN CARLOS DE GUATEMALA</font></h4>");
           escribir.println("<h4><font color=green>FACULTAD DE INGENIERIA</font></h4>");
            escribir.println("<h4><font color=green>ESCUELA DE CIENCIAS</font></h4>");
            escribir.println("<h4><font color=green>INGENIERIA EN CIENCIAS Y SISTEMAS</font></h4>");
            escribir.println("<h4><font color=green>LENGUAGES FORMALES DE PROGRAMACION</font></h4>");
             escribir.println("<h4></h4>");
              escribir.println("<h4></h4>");
               escribir.println("<h4></h4>");
               escribir.println("<h4></h4>");
                escribir.println("<h4>Archivo Fuente :<font color=Red> codigo.MSR</font></h4>");
                 escribir.println("<h4>Archivo salida :<font color=Red> proyecto1.HTML</font></h4>");
                
            
     
            
           
            escribir.println("<center>");
            escribir.println("<p>");
            escribir.println("<br>");
            escribir.println("</p>");
            escribir.println("<table border=4>");
            escribir.println("<tr>");
            escribir.println("<td><center><b>No.Token</b></center></td>");
            escribir.println("<td><center><b>Token</b></center></td>");
            escribir.println("<td><center><b>Lexema</b></center></td>");
            escribir.println("<td><center><b>Palabra Reservada</b></center></td>");
            escribir.println("<td><center><b>Tipo de Token</b></center></td>");
            
           
            escribir.println("</tr>");
         
        Lexema ver;
         for(int i=0;i<lista.size();i++){
             ver=(Lexema) lista.get(i);
           
            escribir.println("<tr>");
            escribir.println("<td><center><b>"+contador2+"</b></center></td>");
            escribir.println("<td><center><b>"+ver.getValor()+"</b></center></td>");
            escribir.println("<td><center><b>"+ver.tipotoken.toString()+"</b></center></td>");
           
            escribir.println("<td><center><b><font color=red>"+contador1+"</font></b></center></td>");
            escribir.println("<td><center><b>"+"Default"+"</b></center></td>");
            
            contador1++;
            
           contador2++;
          
            escribir.println("</tr>");
            }
          
         
            escribir.println("</center>");
            escribir.println("</body>");
            escribir.println("</html>");
            
            archivo.close();
            
            JOptionPane.showMessageDialog(null, "Reporte Generado exitosamente");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
   
     
      public void Listalex(ArrayList lista){
         
    int contador=1;
    int contador1=1;
    int contador2=1;
    char error;
        try{
     

            FileWriter archivo=new FileWriter("C:\\Users\\User\\Desktop\\lenguajes formales\\Lista1.HTML");
            PrintWriter escribir=new PrintWriter(archivo);
     
            escribir.println("<html>");
            escribir.println("<body>");
             escribir.print("<img src=\"C:\\Users\\User\\Documents\\NetBeansProjects\\PrimerProyecto\\src\\primerproyecto\\usac.JPG\"  ALIGN=\"right\" width=\"300\" height=\"300\">");
            escribir.println("<h4><font color=green>UNIVERSIDAD DE SAN CARLOS DE GUATEMALA</font></h4>");
           escribir.println("<h4><font color=green>FACULTAD DE INGENIERIA</font></h4>");
            escribir.println("<h4><font color=green>ESCUELA DE CIENCIAS</font></h4>");
            escribir.println("<h4><font color=green>INGENIERIA EN CIENCIAS Y SISTEMAS</font></h4>");
            escribir.println("<h4><font color=green>LENGUAGES FORMALES DE PROGRAMACION</font></h4>");
             escribir.println("<h4></h4>");
              escribir.println("<h4></h4>");
               escribir.println("<h4></h4>");
               escribir.println("<h4></h4>");
                escribir.println("<h4>Archivo Fuente :<font color=Red> codigo.MSR</font></h4>");
                 escribir.println("<h4>Archivo salida :<font color=Red> proyecto1.HTML</font></h4>");
                
            
     
            
           
            escribir.println("<center>");
            escribir.println("<p>");
            escribir.println("<br>");
            escribir.println("</p>");
            escribir.println("<table border=4>");
            escribir.println("<tr>");
            escribir.println("<td><center><b>No.Token</b></center></td>");
            escribir.println("<td><center><b>Token</b></center></td>");
            escribir.println("<td><center><b>Lexema</b></center></td>");
            escribir.println("<td><center><b>Palabra Reservada</b></center></td>");
            escribir.println("<td><center><b>Tipo de Token</b></center></td>");
            
           
            escribir.println("</tr>");
         
        Lexema1 ver;
         for(int i=0;i<lista.size();i++){
             ver=(Lexema1) lista.get(i);
           
            escribir.println("<tr>");
            escribir.println("<td><center><b>"+contador2+"</b></center></td>");
            escribir.println("<td><center><b>"+ver.tok.toString()+"</b></center></td>");
            escribir.println("<td><center><b>"+ver.getLexema()+"</b></center></td>");
           
            escribir.println("<td><center><b><font color=red>"+ver.reser.toString()+"</font></b></center></td>");
            escribir.println("<td><center><b>"+ver.tipo.toString()+"</b></center></td>");
            
            contador1++;
            
           contador2++;
          
            escribir.println("</tr>");
            }
          
         
            escribir.println("</center>");
            escribir.println("</body>");
            escribir.println("</html>");
            
            archivo.close();
            
            JOptionPane.showMessageDialog(null, "Reporte Generado exitosamente");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
