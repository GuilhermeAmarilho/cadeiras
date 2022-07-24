#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <time.h>

#define TAM 53

// Definições

typedef struct sElemento{
    struct sElemento *next;
    struct sElemento *prev;
    char nome[50];
} Elemento;
typedef struct sLista{
    struct sElemento *head;
    struct sElemento *tail;
	struct sLista *next; 
	struct sLista *prev;
    int size;
    int chave;
} Lista;
typedef struct sHash{
	struct sLista *head;
	struct sLista *tail;
	int size;
} Hash;

// Prototipação 

Elemento*criaElemento(char*);
Lista* criaLista(int);
Hash* criaHash();
void leituraHash(Hash*);
void leituraLista(Lista*);
void leituraElemento(Elemento*);
void iniciaHash(Hash*);
void insereLista(Hash*, int); 
void insereElemento(Hash*, char*);
int obtemChaveHash(char*);
void leituraArquivo(FILE*);
void escreveGraficoTXT(Hash*, FILE*);
void insereElementosDoArquivo(Hash*, FILE*);
void totalElementosPorChave(Hash*);
Lista* buscarLista(Hash*, int);
Elemento* buscarElemento(Hash*, char*);
int removeElemento(Hash*, char*);
void ordenaHash(Hash*);
void ordenaLista(Hash*, int);
void quicksort(Elemento*, Elemento*);
Elemento* separaLista(Elemento*, Elemento*);
void trocaNome(Elemento*, Elemento*);
void menuPrincipal(Hash*);
void menuInserir(Hash*);
void menuBuscarElemento(Hash*);
void menuRemoverElemento(Hash*);
void menuImprimirLista(Hash*);

int main(){
    FILE *file = fopen("nomes.txt", "r");
    FILE *grafico = fopen("grafico.txt","w"); 
    Hash* hash = criaHash();
    iniciaHash(hash);  
    insereElementosDoArquivo(hash, file);
    menuPrincipal(hash);
    escreveGraficoTXT(hash, grafico);
    return 0;
}

// Criações
Elemento* criaElemento(char nome[]){
    Elemento* elemento;
    elemento = (Elemento*) malloc (sizeof(Elemento));
    if(elemento == NULL){
        printf("Impossivel alocar a memoria");
        return NULL;
    }
    else{
    	elemento->next = NULL;
    	elemento->prev = NULL;
    	strcpy(elemento->nome, nome); // String Copy
        return elemento;
    }
}
Lista* criaLista(int chave){
	Lista* lista;
	lista = (Lista*) malloc (sizeof(Lista));
    if(lista == NULL){
        printf("Impossivel alocar a memoria");
        return NULL;
    }
    else{
    	lista->head = NULL;
    	lista->tail = NULL;
    	lista->next = NULL;
    	lista->prev = NULL;
    	lista->size = 0;
    	lista->chave = chave;
    	return lista;
    }
}
Hash* criaHash(){
	Hash* hash;
	hash = (Hash*) malloc (sizeof(Hash));
    if(hash == NULL){
        printf("Impossivel alocar a memoria");
        return NULL;
    }
	hash = (Hash*)malloc(sizeof(Hash));
	hash->head = NULL;
	hash->tail = NULL;
	hash->size = 0;
	return hash;
}
void iniciaHash(Hash* hash){
	int i;
	for(i=0; i<TAM; i++)
		insereLista(hash, i);	
}

// Inserções
void insereLista(Hash* hash, int i){ 
	Lista* nova = criaLista(i);
	if(nova != NULL){
		if(hash->size == 0){
			hash->head = nova;
			hash->tail = nova;
		}else{
			nova->prev = hash->tail;
			hash->tail->next = nova;
			hash->tail = nova;
		}
	hash->size++;
	}
}
void insereElemento(Hash* hash, char nome[]){ 
    Elemento* nova = criaElemento(nome);
    int chave = obtemChaveHash(nome);
    Lista* lista = buscarLista(hash, chave);
    if(lista->size == 0){
        lista->head = nova;
        lista->tail = nova;
    }else{
        nova->prev = lista->tail;
        lista->tail->next = nova;
        lista->tail = nova;
    }
    lista->size++;
}
void insereElementosDoArquivo(Hash* hash, FILE* file){
    char string[50];
    do{
        fscanf(file, "%s", string);
        insereElemento(hash, string);
    }while(fgets(string,50,file) != NULL);
}
int obtemChaveHash(char nome[]){
    int i , tamSring = strlen(nome);
    unsigned int hash = 0, chave;
    for(i = 0; i < tamSring; i++)
        hash+= nome[i] * i;
    chave = hash % TAM; // isso é a chave
    return chave;
}

// Buscas
// Aqui eu deveria mudar para busca binária invéz de busca linear, todavia, busca binária é ideal para array, pois pega posições específicas, já na lista encadeada é mais complexo e ineficiênte, devido o fato de ser impossivel de pegar determinado elemento sem ter de percorrer os seus posteriores ou inferiores.
Elemento* buscarElemento(Hash* hash, char nome[]){
    int chave = obtemChaveHash(nome);
    Lista* lista = buscarLista(hash, chave);
    Elemento* aux = lista->head;
    while (aux){
         if(strcmp(aux->nome, nome) == 0)
             return aux;
        aux = aux->next;
    }       
    return NULL;
}
Lista* buscarLista(Hash* hash, int chave){
    Lista* lista = hash->head;
    while (lista->chave != chave && lista)
        lista = lista->next;
        return lista;
    return NULL;
}

// Remoções

int removeElemento(Hash* hash, char nome[]){
    int chave = obtemChaveHash(nome);
    Lista* lista = buscarLista(hash, chave);
    Elemento* elemento = buscarElemento(hash, nome);
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
        return 1;
    }
    return 0;
}

