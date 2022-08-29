public class privateClassExample {
    
    private int hiddenNumber;

    public privateClassExample(int n){
        hiddenNumber = n;
    }

    public privateClassExample(){
        hiddenNumber = (int) (Math.random()*11);
    }

    public privateClassExample(int min, int max){
        hiddenNumber = (int) (Math.random()*(max-min+1)+min);
    }

    public int getHiddenNumber(){
        return hiddenNumber;
    }

    public void setHiddenNumber (int n){
        hiddenNumber = n;
    }

    public boolean guessHiddenNumber(int g){
        if (g == hiddenNumber){
            return true;
        }
        return false;
    }
}
