#include <iostream>
#include <string>
#include <iomanip>

using namespace std;

// ============================================================================
// Employee Class Definition
// ============================================================================
class Employee
{
private:
    int empId;
    string name;
    string department;
    char grade;
    double basicSalary;
    bool isActive;

    static int employeeCount;

public:
    // Constructor: Auto-assigns ID and increments static employeeCount
    Employee()
    {
        employeeCount++;
        empId = 1000 + employeeCount;
        name = "Unknown";
        department = "Engineering";
        grade = 'D';
        basicSalary = 15000.0;
        isActive = true;
    }

    // --- Setters with Validation ---

    void setName(const string &n)
    {
        if (n.empty())
        {
            cout << "ERROR: Name cannot be empty. Value rejected." << endl;
        }
        else
        {
            name = n;
        }
    }

    void setDepartment(const string &dept)
    {
        if (dept == "Engineering" || dept == "HR" || dept == "Finance" || dept == "Operations")
        {
            department = dept;
        }
        else
        {
            cout << "ERROR: '" << dept << "' is not a registered department." << endl;
        }
    }

    void setGrade(char g)
    {
        if (g == 'A' || g == 'B' || g == 'C' || g == 'D')
        {
            grade = g;
        }
        else
        {
            cout << "ERROR: Invalid grade '" << g << "'. Accepted values: A, B, C, D." << endl;
        }
    }

    void setBasicSalary(double salary)
    {
        if (salary > 10000.0 && salary < 500000.0)
        {
            basicSalary = salary;
        }
        else
        {
            cout << "ERROR: Salary must be between Rs.10,000 and Rs.5,00,000. Value rejected." << endl;
        }
    }

    void deactivate()
    {
        isActive = false;
    }

    // --- Getters (const) ---

    int getEmpId() const { return empId; }
    string getName() const { return name; }
    string getDepartment() const { return department; }
    char getGrade() const { return grade; }
    double getBasicSalary() const { return basicSalary; }
    bool getIsActive() const { return isActive; }

    // --- Business Logic (const) ---

    double computeAllowances() const
    {
        switch (grade)
        {
        case 'A':
            return 0.40 * basicSalary; // 40%
        case 'B':
            return 0.30 * basicSalary; // 30%
        case 'C':
            return 0.20 * basicSalary; // 20%
        case 'D':
            return 0.10 * basicSalary; // 10%
        default:
            return 0.0;
        }
    }

    double computeGrossSalary() const
    {
        return basicSalary + computeAllowances();
    }

    double computeTax() const
    {
        double gross = computeGrossSalary();
        if (gross <= 50000.0)
        {
            return 0.0;
        }
        else if (gross <= 100000.0)
        {
            return 0.10 * (gross - 50000.0);
        }
        else
        {
            return 5000.0 + 0.20 * (gross - 100000.0);
        }
    }

    double computeNetSalary() const
    {
        return computeGrossSalary() - computeTax();
    }

    void printPayslip() const
    {
        cout << "\n============================================" << endl;
        cout << "EMPLOYEE PAYSLIP — AUG 2026" << endl;
        cout << "============================================" << endl;
        cout << left << setw(14) << "Emp ID" << ": " << empId << endl;
        cout << left << setw(14) << "Name" << ": " << name << endl;
        cout << left << setw(14) << "Department" << ": " << department << endl;
        cout << left << setw(14) << "Grade" << ": " << grade << endl;
        cout << left << setw(14) << "Status" << ": " << (isActive ? "Active" : "Inactive") << endl;
        cout << "-------------------------------------------" << endl;

        int allowPct = (grade == 'A' ? 40 : (grade == 'B' ? 30 : (grade == 'C' ? 20 : 10)));
        string allowLabel = "Allowances (" + to_string(allowPct) + "%)";

        cout << fixed << setprecision(2);
        cout << left << setw(18) << "Basic Salary" << ":  Rs. " << right << setw(10) << basicSalary << endl;
        cout << left << setw(18) << allowLabel << ":  Rs. " << right << setw(10) << computeAllowances() << endl;
        cout << left << setw(18) << "Gross Salary" << ":  Rs. " << right << setw(10) << computeGrossSalary() << endl;
        cout << "-------------------------------------------" << endl;
        cout << left << setw(18) << "Tax Deduction" << ":  Rs. " << right << setw(10) << computeTax() << endl;
        cout << left << setw(18) << "Net Salary" << ":  Rs. " << right << setw(10) << computeNetSalary() << endl;
        cout << "============================================\n"
             << endl;
    }

