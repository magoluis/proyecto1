

package primerproyecto;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;


public class creararbol {
    
  static  ArrayList arb=new ArrayList();
   static ArrayList relacion=new ArrayList();
           
    
    public void agregaren(String i,String n,String e,String p){
           arbol nuevo=new arbol(i,n,e,p);
           arb.add(nuevo);
       }
       
       public void info(){
           String ru1="";
           String x1="";
           String y1="";
           String tx1="";
           Lexema1 ver;
           int estado=0;
           
           for(int i=0;i<Analizador1.lista1.size();i++){
               ver=(Lexema1) Analizador1.lista1.get(i);
               
           switch(estado){
               
               case 0:
                   
           
           if(ver.valor.equals("P4")){
                ru1=ver.lexema;
                break;
           }
           else if(ver.valor.equals("P7")){
                   x1=ver.lexema;
                   break;
           }
               else if(ver.valor.equals("P11")){
                        y1=ver.lexema;
                        break;
               }            
               else if(ver.valor.equals("P15")){
                           tx1=ver.lexema;
                           break;
               }        
              
               else if(ver.valor.equals("AC")){
                     this.agregaren(ru1, x1, y1,tx1);
                   estado=0;
               
                   break;
               }
                         else {
                
                                    
                               }
       
       
           }
     
    
    
}
       }
       
       
       public void mostrarArbol(){
           arbol a;
           for(int i=0;i<arb.size();i++){
              a=(arbol) arb.get(i);
               System.out.println("ID :"+a.id+" nombre :"+a.nombre+" edad :"+a.edad+" parentesco :"+a.parentesco);
               
           }
       }
       
       
        public void mostrar(){
            
          FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("C:\\Users\\User\\Desktop\\lenguajes formales\\pruebaA1.txt");
            pw = new PrintWriter(fichero);
             
               
           
pw.println("digraph grafica{");
pw.println("rankdir=TB;");
pw.println("node [color= lightblue2, style=filled, fillcolor=seashell2];");
arbol a;
int contador=1;
           for(int i=0;i<arb.size();i++){
              a=(arbol) arb.get(i);
               System.out.println("ID :"+a.id+" nombre :"+a.nombre+" edad :"+a.edad+" parentesco :"+a.parentesco);

pw.println("nodo"+Integer.toString(contador)+" [ "+"label "+"="+"\""+a.id+"\""+"+"+"\""+"\\n"+"\""+"+"+a.nombre+"+"+"\""+"\\n"+"\""+"+"+"\""+a.edad+"\""+"+"+"\""+"\\n"+"\""+"+"+"\""+a.parentesco+"\""+"];"+"\n");
contador++;
           }
pw.println("nodo1:C0->nodo3");
pw.println("nodo1:C1->nodo4");
pw.println("nodo2:C0->nodo3");
pw.println("nodo2:C1->nodo4");
pw.println("nodo3:C0->nodo4");
pw.println("nodo4:C1->nodo3");
pw.println("}");            
          //  for (int i = 0; i < 10; i++)
                   //   pw.println("Linea " + i);
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    
       
       
        }
        
        
        
         public void relac(){
           String ru1="";
           String x1="";
           String y1="";
           String tx1="";
           Lexema1 ver;
           int estado=0;
          
           
           for(int i=0;i<Analizador1.lista1.size();i++){
               ver=(Lexema1) Analizador1.lista1.get(i);
               
           switch(estado){
               
               case 0:
                   
           
           if(ver.valor.equals("H1")){
                relacion.add(ver.lexema);
                break;
           }
           else if(ver.valor.equals("PH1")){
                   relacion.add(ver.lexema);
                   break;
           }
               else if(ver.valor.equals("HR1")){
                       relacion.add(ver.lexema);
                        break;
               }            
               else if(ver.valor.equals("HP1")){
                           relacion.add(ver.lexema);
                           break;
               }        
              
               else if(ver.lexema.equals("}")){
                     this.agregaren(ru1, x1, y1,tx1);
                   estado=0;
               
                   break;
               }
                         else {
                
                                    
                               }
       
       
           }
     
    
    
}
       }
         
         
         public void mostrarrelacion(){
             String var;
             for(int i=0;i<relacion.size();i++){
                 var=(String) relacion.get(i);
                 System.out.println(i+var);
             }
         }
        
        
        
       
    
}
