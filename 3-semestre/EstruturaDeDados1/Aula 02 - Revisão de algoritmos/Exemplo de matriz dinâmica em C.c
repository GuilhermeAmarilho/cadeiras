/******************************************************************************
Exemplo de matriz dinâmica em C
*******************************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define N 3
#define M 5

//Protótipos dos módulos
int** alocaMemoriaMatrizDinamica(int, int);
void carregaMatrizDinamica(int**, int, int);
void escreveMatrizDinamica(int**, int, int);
void liberaMemoriaMatrizDinamica(int**, int);

int main(){
    srand(time(NULL));
    int **ma;
    ma = alocaMemoriaMatrizDinamica(N, M);
    carregaMatrizDinamica(ma, N, M);
    escreveMatrizDinamica(ma, N, M);
    liberaMemoriaMatrizDinamica(ma, N);
    
    return 0;
}

int** alocaMemoriaMatrizDinamica(int n, int m){
    //Procedimento para alocar memoria da matriz
    int **ma, i;
    ma = (int**) malloc(sizeof(int*) * n);
    for (i=0; i<N; i++){
        ma[i] = (int*) malloc(sizeof(int) * m);
    }
    
    return ma;
}

void carregaMatrizDinamica(int **ma, int n, int m){
    //Procedimento para carregar a matriz
    int l,c;
    
    for(l=0; l<n; l++){
        for(c=0; c<m; c++){
            ma[l][c] = rand() % 10;
        }
    }
}

void escreveMatrizDinamica(int **ma, int n, int m){
    //Procedimento para escrever a matriz
    int l, c;
    for(l=0; l<n; l++){
        for(c=0; c<m; c++){
            printf("\t%i", ma[l][c]);
        }
        printf("\n");
    }    
}

void liberaMemoriaMatrizDinamica(int** ma, int n){
    //Procedimento para desalocar memoria da matriz
    int i;
    for (i=0; i<n; i++){
        free(ma[i]);
    }
    free(ma);     
}