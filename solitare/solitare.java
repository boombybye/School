import java.util.Scanner;

public class solitare {
    public static void main(String[] args) {

        linkedListO piles = new linkedListO();
        doubleLinkedList deck = new doubleLinkedList();
        stack newDeck = new stack(null);
        stack interum = new stack();
        Scanner scan = new Scanner(System.in);

        int origin = -1;
        int amount = -1;
        int destination = -1;
        int numFaceUp = 0;

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
            piles.getAtIndex(i).s.peak().value = 0;
            piles.getAtIndex(i).s.peak().faceUp = false;
        }
        piles.add(newDeck);//add deck to piles index 4
        for(int i = 0; i<8; i++){
            piles.add(new stack());//create turned up card pile index 5 and playing field piles index 6-12 increases with starting num cards in each pile
        }
        //temp.printTypeSuit();

        for(int i = 0; i<7; i++){//deals out cards
            for(int j = 0; j<i; j++){
                //System.out.println(piles.getAtIndex(4).s.peak().type);
                //System.out.println("stack "+(i+6));
                piles.getAtIndex(i+6).s.push(piles.getAtIndex(4).s.pop());
            }
            //piles.getAtIndex(4).s.peak().faceUp = true;
            piles.getAtIndex(i+6).s.push(piles.getAtIndex(4).s.pop());
            piles.getAtIndex(i+6).s.peak().faceUp = true;
            //System.out.println(piles.getAtIndex(i+6).s.peak().faceUp);
        }
        piles.getAtIndex(4).s.peak().faceUp = true;
        piles.getAtIndex(5).s.push(piles.getAtIndex(4).s.pop());
        //linkedList pileSizes;//not important could delete with its manipulation
        //linkedList tempSizes;//not important could delete with its manipulation

        try{
            boolean won = false;
            int biggest = 0;
            while(!won){
                /*pileSizes = new linkedList();
                for(int k = 6; k<13; k++){
                    pileSizes.add(piles.getAtIndex(k).s.size());
                }
                tempSizes = pileSizes;
                */
                System.out.println("");
                System.out.println("  ___   ___   ___   ___   ___   ___  ");
           
                System.out.println(" |///| |" + piles.getAtIndex(5).s.peak().getSuitType() + "| |" + piles.getAtIndex(0).s.peak().getSuitType() + "| |" + piles.getAtIndex(1).s.peak().getSuitType() + "| |" + piles.getAtIndex(2).s.peak().getSuitType() + "| |" + piles.getAtIndex(3).s.peak().getSuitType() + "| ");
            
                System.out.println("  ▔▔▔   ▔▔▔   ▔▔▔   ▔▔▔   ▔▔▔   ▔▔▔  ");

                System.out.println("-------------------------------------------");

                

            for(int i = 6;i<=12;i++){//gets size of biggest pile
                if(biggest<piles.getAtIndex(i).s.size()){
                    biggest = piles.getAtIndex(i).s.size();
                }
            }
            String printing1 = "";
            String printing2 = "";
            String printing3 = "";
            for(int i = 0;i<=biggest;i++){
                printing1 = " ";
                printing2 = " ";
                printing3 = " ";
                for(int j = 6;j<=12;j++){
                    if(piles.getAtIndex(j).s.size()-i+1>0){
                        printing1 = printing1 + " ___  ";
                        printing2 = printing2 + "|" + piles.getAtIndex(j).s.peak((piles.getAtIndex(j).s.size())-i).getSuitType() + "| ";
                        printing3 = printing3 + " ▔▔▔  ";
                    }else{
                        printing1 = printing1 + "      ";
                        printing2 = printing2 + "      ";
                        printing3 = printing3 + "      ";
                    }
                }
                System.out.println(printing1);
                System.out.println(printing2);
                System.out.println(printing3);
            }



            System.out.println("Input pile of card(s) you wish to move(0-3 for ace piles, 4 to draw a card, 5 for drawn cards, 6-12 for piles in playing area):");
            origin = scan.nextInt();
            if(origin>=0&&origin<=12){
                if(origin>=0&&origin<=5){
                    amount = 1;
                    if(piles.getAtIndex(origin).s.size()<=0||(piles.getAtIndex(origin).s.size()<0&&origin>=4)){
                        System.out.println("input is an empty pile");
                        origin = -1;
                    }
                }else{
                    System.out.println("Input amount of cards to move(max is as many as there are facup in selected coulum):");
                    amount = scan.nextInt();
                    numFaceUp = 0;
                    for(int i = 0;i<piles.getAtIndex(origin).s.size();i++){
                        if(piles.getAtIndex(origin).s.peak(i).faceUp){
                            numFaceUp++;
                        } else {break;}
                    }
                    if(numFaceUp>amount){
                        System.out.println("amount is more than the number of faceup cards in this pile");
                        origin = -1;
                    }
                }
                if(origin!=-1){
                    System.out.println("Input destination of the card(s)(0-3 for ace piles, 4 is unavalable, 5 to draw a card, 6-12 for piles in playing area)");
                    destination = scan.nextInt();
                } else if(destination!=4&&destination>=0&&destination<=12){//this bit not working->fix!!!
                    if(piles.getAtIndex(destination).s.peak().value-piles.getAtIndex(origin).s.peak().value==1&&piles.getAtIndex(destination).s.peak().color!=piles.getAtIndex(origin).s.peak().color){
                        for(int i = 0;i<amount;i++){
                            interum.push(piles.getAtIndex(origin).s.pop());
                        }
                        for(int i = 0;i<amount;i++){
                            piles.getAtIndex(destination).s.push(interum.pop());
                        }
                        if(destination==5){
                            piles.getAtIndex(5).s.peak().faceUp = true;
                        }
                    }else{System.out.println("not valid movement");}
                }
                //proceed from here
            } else {
                System.out.println("input is not a valid pile");
            }

            for(int i = 0; i<=12; i++){
                if(piles.getAtIndex(i).s.peak().faceUp!=true && i>4){
                    piles.getAtIndex(i).s.peak().faceUp = true;
                }
            }
            

            if(piles.getAtIndex(0).s.size()==13&&piles.getAtIndex(1).s.size()==13&&piles.getAtIndex(2).s.size()==13&&piles.getAtIndex(3).s.size()==13){
                System.out.println("congratualtions, you win!");
                won = true;
            }
            //won = true;
            }

            scan.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        


    }
    /*public static void moveTo(int origin){
        if(true){}
    }*/
}