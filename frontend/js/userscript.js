document.addEventListener('DOMContentLoaded', function () {
    const notauser = document.getElementById('notauser');
    if (notauser) {
        notauser.addEventListener('click', () => {
            document.getElementById('userregister').style.display = 'block';
            document.getElementById('notauser').style.display = 'none';
            document.getElementById('userlogin').style.display = 'none';
        });
    }

    const confirmpassword = document.getElementById('userconfirmpassword');
    if (confirmpassword) {
        confirmpassword.addEventListener('focusout', () => {
            const password = document.getElementById('userpassword').value;
            if (password !== confirmpassword.value) {
                document.getElementById('userspan2').textContent = 'Passwords do not match';
            } else {
                document.getElementById('userspan2').textContent = '';
            }
        });
    }
});
