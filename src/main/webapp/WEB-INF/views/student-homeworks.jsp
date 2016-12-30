<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Page</title>
        <link href="<c:url value='/resources/css/bootstrap.css' />"  rel="stylesheet"></link>
        <link href="<c:url value='/resources/css/animate.min.css' />" rel="stylesheet"></link>
        <link href="<c:url value='/resources/fonts/font-awesome.min.css' />"  rel="stylesheet"></link>
        <link href="<c:url value='/resources/css/error.css' />" rel="stylesheet"></link>
        <link href="<c:url value='/resources/css/light-bootstrap-dashboard.css' />" rel="stylesheet"></link>
        <link href="<c:url value='/resources/css/demo.css' />" rel="stylesheet"></link>
        <link href="<c:url value='/resources/css/style-blog.css' />" rel="stylesheet"></link>
        <link href="<c:url value='/resources/css/jquery.dataTables.min.css' />" rel="stylesheet"></link>
        <link href="<c:url value='/resources/css/teacher-card.css' />" rel="stylesheet"></link>
    </head>
 
 <body>
 
 <div class="wrapper">	
 	<jsp:include page="student-side-bar.jsp" />
 	<div class="main-panel">
 		<jsp:include page="users-nav-bar.jsp" />
 	
 	
 		<div class="content">
            <div class="container-fluid">
        		
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
                                     	<td>${c.homework.title}</td>
                                        <td>${c.homework.subject.title}</td>
                                        <td>${c.homework.dueDate}</td>
                                        <td>${c.homework.duration}</td>
                                        <td>
                                          <a type="button" class="btn btn-info btn-xs homework-info" 
                                          		data-teacher="${c.homework.teacher.fullName}"  
                                          		data-subject="${c.homework.subject.title}" 
                                          		data-duedate="${c.homework.dueDate}"
                                          		data-date="${c.homework.date}"
                                          		data-duration="${c.homework.duration}"
                                          		data-idteacher="${c.homework.teacher.idUser}" 
                                          		data-description="${c.homework.description}" 
                                          		data-toggle="modal" 
                                          		data-target="#myModal">
                                             <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                                                 details
                                          </a>
                                        </td>
                                        <td>
                                          <a type="button" class="btn btn-success btn-xs" >
                                             <span class="glyphicon glyphicon-check" aria-hidden="true"></span>
                                                 done
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
 
 
 <!-- Modal -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="container">    
		<div class="row">
			<div class="col-md-8">				
				<div class="panel panel-default  panel--styled" style="background: #e74c3c;">
					<div class="panel-body">
						<div class="col-md-12 panelTop">	
							<div class="col-md-4 image">	
								
							</div>
							<div class="col-md-8">	
								<h3 id="teacher"></h3>
								<h3 id="subject"></h3>
								<h4><small  id="duedate"></small></h4>
								<h4><small  id="duration"></small></h4>
							</div>
						</div>
						
						<div class="col-md-12 panelTop">
							<div class="col-md-12">	
								<h2>what to do</h2>
								<p id="description"></p>
							</div>
						</div>
						
						<div class="col-md-12 panelBottom">
						    <form>
							<div class="col-md-8 text-center">
								<div class="form-group row">
                                  <label for="example-text-input" class="col-xs-5 col-form-label">Change date :</label>
                                  <div class="col-xs-7">
                                    <input name="date" id="date-to-do" type="date"  class="form-control" value="" />
                                  </div>
                                </div>						
							</div>
							<div class="col-md-4">								
								<button type="submit" class="btn btn-warning btn-fill">change</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
							</div>
							</form>
						</div>
						
					</div>
				</div>
			</div>
		</div>
    </div>
    </div>
  
   
</body>

<script src="<c:url value="/resources/js/jquery.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/dataTables.bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.dataTables.min.js"/>"></script>
<script>
$(document).ready(function(){
    $('#myTable').dataTable();
});
$(document).on("click", ".homework-info", function () {
	    var teacher =  $(this).data('teacher');
		var subject = $(this).data('subject');
		var duedate = $(this).data('duedate');
		var date    = $(this).data('date');
		var duration = $(this).data('duration');
		var idteacher= $(this).data('idteacher');
		var description= $(this).data('description'); 

		$('.panel--styled .image').html('<img class="img-responsive" src="http://localhost:8080/SchoolMgmt/image?id='+idteacher+'" alt=""/>');
        
		$('.panel--styled #teacher').text('Teacher :' + teacher);
		$('.panel--styled #subject').text('Subject : ' + subject);
		$('.panel--styled h4 #duedate').text('due date :' +duedate);
		$('.panel--styled h4 #duration').text('duration : '+duration+ ' min');
		$('.panel--styled #description').text(description);
		
		$('.panel--styled #date-to-do').val(date);
		
		$('.panel--styled h4 #duedate').css('color' ,"#fff");
		$('.panel--styled h4 #duration').css('color',"#fff");
});
</script>
</html>