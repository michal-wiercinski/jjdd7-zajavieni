<#include "navbar.ftlh">
<#include "favourite-beam.ftlh">
<div class="alert alert-dark text-center" role="alert">
  <h1>
    <strong>Statystyki</strong>
  </h1>
</div>
<div>
  <article id="contentView">
    <div class="container">
      <div id="columnchart1" style="width: 1000px; height: 600px;"></div>
    </div>
    <div class="container">
      <div id="columnchart2" style="width: 1000px; height: 600px;"></div>
    </div>
    <div class="container">
      <div id="columnchart3" style="width: 1000px; height: 600px;"></div>
    </div>
  </article>
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script src="/js/statistics.js"></script>
</div>
<#include "footer.ftlh">