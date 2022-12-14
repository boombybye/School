import java.awt.event.*;
//import java.lang.*;

public class Inputs implements KeyListener{
    public Space space;
    public int speed;
    public boolean firing;
    public boolean left;
    public boolean right;
    public boolean fire;
    public Inputs(Space e, int d){
        space = e;
        speed = d;
    }

    public void keyTyped(KeyEvent e){

    }

    public void keyPressed(KeyEvent e){
        
        /*if(e.getKeyCode() == KeyEvent.VK_UP){
            space.player.y+=1;
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN) {
            space.player.y-=1;
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
            space.player.x+=1;
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT) {
            space.player.x-=1;
        }
        */
        if(e.getKeyCode()==KeyEvent.VK_SPACE) {
            firing = true;
            fire = true;
        }
        switch(e.getKeyCode()){
            //case 38: space.player.y -= speed;break;
            //case 40: space.player.y += speed;break;
        
            case 39: space.player.x += speed;right = true;break;
            case 37: space.player.x -= speed;left = true;break;
            case KeyEvent.VK_UP: firing = true;fire = true;break;
            //case KeyEvent.VK_SPACE: firing = false;break;
        }
        
        System.out.println(e.getKeyCode());
        space.player.fire();
        space.repaint();

    }

    public void keyReleased(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_LEFT) {
            left = false;
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
            right = false;
        }
        if(e.getKeyCode()==KeyEvent.VK_SPACE||e.getKeyCode()==KeyEvent.VK_UP) {
            firing = false;
            fire = false;
        }
        /*while(!left&&!right&&!fire){
            try{
                Thread.sleep(100);
                space.player.fire();
            } catch (Exception E) {

            }
        }*/

    }
}
