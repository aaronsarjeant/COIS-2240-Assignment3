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

}
