import java.awt.TextField;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;



public class Aleatorio implements ActionListener {
    
    JFrame ventana;
    JLabel LBL_NUMERO;
    JTextField TF_NUMERO;
    JButton JB_GENERAR, JB_RESET;
    Random rnd;

    public static void main(String[] args) {

        new Aleatorio();
        
    }

    Aleatorio(){

        ventana = new JFrame("Aleatorio");
        ventana.setBounds(100,100,300,300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);

        LBL_NUMERO = new JLabel("Numero");
        LBL_NUMERO.setBounds(50, 50, 80, 20);
        
        TF_NUMERO = new JTextField();
        TF_NUMERO.setBounds(135, 50, 80, 20);

        JB_GENERAR = new JButton("GENERAR");
        JB_GENERAR.setBounds(50, 75, 70, 20);
        JB_GENERAR.addActionListener(this);

        JB_RESET = new JButton("RESET");
        JB_RESET.setBounds(70 + 50 + 5, 75, 80, 20);
        JB_RESET.addActionListener(this);

        rnd = new Random();

        ventana.add(TF_NUMERO);
        ventana.add(LBL_NUMERO);
        ventana.add(JB_GENERAR);
        ventana.add(JB_RESET);

        ventana.setVisible(true);


    }



    @Override
    public void actionPerformed(ActionEvent e) {
        
        if( e.getSource() == JB_GENERAR){

            TF_NUMERO.setText( String.valueOf(rnd.nextInt(100)) );

        }

        if( e.getSource() == JB_RESET ){

            TF_NUMERO.setText("");

        }

    }

    

}
