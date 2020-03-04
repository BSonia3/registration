<%-- 
    Document   : messageDetails
    Created on : Mar 3, 2020, 5:06:17 PM
    Author     : sonia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>



    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

            <title>Message details</title>
        </head>
        <body>
            <div align="center">
            <h4 >Message details</h4>
   
            <table border="1" cellpadding="10">
        <thead>
            <tr>
                <th>Message ID</th>
                <th>Subject</th>
                <th>Content</th>
                
            </tr>
        </thead>
        <tbody>
           
         
                <tr>
               
                <td><c:out value="${message.id}"/></td>
                <td><c:out value="${message.subject}"/></td>
                <td><c:out value="${message.content}"/></td>
       
                </tr>
           
          
        </tbody>
    </table>
     
        </div>      
         
       
        <div class="pictures" align="center">
            
        <h4 class="text-center"> <a href="${pageContext.request.contextPath}/message">Messages Page</a> </h4>
       
      </div>
            
     
        </body>
    </html>
