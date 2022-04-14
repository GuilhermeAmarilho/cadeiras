/*
Faça um programa modularizado em C que crie um vetor dinâmico de 10 posições. Crie procedimentos para carregar e escrever o vetor dinâmico;
*/
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

//Prototipação
int* alocaMemoriaVetor(int);
void carregaVetorDinamico(int*, int);
void escreveVetorDinamico(int*, int);
int carregaTamanhoVetor();
int erros(int);

int main(void) {
  int *x, tam;

  tam = carregaTamanhoVetor();

  x = alocaMemoriaVetor(tam);
  if (x == NULL){
    return erros(0); //retorna erro
  }

  carregaVetorDinamico(x, tam);
  escreveVetorDinamico(x, tam);

  free(x);

  return 0;
}

int carregaTamanhoVetor(){
  int tam;
  printf("Digite o tamanho do vetor: ");
  scanf("%i", &tam);
  return tam;
}

int erros(int erro){
    printf("Erro ao alocar memória para o vetor! (Erro %i)\n", erro);
    return erro;
}

int* alocaMemoriaVetor(int tam){
  //Alocação dinâmica de memória 
  return (int*) malloc(sizeof(int) * tam);
}

void carregaVetorDinamico(int* vet, int tam){
  srand(time(NULL));
  int i;

  //Procedimento para carregar o vetor dinâmico
  for (i = 0; i < tam; i++){
    vet[i] = rand() % 10;
  }
}

void escreveVetorDinamico(int* vet, int tam){
  int i;
  //Procedimento para escrever o vetor dinâmico
  printf("\n");
  for (i = 0; i < tam; i++){
    printf("[%i] ", vet[i]);
  }
}