import java.util.ArrayList;
import java.util.Collection;

class ArrayListPrime<T> {

    Object[] hello = new Object[10];
    T[] array = (T[])(hello);

    public static void main(String[] args) {
        ArrayListPrime<Integer> inter = new ArrayListPrime<Integer>();
        inter.add(1);
        System.out.println(inter.get(0));
        ArrayListPrime<ArrayList<String>> bigQ = new ArrayListPrime<ArrayList<String>>();
        bigQ.add(new ArrayList<String>());
        bigQ.get(0).add("Hello World!");
        System.out.println(bigQ.get(0).get(0));
    }

    ArrayListPrime(){
        array = (T[])(new Object[10]);
    }
    ArrayListPrime(int size){
        array = (T[])(new Object[size]);
    }
    ArrayListPrime(T[] set){
        array = set;
    }

    public T get(int index){
        return array[index];
    }

    public int indexOf(T element){
        for(int i = 0;i<array.length;i++){
            if(array[i] == element){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T element){
        for(int i = array.length-1;i>=0;i--){
            if(array[i] == element){
                return i;
            }
        }
        return -1;
    }

    public boolean containes(T element){
        for(int i = 0;i<array.length;i++){
            if(array[i] == element){
                return true;
            }
        }
        return false;
    }

    public void add(T element){
        checkLength();
        for(int i = 0; i<array.length; i++){
            if(array[i]==null){
                array[i] = element;
                return;
            }
        }
    }

    public void add(int index, T element){
        checkLength();
        for(int i = array.length-1;i>index;i--){
            array[i] = array[i-1];
        }
        array[index] = element;
    }

    public void addAll(Collection<T> coll){
        for(T i : coll){
            add(i);
        }
    }

    public boolean removeAll(Collection<T> coll){
        boolean removed = false;
        for(T i : coll){
            if(remove(i)!=null){
                removed = true;
            }
        }
        return removed;
    }

    public boolean retainAll(Collection<T> coll){
        boolean removed = false;
        for(T i : coll){
            if(!coll.contains(i)){
                remove(i);
                removed = true;
            }
        }
        return removed;
    }

    protected void removeRange(int start, int end){
        for(int i = end; i<array.length;i++){
            array[i-(end-start)] = array[i];
        }
    }

    public void addAll(int index, Collection<T> coll){
        int j = 0;
        for(T i : coll){
            add(index+j, i);
            j++;
        }
    }

    public T set(int index, T element){
        T removed = array[index];
        array[index] = element;
        return removed;
    }

    public int size(){
        for(int i = array.length-1;i>=0;i--){
            if(array[i]!=null){
                return i+1;
            }
        }
        return 0;
    }

    public T remove(T item){
        T removed = null;
        for(int i = 0; i<size(); i++){
            if(item == array[i]){
                removed = array[i];
                for(int j = i; j>size()-1;j++){
                    array[j] = array[j+1];
                }
            }
        }
        return removed;
    }

    public T remove(int index){
        if(index>0&&index<size()){
            T removed = array[index];
        for(int i = index; i>size()-1;i++){
            array[i] = array[i+1];
        }
        return removed;
        }
        return null;
    }

    public boolean isEmpty(){
        for(int i = 0;i<size();i++){
            if(array[i]!=null){
                return false;
            }
        }
        return true;
    }

    public void clear(){
        for(int i = 0; i<array.length; i++){
            array[i] = null;
        }
    }

    public ArrayListPrime<T> clone(){
        ArrayListPrime<T> toReturn = new ArrayListPrime<T>(array);
        return toReturn;
    }

    public void checkLength(){
        if(array[array.length-1]!=null){
            T[] temp = (T[])(new Object[array.length+1]);
            for(int i = 0; i<array.length; i++){
                temp[i] = array[i];
            }
            array = temp;
        }
    }

    public void trimToSize(){
        for(int i = array.length-1;i>0;i--){
            if(array[i] != null){
                T[] temp = (T[])(new Object[i+1]);
                for(int j = 0; j<temp.length; j++){
                    temp[j] = array[j];
                }
                array = temp;
            }
        }
    }

    public T[] sublist(int start, int end){

        T[] temp = (T[])(new Object[end-start]);
        for(int j = start; j<end; j++){
            temp[j-start] = array[j];
        }
        return temp;
    }

    public T[] toArray(){
        return array;
    }

    public void ensureCapacity(int min){
        if(array.length<min){
            T[] temp = (T[])(new Object[min]);
            for(int i = 0; i<array.length; i++){
                temp[i] = array[i];
            }
            array = temp;
        }
    }

}
