#include <iostream>
using namespace std;

// original bag V1
void resetSensorPairV1(int reading1, int reading2)
{ //<--- void function not return a value
    int temp = reading1;
    reading1 = reading2;
    reading2 = temp;
}

// V2 call by refrence
void resetSensorPairV2(int &reading1, int &reading2)
{ //<--- void function not return a value
    int temp = reading1;
    reading1 = reading2;
    reading2 = temp;
}

void resetSensorPairV3(int *reading1, int *reading2)
{ //<--- void function not return a value
    int temp = *reading1;
    *reading1 = *reading2;
    *reading2 = temp;
}

int main()
{
    /*
     * ROOT CAUSE & DETAILED COMPARISON:
     *
     * 1. Why V1 Fails (Call by Value):
     *    - main() only passes a duplicate copy of values A and B to V1.
     *    - The swap operation happens only on V1's local stack variables.
     *    - Once V1 finishes execution, those local variables are destroyed, leaving A and B in main() untouched.
     *
     * 2. Why V2 Works (Call by Reference - &):
     *    - reading1 and reading2 do not allocate new memory or create copies.
     *    - They act as aliases (alternative names) for the original variables A and B in main().
     *    - Since both share the exact same memory address, swapping values inside V2 immediately modifies the variables in main().
     *
     * 3. Why V3 Works (Call by Pointer - *):
     *    - We pass the memory addresses &A and &B from main() to the function.
     *    - reading1 and reading2 are pointer variables holding those memory addresses.
     *    - Using the dereference operator (*reading1 and *reading2), we directly access and swap the values stored at those memory locations.
     */

    int A = 55;
    int B = 12;

    // Test V1: Call by Value
    cout << "--- V1: Call by Value ---" << endl;
    cout << "Before : A=" << A << "  B=" << B << endl;
    resetSensorPairV1(A, B);
    cout << "After  : A=" << A << "  B=" << B << "     <- values unchanged" << endl
    << endl;

    // Test V2: Call by Reference
    cout << "--- V2: Call by Reference ---" << endl;
    cout << "Before : A=" << A << "  B=" << B << endl;
    resetSensorPairV2(A, B);
    cout << "After  : A=" << A << "  B=" << B << "     <- values swapped" << endl
    << endl;

    // Test V3: Call by Pointer
    cout << "--- V3: Call by Pointer ---" << endl;
    cout << "Before : A=" << A << "  B=" << B << endl;
    resetSensorPairV3(&A, &B);
    cout << "After  : A=" << A << "  B=" << B << "     <- values swapped back" << endl;

    return 0;
}