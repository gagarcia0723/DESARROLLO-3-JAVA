import javax.swing.*;


public class Grafico{
    public static void main( String arg[] ){

        JFrame ventana;
        JLabel lblNombre;
        
        
        ventana = new JFrame( "Mi ventana ");
        ventana.setSize(300,500);
        ventana.setLocation(300,300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);
        
        lblNombre = new JLabel("Hola mundo");
        lblNombre.setSize(120,20);
        lblNombre.setLocation(40,20);
        ventana.add(lblNombre);

        ventana.setVisible(true);        
    
    }
}