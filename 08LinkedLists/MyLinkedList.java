public class MyLinkedList{

    private class Node{

	Node next, prev;
	int data;

	public Node(Node n, Node p, int d){
	    next = n;
	    prev = p;
	    data = d;
	}

	public Node getNext(){
	    return next;
	}

	public Node getPrev(){
	    return prev;
	}

	public void setNext(Node n){
	    next = n;
	}

	public void setPrev(Node p){
	    prev = p;
	}

	public int getValue(){
	    return data;
	}

	public void setValue(int d){
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
	return length;
    }

    public boolean add(int value){
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

    public static void main(String[] args){
	MyLinkedList list = new MyLinkedList();
	System.out.println(list.toString());
	list.add(4);
	list.add(10);
	System.out.println(list.toString());
    }

}
