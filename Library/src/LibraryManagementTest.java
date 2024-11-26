import static org.junit.Assert.*;

import org.junit.Test;

public class LibraryManagementTest {

	@Test
	public void testBookId() throws Exception{
		Book book1 = new Book(100, "book1");
		Book book2 = new Book(999, "book2");
		Book book3 = new Book(1000, "book3");
		Book book4 = new Book(99, "book4");
		Book book5 = new Book(204857, "book5");
	}
@Test
public void testBorrowReturn() throws Exception
{
	Book book1 = new Book(100, "book1");
	Member member1 = new Member(200, "member1");
	assertTrue(book1.isAvailable());
	Transaction t = Transaction.getTransaction();
	assertTrue(t.borrowBook(book1, member1));
	assertFalse(book1.isAvailable());
	assertFalse(t.borrowBook(book1, member1));
	assertTrue(t.returnBook(book1, member1));
	assertTrue(book1.isAvailable());
	assertFalse(t.returnBook(book1, member1));
	
	
}


}


	

