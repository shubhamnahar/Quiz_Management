<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel ="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>" />
<title>Login Page</title>
</head>
<body>

<form autocomplete='off' class='form' action ="login" method="post">
  <div class='control'>
    <h1>
      Sign In
      	${SPRING_SECURITY_LAST_EXCEPTION.message}
    </h1>
  </div>
  <div class='control block-cube block-input'>
    <input name='username' placeholder='Username' type='text'>
    <div class='bg-top'>
      <div class='bg-inner'></div>
    </div>
    <div class='bg-right'>
      <div class='bg-inner'></div>
    </div>
    <div class='bg'>
      <div class='bg-inner'></div>
    </div>
  </div>
  <div class='control block-cube block-input'>
    <input name='password' placeholder='Password' type='password'>
    <div class='bg-top'>
      <div class='bg-inner'></div>
    </div>
    <div class='bg-right'>
      <div class='bg-inner'></div>
    </div>
    <div class='bg'>
      <div class='bg-inner'></div>
    </div>
  </div>
  <button class='btn block-cube block-cube-hover' type='submit' name='submit' value='submit'>
    <div class='bg-top'>
      <div class='bg-inner'></div>
    </div>
    <div class='bg-right'>
      <div class='bg-inner'></div>
    </div>
    <div class='bg'>
      <div class='bg-inner'></div>
    </div>
    <div class='text'>
      Log In
    </div>
  </button>
</form>

</body>
</html>