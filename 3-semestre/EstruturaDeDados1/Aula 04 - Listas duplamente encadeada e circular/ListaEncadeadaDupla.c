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
Elemento* buscaElemento(Lista*, Elemento*, int, int);
void tratamentoFuncoes(int);
void leituraDeElemento(Elemento*);
void leituraDaLista(Lista*, int);
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
void tratamentoFuncoes(int cod){
    switch (cod){
        case 10: printf("\n###### Insersao de elemento ########\nInsersao realizada com sucesso");break;
        case 11: printf("\n###### Insersao de elemento ########\nErro: só é aceito pivo NULL na inserção do primeiro elemento da lista");break;
        case 20: printf("\n###### Remocao de elemento ########\nRemocao realizada com sucesso");break;
        case 21: printf("\n###### Remocao de elemento ########\nErro: Não é possivel fazer esta remocao");break;
    }
    printf("\n");
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
Elemento* buscarElemento(Lista* lista, Elemento* pivo, int valor, int formato){
    // Caso formato = 1 roda no sentido Head -> Tail; Caso formato = 2 roda no sentido Tail -> Head
    while (pivo!=NULL){
        if(pivo->dado == valor){
            return pivo;
        }else{
            switch(formato){
                case 1: pivo = pivo->next;break;
                case 2: pivo = pivo->prev;break;
            }
        }
    }
    return NULL;
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
void leituraDaLista(Lista* lista, int formato){
    // Caso formato 1, roda Head > Tail, Caso formato 2, roda Tail > Head
    Elemento* aux;
    switch (formato){
        case 1: aux = lista->head;printf("\n\n######## Leitura da Lista Head > Tail ########");break;
        case 2: aux = lista->tail;printf("\n\n######## Leitura da Lista Tail > Head ########");break;
    }
    while (aux!=NULL){
        leituraDeElemento(aux);
        switch (formato){
            case 1: aux = aux->next;break;
            case 2: aux = aux->prev;break;
        }
    }
    printf("\n######## Fim da Lista ########");
}
int main(){
    Lista* valores = criaLista();
    tratamentoFuncoes(insereElementoNaLista(valores, valores->tail, 15)); // 15
    tratamentoFuncoes(insereElementoNaLista(valores, valores->tail, 25)); // 15, 25
    tratamentoFuncoes(insereElementoNaLista(valores, valores->head, 10)); // 15, 10, 25
    tratamentoFuncoes(insereElementoNaLista(valores, NULL, 35)); // Erro
    tratamentoFuncoes(insereElementoNaLista(valores, valores->head, 35)); //15, 35, 10, 25
    
    Elemento* e;
    e = buscarElemento(valores, valores->head,10, 1);
    tratamentoFuncoes(insereElementoNaLista(valores, e, 27)); //15, 35, 10, 27, 25
    tratamentoFuncoes(insereElementoNaLista(valores, valores->tail, 29)); //15, 35, 10, 27, 25, 29
    tratamentoFuncoes(insereElementoNaLista(valores, NULL, 45)); // Erro

    leituraDaLista(valores, 1); // head > tail
    leituraDaLista(valores, 2); // tail > head
    
    tratamentoFuncoes(removeElementoDaLista(valores, valores->tail)); //15, 35, 10, 27, 25
    tratamentoFuncoes(removeElementoDaLista(valores, valores->head)); //35, 10, 27, 25
    tratamentoFuncoes(removeElementoDaLista(valores,NULL)); // erro
    
    e = buscarElemento(valores, valores->head,55, 1);
    tratamentoFuncoes(removeElementoDaLista(valores,e)); // erro
    
    e = buscarElemento(valores, valores->head,27, 1);
    tratamentoFuncoes(removeElementoDaLista(valores,e)); //35, 10, 25
    
    tratamentoFuncoes(removeElementoDaLista(valores, valores->head)); // 10, 25

    e = buscarElemento(valores, valores->head,10, 1);
    tratamentoFuncoes(removeElementoDaLista(valores,e)); // 25
    
    leituraDaLista(valores, 1); // head > tail
    leituraDaLista(valores, 2); // tail > head
    
    return 0;
}