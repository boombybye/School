import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Inputs implements KeyListener, MouseListener {

    public Board panel;

    public boolean u;
    public boolean d;
    public boolean l;
    public boolean r;
    public char last = ' ';
    

    public Inputs(Board b){
        panel = b;
    }

    public void keyTyped(KeyEvent e){
        System.out.println("Typed "+e.getKeyChar());

    }

    public void keyPressed(KeyEvent e){
        System.out.println("Pressed "+e.getKeyChar());
        //switch statement does not work because of user input timing issues

        if(e.getKeyCode()==KeyEvent.VK_LEFT) {
            //panel.moveLeft();
            boolean done = false;
            if(!done){
            l = true;
            r = false;
            u = false;
            d = false;
            last = 'l';
            done = true;
            }
            try{
                Thread.sleep(1000);
            }catch(Exception a){

            }
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
            //panel.moveRight();
            l = false;
            r = true;
            u = false;
            d = false;
            last = 'r';
        }
        if(e.getKeyCode()==KeyEvent.VK_UP) {
            //panel.moveUp();
            l = false;
            r = false;
            u = true;
            d = false;
            last = 'u';
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN) {
            //panel.moveDown();
            l = false;
            r = false;
            u = false;
            d = true;
            last = 'd';
        }

        

    
        
        if(panel.head.intersects(panel.target)){
            System.out.println("current win condition fulfilled");
        } else for(int i = 0; i<10; i++){

        }

        

        panel.repaint();
    }

    public void keyReleased(KeyEvent e){
        System.out.println("Released "+e.getKeyChar());
        if(e.getKeyCode()==KeyEvent.VK_LEFT) {
            //panel.moveLeft();
            l = false;
            

        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
            //panel.moveRight();
            r = false;
            
        }
        if(e.getKeyCode()==KeyEvent.VK_UP) {
            //panel.moveUp();
            u = false;
            
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN) {
            //panel.moveDown();

            d = false;
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Hello World!");
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

}