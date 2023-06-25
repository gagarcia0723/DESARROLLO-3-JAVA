import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.*;

public class Mover implements ActionListener{

    JFrame ventana;
    JButton BTN_N1, BTN_BAJAR, BTN_SUBIR, BTN_IZQ, BTN_DER;

    public static void main(String[] args) {
        new Mover();
    }
    
    Mover(){
        ventana = new JFrame("Mover ", null);
        ventana.setBounds(100, 100, 500, 500);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);


        BTN_N1 = new JButton("", null);
        BTN_N1.setBounds(300, 400, 20, 20);
        BTN_N1.addActionListener(this);

        ventana.add(BTN_N1);


        BTN_BAJAR = new JButton("BAJAR", null);
        BTN_BAJAR.setBounds(900, 400, 80, 20);
        BTN_BAJAR.addActionListener(this);

        BTN_SUBIR = new JButton("SUBIR", null);
        BTN_SUBIR.setBounds(900, 200, 80, 20);
        BTN_SUBIR.addActionListener(this);

        BTN_IZQ = new JButton("IZQ", null);
        BTN_IZQ.setBounds(800, 300, 80, 20);
        BTN_IZQ.addActionListener(this);

        BTN_DER = new JButton("DER", null);
        BTN_DER.setBounds(1000, 300, 80, 20);
        BTN_DER.addActionListener(this);


        ventana.add(BTN_BAJAR);
        ventana.add(BTN_SUBIR);
        ventana.add(BTN_IZQ);
        ventana.add(BTN_DER);

        ventana.setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        int x,  y;

        x = BTN_N1.getLocation().x;
        y = BTN_N1.getLocation().y;

        if(e.getSource() == BTN_BAJAR){
            BTN_N1.setLocation(x , y + 20);
        }

        if(e.getSource() == BTN_SUBIR){
            BTN_N1.setLocation(x , y - 20);
        }

        if(e.getSource() == BTN_IZQ){
            BTN_N1.setLocation(x - 20 , y);
        }

        if(e.getSource() == BTN_DER){
            BTN_N1.setLocation(x + 20 , y);
        }

    }
}
