import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TestSinglyLinkedList {

	LinkedList list = new LinkedList();
	SinglyLinkedList mylist = new SinglyLinkedList();

	void fillListsWithData() {
		mylist.add("A");
		mylist.add("B");
		mylist.add("C");
		list.add("A");
		list.add("B");
		list.add("C");
	}

	@Test
	@DisplayName("[5] Test if your basic constructor works correctly")
	public void testConstructor() {
		mylist = new SinglyLinkedList();
		assertEquals(0, mylist.size());
		assertNull(mylist.getHead());
	}
	
	@Test
	@DisplayName("[5] Test if your constructor from array works correctly")
	public void testConstructor2() {
		String[] arr = {"A", "B", "C"};
		mylist = new SinglyLinkedList(arr);
		

		int i = 0;
		for (ListNode node = mylist.getHead(); node != null; node = node.getNext()) {
			
			assertEquals(arr[i], node.getValue());
			i++;
		}
		assertEquals(i, arr.length);
	}
	
	@Test
	@DisplayName("[5] Test if your add method works correctly")
	public void testAdd() {
		fillListsWithData();

		int i = 0;
		for (ListNode node = mylist.getHead(); node != null; node = node.getNext()) {
			
			assertEquals(list.get(i), node.getValue());
			i++;
		}
		assertEquals(i, list.size());
	}
	
	@Test
	@DisplayName("[5] Test if your get method works correctly")
	public void testGet() {
		fillListsWithData();

		for (int i = 0; i < list.size(); i++) {
			assertNotNull(mylist.get(i));		
			assertEquals(list.get(i), mylist.get(i));
		}
	}


	@Test
	@DisplayName("[5] Test if your size method works correctly")
	public void testSize() {
		fillListsWithData();

		assertEquals(list.size(), mylist.size());
	}

	@Test
	@DisplayName("[5] Test if your toString method works correctly")
	public void testToString() {
		fillListsWithData();

		assertEquals(list.toString(), mylist.toString());
	}


	@Test
	@DisplayName("[5] Test if your isEmpty() works correctly")
	public void testIsEmpty() {
		assertTrue(mylist.isEmpty());

		mylist.add("X");

		assertFalse(mylist.isEmpty());
	}

	@Test
	@DisplayName("[5] Test if your set() works correctly")
	public void testSet() {
		fillListsWithData();
		assertEquals(list.set(1, "Z"), mylist.set(1, "Z"));
		
		int i = 0;
		for (ListNode node = mylist.getHead(); node != null; node = node.getNext()) {
			
			assertEquals(list.get(i), node.getValue());
			i++;
		}
		assertEquals(i, list.size());
		

	}


	@Test
	@DisplayName("[5] Test if your get() throws the correct exception")
	public void testException() {
		fillListsWithData();

		assertThrows(IndexOutOfBoundsException.class, () -> mylist.get(4));
	}



	@Test
	@DisplayName("[5] Test if your add() works for null")
	public void testAddNull() {
		list = new LinkedList();
		mylist = new SinglyLinkedList();

		mylist.add("B");
		mylist.add("C");
		mylist.add("D");
		mylist.add("F");
		mylist.add("G");
		mylist.add(3, null);

		list.add("B");
		list.add("C");
		list.add("D");
		list.add("F");
		list.add("G");
		list.add(3, null);

		assertEquals(list.size(), mylist.size());

		int i = 0;
		for (ListNode node = mylist.getHead(); node != null; node = node.getNext()) {
			
			assertEquals(list.get(i), node.getValue());
			i++;
		}
		assertEquals(i, list.size());

	}

	@Test
	@DisplayName("[5] Test if your add at index method works correctly")
	public void testAddAtIndex() {
		fillListsWithData();

		mylist.add(1, "D");
		list.add(1, "D");


		int i = 0;
		for (ListNode node = mylist.getHead(); node != null; node = node.getNext()) {
			
			assertEquals(list.get(i), node.getValue());
			i++;
		}
		assertEquals(i, list.size());

	}

	@Test
	@DisplayName("[5] Test if your remove at index method works correctly.")
	public void testRemoveIndex() {
		list = new LinkedList();
		mylist = new SinglyLinkedList();

		mylist.add("B");
		mylist.add("C");
		mylist.add("D");
		mylist.add("E");
		mylist.add("F");
		mylist.add("G");
		mylist.remove(3);

		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		list.add("G");
		list.remove(3);

		System.out.println(mylist);
		System.out.println(list);
		
		assertEquals(list.size(), mylist.size());

		int i = 0;
		for (ListNode node = mylist.getHead(); node != null; node = node.getNext()) {
			
			assertEquals(list.get(i), node.getValue());
			i++;
		}
		assertEquals(i, list.size());

	}

	@Test
	@DisplayName("[5] Test if your remove object method works correctly.")
	public void testRemoveStrings() {
		list = new LinkedList();
		mylist = new SinglyLinkedList();

		mylist.add("A");
		mylist.add("B");
		mylist.add("C");
		mylist.add("D");
		mylist.add("E");
		mylist.add("F");
		mylist.add("G");
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		list.add("G");
		
		assertEquals(mylist.remove("A"), list.remove("A"));

		assertEquals(mylist.remove("F"), list.remove("F"));

		int i = 0;
		for (ListNode node = mylist.getHead(); node != null; node = node.getNext()) {
			
			assertEquals(list.get(i), node.getValue());
			i++;
		}
		assertEquals(i, list.size());

	}




}