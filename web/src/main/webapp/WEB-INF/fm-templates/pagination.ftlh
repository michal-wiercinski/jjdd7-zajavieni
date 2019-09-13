
<div class="container">
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <#if page gt 0> <li class="page-item"><a class="page-link" href="/upcoming-events?pagNo=${page = 0}">Pierwsza</a></li></#if>
            <#if page -1 gt 0> <li class="page-item"><a class="page-link" href="/upcoming-events?pagNo=${page - 1}">Poprzednia</a></li></#if>
            <#if page -2 gt 0><li class="page-item"><a class="page-link" href="/upcoming-events?pagNo=${page - 2}">${page - 2}</a></li></#if>
            <#if page -1 gt 0> <li class="page-item"><a class="page-link" href="/upcoming-events?pagNo=${page -1}">${page - 1}</a></li></#if>
            <li class="page-item active" aria-current="page"><span class="page-link">${page}<span class="sr-only">(current)</span></span></li>
            <#if page < totalPages-1> <li class="page-item"><a class="page-link" href="/upcoming-events?pagNo=${page + 1}">${page + 1}</a></li></#if>
            <#if page < totalPages-1 > <li class="page-item"><a class="page-link" href="/upcoming-events?pagNo=${page + 2}">${page + 2}</a></li></#if>
            <#if page < totalPages-1><li class="page-item"><a class="page-link" href="/upcoming-events?pagNo=${page + 1}">Następna</a></li></#if>
            <#if page < totalPages-1><li class="page-item"><a class="page-link" href="/upcoming-events?pagNo=${totalPages -1}">Ostatnia</a></li></#if>
        </ul>
    </nav>
</div>