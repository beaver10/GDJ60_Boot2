<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <!DOCTYPE html>
<html>    
<head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>JOIN</title>
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
                            <div class="feature bg-gradient text-white rounded-3 mb-3" style="font-size: 50px">🔒</div>
                            <h1 class="fw-bolder">회원가입</h1>
                            <p class="lead fw-normal text-muted mb-0">정보를 입력하세요</p>
                        </div>
                        <div class="row gx-5 justify-content-center">
                            <div class="col-lg-8 col-xl-6">
                           		 <form:form id="contactForm" modelAttribute="memberVO" method="post">
                                    <!-- Title input-->
                                    <div class="form-floating mb-3">
                                        <form:input path="username" id="username" cssClass="form-control" required="required"/>
                                        <label for="userName">ID</label>
                                        <div class="feedback usernameRe"></div>
                                        <form:errors path="username" cssStyle="color:red"></form:errors>
                                    </div>
                                    <!-- writer address input-->
                                    <div class="form-floating mb-3">
                                        <form:password path="password" id="password" cssClass="form-control" required="required"/>
                                        <label for="password">Password </label>
                                        <div class="feedback passwordRe"></div>
                                        <form:errors path="password" cssStyle="color:red"></form:errors>
                                        
                                    </div>
                                    <div class="form-floating mb-3">
                                        <form:password cssClass="form-control" id="password2" path="password2" required="required" />
                                        <label for="password2">Password 확인  </label>
                                        <form:errors path="password2" cssStyle="color:red"></form:errors>                                        
                                    </div>                                                                                                           
                                    <div class="form-floating mb-3">
                                    	<form:input path="name" id="name" cssClass="form-control"/>
                                        <label for="name">이름 </label>
                                        <form:errors path="name" cssStyle="color:red"></form:errors>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <form:input cssClass="form-control" path="email" id="email"/>
                                        <label for="email">email </label>
                                        <form:errors path="email" cssStyle="color:red"></form:errors>                                
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="birth" name="birth" type="date"/>
                                        <label for="birth">생일 </label>
                                        <form:errors path="birth" cssStyle="color:red"></form:errors>                                                                        
                                    </div>                                    
                                    
                                    <!-- Submit Button-->
                                    <div class="d-grid"><button class="btn btn-primary btn-lg" id="submitButton" type="submit">Submit</button></div>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
 
 
 

<c:import url ="../temp/footer.jsp"></c:import>

<!-- 	<script type="text/javascript" src="/js/joinFormCheck.js"></script>
 -->	
	
</body>
</html>