    // Static member function
    static int getEmployeeCount()
    {
        return employeeCount;
    }

    // Accept details through setters
    void acceptDetails()
    {
        string n, dept;
        char g;
        double sal;

        cout << "\n--- Enter Employee Details (ID: " << empId << ") ---" << endl;
        cout << "Enter Name: ";
        getline(cin >> ws, n);
        setName(n);

        cout << "Enter Department (Engineering, HR, Finance, Operations): ";
        getline(cin >> ws, dept);
        setDepartment(dept);

        cout << "Enter Grade (A, B, C, D): ";
        cin >> g;
        setGrade(g);

        cout << "Enter Basic Salary: ";
        cin >> sal;
        setBasicSalary(sal);
    }
};

// Initialize static member
int Employee::employeeCount = 0;

// ============================================================================
// Bonus: Struct Padding Demonstration
// ============================================================================
struct Layout1
{
    char c1;
    int i;
    char c2;
};
struct Layout2
{
    int i;
    char c1;
    char c2;
};

/*
 * BONUS — STRUCT PADDING EXPLANATION:
 *
 * 1. Why sizes differ:
 *    - Layout1 requires 12 bytes: 'c1' (1 byte) + 3 bytes padding, 'i' (4 bytes), 'c2' (1 byte) + 3 bytes padding.
 *    - Layout2 requires 8 bytes: 'i' (4 bytes), 'c1' (1 byte), 'c2' (1 byte) + 2 bytes padding at the end.
 *
 * 2. Why compiler adds padding:
 *    - Modern CPUs fetch data from memory aligned on 4-byte or 8-byte boundaries for hardware bus efficiency.
 *    - Padding prevents unaligned memory access penalties.
 *
 * 3. Why order matters in hardware / network packets:
 *    - Hardware chips and network protocols expect exact byte offsets without compiler-inserted padding bytes.
 *    - Mismatched ordering causes fields to misalign and corrupt transmitted data.
 */

// ============================================================================
// main() Function
// ============================================================================
int main()
{
    // 1. Create objects — one on stack, two on heap
    Employee e1;
    Employee *e2 = new Employee();
    Employee *e3 = new Employee();

    // 2. Accept details
    e1.acceptDetails();
    e2->acceptDetails();
    e3->acceptDetails();

    // ------------------------------------------------------------------------
    // ENCAPSULATION DEMONSTRATION:
    // Trying to uncomment the following lines causes compiler errors:
    //
    // e1.empId = 999;
    // e1.basicSalary = -1000;
    //
    // WHY COMPILER ERROR OCCURS:
    // 'empId' and 'basicSalary' are private members of the Employee class.
    // Encapsulation prevents external direct access to protect data integrity.
    // Modifications must strictly go through validated public setters.
    // ------------------------------------------------------------------------

    // 3. Print Payslips
    e1.printPayslip();
    e2->printPayslip();
    e3->printPayslip();

    // 4. Simulate resignation
    e3->deactivate();
    if (!e3->getIsActive())
    {
        cout << e3->getName() << " is no longer active. Payroll skipped." << endl;
    }

    // 5. Static count
    cout << "Total Employees : " << Employee::getEmployeeCount() << endl;

    // 6. Bonus Struct Padding Output
    cout << "\n--- Bonus: Struct Padding ---" << endl;
    cout << "sizeof(Layout1) : " << sizeof(Layout1) << " bytes" << endl;
    cout << "sizeof(Layout2) : " << sizeof(Layout2) << " bytes" << endl;

    // 7. Clean up heap memory
    delete e2;
    delete e3;

    return 0;
}