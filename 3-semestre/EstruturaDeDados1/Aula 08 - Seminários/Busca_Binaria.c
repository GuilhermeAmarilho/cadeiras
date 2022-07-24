#include <stdio.h>
#include <stdlib.h>


int buscaBinariaRecursiva(int *vet, int valor, int inicio, int fim){
  int meio;
  if(inicio <=fim){
    meio =(inicio+fim)/2;
    if(valor == vet[meio]){
      return meio;
    }else{
      if(valor<vet[meio]){
        return buscaBinariaRecursiva(vet, valor, inicio, meio -1);
      }else{
        return buscaBinariaRecursiva(vet, valor, meio+1, fim);
      }
    }
  }
  return -1; // não existe o numero
}

int buscaBinariaIterativa(int *vet, int valor, int fim){
  int inicio = 0;
  int meio = (inicio+fim)/2;
  
  while(inicio <=fim){
    if(valor==vet[meio])
      return  meio+1;
    else{
      if(valor<vet[meio])
        fim = meio-1;
      else
        inicio = meio+1;
      }
    meio = (inicio+fim)/2;
  }
  return -1; // não existe o numero
}

int main(void) {
 int vet[10] = {13,14,19,43,52,65,82,89,91, 99};
  int valor, op;
  do{
    printf("Digite um valor a ser buscado: ");
    scanf("%d", &valor);
    //printf("\n Resuldado: %d \n", buscaBinariaRecursiva(vet, valor, 0, 10));
    printf("\n Resuldado: %d \n", buscaBinariaIterativa(vet, valor, 10));

    printf("\n 0 - Sair\n 1 - Nova Busca");
    scanf("%d", &op);
    
  
  } while(op != 0 );
  return 0;
}
