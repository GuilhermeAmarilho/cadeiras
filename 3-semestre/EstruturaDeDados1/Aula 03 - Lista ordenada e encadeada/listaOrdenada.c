#include <stdio.h>
#include <stdlib.h>

typedef struct sElemento{
    struct sElemento *next;
    int dado;
} Elemento;

typedef struct sLista{
    struct sElemento *head;
    struct sElemento *tail;
    int size;
} Lista;

// prototipação
Lista* criaLista();
Elemento* criaElemento();
void insereElementoNaLista(Lista*, Elemento*, int);
void insereElementoNaListaPivoNulo(Lista*, Elemento*, Elemento*);
void insereElementoNaListaComPivo(Lista*, Elemento*, Elemento*);
void removeElementoDaLista(Lista*, Elemento*);
Elemento* pesquisaNaLista(Lista*, int);
void percorreLista(Lista*);
void percorreElemento(Elemento*);

Elemento* criaElemento(int valor){
    Elemento* elemento;
    elemento = (Elemento*) malloc (sizeof(Elemento));
    if(elemento == NULL){
        printf("Impossivel alocar a memória");
        return NULL;
    }
    else{
        elemento->dado = valor;
        return elemento;
    }
}

void liberaMemoriaElemento(Elemento* elemento){
    free(elemento);
}

void liberaMemoriaLista(Lista* lista){
    Elemento* aux;
    Elemento* aux2;
    aux = lista->head;
    while (aux!=NULL){
        aux = lista->head->next;
        removeElementoDaLista(lista,lista->head);
        liberaMemoriaElemento(lista->head);
    }
    free(lista);
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

void insereElementoNaLista(Lista* lista, Elemento* pivo, int valor){
    Elemento* novoElemento;
    novoElemento = criaElemento(valor);
    if(pivo == NULL){
        insereElementoNaListaPivoNulo(lista, pivo, novoElemento);
    }else{
        insereElementoNaListaComPivo(lista, pivo, novoElemento);
    }
    lista->size++;
}

void insereElementoNaListaPivoNulo(Lista* lista, Elemento* pivo, Elemento* novoElemento){
    if(lista->size ==0){
        lista->head = novoElemento;
        lista->tail = novoElemento;
    }else{
        novoElemento->next = lista->head;
        lista->head = novoElemento;
    }
}

void insereElementoNaListaComPivo(Lista* lista, Elemento* pivo, Elemento* novoElemento){
    if(pivo->next==NULL){
        lista->tail->next = novoElemento;
        lista->tail = novoElemento;
    }else{
        novoElemento->next = pivo->next;
        pivo->next = novoElemento;
    }
}

void removeElementoDaLista(Lista* lista, Elemento* pivo){
    Elemento* antigoElemento;
    antigoElemento = criaElemento(0);
    if(lista->size==0){
        printf("\nA lista está vazia!");
    }
    else {
        if(pivo==NULL){
            antigoElemento = lista->head;
            lista->head = lista->head->next;
            if(lista->head==NULL){
                lista->tail = NULL;
                lista->size = 0;
            }else{
                lista->size--;
            }
            liberaMemoriaElemento(antigoElemento);
        }
        else {  // pivo com valor
            if(pivo->next==NULL){
                printf("\nO elemento já é o ultimo item da lista");
            }       
            else{
                antigoElemento = pivo->next;
                pivo->next = antigoElemento->next;
                if(pivo->next == NULL){
                    lista->tail = pivo;
                }
                liberaMemoriaElemento(antigoElemento);
                lista->size--;
            }
        }
    }
}

void percorreLista(Lista* lista){
    Elemento* aux;
    aux = lista->head;
    printf("\n\n######### Dados da Lista #########");
    while(aux!=NULL){
        percorreElemento(aux);
        aux = aux->next; 
    }
}

void percorreElemento(Elemento* elemento){
    if(elemento->next==NULL){
        printf("\nDado do elemento: %i - O elemento é o último da lista.",elemento->dado);
    }else{
        printf("\nDado do elemento: %i - Pivo: %i", elemento->dado, elemento->next->dado);
    }
}

Elemento* pesquisaNaLista(Lista* lista, int valor){
    Elemento* aux;
    int count = 0;
    aux = lista->head;
    while(aux!=NULL){
        count++;
        if(aux->dado==valor){
            printf("\nO valor %i está na posição %i da lista de %i valores.",valor,count + 1,lista->size);
            return aux;
        }else{
            aux = aux->next;
        }
    }
    return NULL;
}

int main(){
    Lista* idades = criaLista();
    
    insereElementoNaLista(idades, idades->head, 10);
    insereElementoNaLista(idades, idades->head, 20);
    insereElementoNaLista(idades, idades->tail, 30);
    // 10, 20, 30 - OK
    percorreLista(idades);
    
    removeElementoDaLista(idades, idades->head);
    // 10, 30 - OK
    percorreLista(idades);
    
    printf("- Busca de valores -");
    pesquisaNaLista(idades, 10);
    
    return 0;
}
