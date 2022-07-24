#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct sElemento{
    struct sElemento *next;
    struct sElemento *prev;
    int dado;
} Elemento;

typedef struct sPilha{
    struct sElemento *head;
    struct sElemento *tail;
    int size;
} Pilha;

Elemento* criaElemento(int valor){
    Elemento* elemento;
    elemento = (Elemento*) malloc (sizeof(Elemento));
    if(elemento == NULL){
        printf("Impossivel alocar a memoria");
        return NULL;
    }
    else{
        elemento->dado = valor;
        return elemento;
    }
}

Pilha* criaPilha(){
    Pilha* pilha;
    pilha = (Pilha*) malloc (sizeof(Pilha));
    if(pilha == NULL){
        printf("Impossivel alocar a memoria");
        return NULL;
    }
    else{
        pilha->head = NULL;
        pilha->tail = NULL;
        pilha->size = 0;
        return pilha;
    }
}

// Prototipacao

Elemento* criaElemento(int);
Pilha* criaPilha();
void insereElementoNaPilha(Pilha*, int);
bool empty(Pilha*);
void removeElementoDaPilha(Pilha*);
int buscaLinear(Pilha*, int);

// Fim prototipacao

// ----------------------------------

// Leitura

void leituraDeElemento(Elemento* elemento){
    if(elemento!=NULL){
        printf("\nElemento: %i",elemento->dado);
        if(elemento->prev!=NULL){
            printf(", Elemento anterior: %i",elemento->prev->dado);
        }
        if(elemento->next!=NULL){
            printf(", Elemento posterior: %i",elemento->next->dado);
        }
    }
}

void leituraDePilha(Pilha* pilha){
    Elemento* aux = pilha->head;
    printf("\n######## Leitura da Pilha ########");
    while(aux!=NULL){
        leituraDeElemento(aux);
        aux = aux->next;
    }
    leituraDeElemento(aux);
    printf("\n######## Fim da Pilha ########\n");
}

// Fim leitura

// ----------------------------------

// Insersao

void insereElementoNaPilha(Pilha* pilha, int dado){
    Elemento* novo = criaElemento(dado);
    if(empty(pilha)){
        pilha->head = novo;
        pilha->tail = novo;
    }else{
        pilha->tail->next = novo;
        novo->prev = pilha->tail;
        novo->next = NULL;
        pilha->tail = novo;
    }
    pilha->size++;
}

// Fim insercao

// ----------------------------------

// Remocao

bool empty(Pilha* pilha){
    if(pilha->size == 0)
        return true;
    else
        return false;
}

void removeElementoDaPilha(Pilha* pilha){
    if(empty(pilha))
        printf("A pilha já está vazia!");
    else{
        if(pilha->size==1){
            pilha->head = NULL;
            pilha->tail = NULL;
            pilha->size--;
        }else{
          pilha->tail->prev->next = NULL;
          pilha->tail = pilha->tail->prev;
        }
    }
}

// Fim remocao

// ----------------------------------


int buscaLinear(Pilha* pilha, int dado){
    Elemento* aux = pilha->head;
    while(aux!=NULL){
        if(aux->dado == dado)
            return dado;
        aux = aux->next;
    }
    return false;
}

int main(){
    Pilha* pilha = criaPilha();
    insereElementoNaPilha(pilha, 12);
    insereElementoNaPilha(pilha, 17);
    insereElementoNaPilha(pilha, 14);
    insereElementoNaPilha(pilha, 19);
    insereElementoNaPilha(pilha, 22);
    insereElementoNaPilha(pilha, 32);
    insereElementoNaPilha(pilha, 45);
    insereElementoNaPilha(pilha, 53);
    insereElementoNaPilha(pilha, 129);
    int i = buscaLinear(pilha, 1929);
    printf("%i",i);
    return 0;
}