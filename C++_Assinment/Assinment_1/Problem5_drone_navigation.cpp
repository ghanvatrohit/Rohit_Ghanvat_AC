#include <iostream>
#include <cmath>
#include <iomanip>

using namespace std;


inline double distanceBetween(double x1, double y1, double x2, double y2) {
    double dx = x2 - x1;
    double dy = y2 - y1;
    return sqrt(dx * dx + dy * dy);
}


inline double toRadians(double degrees) {
    const double PI = 3.14159265358979323846;
    return degrees * (PI / 180.0);
}


inline double clamp(double value, double minVal, double maxVal) {
    if (value < minVal) return minVal;
    if (value > maxVal) return maxVal;
    return value;
}


inline bool isInSafeZone(double x, double y, double cx, double cy, double radius) {
    return distanceBetween(x, y, cx, cy) <= radius;
}

int main() {
    const double homeX = 0.0;
    const double homeY = 0.0;
    const double safeRadius = 50.0;

    double waypoints[3][2] = {
        {15.0, 20.0},
        {30.0, 40.0},
        {45.0, 60.0}    
    };

    cout << "=== Drone Flight Controller: Navigation Utilities ===" << endl;
    cout << "Home Base   : (" << fixed << setprecision(1) << homeX << ", " << homeY << ")" << endl;
    cout << "Safe Radius : " << safeRadius << " units\n" << endl;

    for (int i = 0; i < 3; i++) {
        double wx = waypoints[i][0];
        double wy = waypoints[i][1];

        double dist = distanceBetween(homeX, homeY, wx, wy);
        bool safe = isInSafeZone(wx, wy, homeX, homeY, safeRadius);

        cout << "Waypoint " << (i + 1) << " (" << wx << ", " << wy << "):" << endl;
        cout << "  Distance from Home : " << fixed << setprecision(2) << dist << " units" << endl;
        cout << "  Safe Zone Status   : " << (safe ? "INSIDE (Safe)" : "OUTSIDE (Unsafe)") << endl;
        cout << "-----------------------------------------------" << endl;
    }

    return 0;
}