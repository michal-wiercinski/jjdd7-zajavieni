<#include "navbar.ftlh">
<#include "favourite-beam.ftlh">
<div>
  <h2> Wyniki wyszukiwania </h2>

  <#include "cards-of-events.ftlh">

</div>

<div class="container">
  <nav aria-label="Page navigation example">
    <ul class="pagination">
      <#if page gt 2>
        <li class="page-item"><a class="page-link" href="/advanced-search?pageNo=1&categorySearch=${categorySearch}&name=${name}&startDate=${startDate}&endDate=${endDate}">Pierwsza</a></li>
      </#if>
      <#if page gt 2>
        <li class="page-item"><a class="page-link" href="/advanced-search?pageNo=${(page-1)?c}&categorySearch=${categorySearch}&name=${name}&startDate=${startDate}&endDate=${endDate}">Poprzednia</a></li>
      </#if>
      <#if page gt 3>
        <li class="page-item"><a class="page-link" href="/advanced-search?pageNo=${(page - 2)?c}&categorySearch=${categorySearch}&name=${name}&startDate=${startDate}&endDate=${endDate}">${page - 2}</a></li>
      </#if>
      <#if page gt 1>
        <li class="page-item"><a class="page-link" href="/advanced-search?pageNo=${(page-1)?c}&categorySearch=${categorySearch}&name=${name}&startDate=${startDate}&endDate=${endDate}">${page-1}</a></li>
      </#if>
      <li class="page-item active" aria-current="page"><span class="page-link">${page}<span class="sr-only">(current)</span></span></li>
      <#if page lte totalPages>
        <li class="page-item"><a class="page-link" href="/advanced-search?pageNo=${(page + 1)?c}&categorySearch=${categorySearch}&name=${name}&startDate=${startDate}&endDate=${endDate}">${page + 1}</a></li>
      </#if>
      <#if page lt totalPages>
        <li class="page-item"><a class="page-link" href="/advanced-search?pageNo=${(page + 2)?c}&categorySearch=${categorySearch}&name=${name}&startDate=${startDate}&endDate=${endDate}">${page + 2}</a></li>
      </#if>
      <#if page lt totalPages>
        <li class="page-item"><a class="page-link" href="/advanced-search?pageNo=${(page + 1)?c}&categorySearch=${categorySearch}&name=${name}&startDate=${startDate}&endDate=${endDate}">Następna</a></li>
      </#if>
      <#if page lt totalPages>
        <li class="page-item"><a class="page-link" href="/advanced-search?pageNo=${(totalPages+1)?c}&categorySearch=${categorySearch}&name=${name}&startDate=${startDate}&endDate=${endDate}">Ostatnia</a></li>
      </#if>
    </ul>
  </nav>
</div>

<#include "footer.ftlh">