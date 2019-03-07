package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PauseButton {
    static int count = 0;
    static boolean marche = true;
    static Thread mythread;
    static JButton button = new JButton("Pause");
    private JFrame fen;

    public PauseButton(JFrame fen) {

        fen.getContentPane().add(button);
        fen.setLocationRelativeTo(null);
        fen.setVisible(true);
        updateBouton();
        setButtonLis();
        
    }

    public static void updateBouton() {
        mythread = new Thread() {
            public void run() {
//            for (int i = 0; i < 100; i++) {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(marche) {
                        button.setText("Pause " + ++count);
                    }
                }
//            }
            }
        };
        mythread.start();
    }

    static public void setButtonLis() {

        button.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

                if (marche)
                    marche = false;
                else
                    marche = true;
                new Thread() {
                    public void run() {
                        System.out.print(marche + " ");
                    }
                }.start();
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
            }

            @Override
            public void mousePressed(MouseEvent arg0) {
            }

            @Override
            public void mouseReleased(MouseEvent arg0) {
                // button.setText("Pause");
            }
        });

    }
}