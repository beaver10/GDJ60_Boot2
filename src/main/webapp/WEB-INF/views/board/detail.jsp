<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Modern Business</title>
	<!--  css, favicon 자리  -->
	<c:import url="../temp/style.jsp"></c:import>
    </head>
<body class="d-flex flex-column h-100">
    <main class="flex-shrink-0">
    
            <!-- Navigation-->
			<c:import url="../temp/header.jsp"></c:import>
            <!-- Header-->
            <section class="py-5">
                <div class="container px-5 my-5">
                    <div class="row gx-5">
                        <div class="col-lg-3">
                            <div class="d-flex align-items-center mt-lg-5 mb-4">
                            
                                	<img class="img-fluid rounded-circle" src="https://em-content.zobj.net/thumbs/240/apple/354/alien-monster_1f47e.png" width="10%" alt="..." />

                                <div class="ms-3">
                                    <div class="fw-bold">${boardVO.writer}</div>
                                    <div class="text-muted">${board}</div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-9">
                            <!-- Post content-->
                            <article>
                                <!-- Post header-->
                                <header class="mb-4">
                                    <!-- Post title-->
                                    <h1 class="fw-bolder mb-1">${boardVO.title}</h1>
                                    <!-- Post meta content-->
                                    <div class="text-muted fst-italic mb-2">${boardVO.writeDate}</div>
                                    <!-- Post categories-->
                                    <a class="badge bg-secondary text-decoration-none link-light" href="./list">${board}</a>
                                </header>
                                <!-- Preview image figure-->
                                <!-- Post content-->
                                <section class="mb-5">
                                   <c:forEach items="${boardVO.boardFileVOs}" var="boardFileVO">
	                               		 <a href="./fileDown?fileNum=${boardFileVO.fileNum}">${boardFileVO.oriName}</a>
	                               		 <figure class="mb-4"><img class="img-fluid rounded" src="/file/${board}/${boardFileVO.fileName}" alt="..." /></figure>
	                                </c:forEach>
                                   <p>${boardVO.contents}</p>
                                </section>
                            </article>
                            <!-- Comments section-->
                            <section>
                                <div class="card bg-light">
                                    <div class="card-body">
                                        <!-- Comment form-->
                                        <form class="mb-4"><textarea class="form-control" rows="3" placeholder="Join the discussion and leave a comment!"></textarea>
                                        <button class="btn btn-primary mt-2" style="margin-left: 85%;">댓글 등록</button>
                                        </form>
                                        <!-- Comment with nested comments-->
                                        <div class="d-flex mb-4">
                                            <!-- Parent comment-->
                                            <div class="flex-shrink-0"><img class="rounded-circle" src="https://dummyimage.com/50x50/ced4da/6c757d.jpg" alt="..." /></div>
                                            <div class="ms-3">
                                                <div class="fw-bold">Commenter Name</div>
                                                If you're going to lead a space frontier, it has to be government; it'll never be private enterprise. Because the space frontier is dangerous, and it's expensive, and it has unquantified risks.
                                                <!-- Child comment 1-->
                                                <div class="d-flex mt-4">
                                                    <div class="flex-shrink-0"><img class="rounded-circle" src="https://dummyimage.com/50x50/ced4da/6c757d.jpg" alt="..." /></div>
                                                    <div class="ms-3">
                                                        <div class="fw-bold">Commenter Name</div>
                                                        And under those conditions, you cannot establish a capital-market evaluation of that enterprise. You can't get investors.
                                                    </div>
                                                </div>
                                                <!-- Child comment 2-->
                                                <div class="d-flex mt-4">
                                                    <div class="flex-shrink-0"><img class="rounded-circle" src="https://dummyimage.com/50x50/ced4da/6c757d.jpg" alt="..." /></div>
                                                    <div class="ms-3">
                                                        <div class="fw-bold">Commenter Name</div>
                                                        When you put money directly to a problem, it makes a good headline.
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- Single comment-->
                                        <div class="d-flex">
                                            <div class="flex-shrink-0"><img class="rounded-circle" src="https://dummyimage.com/50x50/ced4da/6c757d.jpg" alt="..." /></div>
                                            <div class="ms-3">
                                                <div class="fw-bold">Commenter Name</div>
                                                When I look at the universe and all the ways the universe wants to kill us, I find it hard to reconcile that with statements of beneficence.
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </section>
                        </div>
                    </div>
                </div>
            </section>
      
        
	</main>
	<c:import url="../temp/footer.jsp"></c:import>
</body>
</html>