import java.util.*;

public class Sort extends MyLinkedListImproved{

    public static void radixsort(MyLinkedListImproved<Integer> data){

	if (data.size() < 2){
	    return;
	}

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

	if (pos.size() > 0 && neg.size() > 0){
	    radixpositive(pos);
	    radixnegative(neg);
	    neg.extend(pos);
	    data.first = neg.first;
	    data.last = neg.last;
	    return;
	}

	if (pos.size() == 0){
	    radixnegative(data);
	    return;
	}

	if (neg.size() == 0){
	    radixpositive(data);
	    return;
	}
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

    public static void main(String[] args) {
	//-----------SORTING POSITIVES-----------
	System.out.println("TESTING ON POSITIVE INTEGERS ONLY:");
	MyLinkedListImproved<Integer> data = new MyLinkedListImproved<>();
	int[] correctData = new int[1000];

	//Create MyLinkedListImproved and array with random integers
	for(int i = 0; i < 1000; i++){
	    int temp = (int)(Math.random() * 1000);
	    data.add(temp);
	    correctData[i] = temp;
	}

	//Sorts data and times the sort
	long end,start = System.currentTimeMillis();
	radixsort(data);
	end = System.currentTimeMillis();

	//Sorts the array
	Arrays.sort(correctData);
	System.out.println("Sort completed in " + (end - start) + " seconds");

	//Checks if data is properly sorted
	boolean hasError = false;
	int index = 0;
	for(Integer x: data){
	    if(!(x.equals(correctData[index]))){
		System.out.println("THERE IS AN ERROR");
		System.out.println("Index of error: " + index);
		hasError = true;
	    }
	    index++;
	}

	if(!(hasError)){
	    System.out.println("Your LinkedList with all positive integers is properly sorted.");
	}
	else{
	    System.out.println(data);
	}
	System.out.println("\n");


	//-----------SORTING NEGATIVES-----------
	System.out.println("TESTING ON NEGATIVE INTEGERS ONLY:");
	data.clear();
	correctData = new int[1000];

	//Create MyLinkedListImproved and array with random integers
	for(int i = 0; i < 1000; i++){
	    int temp = (int)(Math.random() * 1000);
	    temp *= -1;
	    data.add(temp);
	    correctData[i] = temp;
	}

	//Sorts data and times the sort
	start = System.currentTimeMillis();
	radixsort(data);
	end = System.currentTimeMillis();

	//Sorts the array
	Arrays.sort(correctData);
	System.out.println("Sort completed in " + (end - start) + " seconds");

	//Checks if data is properly sorted
	hasError = false;
	index = 0;
	for(Integer x: data){
	    if(!(x.equals(correctData[index]))){
		System.out.println("THERE IS AN ERROR");
		System.out.println("Index of error: " + index);
		hasError = true;
	    }
	    index++;
	}

	if(!(hasError)){
	    System.out.println("Your LinkedList with all negative numbers is properly sorted.");
	}
	else{
	    System.out.println(data);
	}
	System.out.println("\n");


	//-----------SORTING POSITIVES AND NEGATIVES-----------
	System.out.println("TESTING ON POSITIVE AND NEGATIVE INTEGERS:");
	data.clear();
	correctData = new int[1000];

	//Create MyLinkedListImproved and array with random integers
	for(int i = 0; i < 1000; i++){
	    int temp = (int)(Math.random() * 1000);
	    if((int)(Math.random() * 1000) % 2 == 0){
		temp *= -1;
	    }
	    data.add(temp);
	    correctData[i] = temp;
	}

	//Sorts data and times the sort
	start = System.currentTimeMillis();
	radixsort(data);
	end = System.currentTimeMillis();

	//Sorts the array
	Arrays.sort(correctData);
	System.out.println("Sort completed in " + (end - start) + " seconds");

	//Checks if data is properly sorted
	hasError = false;
	index = 0;
	for(Integer x: data){
	    if(!(x.equals(correctData[index]))){
		System.out.println("THERE IS AN ERROR");
		System.out.println("Index of error: " + index);
		hasError = true;
	    }
	    index++;
	}

	if(!(hasError)){
	    System.out.println("Your LinkedList with positive and negative integers is properly sorted.");
	}
	else{
	    System.out.println(data);
	}
	System.out.println("\n");


	//-----------SORTING EMPTY LISTS-----------
	System.out.println("SORTING ON EMPTY LISTS");
	data.clear();
	correctData = new int[0];

	start = System.currentTimeMillis();
	radixsort(data);
	end = System.currentTimeMillis();

	//Sorts the array
	Arrays.sort(correctData);
	System.out.println("Sort completed in " + (end - start) + " seconds");

	//Checks if data is properly sorted
	hasError = false;
	index = 0;
	for(Integer x: data){
	    if(!(x.equals(correctData[index]))){
		System.out.println("THERE IS AN ERROR");
		System.out.println("Index of error: " + index);
		hasError = true;
	    }
	    index++;
	}

	if(!(hasError)){
	    System.out.println("Your empty LinkedList is properly sorted.");
	}
	else{
	    System.out.println(data);
	}
	System.out.println("\n");


	//-----------SORTING POSITIVE ONE-ELEMENT LISTS-----------
	System.out.println("SORTING POSITIVE ONE-ELEMENT LISTS");
	data.clear();
	correctData = new int[1];

	int temp = (int)(Math.random() * 1000);
	data.add(temp);
	correctData[0] = temp;

	start = System.currentTimeMillis();
	radixsort(data);
	end = System.currentTimeMillis();

	//Sorts the array
	Arrays.sort(correctData);
	System.out.println("Sort completed in " + (end - start) + " seconds");

	//Checks if data is properly sorted
	hasError = false;
	index = 0;
	for(Integer x: data){
	    if(!(x.equals(correctData[index]))){
		System.out.println("THERE IS AN ERROR");
		System.out.println("Index of error: " + index);
		hasError = true;
	    }
	    index++;
	}

	if(!(hasError)){
	    System.out.println("Your LinkedList with one positive element is properly sorted.");
	}
	else{
	    System.out.println(data);
	}
	System.out.println("\n");


	//-----------SORTING NEGATIVE ONE-ELEMENT LISTS-----------
	System.out.println("SORTING NEGATIVE ONE-ELEMENT LISTS");
	data.clear();
	correctData = new int[1];

	temp = (int)(Math.random() * 1000) * -1;
	data.add(temp);
	correctData[0] = temp;

	start = System.currentTimeMillis();
	radixsort(data);
	end = System.currentTimeMillis();

	//Sorts the array
	Arrays.sort(correctData);
	System.out.println("Sort completed in " + (end - start) + " seconds");

	//Checks if data is properly sorted
	hasError = false;
	index = 0;
	for(Integer x: data){
	    if(!(x.equals(correctData[index]))){
		System.out.println("THERE IS AN ERROR");
		System.out.println("Index of error: " + index);
		hasError = true;
	    }
	    index++;
	}

	if(!(hasError)){
	    System.out.println("Your LinkedList with one negative element is properly sorted.");
	}
	else{
	    System.out.println(data);
	}
  }
    
}
