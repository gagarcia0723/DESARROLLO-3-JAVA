# DESARROLLO-3-JAVA
CURSO DE JAVA - UTP PANAMA


Este curso esta basado en Java, no se esta utilizando ide de programación,
Se busca lograr una mayor portabilidad en los programas creados.

PASOS PARA LA CREACION DE UN PROGRAMA DE VENTANA: 
0. importamos la libreria de JFrane

<pre> AREA DE IMPORTACION < import javax.swing.*; </pre> 

1. primero se define la ventana , mediante la declaracion de la misma.

<pre> GLOBAL < JFrame ventana </pre >

2. Generamos el código necesario para crear la ventana en el constructor de la clase.

<pre><br>
    ventana = new JFrame("Aleatorio");
    ventana.setBounds(100,100,300,300);
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.setLayout(null);
    ventana.setVisible(true);
</pre> 

<br><br>
<h1> ESTRUCTURA GENERAL DE UNA CLASE DE JAVA </h1>

<pre><br>
    // ZONA DE IMPORTACION

    public class Proyecto {
        
        // GLOBAL
        
        public static void main(String[] args) {
            
            new Proyecto();


        }

        Proyecto() {
        
            // CONSTRUCTO
        
        }
    
    }

</pre>

<br><br>
<h1> CREACIÓN DE UN BOTON </h1>

<pre><br>
    GLOBAL < JButton JB_GENERAR
    IMPORTACION < import java.awt.event.*; //PARA MANEJAR LOS EVENTOS
    
    
    JB_GENERAR = new JButton("GENERAR");
    JB_GENERAR.setBounds(50, 75, 70, 20);
    JB_GENERAR.addActionListener(this);

    // IMPLEMENTAR EN EN NOMBRE DE LA CLASE PRINCIPAL PARA MANEJAR LOS EVENTOS

    public class Calculadora implements ActionListener{

    }

    //INTERFAZ PARA EVENTOS
    @Override
    public void actionPerformed(ActionEvent e) {
        if( e.getSource() == #NOMBRE_OBJETO){
            
        }

        // ESTO PERMITE VERIFICAR QUE BOTON FUE PRESIONADO EN EL SISTEMA
    
    }
</pre>

<br><br>
<h1> CREACIÓN DE UN LABEL </h1>

<pre><br>
    GLOBAL < JLabel LBL_NUMERO; 

    LBL_NUMERO = new JLabel("Numero");
    LBL_NUMERO.setBounds(50, 50, 80, 20);
</pre>

<br><br>
<h1> CREACIÓN DE UN TEXT FIELD </h1>

<pre><br>
    GLOBAL < JTextField TF_NUMERO;

    TF_NUMERO = new JTextField();
    TF_NUMERO.setBounds(135, 50, 80, 20);
</pre>


<br><br>
<h1> CREACION DE UN CHECKBOX </h1>

<pre><br>
    GLOBAL <   JCheckBox  JC_MULTI;
    
    JC_MULTI = new JCheckBox();
    JC_MULTI.setBounds(300, 150, 50,50);

</pre>


<br><br>
<h1> GENERANDO NUMEROS ALEATORIOS </h1>

<pre><br>
    ZONA DE IMPORTACION < import java.util.Random;
    GLOBAL < Random rnd;
    CONSTRUCTOR <   rnd = new Random();
    rnd.nextInt(100)) ## Para generar el numero aleatorio
</pre>



  