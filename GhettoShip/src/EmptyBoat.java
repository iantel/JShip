import javax.swing.*;

/**
 * Created by 072909328 on 6/1/2015.
 */
public class EmptyBoat extends Boat {

    public EmptyBoat(){
        super(0,0);
        this.boatImg = new ImageIcon("waterblock.jpg");
    }

    @Override
    public void loadImg() {

    }
}
