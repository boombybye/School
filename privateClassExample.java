public class privateClassExample {
    
    private int hiddenNumber;

    public privateClassExample(int n){
        hiddenNumber = n;
    }

    public privateClassExample(){
        hiddenNumber = (int) (Math.random()*11);
    }

    public int getHiddenNumber(){
        return hiddenNumber;
    }

    public boolean guessHiddenNumber(int g){
        if (g == hiddenNumber){
            return true;
        }
        return false;
    }
}
