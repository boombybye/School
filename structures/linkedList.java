public class linkedList {
    public static void main(String[] args) {
    linkedList lList = new linkedList();
    lList.add(5);
    lList.add(6);
    lList.add(7);
    //lList.remove(7);
    lList.printItems();
    lList.printReverse();
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
        int idk = 0;
        for(int i = 0;current!=null;i++){
            current = current.next;
            idk = i;
        }
        for(int i = idk;i>=0;i--){
            current = head;
            for(int j = i;j>=1;j--){
                current = current.next;
            }
            System.out.println(current.data);
        }
    }
}
