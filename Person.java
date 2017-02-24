import java.util.Random;
public class Person
{
	//person object

	private int stair_up;
	private int stair_down;
	private int time_deleted;
	private Floor destination;
	

	//constructor
	public Person(Floor f)
	{
		time_spawned = Timekeeper.get_timestep();
		//create random floor destination for each person
		Random r = new Random();
		int floorNumber = r.nextInt(7);
		while(Floor.get_Floor() == floorNumber)
			floorNumber = r.nextInt(7);
		destination = Floors.floors[floorNumber];
		//time_spawned = ; //poisson distribution
	}


	///////////GETTERS///////////////////////
	
	public Floor get_floor_off()
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
	public void delete(){
		//Log total time here
		System.out.println("DELETING A PERSON: Total Time: " + time_spawned-Timekeeper.get_timestep());
	}



}