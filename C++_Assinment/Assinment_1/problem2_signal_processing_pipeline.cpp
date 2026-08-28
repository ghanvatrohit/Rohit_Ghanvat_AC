#include <iostream>
#include <cmath>
#include <iomanip>
using namespace std;

void printSignal(const double *signal, int n)
{
    cout << "[";
    for (int i = 0; i < n; i++)
    {
        cout << fixed << setprecision(3) << *(signal + i) << " ";
    }
    cout << "]" << endl;
}

double computeRMS(double *signal, int n)
{
    double sumSquares = 0.0;
    for (int i = 0; i < n; i++)
    {
        double val = *(signal + i);
        sumSquares += val * val;
    }
    return sqrt(sumSquares / n);
}

void normalise(double *signal, int n)
{
    double maxAbs = fabs(*signal);

    for (int i = 1; i < n; i++)
    {
        double currentAbs = fabs(*(signal + i));
        if (currentAbs > maxAbs)
        {
            maxAbs = currentAbs;
        }
    }

    if (maxAbs > 0.0)
    {
        for (int i = 0; i < n; i++)
        {
            *(signal + i) = *(signal + i) / maxAbs;
        }
    }
}

int countZeroCrossings(double* signal, int n ){
    int crossings = 0;
    for(int i=0; i<n-1; i++){
        double currentVal = *(signal+i);
        double nextVal = *(signal + i+1);

        if((currentVal > 0 && nextVal < 0)||(currentVal<0 && nextVal>0)){
            crossings++;
        }
    }
    return crossings;
}

void applyGain(double* signal, int n, double gainFactor){
    for(int i=0; i<n; i++){
        *(signal+i) *= gainFactor;
    }
}

int main()
{
    double audioData[] = {0.5, -1.2, 0.8, -0.3, 1.0, -0.9, 0.1};
    int n = sizeof(audioData) / sizeof(audioData[0]);

    cout << "Original Signal          : ";
    printSignal(audioData, n);

    // RMS Calculation
    double rms = computeRMS(audioData, n);
    cout << "RMS Value                : " << fixed << setprecision(4) << rms << endl;

    // Zero Crossings
    int zc = countZeroCrossings(audioData, n);
    cout << "Zero Crossings Count     : " << zc << endl;

    cout << "\n--------------------------------------------------" << endl;

    // Normalisation
    cout << "Before normalise()       : ";
    printSignal(audioData, n);

    normalise(audioData, n);

    cout << "After normalise()        : ";
    printSignal(audioData, n);

    cout << "\n--------------------------------------------------" << endl;

    // Apply Gain (e.g., 2.0x volume boost)
    double gain = 1.5;
    cout << "Applying Gain (" << gain << "x)..." << endl;
    cout << "Before applyGain()       : ";
    printSignal(audioData, n);

    applyGain(audioData, n, gain);

    cout << "After applyGain()        : ";
    printSignal(audioData, n);

    return 0;
}