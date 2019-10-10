 $.ajax({                     
	        url: "http://mylinux:8002/shoes/page/1",
	        type: "get",          
	        contentType: "json",
	        dataType: "json",
	                success: function (result) {
	                	var html="";
	                	var html2="";
	                	$(".product-model").empty()
	                		$(".pagination").empty()
	                	$.each(result["list"],function(i,item){
	                		html+="<tr><td>"+item["id"]+"</td>"+
							"<td>"+item["name"]+"</td>"+
							"<td>"+item["description"]+"</td>"+
							"<td>"+item["price"]+"</td>"+
							"<td><img src="+item['img']+"  /></td>"+
							"<td><button class='btn btn-warning' onclick='show()'><span class='glyphicon glyphicon-pencil' aria-hidden='true'></span>修改</button>"+
								"  <button class='btn btn-danger'><span class='glyphicon  glyphicon-trash' aria-hidden='true'></span>删除</button></td></tr>"
	                		
	                	
							
	                	})
	                		$(".product-model").append(html)
					 	
	                		
	                		
	                		html2+=" <li class='"+(1==result["pageNum"]?" disabled ": "onpage")+"'><input type='hidden' value='1'/><a >首页</a></li>"+
					    "<li class='"+(result["isFirstPage"]?" disabled":"onpage")+"'><input type='hidden' value='"+result["prePage"]+"'/><a   aria-label='Previous'>上一页</a></li>"
	                	$.each(result["navigatepageNums"],function(i,item){
	                		html2+=" <li class='"+(item==result["pageNum"]?" active":"onpage")+"'><input type='hidden' id='"+(item==result["pageNum"]?" thispage":"")+"' value='"+item+"'/><a >"+item+"</a></li>"
	                	})
	                	html2+= "<li class='"+(result["isLastPage"]?" disabled":"onpage")+"'><input type='hidden' value='"+result["nextPage"]+"'/><a   aria-label='Next'>下一页</a></li>"+
	                	   "<li class='"+(result["isLastPage"]?" disabled":"onpage")+"'><input type='hidden' value='"+result["lastPage"]+"'/><a  >尾页</a></li>"
	                	   $(".pagination").append(html2)
//	                	  $(".pagination").css('display',' '); 
	                	
	                 
	                }
	            })
	        
			
		  $(document).on("click",".btn-danger",function(){
			  var id=$(this).parent().parent().children().eq(0).text()
			  var thisPage=$("#thispage").val()
			   $.ajax({                     
	        url: "http://mylinux:8002/shoes/"+id,
	        type: "delete", 
	        
	        contentType: "json",
	        
	                success: function (res) {
	                	alert("删除成功")
	                	window.location.reload();
	                	
	                }
			   })
			   
			    
			
		  })
		    $(document).on("click"," .btn-warning",function(){
		    	 var id=$(this).parent().parent().children().eq(0).text()
		    	 var name=$(this).parent().parent().children().eq(1).text()
		    	 var description=$(this).parent().parent().children().eq(2).text()
		    	 var price=$(this).parent().parent().children().eq(3).text()
		    	
		    	 $("#exampleInputText1").val(id)
		    	  $("#exampleInputText2").val(name)
		    	   $("#exampleInputText3").val(description)
		    	    $("#exampleInputText4").val(price)
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
	                	$(".product-model").empty()
	                	$(".pagination").empty()
	                	$.each(result["list"],function(i,item){
	                		html+="<tr><td>"+item["id"]+"</td>"+
							"<td>"+item["name"]+"</td>"+
							"<td>"+item["description"]+"</td>"+
							"<td>"+item["price"]+"</td>"+
							"<td><img src="+item['img']+"  /></td>"+
							"<td><button class='btn btn-warning' onclick='show()'><span class='glyphicon glyphicon-pencil' aria-hidden='true'></span>修改</button>"+
								"  <button class='btn btn-danger'><span class='glyphicon  glyphicon-trash' aria-hidden='true'></span>删除</button></td></tr>"
	                	})
	                		$(".product-model").append(html)
	                		
	                		html2+=" <li class='"+(1==result["pageNum"]?" disabled ": "onpage")+"'><input type='hidden' value='1'/><a >首页</a></li>"+
						    "<li class='"+(result["isFirstPage"]?" disabled":"onpage")+"'><input type='hidden' value='"+result["prePage"]+"'/><a   aria-label='Previous'>上一页</a></li>"
		                	$.each(result["navigatepageNums"],function(i,item){

		                		html2+=" <li class='"+(item==result["pageNum"]?" active":"onpage")+"'><input type='hidden' id='"+(item==result["pageNum"]?" thispage":"")+"' value='"+item+"'/><a >"+item+"</a></li>"
		                	})
		                	html2+= "<li class='"+(result["isLastPage"]?" disabled":"onpage")+"'><input type='hidden' value='"+result["nextPage"]+"'/><a   aria-label='Next'>下一页</a></li>"+
		                	   "<li class='"+(result["isLastPage"]?" disabled":"onpage")+"'><input type='hidden' value='"+result["lastPage"]+"'/><a  >尾页</a></li>"
		                	   $(".pagination").append(html2)
	                }
	            })
		 })

	          