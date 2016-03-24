#include <iostream>
#include <string>

using namespace std;
string RLE(string& input_string);

class RLENode {
	public:
		RLENode* next;
		char character;
		int char_num;
		RLENode(){
			next = NULL;
		}
};

int main(int argc, char* argv[]){
	string input_string;
	if(argc > 1){
		input_string = string(argv[1]);
	} else {
		cout << "YOU HAVE FAILED TO PROVIDE A STRING ON THE COMMAND LINE. YOUR RENTAL STRING IS BOORRROOOOMMMMMIIIIIIRRRRRRR.\n";
		char rental [] = "BOORRROOOOMMMIIR";
		input_string = string(rental);
	}
	cout << input_string << " => " << RLE(input_string) << endl;

}

string RLE(string& input_string){
	string output = "";
	int string_length = input_string.length();
	if(string_length < 1){
		return output;
	}
	int i = 0;
	RLENode RLEHead;
	RLEHead.char_num = 0;
	RLEHead.next = new RLENode();
	RLEHead.next->char_num = 1;
	// cout << RLEHead.next->char_num << endl;
	// RLENode RLECur = RLEHead;
	int curctr = 1;
	for(int i = 1; i < string_length; i++){
		if(input_string.at(i) != input_string.at(i-1)){
			cout << curctr << input_string.at(i-1) << endl;
			curctr = 1;
		}else{
			curctr++;
		}
	}
	cout << curctr << input_string.at(string_length-1) << endl;
	return output;
}
