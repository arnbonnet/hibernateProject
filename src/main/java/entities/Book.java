package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

@Entity
@SequenceGenerator(name = "seq_book", sequenceName = "seq_book", initialValue = 1, allocationSize = 1)
public class Book {
	
	@Id
	@GeneratedValue(generator = "seq_book")
	private Long id;
	
	@Column
	@NotBlank
	private String title;
	
	private String author;
	
	@ManyToMany (mappedBy = "books")
	private List<Client> clients = new ArrayList<>();
	
	public Book() {
	}
	
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
	}
	
	
	
}
