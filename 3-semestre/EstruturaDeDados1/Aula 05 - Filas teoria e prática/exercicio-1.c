#include <stdio.h>
#include <stdlib.h>
typedef struct sElemento{
    struct sElemento *next;
    struct sElemento *prev;
    int dado;
    int movimentos;
} Elemento;

typedef struct sLista{
    struct sElemento *head;
    struct sElemento *tail;
    int limit;
    int size;
} Lista;

// Prototipacao

Lista* criaLista(int);
Elemento* criaElemento(int);
void insereElementoNaLista(Lista*, Lista*, int, int);
int condicionalInsercaoLista(Lista*);
void inserindoListaVazia(Lista*, Elemento*);
void inserindoListaComVaga(Lista*, Elemento*);
void insereElementoNaListaEspera(Lista*, Elemento*);
void removeElementoDaLista(Lista*, Lista*, int);
void removeHeadLista(Lista*);
int condicionalRemocaoLista(Lista*, int);
void movimentoElementoNaLista(Lista*);
void trocaPosicaoElementos(Lista*);
void repeticaoDaTrocaDeElementos(Lista*, Elemento*, int);
void vagaLiberada(Lista*, Lista*);
void leituraDeElemento(Elemento*);
void leituraDaLista(Lista*);
// Fim prototipação

// --------------------------------------------------

// Alocação de memória

Elemento* criaElemento(int valor){
    Elemento* elemento;
    elemento = (Elemento*) malloc (sizeof(Elemento));
    if(elemento == NULL){
        printf("Impossivel alocar a memoria");
        return NULL;
    }
    else{
        elemento->dado = valor;
        elemento->movimentos = 0;
        return elemento;
    }
}

Lista* criaLista(int limit){
    Lista* lista;
    lista = (Lista*) malloc (sizeof(Lista));
    if(lista == NULL){
        printf("Impossivel alocar a memÃ³ria");
        return NULL;
    }
    else{
        lista->head = NULL;
        lista->tail = NULL;
        lista->size = 0;
        lista->limit = limit;
        return lista;
    }
}

// Fim alocação de memória

// --------------------------------------------------

// Leituras

void leituraDeElemento(Elemento* elemento){
    if(elemento!=NULL){
        printf("\nCarro: %i - Movimentos %i",elemento->dado,elemento->movimentos);
        if(elemento->prev!=NULL){
            printf(", Carro anterior: %i",elemento->prev->dado);
        }
        if(elemento->next!=NULL){
            printf(", Carro posterior: %i",elemento->next->dado);
        }
    }
}

void leituraDaLista(Lista* lista){
    Elemento* aux = lista->head;
    printf("\n######## Leitura da Lista ########");
    while (aux!=NULL){
        leituraDeElemento(aux);
        aux = aux->next;
    }
    leituraDeElemento(aux);
    printf("\n######## Fim da Lista ########\n");
}

// Fim Leituras

// --------------------------------------------------

// Inserções na lista

int condicionalInsercaoLista(Lista* lista){
    if(lista->size == 0){
       return 0;
    }else{
        if(lista->size < lista->limit){
            return 1;   
        }else{
            return 2;
        }
    }
}

void insereElementoNaLista(Lista* lista, Lista* espera, int dado, int movimentos){
    Elemento* novo = criaElemento(dado);
    novo->movimentos = movimentos;
    int opcao = condicionalInsercaoLista(lista);
    switch (opcao){
        case 0: inserindoListaVazia(lista , novo);break;
        case 1: inserindoListaComVaga(lista, novo);break;
        case 2: 
          printf("\nNão há vaga para o carro %i estacionar", novo->dado);
          insereElementoNaListaEspera(espera, novo);
          break;
    }
}

void inserindoListaVazia(Lista* lista ,Elemento* novo){
    printf("\nHá vaga para o carro %i estacionar",novo->dado);
    lista->head = novo;
    lista->tail = novo;
    lista->size++;            
    printf("\nCarro ( %i ) inserido no inicio da fila",novo->dado);
}

void inserindoListaComVaga(Lista* lista ,Elemento* novo){
    lista->tail->next = novo;
    novo->prev = lista->tail; 
    lista->tail = novo;
    lista->size++;
    printf("\nCarro ( %i ) inserido no final da fila",novo->dado);
}

