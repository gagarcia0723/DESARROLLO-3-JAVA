public class Persona
{
   private String nombre;
   private String apellido;

   public void setNombre()
   {
      nombre = "VACIO";
   }

   public void setNombre(String n)
   {
      nombre = n;
   }
   public String getNombre()
   {
      return nombre;
   }

   public void setApellido(String n)
   {
      apellido = n;
   }
   public String getApellido()
   {
      return apellido;
   }
   public String getNombreCompleto()
   {
      return nombre+" "+apellido;
   }
}