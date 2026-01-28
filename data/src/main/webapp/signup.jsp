<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">

<h2>Sign Up</h2>
<form action="signup" method="post">

    <input type="text" name="name" placeholder="Name" class="form-control mb-2" required>
    <input type="text" name="surname" placeholder="Surname" class="form-control mb-2" required>
    <input type="number" name="phoneNumber" placeholder="Phone Number" class="form-control mb-2" required>
    <input type="email" name="email" placeholder="Email" class="form-control mb-2" required>
    <input type="text" name="username" placeholder="Username" class="form-control mb-2" required>
    <input type="password" name="password" placeholder="Password" class="form-control mb-2" required>
    <input type="password" name="confirmPassword" placeholder="Confirm Password" class="form-control mb-2" required>

    <button type="submit" class="btn btn-primary mt-2">Submit</button>
</form>

</body>
</html>
