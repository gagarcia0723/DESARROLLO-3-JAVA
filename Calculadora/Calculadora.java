import javax.swing.*;
import java.awt.event.*;

public class Calculadora implements ActionListener{

    /** 
     *  Para iniciar con el desarrollo de ventanas es importante, 
     * definir el objeto de tipo JFrame con su respectivo nombre.
    */

    JFrame ventana;
    JLabel lblNum_1, lblNum_2, lblRes;
    JTextField tfNum_1, tfNum_2, tfResultado;
    JButton JB_CALCULAR;


    public static void main(String[] args) {
        new Calculadora();
    }

    Calculadora(){

        ventana = new JFrame( "Mi ventana ");
        ventana.setSize(500,300);
        ventana.setLocation(300,300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);

        lblNum_1 = new JLabel("NUMERO 1: ");
        lblNum_1.setBounds(50,50, 100, 30);
        tfNum_1 = new JTextField();
        tfNum_1.setBounds(150,50,100,30);

        lblNum_2 = new JLabel("NUMERO 2: ");
        lblNum_2.setBounds(50,100, 100, 30);
        tfNum_2 = new JTextField();
        tfNum_2.setBounds(150,100,100,30);
        
        lblRes = new JLabel("RESULTADO: ");
        lblRes.setBounds(50,150, 100, 30);
        tfResultado = new JTextField();
        tfResultado.setBounds(150,150,100,30);

        JB_CALCULAR = new JButton("Calcular");
        JB_CALCULAR.setBounds(300, 50, 100, 100);
        /**
         * Esto es necesario agregar para poder hacer el reconocimiento de las pulsaciones realizadas
         * 
         */
        JB_CALCULAR.addActionListener(this);

        /**
         *  ESTO ES LO NECESARIO PARA AGREGAR LOS COMPONENTES A LA VENTANA ANTES CREADA
         * 
         * ventana.add(lblNum_1);
         * 
         * */ 


        ventana.add(lblNum_1);
        ventana.add(lblNum_2);
        ventana.add(lblRes);
        ventana.add(tfNum_1);
        ventana.add(tfNum_2);
        ventana.add(tfResultado);
        ventana.add(JB_CALCULAR);
        
        ventana.setVisible(true);       

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub\

        if( e.getSource() == JB_CALCULAR ) {

            int RESULTADO = Integer.parseInt(tfNum_1.getText()) + Integer.parseInt(tfNum_2.getText());
            tfResultado.setText( Integer.toString(RESULTADO ));

        }
    }



}