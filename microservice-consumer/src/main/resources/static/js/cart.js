function checkAll(check){
		
			if(check.checked==true){
				total=0;
				$("input[name='check']").prop("checked",true); 
				var number= $(".goods-number")
				var price=$(".goods-price");
				var state=$(".goods-content").lastElementChild
				
			

				for(var i=0;i<number.length;i++){
					total+=parseInt(number[i].innerHTML)*parseInt(price[i].firstElementChild.innerHTML)
					
				}
				
				
			}else if(check.checked==false){
					$("input[name='check']").prop("checked",false); 
					total=0
			}
			$(".total").text(total)
		}
		
		var total=0;
		
		$("input[name='check']").change(function(){
		var state=$(this).parent().parent().find(".state").text()
	
			if(state==0){
				var number=parseInt($(this).parent().siblings(".goods-number").text());
			var price=parseInt($(this).parent().siblings(".goods-price").children().text());
			
			$(this).parent().parent().find(".state").text(1)
			total+=number*price;
			}else{
				var number=parseInt($(this).parent().siblings(".goods-number").text());
			var price=parseInt($(this).parent().siblings(".goods-price").children().text());
			
			total-=number*price;
			$(this).parent().parent().find(".state").text(0)
			}
			
			$(".total").text(total)
		
		})
		
		 $(document).on("click",".btn-danger",function(){
			 
			var order_id= $(this).parent().parent().find(".id").val()
			
		 $.ajax({                     
					        url: "http://mylinux:8002/orders/"+order_id,
					        type: "DELETE",           
					        contentType: "application/json",
					                dataType: "json",
					               
					                success: function (result) {
					                   if(result){
					                	   alert("删除成功");
					                	   window.location.reload();
					                   }else{
					                	   alert("删除失败");
					                   }
					                }
					            })
		 })
		
		
	          