<%@ page import="com.gmail.grind3x.model.Apartment" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<title>Result</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-teal.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
    body {
        font-family: "Roboto", sans-serif
    }

    .w3-bar-block .w3-bar-item {
        padding: 16px;
        font-weight: bold
    }
    table {
        display: table;
        border-collapse: collapse;
        border: 1px solid black;
    }
    th {
        text-align: center;
        border: 1px solid black;
    }
    td {
        text-align: center;
        border: 1px solid black;

    }
</style>
<body>

<nav class="w3-sidebar w3-bar-block w3-collapse w3-animate-left w3-card" style="z-index:3;width:250px;" id="mySidebar">
    <a class="w3-bar-item w3-button w3-hide-large w3-large" href="javascript:void(0)" onclick="w3_close()">Close <i
            class="fa fa-remove"></i></a>
    <a class="w3-bar-item w3-button" href="/">Home</a>
    <a class="w3-bar-item w3-button" href="/load.jsp">Load apartments</a>
    <a class="w3-bar-item w3-button" href="/add.jsp">Add apartment</a>
    <% if (session.getAttribute("apartments") != null) {
    %>
    <a class="w3-bar-item w3-button" href="/view.jsp">View list of apartments</a>
    <a class="w3-bar-item w3-button" href="/recost.jsp">Change apartment cost</a>
    <a class="w3-bar-item w3-button" href="/delete.jsp">Delete the apartment</a>
    <%
        }
    %>
</nav>

<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer"
     id="myOverlay"></div>

<div class="w3-main" style="margin-left:250px;">
    <div id="myTop" class="w3-container w3-top w3-theme w3-large">
        <p><i class="fa fa-bars w3-button w3-teal w3-hide-large w3-xlarge" onclick="w3_open()"></i>
            <span id="myIntro" class="w3-hide">W3.CSS: Introduction</span></p>
    </div>

    <header class="w3-container w3-theme" style="padding:16px">
        <h2>Apartments</h2>
    </header>

    <div class="w3-container" style="padding:32px">

        <table width="100%">
            <tr>
                <th>#</th>
                <th>Address</th>
                <th>Number of rooms</th>
                <th>Floor</th>
                <th>Cost</th>
            </tr>
            <%
                List<Apartment> apartments = (List<Apartment>) request.getAttribute("apartments");
                int count = 0;
                for (Apartment apartment : apartments) {

            %>

            <tr>
                <td><%=++count%></td>
                <td><%= apartment.getAddress()%></td>
                <td><%= apartment.getNumberOfRooms()%></td>
                <td><%=apartment.getFloor()%></td>
                <td><%=apartment.getCost()%></td>
            </tr>
            <%
                }
            %>
        </table><br>
        <button type="button" onclick="location.href = '/view.jsp'">Go back!</button>

    </div>

    <footer class="w3-container w3-theme">
        <p>&copy; Grind3x, 2018</p>
    </footer>

</div>

<script>
    function w3_open() {
        document.getElementById("mySidebar").style.display = "block";
        document.getElementById("myOverlay").style.display = "block";
    }

    function w3_close() {
        document.getElementById("mySidebar").style.display = "none";
        document.getElementById("myOverlay").style.display = "none";
    }

    window.onscroll = function () {
        myFunction()
    };

    function myFunction() {
        if (document.body.scrollTop > 80 || document.documentElement.scrollTop > 80) {
            document.getElementById("myTop").classList.add("w3-card-4", "w3-animate-opacity");
            document.getElementById("myIntro").classList.add("w3-show-inline-block");
        } else {
            document.getElementById("myIntro").classList.remove("w3-show-inline-block");
            document.getElementById("myTop").classList.remove("w3-card-4", "w3-animate-opacity");
        }
    }

    function myAccordion(id) {
        var x = document.getElementById(id);
        if (x.className.indexOf("w3-show") == -1) {
            x.className += " w3-show";
            x.previousElementSibling.className += " w3-theme";
        } else {
            x.className = x.className.replace("w3-show", "");
            x.previousElementSibling.className =
                x.previousElementSibling.className.replace(" w3-theme", "");
        }
    }
</script>
</body>
</html>
