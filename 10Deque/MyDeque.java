import java.util.*;

public class MyDeque<E>{

    private E[] data;
    private int start;
    private int end;
    private int len;
    
    @SuppressWarnings("unchecked")
    public MyDeque(){
	data = (E[])new Object[10];
	start = 0;
	end = 0;
	len = 0;
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
	if (initialCapacity < 0){
	    throw new IllegalArgumentException();
	}
	data = (E[])new Object[initialCapacity];
	start = 0;
	end = 0;
	len = 0;
    }

    @SuppressWarnings("unchecked")
    private void resize(){
	E[] d = (E[])new Object[data.length * 2 + 1];
	for (int temp = 0; temp < data.length; temp++){
	    d[temp] = data[(start + temp) % data.length];
	}
	this.start = d.length - 1;
	this.end = data.length;
	this.data = d;
    }

    public int size(){
	return len;
    }

    public void addFirst(E element){
	if (element == null){
	    throw new NullPointerException();
	}
	if (data[start] == null){
	    data[start] = element;
	    start = (start - 1) % data.length;
	    len++;
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
	    end = (end + 1) % data.length;
	    len++;
	    return;
	}
	resize();
	addLast(element);
    }

    public E removeFirst(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	E temp = data[(start + 1) % data.length];
	data[(start + 1) % data.length] = null;
	start = (start + 1) % data.length;
	len--;
	return temp;
    }

    public E removeLast(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	E temp = data[(end - 1) % data.length];
	data[(end - 1) % data.length] = null;
	end = (end - 1) % data.length;
	len--;
	return temp;
    }

    public E getFirst(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	return data[(start + 1) % data.length];
    }

    public E getLast(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	return data[(end - 1) % data.length];
    }

    public String toString(){
	String str = "";
	for (int x = 0; x < size(); x++){
	    str += data[(start + 1 + x) % data.length] + " ";
	}
	return str;
    }

    public static void main(String[] args){
	MyDeque<Integer> e = new MyDeque<Integer>();
	System.out.println(e.size());
	for (int x = 0; x < 11; x++){
	    e.addLast(new Integer(x));
	}
	System.out.println(e.size());
	System.out.println(e);
    }
    
}
