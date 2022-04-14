#include <stdio.h>
#include <stdlib.h>
#include "ArvoreBinaria.h"

int main(){
    ArvBin* raiz;

    ArvBin* raiz = cria_ArvBin();

    int x;
    
    x = estaVazia_ArvBin(raiz);

    x = altura_ArvBin(raiz);

    x = totalNO_ArvBin(raiz);
    
    libera_ArvBin(raiz);


}