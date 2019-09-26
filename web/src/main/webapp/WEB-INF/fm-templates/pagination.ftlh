<div class="container">
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <#if page gt 2> <li class="page-item"><a class="page-link" href="/upcoming-events?pageNo=1">Pierwsza</a></li></#if>
            <#if page gt 2> <li class="page-item"><a class="page-link" href="/upcoming-events?pageNo=${(page-1)?c}">Poprzednia</a></li></#if>
            <#if page gt 3><li class="page-item"><a class="page-link" href="/upcoming-events?pageNo=${(page - 2)?c}">${page - 2}</a></li></#if>
            <#if page gt 1> <li class="page-item"><a class="page-link" href="/upcoming-events?pageNo=${(page-1)?c}">${page-1}</a></li></#if>
            <li class="page-item active" aria-current="page"><span class="page-link">${page}<span class="sr-only">(current)</span></span></li>
            <#if page lte totalPages> <li class="page-item"><a class="page-link" href="/upcoming-events?pageNo=${(page + 1)?c}">${page + 1}</a></li></#if>
            <#if page lt totalPages > <li class="page-item"><a class="page-link" href="/upcoming-events?pageNo=${(page + 2)?c}">${page + 2}</a></li></#if>
            <#if page lt totalPages><li class="page-item"><a class="page-link" href="/upcoming-events?pageNo=${(page + 1)?c}">Następna</a></li></#if>
            <#if page lt totalPages><li class="page-item"><a class="page-link" href="/upcoming-events?pageNo=${(totalPages+1)?c}">Ostatnia</a></li></#if>
        </ul>
    </nav>
</div>