import java.util.*;
public class ReverseArray{
    public static void main(String args[]){
        final int NUM_ELEMS = 15;
        int[] number_arr = new int[NUM_ELEMS];
        Random r = new Random();
        // fill array 0 - 100
        for(int i = 0; i < NUM_ELEMS; ++i){
            int num_to_add = r.nextInt(100);
            number_arr[i] = num_to_add;
        }
        Arrays.sort(number_arr);
        for(int i = 0; i < NUM_ELEMS; ++i){
            System.out.print(number_arr[i] + " ");
        }
        System.out.println("");
        reverse_array((int[])number_arr, -1, -1);
        for(int i = 0; i < NUM_ELEMS; ++i){
            System.out.print(number_arr[i] + " ");
        }
        System.out.println("");
    }
    // reverses the elements in an array
    public static void reverse_array(int[] arr, int start, int end){
        if(arr == null || arr.length < 1 ){
            return;
        }
        int left   = (start == -1)?0:start;
        int right  = (end   == -1)?arr.length-1:end;
        while(left < right){
            int temp_obj = arr[left];
            arr[left] = arr[right];
            arr[right] = temp_obj;
            ++left;
            --right;
        }
    }
}