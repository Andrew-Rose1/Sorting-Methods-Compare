import java.util.*;
import java.util.ArrayList;

class HeapMax {
    // we go with arraylist instead of array for size flexibility
    private ArrayList<Integer> data;

    // default constructor
    public HeapMax() {
      data = new ArrayList<Integer>(0);
    }

    // DO NOT MODIFY THIS METHOD
    public ArrayList<Integer> getData() {
      return data;
    }

    // insert a new element and restore max heap property
    public void insert(int element) {
      data.add(element);
      int i = data.size() - 1;
      while ((i > 0) && ((i-1)/2 >= 0)) {
        if (data.get((i)) > data.get(((i-1)/2))) {
          int tmp = data.get((i));
          //data.set(i) = data.get((i-1)/2);
          data.set(i, data.get((i-1)/2));
          data.set((i-1)/2, tmp);
        }
        i = (i-1)/2;
      }
    }

    // return max
    public int getMax() {
      // remove this line
      return data.get(0);
    }

    // remove max and restore max heap property
    public int removeMax() {
      // remove this line
      int val = data.get(data.size()-1);
      data.remove(data.size()-1);
      data.set(0, val);
      heapify(0);
      return data.get(data.size()-1);
    }

    // heap builder
    public void build(int[] arr) {
      for (int i = data.size() / 2 - 1; i >= 0; i--)
            heapify(i);
    }

    // print out heap as instructed in the handout
    public void display() {
      System.out.print("Current heap is: ");
      for (int j = 0; j <= data.size() - 1; j++) {
        System.out.print(data.get(j) + " ");
      }
      System.out.println(" ");
    }

    // you are welcome to add any supporting methods
    public void heapify(int i) {
      while (2*i+1 < data.size()) {
        int maxChildIndex = maxChild(i);
        if (data.get(i) < data.get(maxChildIndex)) {
          int temp = data.get(maxChildIndex);
          data.set(maxChildIndex, data.get(i));
          data.set(i, temp);
        }
        i = maxChildIndex;
      }
    }

    public int maxChild(int i) {
      int cl = 2*i + 1;
      int cr = 2*i + 2;
      if ((cr >= data.size()) || (data.get(cl) > data.get(cr))) {
        return cl;
      } else {
          return cr;
      }
    }



}
