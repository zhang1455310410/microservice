var Auth = {
	vars: {
		lowin: document.querySelector('.lowin'),
		
		lowin_wrapper: document.querySelector('.lowin-wrapper'),
		lowin_login: document.querySelector('.lowin-login'),
		lowin_wrapper_height: 0,
		login_back_link: document.querySelector('.login-back-link'),
		forgot_link: document.querySelector('.forgot-link'),
		login_link: document.querySelector('.login-link'),
		login_btn: document.querySelector('.login-btn'),
		register_link: document.querySelector('.register-link'),
		password_group: document.querySelector('.password-group'),
		password_group_height: 0,
		lowin_register: document.querySelector('.lowin-register'),

		box: document.getElementsByClassName('lowin-box'),
		option: {}
	},
	register(e) {
		Auth.vars.lowin_login.className += ' lowin-animated';
		setTimeout(() => {
			Auth.vars.lowin_login.style.display = 'none';
			Auth.vars.lowin_register.style.visibility='visible';
		}, 500);
		Auth.vars.lowin_register.style.display = 'block';
			
		Auth.vars.lowin_register.className += ' lowin-animated-flip';

		Auth.setHeight(Auth.vars.lowin_register.offsetHeight );

		e.preventDefault();
	},
	login(e) {
		Auth.vars.lowin_register.classList.remove('lowin-animated-flip');
		Auth.vars.lowin_register.className += ' lowin-animated-flipback';
		Auth.vars.lowin_login.style.display = 'block';
		Auth.vars.lowin_login.classList.remove('lowin-animated');
		Auth.vars.lowin_login.className += ' lowin-animatedback';
		setTimeout(() => {
			Auth.vars.lowin_register.style.display = 'none';
		}, 500);
		
		setTimeout(() => {
			Auth.vars.lowin_register.classList.remove('lowin-animated-flipback');
			Auth.vars.lowin_login.classList.remove('lowin-animatedback');
		},1000);

		Auth.setHeight(Auth.vars.lowin_login.offsetHeight);

		e.preventDefault();
	},setHeight(height) {
		Auth.vars.lowin_wrapper.style.minHeight = height + 'px';
	},
	
	init() {
		Auth.setHeight(Auth.vars.box[0].offsetHeight );

		Auth.vars.password_group.style.height = Auth.vars.password_group.offsetHeight + 'px';
		Auth.vars.password_group_height = Auth.vars.password_group.offsetHeight;
		Auth.vars.lowin_wrapper_height = Auth.vars.lowin_wrapper.offsetHeight;
		
	

		var len = Auth.vars.box.length - 1;

		for(var i = 0; i <= len; i++) {
			if(i !== 0) {
				Auth.vars.box[i].className += ' lowin-flip';
			}
		}

		
		Auth.vars.register_link.addEventListener("click", (e) => {
			
			Auth.register(e);
		});

		Auth.vars.login_link.addEventListener("click", (e) => {
			
			Auth.login(e);
		});

		
	}
}

var show_num = [];
	draw(show_num);

	$("#canvas").on('click',function(){
		draw(show_num);
	})
	
	//
	

	
function draw(show_num) {
	var canvas_width=$('#canvas').width();
	var canvas_height=$('#canvas').height();
	var canvas = document.getElementById("canvas");//获取到canvas的对象，演员
	var context = canvas.getContext("2d");//获取到canvas画图的环境，演员表演的舞台
	canvas.width = canvas_width;
	canvas.height = canvas_height;
	var sCode = "A,B,C,E,F,G,H,J,K,L,M,N,P,Q,R,S,T,W,X,Y,Z,1,2,3,4,5,6,7,8,9,0";
	var aCode = sCode.split(",");
	var aLength = aCode.length;//获取到数组的长度
	
	for (var i = 0; i <= 3; i++) {
		var j = Math.floor(Math.random() * aLength);//获取到随机的索引值
		var deg = Math.random() * 30 * Math.PI / 180;//产生0~30之间的随机弧度
		var txt = aCode[j];//得到随机的一个内容
		show_num[i] = txt.toLowerCase();
		var x = 10 + i * 20;//文字在canvas上的x坐标
		var y = 20 + Math.random() * 8;//文字在canvas上的y坐标
		context.font = "bold 23px 微软雅黑";

		context.translate(x, y);
		context.rotate(deg);

		context.fillStyle = randomColor();
		context.fillText(txt, 0, 0);

		context.rotate(-deg);
		context.translate(-x, -y);
	}
	for (var i = 0; i <= 5; i++) { //验证码上显示线条
		context.strokeStyle = randomColor();
		context.beginPath();
		context.moveTo(Math.random() * canvas_width, Math.random() * canvas_height);
		context.lineTo(Math.random() * canvas_width, Math.random() * canvas_height);
		context.stroke();
	}
	for (var i = 0; i <= 30; i++) { //验证码上显示小点
		context.strokeStyle = randomColor();
		context.beginPath();
		var x = Math.random() * canvas_width;
		var y = Math.random() * canvas_height;
		context.moveTo(x, y);
		context.lineTo(x + 1, y + 1);
		context.stroke();
	}
}

function randomColor() {//得到随机的颜色值
	var r = Math.floor(Math.random() * 256);
	var g = Math.floor(Math.random() * 256);
	var b = Math.floor(Math.random() * 256);
	return "rgb(" + r + "," + g + "," + b + ")";
}
	
		 $('.lowin-input').on("focus", function() {
        $(this).siblings('.lowin-input-left').addClass("input-group-focus");
    }).on("blur", function() {
        $(this).siblings(".lowin-input-left").removeClass("input-group-focus");
    });
	
		
		 $(".register-btn").click(function(){
				var val = $(".input-val").val().toLowerCase();
				var username=$("input[name='regusername']").val()
				var pswd=$("input[name='regpassword']").val()
				var user={
					"username":username,
					"password":pswd
				}
				var num = show_num.join("");
				if(val==''){
					
					$(".text-msg").html("请填入正确的注册信息及验证码！")
				
				}else if(val == num && username!=null && username!="" && pswd!=null &&pswd!=""){
			
					$(".input-val").val('');
					draw(show_num);
					 $.ajax({                     
					        url: "http://mylinux:8002/user",
					        type: "POST",           
					        contentType: "application/json",
					                dataType: "json",
					                data: JSON.stringify(user),
					                success: function (result) {
					                   if(result){
					                	   alert("注册成功");
					                   }else{
					                	   $(".text-msg").html("账号名已被注册或格式错误")
					                   }
					                }
					            })
				}else{
					
					$(".text-msg").html("请填入正确的注册信息及验证码！")
					$(".input-val").val('');
					draw(show_num);
						
				}
				return false;
			})
	
	
		