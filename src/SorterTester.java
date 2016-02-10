import java.io.PrintStream;

public class SorterTester
{
  public static boolean PRINT_NUMS = false;
  
  public static void testArraySelectionSort(Comparable[] array)
  {
    if (PRINT_NUMS)
    {
      System.out.println("before array selection sort: ");
      printArray(array);
    }
    long pre1 = System.currentTimeMillis();
    ArraySorter.selectionSort(array);
    long pre2 = System.currentTimeMillis();
    if (PRINT_NUMS)
    {
      System.out.println("after array selection sort: ");
      printArray(array);
    }
    System.out.println("array selection sort took " + (pre2 - pre1) + " ms");
    System.out.println("************************");
  }
  
  public static void testArrayInsertionSort(Comparable[] array)
  {
    if (PRINT_NUMS)
    {
      System.out.println("before array insertion sort: ");
      printArray(array);
    }
    long pre1 = System.currentTimeMillis();
    ArraySorter.insertionSort(array);
    long pre2 = System.currentTimeMillis();
    if (PRINT_NUMS)
    {
      System.out.println("after array insertion sort: ");
      printArray(array);
    }
    System.out.println("array insertion sort took " + (pre2 - pre1) + " ms");
    System.out.println("************************");
  }
  
  public static void testArrayBubbleSort(Comparable[] array)
  {
    if (PRINT_NUMS)
    {
      System.out.println("before array bubble sort: ");
      printArray(array);
    }
    long pre1 = System.currentTimeMillis();
    ArraySorter.bubbleSort(array);
    long pre2 = System.currentTimeMillis();
    if (PRINT_NUMS)
    {
      System.out.println("after array bubble sort: ");
      printArray(array);
    }
    System.out.println("array bubble sort took " + (pre2 - pre1) + " ms");
    System.out.println("************************");
  }
  
  public static void printArray(Comparable[] array)
  {
    if (array == null)
    {
      System.out.println("null array");
    }
    else
    {
      System.out.print(array[0].toString());
      for (int i = 1; i < array.length; i++) {
        System.out.print(", " + array[i].toString());
      }
    }
    System.out.println("");
  }
  
  public static Integer[] randomIntegerArray(int lo, int hi, int length)
  {
    Integer[] a = new Integer[length];
    for (int i = 0; i < length; i++) {
      a[i] = new Integer((int)Math.floor(Math.random() * (hi - lo) + lo));
    }
    return a;
  }
  
  public static void testSorts(int numIterations, int lo, int hi, int length)
  {
    for (int i = 0; i < numIterations; i++)
    {
      System.out.println("TESTING ITERATION " + i);
      testSorts(lo, hi, length);
    }
  }
  
  public static void testSorts(int lo, int hi, int length)
  {
    Integer[][] randomArrayCopies = new Integer[3][length];
    
    randomArrayCopies[0] = randomIntegerArray(lo, hi, length);
    for (int i = 1; i < randomArrayCopies.length; i++) {
      System.arraycopy(randomArrayCopies[0], 0, 
        randomArrayCopies[i], 0, 
        randomArrayCopies[0].length);
    }
    testArraySelectionSort(randomArrayCopies[0]);
    testArrayInsertionSort(randomArrayCopies[1]);
    testArrayBubbleSort(randomArrayCopies[2]);
  }
  
  public static void main(String[] args)
  {
    int lo = 64536;
    int hi = 40000;
    int length = 2000;
    int numIterations = 5;
    
    testSorts(numIterations, lo, hi, length);
  }
}
