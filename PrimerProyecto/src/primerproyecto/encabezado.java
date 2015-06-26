/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package primerproyecto;

import java.util.ArrayList;
import java.util.Stack;


public class encabezado {
    
    String aux1;
    String aux2;
    String aux3;
    String aux4;
    String aux5;
    String aux6;
    String aux7;
    
    
  static  ArrayList info=new ArrayList();
    
            public String ruta(){
           Lexema1 ver;
           for(int i=0;i<Analizador1.lista1.size();i++){
               ver=(Lexema1) Analizador1.lista1.get(i);
               
               if(ver.valor.equals("E13")){
                   
                  aux1=ver.lexema; 
                   return aux1;
               }
           }
           
         return null;        
          
       }
      public String formatox(){
           Lexema1 ver;
           for(int i=0;i<Analizador1.lista1.size();i++){
               ver=(Lexema1) Analizador1.lista1.get(i);
               
               if(ver.valor.equals("X")){
                   
                  aux2=ver.lexema; 
                   return aux2;
               }
           }
           
         return null;        
          
       }
       public String formatoy(){
           Lexema1 ver;
           for(int i=0;i<Analizador1.lista1.size();i++){
               ver=(Lexema1) Analizador1.lista1.get(i);
               
               if(ver.valor.equals("Y")){
                   
                  aux3=ver.lexema; 
                   return aux3;
               }
           }
           
         return null;        
          
       }
       public String Tex(){
           Lexema1 ver;
           for(int i=0;i<Analizador1.lista1.size();i++){
               ver=(Lexema1) Analizador1.lista1.get(i);
               
               if(ver.valor.equals("E22")){
                   
                  aux4=ver.lexema; 
                   return aux4;
               }
           }
           
         return null;        
          
       }
       public String Neg(){
           Lexema1 ver;
           for(int i=0;i<Analizador1.lista1.size();i++){
               ver=(Lexema1) Analizador1.lista1.get(i);
               
               if(ver.valor.equals("E32")){
                   
                  aux5=ver.lexema; 
                   return aux5;
               }
           }
           
         return null;        
          
       }
       public String Cur(){
           Lexema1 ver;
           for(int i=0;i<Analizador1.lista1.size();i++){
               ver=(Lexema1) Analizador1.lista1.get(i);
               
               if(ver.valor.equals("E42")){
                   
                  aux6=ver.lexema; 
                   return aux6;
               }
           }
           
         return null;        
          
       }
       public String Sub(){
           Lexema1 ver;
           for(int i=0;i<Analizador1.lista1.size();i++){
               ver=(Lexema1) Analizador1.lista1.get(i);
               
               if(ver.valor.equals("E52")){
                   
                  aux7=ver.lexema; 
                   return aux7;
               }
           }
           
         return null;        
          
       }
       public void agregaren(String ru,String xx,String yy,String tt,String nn,String cc,String ss){
           infoencabezado nuevo=new infoencabezado(ru, xx, yy,tt, nn, cc, ss);
           info.add(nuevo);
       }
       
       public void info(){
           String ru1="";
           String x1="";
           String y1="";
           String tx1="";
           String ne1="";
           String cur1="";
           String sub1="";
           Lexema1 ver;
           int estado=0;
           for(int i=0;i<Analizador1.lista1.size();i++){
               ver=(Lexema1) Analizador1.lista1.get(i);
               
           switch(estado){
               
               case 0:
                   
           
           if(ver.valor.equals("E13")){
                ru1=ver.lexema;
                break;
           }
           else if(ver.valor.equals("X")){
                   x1=ver.lexema;
                   break;
           }
               else if(ver.valor.equals("Y")){
                        y1=ver.lexema;
                        break;
               }            
               else if(ver.valor.equals("E22")){
                           tx1=ver.lexema;
                           break;
               }        
               else if(ver.valor.equals("E32")){
                               ne1=ver.lexema;
                               break;
               } 
               else if(ver.valor.equals("E42")){
                               cur1=ver.lexema;
                               break;
               } 
               else if(ver.valor.equals("E52")){
                               sub1=ver.lexema;
                               break;
               } 
               else if(ver.lexema.equals("}")){
                      this.agregaren(ru1, x1, y1, tx1,ne1, cur1, sub1);
                   estado=0;
               
                   break;
               }
                         else {
                
                                    
                               }
       
       
           }
     
    
    
}
       }
       
       

       
}