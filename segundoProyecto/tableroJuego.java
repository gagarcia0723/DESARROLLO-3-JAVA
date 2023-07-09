import java.util.Random;
import javax.swing.*;
import java.awt.event.*;


public class tableroJuego implements ActionListener {
    
    int velocidadMovimiento = 10;

    int[] posicionBotones = new int[16];
    piezas[][] casillaTablero = new piezas[4][4];
    JButton JB_REVOLVER, JB_TMP, JB_CONSULTAR, JB_PRUEBA;
    JTextField TF_CONTADOR, TF_TIMER, TF_NOMBRE;
    JTextArea JTA_RECORDS, JTA_DETALLES;
    JLabel JL_NOMBRE;
    
    JFrame frame = new JFrame("PROYECTO 2 : ROMPECABEZA");
    Random value = new Random();

    int posicion = 0;
    int rows = 4; // Número de filas
    int columns = 4; // Número de columnas
    int buttonWidth = 100; // Ancho del botón
    int buttonHeight = 100; // Altura del botón
    int xMargin = 10; // Margen horizontal
    int yMargin = 10; // Margen vertical
    int margenLateral_x = 600;
    int margenLateral_y = 50;
    int buttonCount = 1;
    int index = 0;
    int contadorIntentos = 0;
    boolean juegoIniciado = false;
    
    gestorArchivos gestosRecords = new gestorArchivos();
    
