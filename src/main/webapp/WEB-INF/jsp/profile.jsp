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
                    User Profile
                </div>
            </div>
            <div class="row">
                <tbody>
                    <tr th:each="student: ${students}">
                        <td th:text="${student.id}" />
                        <td th:text="${student.name}" />
                    </tr>
                </tbody>

                <table class="table table-dark">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Name</th>
                            <th scope="col">Email</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td th:text="${user.uid}"></td>
                            <td th:text="${user.name}"></td>
                            <td th:text="${user.email}"></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
