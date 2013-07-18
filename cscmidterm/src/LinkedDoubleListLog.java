/**
 * 
 * @author James Roberts jpr242
 *
 */
public class LinkedDoubleListLog<T extends Comparable<T>> implements DoublyLinkedListLog<T> {

	protected DoubleNode<T> head, tail, current;
	private int size;
	
	public LinkedDoubleListLog() {
		this.head = null;
		this.tail = null;
		this.current = null;
		this.size = 0;
	}
	
	public LinkedDoubleListLog(T data) {
		this.head = new DoubleNode<T>(data);
		this.tail = this.head;
		this.current = null;
		this.size = 1;
	}
	
//	//adds to front
//	public void insert(T data) {
//		DoubleNode<T> newNode = new DoubleNode<T>(data);
//		this.size++;
//		if(this.isEmpty()) {
//			this.head = newNode;
//			this.tail = this.head;
//			return;
//		}
//		newNode.setFrontPointer(this.head);
//		this.head.setBackPointer(newNode);
//		this.head = newNode;
//	}
	
	//adds to front
	public void insertFirst(T data) {
		DoubleNode<T> newNode = new DoubleNode<T>(data);
		this.size++;
		if(this.isEmpty()) {
			this.head = newNode;
			this.tail = this.head;
			return;
		}
		newNode.setFrontPointer(this.head);
		this.head.setBackPointer(newNode);
		this.head = newNode;
	}
	
	//adds to end
	public void insertLast(T data) {
		if(this.isEmpty()) {
			this.insertFirst(data);
			return;
		}
		this.size++;
		DoubleNode<T> newNode = new DoubleNode<T>(data);
		newNode.setBackPointer(this.tail);
		this.tail.setFrontPointer(newNode);
		this.tail = newNode;
	}
	
	//adds to location
	public void insert(T data, int location) {
		if(location > this.size || location < 0) {
			throw new IndexOutOfBoundsException();
		}
		if(location == 0) {
			this.insertFirst(data);
			return;
		}
		if(location == this.size) {
			this.insertLast(data);
			return;
		}
		DoubleNode<T> newNode = new DoubleNode<T>(data);
		this.moveCurrentClosest(location - 1);
		newNode.setFrontPointer(this.current.getFrontPointer());
		this.current.setFrontPointer(newNode);
		newNode.setBackPointer(this.current);
		((DoubleNode<T>)(newNode.getFrontPointer())).setBackPointer(newNode);
		this.size++;
	}
	
	//removes from front
	public T remove() throws EmptyListException{
		if(this.isEmpty()) {
			throw new EmptyListException();
		}
		T toReturn = this.head.getData();
		this.size--;
		if(this.head.getFrontPointer() == null) {
			this.head = null;
			this.tail = null;
			return toReturn;
		}
		this.head = (DoubleNode<T>)this.head.getFrontPointer();
		this.head.setBackPointer(null);
		return toReturn;
	}
	
	//removes from front
	public T removeFirst() throws EmptyListException {
		return this.remove();
	}
	
	//removes from back
	public T removeLast() throws EmptyListException {
		if(this.size == 1) {
			return this.remove();
		}
		T toReturn = this.tail.getData();
		this.tail = this.tail.getBackPointer();
		this.tail.setFrontPointer(null);
		this.size--;
		return toReturn;
	}
	
	//removes from location
	public T remove(int location) throws EmptyListException {
		if(this.isEmpty()) {
			throw new EmptyListException();
		}
		if(location >= this.size || location < 0) {
//			System.out.println(location);
			throw new IndexOutOfBoundsException();
		}
		if(location == 0) {
			return this.remove();
		}
		if(location == this.size - 1) {
			return this.removeLast();
		}
	//	System.out.println("Got here");
		this.moveCurrentClosest(location - 1);
		T toReturn = this.current.getFrontPointer().getData();
	//	System.out.println(toReturn);
		this.current.setFrontPointer(this.current.getFrontPointer().getFrontPointer());
		((DoubleNode<T>)(this.current.getFrontPointer())).setBackPointer(this.current);
		this.size--;
		return toReturn;
	}
	
