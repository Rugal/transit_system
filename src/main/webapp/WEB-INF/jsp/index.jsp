<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
    <head>
        <meta charset="UTF-8"/>
        <title>Transit System</title>
        <!--  Static resources form Webjars -->
        <link rel="stylesheet" href="/webjars/bootstrap/4.1.0/css/bootstrap.min.css">
        <script src="/webjars/jquery/4.1.0/jquery.min.js"></script>
        <script src="/webjars/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container-fluid" style="margin-top: 20px">
            <div class="row">
                <div class="col-md-10 offset-md-1">
                    Login Page
                </div>
            </div>
            <div class="col-md-10 offset-md-1">
                <form action="#" th:action="@{/login}" th:object="${user}" method="post">
                    <div class="form-group">
                        <label for="email">Email address</label>
                        <input th:field="*{email}" type="email" class="form-control" id="email"
                               aria-describedby="emailHelp" placeholder="Enter email"/>
                        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                    </div>                    
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input th:field="*{password}" type="password" class="form-control" id="password" placeholder="Password"/>
                    </div>
                    <button type="submit" class="btn btn-success">Sign In</button>
                    <button type="button" class="btn btn-primary">Sign Up</button>
                </form>
            </div>
        </div>
    </body>
</html>
