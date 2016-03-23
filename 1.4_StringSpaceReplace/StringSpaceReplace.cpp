//This program sanitizes the spaces strings 
#include <iostream>
#include <cstring>

using namespace std;

void sanitize_string(char* str, int string_length);
int main(){
	char input_str [] = "Hello my name is mudd        ";
	sanitize_string(input_str, strlen(input_str));
	cout << input_str << endl;
	return 0;
}

void sanitize_string(char* str, int string_length){	
	int backiter = string_length-1;
	while(str[backiter] == ' '){
		backiter--;
	}
	//                  e
	//            s       
	// "My name is mudd  %20mudd";
	int sentence_iter = backiter;
	int end_iter = string_length-1;
	do {
		if(str[sentence_iter] == ' '){
			str[end_iter] = '0';
			end_iter--;
			str[end_iter] = '2';
			end_iter--;
			str[end_iter] = '%';
		} else {
			str[end_iter] = str[sentence_iter];
		}
		sentence_iter--;
		end_iter--;

	} while (sentence_iter !=  end_iter && sentence_iter > -1 && end_iter > -1);
}