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
	<h2>Create order</h2>

	<form:form method="POST" commandName="order" action="create">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<div>${message}</div>
		<table>
			<tr>
				<td>User ID :</td>
				<td><form:input path="userVO.id" type="number"  /></td>
				<td><form:errors path="userVO.id" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Book ID :</td>
				<td><form:input path="bookVO.id" type="number" /></td>
				<td><form:errors path="bookVO.id" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" /></td>
			</tr>
		</table>
	</form:form>

	<h2> Return order <h2>

	<form:form method="POST" commandName="order" action="return">
        		<form:errors path="*" cssClass="errorblock" element="div" />
        		<div>${message}</div>
        		<table>
        			<tr>
        				<td>Order ID :</td>
        				<td><form:input path="id" type="number"  /></td>
        				<td><form:errors path="id" cssClass="error" /></td>
        			</tr>
        			<tr>
        				<td colspan="3"><input type="submit" /></td>
        			</tr>
        		</table>
        	</form:form>

</body>
</html>