import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

    // Perform the borrowing of a book
    public boolean borrowBook(Book book, Member member) {
        if (book.isAvailable()) {
            book.borrowBook();
            member.borrowBook(book); 
            String transactionDetails = getCurrentDateTime() + " - Borrowing: " + member.getName() + " borrowed " + book.getTitle();
            saveTransaction(transactionDetails);
            return true;
        } else {
            System.out.println("The book is not available.");
            return false;
        }
    }

    // Perform the returning of a book
    public void returnBook(Book book, Member member) {
        if (member.getBorrowedBooks().contains(book)) {
            member.returnBook(book);
            book.returnBook();
            String transactionDetails = getCurrentDateTime() + " - Returning: " + member.getName() + " returned " + book.getTitle();
            saveTransaction(transactionDetails);
        } else {
            System.out.println("This book was not borrowed by the member.");
        }
    }

    // Get the current date and time in a readable format
    private String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
    
    //private constructor
    private Transaction()
    {
    	
    }
    //private instance variable
    private static Transaction instance;
    
    //public accessor method
    public static Transaction getTransaction()
    {
    	if (instance == null)
    	{
    		instance = new Transaction();
    	}
    	return instance;
    }
	
    private void saveTransaction(String transactionDetails)
    {
    	try
    	{
      BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.txt", true));
    writer.write(transactionDetails + "\n");
    
      writer.close(); 
    	} catch (Exception e) {}
    	

    }
    public void displayTransactionHistory()
    {
    	try
    	{
    	BufferedReader reader = new BufferedReader(new FileReader("transactions.txt"));
    	
    String line;
    	while ((line = reader.readLine()) != null)
    	{
    	System.out.println(line);
    	}
    	reader.close();
    	} catch (Exception e) {}
    }

}