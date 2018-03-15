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
import java.util.Random;
import java.nio.file.*;
import java.io.*;
public class Main{

	public static int steps_up;
	public static int steps_down;
	public static String sim_name;

	public static void main(String[] args){
		if(args.length<1){
			System.err.println("USAGE: Please provide a path to a valid config file (check the config/ folder)");
			return;
		}
		Config c = new Config(args[0]);//the first command line argument is the path of the config file
		steps_up = c.get_steps_per_floor_stairs_up();
		steps_down = c.get_steps_per_floor_stairs_down();
		sim_name = c.get_simulation_name();
		System.out.println(c);
		Floors.init(c);
		System.out.println("Sim name is: " + sim_name);
		String log_name = get_log_name(sim_name);
		File f = new File("logs/" + log_name + ".log");
		try{
			f.createNewFile();
		}
		catch(IOException e){
			System.err.println("FATAL: Error creating log file. Aborting.");
			e.printStackTrace();
			return;
		}
		/*What does this even do?*/
		try{
			PrintWriter pw = new PrintWriter(f);
			pw.close();
		}
		catch(IOException e){
			System.err.println("???: Error with PrintWriter");
			return;
		}

		try
		{
			Files.write(Paths.get("logs/"+log_name+".log"), "Timestep Created | Timestep Deleted | Total time | walking time | Spawned floor | destination floor\n".getBytes(), StandardOpenOption.APPEND);//Write the headers to the log file
		}
		catch(IOException e)
		{
			System.err.println("FATAL: can't open the log file to write the headers. Aborting");
			return;
		}
		Elevator[] elevators = new Elevator[c.get_number_of_elevators()];
		//loop through each elevator to create it
		for(int i=0;i<elevators.length;i++){
			elevators[i] = new Elevator(c, Floors.floors[0]);
		}
		/*for each timestep:
		each floor checks for new people
		the elevator checks to see of it moves onto the next floor
		if the elevator is at a floor, let off people at that floor and pick up waiting people.
		print to a file, the person instance and the time step they got on the elevator, the floor they got on,
		the floor they got off, (maybe the total floors they traveled?)
		*/

		while(Timekeeper.get_timestep()<c.get_simulation_steps()){
			System.out.println("Timestep: " + Timekeeper.get_timestep());
			for(int i=0;i<Floors.floors.length;i++){
				Floors.floors[i].spawn_person();
			}
			for(int i=0;i<elevators.length;i++){
				elevators[i].check_if_next_floor();
			}
			Timekeeper.increment_timestep();

		}
	}

	/**
	*	This method calculates a random number using a poisson distribution using a specified lambda, or average value. Method developed by Donald Knuth
	*	@param lambda the average number of events happening in an interval
	*	@return a random number based on the lambda value;
	*/
	public static int get_poisson(double lambda){
		Random r = new Random();
		double l = Math.exp(-lambda);
		int k=0;
		double p = 1.0;
		do{
			p = p*r.nextDouble();
			k++;
		}while(p>l);
		return k-1;
	}
	/**
	*	This method strips the path of the provided config file to just the local file name, to use for the log file name
	*	@param pathname the path to the config file, provided by the user
	*	@return the stripped filename
	*/
	public static String get_log_name(String pathname){
		String[] parts = pathname.split("/");
		String localfile = parts[parts.length-1];
		System.out.println("Localfile is " + localfile);
		String filename = localfile.split("\\.")[0];

		return filename;
	}


		

}

