import javax.swing.*;
import java.awt.*;
import java.lang.*;

public class SpaceInvaders{

public static void main(String[] args) {
    Player player = new Player(20,360,20,20);
    Aliens aliens = new Aliens(400, 200, 10, 10, true);
    JFrame frame = new JFrame();
    Space space = new Space(player, aliens);
    Inputs inputs = new Inputs(space, 10);
    player.addInputs(inputs);
    frame.setContentPane(space);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new FlowLayout());
    frame.setSize(400, 428);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    frame.getContentPane().setVisible(true);
    space.addKeyListener(inputs);
    space.setFocusable(true);
    /*while(true){
        try{//player.fire();Thread.sleep(8);
        }catch(Exception e){}
    }*/


}

}