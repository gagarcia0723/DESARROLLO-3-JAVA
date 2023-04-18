import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class Proyecto implements ActionListener {

    JFrame VENTANA;
    JLabel JL_COMPU, JL_USER, JL_MSJ, JL_TRY;
    JTextField TF_COMPU, TF_USER, TF_MSJ, TF_TRY;
    JButton JB_INICIAR, JB_VALIDAR;
    Random NAleatorio;

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
        TF_COMPU = new JTextField(null, null, 0);
        TF_COMPU.setBounds(170, 50, 110, 20);

        JL_USER =new JLabel("Usuario", null,0);
        JL_USER.setBounds(50, 100, 110, 20);
        TF_USER = new JTextField(null, null, 0);
        TF_USER.setBounds(170, 100, 110, 20);
        TF_USER.setHorizontalAlignment(JTextField.LEFT);

        JL_MSJ =new JLabel("Mensaje", null, 0);
        JL_MSJ.setBounds(50, 150, 110, 20);
        TF_MSJ = new JTextField(null, null, 0);
        TF_MSJ.setBounds(170, 150, 110, 20);

        JL_TRY =new JLabel("Intentos", null, 0);
        JL_TRY.setBounds(50, 200, 110, 20);
        TF_TRY = new JTextField(null, null, 0);
        TF_TRY.setBounds(170, 200, 110, 20);

        JB_INICIAR = new JButton("INICIAR", null);
        JB_INICIAR.setBounds(50, 250, 70, 20);
        JB_INICIAR.addActionListener(this);

        JB_VALIDAR = new JButton("VALIDAR", null);
        JB_VALIDAR.setBounds(150, 250, 70, 20);
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

    @Override
    public void actionPerformed(ActionEvent e){

        if( e.getSource() == JB_INICIAR ){

            TF_COMPU.setText( String.valueOf( NAleatorio.nextInt(100) + 1 ) );

        }

        if( e.getSource() == JB_VALIDAR ){

         



           

        }

    }

    
    
}
