package review;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	
	private long id;
	private String title;
	private String author;
	private String content;
	private Date date;
	
		
		
		
		@ManyToOne(cascade=CascadeType.MERGE)
		private Category category;
		
		protected Review(){}
		
		public Review(String title, String author, String content, Date date, Category category){
			this.title = title;
			this.author = author;
			this.content = content;
			this.date = date;
			this.category = category;
		}
	
	
	
	
	public long getId(){
		return id;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getAuthor(){
		return author;
	}
	
	public String getContent(){
		return content;
	}
	
	public Date getDate(){
		return date;
	}
	
	public Category getCategory(){
		return category;
	}

}
