
<#include "navbar.ftlh">

<div class="container-fluid row">
    <#list events as event>
        <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-100">

                <img class="card-img-top" src="${event.attachmentFileName}" alt="">
                <div class="card-body">
                    <h5 class="card-title">${event.startDate?string('dd.MM.yyyy (HH:mm)')} -
                        ${event.endDate?string('dd.MM.yyyy (HH:mm)')} </h5>
                    <p class="card-text">${event.name}</p>
                    <p class="card-text">${(event.addressCity)}</p>
                    <p>${(event.addressName)}</p>
                </div>
                <div class="card-footer">
                    <a href="#" class="btn btn-primary">Zarezerwuj bilet</a>
                </div>
            </div>
        </div>
    </#list>
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
