<div class="container">
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <#if (page +1) gt 1> <li class="page-item"><a class="page-link" href="/upcoming-events?pageNo=0">Pierwsza</a></li></#if>
            <#if (page) gt 1> <li class="page-item"><a class="page-link" href="/upcoming-events?pageNo=${(page)?c}">Poprzednia</a></li></#if>
            <#if (page -1) gt 1><li class="page-item"><a class="page-link" href="/upcoming-events?pageNo=${(page - 1)?c}">${page - 1}</a></li></#if>
            <#if (page) gt 1> <li class="page-item"><a class="page-link" href="/upcoming-events?pageNo=${(page)?c}">${page}</a></li></#if>
            <li class="page-item active" aria-current="page"><span class="page-link">${page + 1}<span class="sr-only">(current)</span></span></li>
            <#if page lt (totalPages-1)> <li class="page-item"><a class="page-link" href="/upcoming-events?pageNo=${(page + 2)?c}">${page + 2}</a></li></#if>
            <#if page lt (totalPages-1) > <li class="page-item"><a class="page-link" href="/upcoming-events?pageNo=${(page + 3)?c}">${page + 3}</a></li></#if>
            <#if page lt(totalPages-1)><li class="page-item"><a class="page-link" href="/upcoming-events?pageNo=${(page + 1)?c}">Następna</a></li></#if>
            <#if page lte (totalPages-1)><li class="page-item"><a class="page-link" href="/upcoming-events?pageNo=${(totalPages-1)?c}">Ostatnia</a></li></#if>
        </ul>
    </nav>
</div>