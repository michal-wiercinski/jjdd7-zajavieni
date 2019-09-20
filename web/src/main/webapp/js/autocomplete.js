$.ui.autocomplete.prototype._resizeMenu = function () {
    let ul = this.menu.element;
    ul.outerWidth(this.element.outerWidth()*2
    );
}
$("#search").autocomplete({
    source: function (request, response) {
        $.ajax({
            url: '/search?phrase=' + request.term,
            type: 'GET',
            success: function (data) {
                if (!data.length) {
                    let result = [
                        {
                            label: 'Brak wyników',
                            value: request.term
                        }
                    ];
                    response(result);
                } else {
                    let result = data.map(
                        r => {
                            return {
                                id: r.id,
                                label: r.name,
                                value: r.name
                            };
                        }
                    );
                    response(result);
                }
            }
        });
    },
    minLength: 3,
    select: function (event, ui) {
        if (ui.item.id === undefined) {
            return;
        } else {
            window.location.href = "/event-view?id=" + ui.item.id;
        }
    }
});
