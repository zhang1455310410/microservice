package com.ccit.pojo;

//import com.fasterxml.jackson.core.sym.Name;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
public class OrdersExample {
	 private Integer id;

	  
	    private Integer shoesId;

	  
	    private Integer userId;

	  
	    private Integer shoesSize;

	   
	    private Integer num;

	   
	    private Integer couponId;
	    
	    private String name;
	    
	    private double price;
	    private String description;
	    private String img;
}
