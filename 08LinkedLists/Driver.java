public class Driver extends MyLinkedList{
    public static void main(String[]args){
	MyLinkedList thing = new MyLinkedList();
	for (int x = 0; x < 10; x++){
	    thing.add(x);
	}
	System.out.println(thing.toString());
	System.out.println(thing.size());
	thing.add(0,10);
	System.out.println(thing.toString());
	System.out.println(thing.toString());
    }
}
