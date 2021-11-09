package OOP_UI;

public class Book {
	private String id, name, author;
	private int quantity, price;

	/**
	 * @param id
	 * @param name
	 * @param author
	 * @param quantity
	 * @param price
	 */
	public Book() {
		
	}
	public Book(String id, String name, String author, int quantity, int price) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.quantity = quantity;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
