#ifndef ENTITY_H
#define ENTITY_H

#include <string>

using namespace std;

class Entity
{
private:
    string name;
    int health;
    int level;
    string type;

public:
    Entity();

    // Setters
    Entity &setName(const string &name);
    Entity &setHealth(int health);
    Entity &setLevel(int level);
    Entity &setType(const string &type);

    // Getters
    string getName() const;
    int getHealth() const;
    int getLevel() const;
    string getType() const;

    void displayInfo() const;
};

// Physics namespace
namespace Physics
{
    double clamp(double val, double min, double max);
    double lerp(double a, double b, double t);
}

// GameMath namespace
namespace GameMath
{
    int clamp(int val, int min, int max);
    double lerp(double a, double b, double t);
}

// Nested namespace
namespace Engine
{
    namespace Audio
    {
        void playSound(string name);
    }
}

#endif