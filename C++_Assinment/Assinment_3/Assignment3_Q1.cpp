#include <iostream>
#include <string>
#include <vector>
#include <utility>

using namespace std;

// Paert A - enum class for HTTP status codes **

enum class HttpStatus
{
    OK = 200,
    Created = 201,
    BadRequest = 400,
    Unauthorized = 401,
    NotFound = 404,
    ServerError = 500
};

// Part B :- Type Aliases ***

using Header = pair<string, string>;
using HeaderList = vector<Header>;
using Port = unsigned int;
using IPAdress = string;

typedef unsigned long long RequestId;

void handleResponse(HttpStatus status, const string &endpoint)
{
    cout << "[" << endpoint << "] -> ";
    switch (status)
    {
    case HttpStatus::OK:
        cout << "200 OK : Request successful";
        break;

    case HttpStatus::Created:
        cout << "201 Created : Resource created successfully";
        break;

    case HttpStatus::BadRequest:
        cout << "400 Bad Request : Invalid request";
        break;

    case HttpStatus::Unauthorized:
        cout << "401 Unauthorized : Authentication required";
        break;

    case HttpStatus::NotFound:
        cout << "404 Not Found : Endpoint does not exist";
        break;

    case HttpStatus::ServerError:
        cout << "500 Server Error : Internal server error - retry later";
        break;
    }
    cout << endl;
}

void printHeaders(const HeaderList &headers)
{
    cout << "Headers: " << endl;
    for (const Header &header : headers)
    {
        cout << header.first << ":" << header.second << endl;
    }
}

int main()
{

    // A  Testing different HTTP status codes
    handleResponse(HttpStatus::OK, "GET /api/users");
    handleResponse(HttpStatus::Created, "POST /api/users");
    handleResponse(HttpStatus::Unauthorized, "POST /api/login");
    handleResponse(HttpStatus::NotFound, "GET /api/products/99");
    handleResponse(HttpStatus::ServerError, "POST /api/order");

    // B  HeaderList
    HeaderList headers = {{"Content-Type", "application/json"},
                          {"Authorization", "Bearer eyJhbGci..."},
                          {"Accept-Language", "en-US"}};

    printHeaders(headers);

    Port serverPort = 8080;

    RequestId requestId = 1748293847;

    cout << endl;
    cout << "Request ID : " << requestId << endl;
    cout << "Server Port : " << serverPort << endl;

    return 0;
}