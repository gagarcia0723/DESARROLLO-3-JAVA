import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Archivos implements ActionListener{

    JFrame VENTANA;
    JLabel JL_NOMBRE, JL_APELLIDO;
    JTextField JT_NOMBRE, JT_APELLIDO;
    JButton JB_GRABAR, JB_LEER;
    


    public static void main(String[] args) {
        new Archivos();
    }

    Archivos(){

        VENTANA = new JFrame("MANIPULADOR DE ARCHIVOS");
        VENTANA.setBounds(100, 100, 500, 500);
        VENTANA.setLayout(null);
        VENTANA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        JL_NOMBRE = new JLabel("Nombre", null, 0);
        JL_NOMBRE.setBounds(50, 50, 80, 20);
        JT_NOMBRE = new JTextField(null, null, 0);
        JT_NOMBRE.setBounds(50 + 80, 50, 80,  20);
        JL_APELLIDO = new JLabel("Apellido", null, 0);
        JL_APELLIDO.setBounds(50, 75 , 80, 20);
        JT_APELLIDO = new JTextField(null, null, 0);
        JT_APELLIDO.setBounds(50 + 80, 75, 80,  20);
        JB_GRABAR = new JButton("Grabar", null);
        JB_GRABAR.setBounds(220, 50, 80, 20);
        JB_GRABAR.addActionListener(this);
        JB_LEER = new JButton("LEER", null);
        JB_LEER.setBounds(220, 75, 80, 20);
        JB_LEER.addActionListener(this);
        
        
        //FileWriter 

        VENTANA.add(JL_NOMBRE);
        VENTANA.add(JT_NOMBRE);
        VENTANA.add(JL_APELLIDO);
        VENTANA.add(JT_APELLIDO);
        VENTANA.add(JB_GRABAR);
        VENTANA.add(JB_LEER);
        VENTANA.setVisible(true);
    }
    
    @Override
    public void actionPerformed( ActionEvent a ){
        
        


        if( a.getSource() == JB_GRABAR ) {
           
            escribir();
            
        }

        if( a.getSource() == JB_LEER ) {
           
            leer();
           
            
        }
    
    }

    public void escribir (){
        try {
            FileWriter fw = new FileWriter("cliente.txt", true);
            fw.write( JT_NOMBRE.getText() + "\t\t" + JT_APELLIDO.getText() + "\n");
            fw.close();

         } catch(Exception e){
             System.out.println("Error detectado: " + e);

         } 
    }

    public void leer(){
        File f = new File("Cliente.txt");
        Scanner sc;

        String nombre, apellido;

        try {
               
            sc = new Scanner(f);
            System.out.println("Nombre\t\t\tApellido \n");
            while(sc.hasNext()){
                
                nombre =sc.next();
                apellido = sc.next();

                System.out.println(nombre + "\t\t\t" + apellido);
            }

        } catch(Exception e){
            System.out.println("Error detectado: " + e);
        } 
    }


    
}
