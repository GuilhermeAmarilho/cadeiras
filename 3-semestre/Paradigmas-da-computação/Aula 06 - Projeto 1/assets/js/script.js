// bolin
var bolin = document.querySelector('div.bolin');
bolin.style.top =  (Math.random() * (57 - 1) + 1)+"vh";
bolin.style.left =  (Math.random() * (688 - 400) + 400)/10+"vw";

// bochas
var bocha = [];
bocha.push(document.querySelectorAll("div.bocha")[0]);
bocha.push(document.querySelectorAll("div.bocha")[3]);
bocha.push(document.querySelectorAll("div.bocha")[1]);
bocha.push(document.querySelectorAll("div.bocha")[4]);
bocha.push(document.querySelectorAll("div.bocha")[2]);
bocha.push(document.querySelectorAll("div.bocha")[5]);

// players
var vez = 0;
var player1 = document.querySelectorAll('div.pessoas img')[0];
player1.style.top = "-40vh";player1.style.left = "6vw";
var player2 = document.querySelectorAll('div.pessoas img')[1];
player2.style.top = "-40vh";player2.style.left = "6vw";

// Angulação
var arco = document.querySelector("div.arco");
arco.style.top = (55 + parseFloat(player1.style.top) - 0.5)+"vh"; 
arco.style.left = (parseFloat(player1.style.left) - 6)+"vw";
var linhaarco = document.querySelector("div.arcolinha");
linhaarco.style.left = (parseFloat(player1.style.left) - 6)+"vw";
linhaarco.style.top = (40.5 + parseFloat(player1.style.top) - 0.5)+"vh";
var angulo = 0;

// Força
var forca = document.querySelector("div.forca");
var barraforca = document.querySelector("div.barraforca");
var valorforca = 100;

var body = document.querySelector("body");

body.addEventListener("keyup", function( e ) {
    if(arco.style.visibility != "visible"){
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
                player2.src = "assets/img/parado-right2.png"
            }
        }
        if(e.key == "s" || e.key == "S" || e.key == "ArrowDown"){
            if(vez%2==0){
                player1.src = "assets/img/parado-bottom.png"
            }else{
                player2.src = "assets/img/parado-bottom2.png"
            }
        }   
    }
}) // Evento para parar o boneco

body.addEventListener("keydown", function( e ) {
    if(barraforca.style.visibility != "visible"){
        if(arco.style.visibility != "visible"){ // Movimento do boneco
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
            if(e.key == "Enter"){
                if(vez%2==0){
                    movimento(5,player1,vez);
                }else{
                    movimento(5,player2,vez);
                }
            }
        }else{ // Movimento da angulacao
            if ((e.key == "w" || e.key == "W" || e.key == "ArrowUp") && (angulo > -60)){
                angulo-=3;
                linhaarco.style.transform = "rotate("+(angulo)+"deg)";
                linhaarco.style.top = (parseFloat(linhaarco.style.top)-.1)+"vh";
            }
            if((e.key == "s" || e.key == "S" || e.key == "ArrowDown") && (angulo < 60)){
                angulo+=3;
                linhaarco.style.transform = "rotate("+(angulo)+"deg)";
                linhaarco.style.top = (parseFloat(linhaarco.style.top)+.1)+"vh";
            }
            if(e.key == "Enter"){
                barraforca.style.visibility = "visible";
            }
            if(e.key == "Escape"){
                arco.style.visibility = "hidden";              
                linhaarco.style.visibility = "hidden";
            }
            console.log(angulo);
        }
    }else{ // Movimento da barra de forca
        if(e.key == "a" || e.key == "A" || e.key == "ArrowLeft"){
            if(valorforca>=0){
                valorforca--;
                forca.style.width = valorforca+"%";
            }
        }
        if(e.key == "d" || e.key == "D" || e.key == "ArrowRight"){
            if(valorforca<=99){
                valorforca++;
                forca.style.width = valorforca+"%";
            }
        }
        if(e.key == "Enter"){
            if(vez%2==0){
                lancamento(angulo, valorforca, bocha[vez], player1);
            }else{
                lancamento(angulo, valorforca, bocha[vez], player2);                
            }
        }
        if(e.key == "Escape"){
            forca.style.width = 0+"%";
            valorforca = 0;
            barraforca.style.visibility = "hidden";
            bocha[vez].style.visibility = "hidden";
        }
    }
}); // Evento principal de movimento


