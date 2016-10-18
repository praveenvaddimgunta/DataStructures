public class DoubleList<E> 
{
	private Node start;
	private Node end;
	private int size;

	DoubleList() 
	{
		start = null;
		end = null;
		size = 0;
	}

	public void insert(E element) 
	{
		Node n = new Node(element);
		if(size == 0) {
			start = n;
			end = start;
		} 
		else 
		{
			end.setNext(n);
			n.setPrevious(end);
			end = n;
		}
		size++;
	}

	public void insertAfter(E element, E value) 
	{
		if(end.getData().equals(element)) 
		{
			pushBack(value);
		} 
		else 
		{
			Node n = new Node(value);
			Node temp = start;
			for(int i = 0; i < size; i++) {
				if(temp.getData().equals(element)) {
					Node temp1 = temp.getNext();
					temp.setNext(n);
					n.setPrevious(temp);
					n.setNext(temp1);
					temp.setPrevious(n);
					size++;
					break;
				}
				temp = temp.getNext();
			}
		}
	}

	public void insertBefore(E element, E value) {
		if(start.getData().equals(element)) {
			pushFront(value);
		} else {
			Node n = new Node(value);
			Node temp = start;
			for(int i = 0; i < size; i++) {
				if(temp.getData().equals(element)) {
					Node temp1 = temp.getPrevious();
					temp1.setNext(n);
					n.setPrevious(temp1);
					n.setNext(temp);
					size++;
					break;
				}
				temp = temp.getNext();
			}
		}
	}

	public void pushFront(E element) {
		Node n = new Node(element);
		start.setPrevious(n);
		n.setNext(start);
		start = n;
		size++;
	}

	public void pushBack(E element) {
		Node n = new Node(element);
		end.setNext(n);
		n.setPrevious(end);
		end = n;
		size++;
	}

	public void popFront() {
		start = start.getNext();
		start.setPrevious(null);
		size--;
	}

	public void popBack() {
		end = end.getPrevious();
		end.setNext(null);
		size--;
	}

	public void removeElement(E element) {
		Node temp = start;
		if(start.getData().equals(element)){
			popFront();
			System.exit(0);
		} 
		if(end.getData().equals(element)) {
			popBack();
			System.exit(0);
		}
		Node temp1=null;
		for(int i = 0; i < size; i++) {
			if(temp.getData().equals(element)) {
				temp1 = temp;
				if(temp==start) {
					start=start.getNext();
					temp.setNext(null);
				}
				else if(temp.getNext()==null) {
					temp.getPrevious().setNext(null);
				}
				else {
					temp.getNext().setPrevious(temp.getPrevious());
					temp.getPrevious().setNext(temp.getNext());}//Node temp2 = temp.getNext();
					temp.setNext(temp1);
					size--;
				}
			temp = temp.getNext();
		}
	}

	public void removeIndex(int index) {
		Node temp = start;
		if(start == null) {
			System.out.println("empty list!");
			return;
		}
		for(int i=0; i<index; i++) 
			temp = temp.getNext();
			
			if(temp==start) {
				start=start.getNext();
				temp.setNext(null);
			}
			else if(temp.getNext()==null) {
				temp.getPrevious().setNext(null);
			}
			else {
				temp.getNext().setPrevious(temp.getPrevious());
				temp.getPrevious().setNext(temp.getNext());
			}
	}
	public void concat(DoubleList<E> obj1 , DoubleList<E> obj2) {
		Node end1 = obj1.end;
		Node start2 = obj2.start;
		end1.setNext(obj2.start);
		start2.setPrevious(end1);
		end1 = obj2.end;
	}

	public void print() {
		Node temp = start;
		for(int i = 0; temp!=null; i++) {
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}
		System.out.println();
	}
}