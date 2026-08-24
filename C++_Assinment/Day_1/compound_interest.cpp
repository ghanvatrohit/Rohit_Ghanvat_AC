#include <iostream>
#include <cmath>
using namespace std;

int main(){
    double principal, rate, time, amount, ci;

    cout<<"Enter Principal amount: ";
    cin >>principal;

    cout<<"Enter Annual Interest Rate (%): ";
    cin >>rate;

    cout<<"Enter Time (in years): ";
    cin>>time;

    amount = principal * pow((1 + rate / 100.0), time);
    ci = amount - principal;

    cout<<"\nTotal Amount: "<< amount << endl;
    cout<<"Compound Interest: "<< ci << endl;
    return 0;

}