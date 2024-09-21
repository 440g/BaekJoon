#include <stdio.h>
#define max(X, Y) (((X) > (Y)) ? (X) : (Y))

void p12865(){
    int N, K;
    scanf("%d %d", &N, &K);
    int WV[N][2];
    for(int i=1; i<N+1; i++){
        scanf(" %d %d", &WV[i][0], &WV[i][1]);
    }

    int DP[N+1][K+1];
    for (int i=0; i<N+1; i++){
        DP[i][0] = 0;
    }
    for (int i=0; i<K+1; i++){
        DP[0][i] = 0;
    }

    for(int i=1; i<N+1; i++){
        for(int j=1; j<K+1; j++){
            if(j<WV[i][0])
                DP[i][j] = DP[i-1][j];
            else{
                DP[i][j] = max(WV[i][1]+DP[i-1][j-WV[i][0]], DP[i-1][j]);
            }
        }
    }

    printf("%d", DP[N][K]);
}

int main(){
    p12865();
    return 0;
}