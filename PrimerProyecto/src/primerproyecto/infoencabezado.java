
package primerproyecto;


public class infoencabezado {
    
    String ruta;
    String x;
    String y;

    public infoencabezado(String ruta, String x, String y, String tex, String ne, String cu, String sub) {
        this.ruta = ruta;
        this.x = x;
        this.y = y;
        this.tex = tex;
        this.ne = ne;
        this.cu = cu;
        this.sub = sub;
    }
    String tex;

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getTex() {
        return tex;
    }

    public void setTex(String tex) {
        this.tex = tex;
    }

    public String getNe() {
        return ne;
    }

    public void setNe(String ne) {
        this.ne = ne;
    }

    public String getCu() {
        return cu;
    }

    public void setCu(String cu) {
        this.cu = cu;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }
    String ne;
    String cu;
    String sub;
}
