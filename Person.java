import java.util.Random;
import java.nio.file.Files;//for Files
import java.nio.file.Paths;//for Paths
import java.io.IOException;//for IOException
import java.nio.file.StandardOpenOption;//for StandardOpenOption
public class Person
{
	//person object

	private Floor spawned_floor;
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
		System.out.println("Created New Person: Created at: " +f.get_floor() + " Going to: " + destination.get_floor());
		spawned_floor = f;
		//time_spawned = ; //poisson distribution
	}


	///////////GETTERS///////////////////////
	
	public Floor get_floor_off()
	{
		return destination;
	}
	public void delete(){
		//Log total time here

		System.out.println("DELETING A PERSON: Total Time: " + (Timekeeper.get_timestep()-time_spawned));

		String line = Integer.toString(time_spawned) + " " + Integer.toString(Timekeeper.get_timestep()) + " " + Integer.toString(Timekeeper.get_timestep()-time_spawned) + " " + Integer.toString(steps_walking) + " " + Integer.toString(spawned_floor.get_floor()) + " " + Integer.toString(destination.get_floor()) + "\n";
		
		try
		{
			Files.write(Paths.get("logs/"+Main.sim_name+".log"), line.getBytes(), StandardOpenOption.APPEND);
		}
		catch(IOException e)
		{
			System.out.println("can't open the file");
		}


	}



}