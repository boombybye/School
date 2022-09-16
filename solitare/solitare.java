//import java.util.Scanner;

public class solitare {
    public static void main(String[] args) {
        doubleLinkedList deck = new doubleLinkedList();
        doubleLinkedList temp = new doubleLinkedList();
        //Scanner sc = new Scanner(System.in);
        //initalized deck and cards
        for(int i = 0; i<4; i++){
            for(int j = 0; j<13; j++){
                deck.add(new playingCard());
                deck.head.data.value = j+1;
                switch(i){
                    case 0: deck.tail.data.color = true;deck.tail.data.suit = '♥';break;
                    case 1: deck.tail.data.color = true;deck.tail.data.suit = '♦';break;
                    case 2: deck.tail.data.color = false;deck.tail.data.suit = '♠';break;
                    case 3: deck.tail.data.color = false;deck.tail.data.suit = '♣';break;
                }
                switch(j){
                    case 9: deck.tail.data.type = '⒑';break;
                    case 10: deck.tail.data.type = 'J';break;
                    case 11: deck.tail.data.type = 'Q';break;
                    case 12: deck.tail.data.type = 'K';break;
                    default: deck.tail.data.type = Character.forDigit(j+1, 10);
                }
            }   
            
        }
        deck.printTypeSuit();
        //shuffle
        for(int i = 51; i>=0;i--){
            temp.add(deck.cutAtIndex((int)(Math.random()*i)));
        }
        temp.printTypeSuit();
    }



}