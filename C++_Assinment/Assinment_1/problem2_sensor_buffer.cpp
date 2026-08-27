#include <iostream>
#include <iomanip>

using namespace std;

void printArray(double arr[], int n){
    int count = 0;
    cout << "Valid readings   : ";

    for (int i = 0; i < n; i++){
        if (arr[i] < 0){
            count++;
            continue;
        }
        cout << arr[i] << "  ";
    }
    cout << endl;
    cout << "Skipped (errors) : " << count << endl;
}


void firstCritical(double arr[], int n){
    for (int i = 0; i < n; i++){
        if (arr[i] >= 45.0){
            cout << "First CRITICAL   : Index " << i << "  →  " << arr[i] << "°C" << endl;
            break;
        }
    }
}


void minMax(double arr[], int n){
    double min = 1e9;
    double max = -1e9;
    double sum= 0;
    int valid_count = 0;

    for (int i = 0; i < n; i++){
        if(arr[i]<0){
            continue;
        }
        if (arr[i] < min){
            min = arr[i];
        }
        if (arr[i]>max){
            max = arr[i];
        }
        
        sum += arr[i];
        valid_count++;
    }

    if (valid_count > 0) {
        double avg = sum / valid_count;
        cout << fixed << setprecision(2);
        cout << "Min : " << min << "°C    Max : " << max << "°C    Avg : " << avg << "°C" << endl;
    }
}

void categoryCount(double arr[], int n ){
        int normal=0;
        int warning=0;
        int critical=0;
        int shutdown=0;

    for(int i=0 ; i<n ; i++){
        if(arr[i]<0){
            continue;;
        }
        
        if(arr[i]<30){
            normal++;
        }else if (arr[i]<45)
        {
            warning++;
        }else if (arr[i]<60)
        {
            critical++;
        }else{
            shutdown++;
        }
    }

    cout << "Normal:" << normal << "   Warning:" << warning << "   Critical:" << critical << "   Shutdown:" << shutdown << endl;
}

int main()
{
    int n;
    cout << "Enter the number: ";
    cin >> n;

    double arr[n];

    cout << "Enter " << n << " readings: " << endl;
    for (int i = 0; i < n; i++){
        cin >> arr[i];
    }

    printArray(arr, n);
    firstCritical(arr, n);
    minMax(arr, n);
    categoryCount(arr,n);

    return 0;
}