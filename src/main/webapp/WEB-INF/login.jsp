<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<body>
<h1>Login</h1>
<form action="/login" method="post">

    <h1>${welcome}</h1>

    <c:if test="${error!=null}">
        <span>${error}</span>
        <br/>
        <br/>
    </c:if>
    <c:if test="${logout!=null}">
        <span>${logout}</span>
        <br/>
        <br/>
    </c:if>
    <label>Username</label>
    <input name="username" path="username" type="text"/>
    <br/>
    <label>Password</label>
    <input name="password" type="password"/>
    <br/>
    <input type="submit" value="Sign in"/>

</form>
</body>

</html>