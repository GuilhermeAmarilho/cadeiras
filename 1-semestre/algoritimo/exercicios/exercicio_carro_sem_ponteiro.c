#include <stdio.h>
#define TAM 1
#define VOGAL 5
#define N 3

//declaração do Registro
typedef
  struct{
    char cor[14];
    int combustivel;
    char nomeP[20];
    int nChassi;
    char mod[50];
    int ano;
    char placaL[7];
    int placaN;
  }
Veiculo;

//Prototipação
Veiculo carregaPlaca();
void carregaVetorPlaca(Veiculo[]);
void escrevePlaca(Veiculo[]);
void escrevePropietario(Veiculo[]);
void escreveModeloCor(Veiculo[]);
void calcularPlaca(Veiculo[]);
void carregaTrocaAlgo(Veiculo []);
void escreveAll(Veiculo[]);

int main(){
  Veiculo carro[TAM];
  carregaVetorPlaca(carro);
  escrevePlaca(carro);
  escrevePropietario(carro);
  escreveModeloCor(carro);
  calcularPlaca(carro);
  carregaTrocaAlgo(carro);
  escreveAll(carro);
  return 0;
}
//Implementação
void carregaVetorPlaca(Veiculo carro[]){
  int i;
  for (i = 0; i < TAM; i++){
    carro[i] = carregaPlaca();
  }
}

Veiculo carregaPlaca(){
  Veiculo c;
  printf("Digite o nome do proprietario: ");
  scanf("%s", c.nomeP);
  printf("\n");
  printf("*DADOS DO VEICULO*\n\n");
  printf("Digite a cor do carro: ");
  scanf("%s", c.cor);
  printf("Utilize: 1- Gasolina, 2- Alcool, 3- Diesel\n\n");
  printf("Digite o tipo de combustivel: ");
  scanf("%i", &c.combustivel);
  printf("Digite o N° do chassi: ");
  scanf("%i", &c.nChassi);
  printf("Digite o modelo do seu carro: ");
  scanf("%s", c.mod);
  printf("Digite o ano do seu carro: ");
  scanf("%i", &c.ano);
  printf("\n");
  printf("* P L A C A *\n\n");
  printf("(NÃO PODE SER O MODELO MERCOSUL!)\n\n");
  printf("PRIMEIRO LETRAS\n");
  printf("Digite a placa do seu carro: ");
  scanf("%s", c.placaL);
  printf("APENAS NUMEROS\n\n");
  printf("Digite a placa do seu carro: ");
  scanf("%i", &c.placaN);
  getchar();
  return c;
}

void escrevePropietario(Veiculo c[]){
  int i;
  for (i = 0; i < TAM; i++){
    if((c[i].ano == 1980) && (c[i].combustivel == 3)){
      printf("DADOS DO PROPRIETARIO CUJO ANO (1980) E COMBUSTIVEL (3)\n");
      printf("\n%s", c[i].nomeP);
    }
  }
  printf("\n");
}
void escrevePlaca(Veiculo c[]){
  int i;
  for(i=0; i<TAM; i++){
    if(((((c[i].placaN == 0) ||( c[i].placaN == 2)) || (c[i].placaN == 4)) || (c[i].placaN == 7)) && (c[i].placaL[i] == ('A'))){
      printf("\n\nDADOS DO PROPRIETARIO CUJO PLACA SEJA 0,2,4,7 E VOGAL (A)\n");
      printf("\n%s", c[i].nomeP);
    }
  }
  printf("\n");
}
//Calcular soma dos numeros da placa cuja soma dos valores numéricos fornece um número par.
void calcularPlaca(Veiculo c[]){
  int i, soma=0,somaP=0, k=0, l=0;
  for (i=0; i<l; i++){
    printf("Digite o %i N° da placa: ", k+1);
    scanf("%i", &somaP);
    soma= soma+ somaP;
    if (soma % 2 ==0){
      printf("\n\nDADOS DO VEICULO CUJO SUA PLACA SEJA VALOR PAR\n\n");
      printf("\n%s", c[i].cor);
      printf("\n%s", c[i].mod);
    }
  }
  printf("\n");
}
//Elabore um algoritmo que liste o modelo e a cor dos veículos cujas placas possuem como segunda letra uma vogal 

void escreveModeloCor(Veiculo c[]){
  int i, j;
  char gabPlaca[VOGAL]= {'A', 'E', 'I', 'O', 'U'};
   for(i=0; i<TAM; i++){
     for(j=0; j<VOGAL; j++){
      if(c[i].placaN == gabPlaca[j]){
        printf("DADOS DO PROPRIETARIO\n");
        printf("%s", c[i].mod);
        printf("%s", c[i].cor);
      }
    }
  }
}

void escreveAll(Veiculo c[]){
  int i;
  for(i=0; i<TAM; i++){
    printf("**DADOS DE TODOS OS VEICULOS**\n");
    printf("\nNome: <%s>", c[i].nomeP);
    printf("\nCor do carro: <%s>", c[i].cor);
    printf("\nCombustivel: <%i>", c[i].combustivel);
    printf("\nChassi: <%i>", c[i].nChassi);
    printf("\nModelo: <%s>", c[i].mod);
    printf("\nAno: <%i>", c[i].ano);
    printf("\nPlaca Letras: <%s>", c[i].placaL);
    printf("\nPlaca Numeros: <%i>", c[i].placaN);
  }
  printf("\n");
}
//Criação de alguma troca do veiculo
void carregaTrocaAlgo(Veiculo c[]){
  int i, chassiNovo=0, op;
  printf("Digite a opção de troca de proprietario 1-Trocar! 0-Não trocar!: ");
  scanf("%i", &op);
  if(op == 1){
   printf("DIGITE O CHASSI DO VEICULO QUE DESEJE ALTERAR O PROPRIETARIO: ");
   scanf("%i", &chassiNovo);
   for(i=0; i<TAM; i++){
    if(c[i].nChassi == chassiNovo){
       printf("Digite o novo nome do  proprietario: ");
       scanf("%s", c[i].nomeP);
      }
   }
 }
 else 
  if(op != 1){
    printf("\n**DADOS NÃO ALTERADOS**\n");
    escreveAll(c);
  }
}