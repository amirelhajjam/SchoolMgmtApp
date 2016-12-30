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
        		
        			<input type="hidden" id="userId" value="${userId }" > 
        		
    			    <div style="padding:20px;" class="card user-card">		
				 		<div class="btn-group" role="group" aria-label="Basic example">
				          <button id="weekAButton" type="button" class="btn btn-primary btn-secondary">WEEK A</button>
				          <button id="weekBButton" type="button" class="btn btn-primary btn-secondary">WEEK B</button>
				        </div>
			        </div>
			        
			        <div id="weekA" class="content" >
			            <div class="container-fluid">
			                <div class="row"> 
			                    <div class="col-md-12">
			                        <div class="table-container">
			                        <table class="table table-bordered" id="idTable">
			                            <thead>	                                    
				                            <th colspan="8" style="hight:10px;"><center>WEEK A</center></th>	                                    
			                            </thead>
			                            <tbody>
			                                <tr>
				                               <th></th>
				                               <th>Monday</th>
				                               <th>Tuesday</th>
				                               <th>Wednesday</th>
				                               <th>Thursday</th>
				                               <th>Friday</th>
				                               <th>Saturday</th>
			                                   <th>Sunday</th>
				                            </tr>                                        
			                            </tbody>                                   
			                        </table> 
			                        </div> 
			                    </div>
			                </div>
			            </div>
			        </div>
			        
			        <div id="weekB" class="content" >
			            <div class="container-fluid">
			                <div class="row"> 
			                    <div class="col-md-12">
			                        <div class="table-container">
			                        <table class="table table-bordered" id="idTable">
			                            <thead>	                                    
				                            <th colspan="8" style="hight:10px;"><center>WEEK B</center></th>	                                    
			                            </thead>
			                            <tbody>
			                                <tr>
				                               <th></th>
				                               <th>Monday</th>
				                               <th>Tuesday</th>
				                               <th>Wednesday</th>
				                               <th>Thursday</th>
				                               <th>Friday</th>
				                               <th>Saturday</th>
			                                   <th>Sunday</th>
				                            </tr>                                        
			                            </tbody>                                   
			                        </table> 
			                        </div> 
			                    </div>
			                </div>
			            </div>
			        </div>	
        		        	
        	</div>
        </div>
       
        
 	</div>  
 </div> 
   
</body>

<script src="<c:url value="/resources/js/jquery.js"/>"></script>
<script type="text/javascript">
$(function(){  

	getWeekSchedule("weekA");    
    getWeekSchedule("weekB");

    $("#weekA").show();        
    $("#weekB").hide();
    
    $('#weekBButton').click(function(){
        $("#weekA").hide();        
        $("#weekB").show();
    });
    
    $('#weekAButton').click(function(){
        $("#weekB").hide();
        $("#weekA").show();
    });		
  
});

function getWeekSchedule(week){

	var id = $( "#userId" ).val();
	var URL = "http://localhost:8080/SchoolMgmt/rest/teacher/schedule?week="+week+"&id="+id;
	
	$.get(URL, function(data, status){ 
		
		for (var i = 0; i < data.length; i++) {	

			if($( "#Monday_" + data[i].startTime ).length == 0){
				        
		    trElem ='<tr>' +
		            	'<td id="">'+data[i].startTime+':'+data[i].startTimeMinute+'-'+data[i].finishTime+':'+data[i].finishTimeMinute+'</td>'+
		                '<td id="Monday_'+data[i].startTime+'"></td>'+
		                '<td id="Tuesday_'+data[i].startTime+'"></td>'+
		                '<td id="Wednesday_'+data[i].startTime+'"></td>'+
		                '<td id="Thursday_'+data[i].startTime+'"></td>'+
		                '<td id="Friday_'+data[i].startTime+'"></td>'+
		                '<td id="Saturday_'+data[i].startTime+'"></td>'+
		                '<td id="Sunday_'+data[i].startTime+'"></td>'+
		            '</tr>';
		  	$('#'+ week + ' #idTable tr:last').after(trElem);

			}
			
		}		

		for (var i = 0; i < data.length; i++) {			
			tdId = data[i].day + "_" + data[i].startTime;
     		$( "#" + tdId ).css("background-color", ""+data[i].color);		
		}
		
		//$( "#profs" ).hide();
	});
}
</script>


</html>
