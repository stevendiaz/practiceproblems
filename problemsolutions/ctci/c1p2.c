#include <string.h>
#include <stdio.h>

void reverseString(char *input, int inputSize) {
	int i = 0;
	int j = inputSize - 1;
	while(i < j) {
		//swap with XOR
  		input[i] = input[i] ^ input[j];
  		input[j] = input[i] ^ input[j];
  		input[i] = input[i] ^ input[j];
		i++;
		j--;
	}
}

int main()
{
    char input[] = "Hello World!";
    printf("Pre: %s\n", input);
    reverseString(input, strlen(input));
    printf("Output: %s\n", input);
}