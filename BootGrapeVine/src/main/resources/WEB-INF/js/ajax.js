function queryParamiters(url) {
	// get filled paramiters from Form
	console.log("queryParamiters");
	let myForm = document.getElementById('form-knockknock');
	let allInputs = myForm.getElementsByTagName('input');
	url += '?'; // start query paramiter section;
	for (let i = 0; i < allInputs.length; i++) { // TODO add foreach $each;
		let input = allInputs[i];
		//if (input.value != "") {
			url += input.id + '=' + input.value + '&';
		//}
	}
	url.slice(0, -1); // tody last & character;
	console.log(url);
	return url;
}

function submitKnockknock(){
	event.preventDefault();
	 console.log("submitknockknock");
	var url = queryParamiters("http://localhost:8080/knockknock");
	$.ajax({
		url : url,
		type : "GET"
	}).then(function(data) {
		console.log("then funciton");
		//document.getElementsByClassName("person").innerHTML = "";
		$('.person-id').text(data.id);
		$('.person-Name').text("Hello " + data.firstName + " " + data.lastName);
	});
}

$(document).ready(function() {

});