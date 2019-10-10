package com.ccit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
public class Orders {
   
    private Integer id;

  
    private Integer shoesId;

  
    private Integer userId;

  
    private Integer shoesSize;

   
    private Integer num;

   
    private Integer couponId;
}