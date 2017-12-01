package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

@Entity
@SequenceGenerator(name = "seq_client", sequenceName = "seq_client", initialValue = 1, allocationSize = 1)
public class Client {

	@Id
	@GeneratedValue(generator = "seq_client")
	private Long id;
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@ManyToOne
	private Book favoriteBook;
	
	@ManyToMany
	private List<Book> books = new ArrayList<>();
	
	public Client() {
	}
	
	public Client(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Client(String firstName, String lastName, Gender gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	}
	
	public Client(String firstName, String lastName, Gender gender, Book favoriteBook) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.favoriteBook = favoriteBook;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Book getFavoriteBook() {
		return favoriteBook;
	}

	public void setFavoriteBook(Book favorite_book) {
		this.favoriteBook = favorite_book;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public void addBook(Book book) {
		this.books.add(book);
	}
	
	
	
}
