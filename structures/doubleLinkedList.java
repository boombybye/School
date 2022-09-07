public class doubleLinkedList {
    public static void main(String[] args) {
    doubleLinkedList lList = new doubleLinkedList();
        
    lList.add(5);
    lList.add(7);
    lList.add(6);
    lList.remove(7);
    lList.printItems();
    lList.printReverse();
        
    }

    node head;
    node tail;

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

    void add(Object data){
        if(tail==head && head.data == null){
            head.data = data;
        } else {
            tail.next = new node(data);
            node temp = tail;
            tail = tail.next;
            tail.prev = temp;
        }
    }

    void remove(Object data){
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
}
