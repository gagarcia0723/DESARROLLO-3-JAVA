import javax.swing.*;
import java.awt.event.*;

public class Crearbotones implements ActionListener
{

   JFrame ventana;
   JButton btn_boton, btn_tmp;
   JLabel lbl_valor;
   JTextField tf_valor;
   int i;

   public static void main(String[] args)
   {
      new Crearbotones();
   }
   Crearbotones()
   {
      ventana = new JFrame("Crear botones");
      ventana.setBounds(100,100,500,500);
      ventana.setLayout(null);
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
      for (i=0; i<5; i++)
      {
         btn_boton = new JButton(String.valueOf(i));
         btn_boton.setBounds(50+85*i,50,80,20);
         btn_boton.addActionListener(this);
         ventana.add(btn_boton);
      }

      lbl_valor = new JLabel("Valor");
      lbl_valor.setBounds(50,75,80,20);
      ventana.add(lbl_valor);

      tf_valor = new JTextField();
      tf_valor.setBounds(135,75,80,20);
      ventana.add(tf_valor);
      
      ventana.setVisible(true);
   
   }

   public void actionPerformed(ActionEvent e)
   {

      btn_tmp = (JButton)e.getSource();     
      tf_valor.setText(btn_tmp.getText()); 
      System.out.println(btn_tmp.getText());
      btn_tmp.setText("B"+btn_tmp.getText());
     // btn_tmp.setEnabled(false);


      if (e.getSource() == btn_boton)
         System.out.println("en actionPerformed");

   }
}



