# Algorithmic weightlifting program generator
This program takes user input like the user's best lifts (snatch, clean and jerk, squat, etc.), experience level, and
how long each cycle will be (how far out from competition) and uses this data to determine the appropriate volume and
intensity each month for their individual needs. 

When it is complete it will output everything down to the specific days/exercises/sets/reps/weight and potentially 
adjust the weekly/daily parts of the program based on user feedback (recovery, performance in the previous workout, 
etc.)

# To do:
-Weeks now divide up the total monthly(micro-cycle) volume, and now the week class needs a way to create individual days,
which will further divide up the volume amongst themselves.

Right now a lot of code is being rewritten between classes, and it would be more efficient for the child objects to 
inherit certain methods and values from their parent object to get rid of the redundant code. Once I get the days 
splitting up volume properly, I will go back and rework how the classes are set up.

Also adding enum classes would help keep track of types of months/weeks/days, as well as experience level.