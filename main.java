import java.util.*;

public class main {
    
    static privateClassExample pClassE = new privateClassExample();

    public static void main(String args[]){
        main.makeGuess();
        System.out.println("The number was "+pClassE.getHiddenNumber());
    }

    public static void makeGuess(){
        Scanner input = new Scanner(System.in);
        System.out.println("Your guess is ");
        int guess = input.nextInt();
        System.out.println("Your guess was "+pClassE.guessHiddenNumber(guess));
        input.close();
    }

}
