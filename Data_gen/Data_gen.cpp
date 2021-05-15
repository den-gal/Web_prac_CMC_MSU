// Data_gen - program to generate the data and populate the database
#include <iostream>
#include <string>
#include <fstream>
#include <vector>
#include <sstream>
#include <random>

int main()
{
    std::string s;
    std::vector<std::string> manufacturer = { "China", "Taiwan", "USA", "South_Korea", "Japan", "France", "UK", "Germany"};
    std::vector<std::string> colours = { "Black", "White", "Silver", "Gold", "Pirl", "Pink", "Green", "Blue" };
    std::vector<std::string> addit_dev = { "GPS", "Radio", "Air conditioning", "Video", "Auto parking", "Sits warming"};
    std::vector<bool> testrive = {true, false};
    std::vector<std::string> order_status = { "new", "processed", "in travel", "arrived", "issued", "returned"};
    std::vector<std::string> client_status = { "newcomer", "beginner", "senior", "regular", "master"};
    std::vector<double> engine_volume = { 1, 1.5, 2, 2.5, 3 };
    std::vector<int> engine_power = {120, 125, 130, 135, 140, 145, 150, 155, 160};
    std::vector<int> fuel_consumption = {5, 10, 15, 20, 25 ,30, 35, 40};
    std::vector<int> number_of_places = {2, 5};
    std::vector<int> number_of_doors = {2, 4};
    std::vector<std::string> upholstery = {"leather", "textile"};

    std::vector<std::string> LastName;
    std::ifstream file1("LastName.txt");
    while (getline(file1, s))
    {
        LastName.push_back(s);
    }
    file1.close();

    std::vector<std::string> FirstName;
    std::ifstream file2("FirstName.txt");
    while (getline(file2, s))
    {
        FirstName.push_back(s);
    }
    file2.close();

    std::vector<std::string> brands;
    std::ifstream file3("brands.txt");
    while (getline(file3, s))
    {
        brands.push_back(s);
    }
    file3.close();

    std::random_device rd;
    std::mt19937 gen(rd());
    std::uniform_int_distribution<> distrib_1(0, 17); // brands
    std::uniform_int_distribution<> distrib_2(0, 7); // manufacturer and colours, fuel_consumption
    std::uniform_int_distribution<> distrib_3(0, 5); // addit_dev and order_status
    std::uniform_int_distribution<> distrib_4(0, 4); // engine_volume
    std::uniform_int_distribution<> distrib_5(0, 8); // engine_power
    std::uniform_int_distribution<> distrib_6(0, 999); // client_ids 
    std::uniform_int_distribution<> distrib_7(0, 1999); // order_ids
    std::uniform_int_distribution<> distrib_8(0, 2999); // car_ids 
    std::uniform_int_distribution<> distrib_9(1000000, 10000000); // price and mileage
    std::uniform_int_distribution<> distrib_10(0, 1); // testdrive and number_of_doors
    std::uniform_int_distribution<> distrib_11(1, 28); // day
    std::uniform_int_distribution<> distrib_12(1, 12); // month
    std::uniform_int_distribution<> distrib_13(0, 3999); // firstname and lastname
    std::uniform_int_distribution<> distrib_14(100000000, 999999999); // phone number
    std::uniform_int_distribution<> distrib_15(0,4); // client_status

    int k = 0;
    std::ofstream myfile;
    myfile.open("cars.csv");

    std::ofstream myfile2;
    myfile2.open("orders.csv");
    for (int i = 0; i < 2000; i++)
    {
        std::stringstream ss;
        ss << i << ";"<< distrib_8(gen) << ";" << testrive[distrib_10(gen)] << ";" << distrib_11(gen) << "/" << distrib_12(gen) << "/2020" << ";" << order_status[distrib_3(gen)] << "\n";
        myfile2 << ss.str();
    }

    std::ofstream myfile3;
    myfile3.open("clients.csv");
    for (int i = 0; i < 1000; i++)
    {
        std::stringstream ss;
        std::string s1 = FirstName[distrib_13(gen)];
        std::string s2 = LastName[distrib_13(gen)];
        ss << i << ";" << s1 << s2 << ";";
        ss << " Email:" << s1 << "_" << i << "@gmail.com" << " PhoneNumber:" << 8 << " " << 9 << distrib_14(gen) << ";";
        ss << s1 << s2 << "_" << i << ";";
        ss << s1 << distrib_8 << ";";
        ss << client_status[distrib_15(gen)] << "\n";
        myfile3 << ss.str();
    }

    for (int i = 0; i < 3000; i++)
    {
        std::stringstream ss;
        ss << i << ";" << brands[distrib_1(gen)] << ";" << manufacturer[distrib_2(gen)] << ";";
        ss << " Engine volume:" << engine_volume[distrib_4(gen)] << " Engine power:" << engine_power[distrib_5(gen)];
        ss << " Fuel consumption:" << fuel_consumption[distrib_2(gen)] << " Number of places:" << number_of_places[distrib_10(gen)];
        ss << " Number of doors" << number_of_doors[distrib_10(gen)] << ";";
        k = distrib_3(gen);
        ss << addit_dev[k] << addit_dev[(k+2) % (k+1)] << addit_dev[(k + 3) % (k+1)] << addit_dev[(k + 4) % (k+1)] << ";";
        ss << colours[distrib_2(gen)] << upholstery[distrib_10(gen)] << ";";
        ss << "Mileage(km):" << distrib_9(gen) << ";";
        ss << distrib_9(gen) << "\n";
        myfile << ss.str();
    }

}