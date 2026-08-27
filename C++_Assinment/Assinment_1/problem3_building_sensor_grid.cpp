#include <iostream>
using namespace std;
const int FLOORS = 3;
const int ROOMS = 3;

void displayReading(double arr[FLOORS][ROOMS], int rows, int cols)
{

    cout << "\tRoom1\tRoom2\tRoom3" << endl;

    for (int i = 0; i < rows; i++)
    {
        cout << "Floor " << (i + 1) << " : ";
        for (int j = 0; j < cols; j++)
        {
            cout << arr[i][j] << "\t";
        }
        cout << endl;
    }
}

void hottestRoom(double arr[FLOORS][ROOMS], int rows, int cols)
{
    double max_temp = arr[0][0];
    int max_rows = 1;
    int max_cols = 1;

    for (int i = 0; i < rows; i++)
    {
        for (int j = 0; j < cols; j++)
        {
            if (arr[i][j] > max_temp)
            {
                max_temp = arr[i][j];
                max_rows = i + 1;
                max_cols = j + 1;
            }
        }
    }
    cout << "Hottest Room  : Floor " << max_rows << ", Room " << max_cols
        << "  →  " << max_temp << "°C" << endl;
}

void avegTemp(double arr[FLOORS][ROOMS], int rows, int cols)
{
    double max_avg = -1.0;
    int hottest_floor = 0;

    for (int i = 0; i < rows; i++)
    {
        double row_sum = 0;
        for (int j = 0; j < cols; j++)
        {
            row_sum += arr[i][j];
        }

        double floor_avg = row_sum / cols;

        if (floor_avg > max_avg)
        {
            max_avg = floor_avg;
            hottest_floor = i + 1;
        }
    }
    cout << "Hottest Floor : Floor " << hottest_floor
        << "  (avg " << max_avg << "°C)" << endl;
}

void thresholdRooms(double arr[FLOORS][ROOMS], int rows, int cols)
{
    int warning_count = 0;

    for (int i = 0; i < rows; i++)
    {
        for (int j = 0; j < cols; j++)
        {
            if (arr[i][j] >= 30.0)
            {
                warning_count++;
            }
        }
    }

    cout << "Rooms at WARNING or above : " << warning_count << endl;
}

int main()
{
    int rows = 3, cols = 3;

    double arr[FLOORS][ROOMS];

    cout << "Enter " << (rows * cols) << " elements: " << endl;
    for (int i = 0; i < rows; i++)
    {
        for (int j = 0; j < cols; j++)
        {
            cin >> arr[i][j];
        }
    }

    displayReading(arr, rows, cols);
    hottestRoom(arr, rows, cols);
    avegTemp(arr, rows, cols);
    thresholdRooms(arr, rows, cols);
}