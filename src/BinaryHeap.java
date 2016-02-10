
public interface BinaryHeap<T extends Comparable<T>> {

	
	
	public void maxHeapify(Comparable[] valueArray);
	
	public Comparable[] buildMaxHeap(Comparable[] internalArray);
	
	public Comparable remove();
	
	public Comparable[] toArray(Comparable[] internalArray);
	
	public void fromArray(Comparable[] internalArray);
	

	
	// method to add value
	public void add(T value);
	
	//method to remove value from array
	public T remove();
	
	//method to set value to array
	public T[] toArray(T[] array);
	
	//method to get value from array
	public void fromArray(T[] array);
	
	//method that builds maxheap from array
	public T[] buildMaxHeap(T[] array);
>>>>>>> origin/master
	
	
	
}
