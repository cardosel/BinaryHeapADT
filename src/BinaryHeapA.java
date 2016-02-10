import java.util.ArrayList;
import java.lang.Comparable;



public class BinaryHeapA<T extends Comparable<T>> implements BinaryHeap<T>{
	
private Node root = null;
private int heapSize = 0;


			
	public void add(T value) {
			int tempSize = heapSize + 1;
			Node currentNode = root;
			if (heapSize == 0 || root == null) {
				root = new Node(value, null);
				currentNode = root;
				//System.out.println(currentNode.value + " is added at root");
			} else {
				boolean left = true;
				for (int i = 0; i < nextDepth() - 1; i++) {
	
					if ((((Math.pow(2, nextDepth() + 1 - i) - 1)) - (tempSize)) >= Math
							.pow(2, nextDepth() - i - 1)) {
						currentNode = currentNode.leftChild;
						left = true;
					//	System.out.println("moved left");
					} else {
						currentNode = currentNode.rightChild;
						left = false;
					//	System.out.println("moved right");
					}
	
					if (left) {
						tempSize = (int) (tempSize - Math.pow(2, nextDepth() - i
								- 1));
					} else {
						tempSize = (int) (tempSize - Math.pow(2, nextDepth() - i));
					}
				}
	
				if (currentNode.leftChild == null) {
					currentNode.leftChild = new Node(value, currentNode);
					//System.out.println(currentNode.leftChild.value
					//		+ " added to left. parent is " + currentNode.value);
					siftUp(currentNode.leftChild, "add");
	
				} else if (currentNode.leftChild != null
						&& currentNode.rightChild == null) {
					currentNode.rightChild = new Node(value, currentNode);
	//
				//	System.out.println(currentNode.rightChild.value
					//		+ " added to right. parent is " + currentNode.value);
					siftUp(currentNode.rightChild, "add");
	
				}
	
			}
			heapSize++;
		}			
			
/*
* here lies the array methods of the heap.
*/
// ////////////////////////////////////////////////////////////////////////////
// ////////////////////////////////////////////////////////////////////////////
	
	public void fromArray(T[] array) {
		T[] valueArray = array;
		for (int i = 0; i < valueArray.length; i++) {
			add(valueArray[i]);
		}

	}	
			
			

	public T[] buildMaxHeap(T[] array) {
		T[] sortedArray = (T[]) java.lang.reflect.Array.newInstance(array
				.getClass().getComponentType(), heapSize);
		sortedArray = toArray(array);
		
		if(heapSize == 1){
			return sortedArray;
		}
		for (int i = 0; i < (heapSize)  ; i++) {
			swap(sortedArray, 0, sortedArray.length - 1 - i);
			arraySiftDown(sortedArray, i + 1);
		}
		swap(sortedArray, 0, 1);

		return sortedArray;
	}
	
	//-----------------------------------
	
	private void swap(T[] array, int i1, int i2) {
		T[] valueArray = array;
		T temp = valueArray[i1];
		valueArray[i1] = valueArray[i2];
		valueArray[i2] = temp;
	}
	
	
	
	private void arraySiftDown(T[] array, int counter) {
		int pointer = 0;
		int left;
		int right;
		
		for (int i = 0; i < (Math.floor(Math.log(heapSize - counter) / Math.log(2))); i++) {
			left = 2 * pointer + 1;
			right = 2 * pointer + 2;
			if (left >= array.length - counter) {
				return;
			}
			if ((right >= array.length - counter) && (left < array.length - counter)) {
				if (array[pointer].compareTo(array[left]) > 0) {
					swap(array, pointer, left);
					pointer = left;
				}
	
			}
	
			if (left < array.length - counter && right < array.length - counter) {
				if(array[right].compareTo(array[left]) > 0){
					if(array[pointer].compareTo(array[right]) < 0){
						swap(array, pointer, right);
						pointer = right;
					}
				} else{
					if(array[pointer].compareTo(array[left]) < 0 ){
						swap(array, pointer, left);
						pointer = left;
					}
				}
			}
		}
	}
	
	
	
	
	public T[] toArray(T[] array) {
		int counter = 0;
		Node tempNode;
		T[] valuesArray = (T[]) java.lang.reflect.Array.newInstance(array
				.getClass().getComponentType(), heapSize);
		ArrayList<BinaryHeapA<T>.Node> queue = new ArrayList<Node>();
		queue.add(root);

		while (!queue.isEmpty()) {
			tempNode = (Node) queue.remove(0);
			valuesArray[counter] = tempNode.value;
			if (tempNode.leftChild != null) {
				queue.add(tempNode.leftChild);
			}
			if (tempNode.rightChild != null) {
				queue.add(tempNode.rightChild);
			}
			counter++;
		}

		return valuesArray;
	}
	
	
	
