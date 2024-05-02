#include <stdio.h>

int main() {
    int h, m;
    scanf("%d %d", &h, &m);
    
    m -= 45;
    h = m < 0 ? h - 1 : h;
    m = m < 0 ? m + 60 : m;
    h = h < 0 ? h + 24 : h;
    
    printf("%d %d\n", h, m);

    return 0;
}