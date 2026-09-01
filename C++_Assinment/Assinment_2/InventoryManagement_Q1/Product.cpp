#include <iostream>
#include <iomanip>
#include "Product.h"

using namespace std;

// Default Constructor
Product::Product()
    : productId(0), name(""), price(0.0), quantity(0)
{
}

// Parameterized Constructor
Product::Product(int id, string n, double p, int q)
    : productId(id), name(n), price(p), quantity(q)
{
}

// Accept Product Details
void Product::acceptDetails()
{
    cout << "Enter Product ID: ";
    cin >> productId;

    cout << "Enter Product Name: ";
    cin >> name;

    cout << "Enter Price: ";
    cin >> price;

    cout << "Enter Quantity: ";
    cin >> quantity;
}

// Display Product Details
void Product::displayDetails() const
{
    cout << left << setw(8) << productId
        << setw(15) << name
        << right << setw(10) << fixed << setprecision(2) << price
        << setw(8) << quantity
        << setw(15) << totalValue();

    if (isLowStock(10))
    {
        cout << "  <- LOW STOCK";
    }

    cout << endl;
}

// Calculate Total Value
double Product::totalValue() const
{
    return price * quantity;
}

// Check Low Stock
bool Product::isLowStock(int threshold) const
{
    return quantity < threshold;
}

// Get Product Name
string Product::getName() const
{
    return name;
}