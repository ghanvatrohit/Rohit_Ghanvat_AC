#ifndef PATIENT_H
#define PATIENT_H

#include <string>

using namespace std;

class Patient
{
private:
    int patientId;
    string name;
    int age;
    string ward;
    const string bloodGroup;

public:
    // Constructor 1 - Default
    Patient();

    // Constructor 2 - Emergency Admission
    Patient(int id, const string &name);

    // Constructor 3 - Full Admission
    Patient(int id, const string &name, int age,
            const string &ward, const string &bg);

    // Destructor
    ~Patient();

    // Member Functions
    void displayRecord() const;
    void transferWard(const string &newWard);
};

#endif