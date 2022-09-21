public class playingCard {
    
    public int value;
    public char type;
    public char suit;
    public boolean color;//true is red false is black
    public boolean faceUp;

    playingCard(int v, char t, char s, boolean c){
        value = v;
        type = t;
        suit = s;
        color = c;
        faceUp = false;
    }

    playingCard(){
        faceUp = false;
    }

    public void setValue(int v){
        value = v;
    }

    public void setType(char t){
        type = t;
    }

    public void setSuit(char s){
        suit = s;
    }

    public void setColor(boolean c){
        color = c;
    }

    public String getSuitValue(){
        if(faceUp){
            return suit + " " + value;
        } else {
            return "///";
        }
    }

}
