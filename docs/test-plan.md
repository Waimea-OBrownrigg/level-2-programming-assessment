# Plan for Testing the Program

The test plan lays out the actions and data I will use to test the functionality of my program.

Terminology:

- **VALID** data values are those that the program expects
- **BOUNDARY** data values are at the limits of the valid range
- **INVALID** data values are those that the program should reject

---

## Is The Track Set Up Properly

The track should have both racers and corners set up on it.

### Test Data To Use

Simply run the code and print the lists for racer one's position, racer two's position, and the location of the corners.

### Expected Test Result

Racer one and two should appear at the start line, and the corners should line up with where they are on the map.

---

## Can The Intro Collect And Store Player Inputs

The intro needs to get two types of player info, first, a string, most likely the players name, and two, a single letter, used for choices.

### Test Data To Use

First I'll input some player names and see if it can print them back at me, then I'll try answering a yes/no question with more than one letter, 
and finally, I need to check whether the yes/no question outputs the right response based on the player input.

### Expected Test Result

the program should be able to print player one and two's name when needed, and it should take a single letter input and then perform the action accompanying it.

---

## Does Each Player Get A Turn

Once player one has chosen an action, it should then switch to asking player two for an action.

### Test Data To Use

just run through the code and make sure it's updating the right variables

### Expected Test Result

On player one's turn it should use player one's name and update their speed accordingly, on player two's turn it should use their name and update their speed.

---

## Does The Program Change The Player's Speed Based On What Option They Chose.

When a player chooses accelerate, it should increase their speed, when they choose decelerate, it should decrease etc.

### Test Data To Use

Try all of the different options and print the speed after each one.

### Expected Test Result

Each action should lead to its corresponding speed change.

---

## Do The Cars Move

The cars should move forward on the track in the amount of spaces correlating to their speed.

### Test Data To Use

Run the code, set the speed for the cars, and count the amount of spaces they move.

### Expected Test Result

For every 10 KMpH the cars are going, they should move forward 1 slot.

---

## Can The Cars Go Back To The Start

Once a car completes a lap, it should be sent back to the start of the track.

### Test Data To Use

To test this I'll run the code multiple times with the cars going at different speeds.

### Expected Test Result

once a car gets sent back, it should keep moving the remaining amount of spaces in relation to how fast it is going, 
e.g. a car going 80Kmph moves 2 spaces at the end, and then 6 at the start. 

---

## Do The Cars Crash

When a car is going around a corner it should generate a number and based on the outcome, either crash or survive, the higher the number, 
the bigger the chance to crash.

### Test Data To Use

Drive the cars around corners at various speeds and record the outcome.

### Expected Test Result

Lower speeds should have a smaller amount of crashes while higher speeds have a larger amount.

---

## Does The Boost Grant Invincibility

Using a boost on a corner should make you immune to crashing.

### Test Data To Use

I will approach the corner at a speed which should have a 100% chance of crashing, then use a boost to go around the corner at high speeds. 

### Expected Test Result

The car should be able to preserve its speed around the corner.

---

## Does The Number Of Laps Increase

When a car goes around the track, their number of laps completed should go up by one.

### Test Data To Use

Go around the track and print the number of laps.

### Expected Test Result

The number of laps should stay accurate.

---

## Does The Track Display Properly

Once the players complete a round, (Two turns.) the program should print an image of the track with a number 1 and 2 showing where the cars are.

### Test Data To Use

Run the code with the cars in different positions to see if everything is where it is meant to be.

### Expected Test Result

The code will return an image of the track with everything displaying properly. 

---

## Can You Win

Once a car completes 3 laps, the game should end, and they should be congratulated.

### Test Data To Use

Win the race with both drivers and check the resulting message. 

### Expected Test Result

If p2 wins, the race should end and their name should be the one that is displayed.

---