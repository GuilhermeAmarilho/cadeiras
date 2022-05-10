// bolin
var bolin = document.querySelector('div.bolin');
bolin.style.top =  (Math.random() * (57 - 1) + 1)+"vh";
bolin.style.left =  (Math.random() * (688 - 400) + 400)/10+"vw";

// players
var vez = 0;
var player1 = document.querySelectorAll('div.pessoas img')[0]; 
player1.style.top = "-40vh";player1.style.left = "6vw"; // posição inicial do personagem
var player2 = document.querySelectorAll('div.pessoas img')[1]; 
player2.style.top = "-40vh";player2.style.left = "6vw"; // posição inicial do personagem

// Angulação
var arco = document.querySelector("div.arco"); 
arco.style.top = (61 + parseFloat(player1.style.top))+"vh"; // posição inicial do arco
arco.style.left = (parseFloat(player1.style.left) - 6)+"vw"; 
var linhaarco = document.querySelector("div.arcolinha");
linhaarco.style.left = (parseFloat(player1.style.left) - 6)+"vw"; // posição inicial da linha
linhaarco.style.top = (46.5 + parseFloat(player1.style.top))+"vh";
var angulo = 0;

// Força
var forca = document.querySelector("div.forca");
var barraforca = document.querySelector("div.barraforca");
var valorforca = 50;

var body = document.querySelector("body");

// bochas
var bocha = [];
var pontuacao = [];
bocha.push(document.querySelectorAll("div.bocha")[0]); // Criação das bochas como objeto

bocha[0].style.left = (parseFloat(player1.style.left) - 5) + "vw"; // Posição inicial da bocha que começa
bocha[0].style.top = (69.5 + parseFloat(player1.style.top))+"vh";

bocha.push(document.querySelectorAll("div.bocha")[3]);
bocha.push(document.querySelectorAll("div.bocha")[1]);
bocha.push(document.querySelectorAll("div.bocha")[4]);
bocha.push(document.querySelectorAll("div.bocha")[2]);
bocha.push(document.querySelectorAll("div.bocha")[5]);

// Letreiro
var h1 = document.getElementsByClassName("title")[0];

body.addEventListener("keyup", function( e ) { 
    if(arco.style.visibility != "visible" && vez < 6){
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
}) // Evento feito apenas para parar o boneco

body.addEventListener("keydown", function( e ) {
    if(vez<6){ // Caso ainda tenha jogadas
        if(barraforca.style.visibility != "visible" ){ // caso não esteja na parte da medição da força
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
                forca.style.width = 50+"%";
                valorforca = 50;
            }
            if(e.key == "Escape"){
                forca.style.width = 50+"%";
                valorforca = 50;
                barraforca.style.visibility = "hidden";
                bocha[vez].style.visibility = "hidden";
            }
        }
    }
}); // Evento principal de movimento


function lancamento(angulo, forca, bocha, elemento){
    movimentoXBase = (parseFloat(elemento.style.left) - 5); // Como no eixo X não há diferença entre os players, ele só possui um tipo de movimento base X
    if(vez%2==0){
        movimentoYBase = (69.5 + parseFloat(elemento.style.top));
    }else{
        movimentoYBase = (79 + parseFloat(elemento.style.top));  // Devido a um dos elementos estar abaixo do outro, há a necessidade de fazer valores diferentes
    }
    var anguloRadianos = (angulo*Math.PI)/180; // Para o transform rotate do CSS, é necessário utilizar os angulos em RAD
    var hipotenusa = (80*forca)/100; // Força vem em porcentagem
    // Aqui defino o valor em valueWidht para a força de lançamento, o ideal é 80 para percorrer toda a quadra
    var CatetoAdjascente = Math.cos(anguloRadianos)*hipotenusa; // Fórmulas matemáticas para calcular os catetos
    var CatetoOposto = Math.sin(anguloRadianos)*hipotenusa;
    // Limitadores verticais para não sair da quadra
    var movimentacaoEixoY = movimentoYBase+CatetoOposto; // Movimentação total no eixo y
    if( ( movimentacaoEixoY > -1 ) && ( movimentacaoEixoY < 58.5 ) ){
        bocha.style.top = movimentoYBase + CatetoOposto +"vh";
    }else{
        if ( movimentacaoEixoY < -1 ) {
            bocha.style.top = -1+"vh";
        }
        if ( movimentacaoEixoY > 58.5 ) {
            bocha.style.top = 58.5+"vh";
        }
    }
    // Limitadores Horizontais para não sair da quadra
    var movimentacaoEixoX = movimentoXBase + CatetoAdjascente; // Movimentação total no eixo X
    if( movimentacaoEixoX < 79){
        bocha.style.left = movimentacaoEixoX + "vw";
    }else{
        bocha.style.left = 79 + "vw";
    }
    bocha.style.visibility = "visible"; // Deixa a bocha visivel
    arco.style.visibility = "hidden"; // Esconde o arco
    linhaarco.style.visibility = "hidden"; // Esconde a linha
    barraforca.style.visibility = "hidden"; // Esconde a barra de força
    player1.style.top = "-40vh";player1.style.left = "6vw"; // Reseta a posição do player 1
    player2.style.top = "-40vh";player2.style.left = "6vw"; // Reseta a posição do player 2
    linhaarco.style.transform = "rotate("+0+"deg)"; // Reseta a linha
    var DiferencaX =  Math.pow( (movimentacaoEixoX - parseFloat(bolin.style.left)) , 2 ); 
    var DiferencaY =  Math.pow( (movimentacaoEixoY - parseFloat(bolin.style.top)) , 2 );
    pontuacao[vez] = Math.sqrt( DiferencaX + DiferencaY );  // Distancia entre dois pontos para ver a pontuação
    vez++;
    letreiro(vez);
}