function lancamento(angulo, forca, bocha, elemento){
    var hipotenusa = (20*forca)/100;
    var CatetoOposto = Math.sin(angulo)*hipotenusa;
    var contador = 0;
    // while (contador < 100){
        
    // }
    movimentoXBase = (parseFloat(elemento.style.left) - 5);
    movimentoYBase = (63 + parseFloat(elemento.style.top));
    movimentoXporVez = hipotenusa/100;
    movimentoYporVez = CatetoOposto/100;

    bocha.style.top = movimentoYBase +"vh";
    bocha.style.left = movimentoXBase+"vw";
    // var i = 0;
    // while(i < 100){
    //     if(vez%2==0){
    //         bocha.style.top = ( movimentoYBase - movimentoYporVez*i ) +"vh";
    //     }else{
    //         // bocha.style.top = (70 + parseFloat(elemento.style.top))+"vh";
    //     }
    //     bocha.style.left = ( movimentoXBase + movimentoXporVez * i) +"vw";
    //     i++;
    // }
    bocha.style.visibility = "visible";
    arco.style.visibility = "hidden";
    linhaarco.style.visibility = "hidden";
}

function movimento(tipo, elemento, vez){
    var aux = "";
    var andando = 1;
    if(elemento.src.search("parado") != -1){
        andando = 0;
    }
    if (vez%2==1){ 
        aux = "2";
    }
    if(tipo == 1) { // movimento pra esquerda
        if(andando == 0){
            elemento.src = "assets/img/left-gif"+aux+".gif";
        }
        if(parseFloat(elemento.style.left) >= 9.4){
            elemento.style.left = parseFloat(elemento.style.left) - 0.4 + "vw";
            arco.style.left = (parseFloat(elemento.style.left) - 6)+"vw";
            linhaarco.style.left = (parseFloat(elemento.style.left) - 6)+"vw";
            bocha[vez].style.left = (parseFloat(elemento.style.left) - 5)+"vw";
        }
    }
    if(tipo == 2) { // movimento pra cima
        if(andando == 0){
            elemento.src = "assets/img/top-gif"+aux+".gif";
        }
        if(vez%2==1){
            if(parseFloat(elemento.style.top) >= -70){
                elemento.style.top = parseFloat(elemento.style.top) - 0.5 + "vh";
                arco.style.top = (62 + parseFloat(elemento.style.top) - 0.5)+"vh";
                linhaarco.style.top = (47.5 + parseFloat(elemento.style.top) - 0.5)+"vh";
                bocha[vez].style.top = (70 + parseFloat(elemento.style.top))+"vh";
            }
        }else{
            if(parseFloat(elemento.style.top) >= -62){
                elemento.style.top = parseFloat(elemento.style.top) - 0.5 + "vh";
                arco.style.top = (55 + parseFloat(elemento.style.top) - 0.5)+"vh";
                linhaarco.style.top = (40.5 + parseFloat(elemento.style.top) - 0.5)+"vh";
                bocha[vez].style.top = (63 + parseFloat(elemento.style.top))+"vh";
            }
        }
    }
    if(tipo == 3) { // movimento pra direita
        if(andando == 0){
            elemento.src = "assets/img/right-gif"+aux+".gif";
        }
        if(parseFloat(elemento.style.left) < 15){
            elemento.style.left = parseFloat(elemento.style.left) + 0.4 + "vw";
            arco.style.left = (parseFloat(elemento.style.left) - 6)+"vw";
            linhaarco.style.left = (parseFloat(elemento.style.left) - 6)+"vw";
            bocha[vez].style.left = (parseFloat(elemento.style.left) - 5)+"vw";
        }
    }
    if(tipo == 4) { // movimento pra baixo
        if(andando == 0){
            elemento.src = "assets/img/bottom-gif"+aux+".gif";
        }
        if(vez%2==1){
            if(parseFloat(elemento.style.top) < -14){
                elemento.style.top = parseFloat(elemento.style.top) + 0.5 + "vh";
                arco.style.top = (62 + parseFloat(elemento.style.top) + 0.5)+"vh";
                linhaarco.style.top = (48 + parseFloat(elemento.style.top) - 0.5)+"vh";                
                bocha[vez].style.top = (70 + parseFloat(elemento.style.top))+"vh";

            }
        }else{
            if(parseFloat(elemento.style.top) < -6){
                arco.style.top = (55 + parseFloat(elemento.style.top) + 0.5)+"vh";
                elemento.style.top = parseFloat(elemento.style.top) + 0.5 + "vh";
                linhaarco.style.top = (41 + parseFloat(elemento.style.top) - 0.5)+"vh";   
                bocha[vez].style.top = (63 + parseFloat(elemento.style.top))+"vh";
            }
        }
    }
    if(tipo == 5) { // começa a ação de angulação
        arco.style.visibility = "visible";
        linhaarco.style.visibility = "visible";
        angulo = 0;
        if(vez%2==0){
            player1.src = "assets/img/parado-right.png"
        }else{
            player2.src = "assets/img/parado-right2.png"
        }
    }
}


