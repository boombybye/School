public class ArrayListPrime {
    Object[] array;



    public static void main(String[] args) {
        
    }

    ArrayListPrime(){
        array = new Object[10];
    }
    ArrayListPrime(int size){
        array = new Object[size];
    }

    public void add(Object element){
        checkLength();
        for(int i = 0; i<array.length; i++){
            if(array[i]==null){
                array[i] = element;
                return;
            }
        }
    }

    public void add(int index, Object element){
        checkLength();
        for(int i = array.length-1;i>index;i--){
            array[i] = array[i-1];
        }
        array[index] = element;
    }

    public void checkLength(){
        if(array[array.length-1]!=null){
            Object[] temp = new Object[array.length+1];
            for(int i = 0; i<array.length; i++){
                temp[i] = array[i];
            }
            array = temp;
        }
    }

}
