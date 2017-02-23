//Michael Ward A01755332
/*
Errors I am unable to solve:
1. If an invalid command is entered, entering the exit command on the next line will not work.
2. ptime only records the time when entering an invalid command
3. history only records the first word entered in any command
I am unable to solve any of these problems but I believe the rest is working fine. Please let me know if you know why any of these are not working. Thank you!
*/
#include <iostream>
#include <sstream>
#include <vector>
#include <cstring>
#include <unistd.h>
#include <sys/wait.h>
#include <chrono>
#include <stdio.h>
typedef std::chrono::high_resolution_clock Time;
typedef std::chrono::milliseconds ms;
typedef std::chrono::microseconds mc;
typedef std::chrono::nanoseconds ns;
typedef std::chrono::duration<double> fsec;
 
fsec start_process(char** args) {
    std::chrono::steady_clock::time_point start, end;
    pid_t pid;
    pid = fork();
    if (pid == 0) {
        //child process
        start = std::chrono::steady_clock::now();
        int status = execvp(args[0], args);
        if(status == -1) {
        //error
        std::cout << "Invalid command." << std::endl;
        //return;
        }
        //wait(NULL);
        end = std::chrono::steady_clock::now();
    } else {
        //parent process
        wait(NULL);
    }
return (end - start);
     
}
 
void shell_loop() {
std::chrono::steady_clock::time_point time = std::chrono::steady_clock::now();
    fsec total = time - time;
    bool status = true;
    std::vector<char**> history;
    while (status) {
        std::cout << "[cmd]:";
        std::string t;
        getline(std::cin, t);
        std::vector<std::string> commands;
        std::istringstream iss(t);
        std::string word;
        int counter = 0;
        while (iss >> word) {
            commands.push_back(word);
        }
        char ** args = new char*[commands.size()];
        for (int i = 0; i < commands.size(); ++i) {
            args[i] = new char[commands[i].size()];
            std::strcpy(args[i], commands[i].c_str());
        }
        if (!strcmp(args[0], "exit")) {
            status = false;
        }
        else if (!strcmp(args[0], "ptime")) {
            ms milliSeconds = std::chrono::duration_cast<ms>(total);
            mc microSeconds = std::chrono::duration_cast<mc>(total);
            ns nanoSeconds = std::chrono::duration_cast<ns>(total);
            std::cout << "Time spent executing child processes: " << total.count() << " seconds " << milliSeconds.count()<< " milliseconds " << microSeconds.count()<< " microseconds " << nanoSeconds.count()<< " nanoseconds" << std::endl;
        }
        else if (!strcmp(args[0], "history")) {
            for (int i = 0; i < history.size(); ++i) {
                std::cout << *history[i] << std::endl;       
            }
        }
        else if (!strcmp(args[0], "^")) {
            int num = std::stoi(args[1]);
            if (num <= history.size()) {
                std::cout << *history[num - 1] << std::endl;
            }
            else {
                std::cout << "No command found for specified number." << std::endl;

            }
        }
 
        else {
            history.push_back(args);
            total += start_process(args);
        }
    }
}
 
int main(int argc, char* argv[]) {
    shell_loop();
}