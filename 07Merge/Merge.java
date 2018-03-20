public class Merge{

    public static void mergesort(int[]data){
	if (data.length < 2){
	    return;
	}
	int[] temp = new int[data.length];
	msort(data, temp, 0, data.length);
    }

    private static void msort(int[]data, int[]temp, int start, int end){
	if (start >= end){
	    return; //has finished dividing data
	}
	for (int x = start; x <= end; x++){
	    temp[x] = data[x];
	}
	int mid = (start + end) / 2;
	msort(temp, data, start, mid);
	msort(temp, data, mid + 1, end);
	merge(data, temp, start, mid, end);
    }

    private static void merge(int[]data, int[]temp, int start, int mid, int end){
	
	/*
	  ---
	 */
	
    }

}
