package Ejercicio10;

//Añade 2 JCheckBox al ejercicio anterior.
//- Cuando el 1º esté activo, el tipo de letra de los JTextField será rojo, cuando esté inactivo
//negro.
//- Cuando el 2º esté activo, todos los otros componentes (menos el checkbox actual) se
//bloquearán.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Calculadora extends JFrame {


    public Calculadora(){

        JLabel lbl1 = new JLabel("Primer operando");
        JLabel llb2 = new JLabel("Segundo operando");
        JLabel lbl3 = new JLabel("Resultado");

        final JTextField campo1 = new JTextField(10);
        final JTextField campo2 = new JTextField(10);
        final JTextField resultado = new JTextField(10);

        JButton btn1 = new JButton("+");
        JButton btn2 = new JButton("-");
        JButton btn3 = new JButton("*");
        JButton btn4 = new JButton("/");
        JButton btn5 = new JButton("Salir");
        Checkbox check1 = new Checkbox("Texto rojo y negro");
        Checkbox check2 = new Checkbox("Bloquear todo");

        Container cp = getContentPane();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        cp.setLayout(new GridLayout(3,1));
        p1.setLayout(new GridLayout(2,3));
        p2.setLayout(new GridLayout(1,4));

        cp.add(p1);
        cp.add(p2);
        cp.add(p3);
        p1.add(lbl1);
        p1.add(llb2);
        p1.add(lbl3);
        p1.add(campo1);
        p1.add(campo2);
        p1.add(resultado);
        p2.add(btn1);
        p2.add(btn2);
        p2.add(btn3);
        p2.add(btn4);
        p2.add(btn5);
        p3.add(check1);
        p3.add(check2);

        super.pack();
        resultado.setEditable(false);

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

            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resta = 0;
                resta = Integer.valueOf(campo1.getText()) - Integer.valueOf(campo2.getText());
                resultado.setText(Integer.toString(resta));

            }
        });

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int multiplicacion = 0;
                multiplicacion = Integer.valueOf(campo1.getText()) * Integer.valueOf(campo2.getText());
                resultado.setText(Integer.toString(multiplicacion));

            }
        });

        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int division = 0;
                division = Integer.valueOf(campo1.getText()) / Integer.valueOf(campo2.getText());
                resultado.setText(Integer.toString(division));

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
