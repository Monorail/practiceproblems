#include <iostream>
#include <cstring>
using namespace std;
void str_reverse(char* str);
int main(int argc, char* argv[]) {
	char* input_string = new char[30];
	if(argc > 1){
		strcpy(input_string, argv[1]);
	} else {
		cout << "YOU HAVE FAILED TO PROVIDE A STRING ON COMMAND LINE. YOUR RENTAL STRING IS BOROMIR.\n";
		strcpy(input_string, "BOROMIR");
	}
	cout << "Before: " << input_string << endl;
	str_reverse(input_string);
	cout << "After: " << input_string << endl;
	return 0;
}

void str_reverse(char* str){
	int string_length = strlen(str);
	int num_iters = string_length/2;
	for(int i = 0; i < num_iters; i++) {
		char temp = *(str + i);
		*(str + i) = *(str + string_length - 1 - i);
		*(str + string_length - 1 - i) = temp;
	}
}
