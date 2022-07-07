#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>

typedef struct{
  float x;
  float y;
  int posicao;
}Ponto;

int definicaoTotal(){ //define quantos pontos haverá
  int x; 
  printf("\nInforme quantos pontos você deseja inserir na amostra: ");
  scanf("%i",&x);
  return x;
} 

int definicaoRaio(){ //define o tamanho do raio
  int x; 
  printf("\nInforme o raio que você quer usar na amostra: ");
  scanf("%i",&x);
  return x;
}

float randNum(int raio){ //gera um valor em binário 
  float p;
  p = rand()%(raio*100000)/100000.0;
  return p;
}

void contaPi(int total, int pontos){ //aqui ele faz o cálculo final
  float pi;
  pi = 4.0 * pontos / total;
  printf("\nCom base nas %i amostras utilizadas\nO valor aproximado de PI é: %2f\n",total,pi);
  printf("\nDentre %i  pontos totais\n%i estavam inscritos na circunferência \n%i estavam fora da mesma.\n",total,pontos,(total-pontos));
}

int posicaoPonto(Ponto* ponto, int raio){ //testa se o valor está dentro ou fora do circulo
  int posicao;
  if( sqrt( pow(ponto->x,2) + pow(ponto->y,2) ) < raio){
    ponto->posicao = 1;
  }
  else{
    ponto->posicao = 0;
  }
  return posicao;
}

Ponto* aloca_memoria_ponto(){ //aloca memória para o sistema
    Ponto *ponto;
    ponto = (Ponto*) malloc(sizeof(Ponto));
    if (ponto == NULL){
        printf("Erro ao alocar memoria!\n");
    }
    return ponto;
}

Ponto* carrega_ponto(int raio){ //carrega valores para dentro do registro
    Ponto *ponto = aloca_memoria_ponto();
    if (ponto != NULL){
      ponto->x = randNum(raio);
      ponto->y = randNum(raio);
      posicaoPonto(ponto, raio);
    }
    return ponto;
}

void desaloca_memoria_ponto(Ponto **pontos, int total){ //apaga a memória que foi reservada
  int i;
  for (i=0;i<total;i++){
    free(pontos[i]);
  }    
  free(pontos);
}

int geraPontos(int total, Ponto** pontos, int raio){
  int valor = 0,i;
  for (i = 0; i < total; i++){
    pontos[i] = carrega_ponto(raio);
    valor+= pontos[i]->posicao;
  }
  return valor;
}

int main(){
  int i, total = definicaoTotal(), raio = definicaoRaio(), pontosDentro = 0;
  randNum(raio);
  Ponto **pontos = (Ponto**) malloc(sizeof(Ponto*)*total);;
  pontosDentro = geraPontos(total,pontos,raio);
  contaPi(total, pontosDentro);
  desaloca_memoria_ponto(pontos, total);
  return 0;
}