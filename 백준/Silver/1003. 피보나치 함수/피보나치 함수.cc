#include <stdio.h>

void fib(int n){
    int mem[41][2];
    mem[0][0] = 1;
    mem[0][1] = 0;
    mem[1][0] = 0;
    mem[1][1] = 1;
    
    if(n!=0 && n!=1){
        for(int i=2; i<n+1; i++){
            mem[i][0] = mem[i-1][0] + mem[i-2][0];
            mem[i][1] = mem[i-1][1] + mem[i-2][1];
        }
    }
    printf("%d %d\n", mem[n][0], mem[n][1]);
}
int main()
{
    int T, n;
    scanf(" %d", &T);
    
    for(int i=0; i<T; i++){
        scanf(" %d", &n);
        fib(n);
    }
    return 0;
}
