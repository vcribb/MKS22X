import java.util.*;
import java.io.*;

public class USACO{

    public static int bronze(String filename){
	try{
	    //extracts basic info from the file
	    File text = new File(filename);
	    Scanner inf = new Scanner(text);
	    int R = inf.nextInt();
	    int C = inf.nextInt();
	    int E = inf.nextInt();
	    int N = inf.nextInt();
	    
	    //initializes the pasture array
	    int[][] pasture = new int[R][C];
	    for (int row = 0; row < R; row++){
		for (int col = 0; col < C; col++){
		    pasture[row][col] = inf.nextInt();
		}
	    }
	    
	    //goes through stomp-digging instructions
	    for (int index = 0; index < N; index++){
		int R_s = inf.nextInt() - 1;
		int C_s = inf.nextInt() - 1;
		int D_s = inf.nextInt();
		for (int counter = 0; counter < D_s; counter++){

		    //finds maximum height in the 3x3 array
		    int maxheight = 0;
		    for (int row_inc = 0; row_inc < 3; row_inc++){
			for (int col_inc = 0; col_inc < 3; col_inc++){
			    if (pasture[R_s + row_inc][C_s + col_inc] > maxheight){
				maxheight = pasture[R_s + row_inc][C_s + col_inc];
			    }
			}
		    }

		    //stomps areas in the pasture with the maximum height
		    for (int row_inc = 0; row_inc < 3; row_inc++){
			for (int col_inc = 0; col_inc < 3; col_inc++){
			    if (pasture[R_s + row_inc][C_s + col_inc] == maxheight){
				pasture[R_s + row_inc][C_s + col_inc]--;
			    }
			}
		    }
		}
	    }

	    //finds the total depth
	    int depth = 0;
	    for (int row = 0; row < R; row++){
		for (int col = 0; col < C; col++){
		    if (E > pasture[row][col]){
			depth += E - pasture[row][col];
		    }
		}
	    }
	    return depth * 72 * 72; 
	}
	
	catch (FileNotFoundException e){
	    System.exit(1);
	}
	
	return 0;
    }

    public static String toString(int[][] arr){
	String array = "";
	for (int r = 0; r < arr.length; r++){
	    for (int c = 0; c < arr[0].length; c++){
		array += arr[r][c] + " ";
	    }
	    array += "\n";
	}
	return array;
    }

    public static int silver(String filename){
	try{
	    //extracts basic info from the file
	    File text = new File(filename);
	    Scanner inf = new Scanner(text);
	    int N = inf.nextInt();
	    int M = inf.nextInt();
	    int T = inf.nextInt();
	    inf.nextLine();

	    //initializes pasture array
	    char[][] pasture = new char[N][M];
	    for (int row = 0; row < N; row++){
		String l = inf.nextLine();
		for (int col = 0; col < M; col++){
		    pasture[row][col] = l.charAt(col);
		}
	    }

	    //more extraction
	    int R1 = inf.nextInt() - 1;
	    int C1 = inf.nextInt() - 1;
	    int R2 = inf.nextInt() - 1;
	    int C2 = inf.nextInt() - 1;

	    //create the two arrays
	    int[][] one = new int[N][M];
	    int[][] two = new int[N][M];
	    
	}
	
	catch (FileNotFoundException e){
	    System.exit(1);
	}
	
	return 0;
    }

    public static String toString(char[][] arr){
	String array = "";
	for (int r = 0; r < arr.length; r++){
	    for (int c = 0; c < arr[0].length; c++){
		array += arr[r][c] + " ";
	    }
	    array += "\n";
	}
	return array;
    }

    public static void main(String[] args) throws FileNotFoundException{
	System.out.println(bronze("lake.txt"));
    }
}
