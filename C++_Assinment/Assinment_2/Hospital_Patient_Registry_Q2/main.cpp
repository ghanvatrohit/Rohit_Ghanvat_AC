#include <iostream>
#include "Patient.h"

using namespace std;

int main()
{
     cout << "===== HOSPITAL PATIENT REGISTRY ====="
          << endl
          << endl;

     // 1. THREE STACK OBJECTS
     cout << "Creating stack patients..." << endl
          << endl;

     // Default Constructor
     Patient patient1;

     // Emergency Constructor
     Patient patient2(1002, "Raj Patel");

     // Full Admission Constructor
     Patient patient3(
         1001,
         "Meera Joshi",
         34,
         "Cardiology",
         "B+");

     // DISPLAY FULL PATIENT RECORD
     cout << "\n===== PATIENT RECORD =====" << endl;

     patient3.displayRecord();

     // 2. DYNAMIC ARRAY OF 4 PATIENTS
     cout << "\n===== CREATING DYNAMIC ARRAY ====="
          << endl;

     Patient *patients = new Patient[4];

     // 3. DISPLAY ALL 4 PATIENTS
     cout << "\n===== DYNAMIC PATIENT RECORDS ====="
          << endl;

     for (int i = 0; i < 4; i++)
     {
          patients[i].displayRecord();
     }

     // 4. TRANSFER ONE PATIENT'S WARD
     cout << "\n===== WARD TRANSFER =====" << endl;

     patients[1].transferWard("ICU");

     // 5. DELETE DYNAMIC ARRAY
     cout << "\n===== DELETING DYNAMIC ARRAY ====="
          << endl;

     delete[] patients;

     cout << "\n===== END OF MAIN =====" << endl;

     return 0;
}