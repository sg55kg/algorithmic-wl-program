# Algorithmic weightlifting program generator
This program takes user input like the user's best lifts (snatch, clean and jerk, squat, etc.), experience level, and
how long each cycle will be (how far out from competition) and uses this data to determine the appropriate volume and
intensity each month for their individual needs. 

When it is complete it will output everything down to the specific days/exercises/sets/reps/weight and potentially 
adjust the weekly/daily parts of the program based on user feedback (recovery, performance in the previous workout, 
etc.)

# To do:
-The program class has been restructured, and now work needs to be done on passing information from the month objects to
their individual week objects. Now the ratios between the lifts will need to start fitting into the picture in order to 
determine not only total volume, but also how specifically what percentage of the total volume will go to each exercise
type.