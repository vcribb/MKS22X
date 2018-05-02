import java.util.*;

public class RunningMedian extends MyHeap{

    private MyHeap<Double> s;
    private MyHeap<Double> b;
    private int size;
    
    public RunningMedian(){
	s = new MyHeap<Double>(true);
	b = new MyHeap<Double>(false);
	size = 0;
    }
    
    public void add(double x){
	if (size() == 0 || x < b.peek()){
	    b.add(x);
	}
	else{
	    s.add(x);
	}
	if (b.size() - s.size() > 1){
	    double temp = b.remove();
	    s.add(temp);
	}
	if (s.size() - b.size() > 1){
	    double temp = s.remove();
	    b.add(temp);
	}
	size++;
    }

    public double getMedian(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	if (s.size() > b.size()){
	    return s.peek();
	}
	if (b.size() > s.size()){
	    return b.peek();
	}
	return (s.peek() + b.peek()) / 2.0;
    }

    public int size(){
	return size;
    }

    public static void main(String[]args){
	RunningMedian x = new RunningMedian();
	x.add(10);
	x.add(2);
	x.add(10);
	x.add(7);
	System.out.println(x.getMedian());
	
    }
    
}
