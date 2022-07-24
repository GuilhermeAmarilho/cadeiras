#include <stdio.h>
#include <stdlib.h>
#define TAM 2

typedef struct{
    char nome[50];
    char cpf[14];
    int idade;
    float salario;
} Pessoa;

// Prototipação
Pessoa* alocaMemoriaVetorPessoas(int);
void carregaVetorPessoa(Pessoa*, int);
void escreveVetorPessoa(Pessoa*, int);


Pessoa* alocaMemoriaVetorPessoas(int tam){
    return (Pessoa*) malloc (sizeof(Pessoa) * tam);
}

void carregaVetorPessoas(Pessoa* pessoas, int tam){
    int i;
    for (i=0;i<tam;i++){
        printf("\nDigite o nome: ");
        scanf("%s", pessoas[i].nome);
        printf("Digite o CPF: ");
        scanf("%s", pessoas[i].cpf);
        printf("Digite a idade: ");
        scanf("%i", &pessoas[i].idade);
        printf("Digite o salario: ");
        scanf("%f", &pessoas[i].salario);  
    }
}

void escreveVetorPessoae(Pessoa* pessoas, int tam){
    printf("\n######### Escrevendo os dados #########");
    int i;
    for (i=0;i<tam;i++){
        printf("\nCodigo %i", i);
        printf("\nNome: %s", pessoas[i].nome);
        printf("\nCPF: %s", pessoas[i].cpf);
        printf("\nIdade: %i", pessoas[i].idade);
        printf("\nSalario: %f\n", pessoas[i].salario);  
    }
}
void desalocaMemoriaVetorPessoa(Pessoas* pessoas){
    free(pessoas);    
}

int main(){
    Pessoa* pessoas;
    pessoas = alocaMemoriaVetorPessoas(TAM);
    carregaVetorPessoas(pessoas, TAM);
    escreveVetorPessoae(pessoas, TAM);
    desalocaMemoriaVetorPessoa(pessoa);
    return 0;
}