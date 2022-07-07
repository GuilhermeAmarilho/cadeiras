/******************************************************

*****************************************************/
#include <stdio.h>
#include <stdlib.h>

typedef struct{
    char nome[50];
    char cpf[11];
} Aluno;

typedef struct{
    char nome[50];
    char cpf[11];
} Professor;

typedef struct{
    char descricao[50];
    int ch;
    Professor *prof; //dinâmico mas é apenas um
    Aluno **alunos; // dinâmico mas são DIVERSOS alunos
} Turma;

//Prototipação dos módulos
Aluno* aloca_memoria_aluno();
Aluno* carrega_aluno(int);
Professor* aloca_memoria_professor();
Professor* carrega_professor();
Turma* aloca_memoria_turma();
Turma* carrega_turma();
void escreve_turma(Turma*);
Aluno** carrega_alunos_turma(Aluno**);
void desaloca_memoria_turma(Turma*);    


int main()
{
    Turma *t1;
    t1 = carrega_turma();
    escreve_turma(t1);

    desaloca_memoria_turma(t1);
    return 0;
}

void desaloca_memoria_turma(Turma *turma){
    int i;
    i=0;
    while (turma->alunos[i] != NULL){
        printf("Desalocando memoria para o aluno: %s\n", turma->alunos[i]->nome);
        free(turma->alunos[i]);
        i++;
    }
    
    printf("Desalocando memória do professor: %s\n", turma->prof->nome);
    free(turma->prof);
    
    printf("Desalocando memória da turma: %s\n", turma->descricao);
    free(turma);
}

void escreve_turma(Turma* turma){
    int i;
    printf("\n...: Dados da turma: %s ...:\n", turma->descricao);
    printf("\tCarga horaria: %i\n", turma->ch);
    printf("\tProfessor (nome/CPF): %s / %s\n", turma->prof->nome, turma->prof->cpf);
    printf("\tAlunos matriculados\n");
    
    i=0;
    while (turma->alunos[i] != NULL){
        printf("\t\tAluno (nome/CPF): %s / %s\n", turma->alunos[i]->nome, turma->alunos[i]->cpf);
        i++;
    }
}

Turma* aloca_memoria_turma(){
    Turma* turma;
    turma = (Turma*) malloc(sizeof(Turma));
    if (turma == NULL){
        printf("Erro ao alocar memoria!\n");
    }
        
    return turma;
}

Aluno** carrega_alunos_turma(Aluno **alunos){
    int i, continuar;        
    i=0;
    continuar=1; // verdadeiro
    while (continuar){
        if (i == 0){
            alunos = (Aluno**) malloc(sizeof(Aluno));
        } else {
            alunos = (Aluno**) realloc(alunos, sizeof(Aluno));
        }
        alunos[i] = carrega_aluno(i);
        i++;
        printf("Deseja continuar? (0-Nao / 1-Sim: ");
        scanf("%i", &continuar);
        if (!continuar){
            alunos = (Aluno**) realloc(alunos, sizeof(Aluno));
            alunos[i] = NULL;
        }
    }
    
    return alunos;
}

Turma* carrega_turma(){
    Turma *turma;
    turma = aloca_memoria_turma();
    if (turma != NULL){
        printf("Digite a descricao da turma: ");
        scanf("%s", turma->descricao);
        
        printf("Digite o carga horaria da turma: ");
        scanf("%i", &turma->ch);

        turma->prof = carrega_professor();
        
        turma->alunos = carrega_alunos_turma(turma->alunos);
    }
    return turma;
}

Aluno* aloca_memoria_aluno(){
    Aluno *aluno;
    aluno = (Aluno*) malloc(sizeof(Aluno));
    if (aluno == NULL){
        printf("Erro ao alocar memoria!\n");
    }
        
    return aluno;
}

Professor* aloca_memoria_professor(){
    Professor *professor;
    professor = (Professor*) malloc(sizeof(Professor));
    if (professor == NULL){
        printf("Erro ao alocar memoria!\n");
    }
        
    return professor;
}

Aluno* carrega_aluno(int i){
    Aluno *aluno = aloca_memoria_aluno();
    if (aluno != NULL){
        printf("Digite o nome do aluno ( %i ): ", i+1);
        scanf("%s", aluno->nome);
        
        printf("Digite o CPF do aluno ( %i ): ", i+1);
        scanf("%s", aluno->cpf);
    }
    return aluno;
}

Professor* carrega_professor(){
    Professor *professor = aloca_memoria_professor();
    if (professor != NULL){
        printf("Digite o nome do professor: ");
        scanf("%s", professor->nome);
        
        printf("Digite o CPF do professor: ");
        scanf("%s", professor->cpf);
    }
    return professor;
}