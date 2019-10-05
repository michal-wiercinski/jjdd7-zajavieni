<div class="container-fluid row">
    <#list events as event>
      <div class="col-lg-3 col-md-6 mb-4">
        <div class="card h-100">
          <a href="/event-view?id=${event.id?c}"><img class="card-img-top"
                                                      style="max-height: 250px; min-height: 250px"
                                                      src="${(event.attachments[0].fileName)!"/img/plug.jpg"}"
                                                      alt=""
                                                      onerror="this.src='/img/plug.jpg';"></a>
          <div class="card-body d-flex flex-column">
            <h5 class="card-title">${event.startDate?string('dd.MM.yyyy (HH:mm)')} -
                ${event.endDate?string('dd.MM.yyyy (HH:mm)')} </h5>
            <p class="card-text">${event.name!"n/a"}</p>
            <p class="card-text">${(event.addressCity)!"n/a"}</p>
            <p>${(event.addressName)!"n/a"}</p>
          </div>
          <div class="card-footer">
              <#if type != "GUEST">
                  <#if event.bookedForUser == false >
                    <button type="button"
                            data-toggle="popover" data-id-event="${event.id?c}"
                            data-id-user="${userId}" class="btn btn-primary make-booking"
                            data-content="Zarezerwowałeś wydarzenie">Zarezerwuj bilet
                    </button>
                  <#else>
                    <button type="button"
                            data-toggle="popover" data-id-event="${event.id?c}"
                            data-id-user="${userId}" class="btn btn-outline-danger cancel-booking"
                            data-content="Odwołałeś rezerwację">Odwołaj rezerwację
                    </button>
                  </#if>
              <#--<button type="button" data-id-event="${event.id?c}" data-id-user="${userId}" class="btn btn-outline-danger cancel-booking">Odwołaj rezerwację</button>-->
              <#else>
                <a href="/login" class="btn btn-primary">Zarezerwuj bilet</a>
              </#if>
              <#--<a href="/event-view?id=${event.id?c}"
                 class="btn btn-primary show-event">Szczegóły</a>-->
            <button type="button"
                    data-toggle="modal"
                    data-id-event="${event.id?c}" class="btn btn-primary show-event"
            >Szczegóły
            </button>
          </div>
        </div>
      </div>
    </#list>
</div>