import javax.swing.*;
import java.awt.*;

public class Space extends JPanel{
    public Player player;
    public Aliens aliens;
    int step;
    Rectangle[] bullets = new Rectangle[100];
    public Space(Player p, Aliens a){
        player = p;
        aliens = a;
        step = 1;
    }

    public void paint(Graphics g){
        
        super.paint(g);
        g.fillRect(player.x, player.y, player.width, player.height);
        for(Rectangle r : player.lasers){
            if(r!=null){
                g.fillRect(r.x, r.y, r.width, r.height);
            }
        }
        for(Aliens a : aliens.aliens){
            if(Math.random()*4<1){
                for(int i = 0; i < 100; i++){
                    if(bullets[i]  == null){
                        bullets[i] = new Rectangle(a.x, a.y, 5, 10);
                        break;
                    }
                }
            }
            switch(step){
                case 1: a.x += 5;break;
                case 2: a.y += 5;break;
                case 3: a.x -= 5;break;
                case 4: a.y -= 5;break;
            }
            g.fillRect(a.x, a.y, a.width, a.height);
        }
        if(step==4){step = 1;}else{step++;}
    }
}
