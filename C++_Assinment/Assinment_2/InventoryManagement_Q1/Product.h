#ifndef PRODUCT_H
#define PRODUCT_H

#include <string>
using namespace std;

class Product
{
private:
    int productId;
    string name;
    double price;
    int quantity;

public:
    // Default Constructor
    Product();

    // Parameterized Constructor
    Product(int id, string n, double p, int q);

    // Member Functions
    void acceptDetails();
    void displayDetails() const;
    double totalValue() const;
    bool isLowStock(int threshold) const;

    // Getter
    string getName() const;
};

#endif