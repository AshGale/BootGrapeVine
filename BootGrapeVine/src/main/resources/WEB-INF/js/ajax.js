
function something(){
	app.alert("hello");
}

$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/knockknock"
    }).then(function(data) {
       $('.person-id').append(data.id);
       $('.person-firstName').append(data.firstName);
       $('.person-lastName').append(data.lastName);
    });
});