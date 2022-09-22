public class stack {

    public static void main(String[] args) {
        /*stack thing = new stack(2);
        thing.push(3);
        thing.push(4);
        thing.push(5);
        System.out.println(thing.pop());
        System.out.println(thing.pop(2));*/
    }

    node head;

    stack(playingCard data){
        head = new node (data);
    }

    stack(){
        head = null;
    }

    void push(playingCard data){
        node temp = new node(data);
        temp.next = head;
        head = temp;
    }

    playingCard pop(){
        node temp = head;
        if (head!=null){
        head = head.next;
        }
        return temp.data;
    }

    playingCard peak(){
        if(head!=null && head.data!=null){
            return head.data;
        }
        return null;
    }

    playingCard peak(int i){
        node current = head;
        if(current == null || current.data == null){
            return null;
        }
        for(int j = i;i>0;i--){
            if (current.next!=null || current.next.data!=null){
                current = current.next;
            }
        }
        if(current!=null && current.data!=null){
            return head.data;
        }
        return null;
    }

    int size(){
        node current = head;
        boolean exit = false;
        int length = 0;
        while(!exit){
            if (current.next!=null && current.next.data!=null){
                current = current.next;
                length++;
            } else {exit = true;}
        }
            return length;
    }

    //proceeding method is everkill for a stack
    playingCard pop(int n){
        Object temp = head;
        playingCard temp2 = new playingCard();
        int i = 0;
        while (i<n && temp != null){
            temp2 = pop();
            i++;
        }
        return temp2;
    }
}