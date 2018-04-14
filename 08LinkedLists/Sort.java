public class Sort extends MyLinkedListImproved{

    public static void radixsort(MyLinkedListImproved<Integer> data){
	MyLinkedListImproved<Integer> pos = new MyLinkedListImproved<>();
	MyLinkedListImproved<Integer> neg = new MyLinkedListImproved<>();

	for (Integer x : data){
	    if (x > 0){
		pos.add(x);
	    }
	    else{
		neg.add(x);
	    }
	}

	radixpositive(pos);
	radixnegative(neg);
	neg.extend(pos);
	data.first = neg.first;
	data.last = neg.last;
    }

    private static void radixpositive(MyLinkedListImproved<Integer> data){

	//create bucket array
	@SuppressWarnings("unchecked")MyLinkedListImproved<Integer>[] digits = new MyLinkedListImproved[10];
	for (int x = 0; x < 10; x++){
	    digits[x] = new MyLinkedListImproved<Integer>();
	}

	//find maximum element
	int max = data.get(data.max());
	int log = log10(max);
        
	//loop through array and sort integers into buckets
	for (int counter = 0; counter < log; counter++){
	    for (Integer x : data){
		int digit = (x / ((int)java.lang.Math.pow(10, counter))) % 10;
		digits[digit].add(x);
	    }

	    //merge lists
	    data.clear();
	    data.add(0);
	    for (int x = 0; x < 10; x++){
		if (digits[x].size() != 0){
		    data.extend(digits[x]);
		}
	    }
	    data.remove(0);
	}
    }

    private static void radixnegative(MyLinkedListImproved<Integer> data){

	//create bucket array
	@SuppressWarnings("unchecked")MyLinkedListImproved<Integer>[] digits = new MyLinkedListImproved[10];
	for (int x = 0; x < 10; x++){
	    digits[x] = new MyLinkedListImproved<Integer>();
	}

	//find maximum element
	int max = -1 * data.get(data.min());
	int log = log10(max);
        
	//loop through array and sort integers into buckets
	for (int counter = 0; counter < log; counter++){
	    for (Integer x : data){
		int digit = (-1 * x / ((int)java.lang.Math.pow(10, counter))) % 10;
		digits[digit].add(x);
	    }

	    //merge lists
	    data.clear();
	    data.add(0);
	    for (int x = 9; x >= 0; x--){
		if (digits[x].size() != 0){
		    data.extend(digits[x]);
		}
	    }
	    data.remove(0);
	}
    }

    private static int log10(int x){
	int ans = 0;
	while (x > 0){
	    x /= 10;
	    ans++;
	}
	return ans;
    }

    public static void main(String[] args){
	MyLinkedListImproved<Integer> m = new MyLinkedListImproved<>();
	for (int x = 50; x >= -50; x-=2){
	    m.add(x);
	}
	radixsort(m);
	System.out.println(m.toString());
    }
    
}
