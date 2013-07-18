/**
 * 
 * @author James Roberts jpr242
 *
 */
public class DoubleNode<T extends Comparable<T>> extends Node<T> {

	protected DoubleNode<T> backPointer;
	
	public DoubleNode() {
		super();
		this.backPointer = null;
	}
	
	public DoubleNode(T data) {
		super(data);
		this.backPointer = null;
	}

	public DoubleNode<T> getBackPointer() {
		return backPointer;
	}

	public void setBackPointer(DoubleNode<T> backPointer) {
		this.backPointer = backPointer;
	}
	
}
