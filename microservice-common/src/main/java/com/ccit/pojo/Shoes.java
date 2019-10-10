package com.ccit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
public class Shoes {
  
    private Integer id;

  
    private String name;

    private Double price;

   
    private String description;

   
    private String img;

  
}