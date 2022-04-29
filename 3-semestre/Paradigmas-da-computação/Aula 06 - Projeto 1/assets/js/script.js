var button = document.querySelector('button');
var bolin = document.querySelector('div.bolin');
var player1 = document.querySelectorAll('div.pessoas img')[0];
var player2 = document.querySelectorAll('div.pessoas img')[1];

function game(){
    console.log("foi");
}

window.setInterval(game(), .5);

bolin.style.top =  (Math.random() * (395 - 5) + 10)+"px";
bolin.style.left =  (Math.random() * (790 - 460) + 460)+"px";

