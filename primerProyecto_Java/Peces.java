import java.util.*;


public class Peces {

    Random rnd = new Random();
    int POS_PECES;
    boolean juegoFinalizado = false;
    
    public static void main(String[] args) {
        new Peces();  
    } 

    Peces(){
        
        newLocation();

    }   

    public int getLocation(){
        return POS_PECES;
    }

    public void newLocation(){
        POS_PECES = rnd.nextInt(100);
        juegoFinalizado = false;
    }
   

    public String moverCardumen( int posx, int posy , int valorBoton, int INICIAL_POS_X, int INICIAL_POS_Y, int BOX_SIZE ){  
        
        int POS_X_PES = INICIAL_POS_X + 50 + BOX_SIZE * ( (POS_PECES) %10); 
        int POS_Y_PES = 510 - BOX_SIZE * ( (POS_PECES) /10);
        String messaString = "";

        /*int indiceOriginal = valorBoton;
        System.out.println( "Indice Original: " + indiceOriginal + " #posx recibida: " + posx + " #posy recibida : "+ posy + " #posx_peces: " + POS_X_PES + " #posy_peces: " + POS_Y_PES + " pos peces: " + POS_PECES );
        */
        
        if( POS_PECES == valorBoton || juegoFinalizado){
            
            messaString = "CARDUMEN ENCONTRADO - JUEGO FINALIZADO";
            juegoFinalizado = true;
            //newLocation();
            
        }else{

            if  ( ( posx == POS_X_PES + BOX_SIZE || posx == POS_X_PES - BOX_SIZE || posx == POS_X_PES ) && ( posy == POS_Y_PES + BOX_SIZE || posy == POS_Y_PES - BOX_SIZE || posy == POS_Y_PES ) ){
                
                messaString = "SE MOVIO EL CARDUMEN";
                newLocation();
               
            } else {
                
                // NOTA: INVESTIGADO EN GOOGLE, PARA EVITAR USAR TANTOS IF (Y) Y MENOS LINEAS DE CÓDIGO
                messaString = 
                    posy < POS_Y_PES && posx == POS_X_PES   ? "EL CARDUMEN ESTA AL SUR"           :  
                    posy > POS_Y_PES && posx == POS_X_PES   ? "EL CARDUMEN ESTA AL NORTE"         : 
                    posy == POS_Y_PES && posx > POS_X_PES   ? "EL CARDUMEN ESTA AL OESTE"         : 
                    posy == POS_Y_PES && posx < POS_X_PES   ? "EL CARDUMEN ESTA AL ESTE"          :
                    posx < POS_X_PES && posy < POS_Y_PES    ? "EL CARDUMEN ESTA AL SUR - ESTE"    :
                    posx > POS_X_PES && posy < POS_Y_PES    ? "EL CARDUMEN ESTA AL SUR - OESTE"   :
                    posx > POS_X_PES && posy > POS_Y_PES    ? "EL CARDUMEN ESTA AL NORT - OESTE"  :
                    posx < POS_X_PES && posy > POS_Y_PES    ? "EL CARDUMEN ESTA AL  NORT - ESTE"  :
                    ""
                ;              
            }
        }
        
        return messaString;
        
    }

}

