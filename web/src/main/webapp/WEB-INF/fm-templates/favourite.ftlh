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
  <h4 class="display-3 font-weight-bold">TWOJE ULUBIONE WYDARZENIA</h4>
</header>
<div class="container-fluid row">
    <#list favouriteEvents as event>
      <div class="col-lg-4 col-md-6 mb-4">
        <div class="card h-100">
          <img class="card-img-top " style="max-height: 250px" src="${event.attachmentFileName}" alt="">
          <div class="card-body d-flex flex-column">
            <h5 class="card-title">${event.startDate?string('dd.MM.yyyy (HH:mm)')} -
                ${event.endDate?string('dd.MM.yyyy (HH:mm)')} </h5>
            <p class="card-text">${event.name}</p>
            <p class="card-text">${(event.addressCity)!"n/a"}</p>
            <p>${(event.addressName)!"n/a"}</p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">Zarezerwuj bilet</a>
          </div>
        </div>
      </div>
    </#list>
</div>

<#include "footer.ftlh">