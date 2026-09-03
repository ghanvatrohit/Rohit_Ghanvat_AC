#include <iostream>
#include <string>
#include <iomanip>
#include <stdexcept>
#include <utility>

using namespace std;

class LedgerEntry
{
private:
    string description;
    double *amounts;
    int days;

    static int totalEntries;

public:

    // 1. Constructor
    LedgerEntry(const string &desc, int days){
        this->description = desc;
        this->days = days;

        if (days > 0){
            amounts = new double[days];

            // Initialize all amounts to 0
            for (int i = 0; i < days; i++)
            {
                amounts[i] = 0.0;
            }
        }else{
            amounts = nullptr;
            this->days = 0;
        }

        ++totalEntries;

        cout << "[LedgerEntry Created] "<< description << " ("<< this->days << " days)"<< endl;
    }

    // 2. Copy Constructor
    //    Performs DEEP COPY
    LedgerEntry(const LedgerEntry &other){
        description = other.description;
        days = other.days;

        if (other.amounts != nullptr && days > 0){
            amounts = new double[days];

            for (int i = 0; i < days; i++){
                amounts[i] = other.amounts[i];
            }
        }else{
            amounts = nullptr;
        }

        ++totalEntries;

        cout << "[Copy Constructor] Deep copy created from: "<< other.description<< endl;
    }

    // 3. Move Constructor
    //    Transfers ownership instead of copying the array
    LedgerEntry(LedgerEntry &&other) noexcept{
        description = std::move(other.description);
        amounts = other.amounts;
        days = other.days;

        // Leave source object in valid empty state
        other.amounts = nullptr;
        other.days = 0;
        other.description = "";

        ++totalEntries;

        cout << "[Move Constructor] Ownership transferred from: "<< description<< endl;
    }

    // 4. Copy Assignment Operator
    //    Performs DEEP COPY
    LedgerEntry &operator=(const LedgerEntry &other){
        // Self-assignment check
        if (this != &other){
            // Delete old memory
            delete[] amounts;

            description = other.description;
            days = other.days;

            if (other.amounts != nullptr && days > 0){
                amounts = new double[days];

                for (int i = 0; i < days; i++){
                    amounts[i] = other.amounts[i];
                }
            }else{
                amounts = nullptr;
            }
        }

        return *this;
    }


    // 5. Move Assignment Operator
    //    Transfers ownership
    LedgerEntry &operator=(LedgerEntry &&other) noexcept{
        // Self-assignment check
        if (this != &other){
            // Delete current object's existing memory
            delete[] amounts;

            // Transfer ownership
            description = std::move(other.description);
            amounts = other.amounts;
            days = other.days;

            // Empty the source object
            other.amounts = nullptr;
            other.days = 0;
            other.description = "";

            cout << "[Move Assignment] Ownership transferred from: "<< description<< endl;
        }

        return *this;
    }

    // 6. Destructor
    ~LedgerEntry(){
        delete[] amounts;

        --totalEntries;

        cout << "[Destructor] "<< (description.empty()? "Empty LedgerEntry": description)<< " destroyed"<< endl;
    }

    // 7. Operator+
    //    Adds corresponding daily amounts
    LedgerEntry operator+(const LedgerEntry &other) const{
        // Both ledgers should have same number of days
        if (days != other.days){
            throw invalid_argument(
                "Cannot add ledgers with different number of days."
            );
        }

        LedgerEntry result("Combined", days);

        for (int i = 0; i < days; i++){
            result.amounts[i] =
                amounts[i] + other.amounts[i];
        }

        return result;
    }

    // 8. Operator==
    //    Compares total sum of amounts
    bool operator==(const LedgerEntry &other) const{
        double total1 = 0.0;
        double total2 = 0.0;

        for (int i = 0; i < days; i++){
            total1 += amounts[i];
        }

        for (int i = 0; i < other.days; i++){
            total2 += other.amounts[i];
        }

        return total1 == total2;
    }

