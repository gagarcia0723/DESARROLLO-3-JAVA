import javax.swing.*;
import java.awt.event.*;

public class Calculadora implements ActionListener{

    /** 
     *  Para iniciar con el desarrollo de VENTANAs es importante, 
     * definir el objeto de tipo JFrame con su respectivo nombre.
    */

    JFrame VENTANA;
    JLabel LBL_NUM1, LBL_NUM2, lBL_RES, LBL_NUM3;
    JTextField TF_NUM1, TF_NUM2, TF_RESULTADO;
    JButton JB_CALCULAR;
    JCheckBox JC_SUMA_RESTA;


    public static void main(String[] args) {
        new Calculadora();
    }

    Calculadora(){

        VENTANA = new JFrame( "Mi VENTANA ");
        VENTANA.setSize(500,300);
        VENTANA.setLocation(300,300);
        VENTANA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        VENTANA.setLayout(null);

        LBL_NUM1 = new JLabel("NUMERO 1: ");
        LBL_NUM1.setBounds(50,50, 100, 30);
        TF_NUM1 = new JTextField();
        TF_NUM1.setBounds(150,50,100,30);

        LBL_NUM2 = new JLabel("NUMERO 2: ");
        LBL_NUM2.setBounds(50,100, 100, 30);
        TF_NUM2 = new JTextField();
        TF_NUM2.setBounds(150,100,100,30);
        
        lBL_RES = new JLabel("RESULTADO: ");
        lBL_RES.setBounds(50,150, 100, 30);
        TF_RESULTADO = new JTextField();
        TF_RESULTADO.setBounds(150,150,100,30);

        JB_CALCULAR = new JButton("Calcular");
        JB_CALCULAR.setBounds(300, 50, 100, 100);

        /**
         * Esto es necesario agregar para poder hacer el reconocimiento
         * de las pulsaciones realizadas.
         */

        JB_CALCULAR.addActionListener(this);

        JC_SUMA_RESTA = new JCheckBox();
        JC_SUMA_RESTA.setBounds(300, 150, 50,50);
        
        LBL_NUM3 = new JLabel("RESTAR ");
        LBL_NUM3.setBounds(340,150, 300, 50);
        
        /**
         *  ESTO ES LO NECESARIO PARA AGREGAR LOS COMPONENTES A LA VENTANA ANTES CREADA
         * 
         * VENTANA.add(LBL_NUM1);
         * 
         * */ 

        VENTANA.add(LBL_NUM1);
        VENTANA.add(LBL_NUM2);
        VENTANA.add(LBL_NUM3);
        VENTANA.add(lBL_RES);
        VENTANA.add(TF_NUM1);
        VENTANA.add(TF_NUM2);
        VENTANA.add(TF_RESULTADO);
        VENTANA.add(JB_CALCULAR);
        VENTANA.add(JC_SUMA_RESTA);
        
        VENTANA.setVisible(true);       

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if( e.getSource() == JB_CALCULAR ) {

            int RESULTADO = Integer.parseInt(TF_NUM1.getText()) + Integer.parseInt(TF_NUM2.getText());
            TF_RESULTADO.setText( Integer.toString(RESULTADO ));

           

        }

        //PENDIENTE AGREGAR LA FUNCION DE RESTA, MULTIPLICACION Y DIVISION.
        

    }



}