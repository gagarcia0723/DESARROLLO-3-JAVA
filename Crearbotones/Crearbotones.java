import javax.swing.*;
import java.awt.event.*;

public class Crearbotones implements ActionListener {

    JFrame ventana;
    JButton btn_boton, btn_tmp, btn_iniciar;
    JLabel JLABEL_MENSAJE;

    public static void main(String[] args)  {
        new Crearbotones();
    }
    
    Crearbotones(){
        ventana = new JFrame("Crear Botones");
        ventana.setBounds(100, 100, 500, 500);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       

        btn_iniciar = new JButton(String.valueOf( "iniciar" ));
        btn_iniciar.setBounds(50  , 50 , 80, 80);
        btn_iniciar.addActionListener(this);
        ventana.add(btn_iniciar);


        

        JLABEL_MENSAJE = new JLabel(null, null, 0);
        JLABEL_MENSAJE.setBounds(85, 20, 400, 200);
        ventana.add(JLABEL_MENSAJE);
        


        ventana.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
      
        btn_tmp = (JButton)e.getSource();
        System.out.println(btn_tmp.getText());

       if ( e.getSource() == btn_iniciar ){
            crear();
       }
    }

    void crear(){

        for(int x = 0; x < 3; x++){
            for ( int y = 0; y < 3; y++ ){

                btn_boton = new JButton(String.valueOf( x + ( y * 10) ));
                btn_boton.setBounds( 50 + ( 85 * x ) , 50 + ( 85 *  y ), 80, 80);
                btn_boton.addActionListener(this);
                ventana.add(btn_boton);

            }
            
        }  

        btn_iniciar.setVisible(false);
        ventana.repaint();
    }
}
