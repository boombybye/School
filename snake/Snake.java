import java.awt.*;
import java.awt.event.KeyEvent;


public class Snake {

    int initialX;
    int initialY;
    int initialLength;
    int width;
    int height;
    int length;
    Segment head;
    Segment current;
    public char direction;



    public Snake(int x, int y , int w, int h, int l) {
        initialX = x;
        initialY = y;
        initialLength = l;
        width = w;
        height = h;
        length = l;
        head = new Segment(initialX, initialY, width, height, null, null, Color.GREEN);
        int plusMinus;
        if((initialX>200&&initialX<=340)||initialX<=60){
            plusMinus = 1;
            direction = 'r';
        } else {
            plusMinus = 'l';
            direction = 0;
        }
        current = head;
        for(int i=1; i<initialLength; i++){
            add(new Segment(initialX+plusMinus*width*i,initialY, width, height, current, null, Color.GREEN));
            current = current.next;
        }
    }

    public void add(Segment n){
        current = head;
        while(current.next!=null){
            current = current.next;
        }
        current.next = n;
        current.next.prev = current;
    }

    public void push(Segment n){
        head.prev = n;
        head.prev.next = head;
        head = head.prev;
    }

    public void dump(){
        current = head;
        while(current.next.next!=null){
            current = current.next;
        }
        current.next = null;
    }

    public void pop(){
        head = head.next;
        head.prev = null;
    }

    public void slither(Segment n){
        push(n);
        dump();
    }

    public void eat(Segment n){
        push(n);
    }
}
