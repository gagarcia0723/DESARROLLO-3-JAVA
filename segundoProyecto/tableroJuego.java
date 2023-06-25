
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.*;


public class tableroJuego implements ActionListener {
    
    int velocidadMovimiento = 10;

    int[] posicionBotones = new int[16];
    JButton[][] casillaTablero = new JButton[4][4];

    
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

    public void agregarBoton(  ){
        
        for(int x = 0; x < posicionBotones.length ; x++ ){
            
            posicionBotones[ x ] = x;
         
        }
        
    }

    // METODO FITSHER - YATES , REVOLVER VALORES
    public void revolverBotones(){

        for(int x = 0; x < posicionBotones.length ; x++ ){

            int seleccionAleatoria = value.nextInt(15);
            int temporal = posicionBotones[seleccionAleatoria];

            posicionBotones[seleccionAleatoria] = posicionBotones[x];
            posicionBotones[x] = temporal;
            
            

            //SE ESTA REVOLVIENDO PERO, LOS VALORES DE POSICION YA ESTAN DEFINIDOS POR ENDE NO FUNCIONA EL METODO DE REVOLVER, YA QUE ES NECESARIO CAMBIAR LA COORDENADA DE IMPRESIÓN
            
            
        }  

        /* 
            for( int numero : posicionBotones ){
                    System.out.print( numero );
            }
        */

    }

    public void cargarTablero(){

        int k = 0;
        
        for (int i = 0; i < casillaTablero.length; i++) {
            for ( int j = 0; j < casillaTablero[i].length; j++ ) {

                
                casillaTablero[i][j] = generarBotones( posicionBotones[k++]);

            }
        }

    }

    private JButton generarBotones( int index ){

        int row = index / columns;
        int col = index % columns;

        int buttonX = margenLateral_x + ( xMargin + col * ( buttonWidth + xMargin ) );
        int buttonY = margenLateral_y + ( yMargin + row * ( buttonHeight + yMargin ) );

        JButton button = new JButton( "" + buttonCount );

        button.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
        button.addActionListener(this);

        buttonCount++;

        return button;

    }

    public void pintarTablero(){

        JFrame frame = new JFrame("Patrón Rectangular de Botones");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        for (int i = 0; i < casillaTablero.length; i++) {
            for ( int j = 0; j < casillaTablero[i].length; j++ ) {
               
                if( casillaTablero[i][j] != null ){
                    frame.add( casillaTablero[i][j] );
                }

            }
        }

        frame.setSize(1000 , 600);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
      

    }
}