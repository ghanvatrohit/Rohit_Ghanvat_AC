#include <iostream>
#include "Patient.h"

using namespace std;

// Constructor 1 - Default Constructor
Patient::Patient()
    : patientId(0),
      name("Unknown"),
      age(0),
      ward("General"),
      bloodGroup("O+")
{
    cout << "[Constructor] Default patient registered."
         << endl;
}

// Constructor 2 - Emergency Admission
Patient::Patient(int id, const string &n)
    : patientId(id),
      name(n),
      age(0),
      ward("Emergency"),
      bloodGroup("O+")
{
    cout << "[Constructor] Emergency: "
         << name << endl;
}

// Constructor 3 - Full Admission
Patient::Patient(int id, const string &n, int a,
                 const string &w, const string &bg)
    : patientId(id),
      name(n),
      age(a),
      ward(w),
      bloodGroup(bg)
{
    cout << "[Constructor] Full admission: "
         << name << endl;
}

// Destructor ~
Patient::~Patient()
{
    cout << "[Destructor] Patient "
         << name
         << " discharged."
         << endl;
}

// Display Patient Record ---->
void Patient::displayRecord() const
{
    cout << "\nPatient Record:" << endl;

    cout << "ID        : " << patientId << endl;
    cout << "Name      : " << name << endl;
    cout << "Age       : " << age << endl;
    cout << "Ward      : " << ward << endl;
    cout << "Blood Grp : " << bloodGroup << endl;
}

// Transfer Ward->>>>>>
void Patient::transferWard(const string &newWard)
{
    cout << "Ward Transfer: "
         << name
         << " -> "
         << newWard
         << endl;

    ward = newWard;
}