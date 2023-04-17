package tdtu.edu.vn.entity;

import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "price")
	private int price;
	@Column(name = "image")
	private String image;
	@Column(name = "image1")
	private String image1;
	@Column(name = "image2")
	private String image2;
	@Column(name = "description")
	private String description;
	@Column(name = "quatity")
	private String quatity;
	@Column(name = "color")
	private String color;
	@Column(name = "year")
	private int year;
	@Column(name = "ram", nullable = true)
	private int ram;
	@Column(name = "rom")
	private int rom;
	@Column(name = "screen")
	private String screen;
	@Column(name = "screen_type")
	private String screen_type;
	@Column(name = "battery")
	private int battery;
	@Column(name = "frontCamera", nullable = true)
	private int frontCamera;
	@Column(name = "backCamera", nullable = true)
	private int backCamera;
	@Column(name = "os")
	private String os;
	@Column(name = "cpu")
	private String cpu;
	@OneToMany(mappedBy = "product")
	List<OrderDetail> orderDetails;
	@ManyToOne
	@JoinColumn(name="Categoryid")
	Category category;
	public Product() {
		super();
	}
	
	

	public Product(String name, int price, String image, String image1, String image2, String description,
			String quatity, String color, int year, int ram, int rom, String screen, String screen_type, int battery,
			int frontCamera, int backCamera, String os, String cpu, List<OrderDetail> orderDetails, Category category) {
		super();
		this.name = name;
		this.price = price;
		this.image = image;
		this.image1 = image1;
		this.image2 = image2;
		this.description = description;
		this.quatity = quatity;
		this.color = color;
		this.year = year;
		this.ram = ram;
		this.rom = rom;
		this.screen = screen;
		this.screen_type = screen_type;
		this.battery = battery;
		this.frontCamera = frontCamera;
		this.backCamera = backCamera;
		this.os = os;
		this.cpu = cpu;
		this.orderDetails = orderDetails;
		this.category = category;
	}



	public int getRam() {
		return ram;
	}



	public void setRam(int ram) {
		this.ram = ram;
	}



	public int getRom() {
		return rom;
	}



	public void setRom(int rom) {
		this.rom = rom;
	}



	public String getScreen() {
		return screen;
	}



	public void setScreen(String screen) {
		this.screen = screen;
	}



	public String getScreen_type() {
		return screen_type;
	}



	public void setScreen_type(String screen_type) {
		this.screen_type = screen_type;
	}



	public int getBattery() {
		return battery;
	}



	public void setBattery(int battery) {
		this.battery = battery;
	}



	public int getFrontCamera() {
		return frontCamera;
	}



	public void setFrontCamera(int frontCamera) {
		this.frontCamera = frontCamera;
	}



	public int getBackCamera() {
		return backCamera;
	}



	public void setBackCamera(int backCamera) {
		this.backCamera = backCamera;
	}



	public String getOs() {
		return os;
	}



	public void setOs(String os) {
		this.os = os;
	}



	public String getCpu() {
		return cpu;
	}



	public void setCpu(String cpu) {
		this.cpu = cpu;
	}



	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}



	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}



	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getQuatity() {
		return quatity;
	}
	public void setQuatity(String quatity) {
		this.quatity = quatity;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	

}
