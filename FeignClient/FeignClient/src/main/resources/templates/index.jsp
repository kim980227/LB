<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>Insert title here</title>

    <script src="
//code.jquery.com/jquery-3.3.1.js
"></script>
    <script type="text/javascript">
        function f1(){
            $.ajax({
                url : "
                http://localhost:8081/t1
                    ",
                type: 'GET',
            }).then(function(data) {
                console.log(data);
            });

            console.log("클릭");
        }
    </script>

</head>
<body>
<a href="t1">링크1</a><br/>
<button onclick="f1();">문제를 주세요.</button>
</body>
</html>