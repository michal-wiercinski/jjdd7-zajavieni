<div class="container-fluid">
<#if date><ul>
    <#list events as event>
        <li>
            <div class="col-lg-3 col-md-6 mb-4">
                <div class="card h-100">
                    <img class="card-img-top" src=${event.attachment.filename} alt="">
                    <div class="card-body">
                        <h5 class="card-title">${event.startDate}</h5>
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