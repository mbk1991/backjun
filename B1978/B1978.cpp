#include <iostream>

using namespace std;

int isPrime(int input);

int main(){
    int N;
    cin >> N;

    int result = 0;
    for(int i=0; i<N; i++){
        int tmp;
        cin >> tmp;

        if(isPrime(tmp) == 1){
            result ++;
         }
    }
    cout << result << endl;
}

int isPrime(int input){
    if( input == 1 ){
        return 0;
    }
    for(int i=2; i<input; i++){
        if(input % i == 0){
            return 0;       
        }
    }
    return 1;

}


