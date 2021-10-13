# Algorithmic weightlifting program generator
This program takes user input like the user's best lifts (snatch, clean and jerk, squat, etc.), experience level, and
how long each cycle will be (how far out from competition) and uses this data to determine the appropriate volume and
intensity each month for their individual needs. 

When it is complete it will output everything down to the specific days/exercises/sets/reps/weight and potentially 
adjust the weekly/daily parts of the program based on user feedback (recovery, performance in the previous workout, 
etc.)

# To do:
-Restructure the Program class. In order to output more specific programs, the data will need to be passed down from 
the program object into the month/week/day/exercise objects. Currently, all the methods are in the program class, and it
is getting pretty messy.