import java.util.Arrays;

public class Lab1 {
    /** Sorting algorithms **/

    // Insertion sort.
    public static void main(String[] args) {
        //int[] a = {1,3,5,4,0};
        //int[] a = {0, 1, 2, 3, 4, 5};
        int[] a = {0,3,3,4,4,1};

        System.out.println(Arrays.toString(a));
        insertionSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void insertionSort(int[] array) {
        //boolean sorted = false;
        int index = 1;
        while (index < array.length){
            int pivot = array[index];

            if (pivot < array[index-1]){ // If the pivot is less than its predecessor

                for (int i = index-1; i >= 0; i--) { // Loop backwards moving elements up one step to the right.(+1)
                    if (pivot < array[i]){ // If the pivot is less than its predecessor
                        array[i+1] = array[i]; // move the element up (+1)
                    }
                    else{ // if the predecessor is less than the pivot, place it.
                        array[i+1] = pivot;
                        break;
                    }
                    if (i == 0){ // if the pivot doesn't have a predecessor, place it first
                        array[i] = pivot;
                    }
                }
            }
            index++;
        }

    }


    // Quicksort.
    public static void quickSort(int[] array) {
        throw new UnsupportedOperationException();
    }

    // Quicksort part of an array
    private static void quickSort(int[] array, int begin, int end) {
    }

    // Partition part of an array, and return the index where the pivot
    // ended up.
    private static int partition(int[] array, int begin, int end) {
        throw new UnsupportedOperationException();
    }

    // Swap two elements in an array
    private static void swap(int[] array, int i, int j) {
        int x = array[i];
        array[i] = array[j];
        array[j] = x;
    }

    // Mergesort.

    public static int[] mergeSort(int[] array) {
        throw new UnsupportedOperationException();
    }

    // Mergesort part of an array
    private static int[] mergeSort(int[] array, int begin, int end) {
        throw new UnsupportedOperationException();
    }

    // Merge two sorted arrays into one
    private static int[] merge(int[] left, int[] right) {
        throw new UnsupportedOperationException();
    }
}

