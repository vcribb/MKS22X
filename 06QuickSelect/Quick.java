import java.util.*;

public class Quick{

    public static void quicksort(int[] ary){
    }

    public static int quickselect(int[] ary, int k){
        return selecthelp(ary, k, 0, ary.length - 1);
    }

    public static int selecthelp(int[] ary, int k, int start, int end){
	//System.out.println(Arrays.toString(ary));
	int n = partition(ary, start, end);
	if (n == k - 1){
	    return ary[n];
	}
	if (n > k - 1){
	    return selecthelp(ary, k, start, n - 1);
	}
	return selecthelp(ary, k, n + 1, end);
    }

    public static int partition(int[] data, int start, int end){
	if (start == end){
	    return start;
	}
	int pivot = randGen(start, end);
        swap(data, start, pivot);
	int i = start + 1;
	int j = end;
	while (i <= j){
	    if (data[i] < data[start]){
		i++;
	    }
	    else{
		swap(data, i, j);
		j--;
	    }
	    //System.out.println(Arrays.toString(data));
	}
	//System.out.println(j);
	//System.out.println(start);
	swap(data, j, start);
	return j;
    }

    public static int randGen(int min, int max){
	int range = (max - min) + 1;     
	return (int)(Math.random() * range) + min;
    }

    public static void swap(int[] nums, int x, int y){
	int temp = nums[x];
	nums[x] = nums[y];
	nums[y] = temp;
    }

    public static void main(String[]args){
	int[] arr = {9, 14, 9, 2, 3, 4, 5, 4, 9, 1, 0};
	System.out.println(Arrays.toString(arr));
	for (int x = 1; x <= arr.length; x++){
	    System.out.println(quickselect(arr, x));
	}
    }

}
