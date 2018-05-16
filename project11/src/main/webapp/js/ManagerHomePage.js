	
function openLogin(evt, Login) {
   
    let i, tabcontent, tablinks;

    
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }

   
    document.getElementById(Login).style.display = "block";
    evt.currentTarget.className += " active";
}
	

//AJAX

function loadEmployee() {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("AllEmployee").innerHTML =
	      this.responseText;
	    }
	  };
	  xhttp.open("post", "/project11/viewEmployee.do");
	  xhttp.send();
	}

function loadAllPendingRequests() {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("AllPendingRequest").innerHTML =
	      this.responseText;
	    }
	  };
	  xhttp.open("post", "/project11/employeePendingRequests.do");
	  xhttp.send();
	}

function loadAllResolvedRequests() {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("AllResolvedRequest").innerHTML =
	      this.responseText;
	    }
	  };
	  xhttp.open("post", "/project11/employeeResolvedRequests.do");
	  xhttp.send();
	}

function loadSearch() {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("SearchEmployee").innerHTML =
	      this.responseText;
	    }
	  };
	  xhttp.open("post", "/project11/searchEmployee.do");
	  xhttp.send();
	}
