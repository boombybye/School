//import java.util.Scanner;

public class solitare {
    public static void main(String[] args) {
        playingCard card;
        doubleLinkedList deck = new doubleLinkedList();
        stack temp = new stack(null);
        //Scanner sc = new Scanner(System.in);
        for(int i = 0; i<4; i++){
            deck.add(new playingCard());
            switch(i){
                case 0: deck.head.data.color = true;deck.head.data.suit = '♥';
                case 1: card.color = true;card.suit = '♦';
                case 2: card.color = false;card.suit = '♠';
                case 3: card.color = false;card.suit = '♣';
            }
            for(int j = 0; i<13; j++){
                
            }
        }

    }


}
