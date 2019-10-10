		
			
			 
			  
		
			$(function(){
			 $(".istop").click(function() {
			 $("html,body").animate({scrollTop:0}, 500);
			 });
			  $(document).on("click",".logsingle1",function(){
	        	 	
	            	
		           	 var id=$(this).parent().find(".id").val()  
		           	 $(this).attr("href","http://mylinux:8002/product/shoes/"+id)
		           	$(this).click()
							})
		       $(document).on("click",".logsingle2",function(){
		              	
		           	
		           	var id=$(this).parent().parent().find(".id").val() 
		           	 $(this).attr("href","http://mylinux:8002/product/shoes/"+id)
		           	$(this).click()
							})
			})

					