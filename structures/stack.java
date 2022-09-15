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