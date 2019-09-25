
<div class="card text-center">
    <div class="card-header">
        <h2 class="card-title">
            <p id="name" class="card-text"></p>
        </h2>
    </div>
    </br>
    <h2 class="card-title"></h2>
    <p class="card-text"></p>

    <div class="card-body text-center">
        <div class="container-fluid">
            <div class="row">
                <div class="col-4  ">
                    <img class="card-img-top " style="max-height: 250px"
                         src="${(event.attachments[0].fileName)!"/img/plug.jpg"}" alt="">
                </div>
                <div class="col-4 text-center">
                    <h3><span class="badge badge-secondary">Organizator</span></h3>
                        <p id="organizerName" class="card-text"></p>
                    <h3><span class="badge badge-secondary">Miejsce</span></h3>
                        <p id="addressName" class="card-text"></p>
                    <h3><span class="badge badge-secondary">Adres</span></h3>
                        <p id="addressCity" class="card-text"></p>
                        <p id="addressStreet" class="card-text"></p>
                        <p id="addressZipCode" class="card-text"></p>
                    <h3><span class="badge badge-secondary">Linki</span></h3>
                        <p id="wwwAddress" class="card-text"><a class="wwwAddress" href="#" Strona WWW </a></p>
                        <p id="fbSite" class="card-text"><a href="#"> Facebook </a></p>
                        <p id="websiteWithTickets" class="card-text"><a href="#"> Strona z biletami</a></p>
                </div>
            </div>
        </div>
        </br></br></br>


    </div>
    <div class="card-footer d-inline">
        <a href="#" class="btn btn-primary">Zarezerwuj bilet</a>
        <#if userId??>
            <button type="button"
                    class="${isFavourite?then('btn btn-outline-danger','btn btn-outline-success')}"
                    id='${isFavourite?then('deleteE','addE')}'
                    data-id='${event.id?c}'>
                ${isFavourite?then('Usuń z ulubionych ❌', 'Dodaj do ulubionych ✅')}
            </button>
        </#if>
        <a href="#" class="btn btn-primary">Dodaj do ulubionych</a>
    </div>
    <script src="/js/event-details.js"></script>
    <script src="/js/favourite.js"></script>

</div>


