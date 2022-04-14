//Faça um programa modulazirado em c que crie um vetor dinamico de 10 posições para armazenar os dados de pessoas (nome, cpf, idade, salário) crio procedimentos para carregar e escrever o vetor dinamico
#include <stdio.h>
#include <stdlib.h>
#define TAM 2
typedef struct{
  char nome[50];
  char cpf[11];
  int idade;
  float salario;
} Pessoa;
Pessoa* aloca_memoria_pessoa(){
    Pessoa *pessoa;
    pessoa = (Pessoa*) malloc(sizeof(Pessoa));
    if (pessoa == NULL){
        printf("Erro ao alocar memoria!\n");
    }
    return pessoa;
}
Pessoa* carrega_pessoa(){
    Pessoa *pessoa = aloca_memoria_pessoa();
    if (pessoa != NULL){
        printf("Digite o nome da pessoa: ");
        scanf("%s", pessoa->nome);
        printf("Digite o CPF da pessoa: ");
        scanf("%s", pessoa->cpf);
        printf("Digite a idade da pessoa: ");
        scanf("%i", &pessoa->idade);
        printf("Digite o salário da pessoa: ");
        scanf("%f", &pessoa->salario);
    }
    printf("Pessoa carregada com sucesso\n\n");
    return pessoa;
}
void escreve_pessoa(Pessoa* pessoa){
    printf("\nNome da pessoa: %s\n", pessoa->nome);
    printf("\nCpf da pessoa: %s\n", pessoa->cpf);
    printf("\nIdade da Pessoa: %i\n", pessoa->idade);
    printf("\nSalário da pessoa: %.2f\n\n\n", pessoa->salario);
}
void desaloca_memoria_pessoa(Pessoa **pessoas){
  int i;
  for (i=0;i<TAM;i++){
    printf("Desalocando memória da pessoa %i\n",i);
    free(pessoas[i]);
  }    
  free(pessoas);
}
int main(){
  int i;
  Pessoa **pessoas;
  pessoas = (Pessoa**) malloc(sizeof(Pessoa*) * 2);
  //Depois dentro de uma estrutura de repetição
  for (i=0;i<TAM;i++){
    pessoas[i] = carrega_pessoa(); 
    escreve_pessoa(pessoas[i]);
  }
  desaloca_memoria_pessoa(pessoas);
  return 0;
}