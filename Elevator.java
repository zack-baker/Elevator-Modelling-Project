import java.util.ArrayList
public class Elevator{

	private final int capacity = 12;
	private int spf;
	private int stationary_time
	private boolean up;
	private Floor cur_floor;
	private ArrayList<Person> people;
	private ArrayList<Floor> destinations;

	public Elevator(Config c, Floor start_floor){
		spf = c.get_steps_per_floor_elevator();
		stationary_time = c.get_stationary_steps();
		cur_floor = start_floor;
		up = true;
		people = new ArrayList();
		destinations = new ArrayList();
	}
}