#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(void) {
  int i, num;
  srand(time(NULL));
  for (i = 0; i < 150; i++){
    num = rand() % 100;
    printf("%i - ", num);
  }
  return 0;
}