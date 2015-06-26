
package primerproyecto;

import java.util.ArrayList;
import primerproyecto.Lexema.Tipo;
import primerproyecto.Lexema1.Tipotoken;
import primerproyecto.Lexema1.palabrareservada;
import primerproyecto.Lexema1.token;


public class Analizador1 {
    String auxLex;
    int contador;
    int estado=0;
    int contador1;
    int contador3;
    static ArrayList listaT=new ArrayList();
    static ArrayList lista1=new ArrayList();
   int contadorvar=0;
  
    public void addtoken1(token to, String lexem,palabrareservada rese,Tipotoken tip, String val){
        
        Lexema1 nuevo1=new Lexema1(to,lexem,rese,tip,val);
        lista1.add(nuevo1);
    }
    
    public void addtoken(Tipo tip,String valor){
        
        Lexema nuevo=new Lexema(tip,valor);
        listaT.add(nuevo);
  
    }
    
     public void analizar(String entrada){
       entrada= entrada +"#";
       auxLex="";
       char c;
       
       for(int i=0;i<entrada.length();i++){
           c=entrada.charAt(i);
           int codigotabla=c;
           switch(estado){

/*------------------------------------------------------estado_inicial---------------------------------*/               
               
               case 0:
               if(Character.isLetter(c)){
                   estado=1;
                   auxLex+=c;
               }
               else if(Character.isDigit(c)){
                   estado=2;
                   auxLex+=c;
               }
               else if(codigotabla==58){
                   estado=0;
                   auxLex+=c;
                   addtoken(Tipo.DOS_PUNTOS, auxLex);
                   auxLex="";
               }
               else if(codigotabla==123){
                   estado=0;
                   auxLex+=c;
                   addtoken(Tipo.LLAVE_INICIAL, auxLex);
                   auxLex="";
               }
               else if(codigotabla==34){
                   estado=4;
                   auxLex+=c;
                   //addtoken(Tipo.COMILLAS, auxLex);
                   //auxLex="";
                  
               }
              // else if(codigotabla==47){
                //   estado=0;
                //   auxLex+=c;
                //   addtoken(Tipo.BARRA, auxLex);
                //   auxLex="";
           //    }
               else if(codigotabla==46){
                   estado=0;
                   auxLex+=c;
                   addtoken(Tipo.PUNTO, auxLex);
                   auxLex="";
                   
               }
               else if(codigotabla==44){
                   estado=0;
                   auxLex+=c;
                   addtoken(Tipo.COMA, auxLex);
                   auxLex="";
               }
               else if(codigotabla==59){
                   estado=0;
                   auxLex+=c;
                   addtoken(Tipo.PUNTO_COMA, auxLex);
                   auxLex="";
               }
               else if(codigotabla==125){
                   estado=0;
                   auxLex+=c;
                   addtoken(Tipo.LLAVE_FINAL, auxLex);
                   auxLex="";
               }
               else if(codigotabla==39){
                   estado=8;
                   auxLex+=c;
                 //  addtoken(Tipo.APOSTOFRE, auxLex);
                 //  auxLex="";
               }
               else if(codigotabla==40){
                   estado=0;
                   auxLex+=c;
                   addtoken(Tipo.PARENTESIS_INICIAL, auxLex);
                   auxLex="";
               }
               else if(codigotabla==41){
                   estado=0;
                   auxLex+=c;
                   addtoken(Tipo.PARENTESIS_FINAL, auxLex);
                   auxLex="";
               }
               else if(codigotabla==61){
                   estado=0;
                   auxLex+=c;
                   addtoken(Tipo.SIGNO_IGUAL, auxLex);
                   auxLex="";
               }
               else if(c=='\n'){
                   estado=0;
                   auxLex="";
                   contador1++;
               }
               else if(codigotabla==32){
                   estado=0;
                   auxLex="";    
               }
               
               else{
                   addtoken1(token.ERROR,Character.toString(c), palabrareservada.NO, Tipotoken.ERROR_LEXICO,"e");
                   addtoken(Tipo.ERROR,Character.toString(c));
                   System.out.println("Error lexico----->"+c);
                   
               }break;
               
  /*---------------------------------------------------------------------------estado_1------------------*/ 
                   
                          
               case 1:
                   if(Character.isLetter(c)){
                       estado=1;
                      auxLex+=c; 
                   }
                   else if(Character.isDigit(c)){
                       estado=3;
                       auxLex+=c;
                   }
                   else{
                       addtoken(Tipo.LETRA, auxLex);
                       auxLex="";
                       estado=0;
                       i--;
                   }break;
  /*----------------------------------------------------------------------------estado_2--------------------------*/                 
                   
               case 2:
                   if(Character.isDigit(c)){
                       estado=2;
                       auxLex+=c;
                   }else{
                       addtoken(Tipo.NUMERO_ENTERO, auxLex);
                       auxLex="";
                       estado=0;
                       i--;
                   }break;
/*-----------------------------------------------------------------------estado_3--------------------*/
               case 3:
                   if(Character.isDigit(c)){
                       auxLex+=c;
                   }else {
                       addtoken(Tipo.VARIABLE_UNO, auxLex);
                       auxLex="";
                       estado=0;
                       i--;
                   }break;
   /*----------------------------------------------------------------estado_4----------------*/          
               case 4:
                   if(Character.isLetter(c)){
                       estado=4;
                       auxLex+=c;
                       
                   }
                   else if(Character.isDigit(c)){
                           estado=4;
                           auxLex+=c;
                           }
                   else if(codigotabla==58){
                       estado=6;
                       auxLex+=c;
                   }
                  
                   else if(codigotabla>=35 && codigotabla<=47){
                           estado=4;
                           auxLex+=c;
                           }
                   else if(c==' '){
                       estado=4;
                       auxLex+=c;
                   }
                   
                   else if(codigotabla==92){
                       estado=4;
                       auxLex+=c;
                   }
                       
                   else{
                       estado=5;
                       auxLex+=c;
                   }break;
               case 5:
                   if(codigotabla==34){
                       auxLex+=c;
                   }else{
                       addtoken(Tipo.NOMBRE, auxLex);
                       auxLex="";
                       estado=0;
                       i--;
                   }break;
               case 6:
                     if(Character.isLetter(c)){
                       estado=6;
                       auxLex+=c;
                       
                   }
                   else if(Character.isDigit(c)){
                           estado=6;
                           auxLex+=c;
                           }
                   else if(codigotabla==58){
                       estado=6;
                       auxLex+=c;
                   }
                  
                   else if(codigotabla>=35 && codigotabla<=47){
                           estado=6;
                           auxLex+=c;
                           }
                   else if(c==' '){
                       estado=6;
                       auxLex+=c;
                   }
                      else if(codigotabla==92){
                       estado=6;
                       auxLex+=c;
                   }
                   else{
                       estado=7;
                      auxLex+=c;
                   }break;
                   
                   case 7:
                   if(codigotabla==34){
                       auxLex+=c;
                   }else{
                       addtoken(Tipo.RUTA, auxLex);
                       auxLex="";
                       estado=0;
                       i--;
                   }break;
                       
                   case 8:
                       if(Character.isLetter(c)){
                           estado=8;
                           auxLex+=c;
                           
                       }else if(codigotabla==39){
                           estado=9;
                           auxLex+=c;
     
                       }
                       break;
                
                  case 9:
                       if(codigotabla==39){
                           auxLex+=c;
                       }else{
                       
                           addtoken(Tipo.TEXTO, auxLex);
                          auxLex="";
                           estado=0;
                           i--;
                       }break;
                   
               
           }
           contador1++;
       }
   }
     