// Ordenação

void ordenaHash(Hash* hash){
    for (int i = 0; i < TAM; i++)
        ordenaLista(hash, i);
}
void ordenaLista(Hash* hash, int chave){
    Lista* lista = buscarLista(hash, chave);
    Elemento* head = lista->head;
    Elemento* tail = lista->tail; 
    quicksort(head, tail);
}
void quicksort(Elemento* inicio, Elemento* fim){
    Elemento* separador;
    if( fim != NULL && inicio != fim && inicio != fim->next){
        separador = separaLista(inicio, fim);
        quicksort(inicio, separador->prev); // Quebra o começo em duas partes
        quicksort(separador->next, fim); // Quebra o fim em duas partes
    }
}
Elemento* separaLista(Elemento* inicio, Elemento* fim){
    char aux[50];
    Elemento* i = inicio->prev;
    Elemento* j;
    for(j = inicio; j != fim; j = j->next){
        if(strcmp(j->nome, fim->nome) <= 0){
            i = (i == NULL) ? inicio : i->next;
            trocaNome(i, j);
        }
    }
    i = (i == NULL) ? inicio : i->next;
	trocaNome(i,fim);
	return i;
}
void trocaNome(Elemento* nome1,Elemento* nome2){
	char  aux[50];
	strcpy(aux,nome1->nome);
	strcpy(nome1->nome,nome2->nome);	
	strcpy(nome2->nome,aux);
}

// Leituras

void leituraHash(Hash* hash){
    printf("\nLeitura de Lista Hash: Tamanho: %d",hash->size);
    Lista* lista = hash->head;
    while(lista){
        leituraLista(lista);
        lista = lista->next;
    }
    printf("\nFim da leitura de hash");
}
void leituraLista(Lista* lista){
    printf("\n\nLista %i - Tamanho: %i\n",lista->chave, lista->size);
    Elemento* aux = lista->head;
    while(aux){
        leituraElemento(aux);
        if(aux->next)
            printf(", ");
        aux = aux->next;
    }
    printf("\n");
}
void leituraElemento(Elemento* elemento){
    printf("%s",elemento->nome);
}
void leituraArquivo(FILE* file){
    char string[50];
    do{
        fscanf(file, "%s", string);
        printf("\nLinha: %s",string);
    }while(fgets(string,50,file) != NULL);

}
void totalElementosPorChave(Hash* hash){
    printf("\n\nTotal de elementos por lista:");
    Lista* lista = hash->head;
    while(lista){
        printf("\n%i: %i",lista->chave, lista->size);
        lista = lista->next;
    }
    printf("\nFim da leitura de hash\n"); 
}
void escreveGraficoTXT(Hash* hash, FILE* grafico){
	int	i;
    for (i = 0; i < TAM; i++){
	    Lista* l = buscarLista(hash, i);
        fprintf(grafico,"%i\n",l->size);
    }
}

// Menus

void menuPrincipal(Hash* hash){
    int i = -1;
    while (i != 0 ){
    system("clear");
    printf("\n\n\tMenu principal\n\nInforme o que deseja:\n\t1 - Inserir elemento\n\t2 - Buscar elemento\n\t3 - Remover elemento\n\t4 - Imprimir uma lista\n\t5 - Elementos por lista\n\t6 - Ordenar lista\n\nInforme sua opção: ");
        scanf("%i",&i);
        switch(i){
            case 1: 
                menuInserir(hash);
                break;
            case 2: 
                menuBuscarElemento(hash);
                break;
            case 3: 
                menuRemoverElemento(hash);
                break;
            case 4: 
                menuImprimirLista(hash);
                break;
            case 5: 
                totalElementosPorChave(hash);
                break;
            case 6: 
                ordenaHash(hash);
                printf("\nElementos ordenados com sucesso");
                break;
        }
    }
}
void menuInserir(Hash* hash){
	char *nome;
	nome = (char*) malloc((50+1)*sizeof(char));
	printf("\nDigite o nome: ");
	scanf("%s",nome);
    int chave = obtemChaveHash(nome);
    insereElemento(hash, nome);
    printf("\nSeu elemento foi inserido na lista: %d\n",chave);
    int seguraTexto;
    printf("\nPressione qualquer número para avançar!\n");
    scanf("%d",&seguraTexto);
}
void menuBuscarElemento(Hash* hash){
	char *nome;
	nome = (char*) malloc((50+1)*sizeof(char));
	printf("\nDigite o nome: ");
	scanf("%s",nome);
    Elemento* e = buscarElemento(hash, nome);
    int chave = obtemChaveHash(nome);
    if(e)
        printf("\nElemento %s encontrado na lista %d.\n",nome,chave);
    else
        printf("\nElemento não encontrado\n");
    int seguraTexto;
    printf("\nPressione qualquer número para avançar!\n");
    scanf("%d",&seguraTexto);
}
void menuRemoverElemento(Hash* hash){
	char *nome;
	nome = (char*) malloc((50+1)*sizeof(char));
	printf("\nDigite o nome: ");
	scanf("%s",nome);
    int result = removeElemento(hash, nome);
    if(result == 1)
        printf("\nElemento %s removido da lista.\n",nome);
    else
        printf("\nElemento não encontrado\n");
    int seguraTexto;
    printf("\nPressione qualquer número para avançar!\n");
    scanf("%d",&seguraTexto);
}
void menuImprimirLista(Hash* hash){
    int chave;
    printf("\nInforme a lista que deseja exibir: ");
    scanf("%d",&chave);
    Lista* lista = buscarLista(hash, chave);
    leituraLista(lista);
    int seguraTexto;
    printf("\nPressione qualquer número para avançar!\n");
    scanf("%d",&seguraTexto);
}

