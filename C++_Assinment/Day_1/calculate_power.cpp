#include <iostream>
using namespace std;

int main(){
    int base, exponent;
    long long result = 1;

    cout<<"Enter base:";
    cin >> base;

    cout<<"Enter positive exponent: ";
    cin >> exponent;

    for(int i=1; i<=exponent; i++){
        result *= base;
    }

    cout << "Result: " << result<<endl;
    return 0;
}