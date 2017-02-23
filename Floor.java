
public class Floor
{
	private int floor_number;
	private double floor_lambda;

	//constructor for Floor object class
	public Floor(Config config, Elevator elevator)
	{
		floor_number = 0;

		//determining floor lambda values
		for(int i = 1; i<9; i++) 
		{
			if(i < 2)
				floor_lambda = (1.0/60.0);
			else
				floor_lambda = (1.0/300.0);

		}

	}

	public Person get_queue()
	{
		
	}
}