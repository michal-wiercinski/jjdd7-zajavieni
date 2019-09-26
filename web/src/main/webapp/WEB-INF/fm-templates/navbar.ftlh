<!DOCTYPE html>
<html lang="pl">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="generator" content="Jekyll v3.8.5">
    <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id"
          content="857504899215-qodap15sc3br3qood7gksv2n8ajnjnk9.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <title>3cityevent</title>
    <link rel="canonical" href="#">
    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
    <!-- Custom styles for this template -->
    <link href="/css/main.css" rel="stylesheet">

</head>
    <div class="d-flex flex-column flex-md-row align-hitems-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
        <a href="/main" class="my-0 mr-md-auto font-weight-normal"><img src="/img/logo.jpg" alt="logo"></a>
        <ul class="list-group" id="result"></ul>
        <#assign upcoming_link = "/upcoming-events?pageNo=1">
        <#assign favourite_link = "/favourite-events">
        <#assign search_by_organizer = "/organizers?letter=A">
        <form class="form-inline my-2 my-lg-0" >
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" id="search">
            <button class="btn btn-outline-primary btn-rounded btn-sm my-0 waves-effect waves-light" type="submit">
                Szukaj
            </button>
        </form>
        <nav class="my-2 my-md-0 mr-md-3">
            <#if (type == "ADMIN") || (type == "SUPER_ADMIN")>
                <a class="p-2 text-dark" href="/admin-view">Panel admina</a>
            </#if>
            <a class="p-2 text-dark" href="${upcoming_link}">Lista wydarzeń</a>
            <a class="p-2 text-dark" href="${search_by_organizer}">Organizatorzy</a>
            <a class="p-2 text-dark" href="#">Wyszukiwanie</a>
            <#if type != "GUEST">
            <a class="p-2 text-dark" href="${favourite_link}">Ulubione</a>
            <a class="p-2 text-dark" href="#">Koszyk</a>
            </#if>
            <a href="/login" class="btn btn-danger btn-sm" id="login">
                <i class="fa fa-google"></i> Zaloguj się przez <b>Google</b></a>
            <a href="/logout" class="btn btn-danger btn-sm"
               id="logout"><i class="fa fa-google"></i> Wyloguj się</a>

        </nav>
    </div>

    <header class="jumbotron my-4 text-center ">
        <h1 class="display-3 font-weight-bold">3CITYEVENT</h1>
        <p class="lead">Witaj w miejscu, gdzie zgromadzone są wydarzenia kulturalne w Trójmiescie i okolicy.
            </br>Szukaj, znajdź, rezerwuj i baw się dobrze!</p>
    </header>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
crossorigin="anonymous"></script>
<script src="/js/permissions.js"></script>
<script src="/js/login_logout.js"></script>
<script src="/js/autocomplete.js"></script>
</body>
</html>