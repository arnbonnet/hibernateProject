package dao;

import java.util.List;

import javax.persistence.EntityManager;

import entities.Book;
import entities.Client;

public class ClientDAO {

	private ClientDAO() {}
	
	public static void createClient(Client client) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);

		em.persist(client);
		DatabaseHelper.commitTxAndClose(em);

	}

	public static void updateClient(Client client) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		
		em.merge(client);
		DatabaseHelper.commitTxAndClose(em);
		
	}
	
	public static void buy(Client client, Book book) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);

		client.addBook(book);
		
		em.merge(client);
		DatabaseHelper.commitTxAndClose(em);
		
	}
	
	public static List<Book> getBooks(Client client) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		
		Client clientOut = em.find(Client.class, client.getId());
		
		return clientOut.getBooks();
	}

}
