
/*const validateUser=jsRoutes.controllers.LoginController.validateUser*/
const checkInUser=document.getElementById("checkInUserRoute").value;
const registerUser=document.getElementById("registerUserRoute").value;
const csrfToken= document.getElementById("csrfToken").value;




document.getElementById("loginForm").addEventListener('submit', function (event) {
    if (this.checkValidity() === false) {
        console.log(this.checkValidity()+ "sorry")
        event.preventDefault();
        event.stopPropagation();
    }
    else {
        console.log("registration")
        event.preventDefault();
        signIn();

    }
    console.log("doing it")
    event.preventDefault();
    this.classList.add('was-validated')

}, false)


//
document.getElementById("registrationForm").addEventListener('submit', function (event) {
    if (this.checkValidity() === false) {
        console.log(this.checkValidity()+ "sorry")
        event.preventDefault();
        event.stopPropagation();
    }
    else {
        console.log("registration")
        event.preventDefault();

        register();
        var myModal=document.getElementById('userRegistration');
        var modal = bootstrap.Modal.getInstance(myModal);
        console.log(modal);
        const flashMessage=document.getElementById("flashMessage");
        const node=document.createTextNode("User registered");
        flashMessage.appendChild(node);
        flashMessage.classList.add('text-success')
        modal.toggle();

    }
    console.log("doing it")
    this.classList.add('was-validated')

}, false)


function signIn() {


   console.log("clicked");
   const username = document.getElementById("usernameInput").value;
    const password = document.getElementById("passwordInput").value;

    fetch(checkInUser, {
		method: 'POST',
		headers: {'Content-Type': 'application/json', 'Csrf-Token': csrfToken },
		body: JSON.stringify({ username, password})
	}).then(res => res.json()).then(data => {console.log(data)});

}

function register() {
    console.log("clicked");
    const username=document.getElementById("usernameRegistrationInput").value;
    const password=document.getElementById("passwordRegistrationInput").value;

    fetch(registerUser, {
        method: 'POST',
    	headers: {'Content-Type': 'application/json', 'Csrf-Token': csrfToken },
    	body: JSON.stringify({ username, password})
    }).then(res => res.json()).then(data => {console.log(data)});
}

