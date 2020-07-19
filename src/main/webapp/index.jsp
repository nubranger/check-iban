<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>IBAN Check</title>
</head>
<body>

<form action="check" method="POST">
    IBAN: <input style="width: 200px" type="text" name="numberIBAN" value="">

    <input type="submit" value="Check"><br><hr>

    <%
        String numberIBAN = request.getParameter("numberIBAN");
        String statusIBAN = request.getParameter("statusIBAN");

        if (numberIBAN == null || statusIBAN == null) {
    %>
    <h1> Enter IBAN </h1>
    <%
    } else if (statusIBAN.equals("false")) {
    %>
    <h1 style="color: red">Entered IBAN is not valid</h1>
    <%
    } else {
    %>
    <h1 style="color: green"><%=numberIBAN%></h1>
    <h1>Entered IBAN is valid</h1>
<%--    <a href="${pageContext.request.contextPath}/rest/<%=numberIBAN%>">REST var check</a><br>--%>
    <a href="${pageContext.request.contextPath}/rest.jsp">REST list check</a><br>
    <a href="http://localhost:8080/ws/soap.wsdl">SOAP wsdl file</a>
    <%
        }
    %>
</form>

</body>
</html>