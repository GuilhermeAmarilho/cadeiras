html = document.querySelector('html');
form = document.querySelector('form');

html.addEventListener("click", function (e) {
    if(form.style.left == ''){
        form.style.left = '0%';
    }  
});