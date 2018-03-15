/*
Copyright 2018

This file is part of Elevator Traffic Simulator.

Elevator Traffic Simulator is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Elevator Traffic Simulator is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Elevator Traffic Simulator.  If not, see <http://www.gnu.org/licenses/>.

*/
import java.util.Scanner; //Used for the scanner class
import java.io.File; //used for the file class
import java.io.FileNotFoundException;// used for the file not found exception
public class Config{

	private int number_of_elevators; //the number of elevators for the simulation to use
	private double lambda;//the lambda value of the simulation; used in the poisson distribution to determine patron arrival at a specific floor
	private int steps_per_floor_elevator; //the number of timesteps it takes the elevator to travel one floor
	private int steps_per_floor_stairs_up; // the number of timesteps it takes to go up one floor on the stairs in the elevator
	private int steps_per_floor_stairs_down;// the number of timesteps it takes to go down one floor on the stairs in the elevator
	private int stationary_steps;// the number of steps the elevator doors remain open once the elevator arrives at a floor
	private int simulation_steps;// the total number of steps in the simulation
	private String sim_name;// the name of the current simulation; used to create output files
	/**
	*	Main constructor; initializes the variables of the class
	*	@param pathname the name of the simulation run; is used to create the output files
	*/
	public Config(String pathname){
		sim_name = pathname;
		//don't assume the pathname is in the configs folder.
		//pathname = "configs/" + pathname + ".conf";//get the config file specifically from the given path
		Scanner sc = null;//create the scanner object to read the config file
		try{
			sc = new Scanner(new File(pathname));
		}catch(FileNotFoundException fnf){
			System.err.println("ERROR: File " + sim_name + "not found. Exception in Config constructor");
		}
		while (sc.hasNextLine()) {//for each line
			String line = sc.nextLine();	
			String[] line_split = line.split("\\s");//split the line into parameter name and parameter value
			switch(line_split[0]){
				case "numElevators": number_of_elevators = Integer.parseInt(line_split[1]); break;
				case "lambda": lambda = Double.parseDouble(line_split[1]); break;
				case "stepsPerFloorElevator": steps_per_floor_elevator = Integer.parseInt(line_split[1]); break;
				case "stepsPerFloorStairsUp": steps_per_floor_stairs_up = Integer.parseInt(line_split[1]); break;
				case "stepsPerFloorStairsDown": steps_per_floor_stairs_down = Integer.parseInt(line_split[1]); break;
				case "stationarySteps": stationary_steps = Integer.parseInt(line_split[1]); break;
				case "simSteps": simulation_steps = Integer.parseInt(line_split[1]); break;
				default: 
			}

		}	
	}
	/*
	*
	*	GETTER METHODS
	*
	*/

	/**
	*	Getter method for the number of elevators to use in the simulation
	*	@return the number of elevators to use in the simulation
	*/
	public int get_number_of_elevators(){
		return number_of_elevators;
	}
	/**
	*	Getter method for the lambda value. The lambda value is used in the Poisson distribution to calculate the arrival rate of patons on each floor
	*	@return the lambda value to use for the simulation
	*/
	public double get_lambda(){
		return lambda;
	}
	/**
	*	Getter method for the number of timesteps it takes the elevator to travel one floor
	*/
	public int get_steps_per_floor_elevator(){
		return steps_per_floor_elevator;
	}
	/**
	*	Getter method for the number of timesteps it takes someone to travel one floor via stairs going up
	*/
	public int get_steps_per_floor_stairs_up(){
		return steps_per_floor_stairs_up;
	}
	/**
	*	Getter method for the number of timesteps it takes someone to travel one floor via stairs going down
	*/
	public int get_steps_per_floor_stairs_down(){
		return steps_per_floor_stairs_down;
	}
	/**
	*	Getter method for the number of timesteps the elevator door stays open when it opens
	*/
	public int get_stationary_steps(){
		return stationary_steps;
	}
	/**
	*	Getter method for the number of timesteps to run the simulation for
	*/
	public int get_simulation_steps(){
		return simulation_steps;
	}
	/**
	*	Getter method for the simulation name
	*/
	public String get_simulation_name(){
		return sim_name;
	}
	/**
	*	Method to 'Stringify' the config object; overrides the toString method
	*/
	public String toString(){
		String str = "--------------------------------------------\n";
		str+= "|        Simulation name: " + sim_name + "       \n";
		str+= "|          Number of Elevators: " + number_of_elevators + "          \n";
		str+= "|             Lambda: " + lambda + "              \n"; 
		str+= "|      Steps per floor (elevator): " + steps_per_floor_elevator + "      \n";
		str+= "|     Steps per floor (stairs, up): " + steps_per_floor_stairs_up + "     \n";
		str+= "|    Steps per floor (stairs, down): " + steps_per_floor_stairs_down + "    \n";
		str+= "|    # of elevator stationary steps: " + stationary_steps + "    \n" ;
		str+= "|          Total timesteps: " + simulation_steps + "          \n";
		str+= "--------------------------------------------\n";

		return str;

	}

}