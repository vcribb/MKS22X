public class MyLinkedListImproved<T>{

    private class Node{

	Node next, prev;
	T data;

	private Node(Node n, Node p, T d){
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

	private T getValue(){
	    return data;
	}

	private void setValue(T d){
	    data = d;
	}

	public String toString(){
	    return data+"";
	}

    }

    Node first, last;
    int length;

    public MyLinkedListImproved(){
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

    public T get(int index){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException(":(");
	}
	Node n = first;
	for (int x = 0; x < index; x++){
	    n = n.getNext();
	}
	return n.getValue();
    }

    public T set(int index, T value){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException(":(");
	}
	Node n = first;
	for (int x = 0; x < index; x++){
	    n = n.getNext();
	}
	T ans = n.getValue();
	n.setValue(value);
	return ans;
    }

    public int size(){
	return length;
    }

    public int indexOf(T value){
	Node n = first;
	for (int x = 0; x < size(); x++){
	    if (n.getValue() == value){
		return x;
	    }
	    n = n.getNext();
	}
	return -1;
    }

    public boolean add(T value){
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

    public void add(int index, T value){
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

    public boolean remove(T value){
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

    public T remove(int index){
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

    public static void main(String[]args){
	MyLinkedListImproved<String> n = new MyLinkedListImproved<>();
        n.add("fish");
	System.out.println(n);
	MyLinkedListImproved<Integer> m = new MyLinkedListImproved<>();
        m.add(new Integer(0));
	System.out.println(m);
    }

}
