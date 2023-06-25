import javax.swing.*;
import javax.swing.border.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DetectorPeces implements ActionListener{
    
   JFrame ventana = new JFrame("Detector de peces");
   JButton btn_boton, btn_tmp, JB_HIDE_INFO, BTN_REINICIAR, btn_iniciar;
   
   JLabel LBL_X_COOR, LBL_Y_COOR, JL_NORTE, 
      JL_SUR, JL_ESTE, JL_OESTE, 
      JL_TERMINAL, JL_INTENTOS, 
      JL_INT_VALUE, JL_UBI_CARDUMEN,
      JL_DETALLES
   ;

   JTextField JT_UBI_CARDUMEN;
   JTextArea JTA_DETALLES;
   int INICIAL_POS_X = 600;
   int INICIAL_POS_Y = 150;
   int BOX_SIZE = 40;
   boolean state = false, juegoIniciado = false;

   Peces cardumen = new Peces();

   public void menuInicial(){

    
      ventana.setBounds(100,100,450,800);
      ventana.setLayout(null);
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      btn_iniciar = new JButton("Iniciar");
      btn_iniciar.setBounds(50,25,80,40);
      btn_iniciar.addActionListener(this);
      ventana.add(btn_iniciar);

      BTN_REINICIAR = new JButton("REINICIAR");
      BTN_REINICIAR.setBounds(130,25,80,40);
      BTN_REINICIAR.addActionListener(this);
      ventana.add(BTN_REINICIAR);

      JL_INTENTOS = new JLabel("INTENTOS: ");
      JL_INTENTOS.setBounds(300, 25, 100, 40);
      ventana.add(JL_INTENTOS);

      JL_INT_VALUE = new JLabel("0");
      JL_INT_VALUE.setBounds(380, 25, 100, 40);
      ventana.add(JL_INT_VALUE);

      JL_UBI_CARDUMEN = new JLabel("CARDUMEN: ");
      JL_UBI_CARDUMEN.setBounds(INICIAL_POS_X, 720, 150  , 20);
      JL_UBI_CARDUMEN.setVisible(false);
      ventana.add(JL_UBI_CARDUMEN);

      JT_UBI_CARDUMEN = new JTextField();
      JT_UBI_CARDUMEN.setText(Integer.toString(cardumen.getLocation()));
      JT_UBI_CARDUMEN.setBounds(INICIAL_POS_X + 150 + 47, 720, 50  , 20);
      JT_UBI_CARDUMEN.setVisible(false);
      ventana.add(JT_UBI_CARDUMEN);

      JB_HIDE_INFO = new JButton("Mostrar Información");
      JB_HIDE_INFO.setBounds(INICIAL_POS_X + 150 + 147, 720, 200, 20);
      JB_HIDE_INFO.addActionListener(this);
      ventana.add(JB_HIDE_INFO);


      JTA_DETALLES = new JTextArea(); 
      JTA_DETALLES.setText (

            "\tUniversidad Tecnologica de Panamá\n\n"+ 
         "       Facultad de Ingeniería de Sistemas Computacionales\n\n" +
            "\tLicenciatura en Desarrollo de Software\n\n\n\n\n\n" +
            "\t      Desarrollo de Software 3 \n\n" + 
            "\t           Ricardo Chang\n\n" +
            "\t    Gabriel Axel Garcia Hurtado\n\n"+
            "\t              8-883-2158 \n\n" +
            "\t                1LS221 \n\n\n\n\n\n\n" +
            "\t       24 de Mayo de 2023" 
      
      );
      JTA_DETALLES.setEnabled(false);
      JTA_DETALLES.setFont(new Font(null, Font.CENTER_BASELINE, 14));
      JTA_DETALLES.setBackground(null);
      JTA_DETALLES.setBounds(INICIAL_POS_X - 600, INICIAL_POS_Y + 40, 500, 500);
      
      ventana.add(JTA_DETALLES);
      ventana.setVisible(true);

   }
   
   private void crearCuadrilla(){

      JL_NORTE = new JLabel("NORTE");
      JL_NORTE.setBounds(INICIAL_POS_X + 225, INICIAL_POS_Y - 50, 50, 20);
      ventana.add(JL_NORTE);


      JL_OESTE = new JLabel("OESTE");
      JL_OESTE.setBounds(INICIAL_POS_X  - 100, INICIAL_POS_Y + 200, 50, 20);
      ventana.add(JL_OESTE);

      JL_SUR = new JLabel("SUR");
      JL_SUR.setBounds(INICIAL_POS_X  + 225, INICIAL_POS_Y + 450, 50, 20);
      ventana.add(JL_SUR);

      JL_ESTE = new JLabel("ESTE");
      JL_ESTE.setBounds(INICIAL_POS_X  + 500, INICIAL_POS_Y + 200, 50, 20); 
      ventana.add(JL_ESTE);

      JL_TERMINAL = new JLabel("  Mensaje: No mesage...");
      JL_TERMINAL.setBounds(INICIAL_POS_X, INICIAL_POS_Y + 500, 500 , 50);
      JL_TERMINAL.setBorder(new MatteBorder(2, 2, 2, 2,Color.black));
      
      ventana.add(JL_TERMINAL);



      
      for (int i= 99; i >= 0; i--){

         btn_boton = new JButton(String.valueOf(i));
         btn_boton.setBounds( INICIAL_POS_X + 50 + BOX_SIZE * (i%10), 510 - BOX_SIZE * (i/10), BOX_SIZE, BOX_SIZE );
         btn_boton.addActionListener(this);
         btn_boton.setFocusable(false);
         ventana.add(btn_boton);

      }

      for (int i=0; i < 10; i++){
         
         LBL_X_COOR = new JLabel(String.valueOf( i  + 1 ), SwingConstants.CENTER);
         LBL_X_COOR.setBounds(INICIAL_POS_X + 50 + BOX_SIZE * (i), INICIAL_POS_Y + 400, BOX_SIZE, BOX_SIZE);
         ventana.add(LBL_X_COOR);

      }

      for (int i=0; i < 10; i++){
         
         LBL_Y_COOR = new JLabel(String.valueOf( 10 - i ), SwingConstants.CENTER);
         LBL_Y_COOR.setBounds( INICIAL_POS_X, INICIAL_POS_Y + ( BOX_SIZE * i ), BOX_SIZE, BOX_SIZE);
         ventana.add(LBL_Y_COOR);

      }
      
      ventana.repaint();

   }

   public int getINICIAL_POS_X (){
      return INICIAL_POS_X;
   }

   public int getINICIAL_POS_Y (){
      return INICIAL_POS_Y;
   }

   public int getBOX_SIZE (){
      return BOX_SIZE;
   }

   public void setTerminal(String text){
      JL_TERMINAL.setText(text);
   }

   
    @Override
    public void actionPerformed(ActionEvent e) {
      
      

      switch ( e.getSource() ==  BTN_REINICIAR ? 1 : e.getSource() ==  btn_iniciar ? 2 : e.getSource() == JB_HIDE_INFO ? 3 : 100 ) {
         
         case 1: 
            
               System.out.println("JUEGO REINICIADO");
               cardumen.newLocation();
               JL_INT_VALUE.setText("0");
               JT_UBI_CARDUMEN.setText(Integer.toString(cardumen.getLocation()));
               JL_TERMINAL.setText( "Juegos Reiniciado" );

               
            break;
        
         case 2:
            
            if(!juegoIniciado){
            
               ventana.setBounds(100,100,1200,800);
               crearCuadrilla();
               juegoIniciado = true;

            }
            
            break;

         case 3:
            
            if ( state ) {

               JB_HIDE_INFO.setText("Mostrar información");
               JT_UBI_CARDUMEN.setVisible(false);
               JL_UBI_CARDUMEN.setVisible(false);
               state = false;

            }else {
               
               JB_HIDE_INFO.setText("Ocultar información");
               JT_UBI_CARDUMEN.setVisible(true);
               JL_UBI_CARDUMEN.setVisible(true);
               state = true;
            }
            
            ventana.repaint();

            break;
         
         default:

            btn_tmp = (JButton)e.getSource();    
            JL_TERMINAL.setText( " " + cardumen.moverCardumen( btn_tmp.getLocation().x, btn_tmp.getLocation().y, Integer.parseInt(  btn_tmp.getText() ), INICIAL_POS_X, INICIAL_POS_Y, BOX_SIZE) );
            JT_UBI_CARDUMEN.setText(Integer.toString(cardumen.getLocation()));

            if (e.getSource() == btn_boton){
               System.out.println("en actionPerformed");
            }

            JL_INT_VALUE.setText(( String.valueOf( Integer.parseInt( JL_INT_VALUE.getText() ) + 1 ) )) ;
            break;

      }
       
   }

}
