	
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

function loadmyEmployee() {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("EmployeeView").innerHTML =
	      this.responseText;
	    }
	  };
	  xhttp.open("post", "/project11/myEmployee.do");
	  xhttp.send();
	}

function loadmyPendingRequests() {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("PendingRequest").innerHTML =
	      this.responseText;
	    }
	  };
	  xhttp.open("post", "/project11/specificPendingRequests.do");
	  xhttp.send();
	}

function loadmyResolvedRequests() {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("ResolvedRequest").innerHTML =
	      this.responseText;
	    }
	  };
	  xhttp.open("post", "/project11/specificResolvedRequests.do");
	  xhttp.send();
	}


inputElement.addEventListener("change", uploadFile, false);
function uploadFile () {
	let numFiles = files.length;
	let selectedFile = document.getElementById('input').files[0];
	for (let i = 0, numFiles = files.length; i < numFiles; i++) {
		  let file = files[i];
		}
}