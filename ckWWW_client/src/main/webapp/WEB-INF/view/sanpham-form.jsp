
<%@ taglib  uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form San Pham</title>
</head>
<body>
	<div>
		<p>
			<a href="${pageContext.request.contextPath}/sanphams/list?IDloaiSP=${IDloaiSP}" >Black to List</a>
		</p>
	</div>
	
	<div align="center">
	 	<h2>Create/Edit San Pham</h2>
	 	<c:url var ="saveUrl" value="/sanphams/saveSP?IDloaiSP=${IDloaiSP}"></c:url>
	 	<c:if test="${isUpdate}">
	 		<c:url var ="saveUrl" value="/sanphams/updateSP?IDloaiSP=${IDloaiSP}"></c:url>
	 	</c:if>
	 	<form:form modelAttribute="sanpham" method="POST" action="${saveUrl}">
	 		<form:hidden path="id"/>
	 		<table>
	 			<tbody>
	 					<tr>
                                <td><label>Ten San Pham:</label></td>
                                <td><form:input path="tenSP" /></td>
                        </tr>
                        <tr>
                                <td><label>Don Gia:</label></td>
                                <td><form:input path="donGia" /></td>
                        </tr>
                        <tr>
                                <td><label></label></td>
                                <td><input type="submit" value="Save" class="save" /></td>
                        </tr>
	 			</tbody>
	 		</table>
	 	</form:form>
	</div>
</body>
</html>