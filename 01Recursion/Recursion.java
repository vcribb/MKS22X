public class Recursion{
    public int fact(int n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	if (n == 0){
	    return 1;
	}
	return n * fact(n-1);
    }

    public int fib(int n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	if (n < 2){
	    return n;
	}
	return fibhelper(n, 1, 0, 1);
    }

    public int fibhelper(int n, int count, int x, int y){
	if (count == n){
	    return y;
	}
	int z = y;
	y+=x;
	x = z;
	count++;
	return fibhelper(n, count, x, y);
    }
	
    public double sqrt(double n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	if (n == 0){
	    return n;
	}
	double guess = n/2;
        return helper(n, guess);
    }

    public double helper(double n, double guess){
	if (((guess*guess)/n) < 1.00001 && ((guess*guess)/n) > 0.99999){
	    return guess;
	}
	return helper(n, (n/guess + guess)/2);
    }

    public static void main(String[]args){
	Recursion a = new Recursion();
	System.out.println(a.fib(0)); //0
	System.out.println(a.fib(1)); //1
	System.out.println(a.fib(2)); //1
	System.out.println(a.fib(4)); //3
	System.out.println(a.fib(6)); //8
	System.out.println(a.fib(10)); //55
	System.out.println(a.fib(-11)); //exception
    }
}