void insereElementoNaListaEspera(Lista* lista, Elemento* novo){
    if(lista->size == 0){ // Caso a lista de espera esteja vazia
        lista->head = novo;
        lista->tail = novo;
        lista->size++;            
        printf("\nCarro ( %i ) inserido no inicio da lista de espera",novo->dado);
    }else{ // Caso a lista de espera já possua carros
        lista->tail->next = novo;
        novo->prev = lista->tail; 
        lista->tail = novo;
        lista->size++;
        printf("\nCarro ( %i ) inserido no final da lista de espera",novo->dado);
    }
}

// Fim inserções 

// --------------------------------------------------

// Remoção na lista 

int condicionalRemocaoLista(Lista* lista, int dado){
    if(lista->head==NULL)
        return 0;
    if(lista->size==1)
        return 1;
    else{
        if(lista->head->dado == dado)
            return 2;
        else
            return 3;
    }
}

void removeElementoDaLista(Lista* lista, Lista* espera, int dado){
    Elemento* aux = lista->head; // Primeiro elemento da lista
    int opcao = condicionalRemocaoLista(lista, dado);
    switch (opcao){
        case 0: 
          printf("Lista vazia!"); 
          break;
        case 1: 
          lista->head = NULL; 
          lista->tail = NULL; 
          lista->size--; 
          break;
        case 2: 
          removeHeadLista(lista);
          movimentoElementoNaLista(lista); 
          vagaLiberada(lista, espera);
          break;
        case 3: 
          repeticaoDaTrocaDeElementos(lista, aux, dado);
          vagaLiberada(lista, espera);
          break;
    }
}

void trocaPosicaoElementos(Lista* lista){
    Elemento* novo = lista->head;
    removeHeadLista(lista);
    printf("\n > O carro %i entrou no fim da fila",novo->dado);
    lista->tail->next = novo;
    novo->prev = lista->tail; 
    novo->next = NULL;
    lista->tail = novo;
    lista->size++;
    movimentoElementoNaLista(lista);
}

void repeticaoDaTrocaDeElementos(Lista* lista, Elemento* aux, int dado){
    trocaPosicaoElementos(lista);
    while (lista->head->dado != aux->dado){
        if(lista->head->dado == dado){
            lista->head->movimentos++;
            removeHeadLista(lista);
            printf(" e foi embora, ele andou %i vezes",lista->head->movimentos);
            movimentoElementoNaLista(lista);
        }
        trocaPosicaoElementos(lista);
    }
}

void removeHeadLista(Lista* lista){
    Elemento* aux = lista->head;
    printf("\n < O carro %i saiu da fila", aux->dado);
    aux->next->prev = NULL;
    lista->head = lista->head->next;
    free(aux);
    lista->size--;
}

void movimentoElementoNaLista(Lista* lista){
    Elemento* aux = lista->head;
    aux->movimentos++;
    while(aux->next!=NULL){
        aux = aux->next;
        aux->movimentos++;
    }
}

void vagaLiberada(Lista* lista, Lista* espera){
  if(espera->size > 1){
    Elemento* novo = espera->head;
    removeHeadLista(espera);
    lista->tail->next = novo;
    novo->prev = lista->tail; 
    novo->next = NULL;
    lista->tail = novo;
    lista->size++;
  }
}

// Fim da remoção

// --------------------------------------------------

int main(){
    Lista* estacionamento = criaLista(5); // Fila de Estacionamento de 5 posições
    Lista* espera = criaLista(-1); // Fila de espera com tamanho infinito
    insereElementoNaLista(estacionamento, espera, 1, 0);
    insereElementoNaLista(estacionamento, espera, 2, 0);
    insereElementoNaLista(estacionamento, espera, 3, 0);
    insereElementoNaLista(estacionamento, espera, 4, 0);
    insereElementoNaLista(estacionamento, espera, 5, 0);
    insereElementoNaLista(estacionamento, espera, 6, 0); //Começou a fila de espera
    insereElementoNaLista(estacionamento, espera, 7, 0);
    insereElementoNaLista(estacionamento, espera, 8, 0);
    insereElementoNaLista(estacionamento, espera, 9, 0);
    insereElementoNaLista(estacionamento, espera, 10, 0);
    insereElementoNaLista(estacionamento, espera, 11, 0);
    insereElementoNaLista(estacionamento, espera, 12, 0);
    removeElementoDaLista(estacionamento, espera, 3);
    removeElementoDaLista(estacionamento, espera, 2);
    removeElementoDaLista(estacionamento, espera, 5);
    removeElementoDaLista(estacionamento, espera, 8);
    leituraDaLista(estacionamento);
    leituraDaLista(espera);
    return 0;   
}