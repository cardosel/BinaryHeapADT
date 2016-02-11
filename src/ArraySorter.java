public class ArraySorter
{
  public static void selectionSort(Comparable[] array)
  {
    for (int i = 0; i < array.length; i++)
    {
      int minIndex = findMinIndexPast(array, i);
      
      Comparable tempElement = array[i];
      array[i] = array[minIndex];
      array[minIndex] = tempElement;
    }
  }
  
  

  
  private static int findMinIndexPast(Comparable[] array, int startIndex)
  {
    int minIndex = startIndex;
    for (int i = startIndex + 1; i < array.length; i++) {
      if (array[i].compareTo(array[minIndex]) < 0) {
        minIndex = i;
      }
    }
    return minIndex;
  }
  // method to call heapSort using heapify
  public static void heapSort(Comparable[] array)
  {
    for (int i = 1; i < array.length; i++) {
      heapify(array, i);
    }
  }
  // heapify method
  public static void heapify(Comparable[] array, int n) {
		
		// create first heap
		for (int rootIndex = n/2-1; rootIndex >= 0; rootIndex--)
			buildHeap(array, rootIndex, n-1);
		swap(array, 0, n-1);
		for (int lastIndex = n-2; lastIndex > 0; lastIndex--) {
			buildHeap(array, 0, lastIndex);
			swap(array, 0, lastIndex);
		} 
	}
// method to reassemble heap
  private static void buildHeap(Comparable[] heap, int rootIndex, int lastIndex) {
		boolean done = false;
		Comparable orphan = heap[rootIndex];
		int largerChildIndex = 2 * rootIndex + 1; // index of left child, if any
		
		while (!done && (largerChildIndex <= lastIndex) ) {
			int rightChildIndex = largerChildIndex + 1;
			if ( (rightChildIndex <= lastIndex) &&
			      heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0) {
				largerChildIndex = rightChildIndex;
			}
			if (orphan.compareTo(heap[largerChildIndex]) < 0) {
				heap[rootIndex] = heap[largerChildIndex];
				rootIndex = largerChildIndex;
				largerChildIndex = 2 * rootIndex + 1; // index of next left child
			}
			else
				done = true;
		} 
		
		heap[rootIndex] = orphan;
	}




private static void swap(Comparable[] a, int i, int i2) {
	Comparable[] valueArray = a;
	Comparable temp = valueArray[i];
	valueArray[i] = valueArray[i2];
	valueArray[i2] = temp;
}
 
 
  public static void insertionSort(Comparable[] array)
  {
    for (int i = 1; i < array.length; i++) {
      insert(array, i);
    }
  }
  
  private static void insert(Comparable[] array, int endIndex)
  {
    Comparable elementToInsert = array[endIndex];
    for (int i = 0; i < endIndex; i++) {
      if (elementToInsert.compareTo(array[i]) < 0)
      {
        bumpUp(array, i, endIndex);
        
        array[i] = elementToInsert;
        
        return;
      }
    }
  }
  
  private static void bumpUp(Comparable[] array, int startIndex, int endIndex)
  {
    for (int i = endIndex; i > startIndex; i--) {
      array[i] = array[(i - 1)];
    }
  }
  
  public static void bubbleSort(Comparable[] array)
  {
    for (int i = 0; i < array.length; i++) {
      bubbleArray(array);
    }
  }
  
  private static void bubbleArray(Comparable[] array)
  {
    for (int i = 0; i < array.length - 1; i++) {
      if (array[i].compareTo(array[(i + 1)]) > 0)
      {
        Comparable tempElt = array[i];
        array[i] = array[(i + 1)];
        array[(i + 1)] = tempElt;
      }
    }
  }
  
  public static void mergeSort(Comparable[] array)
  {
    mergeSortR(array, 0, array.length - 1);
  }
  
  private static void mergeSortR(Comparable[] array, int lo, int hi)
  {
    if (hi <= lo) {
      return;
    }
    int mid = (int)Math.floor((lo + hi) / 2);
    
    mergeSortR(array, lo, mid);
    
    mergeSortR(array, mid + 1, hi);
    
    merge(array, lo, hi);
  }
  
  private static void merge(Comparable[] array, int lo, int hi)
  {
    int mid = (int)Math.floor((lo + hi) / 2);
    
    Comparable[] lowerHalf = new Comparable[mid - lo + 1];
    System.arraycopy(array, lo, lowerHalf, 0, mid - lo + 1);
    
    Comparable[] upperHalf = new Comparable[hi - mid];
    System.arraycopy(array, mid + 1, upperHalf, 0, hi - mid);
    
    int i = 0;
    int j = 0;
    for (int k = lo; k <= hi; k++) {
      if (i == lowerHalf.length)
      {
        array[k] = upperHalf[j];
        
        j++;
      }
      else if ((j == upperHalf.length) || (lowerHalf[i].compareTo(upperHalf[j]) < 0))
      {
        array[k] = lowerHalf[i];
        
        i++;
      }
      else
      {
        array[k] = upperHalf[j];
        
        j++;
      }
    }
  
  }
}




