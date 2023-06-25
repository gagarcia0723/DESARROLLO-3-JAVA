    import javax.swing.*;
    import java.awt.*;
    
    public class Contador {
    
        JFrame ventana;
        JTextField TF_CONTADOR;
        
        Timer timer = new Timer(1000, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                TF_CONTADOR.setText( String.valueOf(Integer.parseInt(TF_CONTADOR.getText()) + 1 ) );
            }
        });
    

        public static void main(String[] args) {
            
            new Contador();
        
        }

        Contador () { 
            ventana = new JFrame("C");
            ventana.setBounds(100, 100, 500, 500);
            ventana.setLayout(null);
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            TF_CONTADOR = new JTextField("0");
            TF_CONTADOR.setBounds(50,50,50,50);

            ventana.add(TF_CONTADOR);

            ventana.setVisible(true);

        }
        
    }
