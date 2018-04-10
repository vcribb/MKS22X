public class MyLinkedList{

    private class Node{

	Node next, prev;
	int data;

	private Node(Node n, Node p, int d){
	    next = n;
	    prev = p;
	    data = d;
	}

	private Node getNext(){
	    return next;
	}

	private Node getPrev(){
	    return prev;
	}

	private void setNext(Node n){
	    next = n;
	}

	private void setPrev(Node p){
	    prev = p;
	}

	private int getValue(){
	    return data;
	}

	private void setValue(int d){
	    data = d;
	}

	public String toString(){
	    return data+"";
	}

    }

    Node first, last;
    int length;

    public MyLinkedList(){
	first = null;
	last = null;
	length = 0;
    }

    public String toString(){
	String s = "[";
	Node n = first;
	while (n != null){
	    s += n;
	    if (n.getNext() != null){
		s += ", ";
	    }
	    n = n.getNext();
	}
	s += "]";
	return s;
    }

    public void clear(){
	first = null;
	last = null;
	length = 0;
    }

    public Integer get(int index){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException(":(");
	}
	Node n = first;
	for (int x = 0; x < index; x++){
	    n = n.getNext();
	}
	return n.getValue();
    }

    public Integer set(int index, Integer value){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException(":(");
	}
	Node n = first;
	for (int x = 0; x < index; x++){
	    n = n.getNext();
	}
	Integer ans = n.getValue();
	n.setValue(value);
	return ans;
    }

    public int size(){
	return length;
    }

    public int indexOf(Integer value){
	Node n = first;
	for (int x = 0; x < size(); x++){
	    if (n.getValue() == value){
		return x;
	    }
	    n = n.getNext();
	}
	return -1;
    }

    public boolean add(Integer value){
	Node n = new Node(null, null, value);
	if (size() > 0){
	    last.setNext(n);
	    n.setPrev(last);
	}
	else{
	    first = n;
	}
	length++;
	last = n;
	return true;
    }

    public void add(int index, Integer value){
	if (index < 0 || index > size()){
	    throw new IndexOutOfBoundsException(":(");
	}
	if (index == size()){
	    add(value);
	    return;
	}
	if (index == 0){
	    Node n = new Node(null, null, value);
	    first.setPrev(n);
	    n.setNext(first);
	    first = n;
	    length++;
	    return;
	}
	Node n = new Node(null, null, value);
	Node temp = first;
	for (int x = 0; x < index - 1; x++){
	    temp = temp.getNext();
	}
	Node temp2 = temp.getNext();
	temp.setNext(n);
	n.setPrev(temp);
	temp2.setPrev(n);
	n.setNext(temp2);
	length++;
    }

    public boolean remove(Integer value){
	Node n = first;
	while (n.getValue() != value){
	    n = n.getNext();
	}
	if (n == null){
	    return false;
	}
	if (n.getPrev() == null){
	    n.getNext().setPrev(null);
	    first = n.getNext();
	    length--;
	    return true;
	}
	if (n.getNext() == null){
	    n.getPrev().setNext(null);
	    last = n.getPrev();
	    length--;
	    return true;
	}
	Node m = n.getPrev();
	Node k = n.getNext();
	m.setNext(k);
	k.setPrev(m);
	length--;
	return true;
    }

    public int remove(int index){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException(":(");
	}
	Node n = first;
	for (int x = 0; x < index; x++){
	    n = n.getNext();
	}
	if (n.getPrev() == null){
	    n.getNext().setPrev(null);
	    first = n.getNext();
	    length--;
	    return n.getValue();
	}
	if (n.getNext() == null){
	    n.getPrev().setNext(null);
	    last = n.getPrev();
	    length--;
	    return n.getValue();
	}
	Node m = n.getNext();
	Node k = n.getPrev();
	m.setPrev(k);
	k.setNext(m);
	length--;
	return n.getValue();
    }

    public static void main(String[] args){
	MyLinkedList a = new MyLinkedList();

	System.out.println("Testing add(Integer value)");
	for (int i = 0; i < 10; i++){
	    a.add(new Integer(i));
	    System.out.println("size: " + a.size() + " LinkedList: " + a.toString());
	} //adds the integers from 0 to 9 inclusive and prints out the LinkedList

	System.out.println("\nTesting get(int index)");
	for (int i = 0; i < 10; i++){
	    System.out.println("index: " + i + " data: " + a.get(i));
	} //prints the integers from 0 to 9 inclusive

	System.out.println("\nTesting exception for get(int index)");
	try{
	    System.out.println(a.get(10));
	    System.out.println(a.size());
	}catch(IndexOutOfBoundsException e){
	    System.out.println("This size is out of bounds");
	} //prints "This size is out of bounds"
	try{
	    System.out.println(a.get(-1));
	}catch(IndexOutOfBoundsException e){
	    System.out.println("This size is out of bounds");
	} //prints "This size is out of bounds"

	for (int i = 0; i < 10; i++){
	    a.add(new Integer(i));
	}

	System.out.println("\nTesting indexOf(Integer value)");
	for (int i = 0; i < 10; i++){
	    System.out.println("Value: " + i + " Index: " + a.indexOf(i));
	} //prints 0 to 9 inclusive

	System.out.println("\nTesting remove(Integer value)");
	for(int i = 0; i < 10; i++){
	    a.remove(new Integer(i));
	    System.out.println(a);
	} //removes first half of the LinkedList

	System.out.println("\nTesting set(int index, Integer value)");
	for (int i = 0; i < 10; i++){
	    a.set(i, new Integer(i * 10));
	    System.out.println(a);
	} //sets the data of each node to 10 * index

	System.out.println("\nTesting exceptions for set(int index, Integer value)");
	try{
	    System.out.println(a.set(-1, new Integer(1)));
	}catch(IndexOutOfBoundsException e){
	    System.out.println("This size is out of bounds");
	} //prints "This size is out of bounds"
	try{
	    System.out.println(a.set(10, new Integer(1)));
	}catch(IndexOutOfBoundsException e){
	    System.out.println("This size is out of bounds");
	} //prints "This size is out of bounds"

	System.out.println("\nTesting add(int index, Integer value)");
	for (int i = 0; i < 9; i++){
	    a.add(i, new Integer(i * 3));
	    System.out.println("index added: " + i + " LinkedList: " + a.toString());
	} //adds multiples of 3 up to 24 to the LinkedList at the beginning
	a.add(19, new Integer(100)); //adds 100 to the LinkedList at the end
	System.out.println("index added: " + 19 + " LinkedList: " + a.toString());

	System.out.println("\nTesting exceptions for add(int index, Integer value)");
	try{
	    a.add(-1, new Integer(5));
	}catch(IndexOutOfBoundsException e){
	    System.out.println("This size is out of bounds");
	} //prints "This size is out of bounds"
	try{
	    a.add(21, new Integer(5));
	}catch(IndexOutOfBoundsException e){
	    System.out.println("This size is out of bounds");
	} //prints "This size is out of bounds"

	System.out.println("\nTesting remove(int index)");
	System.out.println("Original LinkedList: " + a.toString());
	System.out.println("data removed: " + a.remove(0) + " index removed: 0"); //removes 0
	System.out.println("LinkedList: " + a.toString());
	System.out.println(a.size());
	System.out.println("data removed: " + a.remove(a.size() - 1) + " index removed: 18"); //removes 100
	System.out.println("LinkedList: " + a.toString());
	System.out.println("data removed: " + a.remove(2) + " index removed: 2 "); //removes 9
	System.out.println("LinkedList: " + a.toString());

	System.out.println("\nTesting exceptions for remove(int index)");
	try{
	    System.out.println(a.remove(-1));
	}catch(IndexOutOfBoundsException e){
	    System.out.println("This size is out of bounds");
	} //prints "This size is out of bounds"
	try{
	    System.out.println(a.remove(17));
	}catch(IndexOutOfBoundsException e){
	    System.out.println("This size is out of bounds");
	} //prints "This size is out of bounds"

	System.out.println("\nTesting clear()");
	a.clear();
	System.out.println("LinkedList: " + a.toString()); //prints an empty LinkedList
    }

}
