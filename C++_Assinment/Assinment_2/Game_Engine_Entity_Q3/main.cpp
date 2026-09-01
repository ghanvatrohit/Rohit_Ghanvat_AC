#include <iostream>
#include <cstdlib>
#include <ctime>

#include "Entity.h"

using namespace std;

// Global game difficulty level
int level = 1;

int main()
{
    // PART A - METHOD CHAINING

    cout << "===== GAME ENTITY SYSTEM =====" << endl;
    cout << endl;

    Entity player;
    Entity enemy;
    Entity item;

    // Method chaining
    player.setName("Aragorn")
        .setHealth(100)
        .setLevel(10)
        .setType("Player");

    enemy.setName("Orc")
        .setHealth(60)
        .setLevel(5)
        .setType("Enemy");

    item.setName("HealthPotion")
        .setHealth(0)
        .setLevel(1)
        .setType("Item");

    // Display entities
    cout << "===== ENTITY INFORMATION =====" << endl;

    cout << "\nPlayer:" << endl;
    player.displayInfo();

    cout << "\nEnemy:" << endl;
    enemy.displayInfo();

    cout << "\nItem:" << endl;
    item.displayInfo();

    // PART B - NAMESPACES

    cout << "\n===== NAMESPACE FUNCTIONS =====" << endl;

    // Physics namespace
    double velocity = 150.5;

    cout << "Physics Clamp : "
         << Physics::clamp(velocity, 0.0, 100.0)
         << endl;

    cout << "Physics Lerp : "
         << Physics::lerp(0.0, 100.0, 0.5)
         << endl;

    // GameMath namespace
    int health = 120;

    cout << "GameMath Clamp : "
         << GameMath::clamp(health, 0, 100)
         << endl;

    cout << "GameMath Lerp : "
         << GameMath::lerp(10.0, 50.0, 0.5)
         << endl;

    // Limited namespace scope
    {
        using namespace Physics;

        cout << "Limited Scope Clamp : "
             << clamp(200.0, 0.0, 100.0)
             << endl;
    }

    // PART C - DYNAMIC 2D GAME MAP

    int rows;
    int columns;

    cout << "\n===== DYNAMIC GAME MAP =====" << endl;

    cout << "Enter number of rows: ";
    cin >> rows;

    cout << "Enter number of columns: ";
    cin >> columns;

    // Allocate outer array
    int **gameMap = new int *[rows];

    // Allocate each row
    for (int i = 0; i < rows; i++)
    {
        gameMap[i] = new int[columns];
    }

    // Fill the map with random tile values

    srand(time(0));

    for (int i = 0; i < rows; i++)
    {
        for (int j = 0; j < columns; j++)
        {
            gameMap[i][j] = rand() % 5;
        }
    }

    // Display Game Map

    cout << "\n===== GAME MAP ("
         << rows << " x "
         << columns << ") =====" << endl;

    for (int i = 0; i < rows; i++)
    {
        for (int j = 0; j < columns; j++)
        {
            cout << gameMap[i][j] << "  ";
        }

        cout << endl;
    }

    // Legend

    cout << "\nLegend: "
         << "0=Grass  "
         << "1=Water  "
         << "2=Mountain  "
         << "3=Forest  "
         << "4=Dungeon"
         << endl;

    // Count Tiles

    int tileCount[5] = {0, 0, 0, 0, 0};

    for (int i = 0; i < rows; i++)
    {
        for (int j = 0; j < columns; j++)
        {
            tileCount[gameMap[i][j]]++;
        }
    }

    cout << "\nTile Count:" << endl;

    cout << "Grass    : " << tileCount[0] << endl;
    cout << "Water    : " << tileCount[1] << endl;
    cout << "Mountain : " << tileCount[2] << endl;
    cout << "Forest   : " << tileCount[3] << endl;
    cout << "Dungeon  : " << tileCount[4] << endl;

    // Deallocate Dynamic 2D Array
    for (int i = 0; i < rows; i++)
    {
        delete[] gameMap[i];
    }

    delete[] gameMap;

    // SCOPE RESOLUTION BONUS

    int level = player.getLevel();

    cout << "\n===== LEVEL INFORMATION =====" << endl;

    cout << "Local Player Level  : " << level << endl;
    cout << "Global Game Level   : " << ::level << endl;

    // NESTED NAMESPACE BONUs
    cout << "\n===== AUDIO =====" << endl;

    Engine::Audio::playSound("sword_clash");

    return 0;
}