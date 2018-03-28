public class MyLinkedList{

    private class Node{

	Node next, prev;
	int data;

	public Node(Node n, Node p, int d){
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

	public void setPrev(Node p){
	    prev = p;
	}

	public int getValue(){
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

    public MyLinkedList(Node f, Node l, int len){
	first = f;
	last = l;
	length = len;
    }

    public String toString(){
	String s = "[";
	Node n = first;
	for (int x = 0; x < size(); x++){
	    s += n.toString() + ", ";
	    n = n.getNext();
	}
	s += "]";
	return s;
    }

    public int get(int index){
	Node n = first;
	for (int x = 0; x < index; x++){
	    n = n.getNext();
	}
	return n.getValue();
    }

    public void set(int index, int value){
	Node n = first;
	for (int x = 0; x < index; x++){
	    n = n.getNext();
	}
	n.setValue(value);
    }

    public int size(){
	Node n = first;
	int ans = 0;
	while (n != null){
	    ans++;
	    n = n.getNext();
	}
	return ans;
    }

    public boolean add(int value){
	Node n = new Node(last, null, value);
	last.setNext(n);
	return true;
    }

    public static void main(String[] args){
	Node s = new Node(null, null, 4);
	Node l = new Node(s, null, 10);
	s.setNext(l);
	MyLinkedList list = new MyLinkedList(s, l, 10);
	System.out.println(list.toString());
    }

}
