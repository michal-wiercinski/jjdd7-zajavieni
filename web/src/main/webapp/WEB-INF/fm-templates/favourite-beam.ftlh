<#if upcomingEvent??>
  <div class="alert alert-success" align="center" style="height: 200px;">

    <h3 class="text-center"><strong>TWOJE NAJBLIŻSZE ULUBIONE WYDARZENIE</strong></h3>
    <div class="card-body d-flex flex-column">
      <h5 class="card-text text-center">${upcomingEvent.startDate?string('dd.MM.yyyy (HH:mm)')} -
          ${upcomingEvent.endDate?string('dd.MM.yyyy (HH:mm)')} </h5>
      <a class="card-text text-center">${upcomingEvent.name}</a>
      <a class="card-text text-center">${(upcomingEvent.addressCity)!"n/a"}</a>
      <div class="d-inline">
        <a href="/event-view?id=${upcomingEvent.id?c}"
           class="btn btn-outline-success show-event" <#--data-id="${event.id}"-->>Szczegóły</a>
        <button type="button"
                class="btn btn-outline-danger"
                id="close">
            Zamknij ❌
        </button>
      </div>
    </div>
  </div>
  <script src="/js/favourite.js"></script>
  <script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</#if>