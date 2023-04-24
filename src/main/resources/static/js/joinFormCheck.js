/*!
*  Join Form에서 검증 
*/

$("#userName").change(idDuplicateCheck);

function idDuplicateCheck(){
	
	$.ajax({
		type:"GET",
		url:"./idDuplicateCheck",
		data:{
			userName:$('#userName').val()
		},
		success:function(result){
			console.log(result)
			if($('#userName').val()!=''){
			if(!result){
				$(".userNameRe").text("사용가능")
				$(".userNameRe").css('color', 'blue')
				console.log("사용 가능한 아이디")
			}else{
				$(".userNameRe").text("사용불가 ")				
				$(".userNameRe").css('color', 'red')
				console.log("중복 아이디")
			}
			}
		},
		error:function(){
			console.log("error")
		}
		
		
	})
	}
	

$("#password2").blur(pwCheck);

function pwCheck(){
	$('.passwordRe').text("");
   if($('#password').val() != $('#password2').val()){
	    	if($('#password2').val()!=''){
				$('.passwordRe').text("비밀번호가 일치하지 않습니다.")
				$(".passwordRe").css('color', 'red')
	    	    $('#password2').val('');
	          $('#password2').focus();
	    	}else if($('#password').val() == $('#password2').val()){
				$('.passwordRe').text("")
		   }
			
		}
	
}
	
	

