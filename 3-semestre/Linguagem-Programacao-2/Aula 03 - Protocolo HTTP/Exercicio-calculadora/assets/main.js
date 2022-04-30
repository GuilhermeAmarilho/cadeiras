let buttons = document.querySelector('div.numeros');
buttons.onclick = function(e) {
    if(document.getElementsByClassName('first')[0] == null && e.target.classList == ""){
        e.target.setAttribute('class','first');
    }else{
        if(document.getElementsByClassName('second')[0] == null && e.target.classList == ""){
            e.target.setAttribute('class','second');
        }
    }
} 
let operadores = document.querySelector('div.operadores');
operadores.onclick = function(e) {
    if(document.getElementsByClassName('opselected')[0] == null && e.target.id  != 'enviar' && e.target.classList == ""){
        e.target.setAttribute('class','opselected');
    }
    if(e.target.id == 'clear'){
        // if(document.getElementsByClassName('first')[0] != null){
        //     document.getElementsByClassName('first')[0].classList = ""
        // }
        // if(document.getElementsByClassName('second')[0] != null){
        //     document.getElementsByClassName('second')[0].classList = ""
        // }
        // if(document.getElementsByClassName('opselected')[0] != null){
        //     document.getElementsByClassName('opselected')[0].classList = ""
        // }
        // document.querySelector("h2").innerText = "";
        window.location.href = "http://localhost:80/index.php";
    }
    if(e.target.id == 'enviar'){
        if(document.getElementsByClassName('first')[0] != null && document.getElementsByClassName('second')[0] != null && document.getElementsByClassName('opselected')[0] != null){
            document.querySelector('input#first').value = document.querySelector('p.first').innerText;            
            document.querySelector('input#second').value = document.querySelector('p.second').innerText;            
            document.querySelector('input#operation').value = document.querySelector('p.opselected').innerText;
            document.querySelector("form").submit();
            console.log('sem erro');
        }       
        console.log('erro');
    }
}