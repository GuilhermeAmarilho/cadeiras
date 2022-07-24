/******************************************************************************
Faça um programa modularizado em C que crie um vetor dinâmico de 10 posições
para armazenar os dados de pessoas (nome, cpf, idade e salário). Crie procedimentos
para carregar e escrever o vetor dinâmico.
*******************************************************************************/

#include <stdio.h>
#include <stdlib.h>
#define TAM 3

typedef struct {
    char nome[50];
    char cpf[14];
    int idade;
    float salario;
} Pessoa;

//Prototipação dos módulos
Pessoa* alocaMemoriaVetorPessoas(int);
void carregaVetorPessoas(Pessoa*, int);
void escreveVetorPessoas(Pessoa*, int);
void liberaMemoriaVetor(Pessoa*);

int main(){
    Pessoa* pessoas;
    pessoas = alocaMemoriaVetorPessoas(TAM);
    
    carregaVetorPessoas(pessoas, TAM);
    escreveVetorPessoas(pessoas, TAM);
    
    liberaMemoriaVetor(pessoas);
    return 0;
}

void liberaMemoriaVetor(Pessoa* pessoas){
    free(pessoas);
}

Pessoa* alocaMemoriaVetorPessoas(int tam){
    return (Pessoa*) malloc(sizeof(Pessoa) * tam);
}

void carregaVetorPessoas(Pessoa* pessoas, int tam){
    int i;
    printf("\n");
    for(i=0; i<tam; i++){
        printf("Digite o nome: ");
        scanf("%s", pessoas[i].nome);
        printf("Digite o cpf: ");
        scanf("%s", pessoas[i].cpf);
        printf("Digite a idade: ") ;       
        scanf("%i", &pessoas[i].idade);
        printf("Digite o salario: ");         
        scanf("%f", &pessoas[i].salario);
    }
}

void escreveVetorPessoas(Pessoa* pessoas, int tam){
    int i;
    for(i=0; i<tam; i++){
        printf("\n\nCodigo: %i\n", i+1);
        printf("\tNome: %s\n", pessoas[i].nome);
        printf("\tCPF: %s\n", pessoas[i].cpf);
        printf("\tIdade: %i\n", pessoas[i].idade);
        printf("\tSalario: %.2f\n", pessoas[i].salario);
    }
}