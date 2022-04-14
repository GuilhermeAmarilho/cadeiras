
#include <stdio.h>
#include <stdlib.h>

typedef struct{ //q1
  float minimo;
  float maximo;
  float abertura;
  float fechamento;
}Candle;

void lerCandle(Candle* candle){
  printf("\n\tValor de mínima: %2.2f",candle->minimo);
  printf("\n\tValor de máxima: %2.2f",candle->maximo);
  printf("\n\tAbriu com %2.2f valor",candle->abertura);
  printf("\n\tFechou com %2.2f valor\n",candle->fechamento);
}

void lerVetorCandle(Candle **candles, int tempo){
  int i;
  for (i=0;i<tempo;i++){
    lerCandle(candles[i]);
  }
}

void lerMedia(float media[], int tempo){
  int i;
  for (i = 0; i < tempo; i++){
    printf("\n\tA média do dia %i foi de %2.2f",(i+1),media[i]);
  }
}

int randCandle(){ //gera um valor em binário 
  int p;
  p = rand()%101;
  return p;
}

Candle* aloca_memoria_candle(){ //aloca memória para o sistema
    Candle *candle;
    candle = (Candle*) malloc(sizeof(Candle));
    if (candle == NULL){
        printf("Erro ao alocar memoria!\n");
    }
    return candle;
}

Candle* carregaCandle(){ //carrega valores para dentro do registro
    Candle *candle = aloca_memoria_candle();
    if (candle != NULL){
      candle->minimo = randCandle();
      candle->maximo = randCandle();
      candle->abertura = randCandle();
      candle->fechamento = randCandle();
    }
    return candle;
}

void desaloca_memoria_candle(Candle **candles, int tempo){ //apaga a memória que foi reservada
  int i;
  for (i=0;i<tempo;i++){
    free(candles[i]);
  }    
  free(candles);
}
void desaloca_memoria_media(float *media){ //apaga a memória que foi reservada
  int i;
  free(media);
}

void geraCandle(Candle** candles, int tempo){ //gera os X valores referente ao tempo
  int i;
  for (i = 0; i < tempo; i++){
    candles[i] = carregaCandle();
  }
}

void geraMedia(float media[],Candle** candles,int tempo){
  int i;
  float med;
  for (i = 0; i < tempo; i++){
    med = (candles[i]->minimo + candles[i]->maximo)/2;
    media[i] = med;
  }
}

void mediaMenorDiaAnterior(float media[],Candle** candles, int tempo){ //acredito que era isso que pedia a questão 5
  int i;
  printf("\n\nOs seguintes dias obtiveram a média maior que a abertura do dia anterior\n");
  for (i = 1; i < tempo; i++){
   if(media[i]<candles[i-1]->abertura){
     printf("\n\tDia %i",i);
     lerCandle(candles[i]);
   }
  }
}

void diaMaiorAmplitude(Candle** candles, int tempo){//acredito que o que pede na questão é para encontrar o dia com menor minimo e maior máxima, ou seja, maior amplitude
  int i, pos = 0;
  float maiorAtual = candles[0]->maximo, menorAtual = candles[0]->minimo;
  for (i = 1; i < tempo; i++){
   if((candles[0]->maximo>maiorAtual)&&(candles[0]->minimo<menorAtual)){
    maiorAtual = candles[0]->maximo;
    menorAtual = candles[0]->minimo;
    pos = i;
   }
  }
  printf("\n\nO dia com maior amplitude foi o %i",(pos+1));
  lerCandle(candles[pos]);
}

int main(){
  int tempo = 30, x;
  float *media;
  media = malloc(tempo * sizeof(float));

  Candle **candles = (Candle**) malloc(sizeof(Candle*)*tempo); //q2

  geraCandle(candles,tempo); //q3
  lerVetorCandle(candles,tempo);

  geraMedia(media,candles,tempo); //q4
  lerMedia(media, tempo);

  diaMaiorAmplitude(candles, tempo); //q5

  mediaMenorDiaAnterior(media,candles,tempo); //q6

  desaloca_memoria_candle(candles, tempo);
  desaloca_memoria_media(media);
  return 0;
}
