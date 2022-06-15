function defineTop(object, top){
    object.style.top = top+"vh";
};
function defineLeft(object, left){
    object.style.left = left+"vw";
};
var player1 = {
    object: document.querySelectorAll('div.pessoas img')[0],
    top: 0,
    left: 0,
    score: 0,
    url: '../assets/img/parado-right1.png',
    getTop: function(){
        return this.top;
    },
    setTop: function(top){
        this.top = top;
        defineTop(this.object,this.top);
    },
    getLeft: function(){
        return this.left;
    },
    setLeft: function(left){
        this.left = left;
        defineLeft(this.object,this.left);
    },
    getScore: function(){
      return this.score;
    },
    setScore: function(score){
      this.score = score;
    },
    getURL: function(){
        return this.url;
    },
    setURL: function(url){
        this.url = url;
    },
  };
var player2 = {
    object: document.querySelectorAll('div.pessoas img')[1],
    top: 0,
    left: 0,
    score: 0,
    url: '../assets/img/parado-right2.png',
    getTop: function(){
        return this.top;
    },
    setTop: function(top){
        this.top = top;
        defineTop(this.object,this.top);
    },
    getLeft: function(){
        return this.left;
    },
    setLeft: function(left){
        this.left = left;
        defineLeft(this.object,this.left);
    },
    getScore: function(){
        return this.score;
    },
    setScore: function(score){
        this.score = score;
    },
    getURL: function(){
        return this.url;
    },
    setURL: function(url){
        this.url = url;
    },
};
var bolin = {
    top: 0,
    left: 0,
    object: document.querySelector('div.bolin'),
    getTop: function(){
        return this.top;
    },
    setTop: function(top){
        this.top = top;
        defineTop(this.object,this.top);
    },
    getLeft: function(){
        return this.left;
    },
    setLeft: function(left){
        this.left = left;
        defineLeft(this.object,this.left);
    }
}
var arco = {
    top: 0,
    left: 0,
    object: arco = document.querySelector("div.arco"),
    getTop: function(){
        return this.top;
    },
    setTop: function(top){
        this.top = top;
        defineTop(this.object,this.top);
    },
    getLeft: function(){
        return this.left;
    },
    setLeft: function(left){
        this.left = left;
        defineLeft(this.object,this.left);
    }
}
var linhaarco = {
    top: 0,
    left: 0,
    object: document.querySelector("div.arcolinha"),
    getTop: function(){
        return this.top;
    },
    setTop: function(top){
        this.top = top;
        defineTop(this.object,this.top);
    },
    getLeft: function(){
        return this.left;
    },
    setLeft: function(left){
        this.left = left;
        defineLeft(this.object,this.left);
    }
}
var bocha = [];
bocha.push(
    {
        top: 0,
        left: 0,
        object: document.querySelectorAll("div.bocha")[0],
        getTop: function(){
            return this.top;
        },
        setTop: function(top){
            this.top = top;
            defineTop(this.object,this.top);
        },
        getLeft: function(){
            return this.left;
        },
        setLeft: function(left){
            this.left = left;
            defineLeft(this.object,this.left);
        },
    }
); // Bocha 1
bocha.push(
    {
        top: 0,
        left: 0,
        object: document.querySelectorAll("div.bocha")[3],
        getTop: function(){
            return this.top;
        },
        setTop: function(top){
            this.top = top;
            defineTop(this.object,this.top);
        },
        getLeft: function(){
            return this.left;
        },
        setLeft: function(left){
            this.left = left;
            defineLeft(this.object,this.left);
        }, 
    }
); // Bocha 2
bocha.push(
    {
        top: 0,
        left: 0,
        object: document.querySelectorAll("div.bocha")[1],
        getTop: function(){
            return this.top;
        },
        setTop: function(top){
            this.top = top;
            defineTop(this.object,this.top);
        },
        getLeft: function(){
            return this.left;
        },
        setLeft: function(left){
            this.left = left;
            defineLeft(this.object,this.left);
        },
    }
); // Bocha 3
bocha.push(
    {
        top: 0,
        left: 0,
        object: document.querySelectorAll("div.bocha")[4],
        getTop: function(){
            return this.top;
        },
        setTop: function(top){
            this.top = top;
            defineTop(this.object,this.top);
        },
        getLeft: function(){
            return this.left;
        },
        setLeft: function(left){
            this.left = left;
            defineLeft(this.object,this.left);
        },
    }
); // Bocha 4
bocha.push(
    {
        top: 0,
        left: 0,
        object: document.querySelectorAll("div.bocha")[2],
        getTop: function(){
            return this.top;
        },
        setTop: function(top){
            this.top = top;
            defineTop(this.object,this.top);
        },
        getLeft: function(){
            return this.left;
        },
        setLeft: function(left){
            this.left = left;
            defineLeft(this.object,this.left);
        },
    }
); // Bocha 5
bocha.push(
    {
        top: 0,
        left: 0,
        object: document.querySelectorAll("div.bocha")[5],
        getTop: function(){
            return this.top;
        },
        setTop: function(top){
            this.top = top;
            defineTop(this.object,this.top);
        },
        getLeft: function(){
            return this.left;
        },
        setLeft: function(left){
            this.left = left;
            defineLeft(this.object,this.left);
        },
    }
); // Bocha 6
