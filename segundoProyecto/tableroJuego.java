import java.util.Random;
import javax.swing.*;
import java.awt.event.*;


public class tableroJuego implements ActionListener {
    
    int velocidadMovimiento = 10;

    int[] posicionBotones = new int[16];
    JButton[][] casillaTablero = new JButton[4][4];
    JButton JB_REVOLVER, JB_TMP;
    JTextField TF_CONTADOR;

    JFrame frame = new JFrame("PROYECTO 2 : ROMPECABEZA");
    Random value = new Random();
    
    int posicion = 0;
    int rows = 4; // Número de filas
    int columns = 4; // Número de columnas
    int buttonWidth = 100; // Ancho del botón
    int buttonHeight = 100; // Altura del botón
    int xMargin = 10; // Margen horizontal
    int yMargin = 10; // Margen vertical
    int margenLateral_x = 500;
    int margenLateral_y = 50;
    int buttonCount = 1;
    int index = 0;
    
    
    Timer timer = new Timer(1000, new ActionListener(){    
        public void actionPerformed(ActionEvent e){   
            
            TF_CONTADOR.setText(String.valueOf(Integer.parseInt( TF_CONTADOR.getText()) + 1));
            
        }
    
    });

    public void agregarBoton(  ){
        
        for(int x = 0; x < posicionBotones.length ; x++ ){
            
            posicionBotones[ x ] = x + 1;
         
        }
        
    }

    // METODO FITSHER - YATES , JB_REVOLVER VALORES
    public void revolverBotones(){

        for(int x = 0; x < posicionBotones.length - 1; x++ ){

            int seleccionAleatoria = value.nextInt(14);
            int temporal = posicionBotones[seleccionAleatoria];

            posicionBotones[seleccionAleatoria] = posicionBotones[x];
            posicionBotones[x] = temporal;
                
        }  

    
        for( int numero : posicionBotones ){
            System.out.print( "[" + numero + "]" );
        }
        System.out.println("\n");
    
        

    }

    public void cargarTablero(){

        int k = 0;
        
        for (int i = 0; i < casillaTablero.length; i++) {
            for ( int j = 0; j < casillaTablero.length; j++ ) {

                casillaTablero[i][j] = generarBotones( k, posicionBotones[k] );

                System.out.print( j == 3 ? "[" + casillaTablero[i][j].getText() + "]\n" : "[" + casillaTablero[i][j].getText() + "]" );
                
                k++;
            }
        }
        System.out.println("\n");
    }

    private JButton generarBotones( int index, int texto ){

        int row = index / columns;
        int col = index % columns;

        int buttonX = margenLateral_x + ( xMargin + col * ( buttonWidth + xMargin ) );
        int buttonY = margenLateral_y + ( yMargin + row * ( buttonHeight + yMargin ) );

        piezas button = new piezas(  );
        button.setText( Integer.toString(texto) );
        button.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
        button.addActionListener(this);
        button.setVisible( buttonCount == 16 ? false:true);
        buttonCount++;

        return button;

    }

    public void pintarTablero(){
        
        
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        
        for (int i = 0; i < casillaTablero.length; i++) {
            for ( int j = 0; j < casillaTablero.length; j++ ) {
                
                frame.add( casillaTablero[i][j] );
                
            }
        }
        
        JB_REVOLVER = new JButton("INICIAR");
        JB_REVOLVER.setBounds(50, 50, 200, 50);
        JB_REVOLVER.addActionListener(this);
        frame.add(JB_REVOLVER);
        
        TF_CONTADOR = new JTextField();
        TF_CONTADOR.setText("0");
        TF_CONTADOR.setHorizontalAlignment(SwingConstants.CENTER);
        TF_CONTADOR.setBounds(250, 50, 50, 50);
        frame.add(TF_CONTADOR);
        

        frame.setSize(1000 , 600);
        frame.setVisible(true);

    }

    public int[] buscarPosicion( int findMe ){
        int[] posicion = new int[2];
        
        for (int i = 0; i < casillaTablero.length; i++) {
            for ( int j = 0; j < casillaTablero.length; j++ ) {
                
                if ( Integer.parseInt( casillaTablero[i][j].getText() ) == findMe ) {

                    posicion[0] = i;
                    posicion[1] = j;

                    //System.out.println("Valor: " +  findMe + " encontrado en: " + posicion[0] + "," + posicion[1]);
                
                }else{
                    //System.out.println("Valor: " +  findMe + " no encontrado ");
                }
            
            }
        }

        return posicion;
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        
        JB_TMP = new JButton();
        JB_TMP = (JButton)e.getSource(); 
    
        if( e.getSource() == JB_REVOLVER){
            
            timer.start();
            buttonCount = 1;
            frame.getContentPane().removeAll();
            
            this.revolverBotones();
            this.cargarTablero();
            this.pintarTablero();
            
            frame.revalidate();
            frame.repaint();

        }

        
        if ( e.getSource() == JB_TMP ){
            
            int evalValue = Integer.parseInt( JB_TMP.getText() );
            
            //ESTE VALOR SIEMPRE SE VA A ENCONTRAR
            int[] posicionA = this.buscarPosicion(16);
            int posicionEVY = casillaTablero[ posicionA[0] ] [ posicionA[1] ].getY();
            int posicionEVX = casillaTablero[ posicionA[0] ] [ posicionA[1] ].getX();
            
            //ESTE VALOR ES EL QUE EL USUARIO INTRODUCE
            int[] posicionB = this.buscarPosicion( Integer.parseInt( JB_TMP.getText() ) );
            int posicionBTY = casillaTablero[ posicionB[0] ] [ posicionB[1] ].getY();
            int posicionBTX = casillaTablero[ posicionB[0] ] [ posicionB[1] ].getX();

        
        }
        
        // PENDIENTE VERIFICAR LOS HERMANOS PARA SABER SI SE PUEDE O NO MOVER.


       

           
    }
   
}