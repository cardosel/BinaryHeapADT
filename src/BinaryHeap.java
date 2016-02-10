
public interface BinaryHeap<T extends Comparable<T>> {
	
	
	
	public void maxHeapify(Comparable[] valueArray);
	
	public Comparable[] buildMaxHeap(Comparable[] internalArray);
	
	public Comparable remove();
	
	public Comparable[] toArray(Comparable[] internalArray);
	
	public void fromArray(Comparable[] internalArray);
	
	
	
	
	
}