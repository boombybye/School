public class node {
    playingCard data;
    stack s;
    Object o;
    node next;
    node prev;

    node (playingCard d){
        data = d;
    }
    node (stack d, boolean noA){
        s = d;
    }
    node (Object d, int i){
        o=d;
    }
}
