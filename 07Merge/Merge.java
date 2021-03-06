import java.util.*;

public class Merge{

    public static void mergesort(int[]data){
	if (data.length < 2){
	    return;
	}
	
	int[] temp = new int[data.length];
	for (int x = 0; x < data.length; x++){
	    temp[x] = data[x];
	}
	
	msort(data, temp, 0, data.length - 1);
    }

    private static void msort(int[]data, int[]temp, int start, int end){
	if (start >= end){
	    return;
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
        while (i <= mid && j <= end){
	    if (temp[i] < temp[j]){
		data[index] = temp[i];
		i++;
	    }
	    else{
		data[index] = temp[j];
		j++;
	    }
	    index++;
	}

	//edge cases
	while (i <= mid){
	    data[index] = temp[i];
	    index++;
	    i++;
	}

	while (j <= end){
	    data[index] = temp[j];
	    index++;
	    j++;
	}
    }

}
