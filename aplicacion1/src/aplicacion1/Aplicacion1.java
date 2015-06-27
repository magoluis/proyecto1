/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion1;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Aplicacion1 {
    
   static  ArrayList lista1=new ArrayList();
  static  ArrayList lista2=new ArrayList();
  static String valor="luis";
   
    
    public static void variable(){
    lista1.add("x1");
    lista1.add(",");
    lista1.add("x3");
    lista1.add("x4");
    lista1.add(":");
    lista1.add("entero");
    lista1.add("=");
    
    }
    
   public static String recorer(){
       String aux = "";
       String valor="";
       for(int i=0;i<lista1.size();i++){
           valor=(String) lista1.remove(i);
          
           
       }
        return aux+=valor;
   }
   
   
   public static void agregar (String dato){
       System.out.println("listar "+dato);
   }

    public static void main(String[] args) {
      
        variable();
        agregar(recorer());
        
        
        
     
    }
    
}
