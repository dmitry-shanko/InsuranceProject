
function doLogin() {
	var flag = false;
	var form = document.loginform;
	var password = form.badpass.value;
	var email = form.email.value;
	var re = /^[^\s()<>@,;:\/]+@\w[\w\.-]+\.[a-z]{2,}$/i;
	var mess = document.getElementById("incorrectemail");
	mess.innerHTML = "";
	mess = document.getElementById("incorrectpassword");
	mess.innerHTML = "";
	if (email == "" || !re.test(email)) {
		mess = document.getElementById("incorrectemail");
		mess.innerHTML = "Incorrect email";
		flag = true;
	}
	if (password == "") {
		mess = document.getElementById("incorrectpassword");
		mess.innerHTML = "Incorrect password";
		flag = true;

	}
	if (flag)
	{
		return;
	}
	var pass_hash = hex_sha1(password);
	form.badpass.value = "";
	form.pass.value = pass_hash;
	form.submit();

	return false;
}