import java.util.Arrays;

public class arrays {
    public static void main(String[] args) {

        //arrays
        String[] array1 = new String [50];
        int[] array2 = {0,100,2,10,3,9,4,8,5,7,6};
        for (int i = 0; i< array1.length; i++){//standard for with array
            //System.out.print(array1[i]);
        }
        for (int i : array2) {//enhanced for with array
            i=i+1-1;
            //System.out.print(i);
        }
        Arrays.sort(array2);//acending order
        //System.out.println(array2[array2.length-1]);//highest value in array
    }
}
