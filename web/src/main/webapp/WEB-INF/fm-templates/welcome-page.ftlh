<!DOCTYPE html>
<html lang="pl">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>3cityevent</title>
    <link rel="canonical" href="#">
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- Custom styles for this template -->
    <link href="css/main.css" rel="stylesheet">
</head>
<body>
<#include "navbar.ftlh">

<header class="jumbotron my-4 text-center">
    <h1 class="display-3 font-weight-bold">3CITYEVENT</h1>
    <p class="lead">Witaj w miejscu, gdzie zgromadzone są wydarzenia kulturalne w Trójmiescie i okolicy.
        </br>Szukaj, znajdź, rezerwuj i baw się dobrze!</p>
</header>
<div class="container-fluid">
    <ul>
        <#list events as event>
            <li>
                <div class="col-lg-3 col-md-6 mb-4">
                    <div class="card h-100">
                        <img class="card-img-top" src="http://placehold.it/500x325" alt="">
                        <div class="card-body">
                            <h5 class="card-title">${event.startDate?date}</h5>
                            <p class="card-text">${event.name}</p>
                            <p class="card-text">${event.place.address.city}</p>
                            <p>${event.place.name}</p>
                        </div>
                        <div class="card-footer">
                            <a href="#" class="btn btn-primary">Zarezerwuj bilet</a>
                        </div>
                    </div>
                </div>
            </li>
        </#list>
    </ul>
</div>
<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-center">
        <li class="page-item disabled">
            <a class="page-link" href="#" tabindex="-1">Previous</a>
        </li>
        <li class="page-item"><a class="page-link" href="#">1</a></li>
        <li class="page-item"><a class="page-link" href="#">2</a></li>
        <li class="page-item"><a class="page-link" href="#">3</a></li>
        <li class="page-item">
            <a class="page-link" href="+1">Next</a>
        </li>
    </ul>
</nav>


<#include "footer.ftlh">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>