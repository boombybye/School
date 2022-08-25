import java.util.*;

public class main {
    
    static privateClassExample pClassE = new privateClassExample();

    public static void main(String args[]){
        //main.oneRangeGame();
        main.dynamicRangeGame();
    }

    public static void oneRangeGame(){
        Scanner input = new Scanner(System.in);
        int guess = -1;
        int min;
        int max;
        System.out.println("The minimum number will be ");
        min = input.nextInt();
        System.out.println("The maximum number will be ");
        max = input.nextInt();
        pClassE = new privateClassExample(min, max);
        while (!pClassE.guessHiddenNumber(guess)) {
            System.out.println("Let's make a new guess!");
            System.out.print("Your guess is ");
            guess = input.nextInt();
            System.out.println("Your guess was "+pClassE.guessHiddenNumber(guess));
        }
        System.out.println("Congradulations, the number was "+pClassE.getHiddenNumber());
        input.close();
    }

    public static void dynamicRangeGame(){
        Scanner input = new Scanner(System.in);
        int guess = -1;
        int min;
        int max;
        while(!pClassE.guessHiddenNumber(guess)){
            min = (int) (Math.random()*91);
            max = (int) (Math.random()*11+min+5);
            pClassE.setHiddenNumber((int) (Math.random()*(max-min+1)+min));
            System.out.println("The range is from " + min + " to " + max);
            System.out.println("Let's make a new guess!");
            System.out.print("Your guess is ");
            guess = input.nextInt();
            System.out.println("Your guess was "+pClassE.guessHiddenNumber(guess));
        }
        System.out.println("Congradulations, the number was "+pClassE.getHiddenNumber());
        input.close();
    }

}
