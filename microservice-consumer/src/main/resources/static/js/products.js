 $.ajax({                     
	        url: "http://mylinux:8002/shoes/page/1",
	        type: "get",          
	        contentType: "json",
	        dataType: "json",
	                success: function (result) {
	                	var html="";
	                	var html2="";
	                	$(".product-model-sec").empty()
	                		$(".pagination").empty()
	                	$.each(result["list"],function(i,item){
	                		html+="<form><a><div class='product-grid love-grid'><div class='more-product'><span> </span></div><div class='product-img b-link-stripe b-animate-go'>"+
	                		
	                		"<img src="+item['img']+" class='img-responsive' />"+
							"<div class='b-wrapper'><h4 class='b-animate b-from-left  b-delay03'><button class='btns' ><span class='glyphicon glyphicon-eye-open' aria-hidden='true'></span>商品详情" +
							"<input class='id' type='hidden' value='"+item['id']+"'/>"+
							"</button></h4></div></div></a><div class='product-info simpleCart_shelfItem'><div class='product-info-cust prt_name'>"+
							"<h4>"+item['name']+"</h4>"+
							"<span class='item_price'>￥"+item['price']+"</span>"+
							"<input type='button' class='item_add items' value='添加购物车''>" +
							"</div><div class='clearfix'> </div></div></div></form>"
						
	                	})
	                		$(".product-model-sec").append(html)
					 	
	                		
	                		
	                		html2+=" <li class='"+(1==result["pageNum"]?" disabled ": "onpage")+"'><input type='hidden' value='1'/><a >首页</a></li>"+
					    "<li class='"+(result["isFirstPage"]?" disabled":"onpage")+"'><input type='hidden' value='"+result["prePage"]+"'/><a   aria-label='Previous'>上一页</a></li>"
	                	$.each(result["navigatepageNums"],function(i,item){
	                		html2+=" <li class='"+(item==result["pageNum"]?" active":"onpage")+"'><input type='hidden' value='"+item+"'/><a >"+item+"</a></li>"
	                	})
	                	html2+= "<li class='"+(result["isLastPage"]?" disabled":"onpage")+"'><input type='hidden' value='"+result["nextPage"]+"'/><a   aria-label='Next'>下一页</a></li>"+
	                	   "<li class='"+(result["isLastPage"]?" disabled":"onpage")+"'><input type='hidden' value='"+result["lastPage"]+"'/><a  >尾页</a></li>"
	                	   $(".pagination").append(html2)
//	                	  $(".pagination").css('display',' '); 
	                	
	                 
	                }
	            })
	            $(document).on("click",".btns",function(){
	                	 var id=$(this).find(".id").val()    	
		            	 var form=$(this).parent().parent().parent().parent().parent().parent()
		            	
		            	 form.attr("action","/product/shoes/"+id)
		            	 form.submit()
							})
			$(document).on("click",".item_add",function(){ 
				 var form=$(this).parent().parent().parent().parent()
		
			  var shoes_id=form.find(".id").val()
			 
			  
			 var order={
					
					"shoesId": shoes_id,
					
					
					
			 }
			 $.ajax({                     
			        url: "http://mylinux:8002/orders/default",
			        type: "POST",           
			        contentType: "application/json",
			                dataType: "json",
			                data: JSON.stringify(order),
			                success: function (result) {
			                   if(result){
			                	   alert("添加成功");
			                   }else{
			                	   alert("添加失败");
			                	   window.location.href="/login"
			                   }
			                }
			            })
		 })
		 
		 $(document).on("click",".pagination .onpage",function(){
			 
			var page= $(this).find("input").val()
			
			 $.ajax({                     
	        url: "http://mylinux:8002/shoes/page/"+page,
	        type: "get",   
	        
	        contentType: "json",
	        dataType: "json",
	                success: function (result) {
	                	var html="";
	                	var html2="";
	                	$(".product-model-sec").empty()
	                	$(".pagination").empty()
	                	$.each(result["list"],function(i,item){
	                		html+="<form><a><div class='product-grid love-grid'><div class='more-product'><span> </span></div><div class='product-img b-link-stripe b-animate-go'>"+
	                		
	                		"<img src="+item['img']+" class='img-responsive' />"+
							"<div class='b-wrapper'><h4 class='b-animate b-from-left  b-delay03'><button class='btns' ><span class='glyphicon glyphicon-eye-open' aria-hidden='true'></span>商品详情" +
							"<input class='id' type='hidden' value='"+item['id']+"'/>"+
							"</button></h4></div></div></a><div class='product-info simpleCart_shelfItem'><div class='product-info-cust prt_name'>"+
							"<h4>"+item['name']+"</h4>"+
							"<span class='item_price'>￥"+item['price']+"</span>"+
							"<input type='button' class='item_add items' value='添加购物车''>" +
							"</div><div class='clearfix'> </div></div></div></form>"
						
	                	})
	                		$(".product-model-sec").append(html)
	                		
	                		html2+=" <li class='"+(1==result["pageNum"]?" disabled ": "onpage")+"'><input type='hidden' value='1'/><a >首页</a></li>"+
						    "<li class='"+(result["isFirstPage"]?" disabled":"onpage")+"'><input type='hidden' value='"+result["prePage"]+"'/><a   aria-label='Previous'>上一页</a></li>"
		                	$.each(result["navigatepageNums"],function(i,item){
		                		html2+=" <li class='"+(item==result["pageNum"]?" active":"onpage")+"'><input type='hidden' value='"+item+"'/><a >"+item+"</a></li>"
		                	})
		                	html2+= "<li class='"+(result["isLastPage"]?" disabled":"onpage")+"'><input type='hidden' value='"+result["nextPage"]+"'/><a   aria-label='Next'>下一页</a></li>"+
		                	   "<li class='"+(result["isLastPage"]?" disabled":"onpage")+"'><input type='hidden' value='"+result["lastPage"]+"'/><a  >尾页</a></li>"
		                	   $(".pagination").append(html2)
	                }
	            })
		 })
	          