<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Questions</title>
<script src="${pageContext.request.contextPath}/js/Common.js"></script>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 20px;
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    h1 {
        color: #333;
    }
    #drop-container {
        margin: 20px 0;
    }
    button {
        background-color: #4CAF50; /* Green */
        border: none;
        color: white;
        padding: 10px 20px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        margin: 4px 2px;
        cursor: pointer;
        border-radius: 4px;
        transition: background-color 0.3s ease;
    }
    button:hover {
        background-color: #45a049;
    }
    #questions, #quiz-container {
        margin-top: 20px;
        padding: 20px;
        background-color: white;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        width: 80%;
    }
</style>
</head>
<body onload="GetCategories()">
    <h1>All Questions</h1>

    <div id="drop-container">
        <!-- 
        <select name="SelectCategory" id="SelectCategory">
            <option value="">-Select-</option>
            <option value="java">Java</option>
            <option value="python">Python</option>
            <option value="all">All Questions</option>
        </select>
        -->
    </div>
    <br>
    <button onclick="fetchQuestions()">Load Questions</button>

<!-- <div id="questions"></div>
 -->    
    <div id="quiz-container"></div>

</body>
</html>
