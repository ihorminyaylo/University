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
