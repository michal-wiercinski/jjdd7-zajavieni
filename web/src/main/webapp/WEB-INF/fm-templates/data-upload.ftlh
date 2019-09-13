<#include "navbar.ftlh">
<body>

<div class="container-fluid row">
    <h2> Formularz </h2>
    <form class="form-inline my-2 my-lg-0" method="post" action="/3cityevent/admin/upload"
          enctype="multipart/form-data">
        <div class="form-group">
            <label for="dataFile">Plik .json z wydarzeniami: </label><br/>
            <input class="form-control mr-sm-2" type="file" class="form-control-file" id="dataFile1"
                   name="eventFile"><br/>
        </div>
        <div class="form-group">
            <label for="dataFile">Plik .json z miejscami: </label><br/>
            <input class="form-control mr-sm-2" type="file" class="form-control-file" id="dataFile2"
                   name="placeFile"><br/>
        </div>
        <div class="form-group">
            <label for="dataFile">Plik .json z organizatorami: </label><br/>
            <input class="form-control mr-sm-2" type="file" class="form-control-file" id="dataFile3"
                   name="organizerFile"><br/>
        </div>
        <button class="btn btn-outline-primary btn-rounded btn-sm my-0 waves-effect waves-light" type="submit">
            Zatwierdź
        </button>
    </form>
</div>

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