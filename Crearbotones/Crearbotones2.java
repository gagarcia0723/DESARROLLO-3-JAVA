import javax.swing.*;
import java.awt.event.*;

public class Crearbotones2 implements ActionListener{

   JFrame ventana;
   JButton btn_boton, btn_tmp, btn_iniciar;
   JLabel lbl_valor, lbl_x, lbl_y;
   JTextField tf_valor, tf_x, tf_y;
   
   public static void main(String[] args)
   {
      new Crearbotones2();
   }
   Crearbotones2()
   {
      ventana = new JFrame("Crear botones");
      ventana.setBounds(100,100,1000,1000);
      ventana.setLayout(null);
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
      //crear();
      btn_iniciar = new JButton("Iniciar");
      btn_iniciar.setBounds(50,25,80,20);
      btn_iniciar.addActionListener(this);
      ventana.add(btn_iniciar);

      lbl_valor = new JLabel("Valor");
      lbl_valor.setBounds(50,75,80,20);
      ventana.add(lbl_valor);

      tf_valor = new JTextField();
      tf_valor.setBounds(135,75,80,20);
      ventana.add(tf_valor);

      lbl_x = new JLabel("X");
      lbl_x.setBounds(220,75,20,20);
      ventana.add(lbl_x);

      tf_x = new JTextField();
      tf_x.setBounds(245,75,40,20);
      ventana.add(tf_x);
      
      lbl_y = new JLabel("Y");
      lbl_y.setBounds(290,75,20,20);
      ventana.add(lbl_y);

      tf_y = new JTextField();
      tf_y.setBounds(315,75,40,20);
      ventana.add(tf_y);
      
      
      ventana.setVisible(true);
   
   }

   public void actionPerformed(ActionEvent e)
   {

      if (e.getSource() == btn_iniciar)
         crear();
      else
      {
         btn_tmp = (JButton)e.getSource();     
         tf_valor.setText(btn_tmp.getText()); 
         System.out.println(btn_tmp.getText());
        // btn_tmp.setText("B"+btn_tmp.getText());
        // btn_tmp.setEnabled(false);
         tf_x.setText(String.valueOf(btn_tmp.getLocation().x));
         tf_y.setText(String.valueOf(btn_tmp.getLocation().y));
        
 

         if (e.getSource() == btn_boton)
            System.out.println("en actionPerformed");
      }
   }

   private void crear()
   {

        int CUADRICULA = 20;
        int BOX_SIZE = 20;
        int INITIAL_POS_X = 50;
        int INITIAL_POS_Y = 100;



      for (int i = 0; i < CUADRICULA; i++){

        btn_boton = new JButton( String.valueOf(i > (CUADRICULA/ 2) ?  i - ( CUADRICULA / 2) + 1 :( CUADRICULA/2 ) - i + 1 ));
        
        btn_boton.setBounds( 
            INITIAL_POS_X + ( ( BOX_SIZE + 5 ) * ( i < (CUADRICULA / 2) + 1 ? 0 : i - (CUADRICULA / 2))), 
            INITIAL_POS_Y + ( ( BOX_SIZE + 5 ) * ( i < (CUADRICULA / 2) + 1 ? i : ( CUADRICULA/2 ) + 1)) ,
            BOX_SIZE,
            BOX_SIZE
        );
        
        btn_boton.addActionListener(this);
        ventana.add(btn_boton);
      
    }

    for( int y = 0; y < 10; y++ ){

        btn_boton = new JButton( String.valueOf( y ) );
        btn_boton.setBounds(75 + ( 25 * y ) , 100  , 20, 20);
        btn_boton.addActionListener(this);
        ventana.add(btn_boton);

    } 

        
      

      ventana.repaint();

   }
}























