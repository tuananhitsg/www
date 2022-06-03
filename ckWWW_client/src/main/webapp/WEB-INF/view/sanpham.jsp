<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List San Pham</title>
</head>
<body>
<div>
		<p>
			<a href="${pageContext.request.contextPath}/loaisanphams/list" >Black to List</a>
		</p>
	</div>
	<div align="center">
	<c:url var="addUrl" value="/sanphams/showFormAdd?IDloaiSP=${lsp.id}" />
		<h2>Danh Sach San Pham</h2>
		<input  type="button" value="Create San Pham"
          onclick="window.location.href='${addUrl}'; 
	 	return false;" class="add-button"  />
	 	<table border="1" cellpadding="5">
	 		<tr>
	 			<th>ID</th>
	 			<th>Ten San Pham</th>
	 			<th>Don Gia</th>
	 			<th>Action</th>
	 		</tr>
	 		<c:forEach items="${lisSP}" var ="temp">
	 			<c:url var="updateLink" value="/sanphams/showFormUpdate?IDloaiSP=${lsp.id}&id=${temp.id}">
	 			</c:url>
	 			<c:url var="deleteLink" value="/sanphams/delete?id=${temp.id}&IDloaiSP=${lsp.id}">
	 			</c:url>
	 			<tr>
	 				<td>${temp.id}</td>
	 				<td>${temp.tenSP}</td>
	 				<td>${temp.donGia}</td>
	 				<td>
	 					<a href="${updateLink}" >Edit</a>
	 				
	 					<a href="${deleteLink}" onclick="if (!confirm('Are you sure you want to delete this San Pham?')) { return false; }" >Delete</a>
	 				</td>
	 			</tr>
	 		</c:forEach>
	 		
	 	</table>
	</div>
</body>
</html>