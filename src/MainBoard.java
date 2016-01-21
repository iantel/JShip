import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IK on 31/05/2015.
 */
public class MainBoard {
    static Boat [][] board = new Boat[20][16];
    static Map<Character,Integer> map = new HashMap();

    public static void fillBoard() throws IOException {
        fillMap();
        for (int i = 0; i < 20; i++) {
            for (int x = 0; x < 16; x++) {
                Boat gen = new EmptyBoat();
                board[i][x] = gen;
            }
        }
    }
        //GUI BUT NOT BUILT IN YET
    public static void startGame() throws IOException{
        drawBoard();
        launchLater(1);
    }
    public static void drawBoard () throws IOException{
        BattleshipGUI.main.getContentPane().removeAll();
        MainGameGUI.create();
        BattleshipGUI.main.revalidate();
        BattleshipGUI.main.repaint();
        for (int i = 0; i < 16; i++){
            for (int x = 0; x < 20; x++){
                int xDisplace = 33 + (16*i);
                ImageIcon t = MainBoard.board[x][i].boatImg;
                ImageIcon t2 = MainBoard.board[x][i].boatImg;
                JLabel test = new JLabel(t);
                test.setBounds(xDisplace, 230, 12, 17);
                BattleshipGUI.main.add(test);
                int yDisplace = 230 + (21*x);
                JLabel test2= new JLabel(t2);
                test2.setBounds(xDisplace,yDisplace, 12, 17);
                BattleshipGUI.main.add(test2);
            }
        }

    }
    public static void boatSelect(int shipclass) throws IOException{
        String [] coords = startPosition(shipclass).split(" ");
        int x = map.get(coords[1].charAt(0));
        int y = map.get(coords[0].charAt(0));
        if (shipclass == 1) {//destroyer
            orientDestroyer(1, 2, x, y);
            drawBoard();
            launchLater(2);
        }
        else if (shipclass == 2) {//scout
            orientDestroyer(2, 1, x, y);
            drawBoard();
            launchLater(3);
        }
        else if (shipclass == 3) {//carrier
            orientDestroyer(3, 4, x, y);
            drawBoard();
            launchLater(4);
        }
        else if (shipclass == 4) {//sub
            orientDestroyer(4, 3, x, y);
            drawBoard();
        }
    }
    public static void orientDestroyer (int bID, int boatSize, int xCoord, int yCoord) throws IOException{
        BufferedReader oInput = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Orientation UP(1), DOWN(2), LEFT(3), RIGHT(4): ");
        int orientation = Integer.parseInt(oInput.readLine());
        try {
            if (orientation == 1) {
                for (int s = 0; s < boatSize; s++) {
                    int x = xCoord - s -1;
                    int y = yCoord -1;
                    if(!isOccupied(x,y,bID)){
                        break;
                    }
                    board[x][y] = boatType(bID);
                }
            } else if (orientation == 2) {
                for (int s = 0; s < boatSize; s++) {
                    int x = xCoord + s -1;
                    int y = yCoord - 1;
                    if(!isOccupied(x,y,bID)){
                        break;
                    }
                    board[x][y] = boatType(bID);
                }
            } else if (orientation == 3) {
                for (int s = 0; s < boatSize; s++) {
                    int x = xCoord - 1;
                    int y = yCoord - s - 1;
                    if(!isOccupied(x,y,bID)){
                        break;
                    }
                    board[x][y] = boatType(bID);
                }
            } else if (orientation == 4) {
                for (int s = 0; s < boatSize; s++) {
                    int x = xCoord - 1;
                    int y = yCoord + s -1;
                    if(!isOccupied(x,y,bID)){
                        break;
                    }
                    board[x][y] = boatType(bID);
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Boat won't fit! Input different orientation");
            removeBoat(bID);
            orientDestroyer(bID, boatSize, xCoord, yCoord);
        }
        catch(NumberFormatException n){
            System.out.println("Invalid Input. Not Integer");
            orientDestroyer(bID, boatSize, xCoord, yCoord);
        }
    }
    public static Boat boatType(int type){
        Boat b;
        if (type == 1){
            b = new Destroyer();
            return b;
        }
        else if (type == 2){
            b = new Scout();
            return b;
        }
        else if (type == 3){
            b = new Carrier();
            return b;
        }
        else{
            b = new Submarine();
            return b;
        }
    }

    public static String startPosition(int c) throws IOException{
        BufferedReader userin = new BufferedReader(new InputStreamReader(System.in));
        if (c == 1)
            System.out.println("PLACE DESTROYER");
        else if (c == 2)
            System.out.println("PLACE SCOUT");
        else if (c == 3)
            System.out.println("PLACE CARRIER");
        else if (c == 4) {
            System.out.println("PLACE SUBMARINE");
        }
        System.out.print("Coordinates you want to start at: " + "\n" + "x: ");
        char x = userin.readLine().toUpperCase().charAt(0);
        System.out.print("y: ");
        char y = userin.readLine().toUpperCase().charAt(0);
        if (map.get(x) > 16 || map.get(y) > 20 || map.get(x) < 1 || map.get(y) < 1){
            System.out.println("Invalid Input.");
            return startPosition(c);
        }
        return x + " " + y;
    }

    public static void removeBoat (int bID){
        for (int i = 0; i < 20; i++){
            for (int x = 0; x < 16; x++){
               if (board[i][x].getBoatID() == bID)
                   board[i][x] = new EmptyBoat();
            }
        }
    }
    public static boolean isOccupied(int x, int y, int bID) throws IOException{
        if (board[x][y].getBoatID() != 0){
            System.out.println("Coordinate Occupied, resetting board");
            removeBoat(bID);
            fillBoard();
            drawBoard();
            startGame();
            return false;
        }
        return true;
    }

    public static void fillMap (){
        for (int i=0; i < 20; i++){
            map.put((char) (i + 65),i+1);
        }
    }
    public static void launchLater(final int i){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    boatSelect(i);
                } catch (IOException f) {
                    System.out.println("IOE caught");
                }
            }
        });
    }
}
