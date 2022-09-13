public class queue {

    public static void main(String[] args) {
        queue thing = new queue(2);
        thing.push(3);
        thing.push(4);
        thing.push(5);
        System.out.println(thing.pop());
        System.out.println(thing.pop(2));
    }

    node head;
    node tail;

    queue(Object data){
        head = new node (data);
        tail = head;
    }

    void push(Object data){
        node temp = new node(data);
        temp.next = head;
        head.prev = temp;
        head = temp;
    }

    Object pop(){
        node temp = head;
        if (head!=null){
        head = head.next;
        }
        return temp.data;
    }

    //proceeding method is everkill for a stack
    Object pop(int n){
        Object temp = head;
        int i = 0;
        while (i<n && temp != null){
            temp = pop();
            i++;
        }
        return temp;
    }
}