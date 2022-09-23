import java.util.Scanner;

public class solitare {
    public static void main(String[] args) {

        linkedListO piles = new linkedListO();
        doubleLinkedList deck = new doubleLinkedList();
        stack newDeck = new stack(null);
        Scanner scan = new Scanner(System.in);

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
                    case 9: deck.tail.data.type = '⒑';deck.tail.data.value = 10;break;
                    case 10: deck.tail.data.type = 'J';deck.tail.data.value = 11;break;
                    case 11: deck.tail.data.type = 'Q';deck.tail.data.value = 12;break;
                    case 12: deck.tail.data.type = 'K';deck.tail.data.value = 13;break;
                    default: deck.tail.data.type = Character.forDigit(j+1, 10);deck.tail.data.value = j+1;
                }
            }   
            
        }
        deck.printTypeSuit();
        //shuffle
        for(int i = 51; i>=0;i--){
            newDeck.push(deck.cutAtIndex((int)(Math.random()*i)));//shuffle and put all cards into stack named temp
            System.out.println(newDeck.peak().suit+" "+newDeck.peak().type);
        }
        for(int i = 0; i<4; i++){
            piles.add(new stack(new playingCard()));//create ace piles-index 0-3
        }
        piles.add(newDeck);//add deck to piles index 4
        for(int i = 0; i<8; i++){
            piles.add(new stack());//create turned up card pile index 5 and playing field piles index 6-12 increases with starting num cards in each pile
        }
        //temp.printTypeSuit();

        for(int i = 0; i<7; i++){//deals out cards
            for(int j = 0; j<i+1; j++){
                //System.out.println(piles.getAtIndex(4).s.peak().type);
                //System.out.println("stack "+(i+6));
                piles.getAtIndex(i+6).s.push(piles.getAtIndex(4).s.pop());
            }
            piles.getAtIndex(4).s.peak().faceUp = true;
            piles.getAtIndex(i+6).s.push(piles.getAtIndex(4).s.pop());
        }
        piles.getAtIndex(4).s.peak().faceUp = true;
        piles.getAtIndex(5).s.push(piles.getAtIndex(4).s.pop());
        linkedList pileSizes;
        linkedList tempSizes;

        try{
            boolean won = false;
            int biggest = 0;
            while(!won){
                pileSizes = new linkedList();
                for(int k = 6; k<13; k++){
                    pileSizes.add(piles.getAtIndex(k).s.size());
                }
                tempSizes = pileSizes;
                
                System.out.println("");
                System.out.println("  ___   ___   ___   ___   ___   ___  ");
           
                System.out.println(" |///| |" + piles.getAtIndex(5).s.peak().getSuitType() + "| |" + piles.getAtIndex(0).s.peak().getSuitType() + "| |" + piles.getAtIndex(1).s.peak().getSuitType() + "| |" + piles.getAtIndex(2).s.peak().getSuitType() + "| |" + piles.getAtIndex(3).s.peak().getSuitType() + "| ");
            
                System.out.println("  ▔▔▔   ▔▔▔   ▔▔▔   ▔▔▔   ▔▔▔   ▔▔▔  ");

                System.out.println("-------------------------------------");

                System.out.println("  ___   ___   ___   ___   ___   ___   ___  ");

                

            for(int i = 6;i<=12;i++){
                if(biggest<piles.getAtIndex(i).s.size()){
                    biggest = piles.getAtIndex(i).s.size();
                }
            }

            won = true;
            }

            scan.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        


    }

}