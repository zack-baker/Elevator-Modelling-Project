import java.util.ArrayList;
public class Elevator{

	private final int capacity = 12;
	private int spf;
	private int stationary_time;
	private boolean up;
	private Floor cur_floor;
	private ArrayList<Person> people;
	private ArrayList<Floor> destinations;
	private double last_timestep_on_floor;

	/**
	*Main constructor for the Elevator class; takes in a config object and an the starting floor
	*@param config the config object to initialize each elevator
	*@param start_floor the floor object to initialize the starting floor to be the current floor
	*/

	public Elevator(Config c, Floor start_floor){
		spf = c.get_steps_per_floor_elevator();
		stationary_time = c.get_stationary_steps();
		cur_floor = start_floor;
		up = true;
		people = new ArrayList();
		destinations = new ArrayList();
		last_timestep_on_floor = 0;
	}

	public void check_if_next_floor(){
		//if enough time has passed, advance to the next floor
		if(Timekeeper.get_timestep()-last_timestep_on_floor>=spf){
			
		}		
	}
}