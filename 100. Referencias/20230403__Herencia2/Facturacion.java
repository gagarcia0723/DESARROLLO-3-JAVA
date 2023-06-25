public class Facturacion
{
   public static void main(String[] args)
   {
      new Facturacion();
   }

   Facturacion()
   {
       Empleado empleado = new Empleado();
       empleado.setNombre("Juan");
       empleado.setApellido("Perez");
       empleado.setCargo("vendedor");

       System.out.println(empleado.getNombre());
       System.out.println(empleado.getApellido());
       System.out.println(empleado.getCargo());
       System.out.println("===========");
       System.out.println(empleado.getNombre()+" "+empleado.getApellido());
       System.out.println(empleado.getNombreCompleto());
       System.out.println("============");
       empleado.setNombre();
       System.out.println(empleado.getNombre());
   }
}