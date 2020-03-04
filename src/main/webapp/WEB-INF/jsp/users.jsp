<%-- 
    Document   : users
    Created on : Mar 3, 2020, 10:56:25 PM
    Author     : sonia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Users Page</title>
          
        </head>
    <body>
    <div align="center">
        
        <div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

    <h4>Welcome ${pageContext.request.userPrincipal.name}    &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;  |
         &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;<a onclick="document.forms['logoutForm'].submit()">Logout</a></h4>
     </c:if>
     
        <div>
            <br> <br> 
           <font color="red"> <h4 class="text-center"> ${message}</h4></font>

        </div>   
        
      </div>
    <h4> List of Users</h4>
   
    <br/>
 
    <table border="1" >
        <thead>
            <tr>
                <th>User ID</th>
                <th>Username</th>
                <th>Password</th>
                <th>Actions</th>
            </tr>
        </thead>
      
        <tbody>
       
             <c:forEach items="${listUsers}" var="user"> 
                <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
               
                <td>
                    <a href="editUser?id=${user.id}">Edit User</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="deleteUser?id=${user.id}">Delete User</a>
                    
                    &nbsp;&nbsp;&nbsp;
                    <a href="viewUserDetails?id=${user.id}">View User</a>
                </td>
                
                </tr>
            </c:forEach>
       
        </tbody>
    </table>
    <h4 class="text-center"> <a href="${pageContext.request.contextPath}/adminRegistration">Admin Registration</a> </h4>
     <h4 class="text-center"> <a href="${pageContext.request.contextPath}/message">Messages Page</a> </h4>
    </div>  
    
    
    
            
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="${contextPath}/resources/js/bootstrap.min.js"></script>  
        </body>
    </html>