    Timer timer = new Timer(1000, new ActionListener(){    
        public void actionPerformed(ActionEvent e){   
            
            TF_TIMER.setText(String.valueOf(Integer.parseInt( TF_TIMER.getText()) + 1));
            
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
        
    }

    private piezas generarBotones( int index, int texto ){

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

    public void cargarTablero(){

        int k = 0;
        
        for (int i = 0; i < casillaTablero.length; i++) {
            for ( int j = 0; j < casillaTablero.length; j++ ) {

                casillaTablero[i][j] = generarBotones( k, posicionBotones[k] );
                //System.out.print( j == 3 ? "[" + casillaTablero[i][j].getText() + "]\n" : "[" + casillaTablero[i][j].getText() + "]" );
                
                k++;
            }
        }
       
    }

    public void pintarMenu(){
                
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        
        JB_REVOLVER = new JButton("INICIAR");
        JB_REVOLVER.setBounds(50, 50, 200, 50);
        JB_REVOLVER.addActionListener(this);
        frame.add(JB_REVOLVER);

        JB_PRUEBA = new JButton("PRUEBA");
        JB_PRUEBA.setBounds(50, 100, 200, 50);
        JB_PRUEBA.addActionListener(this);
        frame.add(JB_PRUEBA);

        TF_TIMER = new JTextField();
        TF_TIMER.setText(String.valueOf("0"));
        TF_TIMER.setHorizontalAlignment(SwingConstants.CENTER);
        TF_TIMER.setBounds(250, 50, 100, 50);
        frame.add(TF_TIMER);
        
        TF_CONTADOR = new JTextField();
        TF_CONTADOR.setText(String.valueOf( contadorIntentos ));
        TF_CONTADOR.setHorizontalAlignment(SwingConstants.CENTER);
        TF_CONTADOR.setBounds(350, 50, 100, 50);
        frame.add(TF_CONTADOR);

        JL_NOMBRE = new JLabel("NOMBRE DEL PARTICIPANTE");
        JL_NOMBRE.setBounds(50, 170, 200, 50);
        frame.add(JL_NOMBRE);

        TF_NOMBRE = new JTextField();
        TF_NOMBRE.setBounds(50, 220, 200, 50);
        frame.add(TF_NOMBRE);

        JTA_RECORDS = new JTextArea("");
        JTA_RECORDS.setBounds(50, 290, 400, 200);
        JTA_RECORDS.setEditable(false);
        frame.add(JTA_RECORDS);

        JB_CONSULTAR = new JButton("CONSULTAR");
        JB_CONSULTAR.setBounds(50, 490, 400, 50);
        JB_CONSULTAR.addActionListener(this);
        frame.add(JB_CONSULTAR);

        frame.setSize(1200 , 600);
        frame.setVisible(true);

    }

    public void pintarTablero(boolean isEnable){
        for (int i = 0; i < casillaTablero.length; i++) {
            for ( int j = 0; j < casillaTablero.length; j++ ) {
                casillaTablero[i][j].setEnabled(isEnable);
                frame.add( casillaTablero[i][j] );
                
            }
        }

        frame.revalidate();
        frame.repaint();
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
   
    public void imprimirPosiciones(){
        
        
        
        for (int i = 0; i < casillaTablero.length; i++) {
            for ( int j = 0; j < casillaTablero.length; j++ ) {

                System.out.print( j == 3 ? "[" + casillaTablero[i][j].getText() + "]\n" : "[" + casillaTablero[i][j].getText() + "]" );                
              

            }
        }

        

    }
    
    public Boolean verificarJuego( Boolean juegoIniciado ){
        
        int v = 1;
        
        Boolean verificado = false;

        for (int i = 0; i < casillaTablero.length && juegoIniciado; i++) {
            for ( int j = 0; j < casillaTablero.length; j++ ) {
                
                int eval = Integer.parseInt( casillaTablero[i][j].getText() );
                //System.out.println("Valor 1: " + v + " Valor 2: " + eval );
                
                if( v == eval ){
                    //System.out.println( "v1: " + Integer.toString(v) + " = " + casillaTablero[i][j].getText() + ( v == Integer.parseInt( casillaTablero[i][j].getText() )) );
                    v++;
                }
             
            }
        }

        
        if( v == 17 ){

           verificado = true;
           this.juegoIniciado = false;
           timer.stop();

        }

        return verificado;
        

    }


    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        JB_TMP = new JButton();
        JB_TMP = (JButton)e.getSource(); 
        buttonCount = 1;

        if( e.getSource() == JB_REVOLVER){
            System.out.println("Juego iniciado");
            
            timer.start();
            frame.getContentPane().removeAll();
            
            revolverBotones();
            cargarTablero();
            pintarMenu();
            pintarTablero(true);

            frame.revalidate();
            frame.repaint();

            contadorIntentos = 0;
            TF_CONTADOR.setText( String.valueOf(contadorIntentos));
            TF_TIMER.setText("0");
            juegoIniciado = true;

        }else if( e.getSource() == JB_PRUEBA ){
            
            timer.start();
            
            pintarTablero(true);
            int[] pos = buscarPosicion(15);
            casillaTablero[pos[0]][pos[1]].doClick();

            frame.revalidate();
            frame.repaint();

            contadorIntentos = 0;
            TF_CONTADOR.setText( String.valueOf(contadorIntentos));
            TF_TIMER.setText("0");
            juegoIniciado = true;
        
        }else if( e.getSource() == JB_CONSULTAR ){
            JTA_RECORDS.setText("");
            //System.out.println( gestosRecords.consultarArchivo() );
            JTA_RECORDS.setText("\n\n\tNOMBRE\tAPELLIDO\n\n" + gestosRecords.consultarArchivo());
            
        
        }else if( e.getSource() == JB_TMP ){

           
            int evalValue = Integer.parseInt( JB_TMP.getText() );
            
            //ESTE VALOR SIEMPRE SE VA A ENCONTRAR
            int[] posicionA = this.buscarPosicion(16);
            int posicionEVY = casillaTablero[ posicionA[0] ] [ posicionA[1] ].getY();
            int posicionEVX = casillaTablero[ posicionA[0] ] [ posicionA[1] ].getX();
            
            piezas botonEval1 =  casillaTablero[ posicionA[0] ] [ posicionA[1] ];

            //ESTE VALOR ES EL QUE EL USUARIO INTRODUCE
            int[] posicionB = this.buscarPosicion( evalValue );
            int posicionBTY = casillaTablero[ posicionB[0] ] [ posicionB[1] ].getY();
            int posicionBTX = casillaTablero[ posicionB[0] ] [ posicionB[1] ].getX();

            piezas botonEval2 =  casillaTablero[ posicionB[0] ] [ posicionB[1] ];

            /**  
             *  NOTA: GENERALES DE FUNCIONAMIENTO
             * 
             *  SI EL BOTON 16 ESTA A UN LADO, DEL BOTON PRESIONADO
            /*  ENTONCES SE CAMBIARAN LAS COORDENADAD DEL 16 CON LAS COORDENADAS DEL BOTON ACTUAL.
            /*  ESTO DEBE IR INCREMENTANDO EN UN TIEMPO X
            /*  ES DECIR QUE SE DEBE CREAR UNA FUNCI'ON QUE EJECUTE EL INCREMENTO POR CADA CICLO DEL TIMER HASTA DETENERSE
            /*  HAY QUE ENTENDER QUE ESTA PIEZA, SE DEBE MOVER CON UN X, Y INCIAL A UN X, Y FINAL.
            /*  ESTO DEBE NOTIFICAR QUE HA LLEGADO PARA LIBERAR LOS CONTROLES.
            /*  LA DIFERENCIA EN X O Y DE CADA BOTON ES DE 110
            **/
            
            Boolean isMovible = 
                posicionBTX == posicionEVX - 110 && posicionBTY == posicionEVY ? true :
                posicionBTX == posicionEVX + 110 && posicionBTY == posicionEVY ? true :
                posicionBTX == posicionEVX && posicionBTY == posicionEVY + 110 ? true :
                posicionBTX == posicionEVX && posicionBTY == posicionEVY - 110 ? true :
                false
            ;

            if ( isMovible ){
                // Aquí necesito cambiar en el arreglo: casillaTablero el boton 16 a la posicion del boton presionado
                // y modificar luego el setbound del mismo mediante la funcion mover boton.
                casillaTablero[posicionA[0]][posicionA[1]] = botonEval2;
                casillaTablero[posicionB[0]][posicionB[1]] = botonEval1;

                botonEval2.moverPieza( posicionEVX, posicionEVY, 1 );
                botonEval1.moverPieza( posicionBTX, posicionBTY, 1 );
                
                contadorIntentos += 1;
                TF_CONTADOR.setText( String.valueOf(contadorIntentos));
                
                
            }
            
             Boolean isTerminado = verificarJuego(juegoIniciado);

            if( isTerminado ){
                
                gestosRecords.agregarData( TF_NOMBRE.getText(), TF_TIMER.getText() );
                pintarTablero(false);
                JTA_RECORDS.setText( "Juego terminado: " + isTerminado + "\n");
                
            
            }else{
               
                JTA_RECORDS.setText( "Juego terminado: " + isTerminado + "\n");

            }
            
        }
    
    }
    
}