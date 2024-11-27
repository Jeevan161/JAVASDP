<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>403 </title>
<style>
@import url("https://fonts.googleapis.com/css?family=Share+Tech+Mono|Montserrat:700");

* {
    margin: 0;
    padding: 0;
    border: 0;
    font-size: 100%;
    font: inherit;
    vertical-align: baseline;
    box-sizing: border-box;
    color: inherit;
}
button#goToHome {
 
 font-size: 1.2rem;
 padding: 0.5rem 1rem;
 border-radius: 50px;
 box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
 cursor: pointer;
 transition: background-color 0.3s;
}

button#goToHome:hover {
 background-color: #28a745;
 color:white;
}

body {
    background-image: #e3e7f3;
    height: 100vh;
}

h1 {
    font-size: 12vw;
    text-align: center;
    position: fixed;
    width: 100vw;
    z-index: 1;
    color: #82848c;
    text-shadow: 0 0 50px rgba(0, 0, 0, 0.07);
    top: 50%;
    transform: translateY(-50%);
    font-family: "Montserrat", monospace;
}

.div1 {
    background: rgba(255, 255, 255, 0.6);
    width: 70vw;
    position: relative;
    top: 50%;
    transform: translateY(-50%);
    margin: 0 auto;
    padding: 30px 30px 10px;
    box-shadow: 0 0 150px -20px rgba(0, 0, 0, 0.5);
    z-index: 3;
}

P {
    font-family: "Share Tech Mono", monospace;
    color: #ff4500;
    margin: 0 0 20px;
    font-size: 17px;
    line-height: 1.2;
}

span {
    color: #8b0000;
}

i {
    color: purple;
}

div a {
    text-decoration: none;
}

b {
    color: #81a2be;
}

a.avatar {
    position: fixed;
    bottom: 15px;
    right: -100px;
    animation: slide 0.5s 4.5s forwards;
    display: block;
    z-index: 4
}

a.avatar img {
    border-radius: 100%;
    width: 44px;
    border: 2px solid white;
}

@keyframes slide {
    from {
        right: -100px;
        transform: rotate(360deg);
        opacity: 0;
    }
    to {
        right: 15px;
        transform: rotate(0deg);
        opacity: 1;
    }
}
.ccen
{	
	display:flex;
	font-family:Montserrat;
	align-items:center;
	justify-content:center;
}

</style>

</head>
<body>
<h1>VERIFICATION<br>PENDING</h1>
<div class="div1"><p>> <span>Verification Pending </span>: "<i>Admin is yet to verify the account. </i>"</p>
</div>
</div>
<script>
var str = document.getElementsByTagName('div')[0].innerHTML.toString();
var i = 0;
document.getElementsByTagName('div')[0].innerHTML = "";

setTimeout(function() {
    var se = setInterval(function() {
        i++;
        document.getElementsByTagName('div')[0].innerHTML = str.slice(0, i) + "|";
        if (i == str.length) {
            clearInterval(se);
            document.getElementsByTagName('div')[0].innerHTML = str;
        }
    }, 10);
},0);
</script>
</body>
</html>