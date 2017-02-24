public class Timekeeper{

	private static int timestep=0;
	public static int get_timestep(){
		return timestep;
	}
	public static void increment_timestep(){
		timestep++;
	}
}