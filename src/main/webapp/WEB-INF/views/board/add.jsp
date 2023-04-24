<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <!DOCTYPE html>
<html>    
<head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>글쓰기 </title>
       <!-- css & favicon  -->
       <c:import url="../temp/style.jsp"></c:import>
       <!-- css & favicon  -->
       
	
    </head>
    <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
          <!-- Navigation-->
  		   <c:import url="../temp/header.jsp"></c:import>
            <!-- Header-->
 </main>           
  <section class="py-5">
                <div class="container px-5">
                    <!-- Contact form-->
                    <div class="bg-light rounded-3 py-5 px-4 px-md-5 mb-5">
                        <div class="text-center mb-5">
                            <div class="feature bg-gradient text-white rounded-3 mb-3" style="font-size: 50px">🖍</div>
                            <h1 class="fw-bolder">글작성</h1>
                            <p class="lead fw-normal text-muted mb-0">자유롭게 글을 작성하세요 </p>
                        </div>
                        <div class="row gx-5 justify-content-center">
                            <div class="col-lg-8 col-xl-6">
                                <form:form id="contactForm" action="./add" cssClass="" modelAttribute="boardVO" method="post" enctype="multipart/form-data">
                                    <!-- Title input-->
                                    <div class="form-floating mb-3">
                                        <form:input path="title" cssClass="form-control" id="title"/>
                                        <label for="title">제목 </label>
										<form:errors path="title" cssStyle="color:red" cssClass="is-invalid"></form:errors>
                                    </div>
                                    <!-- writer address input-->
                                    <div class="form-floating mb-3">
                                        <form:input path="writer" id="writer" cssClass="form-control"/>
                                        <label for="writer">작성자 </label>
    									<form:errors path="writer" cssStyle="color:red" cssClass="is-invalid"></form:errors>
                                    </div>
                                    <!-- Message input-->
                                    <div class="form-floating mb-2">
                                        <textarea class="form-control" id="contents" name="contents" placeholder="Enter your message here..." style="height: 10rem" data-sb-validations="required"></textarea>
                                        <label for="contents">내용</label>
                                        <div class="invalid-feedback" data-sb-feedback="message:required">내용이 없습니다.</div>
                                    </div>
                                    <div class="mb-3" id="imgList">
										<div class="form-text">최소 1장, 최대 5장까지 등록 가능합니다.</div>                                        
                                       	<div class="fw-bold fs-5 col-12 my-1 input-group" id="img'+idx+'">
							            <input type="file" class="form-control img" name="boardFiles" multiple="multiple" id="imgs">
							            <button type="button" class="btn btn-outline-primary btn-image" id="fileInsert">+</button>
							            
							           </div>                                                                                 
                                    </div>
                                    
                                    <!-- Submit Button-->
                                    <div class="d-grid"><button class="btn btn-primary btn-lg" id="submitButton" type="submit">Submit</button></div>
                                    </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
 
 
 
<!— footer 적용해야함 —> 
<c:import url ="../temp/footer.jsp"></c:import>
<!— footer 적용 끝 —>
	<script type="text/javascript" src="../js/boardForm.js"></script>
	<script>
        $("#contents").summernote();
        
        setMax(4);
		setParam('imgs');
    </script>
        
	<script>
		const imgList = document.getElementById("imgList");

		let count = 0;
		let max = 4;
		let param = 'boardFiles';
		let idx = 1;

		function setCount(c){
		    count = c;
		}

		function setMax(m) {
		    max = m;
		};

		function setParam(p) {
		    param = p;
		}

		//추가
		$('#fileInsert').click(()=>{
		        if(count >= max) {
		            alert("이미지는 최대 " + (max+1) + "개까지 업로드 가능합니다")
		            return;
		        } 
		        
		        count++;
		        
		        let child = '<div class="fw-bold fs-5 col-12 my-1 input-group" id="img'+idx+'">';
		            child = child + '<input type="file" class="form-control" name="'+param+'">'
		            child = child + '<button type="button" class="btn btn-outline-danger btn-image delete" data-delete-id="img'+idx+'">x</button>'
		        $('#imgList').append(child);
		        idx++;
		})

		//삭제
		$('#imgList').on('click', '.delete', function(e){
		    $(this).parent().remove();
		    count--;
		})

    </script>
</body>
</html>
