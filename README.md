# Elevator Simulator

## Introduction
This project was created as part of a project to measure the differences between taking the stairs and taking an elevator in a residential complex. The focus was on determining the time it would take to travel *n* flights of stairs versus *n* floors on the elevator. The simultation takes several parameters, such as the number of elevators, the lambda value for the Poisson distribution, the number of timesteps it takes to move up or down the stairs, the number of timesteps it takes to travel via elevator, the number of timesteps it takes for the elevator to move after an elevator stops at the floor, and the number of timesteps for the simulation to run. The provided config files were created based on empirically gathered data. 

## Installation
First, clone the repo, then simply run `make`. See the Makefile for more usage information

## Usage
To use the application, run `java Main $PATH/TO/CONFIG/FILE`.

To run silently, reroute `stdout` to `/dev/null/`: `java Main $PATH/TO/CONFIG/FILE > /dev/null`

## Config

The config file is formatted as follows:

```
numElevators $numberOfElevators
lambda $lambdaValue
stepsPerFloorElevator $numberOfTimestepsForElevatorToTravelOneFloor
stepsPerFloorStairsUp $numberOfTimestepsForPatronToTravelUpOneFloorOnStairs
stepsPerFloorStairsDown $numberOfTimestepsForPatronsToTravelDownOneFloorOnStairs
stationarySteps $numberOfTimestepsToWaitOnAFloor
simSteps $numberOfTimestepsForTheSim
```
where `$lambdaValue` is a decimal value between 0.0 and 1.0, and all other variables are positive integers.

## Authors

This simulation was written by Zack Baker (me) and David Fountain. 
