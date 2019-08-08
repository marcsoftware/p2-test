<!DOCTYPE html>
<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <title>register</title>
	
	    <!-- Javascript Files -->
	    <script type="text/javascript" src="resource/js/angular_v1.6.0.js"></script>	    	   
	    <script type="text/javascript" src="resource/js/form.js"></script>
	
	    <!-- CSS Styling -->
	    <style type="text/css">
	        .cssStyling {
	            color: green;
	            font-size: larger;	            
	        }
	    </style>
	</head>
	<body>
	    <h1>Register</h1>
	    <div ng-app="myApp">
	        <form ng-controller="UserController" ng-submit="sendData()">
	            <p>
	                <label>Enter your name: </label>
					<input id="user_name" type="text" ng-model="name" placeholder="User Name" 
					onblur="this.placeholder = 'User Name'" onfocus="this.placeholder = ''" />
				</p>
				
				<p>
	                <label>Enter your password: </label>
					<input id="password" type="text" ng-model="password" placeholder="password" 
					onblur="this.placeholder = 'password'" onfocus="this.placeholder = ''" />
	            </p>
	            <p>
	                <button id="formBtn" type="submit">Submit</button>
	            </p>
	            <!-- Display's Output On The Screen -->
	            <p>
	            	<span id="welcomeText" class="cssStyling">{{msgFromServlet}}</span>
	        	</p>
	        </form>	        
	    </div>
	</body>
</html>