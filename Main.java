import java.util.Random;
public class Main{

	public static int steps_up;
	public static int steps_down;

	public static void main(String[] args){
		Config c = new Config(args[0]);//the first command line argument is the path of the config file
		steps_up = c.get_steps_per_floor_stairs_up();
		steps_down = c.get_steps_per_floor_stairs_down();
		System.out.println(c);
		Floors.init(c);
		//loop through each timestep
		Elevator[] elevators = new Elevator[c.get_number_of_elevators()];
		for(int i=0;i<elevators.length;i++){
			elevators[i] = new Elevator(c, Floors.floors[0]);
		}
		while(Timekeeper.get_timestep()<c.get_simulation_steps()){
			for(int i=0;i<Floors.floors.length;i++){
				Floors.floors[i].spawn_person();
			}
			for(int i=0;i<elevators.length;i++){
				elevators[i].check_if_next_floor();
			}

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

