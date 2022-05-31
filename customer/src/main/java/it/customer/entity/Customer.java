package it.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name = "CUSTOMERS")
@Data
@NoArgsConstructor
@ToString
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	@Column(name = "customer_name")
	private String name ;
	
	@Column(name ="customer_mail")
	private String mail ;

	public Customer(String name, String mail) {
		super();
		this.name = name;
		this.mail = mail;
	}
	

}
