package Ejercicio6;

//6. Haz una aplicación que tenga 2 botones. Estos no harán nada por el momento. Nota: Usa JButton y
//JFrame.

import javax.swing.*;
import java.awt.*;

public class Ejercicio6 extends JFrame {

    private JButton boton1;
    private JButton boton2;

    public Ejercicio6(){

        super("Ejercicio 6");

        Container container = getContentPane();
        container.setPreferredSize(new Dimension(100,200));
        container.setLayout(new FlowLayout());

        boton1 = new JButton("Boton 1");
        boton2 = new JButton("Boton 2");
        container.add(boton1);
        container.add(boton2);

        super.pack();
        super.show();
        super.setVisible(true);
    }

    public static void main(String[] args) {
        new Ejercicio6();
    }

}
