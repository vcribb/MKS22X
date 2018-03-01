import java.util.*;
import java.io.*;

public class Maze{

    private char[][]maze;
    private boolean animate;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)
      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then: 
      throw a FileNotFoundException or IllegalStateException
    */

    public Maze(String filename) throws FileNotFoundException{
        File text = new File(filename);
        Scanner inf = new Scanner(text);
	int r = 0;
        while(inf.hasNextLine()){
            String line = inf.nextLine();
            /*for (int c = 0; c < line.length(); c++){
		maze[r][c] = line.charAt(c);
	    }
	    r++;*/
	    System.out.println(line);
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
            System.out.println(this);
            wait(20);
        }
	if (maze[row][col] == 'E'){
	    return sum;
	}
        maze[row][col] = '@';
	if (maze[row][col + 1] == ' '){
	    return solve(row, col + 1, sum++);
	}
	if (maze[row][col - 1] == ' '){
	    return solve(row, col - 1, sum++);
	}
	if (maze[row + 1][col] == ' '){
	    return solve(row + 1, col, sum++);
	}
	if (maze[row - 1][col] == ' '){
	    return solve(row - 1, col, sum++);
	}
	maze[row][col] = ' ';
        return -1;
    }

    public static void main (String[]args){
	try{
	    Maze a = new Maze("maze.txt");
	    System.out.println(a);
	}
	catch (FileNotFoundException e){
	}
    }
}
