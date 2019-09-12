<#include "navbar.ftlh">
<body>

<div>
    <h2> Formularz </h2>

    <div class="container-fluid row">

        <form method="post" action="/3cityevent/admin/upload" enctype="multipart/form-data">

            <div class="custom-file ">
                <input type="file" class="custom-file-input" id="dataFile1" name="eventFile">
                <label class="custom-file-label" for="dataFile1">Plik z wydarzeniami</label>
            </div>

            <div class="custom-file ">
                <input type="file" class="custom-file-input" id="dataFile2" name="placeFile">
                <label class="custom-file-label" for="dataFile2">Plik z miejscami</label>
            </div>

            <div class="custom-file ">
                <input type="file" class="custom-file-input" id="dataFile3" name="organizerFile">
                <label class="custom-file-label" for="dataFile3">Plik z organizatorami</label>
            </div>

            <div class="form-group row">
                <div class="col-sm-5">
                    <button type="submit" class="btn btn-primary">Zatwierdź</button>
                </div>
            </div>
        </form>
    </div>


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