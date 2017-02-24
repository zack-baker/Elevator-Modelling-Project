public class Main{

	public static void main(String[] args){
		Config c = new Config(args[0]);//the first command line argument is the path of the config file
		System.out.println(c);
	}

	/*for each timestep:
		each floor checks for new people
		the elevator checks to see of it moves onto the next floor
		if the elevator is at a floor, let off people at that floor and pick up waiting people.

		print to a file, the person instance and the time step they got on the elevator, the floor they got on,
		the floor they got off, (maybe the total floors they traveled?)
		*/

		

}