    // 9. Operator>
    //    Compares total sum of amounts
    bool operator>(const LedgerEntry &other) const{
        double total1 = 0.0;
        double total2 = 0.0;

        for (int i = 0; i < days; i++){
            total1 += amounts[i];
        }

        for (int i = 0; i < other.days; i++){
            total2 += other.amounts[i];
        }

        return total1 > total2;
    }

    // 10. Non-const Subscript Operator
    //     Allows modification
    double &operator[](int index){
        if (index < 0 || index >= days){
            throw out_of_range("Invalid day index.");
        }

        return amounts[index];
    }

    // 11. Const Subscript Operator
    //     Allows read-only access
    const double &operator[](int index) const{
        if (index < 0 || index >= days){
            throw out_of_range("Invalid day index.");
        }

        return amounts[index];
    }


    // 12. Friend Stream Insertion Operator <<
    friend ostream &operator<<(
        ostream &out,
        const LedgerEntry &entry
    );


    // 13. Friend Stream Extraction Operator >>
    friend istream &operator>>(
        istream &in,
        LedgerEntry &entry
    );

    // 14. Static Member Getter
    static int getTotalEntries(){
        return totalEntries;
    }

    // 15. Check whether object is empty
    //    Used after move operation
    bool isEmpty() const{
        return amounts == nullptr;
    }
};

// Static Member Initialization
int LedgerEntry::totalEntries = 0;

// Friend operator<<
ostream &operator<<(
    ostream &out,
    const LedgerEntry &entry
){
    out << entry.description << " : [";

    double total = 0.0;

    for (int i = 0; i < entry.days; i++){
        out << fixed<< setprecision(2)<< entry.amounts[i];

        total += entry.amounts[i];

        if (i < entry.days - 1){
            out << ", ";
        }
    }

    out << "]  Total: "<< fixed<< setprecision(2)<< total;

    return out;
}

// Friend operator>>
istream &operator>>(
    istream &in,
    LedgerEntry &entry
){
    for (int i = 0; i < entry.days; i++){
        in >> entry.amounts[i];
    }

    return in;
}

// MAIN
int main(){
    try{
        // Objective 1 — Constructor & Deep Copy
        LedgerEntry jan("January Sales", 5);

        jan[0] = 1200.50;
        jan[1] = 3400.00;
        jan[2] = 800.75;
        jan[3] = 2100.00;
        jan[4] = 650.25;


        LedgerEntry feb("February Sales", 5);

        feb[0] = 900.00;
        feb[1] = 2200.50;
        feb[2] = 1750.00;
        feb[3] = 3000.00;
        feb[4] = 475.50;


        cout << endl;

        cout << jan << endl;
        cout << feb << endl;

        // Objective 2 — Operator+
        LedgerEntry combined = jan + feb;

        cout << "Combined: "<< combined<< endl;


        // Objective 3 — Relational Operators
        cout << "Jan == Feb : "<< (jan == feb ? "Yes" : "No")<< endl;

        cout << "Jan  > Feb : "<< (jan > feb ? "Yes" : "No")<< endl;


        // Objective 4 — Move Constructor
        LedgerEntry moved = std::move(jan);

        cout << "After move, jan.amounts is null: "<< (jan.isEmpty() ? "YES" : "NO")<< endl;

        cout << "Moved entry: "<< moved<< endl;

        // Objective 5 — Move Assignment
        LedgerEntry q1("Q1 Total", 5);

        q1 = std::move(feb);

        cout << "Q1 (moved from feb): "<< q1<< endl;

        // Objective 6 — Static Member
        cout << "Live LedgerEntry objects: "<< LedgerEntry::getTotalEntries()<< endl;


        // Extra — Demonstrate Deep Copy
        LedgerEntry copy = moved;

        cout << endl;

        cout << "Deep Copy: "<< copy<< endl;

        // Modify copied object
        copy[0] = 9999.99;

        cout << "After modifying copy:"<< endl;

        cout << "Original moved: "<< moved<< endl;

        cout << "Copy          : "<< copy<< endl;
    }
    catch (const exception &e){
        cout << "Exception: "<< e.what()<< endl;
    }

    return 0;
}

