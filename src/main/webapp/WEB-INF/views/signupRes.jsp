<%@ page import="com.google.gson.Gson" %>
<%@ page import="itstep.learning.models.form.UserSignupFormModel" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String formData = (String) request.getAttribute( "formData" );
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    System.out.println("formData: " + formData);
    Gson gson = new Gson();
    UserSignupFormModel userModel = gson.fromJson(formData, UserSignupFormModel.class);
    System.out.println("User model: " + userModel.getName());

    Date bday = userModel.getBirthdate();
    String outBday = "";

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    if (bday != null) {
        outBday = sdf.format(bday);
    }
%>
<h1>Signup result</h1>
<p>Data JSON - <%=formData%></p><br>
<p>First name: <%= userModel.getName() %></p>
<p>E-Mail: <%= userModel.getEmail() %></p>
<p>Password: <%= userModel.getPassword()%></p>
<p>Birthday: <%= outBday %></p>
</body>
</html>
