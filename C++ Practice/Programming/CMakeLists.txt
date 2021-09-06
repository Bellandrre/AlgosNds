cmake_minimum_required(VERSION 3.20)
project(Programming)

set(CMAKE_CXX_STANDARD 14)

add_executable(Programming main.cpp)
add_executable(test helloWorld.cpp)
add_executable(DataStructures DataStructures/arrays.cpp)
add_executable(Structures DataStructures/Structures.cpp)
add_executable(ThreeSum ProgrammingProblems/ThreeSum.cpp)