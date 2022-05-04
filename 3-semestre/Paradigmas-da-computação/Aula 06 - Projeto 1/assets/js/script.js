var bolin = document.querySelector('div.bolin');
var vez = 0;
var player1 = document.querySelectorAll('div.pessoas img')[0];
player1.style.top = "-40vh";
player1.style.left = "6vw";

var player2 = document.querySelectorAll('div.pessoas img')[1];
player2.style.top = "-40vh";
player2.style.left = "6vw";
var body = document.querySelector("body");

var str;
var keycode;

body.addEventListener("keyup", function( e ) {
    if(e.key == "a" || e.key == "A" || e.key == "ArrowLeft"){
        if(vez%2==0){
            player1.src = "assets/img/parado-left.png"
        }else{
            player2.src = "assets/img/parado-left2.png"
        }
    }
    if(e.key == "w" || e.key == "W" || e.key == "ArrowUp"){
        if(vez%2==0){
            player1.src = "assets/img/parado-top.png"
        }else{
            player2.src = "assets/img/parado-top2.png"
        }
    }
    if(e.key == "d" || e.key == "D" || e.key == "ArrowRight"){
        if(vez%2==0){
            player1.src = "assets/img/parado-right.png"
        }else{
            player2.src = "assets/img/parado-right.png"
        }
    }
    if(e.key == "s" || e.key == "S" || e.key == "ArrowDown"){
        if(vez%2==0){
            player1.src = "assets/img/parado-bottom.png"
        }else{
            player2.src = "assets/img/parado-bottom2.png"
        }
    }   
}) // Evento para parar o boneco

body.addEventListener("keydown", function( e ) {
    if(e.key == "a" || e.key == "A" || e.key == "ArrowLeft"){
        if(vez%2==0){
            movimento(1,player1,vez);
        }else{
            movimento(1,player2,vez);
        }
    }
    if(e.key == "w" || e.key == "W" || e.key == "ArrowUp"){
        if(vez%2==0){
            movimento(2,player1,vez);
        }else{
            movimento(2,player2,vez);
        }
    }
    if(e.key == "d" || e.key == "D" || e.key == "ArrowRight"){
        if(vez%2==0){
            movimento(3,player1,vez);
        }else{
            movimento(3,player2,vez);
        }
    }
    if(e.key == "s" || e.key == "S" || e.key == "ArrowDown"){
        if(vez%2==0){
            movimento(4,player1,vez);
        }else{
            movimento(4,player2,vez);
        }
    }
    if(e.key == "enter"){
        
    }
}); // Evento principal de movimento
 
function movimento(tipo, elemento, vez){
    var aux = "";
    var andando = 1;
    if(elemento.src.search("parado") != -1){
        andando = 0;
    }
    if (vez%2==1){
        aux = "2";
    }
    if(tipo == 1){
        if(andando == 0){
            elemento.src = "assets/img/left-gif"+aux+".gif";
        }
        if(parseFloat(elemento.style.left) >= 9.4){
            elemento.style.left = parseFloat(elemento.style.left) - 0.4 + "vw";
        }
    }
    if(tipo == 2) {
        if(andando == 0){
            elemento.src = "assets/img/top-gif"+aux+".gif";
        }
        if(parseFloat(elemento.style.top) >= -65){
            elemento.style.top = parseFloat(elemento.style.top) - 0.5 + "vh";
        }
    }
    if(tipo == 3) {
        if(andando == 0){
            elemento.src = "assets/img/right-gif"+aux+".gif";
        }
        if(parseFloat(elemento.style.left) < 15){
            elemento.style.left = parseFloat(elemento.style.left) + 0.4 + "vw";
        }
    }
    if(tipo == 4){
        if(andando == 0){
            elemento.src = "assets/img/bottom-gif"+aux+".gif";
        }
        if(parseFloat(player1.style.top) < -5.5){
            player1.style.top = parseFloat(player1.style.top) + 0.5 + "vh";
        }
    }
}

bolin.style.top =  (Math.random() * (57 - 10) + 10)+"vh";
bolin.style.left =  (Math.random() * (682 - 402) + 402)/10+"vw";

