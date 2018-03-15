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
public class Timekeeper{

	private static int timestep=0;
	public static int get_timestep(){
		return timestep;
	}
	public static void increment_timestep(){
		timestep++;
	}
}