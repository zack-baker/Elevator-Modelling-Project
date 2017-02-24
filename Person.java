import java.util.Random;
public class Person
{
	//person object

	private int stair_up;
	private int stair_down;
	private int time_spawned;
	private Floor destination;
	//constructor
	public Person()
	{

		time_spawned = Timekeeper.get_timestep();

		//time_spawned = ; //poisson distribution
	}
	

	

	///////////GETTERS///////////////////////
	public int get_floor_on()
	{
		
	}

	public int get_floor_off()
	{

	}

	public int get_stair_up()
	{
		return stair_up;
	}

	public int get_stair_down()
	{
		return stair_down;
	}
	public void delete(){
		//Log total time here
		System.out.println("DELETING A PERSON: Total Time: " + time_spawned-Timekeeper.get_timestep());
	}



}