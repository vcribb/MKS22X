import java.util.*;

public class MyDeque<E>{

    private E[] data;
    private int start;
    private int end;
    
    @SuppressWarnings("unchecked")
    public MyDeque(){
	data = (E[])new Object[10];
	start = 0;
	end = 0;
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
	if (initialCapacity < 0){
	    throw new IllegalArgumentException();
	}
	data = (E[])new Object[initialCapacity];
	start = 0;
	end = 0;
    }

    @SuppressWarnings("unchecked")
    private void resize(){
	E[] d = (E[])new Object[size() * 2 + 1];
	for (int temp = 0; temp < size(); temp++){
	    d[temp] = (this.getFirst());
	    this.removeFirst();
	}
	this.start = d.length - 1;
	this.end = size();
	this.data = d;
    }

    public int size(){
	return data.length;
    }

    public void addFirst(E element){
	if (element == null){
	    throw new NullPointerException();
	}
	if (data[start] == null){
	    data[start] = element;
	    start = (start - 1) % size();
	    return;
	}
	resize();
	addFirst(element);
    }

    public void addLast(E element){
	if (element == null){
	    throw new NullPointerException();
	}
	if (data[end] == null){
	    data[end] = element;
	    end = (end + 1) % size();
	    return;
	}
	resize();
	addLast(element);
    }

    public E removeFirst(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	E temp = data[(start + 1) % size()];
	data[(start + 1) % size()] = null;
	start = (start + 1) % size();
	return temp;
    }

    public E removeLast(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	E temp = data[(end - 1) % size()];
	data[(end - 1) % size()] = null;
	end = (end - 1) % size();
	return temp;
    }

    public E getFirst(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	return data[(start + 1) % size()];
    }

    public E getLast(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	return data[(end - 1) % size()];
    }

    public static void main(String[] args){
	MyDeque<Integer> e = new MyDeque<Integer>();
	System.out.println(e.size());
	for (int x = 0; x < 11; x++){
	    e.addLast(x);
	}
	System.out.println(e.size());
	for (int x = 0; x < e.size(); x++){
	    System.out.println(e.getFirst());
	    e.removeFirst();
	}
    }
    
}
