html = document.querySelector('html');
form = document.querySelector('form');

html.addEventListener("click", function (e) {
    if(form.classList[0] != 'formVisible'){
        form.style.left = "0%";
    }  
});