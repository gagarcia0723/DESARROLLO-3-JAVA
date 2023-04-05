public class Empleado extends Persona {
    
    private String cargo;
    //private String nombre;


    public void setCargo(String n) {
        cargo = n;
    }
    public String getCargo() {
        return cargo;
    }

    public void setNombre(String n){
        //nombre = n;
        super.setNombre("MS:" + n );
    }

    
}
