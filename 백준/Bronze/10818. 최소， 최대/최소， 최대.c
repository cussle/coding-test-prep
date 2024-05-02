#include <stdio.h>
#include <string.h>

int main() {
    int repeat;
    scanf("%d", &repeat);
    
    int temp, min = 1000000, max = -1000000;
    
    for (int i = 0; i < repeat; i++) {
        scanf("%d", &temp);
        if(temp > max) max = temp;
        if(temp < min) min = temp;
    }
    
    printf("%d %d", min, max);

    return 0;
}