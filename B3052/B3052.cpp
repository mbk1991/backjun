#include<iostream>
#include<string>
#include<cstring>

using namespace std;


class Set{
    private:
        int arr[1001];
        int size;
    public:
        void add(int i);
        int getSize();
        void initMember();
};

void Set::initMember(){
    size = 0;

    for(int i=0; i<sizeof(arr)/sizeof(*arr); i++){
        arr[i] = 0;   
    }

}

void Set::add(int i){
    if(arr[i] != 1){
        arr[i] = 1;
        size++;
    }
}

int Set::getSize(){
    return size;
}

int main(){
      Set set;
      set.initMember();
      int n;
      for(int i=0; i<10; i++){
        cin >> n;  
        set.add( n % 42 );
     }
      cout << set.getSize();
}



