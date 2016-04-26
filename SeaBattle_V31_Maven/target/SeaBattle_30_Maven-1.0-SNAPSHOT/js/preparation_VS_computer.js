

$(document).ready(function () {
    $("#GO_ON").html(function (indx, oldHtml) {
        if ($("#GamerBattlefieldTable td").hasClass("yesShip")) {
            return '<button id="btn3"> GO ON! </button>';
        } else {            
            return oldHtml;
        }
    })
});