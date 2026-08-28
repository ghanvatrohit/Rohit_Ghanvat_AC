#include <iostream>
#include <bitset>

using namespace std;

int main() {
    // Hardware Registers (Binary representation using 0b prefix)
    int statusReg  = 0b10110001; // Read-only status from chip
    int controlReg = 0b00000000; // Firmware writes control commands here
    int dataReg    = 0b11001010; // Extra register for reassignment demo

    cout << "=== Low-Level Firmware Register Access Demo ===" << endl << endl;

    // -------------------------------------------------------------
    // 1. Pointer to Const Data: const int* regPtr1
    // -------------------------------------------------------------
    const int* regPtr1 = &statusReg;
    cout << "1. regPtr1 (const int*) pointing to statusReg:" << endl;
    cout << "   Current Value (Binary) : " << bitset<8>(*regPtr1) << endl;
    cout << "   Current Value (Decimal): " << *regPtr1 << endl;

    // ATTEMPT 1A: Write through regPtr1 (FAILS)
    // *regPtr1 = 0b11111111; 
    // ERROR: Assignment of read-only location '*regPtr1'. 
    // Explanation: 'const int*' makes the dereferenced data read-only to protect the status register.

    // ATTEMPT 1B: Repoint regPtr1 (ALLOWED by syntax, but demonstrated below)
    regPtr1 = &dataReg; // Allowed: Pointer itself is not const
    cout << "   Repointed to dataReg   : " << bitset<8>(*regPtr1) << endl;
    regPtr1 = &statusReg; // Point back to statusReg

    cout << endl;

    // -------------------------------------------------------------
    // 2. Const Pointer to Data: int* const regPtr2
    // -------------------------------------------------------------
    int* const regPtr2 = &controlReg;
    cout << "2. regPtr2 (int* const) pointing to controlReg:" << endl;
    cout << "   Value Before Write     : " << bitset<8>(*regPtr2) << endl;

    // ATTEMPT 2A: Write through regPtr2 (ALLOWED)
    *regPtr2 = 0b00001111; // Successfully writing control command
    cout << "   Value After Write      : " << bitset<8>(*regPtr2) << " (Write Successful)" << endl;

    // ATTEMPT 2B: Repoint regPtr2 (FAILS)
    // regPtr2 = &dataReg;
    // ERROR: Assignment of read-only variable 'regPtr2'.
    // Explanation: 'int* const' locks the memory address. regPtr2 cannot point to any other register.

    cout << endl;

    // -------------------------------------------------------------
    // 3. Const Pointer to Const Data: const int* const regPtr3
    // -------------------------------------------------------------
    const int* const regPtr3 = &statusReg;
    cout << "3. regPtr3 (const int* const) pointing to statusReg:" << endl;
    cout << "   Locked Value (Binary)  : " << bitset<8>(*regPtr3) << endl;

    // ATTEMPT 3A: Write through regPtr3 (FAILS)
    // *regPtr3 = 0b11110000;
    // ERROR: Assignment of read-only location '*regPtr3'.
    // Explanation: Data is marked const, writing is strictly forbidden.

    // ATTEMPT 3B: Repoint regPtr3 (FAILS)
    // regPtr3 = &dataReg;
    // ERROR: Assignment of read-only variable 'regPtr3'.
    // Explanation: Pointer address is marked const, repointing is strictly forbidden.

    return 0;
}