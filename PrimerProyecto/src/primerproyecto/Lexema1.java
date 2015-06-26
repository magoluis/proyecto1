

package primerproyecto;


public class Lexema1 {

    public Lexema1(token tok, String lexema, palabrareservada reser, Tipotoken tipo, String valor) {
        this.tok = tok;
        this.lexema = lexema;
        this.reser = reser;
        this.tipo = tipo;
        this.valor = valor;
    }

    public void setTok(token tok) {
        this.tok = tok;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public void setReser(palabrareservada reser) {
        this.reser = reser;
    }

    public void setTipo(Tipotoken tipo) {
        this.tipo = tipo;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
  
   
   
  
   token tok;
   String lexema;
   palabrareservada reser;
   Tipotoken tipo;
   String valor;

    public String getLexema() {
        return lexema;
    }

    public String getValor() {
        return valor;
    }
   
   
   
   public enum token{
       ID,
       LLAVE_ABIERTA,
       DOS_PUNTOS,
       PARENTESIS_ABIERTO,
       COMA,
       ENTERO,
       PARENTESIS_CERRADO,
       TEXTO,
       LLAVE_CERRADA,
       ERROR,
       PUNTO_COMA,
       IGUAL
       
  
   }
   public enum palabrareservada{
       SI,
       NO
   }
   public enum Tipotoken{
       SEGMENTO,
       LLAVE,
       FORMATO,
       SIMBOLO,
       PARENTESIS,
       RUTA,
       PARAMETRO,
       PARAMETRO_V,
       PARAMETRO_F,
       VARIABLE,
       ASIGNACION_N,
       ASIGNACION_L,       
       SUB_SEGMENTO,
       ERROR_LEXICO
   
   }
  
     
      
      public String gettipoRString (){
          String value="";
          reser=palabrareservada.valueOf(value);
          switch(reser){
              case NO:
                  return "No    ";
              case SI:
                  return "Si";
              
          }
         return "Desconocido";
  
      }
      
       public String getTokenString(){
     
       String value = "";
       tok=token.valueOf(value);
       
       switch(tok){
           
           case ID:
               return "ID_LETRAS    ";
           case LLAVE_ABIERTA:
                return "Llave_izquierda   ";
            case  DOS_PUNTOS:
                return "Dos puntos     ";
          
            case PARENTESIS_ABIERTO:
                return "Parentesis izquierdo     ";
            case COMA:
                return "Coma   ";
            case ENTERO:
                return "Numero entero   ";
            case PARENTESIS_CERRADO:
                return "Parentesis derecho    ";
            case TEXTO:
                return "Texto  ";
            case LLAVE_CERRADA:
                return "Llave cerrada ";
            case PUNTO_COMA:
                return "Punto_coma ";
            case IGUAL:
                return "Igual   ";
                case ERROR:
                    return "Error ";
            
   }
       return "Desconocido  ";
       
   }
       
        public String getTipoTokenString(){
     
       String value = "";
       tipo=Tipotoken.valueOf(value);
       
       switch(tipo){
           
           case SEGMENTO:
               return "ID_LETRAS    ";
           case LLAVE:
                return "Llave_izquierda   ";
            case  FORMATO:
                return "Dos puntos     ";
          
            case SIMBOLO:
                return "Parentesis izquierdo     ";
            case PARENTESIS:
                return "Coma   ";
            case RUTA:
                return "Numero entero   ";
            case PARAMETRO:
                return "Parentesis derecho    ";
            case PARAMETRO_V:
                return "Texto  ";
            case PARAMETRO_F:
                return "Llave cerrada ";
                case VARIABLE:
                return "Llave cerrada ";
                    case ASIGNACION_N:
                return "Llave cerrada ";
                        case ASIGNACION_L:
                return "Llave cerrada ";
                            case SUB_SEGMENTO:
                return "Llave cerrada ";
                            case ERROR_LEXICO:
                                return "Error lexico";
                               
   }
       return "Desconocido  ";
       
   }
       
       
       
       
       
       
       
      
}