	//--------------------------------------------------
	private void siftUp(Node node, String string) {
		Node n = node;
		if (n.parent == null) {
			return;
		}

		for (int i = 0; i < nextDepth(); i++) {

			if (n.value.compareTo(n.parent.value) > 0) {
				swap(n, n.parent);
				n = n.parent;
			} else {
				break;
			}
		}

	}

	private void siftDown(Node node) {
		Node n = node;
		for (int i = 0; i < depth(); i++) {

			if (n.leftChild != null && n.rightChild != null) {
				if (n.leftChild.value.compareTo(n.value) > 0
						|| n.rightChild.value.compareTo(n.value) > 0) {

					if (n.leftChild.value.compareTo(n.rightChild.value) > 0) {
						swap(n, n.leftChild);
						n = n.leftChild;
					} else {
						swap(n, n.rightChild);
						n = n.rightChild;
					}

				}
			} else if (n.leftChild != null && n.rightChild == null) {
				if (n.leftChild.value.compareTo(n.value) > 0) {
					swap(n, n.leftChild);
					n = n.leftChild;
				}
			} else if (n.rightChild != null && n.leftChild == null) {

				if (n.rightChild.value.compareTo(n.value) > 0) {
					swap(n, n.rightChild);
					n = n.rightChild;
				}
			}
		}

	}
	
private void swap(Node node1, Node node2) {
		
//		System.out.println(node1.value + " is swapped with " + node2.value);
		T temp = node1.value;
		node1.value = node2.value;
		node2.value = temp;
	}

private int depth() {
	int depth = (int) Math.floor(((double) Math.log(heapSize) / (double) Math
			.log(2)));
	return depth;
}

private int nextDepth() {
	int depth = (int) Math
			.floor(((double) Math.log(heapSize + 1) / (double) Math.log(2)));
	return depth;
}

private class Node {

	protected T value;
	protected Node rightChild;
	protected Node leftChild;
	protected Node parent;

	Node(T t, Node parent) {

		value = t;
		this.parent = parent;
	}
}

public T remove() {
	T removedValue = root.value;

	Node currentNode = root;
	int tempSize = heapSize;
	boolean left = true;

	if (heapSize <= 1) {

		root = null;
		if (heapSize > 0) {
			heapSize--;
		}
		return removedValue;
	} else if (heapSize == 2) {
		root.leftChild.parent = null;
		root = root.leftChild;
		heapSize--;
		return removedValue;
	}
	for (int i = 0; i < depth(); i++) {

		if ((((Math.pow(2, depth() + 1 - i) - 1)) - (tempSize)) >= Math
				.pow(2, depth() - i - 1)) {

			currentNode = currentNode.leftChild;

			left = true;
		//	System.out.println("moved left");
		} else {

			currentNode = currentNode.rightChild;
			left = false;
		//System.out.println("moved right");
		}

		if (left) {
			tempSize = (int) (tempSize - Math.pow(2, depth() - i - 1));
		} else {
			tempSize = (int) (tempSize - Math.pow(2, depth() - i));
		}

	}
	root.value = currentNode.value;
	if (left && heapSize > 1) {
		currentNode.parent.leftChild = null;
	} else if (!left && heapSize > 2) {
		currentNode.parent.rightChild = null;
	}
//	System.out.println("root is now " + root.value);
	siftDown(root);

	if (heapSize > 0) {

		heapSize--;
	}

	return removedValue;
}

	public T peek(){
		return root.value;
	}





}
			

	
		  
		  
		  
		  
	
	        
	        
	        
	   
	


