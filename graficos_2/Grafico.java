import javax.swing.*;

public class Grafico {

    JFrame ventana;
    JLabel lbl_nombre , lbl_apellido;
    JTextField tf_nombre, tf_apellido;
    


    public static void main(String[] args) {
        new Grafico();

    }
    
    Grafico(){

        ventana = new JFrame("Mi ventana");
        ventana.setSize(300,300);
        ventana.setLocation(200,200);
        ventana.setLayout(null);

        lbl_nombre = new JLabel("Nombre:");
        lbl_nombre.setBounds(50,50,70,20);
        
        tf_nombre = new JTextField();
        tf_nombre.setBounds(125, 50, 100, 20);        

        lbl_apellido = new JLabel("Apellido:");
        lbl_apellido.setBounds(50,100,70,20);
        
        tf_apellido = new JTextField();
        tf_apellido.setBounds(125, 100, 100, 20);
        
        ventana.add(lbl_nombre);
        ventana.add(tf_nombre);
        ventana.add(lbl_apellido);
        ventana.add(tf_apellido);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

    }
    
}
