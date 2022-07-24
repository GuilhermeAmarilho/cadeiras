/******************************************************************************
Dada uma matriz ma(N,M) de inteiros faça um programa em C que:
-> Carregue e escreva a matriz considerando que N e M serão duas constantes de valores 10 e 10, respectivamente;
-> Crie 2 vetores, sl(N) e mc(M), que contenham, respectivamente, as somas dos valores ímpares das linhas e 
   a média dos valores pares das colunas da matriz ma(N,M). Escreva os vetores de maneira que o usuário consiga
   interpretar seu conteúdo adequadamente;
-> Calcule e escreva a diferença entre a diagonal principal e a diagonal secundária da matriz.

Atenção, para esta questão considerar o uso dos conteúdos:
- manipulação de vetores e matrizes;
- modularização e passagem de parâmetros;

*******************************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define N 3
#define M 3

//Prototipação dos módulos
void carrega_matriz(int[][M]);
void inicializa_vetor(int[], int);
void inicializa_vetor_f(float[], int);
void soma_impares_linhas(int[][M], int[]);
void media_pares_colunas(int[][M], float[]);
void escreve_matriz(int[][M], int, int);
void escreve_vetor(int[], int);
void escreve_vetor_f(float[], int);
int soma_diagonal_principal(int[][M], int);
int soma_diagonal_secundaria(int[][M], int);
void escreveDiferencaDiagonais(int, int);

int main()
{
    srand(time(NULL));
    int ma[N][M], sl[N];
    float mc[M];
    inicializa_vetor(sl, N);
    inicializa_vetor_f(mc, M);
    carrega_matriz(ma);
    
    soma_impares_linhas(ma, sl);
    media_pares_colunas(ma, mc);
    
    escreve_matriz(ma, N, M);
    escreve_vetor(sl, N);
    escreve_vetor_f(mc, M);
    int somaDiagPrincipal= soma_diagonal_principal(ma, N);
    int somaDiagSecundario = soma_diagonal_secundaria(ma, N);
    escreveDiferencaDiagonais(somaDiagPrincipal, somaDiagSecundario);

}

void escreveDiferencaDiagonais(int diagPrinc, int diagSec){
  printf("\nDiagonal Principal: %i; Diagonal Secundaria: %i; Diferença: %i\n", diagPrinc, diagSec, (diagPrinc - diagSec)); 
}

int soma_diagonal_principal(int ma[][M], int n){
    int l,soma=0;
    for(l=0; l<n; l++){
        soma = soma + ma[l][l];
    }
    
    return soma;
}

int soma_diagonal_secundaria(int ma[][M], int n){
    int c=n-1, l, soma=0;
    for(l=0; l<n; l++){
        soma = soma + ma[l][c];
        c--;
    }
    
    return soma;
}

//Implementação dos módulos
void escreve_matriz(int ma[][M], int lin, int col){
    int l, c;
    printf("\n..:: MATRIZ ::..\n");
    for(l=0; l<lin; l++){
        for(c=0; c<col; c++){
            printf("%i\t", ma[l][c]);
        }
        printf("\n");
    }
}

void escreve_vetor(int vet[], int tam){
    int i;
    printf("\nVetor de inteiros:\n");
    for(i=0; i<tam; i++){
        printf("%i, ", vet[i]);
    }
    printf("\n");
}

void escreve_vetor_f(float vet[], int tam){
    int i;
    printf("\nVetor de reais: ");
    for(i=0; i<tam; i++){
        printf("%.2f, ", vet[i]);
    }
    printf("\n");
}


void media_pares_colunas(int ma[][M], float mc[]){
    //média dos valores pares das colunas da matriz
    float media;
    int l, c, cont;
    
    for(c=0; c<M; c++){
        media = 0.0;
        cont = 0;
        for(l=0; l<N; l++){
            if (ma[l][c] % 2 == 0){
                media = media + ma[l][c];
                cont++;
            }
        }
        if (media > 0)
            mc[c] = (media/(float)cont);
    }
}

void soma_impares_linhas(int ma[][M], int sl[]){
    //somas dos valores ímpares das linhas
    int l, c, soma;
    
    for (l=0; l<N; l++){
        soma = 0;
        for(c=0; c<M; c++){
            if (ma[l][c] % 2 != 0)
                soma = soma + ma[l][c];        
        }
        sl[l] = soma;
    }
}

void inicializa_vetor(int vet[], int tam){
    int i;
    for (i=0; i<tam; i++){
        vet[i] = 0;
    }
}

void inicializa_vetor_f(float vet[], int tam){
    int i;
    for (i=0; i<tam; i++){
        vet[i] = 0.0;
    }
}

void carrega_matriz(int ma[N][M]){
    int l,c;
    
    for (l=0; l<N; l++){
        for (c=0; c<M; c++){
            ma[l][c] = rand() % 100; // carrega a matriz com numeros aleatórios
        }
    }
}