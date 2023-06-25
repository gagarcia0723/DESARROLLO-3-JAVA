import javax.swing.*;
import java.awt.event.*;

public class Grafico implements ActionListener
{
   JFrame ventana;
   JLabel lbl_nombre, lbl_apellido;
   JTextField tf_nombre, tf_apellido;
   JButton btn_Escribir, btn_Copiar, btn_Doble;

   public static void main(String[] args)
   {
      new Grafico();
   }

   Grafico()
   {
      ventana = new JFrame("Mi Ventana");
      ventana.setSize(300,300);
      ventana.setLocation(200,200);
      ventana.setLayout(null);

      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      lbl_nombre = new JLabel("Nombre:");
      //lbl_nombre.setLocation(50,50);
      //lbl_nombre.setSize(70,20);
      lbl_nombre.setBounds(50,50,70,20);
      ventana.add(lbl_nombre);

      tf_nombre = new JTextField();
      tf_nombre.setBounds(125,50,100,20);
      ventana.add(tf_nombre);

      lbl_apellido = new JLabel("Apellido");
      lbl_apellido.setBounds(50,75,70,20);
      ventana.add(lbl_apellido);

      tf_apellido = new JTextField();
      tf_apellido.setBounds(125,75,100,20);
      ventana.add(tf_apellido);

      btn_Escribir = new JButton("Escribir");
      btn_Escribir.setBounds(50,100,80,20);
      btn_Escribir.addActionListener(this);
      ventana.add(btn_Escribir);

      btn_Copiar = new JButton("Copiar");
      btn_Copiar.setBounds(135,100,80,20);
      btn_Copiar.addActionListener(this);
      ventana.add(btn_Copiar);

      btn_Doble = new JButton("Doble");
      btn_Doble.setBounds(220,100,80,20);
      btn_Doble.addActionListener(this);
      ventana.add(btn_Doble);

      ventana.setVisible(true);


   }

   public void actionPerformed(ActionEvent e)
   {
      if (e.getSource() == btn_Escribir)
         tf_nombre.setText("Juan");

      if (e.getSource() == btn_Copiar)
         tf_apellido.setText(tf_nombre.getText());

      if (e.getSource() == btn_Doble)
      {
          int valor;
          valor = Integer.parseInt(tf_nombre.getText());
          tf_apellido.setText(String.valueOf(valor*2));
      }
   }
}











