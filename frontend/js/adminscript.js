document.addEventListener('DOMContentLoaded', function () {
    const notaadmin = document.getElementById('notaadmin');
    if (notaadmin) {
        notaadmin.addEventListener('click', () => {
            document.getElementById('adminregister').style.display = 'block';
            document.getElementById('notaadmin').style.display = 'none';
            document.getElementById('adminlogin').style.display = 'none';
        });
    }

    const confirmpassword = document.getElementById('adminconfirmpassword');
    if (confirmpassword) {
        confirmpassword.addEventListener('focusout', () => {
            const password = document.getElementById('adminpassword').value;
            if (password !== confirmpassword.value) {
                document.getElementById('adminspan2').textContent = 'Passwords do not match';
            } else {
                document.getElementById('adminspan2').textContent = '';
            }
        });
    }
});
