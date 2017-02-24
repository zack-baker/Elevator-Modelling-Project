import java.util.LinkedList;
public class Floor
{
	private int floor_number;
	private double floor_lambda;
	private LinkedList<Person> people;
	private Floor floor_below;
	private Floor floor_above;
	//constructor for Floor object class
	/**
	*	Main constructor for the Floor class; takes in a config object and an int for its floor number
	*	@param config the config object to initialize each floor
	*	@param floor_num an int representing the floor number
	*/
	public Floor(Config config, int floor_num)
	{
		floor_number = floor_num;
		people = new LinkedList<Person>();
		//determining floor lambda values
		if(floor_num==1){
			floor_lambda = config.get_lambda();
		}else{
			floor_lambda = config.get_lambda()/5;
		}

	}

	/**
	*	add a person to the queue of people waiting for the elevator
	*	@param p the person to add to the queue
	*/
	public void add_person(Person p){
		people.add(p);
	}

	/**
	*	remove a person from the queue of people waiting for the elevator on this floor
	*	@return the person at the front of the queue 
	*/
	public Person remove_person()
	{
		return people.poll();
	}
	/**
	*	This method spawns a number of people on the floor and adds them to the existing queue based on a poisson distribution defined by the lambda value of the floor
	*/
	public void spawn_person(){
		int new_people = Main.get_poisson(floor_lambda);
		for(int i=0;i<new_people;i++){
			Person p = new Person();
			add_person(p);
		}
	}
	public Floor get_floor_above(){
		if(floor_number==Floors.floors.length){
			return null;
		}else{
			return Floors.floors[floor_number];
		}
	}
	public Floor get_floor_below(){
		if(floor_number==1){
			return null;
		}else{
			return Floors.floors[floor_number-1-1];
		}
	}
}