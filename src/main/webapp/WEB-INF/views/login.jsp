<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
        <link href="<c:url value='/resources/css/bootstrap.css' />"  rel="stylesheet"></link>
        <link href="<c:url value='/resources/css/main.css' />" rel="stylesheet"></link>
        <link href="<c:url value='/resources/fonts/font-awesome.min.css' />"  rel="stylesheet"></link>
        <link href="<c:url value='/resources/css/error.css' />" rel="stylesheet"></link>
    </head>
 
 <body>
    
    <div class="container-fluid">
			<div class="row">
				<div class="col-md-push-4 col-md-4 col-sm-push-3 col-sm-6 col-sx-12">
					
					<!-- Header end -->
					<div class="login-container">
						<div class="login-wrapper animated flipInY">
							
							
							<!-- login form -->
							
							<div id="login" style="margin-top: 200px;" class="show">
								<div class="row">
									<c:if test="${message != null}">
									   <div class="col-md-4 col-md-offset-4">
									   		<div class="alert alert-${template}"><span class="center">${message}</span></div>
									    </div>
									</c:if>
								</div>
								<div class="login-header">
									<h4>Sign In To Your Account</h4>
								</div>
								<c:url var="loginUrl" value="/login" />
                        		<form action="${loginUrl}" method="post">
                        			<c:if test="${param.error != null}">
	                                <div class="alert alert-danger">
		                                    <p>Invalid email or password.</p>
		                                </div>
		                            </c:if>
									<div class="form-group has-feedback">
										<label class="control-label" for="userName">EMAIL</label>
										<input type="email" class="form-control" name="login" placeholder="EMAIL" autofocus>
										<i class="fa fa-user text-info form-control-feedback"></i>
									</div>
									<div class="form-group has-feedback">
										<label class="control-label" for="passWord">PASSWORD</label>
										<input type="password" class="form-control" name="password" placeholder="*********" >
										<i class="fa fa-key text-danger form-control-feedback"></i>
									</div>
									 <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
									<input type="submit" value="SIGN IN" class="btn btn-danger btn-lg btn-block">
								</form>
								<div style="margin-top: 20px;">
									<a href="#forgot-pwd" class="underline text-info">Forgot Password?</a>
									<span style="float: right;">
										<a href="#register">Don't have an account? <span class="text-danger">SIGN UP</span></a>
									</span>
								</div>
							</div>

							<!-- Registration form -->

							<div id="register" style="margin-top: 20px;" class="form-action hide">
								<div class="login-header">
									<h4>Sign Up for Everest</h4>
								</div>
								 <f:form modelAttribute="registrationForm"  action="${pageContext.request.contextPath}/register" enctype="multipart/form-data">
									<div class="form-group has-feedback">
								       <label class="control-label" for="userName1">PROFESION</label>
											<f:select path="profession" id="checked" class="form-control input-sm">
												<option></option>												
												<option value="STUDENT">STUDENT</option>
												<option value="TEACHER">TEACHER</option>
											</f:select>
									</div>	
									<div class="form-group has-feedback">
										<label class="control-label" for="userName1">FULL NAME</label>
										<f:input path="fullName" type="text" class="form-control" id="userName1" />
										<span id="helpBlock" class="help-block"><f:errors path="fullName" cssClass="errors"></f:errors></span>
									</div>
									<div class="form-group has-feedback">
										<label class="control-label" for="userName1">EMAIL (LOGIN)</label>
										<f:input path="login" type="email" class="form-control" id="userName1" />
										<span id="helpBlock" class="help-block"><f:errors path="fullName" cssClass="errors"></f:errors></span>
									</div>
									<div id="year">						
									<div  class="form-group has-feedback">
										<label class="control-label" for="userName1">YEAR</label>
										<f:select path="year" class="form-control" >	
			                              <option value="1">1st YEAR</option>
			                              <option value="2">2sd YEAR</option>
		                                </f:select>
										<span id="helpBlock" class="help-block"><f:errors path="year" cssClass="errors"></f:errors></span>
									</div>									
									</div>	
									<div class="form-group has-feedback">
										<label class="control-label" for="userName1">SCHOOL EMAIL</label>
										<f:input path="schoolEmail" type="email" class="form-control" id="userName1" />	
										<span id="helpBlock" class="help-block"><f:errors path="schoolEmail" cssClass="errors"></f:errors></span>										
									</div>
									<div class="form-group has-feedback">
										<label class="control-label" for="userName1">PASSWORD</label>
										<f:input path="password" type="password" class="form-control" id="password1" />
										<span id="helpBlock" class="help-block"><f:errors path="password" cssClass="errors"></f:errors></span>
									</div>
									<div class="form-group has-feedback">
										<label class="control-label" for="password1">CONFIRM PASSWORD</label>
										<input type="password" class="form-control" id="password2">										
									</div>
									<div class="form-group has-feedback">
										<label class="control-label" for="picture">PICTURE</label>
										<input type="file" name="file" class="form-control" id="">
									</div>
									<div class="form-group has-feedback">
										<label class="control-label" for="password2">POSITION</label>
										<f:input path="position" type="text" class="form-control" id="poisition" />
									</div>
									<input type="submit" value="Next" class="btn btn-danger btn-lg btn-block">
								</f:form>
								<div style="margin-top: 20px;">
									<a  href="#login">Already have an account? <span style="float: right;" class="text-danger">Sign In</span></a>
								</div>
							</div>						
							
							
							<!-- forgot Password form -->
							
							<div id="forgot-pwd" style="margin-top: 150px;" class="form-action hide">
								<div class="login-header">
									<h4>Reset your Password</h4>
								</div>
								<form action="Etudiant.html">
									<div class="form-group has-feedback">
										<label class="control-label" for="password3">Password</label>
										<input type="text" class="form-control" id="password3">
										<i class="fa fa-key form-control-feedback"></i>
									</div>
									<div class="form-group has-feedback">
										<label class="control-label" for="password4">Confirm password</label>
										<input type="text" class="form-control" id="password4">
										<i class="fa fa-key form-control-feedback"></i>
									</div>
									<input type="submit" value="Reset" class="btn btn-danger btn-lg btn-block">
								</form>
								<div style="margin-top: 20px;">
									<a href="#register">Don't have an account? <span style="float: right;" class="text-danger">Sign Up</span></a>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
     
   		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="<c:url value='/resources/js/jquery.js' />"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="<c:url value='/resources/js/bootstrap.min.js' />"></script>

		<script type="text/javascript">
			(function($) {
				// constants
				var SHOW_CLASS = 'show',
					HIDE_CLASS = 'hide',
					ACTIVE_CLASS = 'active';
				
				$('a').on('click', function(e){
					e.preventDefault();
					var a = $(this),
					href = a.attr('href');
				
					$('.active').removeClass(ACTIVE_CLASS);
					a.addClass(ACTIVE_CLASS);

					$('.show')
					.removeClass(SHOW_CLASS)
					.addClass(HIDE_CLASS)
					.hide();
					
					$(href)
					.removeClass(HIDE_CLASS)
					.addClass(SHOW_CLASS)
					.hide()
					.fadeIn(550);
				});
				
				$('#year').hide();
				$("#checked").on("click" , function(){
					var checked = $('#checked').find(":selected").text();
					if(checked == "STUDENT"){
                    	$("#year").show();
                	}
                	if(checked == "TEACHER"){
                    	$("#year").hide();
                	}
				});
			})(jQuery);
		</script>
		
	</body>
</html>