//This program determines if a string contains a permutation of another string
//arg1: string to permute
//arg2: string searching for
#include <iostream>
#include <string>

using namespace std;
void permute(string& str, int len);
bool permcomp(string& str, int len, string& compstr);
bool permcomp(string& str, string& compstr);
void swap(string& str, int pos1, int pos2);
bool permcomp(string& str, string& compstr){
	if(str.length() != compstr.length())
		return false;
	return permcomp(str, str.length()-1, compstr);
}
bool permcomp(string& str, int len, string& comp){
	if(len == 0 && str.compare(comp) == 0){
		// cout<<"found"<<endl;
		return true;
	}
	bool result = false;
	for(int i = 0; i <len +1; i++){
		swap(str, len, len - i);
		result = permcomp(str, len-1, comp) || result;
		swap(str, len-i, len);
	}
	return result;
}

void permute(string& str, int len){
	if(len == 0){
		cout << str << endl;
	}
	for(int i = 0; i <len +1; i++){
		swap(str, len, len - i);
		permute(str, len-1);
		swap(str, len-i, len);
	}
}

void swap(string& str, int pos1, int pos2){
	char temp = str.at(pos2);
	str.at(pos2) = str.at(pos1);
	str.at(pos1) = temp;
}

int main(int argc, char* argv[]){
	string input_string;
	string comp_string;
	if(argc > 2){
		input_string = string(argv[1]);
		comp_string = string(argv[2]);
	} else {
		char rental [] = "BOROMIR";
		char rental_comp [] = "BOMIROR";
		cout << "YOU HAVE FAILED TO PROVIDE TWO STRINGS ON COMMAND LINE. YOUR RENTAL STRINGS ARE BOROMIR AND BOMIROR.\n";
		input_string = string(rental);
		comp_string = string(rental_comp);
	}
	cout << permcomp(input_string, input_string.length()-1, comp_string) << endl;
	return 0;	
}