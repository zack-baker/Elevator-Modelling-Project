public class Floors{
	public static Floor[] floors = new Floor[8];

	public static void init(Config c){
		for(int i=0;i<floors.length;i++){
			floors[i] = new Floor(c, i);
		}
	}

}