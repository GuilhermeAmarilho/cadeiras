var bolin = document.querySelector('div.bolin');
var vez = 0;
var player1 = document.querySelectorAll('div.pessoas img')[0];
player1.style.top = "-40vh";
player1.style.left = "7vw";
var player2 = document.querySelectorAll('div.pessoas img')[1];
player2.style.top = "-40vh";
player2.style.left = "7vw";
var body = document.querySelector("body");

var str;
var keycode;

body.addEventListener("keyup", function( e ) {
    // console.log(e.key);
    if(e.key == "a" || e.key == "ArrowLeft"){
        if(vez%2==0){
            player1.style.left = parseFloat(player1.style.left) - 0.2 + "vw";
        }
        if(vez%2==1){
            player2.style.left = parseFloat(player1.style.left) - 0.2 + "vw";
        }
    }
});

bolin.style.top =  (Math.random() * (57 - 10) + 10)+"vh";
bolin.style.left =  (Math.random() * (682 - 402) + 402)/10+"vw";

