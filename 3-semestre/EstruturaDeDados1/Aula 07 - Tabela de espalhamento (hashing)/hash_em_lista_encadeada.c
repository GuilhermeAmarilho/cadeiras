#include <stdio.h>
#include <stdlib.h>
#include <stdlib.h>// necessário p/ as funções rand() e srand()
#include<time.h>//necessário p/ função time()

#define TAM 100

typedef struct no{
    int chave;
    struct no *proximo;
}No;

typedef struct{
    No *inicio;
    int tam;
}Lista;

void inicializaLista(Lista *l){
    l->inicio = NULL;
    l->tam = 0;
}

void inserir_na_lista(Lista *l, int valor){
    No *novo = malloc(sizeof(No));
    if(novo){
        novo->chave = valor;
        novo->proximo = l->inicio;
        l->inicio = novo;
        l->tam++;
    }else
        printf("\nErro ao alocar memória\n");
}

int buscar_na_lista(Lista *l, int valor){
    No *aux = l->inicio;
    while (aux && aux->chave != valor )
        aux = aux->proximo;
    if(aux)
        return aux->chave;
    else
        return 0;
}

void imprimir_lista(Lista *l){
    No *aux = l->inicio;
    printf(" Tam: %d: ", l->tam);
    while (aux){
        printf("%d ", aux->chave);   
        aux = aux->proximo;
    }
}

void iniciarTabela(Lista t[]){
    int i;
    for (i = 0; i < TAM; i++)
        inicializaLista(&t[i]);
}

int funcaoHash(int chave){
    return chave % TAM;
}

void inserir(Lista t[], int valor){
    int id = funcaoHash(valor);
    inserir_na_lista(&t[id], valor);
}

int busca(Lista t[], int chave){
    int id = funcaoHash(chave);
    printf("\nIndice gerada: %d\n",id);
    return buscar_na_lista(&t[id], chave);
}

void imprimir(Lista t[]){
    int i;
    for (i = 0; i < TAM; i++){
        printf("%2d = ", i);
        imprimir_lista(&t[i]);
        printf("\n");
    }
}

int main(){
    Lista tabela[TAM];
    int opcao, valor, retorno, i;
    iniciarTabela(tabela);
    // Testando a insersão de 10000 valores em um hash de 10
    srand(time(NULL));
    for (i=0; i < 10000; i++){ // Insere 10000 valores
        valor = rand() % 100000;
        inserir(tabela, valor);
    }
    imprimir(tabela);
    // do{
    //     printf("\n\t0 - Sair\n\t1 - Inserir\n\t2 - Buscar\n\t3 - imprimir\n");
    //     scanf("%d", &opcao);
    //     switch(opcao){
    //         case 1: 
    //             printf("Qual valor deseja Inserir? ");
    //             scanf("%d", &valor);
                // inserir(tabela, valor);
    //             break;
    //         case 2:
    //             printf("Qual valor deseja buscar? ");
    //             scanf("%d", &valor);
    //             retorno = busca(tabela, valor);
    //             if(retorno != 0)
    //                 printf("Valor encontrado: %d\n", retorno);
    //             else
    //                 printf("Valor não encontrado");
    //             break;
    //         case 3:
                // imprimir(tabela);
    //             break;
    //         default:
    //             printf("Opçao inválida\n");
    //             break;
    //     }
    // }while(opcao!=0);

    return 0;
}
