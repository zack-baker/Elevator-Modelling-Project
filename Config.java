import java.util.Scanner; //Used for the scanner class
import java.io.File; //used for the file class
import java.io.FileNotFoundException;// used for the file not found exception
public class Config{

	private int number_of_elevators; //the number of elevators for the simulation to use
	private double lambda;//the lambda value of the simulation; used in the poisson distribution to determine patron arrival at a specific floor
	private int steps_per_floor_elevator; //the number of timesteps it takes an 
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
		pathname = "config/" + pathname + ".conf";//get the config file specifically from the given path
		Scanner sc = null;//create the scanner object to read the config file
		try{
			sc = new Scanner(new File(pathname));
		}catch(FileNotFoundException fnf){
			System.out.println("File Not Found Exception in Config constructor");
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

}