public class doubleLinkedList {
    public static void main(String[] args) {
    doubleLinkedList lList = new doubleLinkedList();
        
    /*lList.add(5);
    lList.add(6);
    lList.add(7);
    lList.add(8);
    lList.add(9);
    //lList.remove(7);
    //lList.printItems();
    lList.printReverse();
    //System.out.println(lList.getAtIndex(2).data);*/
    }

    public node head;
    public node current;
    public node tail;

    doubleLinkedList(){
        head = new node(null);
        tail = head;
    }
    
    void printItems(){
        node current = head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    void printTypeSuit(){
        node current = head;
        while(current != null){
            System.out.println(current.data.suit+" "+current.data.type);
            current = current.next;
        }
    }

    void add(playingCard data){
        if(tail==head && head.data == null){
            head.data = data;
        } else {
            tail.next = new node(data);
            node temp = tail;
            tail = tail.next;
            tail.prev = temp;
        }
    }



    void remove(playingCard data){
        node current = head;
        node last = head;
        while(current != null){
            if (current.data == data){
                if(current == head){
                    head = head.next;
                }else{
                    last.next = current.next;
                    current.next.prev = last;
                }
                System.out.println("found and removed the first instance of " + data);
                return;
            }
            last = current;
            current = current.next;
        }
        System.out.println("could not remove " + data);
    }

    void printReverse(){
        node current = tail;
        while(current != head.prev && current.data != null){
            System.out.println(current.data);
            current = current.prev;
        }
    }

    node getAtIndex(int index){
        int i = 0;
        node current = head;
        while(i<index){
            if (current == null){
                return null;
            }
            else {
                current = current.next;
                i++;
            }
        }
        return current;
    }

    playingCard cutAtIndex(int i){
        playingCard card = getAtIndex(i).data;
        remove(card);
        return card;
    }
    
    int length() {
        node current = head;
        int l = -1;
        while(current != null){
            l++;
            current = current.next;
        }
        return l;
    }
}
