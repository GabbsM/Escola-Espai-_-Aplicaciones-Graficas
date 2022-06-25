package Ejercicio9;

//Añade un botón para cerrar a la aplicación anterior. Nota: usa System.exit(0).

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        Container cp = getContentPane();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        cp.setLayout(new GridLayout(3,1));
        p1.setLayout(new GridLayout(2,3));
        p2.setLayout(new GridLayout(1,4));

        cp.add(p1);
        cp.add(p2);
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

        super.pack();
        resultado.setEditable(false);

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
