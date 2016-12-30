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
        <link href="<c:url value='/resources/css/tooltipster.bundle.min.css' />" rel="stylesheet"></link>
        <link href="<c:url value='/resources/css/tooltipster-sideTip-shadow.min.css' />" rel="stylesheet"></link>
        <link href="<c:url value='/resources/css/teacher-card.css' />" rel="stylesheet"></link>
    </head>
 
 <body>
 
 <div class="wrapper">	
 	<jsp:include page="student-side-bar.jsp" />
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
       
       <div id="profs"></div>
        
 	</div>  
 </div> 
   
</body>

<script src="<c:url value="/resources/js/jquery-1.10.2.js"/>"></script>
<script src="<c:url value="/resources/js/tooltipster.bundle.min.js"/>" ></script>
<script type="text/javascript">
       $(document).on('ready', function() {
           $('.tooltipster').tooltipster({
               contentCloning: true,
               theme : 'tooltipster-shadow'
           });
       });
</script>
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
	var URL = "http://localhost:8080/SchoolMgmt/rest/user/schedule?week="+week+"&id="+id;
	
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

		  var html = '<div class="tooltip_templates">'+
          '<div class="row" id="tooltip_content'+tdId+'">'+
              '<div class="col-md-4 col-sm-6">'+
                  '<div class="card-style">'+
                      '<div class="media">'+
                          '<div class="media-left">'+
                              '<img class="media-object img-thumbnail card-img" src="http://localhost:8080/SchoolMgmt/image?id='+data[i].id +'" />'+
                          '</div>'+
                          '<div class="media-body">'+
                              '<a href="#" ><h5 class="media-heading">'+data[i].teacher +'</h5></a>'+
                              '<div class="members pull-left">'+data[i].day +'</div>'+
                          '</div>'+
                      '</div>'+
                  '</div>'+
              '</div>'+
          '</div>'+                        
          '</div>';      

   		console.log('hello');	

		$( "#" + tdId ).attr('class', "tooltipster");
		$( "#" + tdId ).attr('data-tooltip-content',"#tooltip_content"+tdId);
		$( "#" + tdId ).css("background-color", ""+data[i].color);
		$( "#profs" ).append(html);		

		}
		
		$( "#profs" ).hide();
	});
}
</script>
</html>