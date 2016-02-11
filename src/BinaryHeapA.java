import java.util.ArrayList;
import java.lang.Comparable;



public class BinaryHeapA<T extends java.lang.Comparable<T>> implements BinaryHeap<T>{
	
// comparable array representing internal array
private Comparable[] internalArray;
// integer variable representing size of heap
private int heapSize;
// node variable reprsenting root of heap
private Node root = null;
private int lastIndex;


// BinaryHeapA constructor
public BinaryHeapA() {
    heapSize = internalArray.length;
    internalArray = (T[]) new Comparable[ ( heapSize + 2 ) * 11 / 10 ];

    buildMaxHeap(internalArray);
}	

// method to delete values within array
public void delete() {
    for (int i = heapSize; i < internalArray.length - 1; i++) {
        internalArray[i] = internalArray[i+1];
    }
}
	// max-heapify method that takes in a comparable array
	public void maxHeapify(Comparable[] array) {
			int tempSize = heapSize + 1;
			Node currentNode = root;
			
			
			
			if (heapSize == 0 || root == null) {
				root = new Node(array, null);
				currentNode = root;
				//System.out.println(currentNode.value + " is added at root");
			} else {
				boolean left = true;
				for (int i = 0; i < nextLevel() - 1; i++) {
	
					if ((((Math.pow(2, nextLevel() + 1 - i) - 1)) - (tempSize)) >= Math
							.pow(2, nextLevel() - i - 1)) {
						currentNode = currentNode.leftChild;
						left = true;
					//	System.out.println("moved left");
					} else {
						currentNode = currentNode.rightChild;
						left = false;
					//	System.out.println("moved right");
					}
	
					if (left) {
						tempSize = (int) (tempSize - Math.pow(2, nextLevel() - i
								- 1));
					} else {
						tempSize = (int) (tempSize - Math.pow(2, nextLevel() - i));
					}
				}
	
				if (currentNode.leftChild == null) {
					currentNode.leftChild = new Node(array, currentNode);
					//System.out.println(currentNode.leftChild.value
					//		+ " added to left. parent is " + currentNode.value);
					shiftUp(currentNode.leftChild, "add");
	
				} else if (currentNode.leftChild != null
						&& currentNode.rightChild == null) {
					currentNode.rightChild = new Node(array, currentNode);
	//
				//	System.out.println(currentNode.rightChild.value
					//		+ " added to right. parent is " + currentNode.value);
					shiftUp(currentNode.rightChild, "add");
	
				}
	
			}
			heapSize++;
		}			
			
/*
* below are the array methods of the heap.
*/
//

	// method to get the node from the array
	public void fromArray(Comparable[] internalArray) {
		Comparable[] indexArray = internalArray;
		for (int i = 0; i < indexArray.length; i++) {
			maxHeapify(indexArray);
		}

	}	
			
			
	// method to build the max heap taking in internalArray,
	//sorts array and swaps values greater than size of heap
	public Comparable[] buildMaxHeap(Comparable[] internalArray) {
		Comparable[] sortedArray = (T[]) java.lang.reflect.Array.newInstance(internalArray
				.getClass().getComponentType(), heapSize);
		sortedArray = toArray(internalArray);
		
		if(heapSize == 1){
			return sortedArray;
		}
		for (int i = 0; i < (heapSize)  ; i++) {
			swap(sortedArray, 0, sortedArray.length - 1 - i);
			sorter(sortedArray, i + 1);
		}
		swap(sortedArray, 0, 1);

		return sortedArray;
	}
	
	//-----------------------------------
	// method to swap values
	private void swap(Comparable[] internalArray, int i1, int i2) {
		Comparable[] indexArray = internalArray;
		Comparable temp = indexArray[i1];
		indexArray[i1] = indexArray[i2];
		indexArray[i2] = temp;
	}
	
	
	//-----------------------------------
	
	// method create sorted array in internalArray
	private void sorter(Comparable[] internalArray, int counter) {
		int pointer = 0;
		int left;
		int right;
		
		for (int i = 0; i < (Math.floor(Math.log(heapSize - counter) / Math.log(2))); i++) {
			left = 2 * pointer + 1;
			right = 2 * pointer + 2;
			if (left >= internalArray.length - counter) {
				return;
			}
			if ((right >= internalArray.length - counter) && (left < internalArray.length - counter)) {
				if (internalArray[pointer].compareTo(internalArray[left]) > 0) {
					swap(internalArray, pointer, left);
					pointer = left;
				}
	
			}
	
			if (left < internalArray.length - counter && right < internalArray.length - counter) {
				if(internalArray[right].compareTo(internalArray[left]) > 0){
					if(internalArray[pointer].compareTo(internalArray[right]) < 0){
						swap(internalArray, pointer, right);
						pointer = right;
					}
				} else{
					if(internalArray[pointer].compareTo(internalArray[left]) < 0 ){
						swap(internalArray, pointer, left);
						pointer = left;
					}
				}
			}
		}
	}
	
