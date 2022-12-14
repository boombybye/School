import java.awt.*;

public class Player extends Rectangle{
    public int x;
    public int y;
    public int width;
    public int height;
    public Rectangle[] lasers = new Rectangle[100];
    Inputs inputs;
    public Player(int X, int Y, int w, int h) {
        x = X;
        y = Y;
        width = w;
        height = h;
    }

    public void addInputs(Inputs i){
        inputs = i;
    }

    public void fire(){
        if(inputs.firing){
            for(int i = 0; i < 100; i++){
                if(lasers[i]  == null){
                    lasers[i] = new Rectangle(x+width/2-5/2, y, 5, 10);
                    break;
                }
            }
            for(int i = 0; i < 100; i++){
                if(lasers[i] != null){
                    if(lasers[i].y<0){
                        lasers[i] = null;
                    }
                }
            }
        }
        for(Rectangle r : lasers){
            if(r != null){r.y-=10;}
        }
    }
}
