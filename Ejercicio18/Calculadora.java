package Ejercicio18;

//Vamos a mejorar el aspecto de nuestro programa, en lugar de tener un boton “salir” vamos a crear
//un menú con esa opción. Así que elimina el botón indicado, y crea un menú que tendrá la
//siguiente estructura:
//archivo ->exportar como TXT
//->salir
//Cuando pulsemos en salir deberá salir de la aplicación.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import static java.awt.Color.white;

public class Calculadora extends JFrame {


    public Calculadora(){

        JLabel lbl1 = new JLabel("Primer operando");
        JLabel llb2 = new JLabel("Segundo operando");
        JLabel lbl3 = new JLabel("Resultado");
        JLabel lbl4 = new JLabel("Lista de resultados:");
        lbl4.setHorizontalAlignment(JLabel.CENTER);
        JLabel lbl5 = new JLabel("Opciones de combo");
        lbl5.setHorizontalAlignment(JLabel.CENTER);
        JLabel lbl6 = new JLabel("Contenido TextArea");
        lbl6.setHorizontalAlignment(JLabel.CENTER);

        JLabel lnorte = new JLabel("Calculadora 1.0");
        JLabel lsur = new JLabel("Todos los derechos reservados");

        JMenuBar mb = new JMenuBar();
        JMenu menu = new JMenu("Archivo");
        JMenuItem mi1 = new JMenuItem("Exportar como TXT");
        JMenuItem mi2 = new JMenuItem("Salir");
        setJMenuBar(mb);
        mb.add(menu);
        menu.add(mi1);
        menu.add(mi2);




        final JTextField campo1 = new JTextField(10);
        final JTextField campo2 = new JTextField(10);
        final JTextField resultado = new JTextField(10);

        JButton btn1 = new JButton("+");
        JButton btn2 = new JButton("-");
        JButton btn3 = new JButton("*");
        JButton btn4 = new JButton("/");
        JButton btn5 = new JButton("Salir");
        JButton btn6 = new JButton("Color");


        JList lista = new JList<>();
        JComboBox combo = new JComboBox<>();
        combo.addItem("Escoge una opcion");
        combo.addItem("Borrar Textfields");
        combo.addItem("Borrar lista");
        combo.addItem("Mostrar lista como texto");
        JTextArea jta = new JTextArea();

        Checkbox check1 = new Checkbox("Texto rojo y negro");
        Checkbox check2 = new Checkbox("Bloquear todo");

        Container cp = getContentPane();

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();
        JPanel central  = new JPanel();

        //cp.setLayout(new GridLayout(4,1));
        //cp.setLayout(new GridLayout(3,1));
        cp.setLayout(new BorderLayout());

        p1.setLayout(new GridLayout(2,3));
        p2.setLayout(new GridLayout(1,4));
        p3.setLayout(new GridLayout(1,2));
        p4.setLayout(new GridLayout(2,1));
        p5.setLayout(new GridLayout(2,1));
        p6.setLayout(new GridLayout(2,1));

        central.setLayout(new GridLayout(6,1));

        central.add(p1);
        central.add(p2);
        central.add(p3);
        central.add(p4);
        central.add(p5);
        central.add(p6);
        cp.add(central,BorderLayout.CENTER);
        cp.add(lnorte, BorderLayout.NORTH);
        cp.add(lsur,BorderLayout.SOUTH);




       /* cp.add(p1);
        cp.add(p2);
        cp.add(p3);
        cp.add(p4);
        cp.add(p5);
        cp.add(p6);*/

        p1.add(lbl1);
        p1.add(llb2);
        p1.add(lbl3);
        p1.add(campo1);
        p1.add(campo2);
        p1.add(resultado);
        p2.add(btn1);
        p2.add(btn6);
        p2.add(btn2);
        p2.add(btn3);
        p2.add(btn4);
        p2.add(btn5);
        p3.add(check1);
        p3.add(check2);
        p4.add(lista);
        p5.add(combo);
        p6.add(jta);
        p4.add(lbl4);
        p5.add(lbl5);
        p6.add(lbl6);

        super.pack();
        resultado.setEditable(false);

        Vector datos = new Vector<>();

        mi1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(Calculadora.this,"Selecciones un color",
                        white);

                cp.setBackground(color);
                central.setBackground(color);
                p1.setBackground(color);
                p2.setBackground(color);
                p3.setBackground(color);
                p4.setBackground(color);
                p5.setBackground(color);
                p6.setBackground(color);
            }
        });

        combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(combo.getSelectedIndex()==1){
                    campo1.setText("");
                    campo2.setText("");
                    resultado.setText("");
                } else if (combo.getSelectedIndex()==2) {
                    datos.clear();
                    lista.setListData(datos);
                } else if (combo.getSelectedIndex()==3) {
                    String p = datos.toString();
                    p = p.replace(",","\n").replace("]","");
                    jta.setText(p);
                }
            }
        });

        check1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                if(check1.getState()==true){
                    campo1.setForeground(Color.RED);
                    campo2.setForeground(Color.RED);
                    resultado.setForeground(Color.RED);
                }else {
                    campo1.setForeground(Color.BLACK);
                    campo2.setForeground(Color.BLACK);
                    resultado.setForeground(Color.BLACK);
                }
            }
        });

        check2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(check2.getState()==true){
                    campo1.setEnabled(false);
                    campo2.setEnabled(false);
                    resultado.setEnabled(false);
                    btn1.setEnabled(false);
                    btn2.setEnabled(false);
                    btn3.setEnabled(false);
                    btn4.setEnabled(false);
                    btn5.setEnabled(false);
                    check1.setEnabled(false);

                }else {
                    campo1.setEnabled(true);
                    campo2.setEnabled(true);
                    resultado.setEnabled(true);
                    btn1.setEnabled(true);
                    btn2.setEnabled(true);
                    btn3.setEnabled(true);
                    btn4.setEnabled(true);
                    btn5.setEnabled(true);
                    check1.setEnabled(true);
                }
            }
        });

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int suma = 0;
                suma = Integer.valueOf(campo1.getText()) + Integer.valueOf(campo2.getText());
                resultado.setText(Integer.toString(suma));
                String p = campo1.getText() + " + " + campo2.getText() + " = " + resultado.getText();
                datos.add(p);
                lista.setListData(datos);

            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resta = 0;
                resta = Integer.valueOf(campo1.getText()) - Integer.valueOf(campo2.getText());
                resultado.setText(Integer.toString(resta));
                String p = campo1.getText() + " + " + campo2.getText() + " = " + resultado.getText();
                datos.add(p);
                lista.setListData(datos);

            }
        });

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int multiplicacion = 0;
                multiplicacion = Integer.valueOf(campo1.getText()) * Integer.valueOf(campo2.getText());
                resultado.setText(Integer.toString(multiplicacion));
                String p = campo1.getText() + " + " + campo2.getText() + " = " + resultado.getText();
                datos.add(p);
                lista.setListData(datos);

            }
        });

        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int division = 0;
                division = Integer.valueOf(campo1.getText()) / Integer.valueOf(campo2.getText());
                resultado.setText(Integer.toString(division));
                String p = campo1.getText() + " + " + campo2.getText() + " = " + resultado.getText();
                datos.add(p);
                lista.setListData(datos);

            }
        });

        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              System.exit(0);

            }
        });


    }



    public static void main(String[] args) {
        new Calculadora().setVisible(true);
    }
}
