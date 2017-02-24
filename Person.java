import java.util.Random;
public class Person
{
	//person object

	private Floor destination;
	private int steps_walking;
	private int time_spawned;
	

	//constructor
	public Person(Floor f)
	{
		time_spawned = Timekeeper.get_timestep();
		//create random floor destination for each person
		Random r = new Random();
		int floorNumber = r.nextInt(7)+1;
		while(floorNumber==f.get_floor())
			floorNumber = r.nextInt(7)+1;
		destination = Floors.floors[floorNumber-1];
		if(f.get_floor()<destination.get_floor()){//if your destination is above you
			steps_walking = Main.steps_up*(Math.abs(f.get_floor()-destination.get_floor()));
		}else{
			steps_walking = Main.steps_down*(Math.abs(f.get_floor()-destination.get_floor()));
		}
		//time_spawned = ; //poisson distribution
	}


	///////////GETTERS///////////////////////
	
	public Floor get_floor_off()
	{
		return destination;
	}
	public void delete(){
		//Log total time here
		System.out.println("DELETING A PERSON: Total Time: " + (time_spawned-Timekeeper.get_timestep()));
	}



}