public class ArrayListPrime<T> {
    T[] array;



    public static void main(String[] args) {
        ArrayListPrime<Integer> inter = new ArrayListPrime<Integer>();
        inter.add(1);
    }

    ArrayListPrime(){
        array = new T[10];
    }
    ArrayListPrime(int size){
        array = new T[size];
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
        T removed = array[i];
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

    

    public void checkLength(){
        if(array[array.length-1]!=null){
            T[] temp = new T[array.length+1];
            for(int i = 0; i<array.length; i++){
                temp[i] = array[i];
            }
            array = temp;
        }
    }

}
