import javax.swing.*;
import java.awt.event.*;

public class Grafico implements ActionListener {

    JFrame ventana;
    JLabel lbl_nombre , lbl_apellido;
    JTextField tf_nombre, tf_apellido;
    JButton btn_escribir, btn_copiar, btn_doble;
    


    public static void main(String[] args) {
        new Grafico();

    }
    
    Grafico(){

        ventana = new JFrame("Mi ventana");
        ventana.setSize(300,300);
        ventana.setLocation(200,200);
        ventana.setLayout(null);

        lbl_nombre = new JLabel("Nombre:");
        lbl_nombre.setBounds(50,50,70,20);
        
        tf_nombre = new JTextField();
        tf_nombre.setBounds(125, 50, 100, 20);        

        lbl_apellido = new JLabel("Apellido:");
        lbl_apellido.setBounds(50,100,70,20);
        
        tf_apellido = new JTextField();
        tf_apellido.setBounds(125, 100, 100, 20);

        btn_escribir = new JButton("Escribir");
        btn_escribir.setBounds(50, 150, 80,20);
        btn_escribir.addActionListener(this);

        btn_copiar = new JButton("Copiar");
        btn_copiar.setBounds(150, 150, 80,20);
        btn_copiar.addActionListener(this);

        btn_doble = new JButton("Doble");
        btn_doble.setBounds(220, 150, 80,20);
        btn_doble.addActionListener(this);


        ventana.add(lbl_nombre);
        ventana.add(tf_nombre);
        ventana.add(lbl_apellido);
        ventana.add(tf_apellido);
        ventana.add(btn_escribir);
        ventana.add(btn_copiar);
        ventana.add(btn_doble);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
       
        if( e.getSource() == btn_escribir ){
            tf_nombre.setText("Juan");
        }
       
        if( e.getSource() == btn_copiar ){
            tf_apellido.setText( tf_nombre.getText() );
        }

        if( e.getSource() == btn_doble ){
            int valor;
            valor = Integer.parseInt( tf_nombre.getText() );
            
            tf_apellido.setText( String.valueOf( valor * 2 ) );


        }

    }

    
}
