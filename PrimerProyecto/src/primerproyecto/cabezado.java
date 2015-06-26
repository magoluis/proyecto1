
package primerproyecto;

import primerproyecto.Lexema.Tipo;


public class cabezado {
    String Token;
    String Lexema;
    String Reservada;
    Tipo tipe;

    public cabezado(String Token, String Lexema, String Reservada, Tipo tipe) {
        this.Token = Token;
        this.Lexema = Lexema;
        this.Reservada = Reservada;
        this.tipe = tipe;
    }
    
   

    public String getToken() {
        return Token;
    }

    public void setToken(String Token) {
        this.Token = Token;
    }

    public String getLexema() {
        return Lexema;
    }

    public void setLexema(String Lexema) {
        this.Lexema = Lexema;
    }

    public String getReservada() {
        return Reservada;
    }

    public void setReservada(String Reservada) {
        this.Reservada = Reservada;
    }

    public Tipo getTipe() {
        return tipe;
    }

    public void setTipe(Tipo tipe) {
        this.tipe = tipe;
    }
    
    
}
