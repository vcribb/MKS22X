public class MyHeap <T extends Comparable<T>>{

    private T[] data;
    private int len;
    private boolean max;
    
    @SuppressWarnings("unchecked")
    public MyHeap(){
	max = true;
	data = (T[])new Comparable[10];
	len = 0;
    }

    @SuppressWarnings("unchecked")
    public MyHeap(boolean m){
	if (m){
	    max = true;
	}
	else{
	    max = false;
	}
	data = (T[])new Comparable[10];
	len = 0;
    }

    @SuppressWarnings("unchecked")
    public void resize(){
	T[] d = (T[])new Comparable[size() * 2 + 1];
	for (int x = 0; x < size(); x++){
	    d[x] = data[x];
	}
	data = d;
    }

    public void add(T s){
	if (size() == data.length){
	    resize();
	}
	data[size()] = s;
	shiftup(size());
	len++;
    }

    public void shiftup(int pos){
	if ((max && data[pos].compareTo(data[(int)((pos - 1) / 2)]) > 0) ||
	    (!max && data[pos].compareTo(data[(int)((pos - 1) / 2)]) < 0)){
	    T temp = data[pos];
	    data[pos] = data[(int)((pos - 1) / 2)];
	    data[(int)((pos - 1) / 2)] = temp;
	    shiftup((int)((pos - 1) / 2));
	}
    }

    public T remove(){
	T ans = data[0];
	T temp = data[size() - 1];
	data[size() - 1] = data[0];
	data[0] = temp;
	len--;
	shiftdown(0);
	return ans;
    }

    public void shiftdown(int pos){
	//for left side
	if ((max && (pos * 2 + 1) < size() && data[pos].compareTo(data[pos * 2 + 1]) < 0
	     && ((pos * 2 + 2) > size() - 1 || data[pos * 2 + 2].compareTo(data[pos * 2 + 1]) <= 0)) ||
	    (!max && (pos * 2 + 1) < size() && data[pos].compareTo(data[pos * 2 + 1]) > 0
	     && ((pos * 2 + 2) > size() - 1 || data[pos * 2 + 2].compareTo(data[pos * 2 + 1]) >= 0))){
	    T temp = data[pos];
	    data[pos] = data[pos * 2 + 1];
	    data[pos * 2 + 1] = temp;
	}
	//for right side
	else{
	    if ((max && (pos * 2 + 2) < size() && data[pos].compareTo(data[pos * 2 + 2]) < 0
		 && data[pos * 2 + 1].compareTo(data[pos * 2 + 2]) <= 0) ||
		(!max && (pos * 2 + 2) < size() && data[pos].compareTo(data[pos * 2 + 2]) > 0
		 && data[pos * 2 + 1].compareTo(data[pos * 2 + 2]) >= 0)){
		T temp = data[pos];
		data[pos] = data[pos * 2 + 2];
		data[pos * 2 + 2] = temp;
	    }
	}
    }

    public T peek(){
	return data[0];
    }

    public int size(){
	return len;
    }

    public String toString(){
	String ans = "[";
	for (int x = 0; x < size(); x++){
	    ans += data[x] + ", ";
	}
	ans += "]";
	return ans;
    }

    public static void main(String[]args){
	MyHeap<Integer> a = new MyHeap<Integer>(true);
	MyHeap<Integer> b = new MyHeap<Integer>(false);
	for (int i = 10; i > 0; i--){
	    a.add(i);
	    b.add(i);
	}
	for (int x = 0; x < 7; x++){
	    a.remove();
	    b.remove();
	}
	System.out.println(a);
	System.out.println(b);
	System.out.println(a.peek() + " " + a.size());
	System.out.println(b.peek() + " " + b.size());
    }

}
