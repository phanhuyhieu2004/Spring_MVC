<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="calculate" method="post">
    <input type="number" name="number1" value="${number1}">
    <input type="number" name="number2"  value="${number2}">
    <p>
        <button type="submit" name="calculation" value="+">+</button>
        <button type="submit" name="calculation" value="-">-</button>
        <button type="submit" name="calculation" value="X">X</button>
        <button type="submit" name="calculation" value="/">/</button>
    </p>
</form>
<h2>Result: ${result}</h2>
</body>
</html>