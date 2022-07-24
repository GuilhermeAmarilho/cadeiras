#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#define MAXLENGHT 50

// Definições

typedef struct sElemento{
    struct sElemento *next;
    struct sElemento *prev;
    char dado;
} Elemento;

typedef struct sPilha{
    struct sElemento *head;
    struct sElemento *tail;
    int size;
} Pilha;

Elemento* criaElemento(char dado){
    Elemento* elemento;
    elemento = (Elemento*) malloc (sizeof(Elemento));
    if(elemento == NULL){
        printf("Impossivel alocar a memoria");
        return NULL;
    }
    else{
        elemento->dado = dado;
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

// Fim definicoes

// -------------------------------------------

// Prototipação 

bool verificaExpressao(char[]);
int verificaTipoString(char);
int testaFechamento(Pilha*, char);
void insereElementoNaPilha(Pilha*, char);
void removeTailPilha(Pilha*);
void leituraGraficaPilha(char[]);
// Fim prototipação

// -------------------------------------------

// Insersão

void insereElementoNaPilha(Pilha* pilha, char dado){
    Elemento* novo = criaElemento(dado);
    if(pilha->size == 0){
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

// Fim insersão

// -------------------------------------------

// Remoção

void removeTailPilha(Pilha* pilha){
    if(pilha->size == 0){
        return;
    }else{        
        Elemento* aux = pilha->tail;
        if(pilha->size == 1){
            pilha->head = NULL;
            pilha->tail = NULL;
        }else{
            aux->prev->next = NULL;
            pilha->tail = aux->prev;
        }
        free(aux);
        pilha->size--;
    }
}

// Fim remoção

// -------------------------------------------

// Verificação

bool verificaExpressao(char str[]){
    Pilha* pilha = criaPilha();
    int i = 0;
    while (str[i] != '\0') {
        int tipoString = verificaTipoString(str[i]);
        if(verificaTipoString(str[i]) != 0){
            if(tipoString % 2 == 1)       
                insereElementoNaPilha(pilha, str[i]);
            else
                if(testaFechamento(pilha, str[i]) == 1)
                    return false;
        }
        i++;
    }
    if(pilha->size != 0)
        return false;
    else
        return true;
}

int verificaTipoString(char dado){
    if(dado == '(')
        return 1;
    if(dado == '{')
        return 3;
    if(dado == '[')
        return 5;
    if(dado == ')')
        return 2;
    if(dado == '}')
        return 4;
    if(dado == ']')
        return 6;
    else
        return 0;
}

int testaFechamento(Pilha* pilha, char dado){
    if(pilha->size == 0)
        return 1;
    else{
        int ultimaAbertura = verificaTipoString(pilha->tail->dado);
        if((ultimaAbertura == 1 && dado == ')') 
            || (ultimaAbertura == 3 && dado == '}')
            || (ultimaAbertura == 5 && dado == ']')
            ){
            removeTailPilha(pilha);
            return 0;
        }else
            return 1;
    }
    return 0; 
}

void leituraGraficaPilha(char str[]){
    bool option = verificaExpressao(str);
    printf("\nA expressão %s é", str);
    if(option)
        printf(" verdadeira");
    else
        printf(" falsa");
}

int main(){
    leituraGraficaPilha("7 – ((x * ((x + y) / (j – 3)) + y) / (4 – 2.5))"); // exemplo 1
    leituraGraficaPilha("((a + b) ou a + b("); // exemplo 2
    leituraGraficaPilha(")a + b(-c ou (a + b)) – (c + d"); // exemplo 3
    leituraGraficaPilha("(A + B} )"); // A 
    leituraGraficaPilha("{[A + B] - [(C - D)]"); // B
    leituraGraficaPilha("(A + B) - C { C + D } - [F + G ]"); // C
    leituraGraficaPilha("((H) * {([J + K])})"); // D
    leituraGraficaPilha("(((A))))"); // E
    leituraGraficaPilha("( A - B {C + D} / A){"); // diff escopo
    leituraGraficaPilha("( A + C {B - D}"); // pilha com itens
    leituraGraficaPilha(" A - b } "); // Underflow
    return 0;
}