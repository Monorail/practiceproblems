import java.util.*;
public class QuickSort{
    
    public static void main(String args[]){
        int[] arr = new int[15];
        Random r = new Random();
        for(int i = 0; i < arr.length; i++){
            arr[i] = r.nextInt(100);
        }
        print_int_arr(arr);
        quicksort(arr, 0, arr.length-1);
        print_int_arr(arr);
    }
    
    //uses middle index for partition
    public static void quicksort(int[] arr, int left_bound, int right_bound){
        if(left_bound < right_bound)
            return;
        int pivot = arr[right_bound];
        int found_left = -1;
        int found_right = -1;
        int left_comp = left_bound;
        int right_comp = right_bound;
        while(left_comp <= right_comp){
            if(left_comp == pivot || right_comp == pivot)
                break;
            if(arr[left_comp] == arr[pivot])
                left_comp++;
            if(arr[right_comp] == arr[pivot])
                right_comp--;
            if(found_left == -1 && arr[left_comp] > arr[pivot]){
                found_left = left_comp;
            }
            if(found_right == -1 && arr[right_comp] < arr[pivot]){
                found_right = right_comp;
            }
            if(found_right != -1 && found_left != -1){
                int temp = arr[found_left];
                arr[found_left] = arr[found_right];
                arr[found_right] = temp;
                found_left = -1;
                found_right = -1;
            }
            if(found_left == -1)
                left_comp++;
            if(found_right == -1)
                right_comp--;
        }
        quicksort(arr, left_bound, pivot-1);
        quicksort(arr, pivot+1, right_bound);
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