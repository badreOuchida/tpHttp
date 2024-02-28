<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script>
        function getQueryParam(parameterName) {
            const urlParams = new URLSearchParams(window.location.search);
            return urlParams.get(parameterName);
        }

        const status = getQueryParam('status');
        if (status !== null) {
            console.log('Status:', status);

            
            switch (status) {
                case '403':
                    alert('Access Forbidden! You do not have permission to access this page.');
                    break;
                case '400':
                	alert('Invalid Input');
                default:
                    console.log('Unhandled status:', status);
            }
        } else {
            console.log('Status parameter not present.');
        }
</script>
</head>
<body>


<center>
	<h1> Tenter votre chance a cette lotterie virtuelle!</h1>
</center>
<form action = "./hello" method="post">
 Votre nom svp: <input type = "TEXT" name = "nom"><br>
 <br>
 <center><input type = "SUBMIT" name = "Submit Query"></center>
</form>

</body>
</html>