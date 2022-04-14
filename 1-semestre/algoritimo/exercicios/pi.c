#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>

typedef struct{
  float x;
  float y;
}Ponto;

float randNum(int raio){
  float p;
  p = rand()%(raio*1000+1)/1000.0;
  return p;
}
int monteCarlo(float x, float y, int raio){
  int aux = 0;
  if( sqrt( pow(x,2) + pow(y,2) ) < raio){
    aux++;
  }
  return aux;
}
void lerPi(int ponto, int total){
  float aux;
  aux = 4 * (ponto + 0.0) / total;
  printf("O valor estimado de PI, seguindo a aproximação de Monte Carlo é: %2.2f",aux);
}

int main(){
  float x, i;
  int pontoCirculo = 0, total, raio;
  printf("Informe o número de pontos que observaremos: ");
  scanf("%i",&total);
  printf("Informe o raio da circunferência: ");
  scanf("%i",&raio);
  for (i=0;i<total;i++){
    pontoCirculo+= monteCarlo(randNum(raio),randNum(raio),raio);
  }
  lerPi(pontoCirculo,total);
  return 0;
}