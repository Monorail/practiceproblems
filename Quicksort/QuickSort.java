import java.util.*;
public class QuickSort{
    
    public static void main(String args[]){
        int[] arr = new int[100];
        Random r = new Random();
        for(int i = 0; i < arr.length; i++){
            arr[i] = r.nextInt(100);
        }
        print_int_arr(arr);
        my_quicksort(arr, 0, arr.length-1);
        print_int_arr(arr);
    }
    
    /*
    Right to left recursive quicksort
    Places a pivot on the rightmost element in the array and moves all elements lower
    than it to the left, then finally places the pivot itself after all the lower 
    elements. Recursively called on the subarrays on the left and right of the pivot
    until all subarrays contain one element.
    */
    
    public static void my_quicksort(int[] arr, int left_bound, int right_bound){
        //base case: only one element in subarray
        if(right_bound - left_bound < 0){
            System.out.printf("Quicksort() returning.\n");
            return;
        }
        System.out.printf("Quicksort() between %d and %d.\n", arr[left_bound], arr[right_bound]);
        // System.out.println("ping");
        int pivot = right_bound;
        int wall = left_bound;
        for(int i = left_bound; i < right_bound; ++i){
            if(arr[i] <= arr[pivot]){
                swap(arr, wall, i);
                wall++;
            }
        }
        swap(arr, wall, pivot);
        print_int_arr(arr);
        my_quicksort(arr, left_bound, wall-1);
        my_quicksort(arr, wall+1, right_bound);
    }
    
    public static void quicksort_lomuto(int[] arr, int left_bound, int right_bound){
        if(left_bound < right_bound){
            int p = old_partition(arr, left_bound, right_bound);
            quicksort_lomuto(arr, left_bound, p-1);
            quicksort_lomuto(arr, p+1, right_bound);
        }
    }
    
    public static int old_partition(int[] arr, int lo, int hi){
        System.out.println("ping");
        int pivot = arr[hi];
        int i = lo - 1;
        for(int j = lo; j < hi; j++){
            if(arr[j] <= pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, hi);
        return i+1;
    }
    
    public static void swap(int[] arr, int ind_a, int ind_b){
        System.out.printf("swap %d and %d\n", arr[ind_a], arr[ind_b]);
        int temp = arr[ind_a];
        arr[ind_a] = arr[ind_b];
        arr[ind_b] = temp;
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