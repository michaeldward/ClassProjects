function displayMessageOne() {
	var message = document.getElementById("numOneMessage");
	message.innerHTML = "Enter the first number here.";
}
function displayMessageTwo() {
	var message = document.getElementById("numTwoMessage");
	message.innerHTML = "Enter the second number here.";
}
function displayButtonMessage() {
	var message = document.getElementById("buttonMessage");
	message.innerHTML = "Click one of these buttons to perform the calculation.";
}
function displayResultMessage() {
	var message = document.getElementById("resultMessage");
	message.innerHTML = "This is where the result will appear. You cannot enter anything here!";
}
function hideMessage(name) {
	var message = document.getElementById(name);
	message.innerHTML = "";
}
function addNumbers() {
	num1 = document.getElementById("numOne").value;
	num2 = document.getElementById("numTwo").value;
	document.getElementById("result").value = parseFloat(num1) + parseFloat(num2);
}
function subtractNumbers() {
	num1 = document.getElementById("numOne").value;
	num2 = document.getElementById("numTwo").value;
	document.getElementById("result").value = parseFloat(num1) - parseFloat(num2);
}
function multiplyNumbers() {
	num1 = document.getElementById("numOne").value;
	num2 = document.getElementById("numTwo").value;
	document.getElementById("result").value = parseFloat(num1) * parseFloat(num2);
}
function divideNumbers() {
	num1 = document.getElementById("numOne").value;
	num2 = document.getElementById("numTwo").value;
	document.getElementById("result").value = parseFloat(num1) / parseFloat(num2);
}
function changeBackground() {
	var color = prompt("Enter a new background color: ");
	document.body.style.backgroundColor = color;
}
function changeHeader() {
	var message = document.getElementById("topHeader");
	message.innerHTML = prompt("Enter new text here: ");
}
function changeTitle() {
	var title = prompt("Enter a new title here: ");
	document.title = title;
}
function haveFun() {
	document.getElementById("numOne").style.border = "thick solid red";
	document.getElementById("numTwo").style.border = "thick solid orange";
	document.getElementById("add").style.border = "thick solid red";
	document.getElementById("subtract").style.border = "thick solid orange";
	document.getElementById("multiply").style.border = "thick solid yellow";
	document.getElementById("divide").style.border = "thick solid blue";
	document.getElementById("result").style.border = "thick solid green";
	document.getElementById("changeBackground").style.border = "thick solid yellow";
	document.getElementById("changeHeader").style.border = "thick solid blue";
	document.getElementById("changeTitle").style.border = "thick solid purple";
}
function beBoring() {
	document.getElementById("numOne").style.border = "";
	document.getElementById("numTwo").style.border = "";
	document.getElementById("add").style.border = "";
	document.getElementById("subtract").style.border = "";
	document.getElementById("multiply").style.border = "";
	document.getElementById("divide").style.border = "";
	document.getElementById("result").style.border = "";
	document.getElementById("changeBackground").style.border = "";
	document.getElementById("changeHeader").style.border = "";
	document.getElementById("changeTitle").style.border = "";
}