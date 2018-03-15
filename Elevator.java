/*
Copyright 2018

This file is part of The Elevator Traffic Simulator.

The Elevator Traffic Simulator is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

The Elevator Traffic Simulator is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with The Elevator Traffic Simulator.  If not, see <http://www.gnu.org/licenses/>.

*/

import java.util.ArrayList;
import java.util.Arrays;
public class Elevator{

	private final int capacity = 12;
	private int spf;
	private int stationary_time;
	private boolean up;
	private Floor cur_floor;
	private ArrayList<Person> people;
	private double last_timestep_on_floor;
	private boolean doors_open;

	/**
	*Main constructor for the Elevator class; takes in a config object and an the starting floor
	*@param config the config object to initialize each elevator
	*@param start_floor the floor object to initialize the starting floor to be the current floor
	*/

	public Elevator(Config c, Floor start_floor){
		spf = c.get_steps_per_floor_elevator();
		stationary_time = c.get_stationary_steps();
		cur_floor = start_floor;
		up = true;
		doors_open = false;
		people = new ArrayList<Person>();
		last_timestep_on_floor = 0;
	}

	public void check_if_next_floor(){
		if(doors_open){
			if(Timekeeper.get_timestep()-last_timestep_on_floor>=stationary_time){
				System.out.println("Doors are now closed");
				doors_open = false;
				last_timestep_on_floor = Timekeeper.get_timestep();
			}else{
				return;
			}
		}
		//if enough time has passed, advance to the next floor
		if(Timekeeper.get_timestep()-last_timestep_on_floor>=spf){
			last_timestep_on_floor = Timekeeper.get_timestep();//update the last time the elevator was on the floor
			if(up){//if we are moving up 
				cur_floor = cur_floor.get_floor_above();//move to the floor above us
				System.out.println("Moving up to " + cur_floor.get_floor());
			}else{//otherwise
				cur_floor = cur_floor.get_floor_below();//move to the floor below us
				System.out.println("Moving down to " + cur_floor.get_floor());
			}
			boolean people_moved = false;//a boolean to keep track of whether or not people have gotten on or off the elevator here
			int people_change = 0;
			Person[] people_arr = Arrays.copyOf(people.toArray(), people.toArray().length, Person[].class);// convert the ArrayList to an array
			for(int i=0;i<people_arr.length;i++){//for each person in the elevator
				if(people_arr[i].get_floor_off()==cur_floor){//if people want to get off at this floor

					people_moved = true;
					people.remove(people_arr[i]);//take them out of the array list
					people_arr[i].delete();//"delete" that person
					people_change++;
				}	
			}
			System.out.println(people_change + " people have moved off the elevator");
			people_change = 0;
			int capacity_remaining = capacity-people.size();//calculate how many people can fit in the elevator
			for(int i=0;i<capacity_remaining;i++){//for each space in the elevator that can hold a person
				Person person = cur_floor.remove_person();//pop the next person off the linked list of people of the current floor
				if(person==null){//if the list is empty when you try and remove someone, break the loop
					break;
				}
				people_moved = true;
				people_change++;
				people.add(person);//add the removed person to the ArrayList of people on the elevator
			}
			System.out.println(people_change + " people have moved on the elevator");
			if(people_moved){//if people got on/off the elevator on this floor, open the doors
				doors_open = true;
			}

			if(cur_floor.get_floor()==8 || cur_floor.get_floor()==1){//if at top or bottom floor, switch directions
				System.out.println("Changing directions");
				up = !up;
			}
		}		
	}
}