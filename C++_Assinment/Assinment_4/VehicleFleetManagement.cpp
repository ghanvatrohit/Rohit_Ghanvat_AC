#include <iostream>
#include <iomanip>
#include <string>
#include <vector>

using namespace std;

class Vehicle
{
protected:
    string registrationNo;
    string ownerName;
    int yearOfManufacture;
    double kmDriven;

public:
    Vehicle(const string& reg, const string& owner, int year, double km)
        : registrationNo(reg), ownerName(owner),
          yearOfManufacture(year), kmDriven(km)
    {
        cout << "[Vehicle Constructor] "
             << registrationNo << " : "
             << ownerName << endl;
    }

    virtual ~Vehicle()
    {
        cout << "[Vehicle Destructor] "
             << registrationNo << endl;
    }

    virtual string vehicleType() const = 0;

    virtual double fuelCost(double kmToTravel) const = 0;

    virtual void describe() const
    {
        cout << "Registration No : " << registrationNo << endl;
        cout << "Owner Name      : " << ownerName << endl;
        cout << "Year            : " << yearOfManufacture << endl;
        cout << "Km Driven       : " << kmDriven << endl;
    }

    double getKmDriven() const
    {
        return kmDriven;
    }

    string getRegNo() const
    {
        return registrationNo;
    }

    string getOwnerName() const
    {
        return ownerName;
    }
};

class Car : public Vehicle
{
private:
    string fuelType;
    double mileageKmpl;

public:
    Car(const string& reg, const string& owner, int year, double km,
        const string& fuel, double mileage)
        : Vehicle(reg, owner, year, km),
          fuelType(fuel),
          mileageKmpl(mileage)
    {
        cout << "[Car Constructor] "
             << registrationNo << endl;
    }

    ~Car() override
    {
        cout << "[Car Destructor] "
             << registrationNo << endl;
    }

    string vehicleType() const override
    {
        return "Car";
    }

    double fuelCost(double kmToTravel) const override
    {
        double fuelPrice;

        if (fuelType == "Petrol")
            fuelPrice = 106.00;
        else
            fuelPrice = 93.00;

        return (kmToTravel / mileageKmpl) * fuelPrice;
    }

    void describe() const override
    {
        Vehicle::describe();
        cout << "Fuel Type       : " << fuelType << endl;
        cout << "Mileage         : " << mileageKmpl << " kmpl" << endl;
    }

    string getFuelType() const
    {
        return fuelType;
    }
};

class Truck : public Vehicle
{
protected:
    double payloadCapacityTons;
    double fuelEfficiencyKmpl;

public:
    Truck(const string& reg, const string& owner, int year, double km,
          double payload, double efficiency)
        : Vehicle(reg, owner, year, km),
          payloadCapacityTons(payload),
          fuelEfficiencyKmpl(efficiency)
    {
        cout << "[Truck Constructor] "
             << registrationNo << endl;
    }

    ~Truck() override
    {
        cout << "[Truck Destructor] "
             << registrationNo << endl;
    }

    string vehicleType() const override
    {
        return "Truck";
    }

    double fuelCost(double kmToTravel) const override
    {
        double effectiveEfficiency =
            fuelEfficiencyKmpl * (1 - 0.05 * payloadCapacityTons);

        double fuelPrice = 93.00;

        return (kmToTravel / effectiveEfficiency) * fuelPrice;
    }

    void describe() const override
    {
        Vehicle::describe();
        cout << "Payload Capacity : "
             << payloadCapacityTons << " tons" << endl;
        cout << "Fuel Efficiency  : "
             << fuelEfficiencyKmpl << " kmpl" << endl;
    }
};

class ElectricTruck : public Truck
{
private:
    double batteryCapacityKWh;
    double rangePerChargeKm;
    double batteryPercentage;

public:
    ElectricTruck(const string& reg, const string& owner, int year,
                  double km, double payload, double efficiency,
                  double batteryCapacity, double rangePerCharge,
                  double batteryPercent)
        : Truck(reg, owner, year, km, payload, efficiency),
          batteryCapacityKWh(batteryCapacity),
          rangePerChargeKm(rangePerCharge),
          batteryPercentage(batteryPercent)
    {
        cout << "[ElectricTruck Constructor] "
             << registrationNo << endl;
    }

    ~ElectricTruck() override
    {
        cout << "[ElectricTruck Destructor] "
             << registrationNo << endl;
    }

    string vehicleType() const override
    {
        return "Electric Truck";
    }

    double fuelCost(double kmToTravel) const override
    {
        const double electricityCostPerUnit = 9.50;

        return (kmToTravel / rangePerChargeKm)
             * batteryCapacityKWh
             * electricityCostPerUnit;
    }

    void describe() const override
    {
        Truck::describe();
        cout << "Battery Capacity : "
             << batteryCapacityKWh << " kWh" << endl;
        cout << "Range Per Charge : "
             << rangePerChargeKm << " km" << endl;
        cout << "Battery Status   : "
             << batteryPercentage << "%" << endl;
    }

