package tdtu.edu.vn.entity;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="news")
public class News {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "title", nullable = false, length = 1000)
	private String title;
	
	@Column(name = "content", nullable = false, length = 100000)
	private String content;
	
	@Column(name="create_day")
	Date createDate= new Date();
	
	
	
	@Column(name = "hide")
	private Boolean hide;
	@Column(name = "image")
	private String image;

	public News() {
		super();
	}

	

	public News(String title, String content, Date createDate, Boolean hide, String image) {
		super();
		this.title = title;
		this.content = content;
		this.createDate = createDate;
		this.hide = hide;
		this.image = image;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public Boolean getHide() {
		return hide;
	}

	public void setHide(Boolean hide) {
		this.hide = hide;
	}
	
	

}
