public class Config(){

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
		Scanner sc;//create the scanner object to read the config file
		try{
			sc = new Scanner(new File(pathname));
		}catch(FileNotFoundException fnf){
			System.println("File Not Found Exception in Config constructor");
		}
		while (sc.hasNextLine()) {//for each line
			String line = sc.nextLine();	
			String[] line_split = line.split("\s");//split the line into parameter name and parameter value
			switch(line_split[0]){
				case "numElevators": number_of_elevators = (int)line_split[1]; break;
				case "lambda": lambda = (double)line_split[1]; break;
				case "stepsPerFloorElevator": steps_per_floor_elevator = (int)line_split[1]; break;
				case "stepsPerFloorStairsUp": steps_per_floor_stairs_up = (int)line_split[1]; break;
				case "stepsPerFloorStairsDown": steps_per_floor_stairs_down = (int)line_split[1]; break;
				case "stationarySteps": stationary_steps = (int)line_split[1]; break;
				case "simSteps": simSteps = (int) line_split[1]; break;
				default: 
			}

		}	
	}
}