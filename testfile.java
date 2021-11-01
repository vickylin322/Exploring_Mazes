package project3;

public class testfile {

	public static void main(String[] args) {
		DoublyLinkedList<String> testlist=new DoublyLinkedList<>();
		DoublyLinkedList<Integer> testlist2=new DoublyLinkedList<>();
		testlist.add("cat");
		testlist.add("pig");
		testlist.add("bird");
		testlist.add("dog");
		testlist.remove(null);
		//System.out.println(testlist.remove("a"));
		testlist.remove("pig");
		System.out.println(testlist);
		//System.out.println(testlist.toStringback());
		//System.out.println("Empty: "+testlist.isEmpty());//false
//		//add test
//		System.out.println(testlist);
//		System.out.println("size: "+testlist.size());//3
//		System.out.println(testlist.add(null));//false
//		System.out.println("size: "+testlist.size());//3
//		//System.out.println(testlist.add("cat"));//true
//		System.out.println(testlist.get(0));//cat
//		testlist.add("bird",3);
//		System.out.println(testlist);
//		System.out.println("size: "+testlist.size());//4
//		testlist.add("bird",7);
//		System.out.println(testlist);
//		System.out.println("size: "+testlist.size());//3
		
		//clear() test
		//isEmpty() test
		//testlist.clear();
		//System.out.println(testlist);
		//System.out.println("size: "+testlist.size());//0
		//System.out.println("Empty: "+testlist.isEmpty());//true
		
		//contains(o)test
//		System.out.println(testlist.contains("cat"));//t
//		System.out.println(testlist.contains("dog"));//t
//		System.out.println(testlist.contains("pig"));//t
//		System.out.println(testlist.contains(null));//false
//		
		//test equals()
		//testlist2.add(null);
		//testlist2.add(2);
		//testlist2.add(3);
		//System.out.println(testlist2);
		//System.out.println(testlist.equals(testlist2));//t
		
		//test get(pos)
//		System.out.println(testlist.indexOf("cat"));//0
//		System.out.println(testlist.indexOf("dog"));//1
//		System.out.println(testlist.indexOf("pig"));//2
//		System.out.println(testlist.indexOf("fish"));//-1
//		System.out.println(testlist.indexOf(null));//-1
		
		// test remove(e)
		//System.out.println(testlist.remove("cat"));
		//System.out.println(testlist.size());//1
		//System.out.println(testlist.remove(3));
		
	

	}

}
