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
	for (int temp = 0; temp < size(); temp++){
	    d[temp] = data[(start + temp) % data.length];
	}
	this.start = 0;
	this.end = size() - 1;
	this.data = d;
    }

    public int size(){
	return len;
    }

    public void addFirst(E element){
	if (element == null){
	    throw new NullPointerException();
	}
	if (size() == 0){
	    data[start] = element;
	    len++;
	    return;
	}
	if (data.length == size()){
	    resize();
	}
	start = (start + data.length - 1) % data.length;
	data[start] = element;
	len++;
    }

    public void addLast(E element){
	if (element == null){
	    throw new NullPointerException();
	}
	if (size() == 0){
	    data[end] = element;
	    len++;
	    return;
	}
	if (data.length == size()){
	    resize();
	}
	end = (end + 1) % data.length;
	data[end] = element;
	len++;
    }

    public E removeFirst(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	E temp = getFirst();
	start = (start + 1) % data.length;
	len--;
	return temp;
    }

    public E removeLast(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	E temp = getLast();
	end = (end - 1 + data.length) % data.length;
	len--;
	return temp;
    }

    public E getFirst(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	return data[start];
    }

    public E getLast(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	return data[end];
    }

    //Crystal's toString/main
    public String toString(){
	String ans = "[";
	if(start < end){
	    for (int i = start; i <= end; i++){
		ans += data[i] + " , ";
	    }
	}
	else{
	    for(int i = start; i < data.length; i++){
		ans += data[i] + ", ";
	    }
	    for(int i = 0; i <= end; i++){
		ans += data[i] + ", ";
	    }
	}
	ans = ans.substring(0, ans.length() - 2) + "]";
	return ans;
    }

    public static void main(String[] args) {
        MyDeque<String> a = new MyDeque<>(), a1 = new MyDeque<>();
	ArrayList<String> b = new ArrayList<>();

	int size = Integer.parseInt(args[0]);
	for(int i = 0; i < size; i++){
	    int temp = (int)(Math.random() * 1000);
	    if(temp % 2 == 0){
		a.addFirst("" + temp);
		a1.addFirst("" + temp);
		b.add(0, "" + temp);
	    }
	    else{
		a.addLast("" + temp);
		a1.addLast("" + temp);
		b.add("" + temp);
	    }
	}

	int index = 0;
	boolean hasError = false;
	String errorEvaluation = "Errors found at these indices: ";
	for (String x : b){
	    if (!(x.equals(a.getFirst()))){
		System.out.println("The getFirst() function is incorrect at index " + index);
		hasError = true;
	    }
	    if (!(x.equals(a.removeFirst()))){
		System.out.println("There is an error at index " + index);
		errorEvaluation += index + ", ";
		hasError = true;
	    }
	    index++;
	}


	if(hasError){
	    errorEvaluation = errorEvaluation.substring(0, errorEvaluation.length() - 2);
	    System.out.println(errorEvaluation);
	    System.out.println("MyDeque: " + a1);
	    System.out.println("Actual Deque: " + b);
	}
	else{
	    System.out.println("Your deque is bug-free!");
	}
    }
    
}
