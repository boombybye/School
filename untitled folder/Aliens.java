import java.awt.*;
import java.util.*;

public class Aliens extends Rectangle {
    
    int max;
    int min;
    int width;
    int height;
    int x;
    int y;
    ArrayList<Aliens> aliens = new ArrayList<Aliens>();

    public Aliens(int ma, int mi, int w, int h, boolean b){
        max = ma;
        min = mi;
        width = w;
        height = h;
        //aliens.add(new Aliens());
        for(int i = 0; i <(int) (Math.random()*11) + 11; i++){
            boolean made = false;
            while(!made){
                int X;
                int Y;
                boolean touch = false;
                X = (int) (Math.random()*400);
                Y = (int) (Math.random()*150);
                Aliens a = new Aliens(X, Y, width, height);
                for(Aliens c : aliens){
                    if(a.intersects(c)){
                        touch = true;
                    }
                }
                if(!touch){
                    aliens.add(a);
                    made = true;
                }//add random appearence and position checking
            }
        }
    }

    public Aliens(int X, int Y, int w, int h){
        x = X;
        y = Y;
        width = w;
        height = h;
    }

    public void suppliment(){

    }





}