    double getBatteryPercentage() const
    {
        return batteryPercentage;
    }
};

class Van : public Vehicle
{
private:
    int seatingCapacity;
    double mileageKmpl;

public:
    Van(const string& reg, const string& owner, int year, double km,
        int seating, double mileage)
        : Vehicle(reg, owner, year, km),
          seatingCapacity(seating),
          mileageKmpl(mileage)
    {
        cout << "[Van Constructor] "
             << registrationNo << endl;
    }

    ~Van() override
    {
        cout << "[Van Destructor] "
             << registrationNo << endl;
    }

    string vehicleType() const override
    {
        return "Van";
    }

    double fuelCost(double kmToTravel) const override
    {
        const double petrolPrice = 106.00;

        return (kmToTravel / mileageKmpl) * petrolPrice;
    }

    void describe() const override
    {
        Vehicle::describe();
        cout << "Seating Capacity : "
             << seatingCapacity << endl;
        cout << "Mileage          : "
             << mileageKmpl << " kmpl" << endl;
    }
};

void printFleetReport(const vector<Vehicle*>& fleet, double tripKm)
{
    cout << fixed << setprecision(2);

    cout << "\n===== FLEET REPORT - Trip Distance: "
         << tripKm << " km =====\n";

    cout << left
         << setw(15) << "Reg"
         << setw(20) << "Type"
         << setw(25) << "Owner"
         << setw(15) << "Km Driven"
         << endl;

    cout << string(75, '-') << endl;

    for (Vehicle* vehicle : fleet)
    {
        cout << left
             << setw(15) << vehicle->getRegNo()
             << setw(20) << vehicle->vehicleType()
             << setw(25) << vehicle->getOwnerName()
             << setw(15) << vehicle->getKmDriven()
             << endl;
    }

    cout << "\n===== FUEL / CHARGE COST ESTIMATE =====\n";

    double minimumCost = 0.0;
    Vehicle* mostEfficient = nullptr;

    for (Vehicle* vehicle : fleet)
    {
        double cost = vehicle->fuelCost(tripKm);

        cout << left
             << setw(15) << vehicle->getRegNo()
             << " (" << setw(18) << vehicle->vehicleType() << ")"
             << " : Rs. "
             << fixed << setprecision(2)
             << cost;

        Car* car = dynamic_cast<Car*>(vehicle);

        if (car != nullptr)
        {
            cout << "  (" << car->getFuelType() << ")";
        }

        ElectricTruck* electricTruck =
            dynamic_cast<ElectricTruck*>(vehicle);

        if (electricTruck != nullptr)
        {
            cout << "  [Battery: "
                 << electricTruck->getBatteryPercentage()
                 << "% charged]";
        }

        cout << endl;

        if (mostEfficient == nullptr || cost < minimumCost)
        {
            minimumCost = cost;
            mostEfficient = vehicle;
        }
    }

    if (mostEfficient != nullptr)
    {
        cout << "\nMost Efficient Vehicle: "
             << mostEfficient->getRegNo()
             << " (" << mostEfficient->vehicleType() << ")"
             << " - Rs. "
             << minimumCost
             << " for "
             << tripKm
             << " km"
             << endl;
    }
}

int main()
{
    {
        ElectricTruck electricTruck(
            "V-ET001",
            "Green Logistics",
            2026,
            1000,
            5.0,
            4.0,
            100.0,
            400.0,
            85.0
        );
    }

    vector<Vehicle*> fleet;

    fleet.push_back(
        new Car(
            "KA01AA001",
            "Ramesh Kumar",
            2022,
            45200,
            "Petrol",
            18.75
        )
    );

    fleet.push_back(
        new Truck(
            "MH04BB002",
            "Shyam Logistics",
            2020,
            123500,
            10.0,
            5.0
        )
    );

    fleet.push_back(
        new ElectricTruck(
            "GJ07CC003",
            "Green Fleet Co",
            2025,
            89000,
            4.0,
            4.5,
            85.0,
            300.0,
            85.0
        )
    );

    fleet.push_back(
        new Van(
            "MH12DD004",
            "City Transport",
            2023,
            67500,
            12,
            16.0
        )
    );

    fleet.push_back(
        new Car(
            "DL05EE005",
            "Amit Sharma",
            2021,
            78200,
            "Diesel",
            22.0
        )
    );

    double tripKm = 200.0;

    printFleetReport(fleet, tripKm);

    cout << "\n===== VEHICLE DETAILS =====\n";

    for (Vehicle* vehicle : fleet)
    {
        cout << "\n";
        vehicle->describe();
    }

    cout << "\n===== CLEANUP =====\n";

    for (Vehicle* vehicle : fleet)
    {
        delete vehicle;
    }

    fleet.clear();

    return 0;
}