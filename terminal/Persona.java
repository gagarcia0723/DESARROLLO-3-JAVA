public class Persona {
    
    private String nombre;
    private String apellido;

    public void setNombre( String n ){
        nombre = n;
    }
     
    public void setNombre( ){

        nombre = "null";
    
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellido( ){
       return apellido;
    }

    public void setApellido(String n){
        apellido = n;
    }

    public String getNombreCompleto(){

        return nombre + " " + apellido;
    }

}