import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;

public class piezas extends JButton{

    int incrementoX ;
    int incrementoY ;

    void moverPieza(int x, int y, int incremento) {

        incrementoX = incremento;
        incrementoY = incremento;

        incrementoX = (getX() > x) ? incrementoX * -1 : (getX() == x) ? 0 : incrementoX;
        incrementoY = (getY() > y) ? incrementoY * -1 : (getY() == y) ? 0 : incrementoY;

        Timer timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( getX() != x || getY() != y) {
                    setLocation(getX() + incrementoX, getY() + incrementoY);
                    repaint();
                } else {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        
        timer.start();
    }

}
