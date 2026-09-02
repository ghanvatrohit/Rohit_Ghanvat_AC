#include <iostream>
#include <cstring>

using namespace std;

class LogBuffer
{
private:
    char* buffer;
    int capacity;
    int size;

    static int instanceCount;

    // Bonus: mutable member
    mutable int accessCount = 0;

public:

    // Constructor
    LogBuffer(int capacity)
    {
        this->capacity = capacity;
        this->size = 0;

        buffer = new char[capacity + 1];
        buffer[0] = '\0';

        instanceCount++;

        cout << "[LogBuffer Created] capacity="<< capacity << endl;
    }


    // Copy Constructor - DEEP COPY
    LogBuffer(const LogBuffer& other)
    {
        capacity = other.capacity;
        size = other.size;

        buffer = new char[capacity + 1];

        memcpy(buffer, other.buffer, size + 1);
        instanceCount++;

        cout << "[LogBuffer Deep Copied] capacity="<< capacity << endl;
    }


    // Copy Assignment Operator
    LogBuffer& operator=(const LogBuffer& other)
    {
        // Self-assignment check
        if (this == &other)
        {
            cout << "[Self-assignment detected - no operation]"<< endl;
            return *this;
        }

        // Release old memory
        delete[] buffer;

        // Copy data
        capacity = other.capacity;
        size = other.size;

        // Allocate new memory
        buffer = new char[capacity + 1];

        // Deep copy
        memcpy(buffer, other.buffer, size + 1);

        cout << "[LogBuffer Assigned]" << endl;
        return *this;
    }


    // Destructor
    ~LogBuffer()
    {
        delete[] buffer;
        instanceCount--;
        cout << "[LogBuffer Destroyed]" << endl;
    }


    // append()
    void append(const char* msg)
    {
        int msgLength = strlen(msg);

        // Calculate how much space is available
        int available = capacity - size;
        if (msgLength > available)
        {
            msgLength = available;
        }

        memcpy(buffer + size, msg, msgLength);
        size += msgLength;
        buffer[size] = '\0';
    }

    // print()
    void print() const
    {
        accessCount++;
        cout << buffer << endl;
    }

    // clear()
    void clear()
    {
        size = 0;
        buffer[0] = '\0';
    }


    // Static Member Function
    static int getInstanceCount()
    {
        return instanceCount;
    }


    // Bonus - const getter
    int getAccessCount() const
    {
        return accessCount;
    }
};

// Static Data Member Initialization
int LogBuffer::instanceCount = 0;

// main()
int main()
{
    // Objective 1 : Basic Usage
    cout << "===== Objective 1 =====" << endl;
    LogBuffer log1(256);

    log1.append("Server started on port 8080");
    log1.append(" | Request received from 192.168.1.10");
    log1.print();

    // Objective 2 : Deep Copy via Copy Constructor
    cout << endl;
    cout << "===== Objective 2 =====" << endl;
    LogBuffer log2 = log1;
    log2.append(" | Cached response sent");

    cout << "log1 : ";
    log1.print();

    cout << "log2 : ";
    log2.print();


    // Objective 3 : Copy Assignment Operator
    cout << endl;
    cout << "===== Objective 3 =====" << endl;

    LogBuffer log3(128);

    log3 = log1;

    cout << "log3 : ";
    log3.print();

    cout << "log1 : ";
    log1.print();


    // Objective 4 : Self Assignment
    cout << endl;
    cout << "===== Objective 4 =====" << endl;

    log1 = log1;

    // Objective 5 : Static Member
    cout << endl;
    cout << "===== Objective 5 =====" << endl;

    cout << "Live LogBuffer objects : "
        << LogBuffer::getInstanceCount()<< endl;

    // BONUS : const object + mutable member
    cout << endl;
    cout << "===== Bonus : mutable + const =====" << endl;

    /*
        print() is a const member function.

        Normally, a const member function cannot modify
        normal data members of the object.

        However, accessCount is declared as mutable.

        Therefore, even though print() is const,
        accessCount can still be modified.

        const means:
        "This member function cannot modify the object's
        normal state."

        mutable is an exception that allows a particular
        member to change even inside a const member function.
    */

    const LogBuffer readOnly(log1);

    readOnly.print();
    readOnly.print();
    readOnly.print();

    cout << "Times printed: "<< readOnly.getAccessCount()<< endl;

    return 0;
}