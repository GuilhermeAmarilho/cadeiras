# Apresentação

## Aluno
- Guilherme P Amarilho

## Professor
- Manasses Ribeiro

## Cadeira
- Estrutura de dados 1.

## Instituição
- Instituto Federal Catarinense - Campus Videira.

## Curso
- Ciências da computação.

# Projeto final

## 1. Introdução

### 1.1 Objetivo

Este relatório tem por objetivo demonstrar métodos de organização e agrupamento de dados extremamente massivos de forma simples e eficiente.

### 1.2 Escopo

Este projeto, desenvolvido em C, tem como função organizar e separar uma lista de 100.000 (cem mil) nomes utilizando o método de Hash, como falaremos mais adiante. E após, organiza-los de forma alfabética utilizando o método QuickSort, para então, termos uma lista deveras mais simples de ser visualizada.

## 2. Do desenvolvimento

### 2.1	Método de agrupamento

O método de agrupamento utilizado foi o Hashing com encadeamento, que nada mais é que uma lista encadeada bidimensional, onde os elementos que serão referenciados pela lista Hashing é a primeira e ultima lista encadeada interna. Já estas listas internas, possuem os seguintes atributos: Começo e Fim para exercer sua ligação e controle de Elementos internos, Próximo e Anterior para criar a navegação dentre os “elementos” da lista Hashing, Size para controlar o seu tamanho e Chave, para determinar a posição que determinada lista estará dentro da função Hashing.

### 2.2	Função Hash

O objetivo da função de Hash é receber um determinado valor e retornar um número inteiro, que será o identificador para este valor que lhe foi passado. Assim garantindo maior uniformidade da distribuição dos valores. Todavia, este método, se aplicado em um simples Array, pode gerar colisões. Que falaremos na sequência.

#### 2.2.1	Tratamento de colisões

A função de Hashing produz uma colisão quando duas chaves diferentes têm o mesmo valor Hash e são levadas na mesma posição da tabela de Hash. Para resolver este problema, há dois métodos possíveis.
 A sondagem linear, que testa se determinada posição está vaga, caso não, parte para a próxima, e assim sucessivamente até o momento em que todas as vagas estão preenchidas. 
Enquanto o Hashing com encadeamento não possui essa limitação, devido o fato de ser uma lista de tamanho infinito, assim podendo abrigar os dados passados sem gerar problemas.

#### 2.2.2	Hipótese do Hash uniforme.

A hipótese do Hash uniforme prevê que todas as chaves serão plenamente alcançáveis, todavia, não há uma fórmula exata para obtermos  isso, o que torna essa hipótese inalcançável. Como meio de aproximar o máximo possível deste resultado, utilizamos a fórmula `( caractere 1*1 + caractere 2*2 .... + caractere N*N) % TAM`, onde o TAM é o tamanho total da lista Hash, e com isso, obtivemos um ótimo desempenho. 

![Histograma](
    https://github.com/GuilhermeAmarilho/EstruturaDeDados1/blob/main/Aula%2010%20-%20ProjetoFinal/histograma.png
)

Com base no histograma acima, que correlaciona a quantidade de nomes com cada linha da tabela Hash, verificamos que nosso resultado foi parcialmente uniforme. Obtendo uma média de 1901 nomes por cada lista, e um desvio padrão de 64 nomes.

### 2.3	Método QuickSort

Para ordenar os arquivos após seu agrupamento ocorrer, utilizamos a função QuickSort, que tem como base o método dividir para conquistar, esta estratégia consiste em rearranjar as chaves de modo que as chaves "menores" precedam as chaves "maiores".  Em seguida o quicksort ordena as duas sublistas de chaves menores e maiores recursivamente até que a lista completa se encontre ordenada. 

![QuckSort](
    https://github.com/GuilhermeAmarilho/EstruturaDeDados1/blob/main/Aula%2010%20-%20ProjetoFinal/QuickSort.gif
)

## 3. Funcionalidades

O programa conta com os métodos inserir, remover, buscar, quantidade de elementos por chave e gerador de chaves. Onde este último é fundamental para todas as outras operações.               
