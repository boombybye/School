import java.awt.*;
import javax.swing.*;
import java.lang.*;


public class Main {

    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Inputs");
        Board panel = new Board(((int)(Math.random()*401)) / 20 * 20,((int)(Math.random()*401)) / 20 * 20,20, 20);
        //Timer hello = new Timer();
        //JTextField field = new JTextField(20);
        Inputs player = new Inputs(panel);
        panel.addKeyListener(player);
        panel.addMouseListener(player);
        panel.setFocusable(true);
        //panel.add(field);
        frame.setContentPane(panel);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        //frame.add(new InputsPanel());
        frame.setSize(400, 428);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.getContentPane().setVisible(true);
        while (true){
            boolean done = false;//add counters to each input for presses, when a key has x presses it will cause a move to occur
            try{
                Thread.sleep(100);
                
                if(!done){
                    done = true;
                if(player.l){
                    panel.moveLeft();
                    System.out.println("pollo");
                } else if(player.r){
                    panel.moveRight();
                    System.out.println("pollo");
                } else if(player.u){
                    panel.moveUp();
                    System.out.println("pollo");
                } else if(player.d){
                    panel.moveDown();
                    System.out.println("pollo");
                } else{
                    
                    /*switch(player.last){
                        case 'l': panel.moveLeft();break;
                        case 'r': panel.moveRight();break;
                        case 'u': panel.moveUp();break;
                        case 'd': panel.moveDown();break;
                    }*/
                }
                }
            } catch (InterruptedException e) {

            }
            //impliment sleep here
            
        }
    }



    
}
