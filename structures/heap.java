import java.util.Arrays;
public class heap {

    public static void main(String[] args) {
        heap homeSlice = new heap(12);
        for(Integer i = 1; i <= 10; i++) {
        homeSlice.add(i);
        }
        System.out.println(homeSlice.getNext());
    }
    protected Integer [] heap;
    protected Integer size;
    protected Integer capacity;

    public heap() {
        this.capacity = 10;
        this.size = 0;
        this.heap = new Integer[this.capacity];
    }

    public heap(Integer capacity) {
        this.capacity = capacity;//max num elements in heap
        this.size = 0;//current capacity
        this.heap = new Integer[capacity];
    }

    //input: location of two elements in heap
    //output: switches the location of two elements
    public void swap(Integer first, Integer second){
        Integer temp = this.heap[first];
        this.heap[first] = this.heap[second];
        this.heap[second] = temp;
    }

    public Integer[] getChildren(Integer index){
        return (2*index+2<size)? Arrays.copyOfRange(this.heap, 2*index+1, 2*index+3): (2*index+1<size)? Arrays.copyOfRange(this.heap,2*index+1,2*index+2): null;
    }

    public Integer getParent(Integer index){
        return this.heap[(index-1)/2];
    }

    protected void makeSpace(){
        if(this.heap[this.heap.length-1]!=null){
            Integer[] temp = new Integer[this.heap.length+1];
            for(Integer i=0; i<this.heap.length; i++){
                temp[i] = this.heap[i];
            }
            this.heap = temp;
        }
    }

    protected void ensureCapacity(Integer length){
        if(this.heap[this.heap.length]>length){
            Integer[] temp = new Integer[length];
            for(Integer i=0; i<this.heap.length; i++){
                temp[i] = this.heap[i];
            }
            this.heap = temp;
        }
    }

    //output: the min/max value of the heap
    //removes it from the heap
    //then reorders the heap
    public Integer getNext(){//what is even going on with this
        Integer next = this.heap[0];
        this.heap[0] = this.heap[size-1];
        this.heap[size-1] = null;
        this.size--;
        sortHeap();
        return next;
    }

    //input: value
    //adds the value to the end of the heap and resize the heap accordingly
    public void add(Integer value){
        makeSpace();
        for(Integer i = this.heap.length-1;i>=0;i--){
            if(this.heap[i]!=null){
                boolean placed = false;
                while(placed){

                }
            }
        }
    }

    public void printHeap(Integer index){
        Integer[] children = getChildren(index);
        System.out.println(index+": "+this.heap[index]+"    children:");
        for(Integer child : children){
            System.out.print("index -"+child+"value:"+this.heap[child]);
        }
        for(Integer child : children){
            printHeap(child);
        }
    }

    /*
    public void aString(Integer index){
        System.out.print(index+ ": ");
        if(getChildren(this.heap[index])[0]!=null){
            System.out.print(getChildren(this.heap[index])[0]);
        }
        if(getChildren(this.heap[index])[1]!=null){
            System.out.print(" , "+getChildren(this.heap[index])[0]);
        }
        System.out.println();                                               start here 10/3/22
        if(getChildren(this.heap[index])[0]!=null){
            aString(toPrint.left);
        }
        if(getChildren(this.heap[index])[1]!=null){
            aString(toPrint.right);
        }
    }
    */

    //to be defined in subclasses
    public void sortHeap(){

    }

    class minHeap extends heap{
        public minHeap(Integer capacity) {
            super(capacity);
        }

        public void sortHeap(){
            Integer current = getParent(size-1);
            while(current>=0){
                Integer[] children = getChildren(current);
                if(this.heap[current]>this.heap[children[1]]){
                    swap(current, children[1]);
                }
                if(this.heap[current]>this.heap[children[0]]){
                    swap(current, children[0]);
                }
                current--;
            }
        }
    }

    class maxHeap extends heap{
        public maxHeap(Integer capacity) {
            super(capacity);
        }

        public void sortHeap(){
            Integer current = getParent(size-1);
            while(current>=0){
                Integer[] children = getChildren(current);
                if(this.heap[current]<this.heap[children[1]]){
                    swap(current, children[1]);
                }
                if(this.heap[current]<this.heap[children[0]]){
                    swap(current, children[0]);
                }
                current--;
            }
        }
    }
}