function movimento(tipo, elemento, vez){
    var aux = "";
    var andando = 1;
    if (vez%2==1){ 
        aux = "2";
    }
    if(elemento.src.search("parado") != -1){
        andando = 0;
    }
    if(tipo == 1) { // movimento pra esquerda
        if(andando == 0){
            elemento.src = "assets/img/left-gif"+aux+".gif";
        }
        if(parseFloat(elemento.style.left) >= 9.4){
            elemento.style.left = parseFloat(elemento.style.left) - 0.4 + "vw";
        }
    }
    if(tipo == 2) { // movimento pra cima
        if(andando == 0){
            elemento.src = "assets/img/top-gif"+aux+".gif";
        }
        if(vez%2==1){
            if(parseFloat(elemento.style.top) >= -79){
                elemento.style.top = parseFloat(elemento.style.top) - 0.5 + "vh";
            }
        }else{
            if(parseFloat(elemento.style.top) >= -70){
                elemento.style.top = parseFloat(elemento.style.top) - 0.5 + "vh";
            }
        }
    }
    if(tipo == 3) { // movimento pra direita
        if(andando == 0){
            elemento.src = "assets/img/right-gif"+aux+".gif";
        }
        if(parseFloat(elemento.style.left) < 15){
            elemento.style.left = parseFloat(elemento.style.left) + 0.4 + "vw";
        }
    }
    if(tipo == 4) { // movimento pra baixo
        if(andando == 0){
            elemento.src = "assets/img/bottom-gif"+aux+".gif";
        }
        if(vez%2==1){
            if(parseFloat(elemento.style.top) < -22){
                elemento.style.top = parseFloat(elemento.style.top) + 0.5 + "vh";
            }
        }else{
            if(parseFloat(elemento.style.top) < -11){
                elemento.style.top = parseFloat(elemento.style.top) + 0.5 + "vh";
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
    // Os elementos se movem conforme o personagem, para assim facilitar a sua localização
    // Elementos no eixo X 
    bocha[vez].style.left = (parseFloat(elemento.style.left) - 5) + "vw";
    arco.style.left = (parseFloat(elemento.style.left) - 6)+"vw";
    linhaarco.style.left = (parseFloat(elemento.style.left) - 6)+"vw";
    // Elementos no eixo Y
    if (vez%2==1){ 
        aux = "2";
        arco.style.top = (71 + parseFloat(elemento.style.top))+"vh";
        linhaarco.style.top = (56 + parseFloat(elemento.style.top))+"vh";
        bocha[vez].style.top = (79 + parseFloat(elemento.style.top))+"vh";

    }else{
        arco.style.top = (61 + parseFloat(elemento.style.top))+"vh";
        linhaarco.style.top = (46.5 + parseFloat(elemento.style.top))+"vh";
        bocha[vez].style.top = (69.5+ parseFloat(elemento.style.top))+"vh";
    }
}

function letreiro (vez){
    if(vez%2==0){
        h1.textContent = "Vez do time azul";
    }else{
        h1.textContent = "Vez do time rosa";
    }
    if(vez == 6){
        var menor = pontuacao[0];
        var ganhador = 0;
        for( i = 1; i < 6; i++){
            if(pontuacao[i] < menor){   // Compara até achar o menor valor, este será o ganhador
                menor = pontuacao[i];
                ganhador = i;
            }
        }
        if(ganhador%2==0){
            h1.textContent = "O ganhador foi o azul";
        }else{
            h1.textContent = "O ganhador foi o rosa";
        }
    }
}

