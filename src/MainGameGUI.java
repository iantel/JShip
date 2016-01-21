import javax.swing.*;

import java.awt.Font;
import java.io.IOException;


public class MainGameGUI {
    static JTextArea console = new JTextArea(5,20);
    public static void create() throws IOException
    {
        Font defaultfont = new Font("Calibri",Font.PLAIN,12);

        BattleshipGUI.main.getContentPane().removeAll();
        BattleshipGUI.main.revalidate();
        BattleshipGUI.main.repaint();

        ImageIcon steel = new ImageIcon("Steel3.jpg");
        JLabel wallpaper = new JLabel(steel);
        wallpaper.setBounds(0,0,490,200);
        BattleshipGUI.main.add(wallpaper);

        ImageIcon steel1 = new ImageIcon("Steel2.jpg");
        JLabel wallpaper1 = new JLabel(steel1);
        wallpaper1.setBounds(290,200,200,490);
        //BattleshipGUI.main.add(wallpaper1);

        ImageIcon radar = new ImageIcon("Radar-scan.gif");
        JLabel radarSample = new JLabel(radar);
        radarSample.setBounds(320,25,128,140);
        wallpaper.add(radarSample);

        ImageIcon xpic = new ImageIcon("X-Axis.jpg");
        JLabel xaxis = new JLabel(xpic);
        xaxis.setBounds(10,190,290,50);
        BattleshipGUI.main.add(xaxis);

        ImageIcon ypic = new ImageIcon("Y-Axis.jpg");
        JLabel yaxis = new JLabel(ypic);
        yaxis.setBounds(-10, 190, 50, 500);
        BattleshipGUI.main.add(yaxis);

        ImageIcon box1 = new ImageIcon("box1.jpg");
        JLabel ship1 = new JLabel(box1);
        ship1.setBounds(120,35,60,60);
        wallpaper.add(ship1);

        JTextField title1 = new JTextField("Destroyer");
        title1.setBounds(117,15,67,18);
        title1.setFont(defaultfont);
        title1.setHorizontalAlignment(JTextField.CENTER);
        wallpaper.add(title1);

        ImageIcon box2 = new ImageIcon("box2.jpg");
        JLabel ship2 = new JLabel(box2);
        ship2.setBounds(40,35,60,60);
        wallpaper.add(ship2);

        JTextField title2 = new JTextField("Carrier");
        title2.setBounds(37,15,67,18);
        title2.setFont(defaultfont);
        title2.setHorizontalAlignment(JTextField.CENTER);
        wallpaper.add(title2);

        ImageIcon box3 = new ImageIcon("box3.jpg");
        JLabel ship3 = new JLabel(box3);
        ship3.setBounds(40,120,60,60);
        wallpaper.add(ship3);

        JTextField title3 = new JTextField("Scout");
        title3.setBounds(37,100,67,18);
        title3.setFont(defaultfont);
        title3.setHorizontalAlignment(JTextField.CENTER);
        wallpaper.add(title3);

        ImageIcon box4 = new ImageIcon("box4.jpg");
        JLabel ship4 = new JLabel(box4);
        ship4.setBounds(120,120,60,60);
        wallpaper.add(ship4);

        JTextField title4 = new JTextField("Submarine");
        title4.setBounds(117,100,67,18);
        title4.setFont(defaultfont);
        wallpaper.add(title4);

//        console.setEditable(false);
//        console.setLineWrap(true);
//        JPanel textback = new JPanel(new BorderLayout());
//        textback.setBounds(310,220,150,440);
//        textback.setBorder(new TitledBorder("Console"));
//        textback.add(console);
//        BattleshipGUI.main.add(textback);
//
//        PrintStream out = new PrintStream(new TextAreaOutputStream(console));
//        System.setOut(out);
//        System.setErr(out);

    }
    public static void launch() throws IOException{
        MainBoard.startGame();
    }
    public static void filltest() throws IOException{
        MainBoard.fillBoard();
    }
}
