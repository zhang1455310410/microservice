	$(function(){
			$(".product-coupon ul li a").on("click",function(){
				$(this).addClass("active-coupon").parent().siblings().children().removeClass("active-coupon")
		})
			
			$(".single-product-details .color-swatches li").on("click",function(){
				$(this).addClass("active-color").attr("name","color").siblings().removeClass("active-color")
			})
		})
		
		
	function add(){
			var num=parseInt($("input[name='product-quantity']").val());
			num+=1
			$("input[name='product-quantity']").val(num)
		}
		
		function del(){
			var num=parseInt($("input[name='product-quantity']").val());
			if(num>1)
				num-=1
			
				$("input[name='product-quantity']").val(num)
		}
		 $(document).on("click",".btn-main",function(){ 
				
				
			  var shoes_id=$("input[name='shoes_id']").val()
			  
			  var size=$(".size").val()
			   var number=$("input[name='num']").val()
			 var orders={
				
					"shoesId": shoes_id,
			
					"shoesSize":size,
					"num": number
					
			 }
			 
			  $.ajax({                     
			        url: "http://mylinux:8002/orders",
			        type: "POST",           
			        contentType: "application/json",
			                dataType: "json",
			                data: JSON.stringify(orders),
			                success: function (result) {
			                   if(result){
			                	   alert("添加成功");
			                   }else{
			                	   alert("添加失败");
			                   }
			                }
			            })
		 })