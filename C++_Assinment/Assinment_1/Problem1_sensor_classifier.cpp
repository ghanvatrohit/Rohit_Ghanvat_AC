#include <iostream>
using namespace std;

int range(double temp){
    if(temp<0){
        return -1;
    }else if(temp<30){
        return 0;
    }else if(temp<45){
        return 1;
    }else if(temp<60){
        return 2;
    }else{
        return 3;
    }
}

void status(int code){
    switch(code){
        case -1:
        cout<<"Status: SENSOR_ERROR"<<endl;
        cout<<"Action: Sensor fault — check wiring"<<endl;
        break;
        case 0:
        cout<<"Status: NORMAL"<<endl;
        cout<<"Action: No action required"<<endl;
        break;
        case 1:
        cout<<"Status: WARNING"<<endl;
        cout<<"Action: Alert sent to supervisor"<<endl;
        break;
        case 2:
        cout<<"Status: CRITICAL"<<endl;
        cout<<"Action: Cooling system triggered"<<endl;
        break;
        default:
        cout<<"Status: SHUTDOWN"<<endl;
        cout<<"Action: Emergency shutdown initiated"<<endl;
        break;
    }
}

int main(){
    double temp;
    cout<<"Enter the temperature = ";
    cin >> temp;

    double fehrenheit = (temp*9.0/5.0)+32.0;
    cout<<"Temperature : "<<temp<<"°C / "<<fehrenheit<<"°F"<<endl;

    int code = range(temp);

    status(code);

    cout << "Reading : " << (temp >= 25.0 ? "Above Average":"Below Average" ) << endl;
    
    return 0;
}