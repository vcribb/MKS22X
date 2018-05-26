public class MazeSolver{
    
    private Maze maze;
    private Frontier frontier;

    public MazeSolver(String mazeText){
	maze = new Maze(mazeText);
    }

    public boolean solve(){
	return solve(0);
    }

    public boolean solve(int mode){
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
	frontier.add(maze.getStart());
	while (frontier.hasNext()){
	    Location n = frontier.next();
	    if (!(n.equals(maze.getStart()))){
		maze.set(n.getx(), n.gety(), '.');
	    }
	    Location[] locs = maze.getNeighbors(n);
	    for (Location l : locs){
		if (l != null){
		    if (l.equals(maze.getEnd())){
			while (!(n.equals(maze.getStart()))){
			    maze.set(n.getx(), n.gety(), '@');
			    n = n.getprev();
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
	System.out.println(thing.solve(2));
    }
}
