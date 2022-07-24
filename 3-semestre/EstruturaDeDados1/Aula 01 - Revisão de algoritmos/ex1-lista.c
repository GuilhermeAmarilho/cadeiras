#include <stdio.h>
#include <stdlib.h>
#define tamY 3
#define tamX 3

int escrever(int i[tamY][tamX]){
    for (int j = 0; j < tamY ; j++){
        for (int k = 0; k < tamX ; k++){
            printf("\nInforme o valor para a posição [%i][%i]: ",j+1,k+1);
            scanf("%i",&i[j][k]);
        }
    }
    return i;
}

int main(void) {
    int matriz[tamY][tamX]; 
    escrever(matriz);
    return 0;
}
