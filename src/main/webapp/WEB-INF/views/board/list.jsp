<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
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
		<section class="bg-light py-5">
			<div class="container px-5 my-5">
				<div class="text-center mb-5">
					<h1 class="fw-bolder">🚨${board}</h1>
					<p class="lead fw-normal text-muted mb-0">공지사항입니다. 지키지 못할시 죽음뿐.</p>
				</div>

				<div>
					<table class="table table-hover">
						<thead class="text-center text-muted">
							<tr>
								<th>글번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="boardVO">
								<tr>
									<td class="text-center">${boardVO.num}</td>
									<td><a href="./detail?num=${boardVO.num}">${boardVO.title}</a>
									</td>
									<td class="text-center">${boardVO.writer}</td>
									<td class="text-center">${boardVO.writeDate}</td>
									<td class="text-center">${boardVO.hit}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<nav aria-label="Page navigation example">
					<a class="btn btn-primary " href="./add">글쓰기 </a>
						<ul class="pagination" style="justify-content: center">
							<li class="page-item ${pager.page eq 1 ?'disabled':''}"><a
								class="page-link"
								href="./list?page=1&kind=${pager.kind}&search=${pager.search}"
								aria-label="Previous" data-board-page="1"> <span
									aria-hidden="true">&laquo;</span>
							</a></li>
							<li class="page-item ${pager.page eq 1 ?'disabled':''}">
								<a class="page-link" href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous" data-board-page="${pager.startNum}"> 
									<span aria-hidden="true">&lsaquo;</span>
							</a></li>

							<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="page">
								<li class="page-item"><a class="page-link" href="./list?page=${page}&kind=${pager.kind}&search=${pager.search}">${page}</a></li>
							</c:forEach>


							<li class="page-item ${pager.next eq false ?'disabled':''}">
								<a class="page-link"
								href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}"
								aria-label="Next" data-board-page="${pager.lastNum}"> <span
									aria-hidden="true">&rsaquo;</span>
							</a>
							</li>

							<li
								class="page-item ${pager.page eq pager.totalPage?'disabled' : ''}">
								<a class="page-link"
								href="./list?page=${pager.totalPage}&kind=${pager.kind}&search=${pager.search}"
								aria-label="Next" data-board-page="${pager.totalPage}"> <span
									aria-hidden="true">&raquo;</span>
							</a>
							</li>
						</ul>

						<form action="./list">
							<div class="row justify-content-center mx-auto mt-3">
								<div class="col-auto">
									<select class="form-select" aria-label="Default select example"
										name="kind">
										<option value="title">글제목</option>
										<option value="contents">내용</option>
										<option value="writer">작성자</option>
									</select>
								</div>
								<div class="col-auto">
									<input class="form-control" type="text" name="search">
								</div>
								<div class="col-auto">
									<button type="submit" class="btn btn-outline-primary">Search</button>
								</div>
							</div>
						</form>

					</nav>
				</div>

			</div>
		</section>



	</main>
	<c:import url="../temp/footer.jsp"></c:import>
</body>
</html>