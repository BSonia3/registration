<%-- 
    Document   : userProfile
    Created on : Mar 4, 2020, 9:26:46 AM
    Author     : sonia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>



    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

            <title>Profile details</title>
        </head>
        <body>
            <div align="center">
            <h4 >View Profile</h4>
   
            <table border="1" color="green">
        <thead>
            <tr>
                <th>Profile ID</th>
                <th>UserName</th>
                <th>Action</th>
                
            </tr>
        </thead>
        <tbody>
           
         
                <tr>
               
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.username}"/></td>
                <td>
                <a href="editProfile?id=${user.id}">Edit Profile</a> 
                </td>
                </tr>
           
          
        </tbody>
    </table>
     
        </div>      
         
       
        <div class="pictures" align="center">
            
        <h4 class="text-center"> <a href="${pageContext.request.contextPath}/message">Messages Page</a> </h4>
       
      </div>
            
     
        </body>
    </html>