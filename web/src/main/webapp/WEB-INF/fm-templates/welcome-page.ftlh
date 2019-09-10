<#include "navbar.ftlh">
<body>

<div class="container-fluid row">
    <#list events as event>
        <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-100">
                <img class="card-img-top" src="http://placehold.it/500x325" alt="">
                <div class="card-body">
                    <h5 class="card-title">${event.startDate?date}</h5>
                    <p class="card-text">${event.name}</p>
                    <p class="card-text">${(event.place.address.city)!"n/a"}</p>
                    <p>${(event.place.name)!"n/a"}</p>
                </div>
                <div class="card-footer">
                    <a href="#" class="btn btn-primary">Zarezerwuj bilet</a>
                </div>
            </div>
        </div>
    </#list>
</div>

<#include "footer.ftlh">