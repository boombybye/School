import javax.swing.JPanel;
import java.awt.*;

public class Board extends JPanel{
    public Rectangle target = new Rectangle(120, 40, 60, 30);
    public Segment head;
    public Snake snek;
    
    
    public Board(int initialX, int initialY, int w, int h){
        head = new Segment(initialX, initialY, w, h, null, null, Color.GREEN);
        snek = new Snake(initialX, initialY, w, h, 5);
    }

    public void paint(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(target.x, target.y, target.width, target.height);
        snek.current = snek.head;
        while(snek.current.next!=null){
            g.setColor(snek.current.color);
            g.fillRect(snek.current.x, snek.current.y, snek.current.width, snek.current.height);
            snek.current = snek.current.next;
        }
        g.setColor(Color.GREEN);
        g.fillRect(head.x, head.y, head.width, head.height);
        //super.paint(g);

    }
    

    public void moveUp(){
        //head.y -= head.height;
        snek.slither(new Segment(snek.head.x, snek.head.y-snek.height, snek.head.width, snek.head.height, null, null, Color.GREEN));
    }

    public void moveDown(){
        //ead.y += head.height;
        snek.slither(new Segment(snek.head.x, snek.head.y+snek.height, snek.head.width, snek.head.height, null, null, Color.GREEN));
    }

    public void moveLeft(){
        //head.x -= head.width;
        snek.slither(new Segment(snek.head.x-snek.width, snek.head.y, snek.head.width, snek.head.height, null, null, Color.GREEN));
    }

    public void moveRight(){
        //head.x += head.width;
        snek.slither(new Segment(snek.head.x+snek.width, snek.head.y, snek.head.width, snek.head.height, null, null, Color.GREEN));
    }

}
