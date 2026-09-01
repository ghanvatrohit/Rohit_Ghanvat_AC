#include <iostream>
#include "Entity.h"

using namespace std;

// Entity Default Constructor

Entity::Entity()
{
    name = "";
    health = 0;
    level = 0;
    type = "";
}

// Setters

Entity &Entity::setName(const string &name)
{
    this->name = name;

    return *this;
}

Entity &Entity::setHealth(int health)
{
    this->health = health;

    return *this;
}

Entity &Entity::setLevel(int level)
{
    this->level = level;

    return *this;
}

Entity &Entity::setType(const string &type)
{
    this->type = type;

    return *this;
}

// Getters

string Entity::getName() const
{
    return name;
}

int Entity::getHealth() const
{
    return health;
}

int Entity::getLevel() const
{
    return level;
}

string Entity::getType() const
{
    return type;
}

// Display Entity Information

void Entity::displayInfo() const
{
    cout << "Name   : " << name << endl;
    cout << "Health : " << health << endl;
    cout << "Level  : " << level << endl;
    cout << "Type   : " << type << endl;
}

// Physics Namespace

namespace Physics
{
    double clamp(double val, double min, double max)
    {
        if (val < min)
        {
            return min;
        }

        if (val > max)
        {
            return max;
        }

        return val;
    }

    double lerp(double a, double b, double t)
    {
        return a + (b - a) * t;
    }
}

// GameMath Namespace

namespace GameMath
{
    int clamp(int val, int min, int max)
    {
        if (val < min)
        {
            return min;
        }

        if (val > max)
        {
            return max;
        }

        return val;
    }

    double lerp(double a, double b, double t)
    {
        return a + (b - a) * t;
    }
}

// Engine::Audio Namespace

namespace Engine
{
    namespace Audio
    {
        void playSound(string name)
        {
            cout << "Playing: " << name << endl;
        }
    }
}