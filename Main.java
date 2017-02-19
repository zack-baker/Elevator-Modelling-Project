public class Main{

	public static void main(String[] args){
		Config c = new Config(args[0]);//the first command line argument is the path of the config file
		System.out.println(c);
	}
}