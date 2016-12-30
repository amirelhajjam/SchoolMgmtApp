<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <link href="<c:url value='/resources/css/bootstrap.css' />"  rel="stylesheet"></link>
        <link href="<c:url value='/resources/css/animate.min.css' />" rel="stylesheet"></link>
        <link href="<c:url value='/resources/fonts/font-awesome.min.css' />"  rel="stylesheet"></link>
        <link href="<c:url value='/resources/css/error.css' />" rel="stylesheet"></link>
        <link href="<c:url value='/resources/css/light-bootstrap-dashboard.css' />" rel="stylesheet"></link>
        <link href="<c:url value='/resources/css/demo.css' />" rel="stylesheet"></link>
        <link href="<c:url value='/resources/css/style-blog.css' />" rel="stylesheet"></link>
        <link href="<c:url value='/resources/css/jquery.dataTables.min.css' />" rel="stylesheet"></link>
    </head>
 
 <body>
 
 <div class="wrapper">	
 	<jsp:include page="admin-side-bar.jsp" />
 	<div class="main-panel">
 		<jsp:include page="users-nav-bar.jsp" />
 	
 	
 		<div class="content">
            <div class="container-fluid">
        		
    			<!-- subject color form -->
    			<div class="row">                    
                   <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Add Subject</h4>
                            </div>
                            <div class="content">
                                <f:form modelAttribute="subject" method="post"  action="${pageContext.request.contextPath}/admin/create/subject">                                    
                                    <input type="hidden" name="action" value="${action}"/>
                                    <f:input type="hidden" path="idSubject" />
                                    <div class="row">     
                                    	<div class="col-md-6">
                                            <div class="form-group">
                                                <label>Subject Name</label>
                                                <f:input path="title" type="text"  class="form-control" value="" />
                                            </div>
                                        </div>                                                                                                           
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <div class="form-group">
	                                              <label for="sel1">Subject Type </label>
	                                              <f:select path="type" class="form-control" id="sel1">
	                                                	<option value="Elective" <c:if test="${subject.type == 'Elective'}"> selected </c:if> >Elective</option>
	                                                	<option value="Compulsory" <c:if test="${subject.type == 'Compulsory'}"> selected </c:if>>Compulsory</option>
	                                              </f:select>
	                                            </div>
                                            </div>
                                        </div>
                                    </div>                                    
                                    <button type="submit" class="btn btn-info btn-fill pull-right">Create</button>
                                    <div class="clearfix"></div>
                                </f:form>
                            </div>
                        </div>
                    </div> 
                </div>              
        		
        		<!-- subject color list -->
        		<div class="row">                    
                    <div class="card user-card">
                        <div class="table-responsive">        						
        				  <table id="myTable" class="display table" width="100%" >
                               <thead>
                                  <tr>
                                     <th>Subject Name</th><th>Subject Type</th><th></th><th></th>
                                  </tr>
                               </thead>
                               <tbody>
                                 	<c:forEach items="${subjects}" var="c">
                                     <tr>                                       
                                        <td>${c.title}</td>
                                        <td>${c.type}</td>
                                        <td>
                                          <a type="button" class="btn btn-info btn-xs" href="${pageContext.request.contextPath}/admin/edit/subject?idSubject=${c.idSubject}">
                                             <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                                 modify
                                          </a>
                                        </td>
                                        <td>
                                          <a type="button" class="btn btn-danger btn-xs" href="${pageContext.request.contextPath}/admin/delete/subject?idSubject=${c.idSubject}">
                                             <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                                                 delete
                                          </a>
                                        </td>
                                      </tr>
                                     </c:forEach>
                               </tbody>
                           </table>         					
        			    </div>    
                	</div>                    
                </div>
        		     	
        	
        	</div>
        </div>
       
        
 	</div>  
 </div> 
   
</body>

<script src="<c:url value="/resources/js/jquery.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/dataTables.bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.dataTables.min.js"/>"></script>
<script>
$(document).ready(function(){
    $('#myTable').dataTable();
});
</script>
</html>