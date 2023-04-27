package tdtu.edu.vn.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private double price;
	private int qty = 1;
	private double total;

	public Cart() {
		super();
	}

	public Cart(Long id, String name, double price, int qty, double total) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.qty = qty;
		this.total= total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	public double getTotal() {
		return total;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
}
