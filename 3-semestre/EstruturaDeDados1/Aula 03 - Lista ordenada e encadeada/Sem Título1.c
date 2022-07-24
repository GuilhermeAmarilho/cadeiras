#include <stdio.h>
#include <stdlib.h>

typedef struct sElemento{
    struct sElemento *next;
    struct sElemento *prev;
    int dado;
} Elemento;

typedef struct sLista{
    struct sElemento *head;
    struct sElemento *tail;
    int size;
} Lista;

// Prototipacao
Lista* criaLista();
Elemento* criaElemento(int);
void insereElementoNaLista(Lista*,Elemento*,int);
void leituraDeElemento(Elemento*);
void leituraDaLista(Lista*);
// Fim Prototipacao

Elemento* criaElemento(int valor){
    Elemento* elemento;
    elemento->dado = valor;
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

Lista* criaLista(){
    Lista* lista;
    lista = (Lista*) malloc (sizeof(Lista));
    if(lista == NULL){
        printf("Impossivel alocar a memória");
        return NULL;
    }
    else{
        lista->head = NULL;
        lista->tail = NULL;
        lista->size = 0;
        return lista;
    }
}

void insereElementoNaLista(Lista* lista, Elemento* pivo, int dado){
    Elemento* novo = criaElemento(dado);
    lista->size++;
}

void leituraDeElemento(Elemento* elemento){
    printf("Elemento: %i",elemento->dado);
    if(elemento->prev!=NULL){
        printf(" - Elemento anterior: %i",elemento->prev->dado);
    }
    if(elemento->next!=NULL){
            printf(" - Elemento posterior: %i",elemento->next->dado);
    }
}

void leituraDaLista(Lista* lista){
    Elemento* aux;
    aux = lista->head;
    printf("\n######## Leitura da Lista ########");
    while (aux!=NULL){
        leituraDeElemento(aux);
        aux = aux->next;
    }
    printf("\n######## Fim da Lista ########");
}

int main(){
    Lista* valores = criaLista();
    
    insereElementoNaLista(valores, valores->tail, 15);
    
    // Elemento* novo = criaElemento(15);
    // leituraDeElemento(novo);
    
    printf("oi");
    leituraDaLista(valores);
    return 0;
}
