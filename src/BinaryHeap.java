
public interface BinaryHeap<T extends Comparable<T>> {

	
	// maxheapify method
	public void maxHeapify(Comparable[] valueArray);
	
	// buildmaxheap method
	public Comparable[] buildMaxHeap(Comparable[] internalArray);
	
	// add method
		public void add(Comparable newEntry);
	
	// remove method
	public Comparable remove();
	
	// to array method
	public Comparable[] toArray(Comparable[] internalArray);
	
	// from array method
	public void fromArray(Comparable[] internalArray);
	
	
	
}
