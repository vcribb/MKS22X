import java.util.*;

public class FrontierStack implements Frontier{

    private LinkedList<Location> locations;

    public FrontierStack(){
	locations = new LinkedList<Location>();
    }

    public Location next(){
	return locations.peek();
    }

    public void add(Location n){
	locations.push(n);
    }

    public boolean hasNext(){
	return locations.size() != 0;
    }

}
