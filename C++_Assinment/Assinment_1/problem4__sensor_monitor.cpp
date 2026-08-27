#include <iostream>
#include <cstdlib>

using namespace std;

int main(int argc, char *argv[])
{
    // 1.
    if (argc < 4)
    {
        //    [0]         [1]    [2]             [3]
        cout << "Usage   : ./sensor_monitor <warn> <critical> <num_readings>" << endl;
        cout << "Error   : Missing arguments." << endl;
        return 1;
    }

    // 2.
    int warn = atoi(argv[1]);
    int critical = atoi(argv[2]);
    int num_readings = atoi(argv[3]);

    // 3.
    if (warn >= critical)
    {
        cout << "Error   : Warning threshold must be less than Critical threshold." << endl;
        return 1;
    }

    if (num_readings < 1 || num_readings > 500)
    {
        cout << "Error   : num_readings must be between 1 and 500." << endl;
        return 1;
    }

    // 4.
    cout << "Config  : Warn=" << warn << "°C  Critical=" << critical << "°C  Readings=" << num_readings << endl;

    int normal = 0, warning = 0, crit = 0, shutdown = 0;

    // 5.
    for (int i = 0; i < num_readings; i++)
    {
        int temp = rand() % 70;

        if (temp < warn)
            normal++;
        else if (temp < critical)
            warning++;
        else if (temp < 60)
            crit++;
        else
            shutdown++;
    }

    // 6.
    cout << "Results : Normal:" << normal
        << "  Warning:" << warning
        << "  Critical:" << crit
        << "  Shutdown:" << shutdown << endl;

    return 0;
}