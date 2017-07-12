<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<body>
<form:form modelAttribute="newUser" action="/register" method="post">

    <h1>Register</h1>

    <label>Username</label>
    <form:input name="username" path="username" type="text"/>
    <br/>
    <label>E Mail</label>
    <form:input name="email" path="email" type="text"/>
    <br/>
    <label>Phone</label>
    <form:input name="phone" path="phone" type="text"/>
    <br/>
    <label>Password</label>
    <form:input path="password" name="password" type="password"/>
    <br/>
    <input type="submit" value="Register"/>

</form:form>
</body>

</html>