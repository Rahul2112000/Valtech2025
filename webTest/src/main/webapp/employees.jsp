<%@page import="dao.Employee" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="employees" method="get">
    <input type="hidden" name="operation" value="search">
    <select name="searchType">
     <option value="id">ID</option>
        <option value="name">Name</option>
        <option value="age">Age</option>
         <option value="gender">Gender</option>
        <option value="salary">Salary</option>
        <option value="experience">Experience</option>
        <option value="level">Level</option>
    </select>
    <input type="text" name="searchValue" placeholder="Search value" >
    <select name="condition">
        <option value=">">Greater Than</option>
        <option value="<">Less Than</option>
        <option value="=">Equal To</option>
    </select>
    <button type="submit">Search</button>
 <button type="submit" name="show" value="getAll">ShowAll</button>
 
</form>

<table>
<tr>

	<th><a href="employees?operation=sort&column=ID">ID</a></th>
	<th><a href="employees?operation=sort&column=NAME">Name</a></th>
	<th><a href="employees?operation=sort&column=AGE">Age</a></th>
	<th><a href="employees?operation=sort&column=GENDER">Gender</a></th>
	<th><a href="employees?operation=sort&column=SALARY">Salary</a></th>
	<th><a href="employees?operation=sort&column=EXPERIENCE">Experience</a></th>
	<th><a href="employees?operation=sort&column=LEVEL">Level</a></th>
	<th>Action</th>
</tr>
<c:forEach items="${emps}" var="e"> 
<tr>
<td><c:out value="${e.id }"></c:out></td>

<td>${e.name}</td>
<td>${e.age}</td>
<td>${e.gender}</td>
<td>${e.salary}</td>
<td>${e.experience}</td>
<td>${e.level}</td>

<td>
	<a href="employees?operation=Update&id=${e.id}">Update</a>
	<a href="employees?operation=Delete&id=${e.id}">Delete</a>
</td>

</tr>


</c:forEach>
<tr>
<td colspan="7">
<a href="employees?operation=new">New Employee</a>
</td>
</tr>
</table>

<%-- <div class="dropdown">
 
<jsp:include page="selectMenu.jsp" >
<jsp:param name="mode" value="employees"/>
</jsp:include>
 
<button value="RESET" type="submit" name="reset">Reset</button>
</form>
</div> --%>
 

 

<!-- <table>
<tr>

	<th>Id</th>
	<th>Name</th>
	<th>Age</th>
	<th>Gender</th>
	<th>Salary</th>
	<th>Experience</th>
	<th>Level</th>
</tr> --><%-- 
<% 
	List<Employee> emps=(List<Employee>) request.getAttribute("emps");
if(emps!=null){
	for(Employee e: emps){
	%>
		<tr>
		<td>
		<%= e.getId()%>
		</td>
		<td>
		<%= e.getName()%>
		</td>
		<td>
		<%= e.getAge()%>
		</td>
			<td>
		<%= e.getGender()%>
		</td>
		
		<td>
		<%= e.getSalary()%>
		</td>
	
		<td>
		<%= e.getExperience()%>
		</td>
		<td>
		<%= e.getLevel()%>
		</td>
		</tr>

<% }
	}else {%>
	<tr><td>  Employee not found!!
	</td></tr>
	<%} %> --%>
<!-- </table> -->
</body>
</html>