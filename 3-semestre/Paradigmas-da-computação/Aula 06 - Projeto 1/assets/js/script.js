var button = document.querySelector('button');
var bolin = document.querySelector('div.bolin');
button.addEventListener("click", function (){
    bolin.style.top =  (Math.random() * (490 - 10) + 10)+"px";
    bolin.style.left =  (Math.random() * (890 - 10) + 10)+"px";
}, false);