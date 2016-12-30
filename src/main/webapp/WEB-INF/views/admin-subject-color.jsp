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
                                <h4 class="title">Add Subject Color</h4>
                            </div>
                            <div class="content">
                                <f:form modelAttribute="subjectColor" method="post"  action="${pageContext.request.contextPath}/admin/create/color">                                    
                                    <input type="hidden" name="action" value="${action}"/>
                                    <f:input type="hidden" path="idSubjectColor" />
                                    <div class="row">                                                                            
                                        <div class="col-md-4">
                                            <div class="form-group">
                                              <label for="sel1">Day </label>
                                              <f:select path="day" class="form-control" id="sel1">
                                                <option value="Monday" <c:if test="${subjectColor.day == 'Monday'}"> selected </c:if> >Monday</option>
                                                <option value="Tuesday" <c:if test="${subjectColor.day == 'Tuesday'}"> selected </c:if> >Tuesday</option>
                                                <option value="Wednesday" <c:if test="${subjectColor.day == 'Wednesday'}"> selected </c:if> >Wednesday</option>
                                                <option value="Thursday" <c:if test="${subjectColor.day == 'Thursday'}"> selected </c:if> >Thursday</option>
                                                <option value="Friday" <c:if test="${subjectColor.day == 'Friday'}"> selected </c:if> >Friday</option>
                                                <option value="Saturday" <c:if test="${subjectColor.day == 'Saturday'}"> selected </c:if> >Saturday</option>
                                              </f:select>
                                            </div>
                                        </div>                                        
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <div class="form-group">
	                                              <label for="sel1">Week </label>
	                                              <f:select path="week" class="form-control" id="sel1">
	                                                	<option value="weekA" <c:if test="${subjectColor.week == 'weekA'}"> selected </c:if> >week A</option>
	                                                	<option value="weekB" <c:if test="${subjectColor.week == 'weekB'}"> selected </c:if>>week B</option>
	                                              </f:select>
	                                            </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Start Time</label>
                                                <f:input path="startTime" type="time"  class="form-control" value="" />
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Finish Time</label>
                                                <f:input path="finishTime" type="time"  class="form-control" value="" />
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                              <label>Color</label>
                                              <f:select path="color" class="form-control" id="sel1">
                                                <option value="#3498db" <c:if test="${subjectColor.color == '#3498db'}"> selected </c:if> >Blue</option>
                                                <option value="#e74c3c" <c:if test="${subjectColor.color == '#e74c3c'}"> selected </c:if> >Red</option>
                                                <option value="#f1c40f" <c:if test="${subjectColor.color == '#f1c40f'}"> selected </c:if> >Yellow</option>
                                                <option value="#9b59b6" <c:if test="${subjectColor.color == '#9b59b6'}"> selected </c:if> >Purple</option>
                                                <option value="#2ecc71" <c:if test="${subjectColor.color == '#2ecc71'}"> selected </c:if> >Green</option>
                                                <option value="#bdc3c7" <c:if test="${subjectColor.color == '#bdc3c7'}"> selected </c:if> >Grey</option>
                                                <option value="#fff" <c:if test="${subjectColor.color == '#fff'}"> selected </c:if> >White</option>
                                              </f:select>
                                            </div>
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-warning btn-fill pull-right">Create</button>
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
                                     <th>Color</th><th>Day</th><th>Start Time</th><th>Finish Time</th><th>week</th><th></th><th></th>
                                  </tr>
                               </thead>
                               <tbody>
                                 	<c:forEach items="${colors}" var="c">
                                     <tr>								
                                        <td style="background-color=${c.color} !important;"><div style="background-color=${c.color};width=100%;"></div></td>	
                                        <td>${c.day}</td>
                                        <td>${c.getFormattedStartTime()}</td>
                                        <td>${c.getFormattedFinishTime()}</td>
                                        <td>${c.week}</td>
                                        <td>
                                          <a type="button" class="btn btn-info btn-xs" href="${pageContext.request.contextPath}/admin/edit/color?idSubjectColor=${c.idSubjectColor}">
                                             <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                                 modify
                                          </a>
                                        </td>
                                        <td>
                                          <a type="button" class="btn btn-danger btn-xs" href="${pageContext.request.contextPath}/admin/delete/color?idSubjectColor=${c.idSubjectColor}">
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
