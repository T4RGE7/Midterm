/**
 * 
 * @author James Roberts jpr242
 *
 */
public interface DoublyLinkedListLog<T> {

	void insertAtEnd(T data);
	void insertAtStart(T data);
	void insertBetween(T data);
	void remove(T data) throws EmptyListException;
	boolean contains(T data);
	boolean isEmpty();
	String toString();
	void clear();
	
}
