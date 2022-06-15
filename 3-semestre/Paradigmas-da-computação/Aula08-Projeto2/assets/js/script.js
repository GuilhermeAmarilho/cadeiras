bolin.setTop((Math.random() * (57 - 1) + 1));
bolin.setLeft((Math.random() * (688 - 400) + 400)/10);
var body = document.querySelector("body");
var vez = 0;

body.addEventListener("keydown", function(e) {
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
})