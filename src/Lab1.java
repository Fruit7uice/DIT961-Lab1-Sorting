import java.util.Arrays;

public class Lab1 {
    /**
     * Sorting algorithms
     **/

    // Insertion sort.
    public static void main(String[] args) {
        int[] a = {1,3,5,4,0};
        //int[] a = {0, 1, 2, 3, 4, 5};
        //int[] a = {5,5,4,3,2,1,0,7,8,9};
        //int[] a = {2, 1, 3, 4, 8, 6};
        //int[] one = {1, 2, 3};
        //int[] two = {4, 5, 6};


        System.out.println(Arrays.toString(a));
        //insertionSort(a);
        //System.out.println(Arrays.toString(a));
        //quickSort(a);
        //System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(mergeSort(a)));
        //System.out.println(Arrays.toString(merge(two, one)));
    }



    public static void insertionSort(int[] array) {
        //boolean sorted = false;
        int index = 1;
        while (index < array.length) {
            int pivot = array[index];

            if (pivot < array[index - 1]) { // If the pivot is less than its predecessor

                for (int i = index - 1; i >= 0; i--) { // Loop backwards moving elements up one step to the right.(+1)
                    if (pivot < array[i]) { // If the pivot is less than its predecessor
                        array[i + 1] = array[i]; // move the element up (+1)
                    } else { // if the predecessor is less than the pivot, place it.
                        array[i + 1] = pivot;
                        break;
                    }
                    if (i == 0) { // if the pivot doesn't have a predecessor, place it first
                        array[i] = pivot;
                    }
                }
            }
            index++;
        }

    }


    // Quicksort.
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    // Quicksort part of an array
    private static void quickSort(int[] array, int begin, int end) {

        if (begin >= end) { //If begin is already greater or equal to end, jump out.
            return;
        }
/*  blir långsammare, bara test
        if (end - begin < 10) {
            insertionSort(array);
        }
*/
        int pivot = partition(array, begin, end); //the place where split will happen

        quickSort(array, begin, pivot - 1); //recursive call on quicksort left of pivot
        quickSort(array, pivot, end); // recursive call on quicksort on right side of pivot with pivot included

    }

    // Partition part of an array, and return the index where the pivot
    // ended up.
    private static int partition(int[] array, int begin, int end) {
        int pivot = array[begin];
        while (begin <= end) {
            while (array[begin] < pivot && begin <= end ) {
                begin++;
            }
            while (array[end] > pivot && begin <= end) {
                end--;
            }
            if (begin <= end) {
                swap(array, begin++, end--);
            }
        }
          //swap(array, pivot, array[left]);
        return begin;

    }

    // Swap two elements in an array
    private static void swap(int[] array, int i, int j) {
        int x = array[i];
        array[i] = array[j];
        array[j] = x;
    }

    // Mergesort.

    public static int[] mergeSort(int[] array) {
        return (mergeSort(array, 0, array.length-1));
    }

    // Mergesort part of an array
    private static int[] mergeSort(int[] array, int begin, int end) {
        int len = array.length;;
        if (len == 1) return array;

        int mid = (end-begin)/2;

        int[] left = new int[mid+1];
        int[] right = new int[end-mid];
        for (int i = 0; i < left.length; i++) {
            left[i] = array[i];
        }
        for (int i = 0; i < right.length ; i++) {
            right[i] = array[i + mid + 1];
        }

        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }



    // Merge two sorted arrays into one
    private static int[] merge(int[] left, int[] right) {
        int leftLen = left.length;
        int rightLen = right.length;
        int i, j, k;
        i = 0;
        j = 0;
        k = 0;

        int[] tmp = new int[leftLen + rightLen];
        while(leftLen > i && rightLen > j){
            if (left[i] > right[j]){
                tmp[k] = right[j++];
            }
            else {
                tmp[k] = left[i++];
            }
            k++;
        }
        while (i < leftLen) {
            tmp[k++] = left[i++];
        }

        while (j < rightLen) {
            tmp[k++] = right[j++];
        }
        return tmp;
    }
}

