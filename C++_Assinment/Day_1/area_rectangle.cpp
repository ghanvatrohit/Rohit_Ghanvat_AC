#include <iostream>

int main(){
    double length, breadth;

    std::cout << "Enter length of rectangle : ";
    std::cin >> length;

    std::cout <<"Enter breadth of rectangle : ";
    std::cin >> breadth;

    std::cout<<"Area of rectangle : "<<(length*breadth)<< std::endl;
    return 0;
}