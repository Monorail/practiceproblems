//This program determines if a given string is unique.
//Takes one string
#include <iostream>
#include <string>
using namespace std;
static bool unique_char_string(string input, int input_length);


int main(int argc, char* argv[]){
	string input_string;
	if(argc > 1){
		input_string = argv[1];
	} else {
		cout << "YOU HAVE FAILED TO PROVIDE A STRING ON COMMAND LINE. YOUR RENTAL STRING IS BOROMIR.\n";
		input_string = "BOROMIR";
	}
	std::cout << input_string << " is";
	std::cout << (unique_char_string(input_string, input_string.length())?"":" not");
	std::cout << " unique." << endl;
	return 0;
}

//determines if a string is un
static bool unique_char_string(string input, int input_length){
	int unique_ctr [26];
	for (int i = 0; i < 26; i++){
		unique_ctr[i] = 0;
	}
	for (int i = 0; i < input_length; i++){
		int letter = (int) input.at(i);
		if(letter >= 65 && letter <= 90){
			letter -= 65;
		} else if(letter >= 97 && letter <= 122){
			letter -= 97;
		} else {
			continue;
		}
		unique_ctr[letter]++;
		if(unique_ctr[letter] > 1) {
			return false;
		}
	}

	return true;
}