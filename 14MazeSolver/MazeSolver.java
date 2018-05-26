public class MazeSolver{
    
    private Maze maze;
    private Frontier frontier;
    private boolean a;

    public MazeSolver(String mazeText){
	maze = new Maze(mazeText);
    }

    public boolean solve(){
	return solve(0);
    }

    public boolean solve(int mode){
	a = false;
	if (mode == 0){
	    frontier = new FrontierQueue();
	}
	if (mode == 1){
	    frontier = new FrontierStack();
	}
	if (mode == 2){
	    frontier = new FrontierPriorityQueue();
	}
	else{
	    frontier = new FrontierPriorityQueue();
	    maze.setA(true);
	}
	while (frontier.hasNext()){
	    System.out.println(maze.toStringColor());
	    Location next = frontier.next();
	    if (next.compareTo(maze.getStart()) != 0){
		maze.set(next.getx(), next.gety(), '.');
	    }
	    Location[] locs = maze.getNeighbors(next);
	    for (Location l : locs){
		if (l != null){
		    if (l.compareTo(maze.getEnd()) == 0){
			while (next.compareTo(maze.getStart()) != 0){
			    maze.set(next.getx(), next.gety(), '@');
			    next = next.getprev();
			}
			return true;
		    }
		    frontier.add(l);
		    maze.set(l.getx(), l.gety(), '?');
		}
	    }
	}
	return false;
    }

    public String toString(){
	return maze.toString();
    }

    public static void main(String[] args){
	MazeSolver thing = new MazeSolver("text.txt");
	System.out.println(thing.solve(0));
    }
}
