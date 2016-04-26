
$("body").ready(function () {
    $("#showGamerWin").one().hide();
    $("#showComputerWin").one().hide();
    $("#showAlreadyShoot").one().hide();
    gamerMove();
});

function gamerMove() {
    //alert("Ход игрока: ");
    $('#ComputerMove img').fadeOut(1000);
    $('#GamerMove img').fadeIn(1000);
    
    //$("#showAlreadyShoot").fadeOut(500);
    $('#ComputerBattlefield td').not('.left-column').click(function () {
        var data = "id=" + this.id + "&action=GAMER_MOVE";
        var url = "ControllerServlet?" + data;
        $.ajax({
            type: "GET",
            url: url,
            data: data,
            success: function (responseText) {
                $("#ComputerBattlefield").html(responseText);
                var nextMove = $("#nextMoveCG").attr("name");
                var gw = $("#gamerWin").attr("id");
                var as = $("#alreadyShoot").attr("id");          
                
                if (gw === "gamerWin") {
                    soundHit ();
                    gamerWin();
                }
                
                if (as === "alreadyShoot") {
                    $("#showAlreadyShoot").fadeIn(500).delay(1500).fadeOut();
                }

                if (nextMove === "gamer") {
                    soundHit ();
                    gamerMove();
                } else {
                    soundMiss();
                    computerMove();
                }
            }
        });
    });
}

function computerMove() {
    //alert("ход компьютера:");
    $('#GamerMove img').fadeOut(1000);
    $('#ComputerMove img').fadeIn(1000);
    var obj = $('#ComputerBattlefield');
    Object.freeze(obj);
    $.ajax({
        type: "GET",
        url: "ControllerServlet?action=COMP_MOVE",
        success: function (responseText) {
            $("#GamerBattlefield").html(responseText);
            var nextMove = $("#nextMoveBG").attr("name");
            var cw = $("#compWin").attr("id");
            if (cw === "compWin") {
                //alert (cw);
                soundHit ();
                compWin();
            }
            if (nextMove === "gamer") {
                soundMiss();
                gamerMove();
            } else {
                soundHit ();
                computerMove();
            }
        }
    });
}

function gamerWin() {
    // вывести победителя
    
    $('#GamerMove img').fadeOut(1000);
    $('#ComputerMove img').fadeOut(1000);
    $("#showGamerWin").fadeIn(1000);
    $("#GamerBattlefield").freeze();   
}

function compWin() {
    // вывести победителя
    $('#GamerMove img').fadeOut(1000);
    $('#ComputerMove img').fadeOut(1000);
    $("#showComputerWin").fadeIn(1000);
    $("#GamerBattlefield").freeze();    
}

function soundHit () {
    //alert("Внутри soundHit");
    var audio_hit = new Audio();
    audio_hit.src = 'sounds/explosion3.mp3';
    audio_hit.autoplay = true;
}

function soundMiss () {
    //alert("Внутри soundHit");
    var audio_miss = new Audio();
    audio_miss.src = 'sounds/stoneInWater.mp3';
    audio_miss.autoplay = true;
}