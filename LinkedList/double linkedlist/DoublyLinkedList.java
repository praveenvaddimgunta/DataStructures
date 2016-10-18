public class DoublyLinkedList {
	public static void main(String[] args) 
	{
		DoubleList<Integer> list = new DoubleList<Integer>();
		list.insert(10);
		list.insert(20);
		list.insert(30);
		list.pushBack(5);
		list.print();
		// list.popFront();
		// list.print();
		// list.pushFront(1);
		// list.print();
		// list.popBack();
		// list.print();
		// list.removeElement(20);
		// list.print();
		// list.removeIndex(1);
		// list.print();	
		DoubleList<Integer> list1 = new DoubleList<Integer>();
		list1.insert(15);
		list1.insert(25);
		list1.insert(35);list1.insert(45);
		list1.print();
		list.concat(list, list1);
		list.print();
	}
}