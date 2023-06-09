package tdtu.edu.vn.entity;


import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="oder")
public class Oder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Column(name = "name")
	String name;
	@Column(name = "address")
	String address;
	@Column(name = "phone")
	String phone;
	@Column(name = "status")
	String status;
	@Column(name = "payment")
	String payment;
	@Column(name="create_day")

	Date createDate= new Date();
	@Column(name = "total")
	int total;
	@OneToMany(mappedBy = "oder")
	List<OrderDetail> orderDetails;
	public Oder() {
		super();
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public List<OrderDetail> getOderDetails() {
		return orderDetails;
	}
	public void setOderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
	
	 
	
}
