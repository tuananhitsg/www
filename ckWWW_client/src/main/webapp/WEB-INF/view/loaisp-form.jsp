<%@ taglib  uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Loai San Pham</title>
</head>
<body>
<div>
		<p>
			<a href="${pageContext.request.contextPath}/loaisanphams/list" >Black to List</a>
		</p>
	</div>
	<div align="center">
	 	<h2>Create/Edit Loai San Pham</h2>
	 	<form:form action="saveLoaiSp" modelAttribute="loaisp" method="POST" >
	 		<form:hidden path="id"/>
	 		<table>
	 			<tbody>
	 				<tr>
                                <td><label>Ten Loai San Pham:</label></td>
                                <td><form:input path="tenLoaiSP" /></td>
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