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
	    return;
	}
	
	//copy data into temp
	for (int x = start; x <= end; x++){
	    temp[x] = data[x];
	}
	
	int mid = (start + end) / 2;

	//break down the array into halves and sort
	msort(temp, data, start, mid);
	msort(temp, data, mid + 1, end);
	
	//merge the two sorted halves
	merge(data, temp, start, mid, end);
    }

    private static void merge(int[]data, int[]temp, int start, int mid, int end){
	
	/*
	  takes data[start] through data[mid] and data[mid + 1] through data[end]
	  goes through each and compares values
	  [0, 4, 11, 99] and [9, 12, 124, 999]
	  [0,4,9,11,12,99,124,999]
	 */

	
	
    }

}
