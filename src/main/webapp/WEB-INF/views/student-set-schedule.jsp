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
    </head>
 
 <body>
 
 <div class="wrapper">	
 	<jsp:include page="student-side-bar.jsp" />
 	<div class="main-panel">
 		<jsp:include page="users-nav-bar.jsp" />
 	
		
		<div class="content">              
            <div class="container-fluid">            
                <div class="row">
                    
                    <div class="col-md-8">                        
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Edit Schedule</h4>
                            </div>
                            <div class="content">
                                <f:form method="post" action="${pageContext.request.contextPath}/student/update/schedule">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                              <label for="sel1">Subject Color </label>                                              
                                              <select id="select" name="idColor" class="form-control" id="sel1">
                                              	  <option></option>
	                                              <c:forEach items="${colors}" var="c">
	                                                <option value="${c.idSubjectColor }" 
	                                                		data-day="${c.day }"
	                                                		data-startTime="${c.getFormattedStartTime() }"
	                                                		data-finishTime="${c.getFormattedFinishTime() }"
	                                                		data-week="${c.week }"
	                                                		data-color="${c.color }"
	                                                		>${c.color }</option>
	                                              </c:forEach>                                      
                                              </select>
                                            </div>                                        
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                              <label for="sel1">Teacher </label>                                              
                                              <select name="idTeacher" class="form-control" id="sel1">
                                              	  <option></option>
	                                              <c:forEach items="${teachers}" var="t">
	                                                <option value="${t.idUser }">${t.fullName }</option>
	                                              </c:forEach>
                                              </select>
                                            </div>                                        
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                              <label for="sel1">Subject</label>
                                              <select name="idSubject" class="form-control" id="sel1">
                                              		<option></option>
                                              	  <c:forEach items="${subjects}" var="t">
	                                                <option value="${t.idSubject }">${t.title }</option>
	                                              </c:forEach>
                                              </select>
                                            </div>                                        
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-info btn-fill pull-right">Set</button>
                                    <div class="clearfix"></div>
                                </f:form>
                            </div>
                        </div>
                    </div>                    
                    
                    <div class="col-md-4"  >
                        <div class="color-div"  class="card card-outline-primary text-xs-center">
                            <div class="card card-outline-primary text-xs-center">
                              
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
		                                     <th>Color</th><th>Day</th><th>Start Time</th><th>Finish Time</th><th>week</th><th>Teacher</th><th>Subject</th><th></th><th></th>
		                                  </tr>
		                               </thead>
		                               <tbody>
		                                 	<c:forEach items="${schedule}" var="c">
		                                     <tr>								
		                                        <td style="background-color=${c.subjectColor.color} !important;"><div style="background-color=${c.subjectColor.color};width=100%;"></div></td>	
		                                        <td>${c.subjectColor.day}</td>
		                                        <td>${c.subjectColor.getFormattedStartTime()}</td>
		                                        <td>${c.subjectColor.getFormattedFinishTime()}</td>
		                                        <td>${c.subjectColor.week}</td>
		                                        <td>${c.teacher.fullName}</td>
		                                        <td>${c.subject.title}</td>
		                                        <td>
		                                          <!--  a type="button" class="btn btn-info btn-xs" href="">
		                                             <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
		                                                 modify
		                                          </a -->
		                                        </td>
		                                        <td>
		                                          <a type="button" class="btn btn-danger btn-xs" href="${pageContext.request.contextPath}/student/delete/schedule?idScheduleAssoc=${c.idScheduleAssoc}">
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
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/dataTables.bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.dataTables.min.js"/>"></script>
<script>
$(document).ready(function(){
    $('#myTable').dataTable();
});
</script>
<script type="text/javascript">
$(function () {
	 
	$('.color-div').hide();

	$('#select').on("change",function () {     
		
		  var color = $("option:selected", this).data('color');
		  var startTime = $("option:selected", this).data('starttime');
		  var finishTime = $("option:selected", this).data('finishtime');
		  var week = $("option:selected", this).data('week');
		  var day = $("option:selected", this).data('day');

		  $( '.color-div' ).css("background-color", ""+color);
		  
		  var html = '<div class="card-block" >' +
				          '<blockquote style="color:#fff" class="card-blockquote" >' +
				          '<p style="font-size:20px;">'+day+'</p>'+
				          '<p style="font-size:14px;">'+week+'</p>'+
				          '<footer style="font-size:15px;color:#fff;">start time : '+startTime+'</footer>'+
				          '<footer style="font-size:15px;color:#fff;">finish time : '+finishTime+'</footer>'+
				          '</blockquote>'+
				      '</div>';

	      $('.color-div').html(html);
	      $('.color-div').show();
	  }) 
	    
});


</script>
</html>