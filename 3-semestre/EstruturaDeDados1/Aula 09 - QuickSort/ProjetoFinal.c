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
int insereElementoNaLista(Lista*,Elemento*,int);
int removeElementoDaLista(Lista*, Elemento*);
void leituraDeElemento(Elemento*);
void leituraDaLista(Lista*);
// Fim Prototipacao


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
Lista* criaLista(){
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
        return lista;
    }
}
int insereElementoNaLista(Lista* lista, Elemento* pivo, int dado){
    Elemento* novo = criaElemento(dado);
    if(pivo==NULL && lista->size>0){
        return 11;
    }
    if(lista->size==0){
        lista->head = novo;
        lista->tail = novo;
    }
    else{
        novo->next = pivo->next;
        novo->prev = pivo;
        if(pivo->next==NULL){
            lista->tail = novo;
        }else{
            pivo->next->prev = novo;
        }
        pivo->next = novo;
    }	
    lista->size++;
    return 10;
}
int removeElementoDaLista(Lista* lista, Elemento* elemento){
    if(elemento!=NULL && lista->size>0){
        if(lista->head == elemento){
            lista->head = elemento->next;
            if(lista->head == NULL){
                lista->tail = NULL;
            }else{
                elemento->next->prev = NULL;
            }
        }else{
            elemento->prev->next = elemento->next;
            if(elemento->next == NULL){
                lista->tail = elemento->prev;
            }else{
                elemento->next->prev = elemento->prev;
            }
        }
        free(elemento);
        lista->size--;
        return 20;
    }
    return 21;
}
void leituraDeElemento(Elemento* elemento){
    if(elemento!=NULL){
        printf("\nElemento: %i",elemento->dado);
        if(elemento->prev!=NULL){
            printf(" - Elemento anterior: %i",elemento->prev->dado);
        }
        if(elemento->next!=NULL){
                printf(" - Elemento posterior: %i",elemento->next->dado);
        }
        printf(";");
    }else{
        printf("\nElemento Nulo");
    }
}
void leituraDaLista(Lista* lista){
    printf("\n######## Leitura da lista da Lista ########");
    Elemento* aux = lista->head;
    while (aux!=NULL){
        leituraDeElemento(aux);
        aux = aux->next;
    }
    printf("\n######## Fim da Lista ########");
}
int main(){
    Lista* valores = criaLista();
    return 0;
}