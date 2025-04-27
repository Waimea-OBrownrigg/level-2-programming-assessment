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

First I'll input some player names and see if it can print them back at me, then I'll make a yes or no question asking if they want to see the rules, 
then print a different thing depending on the answer.

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

## Does The Track Display Properly

Example test description. Example test description. Example test description. Example test description. Example test description. Example test description.

### Test Data To Use

Run the code with the cars in different positions to see if everything is where it is meant to be.

### Expected Test Result

The code will return an image of the track with everything displaying properly 

---

## Example Test Name

Example test description. Example test description. Example test description. Example test description. Example test description. Example test description.

### Test Data To Use

Details of test data and reasons for selection. Details of test data and reasons for selection. Details of test data and reasons for selection.

### Expected Test Result

Statement detailing what should happen. Statement detailing what should happen. Statement detailing what should happen. Statement detailing what should happen.

---
