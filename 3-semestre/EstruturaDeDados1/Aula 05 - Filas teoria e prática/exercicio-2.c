#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

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

// Fim alocação de memória

// --------------------------

// Prototipacao

Lista* criaLista();
Elemento* criaElemento(int);
void insereElemento(Lista*, int);
void leituraDeElemento(Elemento*);
void leituraDaLista(Lista*);
void removeElemento(Lista*);
bool empty(Lista*);
void pqmindelete(Lista*);
int procuraMenor(Lista*);
void removeMenor(Lista*, int);
int condicionalPQMinDelete(Lista*, int);
void menorValorNoMeio(Lista*, int);
void menorValorNoInicio(Lista*);
void menorValorNoFim(Lista*);

// Fim prototipação

// --------------------------

// Leituras

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

// --------------------------

// Empty

bool empty(Lista* lista){
    if(lista->size>0){
      return false;
    }else{
      return true;
    }
};  

// Insersão

void insereElemento(Lista* lista, int dado){
  Elemento* novo = criaElemento(dado);
  if(lista->size==0){
    lista->head = novo;
    lista->tail = novo;
  }else{
    lista->tail->next = novo;
    novo->prev = lista->tail;
    novo->next = NULL;
    lista->tail = novo;
  }
  lista->size++;
}

// Fim Insersão

// --------------------------

// Remoção

void removeElemento(Lista* lista){
  if(empty(lista)){
    printf("Lista vazia");
  }else{
    Elemento* aux = lista->head;
    aux->next->prev = NULL;
    lista->head = lista->head->next;
    free(aux);
    lista->size--;
  }
}

void pqmindelete(Lista* lista){
  if(empty(lista)){
    printf("Lista vazia");
  }else{
    if(lista->size == 1){
      removeElemento(lista);
    }else{
      int menor = procuraMenor(lista);
      removeMenor(lista, menor);
    }
  }
}

int procuraMenor(Lista* lista){
  int menor = lista->head->dado;
  Elemento* aux = lista->head->next;
  while(aux!=NULL){
    if(aux->dado<menor)
      menor = aux->dado;
    aux = aux->next;
  }
  return menor;
}

void removeMenor(Lista* lista, int menor){
  Elemento* aux;
  int option = condicionalPQMinDelete(lista, menor);
  switch (option){
    case 0: // No meio da fila ou nao existe
      menorValorNoMeio(lista, menor);break;
    case 1: // Inicio da fila
      menorValorNoInicio(lista);break;
    case 2: 
      menorValorNoFim(lista);break;
  }
}

void menorValorNoMeio(Lista* lista, int menor){
  Elemento* aux = lista->head;
  while(aux!=NULL){
    if(aux->dado == menor){
      aux->prev->next = aux->next;
      aux->next->prev = aux->prev;
    }
    aux = aux->next;
  }
}

void menorValorNoInicio(Lista* lista){
  Elemento* aux = lista->head;
  aux->next->prev = NULL;
  lista->head = aux->next;
  free(aux);
}

void menorValorNoFim(Lista* lista){
  Elemento* aux = lista->tail;
  aux->prev->next = NULL;
  lista->tail = aux->prev;
  free(aux);
}

int condicionalPQMinDelete(Lista* lista, int menor){
  if(lista->head->dado == menor)
    return 1;
  if(lista->tail->dado == menor)
    return 2;
  else
    return 0;
}

int main(){
    Lista* lista = criaLista();
    insereElemento(lista, 82);  
    insereElemento(lista, 27); 
    insereElemento(lista, 32);  
    insereElemento(lista, 52);  
    insereElemento(lista, 97); 
    insereElemento(lista, 17); 
    pqmindelete(lista);
    leituraDaLista(lista); 
    return 0;   
}