$(document).on("click",".btn-default",function(){ 
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