import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.*;


public class BattleshipGUI {
    static JFrame main = new JFrame("Battleship");
    static Font newFont = new Font("BankGothic Lt BT",Font.PLAIN,36);
    public static void main (String args[])
    {
        titleScreen();
    }
    public static void optionsMenu()
    {
        JLabel sound = new JLabel("SOUND:");
        JLabel difficulty = new JLabel("DIFFICULTY:");
        JButton soundON = new JButton("ON");
        JButton soundOFF = new JButton("OFF");
        JButton easy = new JButton("EASY");
        JButton medium = new JButton("MEDIUM");
        JButton hard = new JButton("HARD");
        JLabel h2p = new JLabel("HOW TO PLAY");
        JLabel options = new JLabel("Options");
        JTextArea instruc = new JTextArea("The objective of this game is to protect your fleet " +
                "of ships as well as destroy the enemy fleet. " +
                "You may choose the position of " +
                "4 different boats in your fleet. " +
                "You and the enemy will take turns" +
                " exchanging fire, good luck.");
        JButton Back = new JButton("Back");
        sound.setFont(newFont);
        sound.setForeground(Color.WHITE);
        sound.setBounds(50, 150, 170, 50);
        difficulty.setFont(newFont);
        difficulty.setForeground(Color.WHITE);
        difficulty.setBounds(30, 250, 250, 50);
        soundON.setBounds(225, 150, 100, 50);
        soundOFF.setBounds(350, 150, 100, 50);
        easy.setBounds(280, 270, 75, 25);
        medium.setBounds(360, 270, 100, 25);
        hard.setBounds(330, 300, 75, 25);
        instruc.setLineWrap(true);
        instruc.setWrapStyleWord(true);
        instruc.setEditable(false);
        instruc.setBackground(Color.GRAY);
        instruc.setForeground(Color.WHITE);
        instruc.setBounds(70, 500, 350, 100);
        options.setFont(newFont);
        options.setForeground(Color.WHITE);
        options.setBounds(170, 10, 200, 100);
        h2p.setFont(newFont);
        h2p.setForeground(Color.WHITE);
        h2p.setBounds(120, 300, 300, 300);
        Back.setForeground(Color.BLACK);
        Back.setBounds(40,20,75,25);
        main.add(options);
        main.add(instruc);
        main.add(sound);
        main.add(difficulty);
        main.add(soundON);
        main.add(soundOFF);
        main.add(easy);
        main.add(medium);
        main.add(hard);
        main.add(h2p);
        main.add(Back);
        Back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                titleScreen();
            }
        });
    }
    public static void titleScreen()
    {
        main.getContentPane().removeAll();
        main.revalidate();
        main.repaint();
        main.getContentPane().setBackground(Color.BLACK);
        main.setSize(500,700);
        main.setLayout(null);
        main.setVisible(true);
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Battleship");
        title.setFont(newFont);
        title.setForeground(Color.WHITE);
        title.setBounds(130,10,300,300);
        main.add(title);

        ImageIcon pic = new ImageIcon("BattleShipTitle.jpg");
        JLabel titlepic = new JLabel(pic);
        titlepic.setBounds(50,100,400,350);
        main.add(titlepic);

        JButton options = new JButton("Options");
        options.setFont(newFont);
        options.setForeground(Color.GRAY);
        options.setBounds(100, 500, 300, 50);

        JButton start = new JButton("Start");
        start.setFont(newFont);
        start.setForeground(Color.GRAY);
        start.setBounds(100, 400, 300, 50);
        main.add(options);
        main.add(start);
        main.repaint();
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    MainGameGUI.create();
                    MainGameGUI.filltest();
                    MainGameGUI.launch();
                }catch (IOException f){
                    System.out.println("IOE caught");
                }
            }
        });

        options.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                main.getContentPane().removeAll();
                main.revalidate();
                main.repaint();
                optionsMenu();
            }
        });
    }
}
