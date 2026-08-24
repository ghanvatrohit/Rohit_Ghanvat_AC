#include <iostream>
using namespace std;

int main(){
    double principal, rate, time, si;

    cout<<"Enter the Principal amount: ";
    cin >> principal;

    cout<<"Enter Annual Rate of interest (%): ";
    cin>>rate;

    cout<<"Enter Time (in years): ";
    cin>>time;

    si = ( principal * rate * time ) / 100.0;

    cout<<"Simple Interest = "<< si << endl;
    cout<<"Total Amount = "<<( principal + si )<<endl;

    return 0;
}