//alert("employee Login");
 var submitButton = document.getElementById('submitButton');
submitButton.addEventListener('click', userLogin);
	
 function userLogin(){
	
		var username = document.getElementById('usernamefield').value;
	var pwd = document.getElementById('pwdfield').value;
	console.log("message");
	console.log('username =' + username);
	console.log('password=' + pwd);
    debugger;
	var apiURL = "http://localhost:7001/login";
	debugger;
/*
	fetch(apiURL, {
		method: 'POST',
        body: JSON.stringify({
			username:  document.getElementById('usernamefield').value,
			password: document.getElementById('pwdfield').value,
		}), 
	})
	.then(response => response.json())
	.then(response =>  {
     // console.log(JSON.parse(response).manager);
			console.log(response.manager);
		if(response.manager) {
		window.location.href= "../views/ManagerWelcomePage.html";
		} else {
			window.location.href= "../views/EmployeeWelcomePage.html";
		} 
	})
	.catch(err => console.log('Request Failed:', err));


} 

/*function gotoInfospage (result){
	if(result.manager) {
		window.location.href= "../views/ManagerWelcomePage.html"
	} else {
		window.location.href= "../views/EmployeeWelcomePage.html"
	}
	} */
/*
function userLogin (){
	
		var username = document.getElementById('usernamefield').value;
	var pwd = document.getElementById('pwdfield').value;
	
	console.log('username =' + username);
	console.log('password=' + pwd);
    debugger;
//	var apiURL = "http://localhost:7001/login";
	debugger;
   var apiURL = "http://localhost:7001/employees";
	fetch(apiURL, {
		method: 'GET',
	
	})
	
		.then(response => response.json())   
	    .then(json => console.log(json))
	    .catch(err => console.log('Request Failed:', err));

}

*/



/* var apiURL = "http://localhost:7001/login";
fetch(apiURL)
    //Handle success // Promise
    .then(response => response.json())   //convert to json
    .then(json => populateData(json))  //print data to console
    .catch(err => console.log('Request Failed', err));
    
    function populateData (response){
	  var dataSection = document.getElementById('responseData');
	  dataSection.innerHTML = '';
	  
	  for(i=0; i<response.length;i++){
		
		var idTag = document.createElement('h3');
		var data= response[i].username + " " +response[i].pwd
		idTag.innerHTML = data;
		  dataSection.appendChild(idTag);
	}
	
	
} */
/*
var apiURL = "http://localhost:7001/login";
fetch(apiURL, {
	method: 'POST',
	body: JSON.stringify({
		username: 'username',
		password: 'password',
	}),
})

	.then(response => response.json())   
    .then(json => populateData(json))
    .catch(err => console.log('Request Failed:', err));

function myFunction (status){
	if(status == 200) {
		window.location.href= "EmployeeWelcomePage.html"
	} else {
		alert("Try Again")
	}
}
*/

}