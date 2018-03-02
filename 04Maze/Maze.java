import java.util.*;
import java.io.*;

public class Maze{

    private char[][]maze;
    private boolean animate;

    public Maze(String filename) throws FileNotFoundException{
        File text = new File(filename);
        Scanner inf = new Scanner(text);
	int numrows = 0;
	String l = "";
        while(inf.hasNextLine()){
	    l += inf.nextLine();
	    numrows++;
	}
	maze = new char[numrows][l.length()/numrows];
	int r = 0;
	int c = 0;
        for (int index = 0; index < l.length(); index++){
	    if (c == (l.length()/numrows)){
		r++;
		c = 0;
	    }
	    maze[r][c] = l.charAt(index);
	    c++;
	}
	int scounter = 0;
	int ecounter = 0;
	for (int row = 0; row < r; row++){
	    for (int col = 0; col < c; col++){
		if (maze[row][col] == 'S'){
		    scounter++;
		}
		if (maze[row][col] == 'E'){
		    ecounter++;
		}
	    }
	}
	if (scounter != 1 || ecounter != 1){
	    throw new IllegalStateException("The maze is invalid");
	}
	animate = false;
    }
    
    private void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        System.out.println("\033[2J\033[1;1H");
    }

    public int solve(){
	for (int r = 0; r < maze.length; r++){
	    for (int c = 0; c < maze[0].length; c++){
		if (maze[r][c] == 'S'){
		    maze[r][c] = ' ';
		    return solve(r,c,0);
		}
	    }
	}
	return 0;
    }

    private int solve(int row, int col, int sum){
        if(animate){
            clearTerminal();
	    for (int r = 0; r < this.maze.length; r++){
		System.out.println(Arrays.toString(this.maze[r]));
	    }
            wait(40);
        }
	if (maze[row][col] == 'E'){
	    return sum;
	}
	maze[row][col] = '@';
	if ((col + 1) < maze[0].length && maze[row][col + 1] == ' '){
	    //maze[row][col + 1] = '@';
	    return solve(row, col + 1, sum++);
	}
	if ((col - 1) > -1 && maze[row][col - 1] == ' '){
	    //maze[row][col - 1] = '@';
	    return solve(row, col - 1, sum++);
	}
	if ((row + 1) < maze.length && maze[row + 1][col] == ' '){
	    // maze[row + 1][col] = '@';
	    return solve(row + 1, col, sum++);
	}
	if ((row - 1) > -1 && maze[row - 1][col] == ' '){
	    //maze[row - 1][col] = '@';
	    return solve(row - 1, col, sum++);
	}
	maze[row][col] = ' ';
        return -1;
    }

    public static void main (String[]args){
	try{
	    Maze a = new Maze("maze.txt");
	    for (int r = 0; r < a.maze.length; r++){
		System.out.println(Arrays.toString(a.maze[r]));
	    }
	    a.setAnimate(true);
	    a.solve();
	}
	catch (FileNotFoundException e){
	}
    }
}
