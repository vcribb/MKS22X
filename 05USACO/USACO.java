import java.util.*;
import java.io.*;

public class USACO{

    public static int bronze(String filename){
	try{
	    File text = new File(filename);
	    Scanner inf = new Scanner(text);
	    int R = inf.nextInt();
	    int C = inf.nextInt();
	    int E = inf.nextInt();
	    int N = inf.nextInt();
	    int[][] pasture = new int[R][C];
	}
	catch (FileNotFoundException e){
	}
	return 0;
    }

    public static int silver(String filename){
	try{
	    File text = new File(filename);
	    Scanner inf = new Scanner(text);
	    String l = "";
	    while(inf.hasNextLine()){
		l += inf.nextLine();
	    }
	    //make the char[][] array
	    //initialize int[][]s
	}
	catch (FileNotFoundException e){
	}
	return 0;
    }
}
