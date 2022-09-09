public class linkedList {
    public static void main(String[] args) {
    linkedList lList = new linkedList();
    lList.add(5);
    lList.add(6);
    lList.add(7);
    lList.add(8);
    lList.add(9);
    //lList.remove(7);
    //lList.printItems();
    lList.printReverse();
    //System.out.println(lList.getAtIndex(2).data);
    }

    node head;

    linkedList(){
        head = new node(null);
    }
    
    void printItems(){
        node current = head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    void add(Object data){
        node current = head;
        while(current.next != null){
            current = current.next;
        }
        if(current.data == null){
            current.data = data;
        }else{
            current.next = new node(data);
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
        node current = head;
        int length = 0;
        for(int i = 0;current!=null;i++){
            current = current.next;
            length = i;
        }
        for(int i = length;i>-1;i--){
            current = head;
            for(int j = i;j>0;j--){
                current = current.next;
            }
            System.out.println(current.data);
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
}
