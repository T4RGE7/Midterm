/**
 * 
 * @author James Roberts jpr242
 *
 */
import java.util.Scanner;


public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		LinkedDoubleListLog<String> test = new LinkedDoubleListLog<String>();
		
		int toTest = 4, start = 1, end = 20, middle = 10;
		
		System.out.println("Empty test1");
		System.out.println(test.isEmpty());
		
		for(int i = middle; i < end; i++) {
			if(i != toTest) {
				test.insertAtEnd(i + "");
			}
		}
		System.out.println("Empty test2");
		System.out.println(test.isEmpty());
		System.out.println("Contents 1");
		System.out.println(test.toString());
		
		for(int i = middle - 1; i >= start; i--) {
			if(i != toTest) {
				test.insertAtStart(i + "");
			}
		}
		System.out.println("Contents 2");
		System.out.println(test.toString());
		
		test.insertBetween(toTest + "");
		System.out.println("Contents 3");
		System.out.println(test.toString());
		test.insertBetween(toTest + "");
		
		System.out.println("Contents 4");
		System.out.println(test.toString());
		System.out.println("Contains test 1");
		System.out.println(test.contains("1"));
		System.out.println("Contains test 23");
		System.out.println(test.contains("23"));
		
		try{
			test.remove("1");
			test.remove("19");
			test.remove("9");
			test.removeFirst();
			test.removeLast();
			test.remove("bleh");
		} catch (EmptyListException e) {
			e.printStackTrace();
		}
		
		System.out.println("Contents 5");
		System.out.println(test.toString());
		
		test.clear();
		try{
			test.remove((Character)'1');
			
		} catch (EmptyListException e) {
			e.printStackTrace();
		}
		System.out.println("Last Print: \n" + test.toString());
		System.out.println("Empty test3");
		System.out.println(test.isEmpty());
		
		new Scanner(System.in).nextLine();
		
		LinkedDoubleListLog<Character> test2 = new LinkedDoubleListLog<Character>();
		System.out.println("Character test");
	
	//	int toTest = 4, start = 1, end = 20, middle = 10;
		toTest = 4; start = 1; end = 9; middle = 5;
		System.out.println("Empty test1");
		System.out.println(test2.isEmpty());
		
		for(int i = middle; i < end; i++) {
			if(i != toTest) {
				test2.insertAtEnd((char) (i  + 48));
			}
		}
		System.out.println("Empty test2");
		System.out.println(test2.isEmpty());
		System.out.println("Contents 1");
		System.out.println(test2.toString());
		
		for(int i = middle - 1; i >= start; i--) {
			if(i != toTest) {
				test2.insertAtStart((char) (i  + 48));
			}
		}
		System.out.println("Contents 2");
		System.out.println(test2.toString());
		
		System.out.println("Contains test 1");
		System.out.println(test2.contains((Character)'1'));
		System.out.println("Contains test *");
		System.out.println(test2.contains((Character)'*'));
		
		
		test2.insertBetween((char) (toTest  + 48));
		System.out.println("Contents 3");
		System.out.println(test2.toString());
		test2.insertBetween((char) (toTest  + 48));
		
		System.out.println("Contents 4");
		System.out.println(test2.toString());
		
		try{
			test2.remove((Character)'1');
			test2.remove((Character)'8');
			test2.remove((Character)'3');
			test2.removeFirst();
			test2.removeLast();
			test2.remove((Character)'-');;
		} catch (EmptyListException e) {
			e.printStackTrace();
		}
		
		System.out.println("Contents 5");
		System.out.println(test2.toString());
		
		test2.clear();
		System.out.println("Last Print: \n" + test2.toString());
		System.out.println("Empty test3");
		System.out.println(test2.isEmpty());
	}

}
