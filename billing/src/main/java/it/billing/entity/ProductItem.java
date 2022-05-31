package it.billing.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@NoArgsConstructor
public class ProductItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int productId ;
	private double price ;
	private int quantity ;
	@Transient
	Product product ;


	public ProductItem( int productId, int quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}
	
}
