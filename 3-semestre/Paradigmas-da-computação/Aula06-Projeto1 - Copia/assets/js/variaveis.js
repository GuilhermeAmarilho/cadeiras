// bolin
var bolin = {
    objeto: document.querySelector('div.bolin'),
    top: 0,
    left: 0,
    modifyTop: function(valor){
        this.top+=valor;
        this.objeto.style.top = this.top + "vh";
    },
    modifyLeft: function(valor){
        this.left+=valor;
        this.objeto.style.left = this.left + "vw";
    },
    defineTop: function(valor){
        this.top = valor;
        this.objeto.style.top = this.top + "vh";
    },
    defineLeft: function(valor){
        this.left = valor;
        this.objeto.style.left = this.left + "vw";
    }
}
// players
var vez = 0;
var player1 = {
    objeto: document.querySelectorAll('div.pessoas img')[0],
    top: 0,
    left: 0,
    modifyTop: function(valor){
        this.top+=valor;
        this.objeto.style.top = this.top + "vh";
    },
    modifyLeft: function(valor){
        this.left+=valor;
        this.objeto.style.left = this.left + "vw";
    },
    defineTop: function(valor){
        this.top = valor;
        this.objeto.style.top = this.top + "vh";
    },
    defineLeft: function(valor){
        this.left = valor;
        this.objeto.style.left = this.left + "vw";
    }
}
var player2 = {
    objeto: document.querySelectorAll('div.pessoas img')[1],
    top: 0,
    left: 0,
    modifyTop: function(valor){
        this.top+=valor;
        this.objeto.style.top = this.top + "vh";
    },
    modifyLeft: function(valor){
        this.left+=valor;
        this.objeto.style.left = this.left + "vw";
    },
    defineTop: function(valor){
        this.top = valor;
        this.objeto.style.top = this.top + "vh";
    },
    defineLeft: function(valor){
        this.left = valor;
        this.objeto.style.left = this.left + "vw";
    }
}
var limitadorCampo = {
    top: -65,
    left: 9.4,
    bottom: -9,
    right: 15
};

// Angulação
var arco = {
    objeto: document.querySelector("div.arco"),
    top: 0,
    left: 0,
    visibility: "hidden",
    modifyTop: function(valor){
        this.top+=valor;
        this.objeto.style.top = this.top + "vh";
    },
    modifyLeft: function(valor){
        this.left+=valor;
        this.objeto.style.left = this.left + "vw";
    },
    defineTop: function(valor){
        this.top = valor;
        this.objeto.style.top = this.top + "vh";
    },
    defineLeft: function(valor){
        this.left = valor;
        this.objeto.style.left = this.left + "vw";
    },
    setVisibility: function(value){
        this.visibility = value;
        this.objeto.style.visibility = this.visibility;
    }
}
var linhaarco = {
    objeto: document.querySelector("div.arcolinha"),
    top: 0,
    left: 0,
    visibility: "hidden",
    modifyTop: function(valor){
        this.top+=valor;
        this.objeto.style.top = this.top + "vh";
    },
    modifyLeft: function(valor){
        this.left+=valor;
        this.objeto.style.left = this.left + "vw";
    },
    defineTop: function(valor){
        this.top = valor;
        this.objeto.style.top = this.top + "vh";
    },
    defineLeft: function(valor){
        this.left = valor;
        this.objeto.style.left = this.left + "vw";
    },
    setVisibility: function(value){
        this.visibility = value;
        this.objeto.style.visibility = this.visibility;
    }
}
var angulo = 0;

// Força
var forca = document.querySelector("div.forca");
var barraforca = document.querySelector("div.barraforca");
var valorforca = 50;


// bochas
var bocha = [];
var pontuacao = [];
bocha.push(document.querySelectorAll("div.bocha")[0]); // Criação das bochas como objeto
bocha.push(document.querySelectorAll("div.bocha")[3]);
bocha.push(document.querySelectorAll("div.bocha")[1]);
bocha.push(document.querySelectorAll("div.bocha")[4]);
bocha.push(document.querySelectorAll("div.bocha")[2]);
bocha.push(document.querySelectorAll("div.bocha")[5]);

// Letreiro
var h1 = document.getElementsByClassName("title")[0];

var body = document.querySelector("body");