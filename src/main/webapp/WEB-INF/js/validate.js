function deleteS(b) {
    if (b) {
        alert('This student has marks. You can not deleted this student!');
        return false;
    }
    else {
        var r;
        r = confirm('Are you sure you want to remove this student?');
        return r;
    }
}
function validateForm() {
    var c = document.myForm.newFirstName.value;
    if (c == "") {
        alert("dasdasdas");
    }
    var x = document.forms["infoStudent"]["newFirstName"].value;
    if (x == "") {
        alert("Name must be filled out");
        return false;
    }
}
