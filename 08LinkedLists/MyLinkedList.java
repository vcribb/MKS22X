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

    public MyLinkedList(Node f, Node l){
	first = f;
	last = l;
	int ans = 0;
	Node n = first;
	while (n != null){
	    ans++;
	    n = n.getNext();
	}
	length = ans;
    }

    public String toString(){
	String s = "[";
	Node n = first;
	for (int x = 0; x < size(); x++){
	    s += n.toString() + ", ";
	    n = n.getNext();
	}
	if (s.length() > 1){
	    s = s.substring(0, s.length() - 2);
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
	Node n = new Node(last, null, value);
	if (size() > 0){
	    last.setNext(n);
	}
	else{
	    first = n;
	}
	length++;
	last = n;
	return true;
    }

    public void add(int index, Integer value){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException(":(");
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
	try{
	    return remove(indexOf(value));
	}
	catch (IndexOutOfBoundsException e){
	    return false;
	}
    }

    public boolean remove(int index){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException(":(");
	}
	Node n = first;
	for (int x = 0; x < index; x++){
	    n = n.getNext();
	}
	Node m = n.getNext();
	Node k = n.getPrev();
	m.setPrev(k);
	k.setNext(m);
	length--;
	return true;
    }

    public static void main(String[] args){
	MyLinkedList list = new MyLinkedList();
	System.out.println(list.toString());
	System.out.println(list.size());
	list.add(4);
	list.add(10);
	System.out.println(list.toString());
	System.out.println(list.set(1, 11));
	System.out.println(list.toString());
	list.add(1, 13);
	System.out.println(list.toString());
	int y = 14;
	Integer x = new Integer(y);
	list.remove(x);
	System.out.println(list.toString());
    }

}
