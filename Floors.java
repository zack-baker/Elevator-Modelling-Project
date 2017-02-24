public class Floors{
	public static Floor[] floors = new Floor[8];

	public static void init(Config c){
		for(int i=0;i<floors.length;i++){
			System.out.println("Creating floor " + (i+1));
			floors[i] = new Floor(c, (i+1));
		}
	}

}