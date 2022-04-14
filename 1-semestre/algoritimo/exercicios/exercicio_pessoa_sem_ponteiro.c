#include <stdio.h>
#define TAM 3
//declaração do Registro
typedef
  struct sPessoa{
    char cpf[14];
    char nascimento[10];
    char nome[50];
    float salario;
  }
Pessoa;

//Prototipo do View
Pessoa carregaPessoa(); //Carrega uma única pessoa
void escrevePessoa(Pessoa); //Escreve uma única pessoa
//Protótipos do Model
void carregaVetorPessoas(Pessoa[]); //Carrega um vetor ("n")
void escreveVetorPessoas(Pessoa[]); //Mostra um vetor ("n")

//Implementação
void carregaVetorPessoas(Pessoa pessoas[]){
  int i;
  for (i = 0; i < TAM; i++){
    pessoas[i] = carregaPessoa();
  }
}

Pessoa carregaPessoa(){
  Pessoa p;
  printf("Digite o cpf da pessoa: ");
  scanf("%s", p.cpf);
  printf("Digite o nome da pessoa: ");
  scanf("%s", p.nome);
  printf("Digite o nascimento da pessoa: ");
  scanf("%s", p.nascimento);
  printf("Digite o salário da pessoa: ");
  scanf("%f", &p.salario);
  return p;
}

void escreveVetorPessoas(Pessoa pessoas[]){
  int i;
  for (i = 0; i < TAM; i++){
    escrevePessoa(pessoas[i]);
  }
}

void escrevePessoa(Pessoa p){
  printf("Dados da pessoa: %s\n", p.nome);
  printf("\tCPF: %s\n", p.cpf);
  printf("\tData de Nascimento: %s\n", p.nascimento);
  printf("\tSalário: %.2f\n", p.salario);
}

int main(void) {
  Pessoa pessoas[TAM];
  carregaVetorPessoas(pessoas);
  escreveVetorPessoas(pessoas);
  return 0;
}