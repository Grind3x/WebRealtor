<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<title>W3.CSS</title>
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
</style>
<body>

<nav class="w3-sidebar w3-bar-block w3-collapse w3-animate-left w3-card" style="z-index:3;width:250px;" id="mySidebar">
    <a class="w3-bar-item w3-button w3-hide-large w3-large" href="javascript:void(0)" onclick="w3_close()">Close <i
            class="fa fa-remove"></i></a>
    <a class="w3-bar-item w3-button" href="#">Home</a>
    <a class="w3-bar-item w3-button w3-teal" href="/load.jsp">Load apartments</a>
    <a class="w3-bar-item w3-button" href="/work.jsp">Work with apartments</a>
    <a class="w3-bar-item w3-button" href="/view.jsp">View list of apartments</a>
    <a class="w3-bar-item w3-button" href="/recost.jsp">Change apartment cost</a>
    <a class="w3-bar-item w3-button" href="#">Link 5</a>
</nav>

<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer"
     id="myOverlay"></div>

<div class="w3-main" style="margin-left:250px;">

    <header class="w3-container w3-theme" style="padding:16px">
        <h1>Home page</h1>
    </header>

    <div class="w3-container" style="padding:32px">

        <form action="/work.jsp" method="post">
            <input type="file" name="load" value="Load">
            <input type="submit" value="Load">
        </form>


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
