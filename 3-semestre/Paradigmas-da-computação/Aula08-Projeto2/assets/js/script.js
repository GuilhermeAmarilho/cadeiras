// PRESETS
bolin.defineLeft((Math.random() * (68 - 40) + 40)); // posição bolin eixo X
bolin.defineTop((Math.random() * (57 - 1) + 1)); // posição bolin eixo Y

player1.defineTop(-40);
player1.defineLeft(6); // posição inicial do personagem 1
player2.defineTop(-40);
player2.defineLeft(6); // posição inicial do personagem 1

arco.defineTop(57 + player1.top);   // posição inicial do arco y
arco.defineLeft(player1.left - 6);  // posição inicial do arco x
linhaarco.defineTop(42.5 + player1.top);    // posição inicial da linha do arco no eixo y
linhaarco.defineLeft(player1.left - 6);     // posição inicial da linha do arco no eixo x

bocha[0].style.left = (parseFloat(player1.left) - 5) + "vw";  // Posição inicial da bocha que começa x
bocha[0].style.top = (65.3 + parseFloat(player1.top))+"vh";     // Posição inicial da bocha que começa y

body.addEventListener("keyup", function( e ) { 
    if(arco.visibility != "visible" && vez < 6){
        if(e.key == "a" || e.key == "A" || e.key == "ArrowLeft"){
            if(vez%2==0){
                player1.objeto.src = "assets/img/parado-left.png"
            }else{
                player2.objeto.src = "assets/img/parado-left2.png"
            }
        }
        if(e.key == "w" || e.key == "W" || e.key == "ArrowUp"){
            if(vez%2==0){
                player1.objeto.src = "assets/img/parado-top.png"
            }else{
                player2.objeto.src = "assets/img/parado-top2.png"
            }
        }
        if(e.key == "d" || e.key == "D" || e.key == "ArrowRight"){
            if(vez%2==0){
                player1.objeto.src = "assets/img/parado-right.png"
            }else{
                player2.objeto.src = "assets/img/parado-right2.png"
            }
        }
        if(e.key == "s" || e.key == "S" || e.key == "ArrowDown"){
            if(vez%2==0){
                player1.objeto.src = "assets/img/parado-bottom.png"
            }else{
                player2.objeto.src = "assets/img/parado-bottom2.png"
            }
        }   
    }
}) // Evento feito apenas para parar o boneco

body.addEventListener("keydown", function( e ) {
    // if(vez<6){ // Caso ainda tenha jogadas
        if(barraforca.style.visibility != "visible" ){ // caso não esteja na parte da medição da força
            if(arco.visibility != "visible"){ // Movimento do boneco
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
                    linhaarco.objeto.style.transform = "rotate("+(angulo)+"deg)";
                    linhaarco.modifyTop(-0.1);
                }
                if((e.key == "s" || e.key == "S" || e.key == "ArrowDown") && (angulo < 60)){
                    angulo+=3;
                    linhaarco.objeto.style.transform = "rotate("+(angulo)+"deg)";
                    linhaarco.modifyTop(0.1);
                }
                if(e.key == "Enter"){
                    barraforca.style.visibility = "visible";
                }
                if(e.key == "Escape"){
                    arco.setVisibility("hidden");
                    linhaarco.setVisibility("hidden");
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
    //     }
    }
}); // Evento principal de movimento


function lancamento(angulo, forca, bocha, elemento){
    movimentoXBase = (elemento.left - 5); // Como no eixo X não há diferença entre os players, ele só possui um tipo de movimento base X
    if(vez%2==0){
        movimentoYBase = (69.5 + elemento.top);
    }else{
        movimentoYBase = (76.5 + elemento.top);  // Devido a um dos elementos estar abaixo do outro, há a necessidade de fazer valores diferentes
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
    arco.setVisibility("hidden"); // Esconde o arco
    linhaarco.setVisibility("hidden"); // Esconde a linha
    barraforca.style.visibility = "hidden"; // Esconde a barra de força
    player1.defineLeft(6);
    player1.defineTop(-40);
    player2.defineLeft(6);
    player2.defineTop(-40);
    linhaarco.objeto.style.transform = "rotate("+0+"deg)"; // Reseta a linha
    var DiferencaX =  Math.pow( (movimentacaoEixoX - (bolin.left)) , 2 ); 
    var DiferencaY =  Math.pow( (movimentacaoEixoY - (bolin.top)) , 2 );
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
    if(elemento.objeto.src.search("parado") != -1){
        andando = 0;
    }
    if(tipo == 1) { // movimento pra esquerda
        if(andando == 0){
            elemento.objeto.src = "assets/img/left-gif"+aux+".gif";
        }
        if(elemento.left >= limitadorCampo.left){
            elemento.modifyLeft(-0.4);
        }
    }
    if(tipo == 2) { // movimento pra cima
        if(andando == 0){
            elemento.objeto.src = "assets/img/top-gif"+aux+".gif";
        }
        if(vez%2==0){
            if(elemento.top >= limitadorCampo.top){
                elemento.modifyTop(-0.5);
            }
        }else{
            if(elemento.top >= (limitadorCampo.top - 7)){
                elemento.modifyTop(-0.5);
            }
        }
    }
    if(tipo == 3) { // movimento pra direita
        if(andando == 0){
            elemento.objeto.src = "assets/img/right-gif"+aux+".gif";
        }
        if(elemento.left < limitadorCampo.right){
            elemento.modifyLeft(0.4);
        }
    }
    if(tipo == 4) { // movimento pra baixo
        if(andando == 0){
            elemento.objeto.src = "assets/img/bottom-gif"+aux+".gif";
        }
        if(vez%2==0){
            if(elemento.top <= limitadorCampo.bottom){
                elemento.modifyTop(0.5);
            }
        }else{
            if(elemento.top <= (limitadorCampo.bottom - 7)){ 
                elemento.modifyTop(0.5);
            }
        }
    }
    if(tipo == 5) { // começa a ação de angulação
        arco.setVisibility("visible");
        linhaarco.setVisibility("visible");
        angulo = 0;
        elemento.objeto.src = "assets/img/parado-right"+aux+".png";
    }
    // Os elementos se movem conforme o personagem, para assim facilitar a sua localização
    arco.defineLeft(elemento.left - 6);
    linhaarco.defineLeft(elemento.left - 6);
    arco.defineTop(57 + elemento.top);
    linhaarco.defineTop(42.5 + elemento.top);
    bocha[vez].style.left = (parseFloat(elemento.left) - 5) + "vw";
    if(vez%2==1){
        arco.modifyTop(7);
        linhaarco.modifyTop(7);
        bocha[vez].style.top = (72.3 + parseFloat(elemento.top))+"vh";
    }else{
        bocha[vez].style.top = (65.3 + parseFloat(elemento.top))+"vh";
    }
}

function letreiro (vez){
    if(vez%2==0){
        h1.textContent = "Vez do time azul";
    }else{ cv
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

