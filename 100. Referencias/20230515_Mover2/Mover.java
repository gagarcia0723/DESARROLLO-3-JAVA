import javax.swing.*;

import java.awt.Graphics2D;
import java.awt.event.*;

public class Mover implements ActionListener
{
   JFrame ventana;
   JButton btn_boton, btn_bajar, btn_subir, btn_izq, btn_der;

   int diry = 0, dirx = 0;

   Timer timer = new Timer(100,new ActionListener(){

      public void actionPerformed(ActionEvent e){
         
         int x, y;
         x = btn_boton.getLocation().x;
         y = btn_boton.getLocation().y;

         btn_boton.setLocation( x + dirx, y + diry);

         diry = btn_boton.getY() <= 0 ? -diry  : btn_boton.getY() >= ventana.getHeight() - 80 ? -1 * diry : diry; 
         dirx = btn_boton.getX() <= 0 ? -dirx : btn_boton.getX() >= ventana.getWidth() - 80 ? -1 * dirx : dirx;
   
      }

   });

   public static void main(String[] args)
   {
      new Mover();
   }
   Mover(){

      ventana = new JFrame("Mover");
      ventana.setBounds(100,100,500,500);
      ventana.setLayout(null);
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);

      btn_boton = new JButton("Boton");
      btn_boton.setBounds(300,300,80,20);
      ventana.add(btn_boton);

      btn_subir = new JButton("Subir");
      btn_subir.setBounds(1000,280,80,20);
      btn_subir.addActionListener(this);
      ventana.add(btn_subir);


      btn_bajar = new JButton("Bajar");
      btn_bajar.setBounds(1000,320,80,20);
      btn_bajar.addActionListener(this);
      ventana.add(btn_bajar);

      btn_izq = new JButton("Izq");
      btn_izq.setBounds(910,300,80,20);
      btn_izq.addActionListener(this);
      ventana.add(btn_izq);

      btn_der = new JButton("Der");
      btn_der.setBounds(1090,300,80,20);
      btn_der.addActionListener(this);
      ventana.add(btn_der);


      timer.start();

      ventana.setVisible(true);   

   }

   public void actionPerformed(ActionEvent e){
    
      diry = e.getSource() == btn_bajar ? diry + 1 : e.getSource() == btn_subir ? diry - 1 : diry;
      dirx = e.getSource() == btn_der ? dirx + 1 : e.getSource() == btn_izq ? dirx - 1 : dirx;

   }

}