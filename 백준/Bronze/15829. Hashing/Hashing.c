#include <stdio.h>

int r = 31;
int M = 1234567891; 

int main(void) {
    int L;
    scanf("%d", &L);
    
    char c[L];
    scanf("%s", c);
    
    // 모듈러 연산
    long sum = 0;
    long pow = 1;
    
    for(int i = 0; i < L; i++) {
        sum += (c[i] - 'a' + 1) * pow % M; 
		pow = pow * r % M;
    }
    
    sum %= M;
    
    printf("%ld", sum);
}