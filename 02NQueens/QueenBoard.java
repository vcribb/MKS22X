public class QueenBoard{
    private int[][]board;

    public QueenBoard(int size){
	board = new int[size][size];
	for (int j = 1; j < size; j++){
	    for (int k = 1; k < size; k++){
		board[j][k] = 0;
	    }
	}
    }

    private boolean addQueen(int r, int c){
	if (board[r][c] == 0){
	    board[r][c] = -1;
	    for (int x = r; x < board.length; x++){
		board[x][c]++;
	    }
	    for (int x = c; x < board.length; x++){
		board[r][x]++;
	    }
	}
	return false;
    }

    private boolean removeQueen(int r, int c){
	return true;
    }

    //0 represents a queen, any other number is an empty square
    public String toString(){
	String output = "";
	for (int j = 1; j < board.length; j++){
	    for (int k = 1; k < board.length; k++){
		if (board[j][k] == -1){
		    output+="Q ";
		}
		else{output+="_ ";}
	    }
	    output+="\n";
	}
	return output;
    }

    public boolean solve(){
	return true;
    }

    public int countSolutions(){
	return 0;
    }
}
