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
	int r = 0;
	int c = 0;
	for (int row = 0; row < maze.length; row++){
	    for (int col = 0; col < maze[0].length; col++){
		if (maze[row][col] == 'S'){
		    maze[row][col] = ' ';
		    r = row;
		    c = col;
		}
	    }
	}
	return solve(r, c, 0);
    }

    private int solve(int row, int col, int sum){
        if(animate){
            clearTerminal();
	    System.out.println(this);
            wait(10);
        }
	if (maze[row][col] == 'E'){
	    return sum;
	}
	if (maze[row][col + 1] == ' ' || maze[row][col + 1] == 'E'){
	    maze[row][col] = '@';
	    int temp = solve(row, col + 1, sum + 1);
	    if (temp != -1){
		return temp;
	    }
	    maze[row][col] = '.';
	}
	if (maze[row][col - 1] == ' ' || maze[row][col - 1] == 'E'){
	    maze[row][col] = '@';
	    int temp = solve(row, col - 1, sum + 1);
	    if (temp != -1){
		return temp;
	    }
	    maze[row][col] = '.';
	}
	if (maze[row + 1][col] == ' ' || maze[row + 1][col] == 'E'){
	    maze[row][col] = '@';
	    int temp = solve(row + 1, col, sum + 1);
	    if (temp != -1){
		return temp;
	    }
	    maze[row][col] = '.';
	}
	if (maze[row - 1][col] == ' ' || maze[row - 1][col] == 'E'){
	    maze[row][col] = '@';
	    int temp = solve(row - 1, col, sum + 1);
	    if (temp != -1){
		return temp;
	    }
	    maze[row][col] = '.';
	}
	return -1;
    }

    public String toString() {
	String s = "";
	for (int x = 0; x < maze.length; x++) {
	    for (int y = 0; y < maze[x].length; y++) {
		s = s + maze[x][y];
	    }
	    s = s + "\n";
	}
	return s;
    }

    public static void main (String[]args){
	try{
	    Maze a = new Maze("maze.txt");
	    System.out.println(a);
	    a.setAnimate(true);
	    System.out.println(a.solve());
	}
	catch (FileNotFoundException e){
	}
    }
}
