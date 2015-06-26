

package primerproyecto;



        
public class Lexema {
    Tipo tipotoken;
    String valor;

    public void setTipotoken(Tipo tipotoken) {
        this.tipotoken = tipotoken;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
     public String getTipoEnString(){
     
       String value = "";
       tipotoken=Tipo.valueOf(value);
       
       switch(tipotoken){
           
           case NUMERO_ENTERO:
               return "Numero_entero    ";
           case LETRA:
                return "Letra   ";
            case DOS_PUNTOS:
                return "Dos_puntos     ";
            case LLAVE_INICIAL:
                return "Llave_inicial   ";
            case COMILLAS:
                return "Comillas     ";
            case BARRA:
                return "Barra   ";
            case PUNTO:
                return "Punto   ";
            case COMA:
                return "Coma    ";
            case PUNTO_COMA:
                return "Punto_coma  ";
            case LLAVE_FINAL:
                return "Llave_final ";
            case APOSTOFRE:
                return "Apostrofe   ";
            case PARENTESIS_INICIAL:
                return "Parentesis_inicial  ";
            case PARENTESIS_FINAL:
                return "Parentesis_final    ";
            case SIGNO_IGUAL:
                return "Signo_igual ";
            case VARIABLE_UNO:
                return "Variable_1  ";
            case NOMBRE:
                return "Nombre  ";
            case RUTA:
                return "Ruta    ";
            case TEXTO:
                return "Texto   ";
         
            case ERROR:
               return "Error ";
         
   }
       return "Desconocido  ";
       
   }

    public enum Tipo{
    NUMERO_ENTERO,
    LETRA,
    DOS_PUNTOS,
    LLAVE_INICIAL,
    COMILLAS,
    BARRA,
    PUNTO,
    COMA,
    PUNTO_COMA,
    LLAVE_FINAL,
    APOSTOFRE,
    PARENTESIS_INICIAL,
    PARENTESIS_FINAL,
    SIGNO_IGUAL,
    VARIABLE_UNO,
    NOMBRE,
    RUTA,
    TEXTO,
    ERROR
}  
    public Lexema(Tipo tipo,String auxLex){
        this.tipotoken=tipo;
        this.valor=auxLex;
    }
    
}
