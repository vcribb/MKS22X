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

    public void add(T s){
    }

    public T remove(){
	return data[0];
    }

    public T peek(){
	return data[0];
    }

    public int size(){
	return len;
    }

}
