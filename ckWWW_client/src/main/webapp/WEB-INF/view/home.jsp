<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Loai San Pham</title>
</head>
<body>
	<div align="center">
	 	<h2>Danh Sach Loai San Pham</h2>
	 	<input type="button" value="Create Loai San Pham"
          onclick="window.location.href='showFormLoaiSPforAdd'; 
	 	return false;" class="add-button"  />
	 	<table border="1" cellpadding="5">
	 		<tr>
	 			<th>ID</th>
	 			<th>Ten Loai</th>
	 			<th>Action</th>
	 			<th>Link</th>
	 		</tr>
	 		<c:forEach items="${listLoaiSP}" var ="temp">
	 			<c:url var="spLink" value="/sanphams/list">
	 				<c:param name="IDloaiSP" value="${temp.id}"></c:param>
	 			</c:url>
	 		
	 			<c:url var="updateLink" value="/loaisanphams/showFormLoaiSPforUpdate">
	 				<c:param name="idlsp" value="${temp.id}"></c:param>
	 			</c:url>
	 			<c:url var="deleteLink" value="/loaisanphams/deleteLoaiSp">
	 				<c:param name="idlsp" value="${temp.id}"></c:param>
	 			</c:url>
	 			<tr>
	 				<td>${temp.id}</td>
	 				<td>${temp.tenLoaiSP}</td>
	 				<td>
	 					<a href="${updateLink}" >Edit</a>
	 				
	 					<a href="${deleteLink}" onclick="if (!confirm('Are you sure you want to delete this Loai San Pham?')) { return false; }" >Delete</a>
	 				</td>
	 				<td>
	 					<a href="${spLink}" >Show San Pham</a>
	 				</td>
	 			</tr>
	 		</c:forEach>
	 		
	 	</table>
	</div>
</body>
</html>