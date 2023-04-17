import java.awt.Frame;
import javax.swing.*;


public class Aleatorio {
    
    JFrame ventana;

    public static void main(String[] args) {

        new Aleatorio();
        
    }

    Aleatorio(){

        ventana = new JFrame("Aleatorio");
        ventana.setBounds(100,100,500,500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);

        ventana.setVisible(true);


    }
}
