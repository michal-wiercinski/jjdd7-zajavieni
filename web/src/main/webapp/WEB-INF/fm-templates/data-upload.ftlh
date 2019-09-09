<!--Formularz dla admina - awaryjne ładowanie pliku z danymi-->
<!DOCTYPE html>
<html>
<head>
</head>
<body>

<div>
    <h2> Formularz </h2>
    <form class="form-inline my-2 my-lg-0" method="post" action="/3cityevent/admin/upload" enctype="multipart/form-data">
        <label for="dataFile">Plik z danymi</label>
        <input class="form-control mr-sm-2" type="file" class="form-control-file" id="dataFile" name="file">
        <button class="btn btn-outline-primary btn-rounded btn-sm my-0 waves-effect waves-light" type="submit">
            Zatwierdź
        </button>
    </form>
</div>

</body>
</html>
