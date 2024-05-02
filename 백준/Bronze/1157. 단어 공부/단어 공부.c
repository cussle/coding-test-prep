#include <stdio.h>
#include <string.h>

int main() {
    char data[1000000];
    int count[26] = {0};
    int max, res;
    scanf("%s", data);
    
    int size = strlen(data);
    
    for (int i = 0; i < size; i++) {
        if(data[i] >= 'a') count[data[i]-'a']++;
        else count[data[i]-'A']++;
    }
    
    max = count[0];
    res = 0;
    for (int i = 1; i < 26; i++) {
        if (max < count[i]) {
            max = count[i];
            res = i;
        }
        else if((max == count[i])) {
            res = -1;
        }
    }
    
    if (res < 0) printf("?\n");
    else printf("%c\n", res + 'A');

    return 0;
}