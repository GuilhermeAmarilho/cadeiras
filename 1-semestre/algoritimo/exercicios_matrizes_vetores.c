//questão 4 - Ler do teclado 12 números inteiros e armazená-los em um vetor N. Em seguida, copiar os elementos pares divisíveis por 3 para o vetor X e os ímpares divisíveis por 5 para o vetor Y.
#include<stdio.h>
int ex4(){
  int n[12], x[12], y[12], i, j, auxx = 0, auxy = 0;
  for (i=0;i<12;i++){
	  printf("\nEscreva um número inteiro: ");
    scanf("%i",&n[i]);
    if((n[i]%2 == 0) && (n[i]%3 == 0)){
      x[auxx] = n[i];
      auxx++;
    }
    if((n[i]%2 == 1) && (n[i]%5 == 0)){
      y[auxy] = n[i];
      auxy++;
    }
  }
  return 0;
}
//Faça um programa em C que leia a idade e a altura de 5 pessoas, armazene cada informação no seu respectivo vetor. Imprima a idade e a altura na ordem inversa a ordem lida.
int ex5(){
  int dados[10], i, j;
  for (i=0;i<10;i++){
    printf("Informe sua idade: ");
    scanf("%i",&dados[i]);
    i++;
    printf("Informe sua altura: ");
    scanf("%i",&dados[i]);
  }
  for(i=9;i>0;i--){
    printf("\naltura da pessoa %i: %i",j,dados[i]);
    i--;
    printf("\nidade da pessoa %i: %i\n",j,dados[i]);
    j++;
  }
  return 0;
}
//questão 10 - Escreva um algoritmo que lê uma matriz M(5,5) e calcula as somas:
#include<stdio.h>
int ex10(){
	int i, x, m[5][5], soma, soma2, somad, somas = 0, somat;
	for(i = 0; i <= 4; i++){ 
		for(x = 0; x <= 4; x++){
	    printf("Digite o %i valor para a linha %i matriz M: ",(x+1), (i+1));
	    scanf("%i", &m[i][x]);
	  }
	}
	for(x = 0; x <= 4; x++){ //soma da linha 4
		soma = soma + m[4][x];
	}
	for(i = 0; i <= 4; i++){//soma da coluna 2
		soma2 = soma2 + m[i][2];
  }
	for(i = 0; i <= 4; i++){//soma da diagonal principal
		for(x = 0; x <= 4; x++){
      if(i == x){	
        somad = somad + m[i][x];
      }
	  }
  }
	for(i = 0; i <= 4; i++){//soma da diagonal secundaria
		for(x = 0; x <= 4; x++){
      if(i + x == 4){
        somas = somas + m[i][x];
      }
    }
  }
	for(i = 0; i <= 4; i++){//soma de todos os elementos da matriz
		for(x = 0; x <= 4; x++){
    	somat = somat + m[i][x];
    }
  }
	printf("\nDa linha 4 de M: %i", soma);
	printf("\nDa coluna 2 de M: %i", soma2);
	printf("\nDiagonal principal: %i", somad);
	printf("\nDiagonal secundaria: %i", somas);
	printf("\nDe toda a matriz: %i\n", somat);
	for(i = 0; i <= 4; i++){ 
		for(x = 0; x <= 4; x++){
	    printf("[ %i ] ", m[i][x]);
	  }
	}
  return 0;
}
//questão 14 - Leia uma matriz 10 x 10 que se refere respostas de 10 questões de múltipla escolha, referentes a 10 alunos. Leia também um vetor de 10 posições contendo o gabarito de respostas que podem ser a, b, c ou d. Seu programa deverá comparar as respostas de cada candidato com o gabarito e emitir um vetor Resultado, contendo a pontuação correspondente.
int ex14(){
	int i, x, gabarito[10], m[10][10], notas[10];  
  for (i=0;i<10;i++){
    printf("Digite a %i resposta da prova: ",(i+1));
    scanf("%i", &gabarito[i]);
  }
	for(i = 0; i < 10; i++){ //pega as respostas dos alunos
		notas[i] = 0;
    for(x = 0; x < 10; x++){
	    printf("Digite a %i resposta da prova do %iº aluno: ",(x+1), (i+1));
	    scanf("%i", &m[i][x]);
      if(gabarito[x] == m[i][x]){
        notas[i]++;
      }
	  }
  }
  for(i=0;i<10;i++){
    printf("O primeiro candidato obteve 0% de acertos na prova",notas[i]);
  }
  return 0;
}
//questão 15 - O tempo que um determinado avião gasta para percorrer o trecho entre duas  localidades distintas está disponível através da seguinte tabela:
int ex15(){
	int i, x, d[7][7], cidade1 = 0, cidade2 = 1; 
  d[0][0] = 0;d[0][1] = 2;d[0][2] = 11;d[0][3] = 6;d[0][4] = 15;d[0][5] = 11;d[0][6] = 1;
  d[1][0] = 2;d[1][1] = 0;d[1][2] =  7;d[1][3] = 12;d[1][4] = 4;d[1][5] = 2;d[1][6] = 15;
  d[2][0] = 11;d[2][1] = 7;d[2][2] = 0;d[2][3] = 11;d[2][4] = 8;d[2][5] = 3;d[2][6] = 13;
  d[3][0] = 6;d[3][1] = 12;d[3][2] = 11;d[3][3] = 0;d[3][4] = 10;d[3][5] = 2;d[3][6] = 1;
  d[4][0] = 15;d[4][1] = 4;d[4][2] = 8;d[4][3] = 10;d[4][4] = 0;d[4][5] = 5;d[4][6] = 13;
  d[5][0] = 11;d[5][1] = 2;d[5][2] = 3;d[5][3] = 2;d[5][4] = 5;d[5][5] = 0; d[5][6] = 14;
  d[6][0] = 1;d[6][1] = 15;d[6][2] = 13;d[6][3] = 1;d[6][4] = 13;d[6][5]= 14;d[6][6] = 0;
  while (cidade1 != cidade2){
    printf("\nInforme qual a primeira cidade: ");
    scanf("%i",&cidade1);
    printf("\nInforme qual a primeira cidade: ");
    scanf("%i",&cidade2);
    printf("O tempo que um avião demora para percorrer de %i até %i é de %i horas.",cidade1,cidade2,d[cidade1][cidade2]);
  } 
  for(i = 0; i < 7; i++){ 
		for(x = 0; x < 7; x++){
	    printf("[ %i ] ", d[i][x]);
	  }
    printf("\n");
	}
  return 0;
}
int main(){
	printf("\nExercício 4!\n");
  ex4();
	printf("\nExercício 5!\n");
  ex5();
	printf("\nExercício 10!\n");
  ex10();
	printf("\nExercício 14!\n");
  ex14();
	printf("\nExercício 15!\n");
  ex15();
  return 0;
}
