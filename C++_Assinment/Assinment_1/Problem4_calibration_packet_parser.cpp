#include <iostream>

using namespace std;

bool parsePacket(const int *rawData, int size, int **outMin, int **outMax)
{

    if (rawData == nullptr || size <= 0)
    {
        return false;
    }

    const int *minElem = rawData;
    const int *maxElem = rawData;

    for (int i = 1; i < size; i++)
    {
        if (*(rawData + i) < *minElem)
        {
            minElem = rawData + i;
        }
        if (*(rawData + i) > *maxElem)
        {
            maxElem = rawData + i;
        }
    }

    *outMin = const_cast<int *>(minElem);
    *outMax = const_cast<int *>(maxElem);

    return true;
}

int main()
{
    int packet[] = {45, 12, 67, 8, 55, 31};
    int *minPtr = nullptr;
    int *maxPtr = nullptr;

    if (parsePacket(packet, 6, &minPtr, &maxPtr))
    {
        cout << "Calibration Min : " << *minPtr << endl;
        cout << "Calibration Max : " << *maxPtr << endl;
    }

    return 0;
}