	//peeks first
	public T peek() throws EmptyListException {
		if(this.isEmpty()) {
			throw new EmptyListException();
		}
		return this.head.getData();
	}
	
	//peeks first
	public T peekFirst() throws EmptyListException {
		return this.peek();
	}
	
	//peeks last
	public T peekLast() throws EmptyListException {
		if(this.isEmpty()) {
			throw new EmptyListException();
		}
		if(this.size == 1) {
			return this.peek();
		}
		return this.tail.getData();
	}
	
	//peeks at location
	public T peek(int location) throws EmptyListException {
		if(this.isEmpty()) {
			throw new EmptyListException();
		}
		if(location >= this.size || location < 0) {
			throw new IndexOutOfBoundsException();
		}
		if(location == 0) {
			return this.peek();
		}
		if(location == this.size - 1) {
			return this.peekLast();
		}
		this.moveCurrentClosest(location);
		return this.current.getData();
	}
	
	public void clear() {
		this.head = null;
		this.tail = null;
		this.current = null;
		this.size = 0;
	}
	
	public boolean isEmpty() {
		if(this.head == null) {
			return true;
		}
		return false;
	}
	
	public void moveCurrentClosest(int location) {
		if(location > this.size || location < 0) {
			throw new IndexOutOfBoundsException();
		}
		if(location < this.size/2) {
			this.moveCurrentForwards(location);
			return;
		}
		this.moveCurrentBackwards(location);
	}
	
	public void moveCurrentForwards(int location) {
//		System.out.println("Forwards");
		this.current = this.head;
		for(int j = 0; j < location && current.getFrontPointer() != null; j++, this.current = (DoubleNode<T>) this.current.getFrontPointer());
	}
	
	public void moveCurrentBackwards(int location) {
//		System.out.println("Backwards");
		this.current = this.tail;
		for(int j = this.size - 1; j > location && current.getBackPointer() != null; j--, this.current = this.current.getBackPointer());
	}

	@Override
	public void insertAtEnd(T data) {
		this.insertLast(data);
		
	}

	@Override
	public void insertAtStart(T data) {
		this.insertFirst(data);
		
	}

	@Override
	public void insertBetween(T data) {
		if(this.isEmpty()) {
			this.insertFirst(data);
		}
		this.current = this.head;
		int toInsert = 0;
		while(this.current != null && data.compareTo(this.current.getData()) > 0) {
			toInsert++;
			this.current = (DoubleNode<T>) this.current.getFrontPointer();
		}
		this.insert(data, toInsert);
	}

	@Override
	public void remove(T data) throws EmptyListException {
//		System.out.println("Removed " + data);
		if(this.isEmpty()) {
			throw new EmptyListException();
		}
		int toRemove = this.indexOf(data);
		if(toRemove < 0) {
			return;
		}
		this.remove(toRemove);
		return;		
	}

	@Override
	public boolean contains(T data) {
		if(this.indexOf(data) >= 0) {
			return true;
		}
		return false;
	}
	
	public int indexOf(T data) {
		this.current = this.head;
		int toReturn = 0;
		for(; this.current != null; this.current = (DoubleNode<T>) this.current.getFrontPointer(), toReturn++) {
			if(this.current.getData().equals(data)) {
//				System.out.println("Found " + data.toString() + " at " + toReturn);
				return toReturn;
			}
		}
		return -1;
	}
	
	public String toString() {
		if(this.isEmpty()) {
			return "";
		}
		String toReturn = "";
		this.current = this.head;
		while(this.current != null) {
			toReturn += this.current.getData().toString() + "\n";
			this.current = (DoubleNode<T>) this.current.getFrontPointer();
		}
		return toReturn;
	}
}
