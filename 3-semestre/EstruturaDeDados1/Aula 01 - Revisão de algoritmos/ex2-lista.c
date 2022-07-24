#include <stdio.h>
#include <stdlib.h>
#define W 2
#define H 3

typedef struct{
    int r;
    int g;
    int b;
} Pixel;


// Prototipação
Pixel* alocaPixel();
void carregaPixel(Pixel*);
void escrevePixel(Pixel*);

// Pixel
Pixel* alocaPixel(){
    return (Pixel*) malloc (sizeof(Pixel));
}
void carregaPixel(Pixel* p){
    printf("Digite o valor para a cor vermelha: ");
    scanf("%i", &p->r);
    printf("Digite o valor para a cor verde: ");
    scanf("%i", &p->g);
    printf("Digite o valor para a cor azul: ");
    scanf("%i", &p->b);
}
void escrevePixel(Pixel* p){
    printf("\nO valor para a cor vermelha é: %i", p->r);
    printf("\nO valor para a cor verde é: %i", p->g);
    printf("\nO valor para a cor azul é: %i", p->b);
}
// Imagem

// Imagem* alocaImagem(int width, int height){
Imagem* alocaImagem(int size){
    return (Imagem*) malloc (sizeof(Imagem) * size);
}
void carregaAlunoImagem(Imagem* imagem, int width, int height){
    int i;
    int j;
    for (i = 0; i < height; i++){
        for(j = 0; j < width; j++){
            printf("\n### Dados do pixel (%i,%i)",height,width);
            Pixel* p = alocaPixel();
            carregaPixel(p);
        }
    }
}
void escreveImagem(Imagem* imagem, int width, int height){
    int i;
    int j;
    printf("#x### Dados da imagem ####");
    for (i = 0; i < height; i++){
        for(j = 0; j < width; j++){
            printf("\n### Dados do pixel (%i,%i)",height,width);
            printf("Red = %i - Green = %i - Blue = %i",imagem[i][j]->r,imagem[i][j]->g,imagem[i][j]->b);
        }
    }
}

int main(){
    Imagem* img;
    img = alocaImagem( (W * H) );
    carregaImagem(img, W, H);
    return 0;
}