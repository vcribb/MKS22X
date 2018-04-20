import java.util.*;
import java.io.*;

public class Calculator{
    
    public static double eval(String s){
	String[] list = s.split("\\s+");
	@SuppressWarnings("unchecked")
	LinkedList<String> stack = new LinkedList();
	for (int x = 0; x < list.length; x++){
	    try{
		double temp = Double.parseDouble(list[x]);
		stack.push(temp+"");
	    }
	    catch (NumberFormatException e){
		double b = Double.parseDouble(stack.pop());
		double a = Double.parseDouble(stack.pop());
		if (list[x].equals("+")){
		    stack.push(a + b + "");
		}
		if (list[x].equals("-")){
		    stack.push(a - b + "");
		}
		if (list[x].equals("*")){
		    stack.push(a * b + "");
		}
		if (list[x].equals("/")){
		    stack.push(a / b + "");
		}
		if (list[x].equals("%")){
		    stack.push(a % b + "");
		}
	    }
	}
	return Double.parseDouble(stack.pop());
    }
    
    public static void main(String[] args){
	System.out.println(eval("6 6 +"));
	System.out.println(eval("6 6 + 12 *"));
	System.out.println(eval("11 3 - 4 + 2.5 *"));
	System.out.println(eval("8 2 + 99 9 - * 2 +"));
    }

}
