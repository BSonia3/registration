<%-- 
    Document   : message
    Created on : Mar 3, 2020, 1:12:24 PM
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
            <title>Messages Page</title>
          
        </head>
    <body>
    <div align="center">
        
        <div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h4>Welcome ${pageContext.request.userPrincipal.name}   &nbsp;&nbsp;&nbsp; 
            &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 
           &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
           &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
           <a onclick="document.forms['logoutForm'].submit()">Logout</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
           <a href="viewProfile?username=${pageContext.request.userPrincipal.name}">Your Profile</a></h4>
        
     </c:if>
     
        <div>
            <br> <br> 
           <font color="red"> <h4 class="text-center"> ${message}</h4></font>

        </div>   
        
      </div>
    <h4> List of Messages</h4>
    <a href="/newMessage">Add New Message</a>
    <br>
    <br>
    <table border="1" cellpadding="10">
        <thead>
            <tr>
                <th>Message ID</th>
                <th>Subject</th>
                <th>Content</th>
                <th>Actions</th>
            </tr>
        </thead>
      
        <tbody>
       
             <c:forEach items="${listMessages}" var="message"> 
                <tr>
                <td>${message.id}</td>
                <td>${message.subject}</td>
                <td>${message.content}</td>
               
                <td>
                    <a href="editMessage?id=${message.id}">Edit Message</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="deleteMessage?id=${message.id}">Delete Message</a>
                    
                    &nbsp;&nbsp;&nbsp;
                    <a href="viewMessageDetails?id=${message.id}">View Message</a>
                </td>
                
                </tr>
            </c:forEach>
       
        </tbody>
    </table>
        <h4 class="text-center"> <a href="${pageContext.request.contextPath}/users">users Page</a> </h4> 
    </div>  
    
    
    
            
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="${contextPath}/resources/js/bootstrap.min.js"></script>  
        </body>
    </html>

