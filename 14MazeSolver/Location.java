public class Location implements Comparable<Location>{
    private int x, y;
    private int startdist;
    private int priority;
    private Location previous;

    public Location(int _x, int _y, Location prev, int prior, int dist){
	x = _x;
	y = _y;
	previous = prev;
	startdist = dist;
	priority = prior;
    }

    public int getx(){
	return x;
    }

    public int gety(){
	return y;
    }

    public int getpriority(){
	return priority;
    }

    public Location getprev(){
	return previous;
    }

    public void setPrev(Location l){
	previous = l;
    }

    public int getdist(){
	return startdist;
    }

    public int compareTo(Location l){
	return getpriority() - l.getpriority();
    }

    public boolean equals(Location l){
	if (x == l.getx()){
	    return y == l.gety();
	}
	return false;
    }
}
