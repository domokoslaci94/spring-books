<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>

<body>
	<h2>Create book</h2>

	<form:form method="POST" commandName="book" action="create">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<div>${message}</div>
		<table>
			<tr>
				<td>Author :</td>
				<td><form:input path="author" /></td>
				<td><form:errors path="author" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Title :</td>
				<td><form:input path="title" /></td>
				<td><form:errors path="title" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Price :</td>
				<td><form:input path="price" type="number" /></td>
				<td><form:errors path="price" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>