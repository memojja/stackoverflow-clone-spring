<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<body>
    <h1>Welcome! ${pageContext.request.userPrincipal.name}</h1>

    <a href="/login?logout=true"><button>Çıkış Yap</button></a>

</body>

</html>