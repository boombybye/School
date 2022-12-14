import java.awt.*;

public class Segment extends Rectangle{
    Segment prev;
    Segment next;
    Color color;
    
    public Segment(int x, int y, int width, int height, Segment p, Segment n, Color c) {
        super(x, y, width, height);
        prev = p;
        next = n;
        color = c;
    }

    
    
}
