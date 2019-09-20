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
    <#assign search_by_organizer = "/organizers?letter=A">
    <nav class="my-2 my-md-0 mr-md-3">
        <a class="p-2 text-dark" href="${upcoming_link}">Lista wydarzeń</a>
        <a class="p-2 text-dark" href="${search_by_organizer}">Wyszukiwanie</a>
        <a class="p-2 text-dark" href="#">Ulubione</a>
        <a class="p-2 text-dark" href="#">Koszyk</a>
        <div class="g-signin2" data-onsuccess="onSignIn"></div>
        <a href="#" onclick="signOut();">Sign out</a>
      <#--  <a class="p-2 text-dark" href="/admin/upload">Admin</a>-->
    </nav>
</div>

<header class="jumbotron my-4 text-center">
    <h1 class="display-3 font-weight-bold">3CITYEVENT</h1>
    <p class="lead">Witaj w miejscu, gdzie zgromadzone są wydarzenia kulturalne w Trójmiescie i okolicy.
        </br>Szukaj, znajdź, rezerwuj i baw się dobrze!</p>
</header>

<script>function onSignIn(googleUser) {
        var profile = googleUser.getBasicProfile();
        console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
        console.log('Name: ' + profile.getName());
        console.log('Image URL: ' + profile.getImageUrl());
        console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
    }
</script>
<script>
    function signOut() {
        var auth2 = gapi.auth2.getAuthInstance();
        auth2.signOut().then(function () {
            console.log('User signed out.');
        });
    }
</script>

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