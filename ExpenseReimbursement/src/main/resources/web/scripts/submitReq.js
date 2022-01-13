var apiURL = "http://localhost:7001/submitreq";

alert("submit req");
var submitButton = document.getElementById('amountfield');
submitButton.addEventListener('click', submitReq);


	
function submitReq (){
	
		var amount = document.getElementById('amountfield').value;
	var reason = document.getElementById('reasonfield').value;
	
	console.log('Amount =' + amount);
	console.log('Reason=' + reason);
    debugger;
	var apiURL = "http://localhost:7001/submitreq";
	debugger;

	fetch(apiURL, {
		method: 'POST',
        body: JSON.stringify({ 
			amount: amount,
			reason: reason,
		}), 
	})
	
		.then(response => response.json())   
	    .then(json => console.log(json))
	    .catch(err => console.log('Request Failed:', err));


} 

/* var xhttp = new XMLHTTPRequest();
xhttp.onreadystatechange = receiveData;
xhttp.open('GET', apiURL + '' + amount);
xhttp.send();

*/