     public void verificarpal(){
         int estado=0;
         Lexema ver;
         
         for(int i=0;i<listaT.size();i++){
             ver=(Lexema) listaT.get(i);
             
             switch(estado){
             
                 case 0:
             
             if(ver.getValor().equals("ENCABEZADO")){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.SI, Tipotoken.SEGMENTO,"A1");
             }
             else if(ver.getValor().equals("{")){
                 addtoken1(token.LLAVE_ABIERTA,ver.getValor(), palabrareservada.NO, Tipotoken.LLAVE,"A2");
                 
             }else if(ver.getValor().equals("Imagen")){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.SI, Tipotoken.FORMATO,"A3");
             }else if(ver.getValor().equals(":")){
                 addtoken1(token.DOS_PUNTOS,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"A4");
             }else if(ver.getValor().equals("(")){
                 addtoken1(token.PARENTESIS_ABIERTO,ver.getValor(), palabrareservada.NO, Tipotoken.PARENTESIS,"A5");
             }
             else if(ver.tipotoken.equals(Tipo.RUTA)){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.NO, Tipotoken.RUTA,"A6");
                 estado=1;
                 break;
             }
             //else if(ver.getValor().equals(",")){
             //    addtoken1(token.COMA,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"A7");
             //    estado=1;   
             //   break;
           //  }
             else if(ver.getValor().equals(")")){
                 addtoken1(token.PARENTESIS_CERRADO,ver.getValor(), palabrareservada.NO, Tipotoken.PARENTESIS,"A8");
             }else if(ver.getValor().equals(";")){
                 addtoken1(token.PUNTO_COMA,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"A9");
             }else if(ver.getValor().equals("Texto")){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.SI, Tipotoken.FORMATO,"AT");
                 estado=3;
               break;
             }
             
             
             
             
             
             
             
             else if(ver.getValor().equals("Negrita")){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.SI, Tipotoken.FORMATO,"A10");
             }else if(ver.getValor().equals("ON")){
                 addtoken1(token.ID, ver.getValor(), palabrareservada.NO, Tipotoken.PARAMETRO_V,"A11");
             }else if(ver.getValor().equals("Cursiva")){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.SI, Tipotoken.FORMATO,"A12");
             }else if(ver.getValor().equals("OFF")){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.NO, Tipotoken.PARAMETRO_F, "A13");
             }else if(ver.getValor().equals("Subrayado")){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.SI, Tipotoken.FORMATO, "A14");
             }else if(ver.getValor().equals("}")){
                 addtoken1(token.LLAVE_CERRADA,ver.getValor(), palabrareservada.NO, Tipotoken.LLAVE,"A15");
                 
             }
       /*----------------------------------------------------------------encabezado--------------------------------*/  
             else if(ver.getValor().equals("VARIABLES")){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.SI, Tipotoken.SEGMENTO,"A16");
             }
             else if(ver.tipotoken.equals(Tipo.VARIABLE_UNO)){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.NO, Tipotoken.VARIABLE, "A17");
             }else if(ver.getValor().equals("entero")){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.SI, Tipotoken.ASIGNACION_N,"A18");
             }else if(ver.getValor().equals("=")){
                 addtoken1(token.IGUAL, ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO, "A19");
             }
             else if(ver.tipotoken.equals(Tipo.NUMERO_ENTERO)){
                 addtoken1(token.ENTERO,ver.getValor(), palabrareservada.NO, Tipotoken.PARAMETRO, "A20");
             }else if(ver.getValor().equals("cadena")){
                 addtoken1(token.ID, ver.getValor(), palabrareservada.SI, Tipotoken.ASIGNACION_L, "A21");
             }else if(ver.tipotoken.equals(Tipo.TEXTO)){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.NO, Tipotoken.PARAMETRO,"A22");
             }else if(ver.getValor().equals("ARBOL")){
                 addtoken1(token.ID, ver.getValor(), palabrareservada.SI, Tipotoken.SEGMENTO, "A23");
             }else if(ver.getValor().equals("Persona")){
                 addtoken1(token.ID, ver.getValor(), palabrareservada.SI, Tipotoken.SUB_SEGMENTO,"A24");
             }else if(ver.getValor().equals("id")){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.SI, Tipotoken.VARIABLE,"A25");
             }else if(ver.getValor().equals("nombre")){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.SI, Tipotoken.VARIABLE, "A26");
             }else if(ver.tipotoken.equals(Tipo.NOMBRE)){
                 addtoken1(token.ID, ver.getValor(), palabrareservada.NO, Tipotoken.PARAMETRO,"A27");
                 
             }else if(ver.getValor().equals("edad")){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.SI, Tipotoken.PARAMETRO,"A28");
             }else if(ver.getValor().equals("parentesco")){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.SI, Tipotoken.PARAMETRO,"A29");
             }else if(ver.getValor().equals("Relacion")){
                     addtoken1(token.ID,ver.getValor(), palabrareservada.SI, Tipotoken.SUB_SEGMENTO,"A30");
                 }else if(ver.getValor().equals("hijos")){
                     addtoken1(token.ID,ver.getValor(), palabrareservada.SI, Tipotoken.PARAMETRO,"A31");
                 }else if(ver.getValor().equals("hermano")){
                     addtoken1(token.ID, ver.getValor(), palabrareservada.SI, Tipotoken.PARAMETRO,"A32");
                 }else if(ver.tipotoken.equals(Tipo.ERROR)){
                     addtoken1(token.ERROR,ver.getValor(), palabrareservada.NO, Tipotoken.ERROR_LEXICO, "AE");
                 }
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 case 1:
                     if(ver.tipotoken.equals(Tipo.NUMERO_ENTERO)){
                         addtoken1(token.ENTERO,ver.getValor(), palabrareservada.NO, Tipotoken.PARAMETRO,"A11");
                         
                     }else if(ver.getValor().equals(",")){
                         addtoken1(token.ID,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"A12");
                         estado=2;
                     }break;
                     
                 case 2:
                     if(ver.tipotoken.equals(Tipo.NUMERO_ENTERO)){
                         addtoken1(token.ENTERO,ver.getValor(), palabrareservada.NO, Tipotoken.PARAMETRO,"A12");
                         
                     }else{
                         estado=0;
                         i--;
                     }break;
                 
                 case 3:
                     if(ver.tipotoken.equals(Tipo.NOMBRE)){
                         addtoken1(token.ID,ver.getValor(), palabrareservada.NO, Tipotoken.FORMATO, "ET");
                         
                     }else{
                         estado=0;
                        
                     }break;
                     
         }       
         }
     }
     
     
     public void veri2(){
          int estado=0;
         Lexema ver;
         
         for(int i=0;i<listaT.size();i++){
             ver=(Lexema) listaT.get(i);
             
             switch(estado){
                 case 0:
                     if(ver.getValor().equals("ENCABEZADO")){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.SI, Tipotoken.SEGMENTO,"E");
                 estado=1;
                 break;
             } 
                     
                         else if(ver.getValor().equals("VARIABLES")){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.SI, Tipotoken.SEGMENTO,"V");
                 estado=29;
                 break;
             
                     }
                 else if(ver.getValor().equals("ARBOL")){
                 addtoken1(token.ID, ver.getValor(), palabrareservada.SI, Tipotoken.SEGMENTO, "A");
                 estado=44;
                 break;
             }break;
                     
                     
                 
                 case 1:
                       if(ver.getValor().equals("{")){
                 addtoken1(token.LLAVE_ABIERTA,ver.getValor(), palabrareservada.NO, Tipotoken.LLAVE,"EA");
                 estado=2;
                 break;
                       }break;
                 
                 
                     
                 case 2:
                      
             if(ver.getValor().equals("Imagen")){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.SI, Tipotoken.FORMATO,"E1");
                 estado=3;
                 break;
             }
              else if(ver.getValor().equals("Texto")){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.SI, Tipotoken.FORMATO,"E2");
               estado=13;
               break;
             }
              else if(ver.getValor().equals("Negrita")){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.SI, Tipotoken.FORMATO,"E3");
                 estado=17;
                 break;
             }
              else if(ver.getValor().equals("Cursiva")){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.SI, Tipotoken.FORMATO,"E4");
                 estado=21;
                 break;
             }
               else if(ver.getValor().equals("Subrayado")){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.SI, Tipotoken.FORMATO, "E5");
                 estado=25;
                 break;
             }
               else if(ver.getValor().equals("}")){
                 addtoken1(token.LLAVE_CERRADA,ver.getValor(), palabrareservada.NO, Tipotoken.LLAVE,"EC");
                 estado=0;
                 break;
             }
 
               
                 case 3:       
                if(ver.getValor().equals(":")){ 
                 addtoken1(token.DOS_PUNTOS,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"E11");
                 estado=4;
                 break;
             }
                 case 4:
                   if(ver.getValor().equals("(")){
                 addtoken1(token.PARENTESIS_ABIERTO,ver.getValor(), palabrareservada.NO, Tipotoken.PARENTESIS,"E12");
                  estado=5;
                 break;
             }break;  
                     
                 case 5:
                     
                       if(ver.tipotoken.equals(Tipo.RUTA)){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.NO, Tipotoken.RUTA,"E13");
                estado=6;
                break;
             }
                      
                       break;
                     
                 case 6:
                     
                     if(ver.getValor().equals(",")){
                         addtoken1(token.ID,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"E14");
                         estado=8;
                       break;
                     }
                   break;
                 case 8:
                     
                      if(ver.tipotoken.equals(Tipo.NUMERO_ENTERO)){
                         addtoken1(token.ENTERO,ver.getValor(), palabrareservada.NO, Tipotoken.PARAMETRO,"X"); 
                         estado=9;
                         break;
                     }break;
                     
                 case 9:
                     
                     if(ver.getValor().equals(",")){
                         addtoken1(token.ID,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"E15");
                         estado=10;
                       break;
                     }break;
                     
                 case 10:
                     
                      if(ver.tipotoken.equals(Tipo.NUMERO_ENTERO)){
                         addtoken1(token.ENTERO,ver.getValor(), palabrareservada.NO, Tipotoken.PARAMETRO,"Y");
                         estado=11;
                         break;
          
                     }break;
                 case 11:
                     if(ver.getValor().equals(")")){
                 addtoken1(token.PARENTESIS_CERRADO,ver.getValor(), palabrareservada.NO, Tipotoken.PARENTESIS,"E16");
                 estado=12;
                 break;
             }
                     
                 case 12:
                     if(ver.getValor().equals(";")){
                 addtoken1(token.PUNTO_COMA,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"E17");
             }else{
                         estado=2;
                         i--;
                     }break;
                     
                     
         /*---------------------------------------------------------------------------*/            
                     
                 case 13:
                      if(ver.getValor().equals("(")){
                 addtoken1(token.PARENTESIS_ABIERTO,ver.getValor(), palabrareservada.NO, Tipotoken.PARENTESIS,"E21");
                  estado=14;
                 break;
             }break;  
                 case 14:
                      if(ver.tipotoken.equals(Tipo.NOMBRE)){
                         addtoken1(token.ID,ver.getValor(), palabrareservada.NO, Tipotoken.FORMATO, "E22");
                       estado=15;
   
                     }break;
                 case 15:
                      if(ver.getValor().equals(")")){
                 addtoken1(token.PARENTESIS_CERRADO,ver.getValor(), palabrareservada.NO, Tipotoken.PARENTESIS,"E23");
                 estado=16;
                 break;
                     
                      }break; 
                 case 16:
                      if(ver.getValor().equals(";")){
                 addtoken1(token.PUNTO_COMA,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"E24");
             }else{
                         estado=2;
                         i--;
                     }break;
                     
                     
    /*----------------------------------------------------------------------------*/     
                     
                 case 17:
                     if(ver.getValor().equals("(")){
                 addtoken1(token.PARENTESIS_ABIERTO,ver.getValor(), palabrareservada.NO, Tipotoken.PARENTESIS,"E31");
                  estado=18;
                 break;
             }break;  
                 case 18:
                     if(ver.tipotoken.equals(Tipo.LETRA)){
                 addtoken1(token.ID, ver.getValor(), palabrareservada.NO, Tipotoken.PARAMETRO_V,"E32");
                 estado=19;
                 break;
             }break;
                 case 19:
                     if(ver.getValor().equals(")")){
                 addtoken1(token.PARENTESIS_CERRADO,ver.getValor(), palabrareservada.NO, Tipotoken.PARENTESIS,"E34");
                 estado=20;
                 break;
                     
                      }break; 
                 case 20:
                     if(ver.getValor().equals(";")){
                 addtoken1(token.PUNTO_COMA,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"E35");
             }else{
                         estado=2;
                         i--;
                     }break;
                    
         /*-------------------------------------------------------------------------------------*/
                 case 21:
                    
                     if(ver.getValor().equals("(")){
                 addtoken1(token.PARENTESIS_ABIERTO,ver.getValor(), palabrareservada.NO, Tipotoken.PARENTESIS,"E41");
                  estado=22;
                 break;
             }break;  
                 case 22:
                     if(ver.tipotoken.equals(Tipo.LETRA)){
                 addtoken1(token.ID, ver.getValor(), palabrareservada.NO, Tipotoken.PARAMETRO_V,"E42");
                 estado=23;
                 break;
             }break;
                 case 23:
                     if(ver.getValor().equals(")")){
                 addtoken1(token.PARENTESIS_CERRADO,ver.getValor(), palabrareservada.NO, Tipotoken.PARENTESIS,"E43");
                 estado=24;
                 break;
                     
                      }break; 
                 case 24:
                     if(ver.getValor().equals(";")){
                 addtoken1(token.PUNTO_COMA,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"E44");
             }else{
                         estado=2;
                         i--;
                     }break;
                     
                     
         /*    ---------------------------------------------------------------------------*/
                     
                 case 25:
                    if(ver.getValor().equals("(")){
                 addtoken1(token.PARENTESIS_ABIERTO,ver.getValor(), palabrareservada.NO, Tipotoken.PARENTESIS,"E51");
                  estado=26;
                 break;
             }break;  
                 case 26:
                     if(ver.tipotoken.equals(Tipo.LETRA)){
                 addtoken1(token.ID, ver.getValor(), palabrareservada.NO, Tipotoken.PARAMETRO_V,"E52");
                 estado=27;
                 break;
             }break;
                 case 27:
                     if(ver.getValor().equals(")")){
                 addtoken1(token.PARENTESIS_CERRADO,ver.getValor(), palabrareservada.NO, Tipotoken.PARENTESIS,"E53");
                 estado=28;
                 break;
                     
                      }break; 
                 case 28:
                     if(ver.getValor().equals(";")){
                 addtoken1(token.PUNTO_COMA,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"E54");
             }else{
                         estado=2;
                         i--;
                     }break; 
                     
                     
      /*------------------------------------------------------------------------------------------*/
                     
                 case 29:
                     if(ver.getValor().equals("{")){
                 addtoken1(token.LLAVE_ABIERTA,ver.getValor(), palabrareservada.NO, Tipotoken.LLAVE,"VA");
                 estado=30;
                 break;
                       }break;
                     
                 case 30:
                        if(ver.tipotoken.equals(Tipo.VARIABLE_UNO)){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.NO, Tipotoken.VARIABLE,Integer.toString(contadorvar));
                 estado=30;
                 contadorvar++;
                 break;
                        }
                        else if(ver.getValor().equals(",")){
                         addtoken1(token.ID,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"A12");
                         estado=30;
                       break;
                     }
                 else if(ver.getValor().equals(":")){ 
                 addtoken1(token.DOS_PUNTOS,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"A4");
                 estado=32;
                 break;
             }
                    else if(ver.tipotoken.equals(Tipo.LETRA)){
                 addtoken1(token.ID, ver.getValor(), palabrareservada.NO, Tipotoken.PARAMETRO_V,"A11");
                 estado=36;
                 break;
                    }
                        else if(ver.getValor().equals("}")){
                 addtoken1(token.LLAVE_CERRADA,ver.getValor(), palabrareservada.NO, Tipotoken.LLAVE,"A15");
                 estado=0;
                 break;
             }break;
                     
                 
                 case 32:
                     if(ver.getValor().equals("entero")){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.SI, Tipotoken.ASIGNACION_N,"A18");
                 estado=33;
                 break;
             }   
                     else if(ver.getValor().equals("cadena")){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.SI, Tipotoken.ASIGNACION_L,"A18");
                 estado=41;
                 break;
             }break;
                 case 33:
                     
                if(ver.getValor().equals("=")){
                 addtoken1(token.IGUAL, ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO, "A19");
                 estado=34;
                 break;
             }break;
                 case 34:
                     
                 if(ver.tipotoken.equals(Tipo.NUMERO_ENTERO)){
                         addtoken1(token.ENTERO,ver.getValor(), palabrareservada.NO, Tipotoken.PARAMETRO,"A11");
                         estado=35;
                         break;
                     }break;
                     
                 case 35:
                     if(ver.getValor().equals(";")){
                 addtoken1(token.PUNTO_COMA,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"A9");
             }else{
                         estado=30;
                         i--;
                     }break; 
                     
                 case 36:
                      if(ver.getValor().equals(":")){ 
                 addtoken1(token.DOS_PUNTOS,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"A4");
                 estado=37;
                 break;
             }break;
                 case 37:
                  if(ver.getValor().equals("entero")){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.SI, Tipotoken.ASIGNACION_N,"A18");
                 estado=38;
                 break;
             } else if(ver.getValor().equals("cadena")){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.SI, Tipotoken.ASIGNACION_L,"A18");
                 estado=38;
                 break;
             }  break;  
                 case 38:
                     
                if(ver.getValor().equals("=")){
                 addtoken1(token.IGUAL, ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO, "A19");
                 estado=39;
                 break;
             } 
                else if(ver.getValor().equals(";")){
                 addtoken1(token.PUNTO_COMA,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"A9");
             }else{
                         estado=30;
                         i--;
                     }break; 
               
                 case 39:
                 if(ver.tipotoken.equals(Tipo.TEXTO)){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.NO, Tipotoken.PARAMETRO,"A22");
                 estado=40;
                 break;
             }break;
                 case 40:
                      if(ver.getValor().equals(";")){
                 addtoken1(token.PUNTO_COMA,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"A9");
             }else{
                         estado=30;
                         i--;
                     }break; 
                     
                 case 41:
                      if(ver.getValor().equals("=")){
                 addtoken1(token.IGUAL, ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO, "A19");
                 estado=42;
                 break;
             } 
                 case 42:
                     if(ver.tipotoken.equals(Tipo.TEXTO)){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.NO, Tipotoken.PARAMETRO,"A22");
                 estado=43;
                 break;
             }break;
                 case 43:
                     if(ver.getValor().equals(";")){
                 addtoken1(token.PUNTO_COMA,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"A9");
             }else{
                         estado=30;
                         i--;
                     }break; 
                     
                     
                     
  /*----------------------------------------------------------------------------------*/           
                 case 44:
                      if(ver.getValor().equals("{")){
                 addtoken1(token.LLAVE_ABIERTA,ver.getValor(), palabrareservada.NO, Tipotoken.LLAVE,"A2");
                 estado=45;
                 break;
                       }break;
                     
                 case 45:
                    if(ver.getValor().equals("Persona")){
                 addtoken1(token.ID, ver.getValor(), palabrareservada.SI, Tipotoken.SUB_SEGMENTO,"P");
                 estado=46;
                 break;
             } else if(ver.getValor().equals("Relacion")){
                     addtoken1(token.ID,ver.getValor(), palabrareservada.SI, Tipotoken.SUB_SEGMENTO,"A30");
                     estado=63;
                     break;
                 }
                    if(ver.getValor().equals("}")){
                 addtoken1(token.LLAVE_CERRADA,ver.getValor(), palabrareservada.NO, Tipotoken.LLAVE,"A15");
                 estado=0;
                 break;    
                 
                  }break;
                   
                     
                 case 46:
                     if(ver.getValor().equals(":")){ 
                 addtoken1(token.DOS_PUNTOS,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"A4");
                 estado=47;
                 break;
             }break;
                 case 47:
                     if(ver.getValor().equals("{")){
                 addtoken1(token.LLAVE_ABIERTA,ver.getValor(), palabrareservada.NO, Tipotoken.LLAVE,"P1");
                 estado=48;
                 break;
                       }break;
                     
                 case 48:
                    if(ver.getValor().equals("id")){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.SI, Tipotoken.VARIABLE,"P2");
                 estado=49;
                 break;  
             }break;
             
                 case 49:
                     if(ver.getValor().equals(":")){ 
                 addtoken1(token.DOS_PUNTOS,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"P3");
                 estado=50;
                 break;
             }break;
                 case 50:
                     if(ver.tipotoken.equals(Tipo.NUMERO_ENTERO)){
                         addtoken1(token.ENTERO,ver.getValor(), palabrareservada.NO, Tipotoken.PARAMETRO,"P4"); 
                         estado=51;
                         break;
                     }break;
                 case 51:
                      if(ver.getValor().equals("nombre")){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.SI, Tipotoken.VARIABLE, "P5");
                 estado=52;
                 break;
                 
             }break;
                 case 52:
                      if(ver.getValor().equals(":")){ 
                 addtoken1(token.DOS_PUNTOS,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"P6");
                 estado=53;
                 break;
             }break;
                 case 53:
                    if(ver.tipotoken.equals(Tipo.NOMBRE)){
                 addtoken1(token.ID, ver.getValor(), palabrareservada.NO, Tipotoken.PARAMETRO,"P7");
                 estado=54;
                 break;
             }break;
             
                 case 54:
             if(ver.getValor().equals(";")){
                 addtoken1(token.PUNTO_COMA,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"P8");
                 estado=55;
                 break;
             }break;
                 case 55:
                   if(ver.getValor().equals("edad")){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.SI, Tipotoken.PARAMETRO,"P9");
                 estado=77;
                 break;
                 
             } break;
                     
                 case 77:
                     if(ver.getValor().equals(":")){ 
                 addtoken1(token.DOS_PUNTOS,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"P10");
                 estado=56;
                 break;
             }break;
                     
                     
                     
                 case 56:
                      if(ver.tipotoken.equals(Tipo.NUMERO_ENTERO)){
                         addtoken1(token.ENTERO,ver.getValor(), palabrareservada.NO, Tipotoken.PARAMETRO,"P11"); 
                         estado=57;
                         break;
                     }break;
                     
                 case 57:
                     if(ver.getValor().equals(";")){
                 addtoken1(token.PUNTO_COMA,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"P12");
                 estado=58;
                 break;
             }break;
             
                 case 58:
                     
                 if(ver.getValor().equals("parentesco")){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.SI, Tipotoken.PARAMETRO,"P13");
                 estado=59;
                 break;
             }break;
                 case 59:
                     if(ver.getValor().equals(":")){ 
                 addtoken1(token.DOS_PUNTOS,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"P14");
                 estado=60;
                 break;
             }break;
                 case 60:
                     
                  if(ver.tipotoken.equals(Tipo.LETRA)){
                 addtoken1(token.ID, ver.getValor(), palabrareservada.NO, Tipotoken.PARAMETRO_V,"P15");
                 estado=60;
                 break;
                    } else if(ver.getValor().equals(",")){
                         addtoken1(token.ID,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"P16");
                         estado=60;
                         break;
                     }else{
                        estado=61;
                        i--;
                        
                    }break;
                     
                     
                 
                 case 61:
                     if(ver.getValor().equals(";")){
                 addtoken1(token.PUNTO_COMA,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"A9");
                 estado=62;
                 break;
             }break;
                 case 62:
                  if(ver.getValor().equals("}")){
                 addtoken1(token.LLAVE_CERRADA,ver.getValor(), palabrareservada.NO, Tipotoken.LLAVE,"AC");
                 estado=45;
                
                 break;    
                 
                  }break;
                     
                     
                 case 63:
                     if(ver.getValor().equals(":")){ 
                 addtoken1(token.DOS_PUNTOS,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"A4");
                 estado=64;
                 break;
             }break;
                     
                 case 64:
             
             if(ver.getValor().equals("{")){
                 addtoken1(token.LLAVE_ABIERTA,ver.getValor(), palabrareservada.NO, Tipotoken.LLAVE,"A2");
                 estado=65;
                 break;
                       }break;
                       
                 case 65:
                      if(ver.getValor().equals("hijos")){
                     addtoken1(token.ID,ver.getValor(), palabrareservada.SI, Tipotoken.PARAMETRO,"A31");
                     estado=66;
                     break;
                 }else if(ver.getValor().equals("hermanos")){
                     addtoken1(token.ID, ver.getValor(), palabrareservada.SI, Tipotoken.PARAMETRO,"A32");
                     estado=71;
                     break;
                 }
                    else if(ver.getValor().equals("}")){
                 addtoken1(token.LLAVE_CERRADA,ver.getValor(), palabrareservada.NO, Tipotoken.LLAVE,"A15");
                 estado=45;
                
                 break;    
                 
                  }break;
                    
                 case 66:
                      if(ver.getValor().equals("(")){
                 addtoken1(token.PARENTESIS_ABIERTO,ver.getValor(), palabrareservada.NO, Tipotoken.PARENTESIS,"A8");
                 estado=67;
                 break;
                      }break;
                      
                 case 67:
                     if(ver.tipotoken.equals(Tipo.NUMERO_ENTERO)){
                         addtoken1(token.ENTERO,ver.getValor(), palabrareservada.NO, Tipotoken.PARAMETRO,"H1"); 
                         estado=68;
                         break;
                     }break;
                 case 68:
                     if(ver.getValor().equals(")")){
                 addtoken1(token.PARENTESIS_CERRADO,ver.getValor(), palabrareservada.NO, Tipotoken.PARENTESIS,"A8");
                 estado=69;
                 break;
                     
                      }break;
                 case 69:
                    if(ver.getValor().equals(":")){ 
                 addtoken1(token.DOS_PUNTOS,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"A4");
                 estado=70;
                 break;
             }break;
                 case 70:
                      if(ver.tipotoken.equals(Tipo.NUMERO_ENTERO)){
                         addtoken1(token.ENTERO,ver.getValor(), palabrareservada.NO, Tipotoken.PARAMETRO,"PH1"); 
                         estado=70;
                         break;
                     }
                     else if(ver.getValor().equals(",")){
                         addtoken1(token.ID,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"A12");
                         estado=70;
                         break;
                         
                         
                     }
                    else if(ver.getValor().equals(";")){
                 addtoken1(token.PUNTO_COMA,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"A9");
                 estado=65;
                 break;
                    }break;
                     
                     
                 case 71:
                    if(ver.getValor().equals("(")){
                 addtoken1(token.PARENTESIS_ABIERTO,ver.getValor(), palabrareservada.NO, Tipotoken.PARENTESIS,"A8");
                 estado=72;
                 break;
                      }break;
                 case 72:
                     if(ver.tipotoken.equals(Tipo.NUMERO_ENTERO)){
                         addtoken1(token.ENTERO,ver.getValor(), palabrareservada.NO, Tipotoken.PARAMETRO,"HR1"); 
                         estado=73;
                         break;
                     }break;
                 case 73:
                     if(ver.getValor().equals(")")){
                 addtoken1(token.PARENTESIS_CERRADO,ver.getValor(), palabrareservada.NO, Tipotoken.PARENTESIS,"A8");
                 estado=74;
                 break;
                      }break;
                 case 74:
                     if(ver.getValor().equals(":")){ 
                 addtoken1(token.DOS_PUNTOS,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"A4");
                 estado=75;
                 break;
             }break;
             
                 case 75:
                     if(ver.tipotoken.equals(Tipo.NUMERO_ENTERO)){
                         addtoken1(token.ENTERO,ver.getValor(), palabrareservada.NO, Tipotoken.PARAMETRO,"HP1"); 
                         estado=75;
                         break;
                     }
                       else if(ver.getValor().equals(",")){
                         addtoken1(token.ID,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"A12");
                         estado=75;
                     }
                    else if(ver.getValor().equals(";")){
                 addtoken1(token.PUNTO_COMA,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"A9");
                 estado=65;
                 break;
                    }break;
                    
                     
                 
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                  
                
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
               
                     
                     
                     
                     
                     
               
               /*
               
             
             else if(ver.getValor().equals(":")){ 
                 addtoken1(token.DOS_PUNTOS,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"A4");
                 estado=2;
                 break;
             }
             else if(ver.getValor().equals("(")){
                 addtoken1(token.PARENTESIS_ABIERTO,ver.getValor(), palabrareservada.NO, Tipotoken.PARENTESIS,"A5");
                  estado=3;
                 break;
             }
             
           
             //else if(ver.getValor().equals(",")){
             //    addtoken1(token.COMA,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"A7");
             //    estado=1;   
             //   break;
           //  }
             else if(ver.getValor().equals(")")){
                 addtoken1(token.PARENTESIS_CERRADO,ver.getValor(), palabrareservada.NO, Tipotoken.PARENTESIS,"A8");
             }
             else if(ver.getValor().equals(";")){
                 addtoken1(token.PUNTO_COMA,ver.getValor(), palabrareservada.NO, Tipotoken.SIMBOLO,"A9");
             }
            
             
             else if(ver.getValor().equals("ON")){
                 addtoken1(token.ID, ver.getValor(), palabrareservada.NO, Tipotoken.PARAMETRO_V,"A11");
                 estado=2;
                 break;
             }
             
             else if(ver.getValor().equals("OFF")){
                 addtoken1(token.ID,ver.getValor(), palabrareservada.NO, Tipotoken.PARAMETRO_F, "A13");
                 estado=2;
                 break;      
             }
            
             break;
                     
                     
                     
                     
                
                     
                     
                     
                     
                     
           */        
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                   
                      
                         
                         
                         
                
                    
                     
                /*     case 6:
                     if(ver.tipotoken.equals(Tipo.NOMBRE)){
                         addtoken1(token.ID,ver.getValor(), palabrareservada.NO, Tipotoken.FORMATO, "ET");
                         
                     }else{
                         estado=0;
                        
                     }break;
            */
             }
     }
     }
     
     
     
     
     
     public void imprimirlista1(){
         Lexema ver;
         for(int i=0;i<listaT.size();i++){
             ver=(Lexema) listaT.get(i);
             System.out.println(ver.tipotoken+"------->"+ver.getValor());
         }
        
     }
     
     public void imprimirlista2(){
         Lexema1 ver;
         for(int i=0;i<lista1.size();i++){
             ver=(Lexema1) lista1.get(i);
             System.out.println(ver.tok.toString()+"----"+ver.lexema+"-----"+ver.reser+"-----"+ver.tipo+"---------------"+ver.getValor());
            
             
         }
     }
     
     
     

    
     
     
     
     
     
     
    
}
