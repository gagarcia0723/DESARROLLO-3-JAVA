import javax.swing.JButton;

public class piezas extends JButton{

    void moverPieza( int x, int y , int incremento){
        
        
        boolean move = true;
        int incrementoX = incremento;
        int incrementoY = incremento;
        
        if( this.getX() > x ){
            incrementoX = incrementoX * -1;
            System.out.println(incrementoX);
        }

        if( this.getY() > y ){
            incrementoY = incrementoY * -1;
        }

        if(this.getY() == y ){
            incrementoY = 0;
        }

         if(this.getX() == x ){
            incrementoX = 0;
        }
        
        System.out.println("##" + this.getText() + ": Estoy en X: " + this.getX() + "Y: " + this.getY() +" Me movere a X: " + x + "Y: " + y + "" );  
        System.out.println("Entrando al ciclo");
        
        while( move ){

            if( this.getX() == x && this.getY() == y){
                
                move = false;
                
            }else{
                this.setLocation( this.getX() + incrementoX, this.getY() + incrementoY );
                
                this.repaint();
            }
            
            
        }

        System.out.println("#" + this.getText() + ": Llegando a X: " + this.getX() + "Y: " + this.getY() );
        
    }
}
