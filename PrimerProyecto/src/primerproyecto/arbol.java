
package primerproyecto;


public class arbol {
    
    
 String id;
 String nombre;
 String edad;

    public arbol(String id, String nombre, String edad, String parentesco) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.parentesco = parentesco;
    }
 String parentesco;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }
 
}
