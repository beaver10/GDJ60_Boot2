<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 <!DOCTYPE html>
<html>    
<head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>LOGIN</title>
       <!-- css & favicon  -->
       <c:import url="../temp/style.jsp"></c:import>
       <!-- css & favicon  -->
       
  	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

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
                            <div class="feature bg-gradient text-white rounded-3 mb-3" style="font-size: 50px">🔑</div>
                            <h1 class="fw-bolder">로그인 </h1>
                            <p class="lead fw-normal text-muted mb-0">아이디와 패스워드를 입력하세요 </p>
                        </div>
                        <div class="row gx-5 justify-content-center">
                            <div class="col-lg-8 col-xl-6">
                                <form id="contactForm" action="./login" method="post" enctype="multipart/form-data">
                                    <!-- Title input-->
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="userName" name="userName" type="text" placeholder="Enter userName..." data-sb-validations="required" />
                                        <label for="userName">ID</label>
                                        <div class="invalid-feedback titleRe">제목이 없습니다.</div>
                                    </div>
                                    <!-- writer address input-->
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="password" name="password" type="text"  placeholder=" " data-sb-validations="required,email" />
                                        <label for="password">Password </label>
                                        <div class="invalid-feedback" data-sb-feedback="email:required">An email is required.</div>
                                        <div class="invalid-feedback" data-sb-feedback="email:email">Email is not valid.</div>
                                    </div>
                                    <!-- Submit Button-->
                                    <div class="d-grid"><button class="btn btn-primary btn-lg" id="submitButton" type="submit">Submit</button></div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
 
 
 
<!— footer 적용해야함 —> 
<c:import url ="../temp/footer.jsp"></c:import>
<!— footer 적용 끝 —>
	<script type="text/javascript" src="../js/boardForm.js"></script>
</body>
</html>
