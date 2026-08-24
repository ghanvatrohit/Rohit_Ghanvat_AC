#include <iostream>

int main(){
    int num1,num2,temp;

    std::cout << "Enter the First number : ";
    std::cin >> num1;

    std::cout <<"Enter the Second number : ";
    std::cin >> num2;

    temp=num1;
    num1=num2;
    num2=temp;

    std::cout<<"After swapping: First number = "<<num1<<std::endl<<"Second number : "<< num2;
    return 0;
}