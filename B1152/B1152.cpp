#include <iostream>
#include <string>
#include <sstream>

using namespace std;



int main(){

    string str;
    getline(cin, str);

    int cnt = 0;
    bool isWord = false;
    for(int i=0; i< str.size(); i++){




        if(str[i] == ' '){
            isWord = false;
        }else{
            if(!isWord){
                cnt++;
            }
            isWord = true;
        }

       // cout << "char: " << str[i] << " " <<  "cnt: " << cnt << endl;

    }
    cout << cnt;

}
