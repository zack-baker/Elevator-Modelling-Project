import java.util.Random;
public class Person extends People
{
	//person object

	private int stair_up;
	private int stair_down;
	private int time_spawned;
	private int time_deleted;

	private Floor destination;
	

	

	//constructor
	public Person()
	{

		time_spawned = Timekeeper.get_timestep();

		Random r = new Random();
		destination = r.nextInt(7);
		while(Floor.get_Floor() == destination)
			destination = r.nextInt(7);
		//time_spawned = ; //poisson distribution
	}
	

	

	///////////GETTERS///////////////////////
	
	public int get_floor_off()
	{
		return destination;
	}

	public int get_stair_up()
	{
		return stair_up;
	}

	public int get_stair_down()
	{
		return stair_down;
	}



}