	//-----------------------------------
	
	
	
	// method to get left and right values to new array from internalArray
	public Comparable[] toArray(Comparable[] internalArray) {
		int counter = 0;
		Node tempNode;
		Comparable[] valueArray = (T[]) java.lang.reflect.Array.newInstance(internalArray
				.getClass().getComponentType(), heapSize);
		ArrayList<BinaryHeapA<T>.Node> queue = new ArrayList<Node>();
		queue.add(root);

		while (!queue.isEmpty()) {
			tempNode = (Node) queue.remove(0);
			valueArray[counter] = tempNode.value;
			if (tempNode.leftChild != null) {
				queue.add(tempNode.leftChild);
			}
			if (tempNode.rightChild != null) {
				queue.add(tempNode.rightChild);
			}
			counter++;
		}

		return valueArray;
	}
	
	
	
	
 
	//method to shift node value up tree
	private void shiftUp(Node node, String string) {
		Node n = node;
		if (n.parent == null) {
			return;
		}

		for (int i = 0; i < nextLevel(); i++) {

			if (n.value.compareTo(n.parent.value) > 0) {
				swap(n, n.parent);
				n = n.parent;
			} else {
				break;
			}
		}

	}
// method to shift value of node down tree
	private void shiftDown(Node node) {
		Node n = node;
		for (int i = 0; i < level(); i++) {

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
	// method to swap values of two nodes
private void swap(Node node1, Node node2) {
		
//		System.out.println(node1.value + " is swapped with " + node2.value);
		Comparable temp = node1.value;
		node1.value = node2.value;
		node2.value = temp;
	}
// method that returns value of current level
private int level() {
	int level = (int) Math.floor(((double) Math.log(heapSize) / (double) Math
			.log(2)));
	return level;
}

// method that returns value of next level
private int nextLevel() {
	int level = (int) Math
			.floor(((double) Math.log(heapSize + 1) / (double) Math.log(2)));
	return level;
}

// class to represent nodes for right child, left child, and parent
private class Node {

	protected Comparable value;
	protected Node rightChild;
	protected Node leftChild;
	protected Node parent;

	// returns value within the parent node
	Node(Comparable indexArray, Node parent) {

		value = indexArray;
		this.parent = parent;
	}
	
	public Node(Comparable[] indexArray, BinaryHeapA<T>.Node currentNode) {
		// compares two nodes
	}
}
// method to remove value
public Comparable remove() {
	Comparable removedValue = root.value;

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
	for (int i = 0; i < level(); i++) {

		if ((((Math.pow(2, level() + 1 - i) - 1)) - (tempSize)) >= Math
				.pow(2, level() - i - 1)) {

			currentNode = currentNode.leftChild;

			left = true;
		//	System.out.println("moved left");
		} else {

			currentNode = currentNode.rightChild;
			left = false;
		//System.out.println("moved right");
		}

		if (left) {
			tempSize = (int) (tempSize - Math.pow(2, level() - i - 1));
		} else {
			tempSize = (int) (tempSize - Math.pow(2, level() - i));
		}

	}
	root.value = currentNode.value;
	if (left && heapSize > 1) {
		currentNode.parent.leftChild = null;
	} else if (!left && heapSize > 2) {
		currentNode.parent.rightChild = null;
	}
//	System.out.println("root is now " + root.value);
	shiftDown(root);

	if (heapSize > 0) {

		heapSize--;
	}

	return removedValue;
}

// method that returns value of root
	public Comparable peek(){
		return root.value;
	}

	// method that adds a new value to the internalArray
	public void add(Comparable newValue) {
		lastIndex++;
	
		if (lastIndex >= internalArray.length)
			doubleArray(); // expand array
	
		int newIndex = lastIndex;
		int parentIndex = newIndex/2;
		while ( (newIndex > 1) && newValue.compareTo(internalArray[parentIndex]) > 0) {
			internalArray[newIndex] = internalArray[parentIndex];
		newIndex = parentIndex;
			parentIndex = newIndex/2; 
		}
	
		internalArray[newIndex] = newValue;
	}

	// method to expand the array
	  private void doubleArray() { 
	      Comparable[] tempArray = new Comparable[internalArray.length * 2]; 
	      for(int k = 0; k < heapSize; k++) 
	         tempArray[k] = internalArray[k]; 
	      internalArray = tempArray; 
	   } 





}
			

	
		  
		  
		  
		  
	
	        
	        
	        
	   
	


