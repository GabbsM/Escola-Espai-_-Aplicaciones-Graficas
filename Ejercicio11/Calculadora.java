package Ejercicio11;

//Añade un JList al ejercicio anterior, en él guardaremos cada uno de los resultados que obtengamos
//de la calculadora. Por ejemplo, cuando pulses en “+” el resultado se guardará en la lista. Si luego
//pulsas en “-“, se guardará a continuación en la misma lista y así sucesivamente. El formato en que
//se guardará será el siguiente:
//3 x 5 = 15
//6 - 9 = -3

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

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
        JList lista = new JList<>();
        Checkbox check1 = new Checkbox("Texto rojo y negro");
        Checkbox check2 = new Checkbox("Bloquear todo");

        Container cp = getContentPane();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        cp.setLayout(new GridLayout(4,1));
        cp.setLayout(new GridLayout(3,1));
        p1.setLayout(new GridLayout(2,3));
        p2.setLayout(new GridLayout(1,4));
        p4.setLayout(new GridLayout(1,1));

        cp.add(p1);
        cp.add(p2);
        cp.add(p3);
        cp.add(p4);
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
        p4.add(lista);

        super.pack();
        resultado.setEditable(false);

        Vector datos = new Vector<>();

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
