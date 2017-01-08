<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teacher Page</title>
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
 	<jsp:include page="teacher-side-bar.jsp" />
 	<div class="main-panel">
 		<jsp:include page="users-nav-bar.jsp" />
 	
 	
 		<div class="content">
            <div class="container-fluid">
        		
	    			<!-- subject color form -->
	    			<div class="row">                    
	                   <div class="col-md-12">
	                        <div class="card">
	                            <div class="header">
	                                <h4 class="title">Assign New Homework</h4>
	                            </div>
	                            <div class="content">
	                                <f:form modelAttribute="homework" method="post"  action="${pageContext.request.contextPath}/teacher/assign/homework">                                   
	                                    <input type="hidden" name="action" value="${ action }">	            
	                                    <c:if test="${ action == 'update' }"> 
		                                    <input type="hidden" name="idSubject" value="${ idSub }"/>
		                                    <f:input type="hidden" path="idHomework"/>
		                                    <f:input type="hidden" path="creationDate"/>
		                                    <f:input type="hidden" path="date"/>
		                                </c:if>
	                                    <div class="row">                                                                            
	                                        <div class="col-md-4">
	                                            <div class="form-group">
	                                                <label>Title</label>
	                                                <f:input path="title" type="text"  class="form-control" value="" />
	                                            </div>
	                                        </div>                                        
	                                        <div class="col-md-4">
	                                            <div class="form-group">
	                                                <label>Due Date</label>
	                                                <f:input path="dueDate" type="date"  class="form-control" value="" />
	                                            </div>
	                                        </div> 
	                                        <div class="col-md-4">
	                                            <div class="form-group">
	                                              <label>Subject</label>
	                                              <select name="idSubject" <c:if test="${ action == 'update' }"> disabled </c:if> class="form-control" id="sel1">
	                                              	  <c:forEach items="${subjects}" var="t">	                                              	  
		                                                <option <c:if test="${t.idSubject == idSub }"> selected disabled </c:if> value="${t.idSubject }">${t.title }</option>
		                                              </c:forEach>		                                              
	                                              </select>
	                                            </div>
	                                        </div>
	                                    </div>
	                                    <div class="row">
	                                        <div class="col-md-4">
	                                            <div class="form-group">
	                                                <label>Estimated Time</label>
	                                                <f:input path="duration" type="number"  class="form-control" placeholder="35 min" value="" />
	                                            </div>
	                                        </div>                                       
	                                    </div>
	                                    <div class="row">
	                                    	<div class="col-md-10">
		                                        <div class="form-group">
		                                            <label>Description</label>
		                                            <f:textarea path="description" rows="5" class="form-control" placeholder="hello world sports " value=""></f:textarea>
		                                        </div>
		                                    </div>
	                                    </div>	                                    
	                                    <button type="submit" class="btn btn-info btn-fill pull-right">Assign</button>
	                                    <div class="clearfix"></div>
	                                </f:form>
	                            </div>
	                        </div>
	                    </div> 
	                </div>                
        		        	
        		   
        		    <!-- teacher homework list -->
        		<div class="row">                    
                    <div class="card user-card">
                        <div class="table-responsive">        						
        				  <table id="myTable" class="display table" width="100%" >
                               <thead>
                                  <tr>
                                     <th>Title</th><th>Subject</th><th>Due Date</th><th>Duration</th><th></th><th></th>
                                  </tr>
                               </thead>
                               <tbody>
                                 	<c:forEach items="${homeworks}" var="c">
                                     <tr>
                                     	<td>${c.title}</td>
                                        <td>${c.subject.title}</td>
                                        <td>${c.dueDate}</td>
                                        <td>${c.duration}</td>
                                        <td>
                                          <a type="button" class="btn btn-info btn-xs" href="${pageContext.request.contextPath}/teacher/update/homework?idHomework=${c.idHomework}">
                                             <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                                 modify
                                          </a>
                                        </td>
                                        <td>
                                          <a type="button" class="btn btn-danger btn-xs" href="${pageContext.request.contextPath}/teacher/delete/homework?idHomework=${c.idHomework}">
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
