public class DoublyLinkedList {
	public static void main(String[] args) 
	{
		DoubleList<Integer> list = new DoubleList<Integer>();
		list.insert(10);
		list.insert(20);
		list.insert(30);
		list.pushBack(5);
		list.print();
		list.popFront();
		list.print();
		list.pushFront(1);
		list.print();
		list.popBack();
		list.print();
		list.removeElement(20);
		list.print();
		list.removeIndex(1);
		list.print();		
	}
}