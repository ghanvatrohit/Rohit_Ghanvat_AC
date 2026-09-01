#include <iostream>
#include <iomanip>
#include <string>
#include "Product.h"

using namespace std;

// ========================================
// FUNCTION OVERLOADING

// Integer quantity
double reorderCost(int qty, double unitPrice)
{
    return qty * unitPrice;
}

// Fractional quantity
double reorderCost(double qty, double unitPrice)
{
    return qty * unitPrice;
}

// Integer quantity with tax
double reorderCost(int qty, double unitPrice, double taxRate)
{
    double cost = qty * unitPrice;
    double tax = cost * taxRate / 100;

    return cost + tax;
}

// ========================================
// DEFAULT ARGUMENT

double applyDiscount(double price, double discountPercent = 10.0)
{
    double discount = price * discountPercent / 100;

    return price - discount;
}



int main()
{
    // ========================================
    // PART A - ARRAY OF OBJECTS

    Product products[5];

    cout << "===== ENTER PRODUCT DETAILS =====\n";

    for (int i = 0; i < 5; i++)
    {
        cout << "\n--- Product " << i + 1 << " ---\n";

        products[i].acceptDetails();
    }

    // ========================================
    // INVENTORY REPORT

    cout << "\n\n===== INVENTORY REPORT =====\n";

    cout << left
         << setw(8) << "ID"
         << setw(15) << "Name"
         << right
         << setw(10) << "Price"
         << setw(8) << "Qty"
         << setw(15) << "Total Value"
         << endl;

    cout << string(70, '-') << endl;

    for (int i = 0; i < 5; i++)
    {
        products[i].displayDetails();
    }

    // ========================================
    // HIGHEST TOTAL VALUE

    int highestIndex = 0;

    for (int i = 1; i < 5; i++)
    {
        if (products[i].totalValue() >
            products[highestIndex].totalValue())
        {
            highestIndex = i;
        }
    }

    cout << "\nHighest Value Product : "
        << products[highestIndex].getName()
        << " (Rs. "
        << fixed << setprecision(2)
        << products[highestIndex].totalValue()
        << ")" << endl;

    // ========================================
    // LOW STOCK PRODUCTS


    int threshold;

    cout << "\nEnter Low Stock Threshold: ";
    cin >> threshold;

    cout << "\nLow Stock (threshold: "
        << threshold << ") : ";

    bool found = false;

    for (int i = 0; i < 5; i++)
    {
        if (products[i].isLowStock(threshold))
        {
            cout << products[i].getName() << " ";
            found = true;
        }
    }

    if (!found)
    {
        cout << "None";
    }

    cout << endl;

    // ========================================
    // PART B - FUNCTION OVERLOADING

    cout << "\n\n===== REORDER COST =====\n";

    int qty = 10;
    double unitPrice = 250.0;

    // Calls reorderCost(int, double)
    cout << "Integer Quantity Cost : Rs. "
        << reorderCost(qty, unitPrice)
        << endl;

    double fractionalQty = 12.5;

    // Calls reorderCost(double, double)
    cout << "Fractional Quantity Cost : Rs. "
        << reorderCost(fractionalQty, unitPrice)
        << endl;

    double taxRate = 18.0;

    // Calls reorderCost(int, double, double)
    cout << "Cost With Tax : Rs. "
        << reorderCost(qty, unitPrice, taxRate)
        << endl;

    // ========================================
    // DEFAULT ARGUMENT

    cout << "\n===== DISCOUNT =====\n";

    double originalPrice = 1000.0;


    cout << "Price after default 10% discount : Rs. "
        << applyDiscount(originalPrice)
        << endl;


    cout << "Price after 20% discount : Rs. "
        << applyDiscount(originalPrice, 20.0)
        << endl;

    return 0;
}