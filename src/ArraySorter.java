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
  
  
  public static <T> void heapSort(Comparable[] array)
  {
	  BinaryHeapA bh = new BinaryHeapA();
	  
	  bh.buildMaxHeap(array);
	  
	  
  }
  
  public static void heapify(Comparable[] array){
	
	  
		  
	
			  
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
