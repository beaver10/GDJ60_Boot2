/*!
* board form 유효성 검사 
*/


// const submitButton = document.getElementById("submitButton");

// submitButton.addEventListener("click", function(){
// 	console.log("submit button click")
	
// })

$("#submitButton").click(function(){
	if(!$("#title").val()){
		$(".titleRe").innerHTML("제목이 없습니다.")
	}

})