import java.util.*;

public class MyLinkedListImproved<T extends Comparable<T>> implements Iterable<T>{

    private class Node{

	private Node next, prev;
	private T data;

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

    private class LLIterator implements Iterator<T>{

	Node n;

	public LLIterator(Node nxt){
	    n = nxt;
	}

	public boolean hasNext(){
	    return n != null;
	}

	public T next(){
	    if (hasNext()){
		T m = n.getValue();
		n = n.getNext();
		return m;
	    }
	    else{
		throw new NoSuchElementException();
	    }
	}

	public void remove(){
	    throw new UnsupportedOperationException();
	}
	
    }

    public Node first, last;
    private int length;

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

    public Iterator<T> iterator(){
	return new LLIterator(first);
    }

    public int max(){
	if (size() == 0){
	    return -1;
	}
	Node n = first;
	T value = first.getValue();
	int index = 0;
	int maxindex = 0;
	for (T x : this){
	    if (x.compareTo(value) > 0){
		value = x;
		maxindex = index;
	    }
	    index++;
	}
	return maxindex;
    }

    public int min(){
	if (size() == 0){
	    return -1;
	}
	Node n = first;
	T value = first.getValue();
	int index = 0;
	int minindex = 0;
	for (T x : this){
	    if (x.compareTo(value) < 0){
		value = x;
		minindex = index;
	    }
	    index++;
	}
	return minindex;
    }

    public void extend(MyLinkedListImproved<T> other){
	last.setNext(other.first);
	other.first.setPrev(last);
	last = other.last;
	other.clear();
    }

    public static void main(String[]args){
	MyLinkedListImproved<String> n = new MyLinkedListImproved<>();
        n.add("fish");
	System.out.println(n);
	MyLinkedListImproved<Integer> m = new MyLinkedListImproved<>();
	for (int x = 1; x < 10; x++){
	    m.add(10 - x);
	}
	MyLinkedListImproved<Integer> r = new MyLinkedListImproved<>();
	for (int x = 1; x < 10; x++){
	    r.add(x);
	}
	m.extend(r);
	System.out.println(m.toString());
	System.out.println(r.toString());
	System.out.println(m.min());
	System.out.println(m.max());
    }

}
