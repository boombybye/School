public class linkedList {
    public static void main(String[] args) {
    linkedList lList = new linkedList();
    lList.add(5);
    //lList.add(7);
    lList.printItems();
    }

    node head;

    linkedList(){
        head = new node();
    }
    
    void printItems(){
        node current = head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    void add(Object data){
        if(head.data == null){
            head.data = data;
        }
    }
}
