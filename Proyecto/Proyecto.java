import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class Proyecto implements ActionListener {

    JFrame VENTANA;
    JLabel JL_COMPU, JL_USER, JL_MSJ, JL_TRY;
    JTextField TF_COMPU, TF_USER, TF_MSJ, TF_TRY;
    JButton JB_INICIAR, JB_VALIDAR;
    Random NAleatorio;

    int Intentos = 0;

    public static void main(String[] args) {
        
        new Proyecto();
    }

    Proyecto() {

        VENTANA = new JFrame("JUEGO DE ADIVINANZA");
        VENTANA.setBounds(100, 100, 400, 400);
        VENTANA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        VENTANA.setLayout(null);

        JL_COMPU =new JLabel("Computadora", null, 0);
        JL_COMPU.setBounds(50, 50, 110, 20);
        
        TF_COMPU = new JTextField(null, "0", 0);
        TF_COMPU.setBounds(170, 50, 110, 20);
        TF_COMPU.setVisible(false);

        JL_USER =new JLabel("Usuario", null,0);
        JL_USER.setBounds(50, 100, 110, 20);
        
        TF_USER = new JTextField(null, "0", 0);
        TF_USER.setBounds(170, 100, 110, 20);
        

        JL_MSJ =new JLabel("Mensaje", null, 0);
        JL_MSJ.setBounds(50, 150, 110, 20);
        TF_MSJ = new JTextField(null, null, 0);
        TF_MSJ.setBounds(170, 150, 110, 20);

        JL_TRY =new JLabel("Intentos", null, 0);
        JL_TRY.setBounds(50, 200, 110, 20);

        TF_TRY = new JTextField( "0");
        TF_TRY.setBounds(170, 200, 110, 20);
        

        JB_INICIAR = new JButton("INICIAR", null);
        JB_INICIAR.setBounds(50, 250, 70, 20);
        JB_INICIAR.addActionListener(this);

        JB_VALIDAR = new JButton("VALIDAR", null);
        JB_VALIDAR.setBounds(200, 250, 70, 20);
        JB_VALIDAR.addActionListener(this);

        NAleatorio = new Random();
        
        VENTANA.add(TF_COMPU);
        VENTANA.add(JL_COMPU);
        VENTANA.add(JB_INICIAR);
        VENTANA.add(JL_USER);
        VENTANA.add(JL_MSJ);
        VENTANA.add(TF_MSJ);
        VENTANA.add(TF_USER);
        VENTANA.add(TF_TRY);
        VENTANA.add(JL_TRY);
        VENTANA.add(JB_VALIDAR);

        VENTANA.setVisible(true);
    }
    int Intentar(){
        return Intentos++;
    }

    @Override
    public void actionPerformed(ActionEvent e){

        if( e.getSource() == JB_INICIAR ){

            TF_COMPU.setText( String.valueOf( NAleatorio.nextInt(100) + 1 ) );
            
            JB_INICIAR.setEnabled(false);
            JL_COMPU.setVisible(false);
            TF_TRY.setText("0");
            TF_USER.setText("0");
            TF_MSJ.setText("0");
            

        }

        if( e.getSource() == JB_VALIDAR ){
            
  
            
            TF_TRY.setText( String.valueOf( Integer.valueOf( TF_TRY.getText() ) + 1 ));
            

            //if ( TF_USER.getText().compareTo( TF_COMPU.getText() )  > 0 ){
            if ( Integer.parseInt( TF_USER.getText() )  >  Integer.parseInt( TF_COMPU.getText() ) ){

                TF_MSJ.setText("Muy Alto");
                

            }else{

                if(TF_USER.getText().compareTo( TF_COMPU.getText() )  < 0){

                    TF_MSJ.setText("Muy bajo");
                    

                }else{

                    TF_MSJ.setText("Correcto");
                    JB_INICIAR.setEnabled(true);

                }
            }
        
        }
    }    
}
