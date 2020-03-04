<%-- 
    Document   : newMessage
    Created on : Mar 3, 2020, 4:59:01 PM
    Author     : sonia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
            <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
            <title>New Message</title>
        </head>
        <body>
          
            <div class="col-md-8" >
                <h4 align="center">Add New Message</h4>     
            <form:form  action="addMessage" method="POST" modelAttribute="message">
            <form:hidden path="id"/>
             <div class="form-group">
               <br>
                <label for="subject" class="col-md-2 control-label"> MSG Subject :</label>
             
                <div class=" col-md-8">
                 
                <form:input type="text" class="form-control" name="subject" path="subject" placeholder="enter subject"/>
                </div>  
              </div>
                <br>
               <div class="form-group">
               <br>
                <label for="pcolor" class="col-md-2 control-label"> MSG Content :</label>
             
                <div class=" col-md-8">
                 
                <form:input type="text" class="form-control" name="content" path="content" placeholder="enter Message content"/>
                </div>  
               </div>
                 <br>
               
             
             
           
           <div class="form-group">
             <div class="col-md-offset-4 col-md-8">
               <br>
               <input type="submit" class="btn btn-default" value="Submit"/>    <a href="${pageContext.request.contextPath}/logout" >Logout</a> 
                
             </div>
             
                            
            </div>
          
           
           
           </form:form>
          
           
           </div>
           
 
            
            
            
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
        </body>
    </html>

