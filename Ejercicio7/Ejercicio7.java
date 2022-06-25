package Ejercicio7;

//7. Modifica el ejercicio anterior, y añade una caja de texto. Cuando pulsemos el botón1, debe
//aparecer el texto “hola!” y cuando pulsemos el 2, “adios!”.

import javax.swing.*;
import java.awt.*;

public class Ejercicio7 extends JFrame {

    private JButton boton1;
    private JButton boton2;

    public Ejercicio7(){

        super("Ejercicio 7");

        Container container = getContentPane();
        container.setPreferredSize(new Dimension(100,200));
        container.setLayout(new FlowLayout());

        boton1 = new JButton("Boton 1");
        boton2 = new JButton("Boton 2");
        boton1.addActionListener(new miActionListener());
        boton2.addActionListener(new miActionListener2());
        container.add(boton1);
        container.add(boton2);

        super.pack();
        super.show();
        super.setVisible(true);
    }

    public static void main(String[] args) {
        new Ejercicio7();
    }
}
