#include<iostream>
#include<string>

using namespace std;

class Stack{
    private:
        int arr[10000];
        int pointer;
    public:
        void push(int v);
        int pop();
        void stackSize();
        int empty();
        int top();
        void setPointer();
};

void Stack::setPointer(){
    pointer = -1;
}

void Stack::push(int v){
    arr[++pointer]=v;
}

int Stack::pop(){
    int t = top();
    if(t != -1){
        pointer --;
    }
    return t;
}

void Stack::stackSize(){
    cout << pointer+1 << "\n";
}

int Stack::empty(){
    int result;
    if(pointer == -1){
        result = 1;
    }else{
        result = 0;
    }
    cout << result << "\n";
    return result;
}

int Stack::top(){
    int result;
    if(pointer != -1){
        result =  arr[pointer];
    }else{
        result =  -1;
    }
    cout << result << "\n";
    return result;
}

 int main(){
     int n;
     cin >> n;

     Stack st;
     st.setPointer();
     for(int i=0; i<n; i++){
         string cmd;
         cin >> cmd;
        
         if(cmd.substr(0,4).compare("push") == 0){
            string strN;
            cin >> strN;
            int n = stoi(strN);
            st.push(n);
         }

         if(cmd.compare("top") == 0){
            st.top();
         }

         if(cmd.compare("size") == 0){
            st.stackSize();
         }

         if(cmd.compare("empty") == 0){
            st.empty();
         }

         if(cmd.compare("pop") == 0){
            st.pop();
         }
     }
 }
