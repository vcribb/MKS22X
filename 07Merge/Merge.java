import java.util.*;

public class Merge{

    public static void mergesort(int[]data){
	if (data.length < 2){
	    return;
	}
	int[] temp = new int[data.length];
	msort(data, temp, 0, data.length - 1);
	for (int x = 0; x < data.length; x++){
	    data[x] = temp[x];
	}
	System.out.println(Arrays.toString(data));
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
	int i = start;
	int j = mid + 1;
	int index = start;

	//adds elements of data into temp one by one
	while (index < end + 1){
	    if (j > end || data[i] < data[j]){
		temp[index] = data[i];
		i+=1;
		index+=1;
	    }
	    else{ if (i > mid){
		    temp[index] = data[j];
		    j+=1;
		    index+=1;
		}
		else{
		    temp[index] = data[j];
		    j+=1;
		    index+=1;
		}
	    }
	}
	
    }

}
