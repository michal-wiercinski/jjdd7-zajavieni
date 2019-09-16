

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
    <link href="/css/bootstrap/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- Custom styles for this template -->
    <link href="/css/main.css" rel="stylesheet">
</head>
<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
    <a href="/main" class="my-0 mr-md-auto font-weight-normal"><img src="/img/logo.jpg" alt="logo"></a>
    <form class="form-inline my-2 my-lg-0">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-primary btn-rounded btn-sm my-0 waves-effect waves-light" type="submit">
            Szukaj
        </button>
    </form>
    <#assign upcoming_link = "/upcoming-events?pageNo=0">
    <nav class="my-2 my-md-0 mr-md-3">
        <a class="p-2 text-dark" href="${upcoming_link}">Lista wydarzeń</a>
        <a class="p-2 text-dark" href="#">Wyszukiwanie</a>
        <a class="p-2 text-dark" href="#">Ulubione</a>
        <a class="p-2 text-dark" href="#">Koszyk</a>
        <a class="p-2 text-dark" href="/admin/upload">Admin</a>
    </nav>
</div>

<header class="jumbotron my-4 text-center">
    <h1 class="display-3 font-weight-bold">3CITYEVENT</h1>
    <p class="lead">Witaj w miejscu, gdzie zgromadzone są wydarzenia kulturalne w Trójmiescie i okolicy.
        </br>Szukaj, znajdź, rezerwuj i baw się dobrze!</p>
</header>

<div class="card text-center">
    <div class="card-header">
        <h5 class="card-title">${event.startDate?string('dd.MM.yyyy (HH:mm)')} -
            ${event.endDate?string('dd.MM.yyyy (HH:mm)')} </h5>
    </div>
    <div class="card-body text-center">
        <img class="card-img-top img-fluid" style="max-height: 500px; max-width: 400px" src="${(event.attachments[0].fileName)!"/img/plug.jpg"}" alt="">
        <h5 class="card-title">${event.name}</h5>
        <p class="card-text">Miejsce: ${event.addressName!"n/a"}</p>
        <p class="card-text">Adres: ${event.addressStreet!" "}</p>
        <p class="card-text"> ${event.addressCity!"n/a"}</p>
        <p class="card-text"> ${event.addressZipCode!"n/a"}</p>
        <p class="card-text">${event.descShort!"Brak opisu"}</p>
        <#if event.wwwAddress?has_content><p class="card-text"><a href="${event.wwwAddress}"> Strona WWW </a> </p></#if>
        <#if event.fbSite?has_content><p class="card-text"><a href="${event.fbSite}"> Facebook </a></p></#if>
        <#if event.websiteWithTickets?has_content><p class="card-text"><a href="${event.websiteWithTickets}"> Strona z biletami</a></p></#if>

    </div>
    <div class="card-footer d-inline">
        <a href="#" class="btn btn-primary">Zarezerwuj bilet</a>
        <a href="#" class="btn btn-primary">Dodaj do ulubionych</a>
    </div>
</div>

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