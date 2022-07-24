#include <stdio.h>


typedef struct{
    char *nome;
    char *cpf;
    int idade;
    float salario;
} Pessoa;

// Prototipação

Pessoa* alocaMemoriaPessoa();
Pessoa* carregaPessoa(int);
void desalocaPessoa(Pessoa*);

int main(void){
    int vet[10];
    // populaVetor[10];   
    Pessoa *p;
    p = carregaPessoa();
    escrevePessoa(p);
    return 0;
}

// Alocação dinâmica

Pessoa* alocaMemoriaPessoa(){
    Pessoa pessoa;
    Pessoa = (Pessoa*) malloc(sizeof(Pessoa));

    if (pessoa == NULL){
        printf("Erro ao alocar memoria!\n");
    }
    return pessoa;
}

Pessoa* carregaPessoa(int i){
    Pessoa *pessoa = alocaMemoriaPessoa();
    if (pessoa != NULL){
        printf("Digite o nome da pessoa ( %i ): ", i+1);
        scanf("%s", pessoa->nome);
        printf("Digite o CPF da pessoa ( %i ): ", i+1);
        scanf("%s", pessoa->cpf);
        printf("Digite a idade da pessoa ( %i ): ", i+1);
        scanf("%i", pessoa->idade);
        printf("Digite o salario da pessoa ( %i ): ", i+1);
        scanf("%f", pessoa->salario);
    }
    return pessoa;
}

void escrevePessoa(Pessoa* p){
    printf("###### Dados da pessoa #######")
    printf("\nNome: %s",p->nome);
    printf("\nCPF: %s",p->cpf);
    printf("\nIdade: %s",p->idade);
    printf("\nSalario: %.2f",p->salario);
}

void desalocaPessoa(Pessoa *pessoa){
    free(pessoa);
}

int populaVetor(int v[10]){
    return 0;
}
