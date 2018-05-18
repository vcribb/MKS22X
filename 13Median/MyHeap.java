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

    private void shiftup(int pos){
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

    private void shiftdown(int pos){
	int left = pos * 2 + 1;
	int right = pos * 2 + 2;
	//if left and right are both greater/less than pos
	if ((max && left < size() && right < size() && data[pos].compareTo(data[left]) < 0 &&
	     data[pos].compareTo(data[right]) < 0) ||
	    (!max && left < size() && right < size() && data[pos].compareTo(data[left]) > 0 &&
	     data[pos].compareTo(data[right]) > 0)){
	    if ((max && data[left].compareTo(data[right]) > 0) || (!max && data[left].compareTo(data[right]) < 0)){
		T temp = data[pos];
		data[pos] = data[left];
		data[left] = temp;
		shiftdown(left);
	    }
	    else{
		T temp = data[pos];
		data[pos] = data[right];
		data[right] = temp;
		shiftdown(right);
	    }
	}
        else{
	    //if just left is greater/less than pos
	    if ((max && left < size() && data[pos].compareTo(data[left]) < 0 &&
		 (right >= size() || data[pos].compareTo(data[right]) >= 0)) ||
		(!max && left < size() && data[pos].compareTo(data[left]) > 0 &&
		 (right >= size() || data[pos].compareTo(data[right]) <= 0))){
		T temp = data[pos];
		data[pos] = data[left];
		data[left] = temp;
		shiftdown(left);
	    }
	    else{
		//if just right is greater/less than pos
		if ((max && right < size() && data[pos].compareTo(data[right]) < 0 &&
		     data[pos].compareTo(data[left]) >= 0) ||
		    (!max && right < size() && data[pos].compareTo(data[right]) > 0 &&
		     data[pos].compareTo(data[left]) <= 0)){
		    T temp = data[pos];
		    data[pos] = data[right];
		    data[right] = temp;
		    shiftdown(right);
		}
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

    public static void main(String[] args){
	MyHeap<Double> s = new MyHeap<Double>();
	MyHeap<Double> b = new MyHeap<Double>(false);
	for (int x = 0; x < 10; x++){
	    s.add(x * 1.0);
	}
	for (int x = 10; x > 0; x--){
	    b.add(x * 1.0);
	}
	System.out.println(s);
	System.out.println(b);
    }

}
