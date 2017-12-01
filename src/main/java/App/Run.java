package App;

import java.util.Arrays;

import dao.BookDAO;
import dao.ClientDAO;
import entities.Book;
import entities.Client;
import entities.Gender;

public class Run {

	public static void main(String[] args) {
		
		Book book = new Book();
		book.setTitle("Ready Player");
		book.setAuthor("Ernest Cline");
		
		BookDAO.createBook(book);
		
		book.setTitle("Ready Player One");
		BookDAO.updateBook(book);
		
		Book book2 = new Book();
		book2.setTitle("L'Assassin Royal Tome 1 - L'Apprenti assassin");
		book2.setAuthor("Robin Hodd");
		
		Book book3 = new Book();
		book3.setTitle("L'Assassin Royal Tome 2 - L'Assassin du roi");
		book3.setAuthor("Robin Hodd");
		
		Book book4 = new Book();
		book4.setTitle("L'Assassin Royal Tome 3 - La Nef du crépuscule");
		book4.setAuthor("Robin Hodd");
		
		BookDAO.createBook(book2);
		BookDAO.createBook(book3);
		BookDAO.createBook(book4);

		Client client = new Client();
		client.setFirstName("Arnaud");
		client.setLastName("Bonnet");
		client.setBooks(Arrays.asList(book));
		client.setGender(Gender.M);
		client.setFavoriteBook(book);
		
		ClientDAO.createClient(client);
		
		client.setFavoriteBook(book2);
		ClientDAO.updateClient(client);
		
		ClientDAO.buy(client, book3);
		
	}

}
