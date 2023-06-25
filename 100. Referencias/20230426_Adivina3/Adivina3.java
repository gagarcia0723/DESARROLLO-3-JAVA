import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Adivina3 implements ActionListener
{

   JFrame ventana;
   JLabel lbl_computadora, lbl_intento, lbl_inf, lbl_sup;
   JTextField tf_computadora, tf_intento, tf_inf, tf_sup;
   JButton btn_inicio, btn_bajo, btn_alto, btn_correcto;
   Random rnd;

   public static void main(String[] args)
   {
      new Adivina3();
   }

   Adivina3()
   {
      ventana = new JFrame("Adivina3");
      ventana.setBounds(100,100,500,500);
      ventana.setLayout(null);
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      lbl_computadora = new JLabel("Computadora");
      lbl_computadora.setBounds(100,50,100,20);
      ventana.add(lbl_computadora);

      tf_computadora = new JTextField();
      tf_computadora.setBounds(205,50,50,20);
      ventana.add(tf_computadora);

      btn_inicio = new JButton("Inicio");
      btn_inicio.setBounds(260,50,80,20);
      btn_inicio.addActionListener(this);
      ventana.add(btn_inicio);

      lbl_intento = new JLabel("intento");
      lbl_intento.setBounds(100,75,100,20);
      ventana.add(lbl_intento);

      tf_intento = new JTextField();
      tf_intento.setBounds(205,75,50,20);
      ventana.add(tf_intento);

      btn_bajo = new JButton("Bajo");
      btn_bajo.setBounds(100,100,80,20);
      btn_bajo.addActionListener(this);
      ventana.add(btn_bajo);

      btn_alto = new JButton("alto");
      btn_alto.setBounds(185,100,80,20);
      btn_alto.addActionListener(this);
      ventana.add(btn_alto);

      btn_correcto = new JButton("correcto");
      btn_correcto.setBounds(270,100,80,20);
      ventana.add(btn_correcto);

      lbl_inf = new JLabel("inf");
      lbl_inf.setBounds(100,125,100,20);
      ventana.add(lbl_inf);

      tf_inf = new JTextField();
      tf_inf.setBounds(205,125,50,20);
      ventana.add(tf_inf);

      lbl_sup = new JLabel("sup");
      lbl_sup.setBounds(100,150,100,20);
      ventana.add(lbl_sup);

      tf_sup = new JTextField();
      tf_sup.setBounds(205,150,50,20);
      ventana.add(tf_sup);



      rnd = new Random();

      ventana.setVisible(true);
   }

   public void actionPerformed(ActionEvent e)
   {
      if (e.getSource() == btn_inicio)
      {
         tf_inf.setText("1");
         tf_sup.setText("100");
      }
      if (e.getSource() == btn_bajo)
         tf_inf.setText(tf_computadora.getText());
      if (e.getSource() == btn_alto)
         tf_sup.setText(tf_computadora.getText());
      tf_computadora.setText(String.valueOf(rnd.nextInt(Integer.parseInt(tf_sup.getText()))+Integer.parseInt(tf_inf.getText())));
      
   }
}