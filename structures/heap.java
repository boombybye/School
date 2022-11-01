import java.util.Arrays;
public class heap {
    protected Integer [] heap;
    protected int size;
    protected int capacity;

    public heap() {
        this.capacity = 10;
        this.size = 0;
        this.heap = new Integer[this.capacity];
    }

    public heap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new Integer[capacity];
    }

    public Integer[] getChildren(int index){
        return Arrays.copyOfRange(this.heap, 2*index+1, 2*index+2);
    }

    public int getParent(int index){
        return this.heap[(index-1)/2];
    }

    protected void makeSpace(){
        if(this.heap[this.heap.length-1]!=null){
            Integer[] temp = new Integer[this.heap.length+1];
            for(int i=0; i<this.heap.length; i++){
                temp[i] = this.heap[i];
            }
            this.heap = temp;
        }
    }

    protected void ensureCapacity(int length){
        if(this.heap[this.heap.length]>length){
            Integer[] temp = new Integer[length];
            for(int i=0; i<this.heap.length; i++){
                temp[i] = this.heap[i];
            }
            this.heap = temp;
        }
    }

    public Integer getNext(){
        Integer next = this.heap[0];

        return next;
    }

    public void add(int value){
        makeSpace();
        for(int i = this.heap.length-1;i>=0;i++){
            if(this.heap[i]!=null){
                boolean placed = false;
                while(placed){

                }
            }
        }
    }

    public void sortHeap(){

    }

    class minHeap extends heap{
        public minHeap(int capacity) {
            super(capacity);
        }
    }

    class maxHeap extends heap{
        public maxHeap(int capacity) {
            super(capacity);
        }
    }
}
