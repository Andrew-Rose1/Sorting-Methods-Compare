import java.util.*;

class SortingPack {
    // just in case you need tis method for testing
    public static void main(String[] args) {
        // something
    }



    // implementation of insertion sort
    // parameters: int array unsortedArr
    // return: sorted int array
    public static int[] insertionSort(int[] unsortedArr) {
      for (int i = 1; i <= unsortedArr.length-1; i++) {
        int key = unsortedArr[i];
        int j = i - 1;
        while (j >= 0 && unsortedArr[j] > key) {
          unsortedArr[j+1] = unsortedArr[j];
          j = j - 1;
        }
        unsortedArr[j+1] = key;
      }
      return unsortedArr;
    }



    // implementation of quick sort
    // parameters: int array unsortedArr
    // return: sorted int array
    public static int[] quickSort(int[] unsortedArr) {
      int first = 0;
      int last = unsortedArr.length - 1;
      quickSortHelper(unsortedArr, first, last);
      return unsortedArr;
    }



    // implementation of merge sort
    // parameters: int array unsortedArr
    // return: sorted int array
    public static int[] mergeSort(int[] unsortedArr) {
      if (unsortedArr.length > 1) {
        int mid = unsortedArr.length / 2;
        // Create Copies of the first and second halves of the original array
        int[] lefthalf = Arrays.copyOfRange(unsortedArr, 0, mid);
        int[] righthalf = Arrays.copyOfRange(unsortedArr, mid, unsortedArr.length);
        mergeSort(lefthalf);
        mergeSort(righthalf);
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < lefthalf.length && j < righthalf.length) {
          if (lefthalf[i] < righthalf[j]) {
            unsortedArr[k] = lefthalf[i];
            i++;
          } else {
            unsortedArr[k] = righthalf[j];
            j++;
          }
          k++;
        }
        while (i < lefthalf.length) {
          unsortedArr[k] = lefthalf[i];
          i++;
          k++;
        }
        while (j < righthalf.length) {
          unsortedArr[k] = righthalf[j];
          j++;
          k++;
        }
      }
      return unsortedArr;
    }



    // implementation of heap sort
    // parameters: int array unsortedArr
    // return: sorted int array
    public static int[] heapSort(int[] unsortedArr) {
      // Create and object from HeapMax class located in HeapMax.java
      HeapMax h = new HeapMax();
      for (int num : unsortedArr) {
        h.insert(num);
      }
      //int[] sortedArr2 = h.toAnArray();
      //for (int k = 0; k < sortedArr2.length; k++) {
        //System.out.print(sortedArr2[k]);
      //}
      //System.out.println(" ");
      //return sortedArr2;
      ArrayList<Integer> sortedData = h.getData();
      int[] sortedData1 = new int[sortedData.size()];
      int index = 0;
      for (int m : sortedData) {
        sortedData1[index] = m;
        index++;
      }
      /* TESTING --- HAD TROUBLE WITH CONVERTING FROM ARRAYLIST TO AN ARRAY
      for (int k = 0; k < sortedData1.length; k++) {
        System.out.print(sortedData1[k] + " ");
      }
      System.out.println(" ");
      */
      return sortedData1;
    }




    // you are welcome to add any supporting methods
    public static int partition(int[] unsortedArr, int first, int last) {
      int pivotvalue = unsortedArr[first];
      int l = first + 1;
      int r = last;
      boolean done = false;
      while (done == false) {
        while (l <= r && unsortedArr[l] <= pivotvalue) {
          l = l + 1;
        }
        while (unsortedArr[r] >= pivotvalue && r >= l) {
          r = r - 1;
        }
        if (r < l) {
          done = true;
        } else {
          int temp = unsortedArr[l];
          unsortedArr[l] = unsortedArr[r];
          unsortedArr[r] = temp;
        }
      }
      int temp = unsortedArr[first];
      unsortedArr[first] = unsortedArr[r];
      unsortedArr[r] = temp;
      return r;
    }



    //quickSort helper method. Needed more paramaters...
    public static int[] quickSortHelper(int[] unsortedArr, int first, int last) {
      if (first < last) {
        int splitpoint = partition(unsortedArr, first, last);
        quickSortHelper(unsortedArr, first, splitpoint-1);
        quickSortHelper(unsortedArr, splitpoint+1, last);
      }
      return unsortedArr;
    }
}
