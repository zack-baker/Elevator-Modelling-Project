import java.util.Random;
import java.nio.file.*;
import java.io.*;
public class Main{

	public static int steps_up;
	public static int steps_down;
	public static String sim_name;

	public static void main(String[] args){
		Config c = new Config(args[0]);//the first command line argument is the path of the config file
		steps_up = c.get_steps_per_floor_stairs_up();
		steps_down = c.get_steps_per_floor_stairs_down();
		sim_name = c.get_simulation_name();
		System.out.println(c);
		Floors.init(c);
		
		try
		{
			Files.write(Paths.get("logs\\"+Main.sim_name+".log"), "Timestep Created | Timestep Deleted | Total time | walking time | Spawned floor | destination floor\r\n".getBytes(), StandardOpenOption.APPEND);
		}
		catch(IOException e)
		{
			System.out.println("can't open the file");
		}
		Elevator[] elevators = new Elevator[c.get_number_of_elevators()];
		//loop through each elevator to create it
		for(int i=0;i<elevators.length;i++){
			elevators[i] = new Elevator(c, Floors.floors[0]);
		}
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

	/*for each timestep:
		each floor checks for new people
		the elevator checks to see of it moves onto the next floor
		if the elevator is at a floor, let off people at that floor and pick up waiting people.

		print to a file, the person instance and the time step they got on the elevator, the floor they got on,
		the floor they got off, (maybe the total floors they traveled?)
		*/

		

}

