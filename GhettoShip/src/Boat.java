import javax.swing.*;

/**
 * Created by IK on 31/05/2015.
 */
abstract class Boat {
    protected static int playerBoats = 4;
    protected static boolean hasMissile;
    protected static boolean hasRadar;
    protected int health;
    private int boatID;
    protected ImageIcon boatImg;

    public Boat (int h, int b){
        this.health = h;
        this.boatID = b;
    }
    abstract void loadImg();

    public String toString (){
        if (this.boatID == 1)
            return "x";
        else if (this.boatID == 2)
            return "o";
        else if (this.boatID == 3)
            return "#";
        else if (this.boatID == 4)
            return "@";
        else
            return "~";
    }
    public int getBoatID(){
        return this.boatID;
    }
}
