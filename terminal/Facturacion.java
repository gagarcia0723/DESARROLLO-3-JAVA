public class Facturacion {
    public static void main(String[] args) {
     
        new Facturacion();
    }

    Facturacion(){
    
        Empleado empleado = new Empleado();

        // Empleado empleado = new Empleado();
        // nom.clase nombreObj = new constructor();

        System.out.println(empleado.getNombre());
        System.out.println(empleado.getApellido());
        System.out.println(empleado.getCargo());
        
        empleado.setNombre("Juan");
        empleado.setApellido("Perez");
        empleado.setCargo("vendedor");

        System.out.println("\n========================= 0 ");

        System.out.println( empleado.getNombre() );
        System.out.println( empleado.getApellido() );
        System.out.print( empleado.getCargo() );

        System.out.println("\n========================= 1 ");

        System.out.println( empleado.getNombre() + " " + empleado.getApellido() );
        System.out.print( empleado.getNombreCompleto() );

        System.out.println("\n========================= 2 ");
        
        empleado.setNombre( "Luis");
        System.out.print(empleado.getNombre());

        System.out.println("\n========================= 3 ");

        Empleado empleado2 = new Empleado(
            
            "Maria",
            "Garcia", 
            "Bailarina"

        );
        
        System.out.println(empleado2.getNombre());
        System.out.println(empleado2.getApellido());
        System.out.println(empleado2.getCargo());
        
    }

}
