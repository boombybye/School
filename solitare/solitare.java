import java.util.Scanner;

//import java.util.Scanner;

public class solitare {
    public static void main(String[] args) {

        linkedListO piles = new linkedListO();
        doubleLinkedList deck = new doubleLinkedList();
        stack newDeck = new stack(null);
        Scanner scan = new Scanner(System.in);

        //stack newDeck = new stack(null);
        
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
            newDeck.push(deck.cutAtIndex((int)(Math.random()*i)));//shuffle and put all cards into stack named temp
        }
        for(int i = 0; i<4; i++){
            piles.add(new stack(null));//create ace piles-index 0-3
        }
        piles.add(newDeck);//add deck to piles index 4
        for(int i = 0; i<8; i++){
            piles.add(new stack(null));//create turned up card pile index 5 and playing field piles index 6-12 increases with starting num cards in each pile
        }
        //temp.printTypeSuit();

        for(int i = 0; i<7; i++){//deals out cards
            for(int j = 0; j<i; i++){
                piles.getAtIndex(i+6).s.push(piles.getAtIndex(4).s.pop());
            }
            piles.getAtIndex(4).s.peak().faceUp = true;
            piles.getAtIndex(i+6).s.push(piles.getAtIndex(4).s.pop());
        }
        piles.getAtIndex(4).s.peak().faceUp = true;
        piles.getAtIndex(5).s.push(piles.getAtIndex(4).s.pop());

        try{
            boolean won = false;
            while(!won){
                System.out.println("");
            System.out.println("  ___   ___   ___   ___   ___   ___  ");
            System.out.println(" |///| |"+"suit value"+"| |"/*keep going for rest of row*/);
            }

            scan.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        


    }

}