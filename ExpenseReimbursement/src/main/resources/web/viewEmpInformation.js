alert("employee infos");
 var submitButton = document.getElementById('submitButton');
submitButton.addEventListener('click', userLogin);


	
function userLogin (){
	
		var username = document.getElementById('usernamefield').value;
	var pwd = document.getElementById('pwdfield').value;
	
	console.log('username =' + username);
	console.log('password=' + pwd);
    debugger;
	var apiURL = "http://localhost:7001/login";
	debugger;

	fetch(apiURL, {
		method: 'POST',
        body: JSON.stringify({
			username: username,
			password: pwd,
		}), 
	})
	
		.then(response => response.json())   
	    .then(json => console.log(json))
	    .catch(err => console.log('Request Failed:', err));


} 