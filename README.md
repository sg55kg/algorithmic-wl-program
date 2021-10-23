# Algorithmic weightlifting program generator
This program takes user input like the user's best lifts (snatch, clean and jerk, squat, etc.), experience level, and
how long each cycle will be (how far out from competition) and uses this data to determine the appropriate volume and
intensity each month, week, and day for their individual needs. I am implementing unit testing while building this program.

When it is complete it will output everything down to the specific exercises/sets/reps/weight and potentially 
adjust the weekly/daily parts of the program based on user feedback (recovery, performance in the previous workout, 
etc.)

# To do:
-Start adding more logic involving the ratios between the lifts to determine volume/intensity for individual exercises

-Implement more tests

-Continue cleaning up the redundant/repeated code

-Potentially adding enum classes would help keep track of types of months/weeks/days, as well as experience level.