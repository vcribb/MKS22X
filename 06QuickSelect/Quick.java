import java.util.*;

public class Quick{

    public static void quicksort(int[] ary){
	sorthelp(ary, 0, ary.length - 1);
	//System.out.println(Arrays.toString(ary));
    }

    public static void sorthelp(int[] ary, int start, int end){
	if (start >= end){
	    return;
	}
	int[] n = partition(ary, start, end);
	sorthelp(ary, start, n[0] - 1);
	sorthelp(ary, n[1] + 1, end);
    }
    
    public static int quickselect(int[] ary, int k){
        return selecthelp(ary, k, 0, ary.length - 1);
    }

    public static int selecthelp(int[] ary, int k, int start, int end){
	int[] n = partition(ary, start, end);
	if (n[0] <= k - 1 && n[1] >= k - 1){
	    return ary[n[0]];
	}
	if (n[0] > k - 1){
	    return selecthelp(ary, k, start, n[0] - 1);
	}
	return selecthelp(ary, k, n[1] + 1, end);
    }

    public static int[] partition(int[] data, int start, int end){
	int pivot = randGen(start, end);
	//System.out.println(pivot);
	swap(data, start, pivot);
	int lt = start;
	int i = start + 1;
	int gt = end;
	while (i <= gt){
	    if (data[i] == data[lt]){
		i+=1;
	    }
	    else if (data[i] > data[lt]){
		swap(data, i, gt);
		gt-=1;
	    }
	    else{
		swap(data, i, lt);
		lt+=1;
		i+=1;
	    }
	    //System.out.println(Arrays.toString(data));
	}
	int[] ans = {lt, gt};
	return ans;
    }

    public static int randGen(int min, int max){
	int range = (max - min);     
	return (int)(Math.random() * range) + min;
    }

    public static void swap(int[] nums, int x, int y){
	int temp = nums[x];
	nums[x] = nums[y];
	nums[y] = temp;
    }

    public static void main(String[]args){
	int[] arr = {7989, 14, 14, 14, 14, 4, 14, 14, 4};
	//System.out.println(Arrays.toString(partition(arr, 0, arr.length - 1)));
	System.out.println(Arrays.toString(arr));
	for (int x = 1; x <= arr.length; x++){
	    System.out.println(quickselect(arr, x));
	}
	int[] ary = {0, 1, 2, 3, 2, 1, 2, 2, 2, 4, 1, 0, 4, 2};
	quicksort(ary);
	System.out.println(Arrays.toString(ary));
    }

}
