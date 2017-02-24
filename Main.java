import java.util.Random;
public class Main{

	public static void main(String[] args){
		Config c = new Config(args[0]);//the first command line argument is the path of the config file
		System.out.println(c);

		//loop through each timestep
		for(int ts = 0; ts<c.get_simulation_steps();ts++){
			System.out.println(get_poisson(c.get_lambda()));
		}
	}

	/**
	*	This method calculates a random number using a poisson distribution using a specified lambda, or average value. Method developed by Donald Knuth
	*	@param lambda the average number of events happening in an interval
	*	@return a random number based on the lambda value;
	*/
	public static int get_poisson(double lambda){
		Random r = new Random();
		double l = Math.exp(-lambda);
		int k=0;
		double p = 1.0;
		do{
			p = p*r.nextDouble();
			k++;
		}while(p>l);
		return k-1;
	}
}