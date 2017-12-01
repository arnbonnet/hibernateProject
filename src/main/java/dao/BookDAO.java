package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.Book;
import entities.Client;

public class BookDAO {
	
	private BookDAO() {}
	
	public static void createBook(Book book) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		
		em.persist(book);
		DatabaseHelper.commitTxAndClose(em);
	}

	public static void updateBook(Book book) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		
		em.merge(book);
		DatabaseHelper.commitTxAndClose(em);
	}
	
	public static List<Client> getClients(Book book) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		
		Book bookOut = em.find(Book.class, book.getId());
		
		return bookOut.getClients();
	}
	
	public static List<Book> getAllBoughtBooks() {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		
		TypedQuery<Book> query = em.createQuery("select distinct Book b from Book " + 
												"inner join fetch b.clients", Book.class);
		
		List<Book> books = query.getResultList();
		DatabaseHelper.commitTxAndClose(em);
		
		return books;
	}

}
