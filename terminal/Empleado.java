public class Empleado extends Persona {
    
    private String cargo;
    private String nombre;
    
    Empleado(){
        
        setNombre("aVACIO");
        setApellido("bVACIO");
        setCargo("cVACIO");
    }
    
    Empleado(String nombre, String apellido, String cargo ){
        //setNombre(nombre);
        //setApellido(apellido);
        super( nombre, apellido );
        setCargo(cargo);
    }

    public void setCargo(String n) {
        cargo = n;
    }
    public String getCargo() {
        return cargo;
    }

    public void setNombre(String n){
        nombre = n;
        super.setNombre("MS:" + n );
    }

    
}
