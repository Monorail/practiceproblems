import java.util.*;
public class LowestInSorted{
    public static void main(String args[]){
        final int NUM_ELEMS = 15;
        int[] number_arr = new int[NUM_ELEMS];
        
        Random r = new Random();
        // fill array 0 - 100
        for(int i = 0; i < NUM_ELEMS; ++i){
            int num_to_add = r.nextInt(100);
            number_arr[i] = num_to_add;
        }
        
        // contrast array before and after
        Arrays.sort(number_arr);
        print_int_arr(number_arr);
        quick_rotate_array(number_arr, 2);
        int left = 0;
        int right = number_arr.length-1;
        for(int i = 0; i < 10; i++) {
            print_int_arr(Arrays.copyOfRange(number_arr, left, right));
            if(number_arr[left] <= number_arr[right]){
                System.out.println(left);
                break;
            }
            int mid = (right - left)/2;
            if(number_arr[mid] < number_arr[left])
                right = mid;
            else
                left = mid;
        }
    }
    //calls subfunction rotate 'steps' times
    public static void long_rotate_array(int[] arr, int steps){
        for(int i = 0; i < steps; i++){
            rotate_array(arr);
        }
    }
    
    public static void quick_rotate_array(int[] arr, int steps){
        int pivot = arr.length-1-steps;
        if(pivot < 0) return;
        reverse_array(arr, -1, pivot);
        reverse_array(arr, pivot + 1, -1);
        reverse_array(arr, -1, -1);
    }
    
    public static void rotate_array(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        int temp_num = arr[0];
        for(int i = 1; i < arr.length; ++i){
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = temp_num;
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
    
    public static void print_int_arr(int[] arr){
        if(arr == null){
            System.out.println("<Null array>");
            return;
        }
        if(arr.length == 0){
            System.out.println("<Empty array>");
            return;
        }
        for(int i = 0; i < arr.length; ++i){
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
}