@SuppressWarnings("unchecked")
public class Node<E> 
{
	private E data;
	private Node previous;
	private Node next;
	Node () 
	{
		data = null;
		previous = null;
		previous = null;
	}
	Node (E data) 
	{
	this.data = data;
	previous = null;
	next = null;
	}
	public void setData (E data) 
	{
	this.data = data;
	}
	public void setPrevious (Node previous) 
	{
		this.previous = previous;
	}
	public void setNext(Node next) 
	{
	this.next = next;
	}
	public E getData() 
	{
	return data;
	}
	public Node getPrevious () 
	{
		return previous;
	}
	public Node getNext () 
	{
			return next;
	}
}