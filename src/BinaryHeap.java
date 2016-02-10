
public interface BinaryHeap<T extends Comparable<T>> {
	
	public void add(T value);
	
	public T remove();
	
	public T[] toArray(T[] array);
	
	public void fromArray(T[] array);
	
	public T[] buildMaxHeap(T[] array);
	
	
	
}