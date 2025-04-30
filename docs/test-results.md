# Results of Testing

The test results show the actual outcome of the testing, following the [Test Plan](test-plan.md)

---

## Is The Track Set Up Properly

The track should have both racers and corners set up on it.

### Test Data Used

I ran the code and printed lists for racer one's position, racer two's position, and the location of the corners.

### Test Result

![Screenshot 2025-04-30 232432.png](screenshots/Screenshot%202025-04-30%20232432.png)

Track seems to be in working order, the cars are in the correct place, 
(The empty space at the start is to help them start a new lap.) and the corners ()

---

## Can The Intro Collect And Store Player Inputs

The intro needs to get two types of player info, first, a string, most likely the players name, and two, a single letter, used for choices.

### Test Data Used

I input some player names to see if it can print them back at me, I tried answering a yes/no question with more than one letter,
and finally, I checked whether the yes/no question outputs the right response based on the player input.

### Test Result

![Screenshot 2025-05-01 005436.png](screenshots/Screenshot%202025-05-01%20005436.png)

As you can see, the program is able to easily retrieve and print player input, now, what about yes/no questions? 

![Screenshot 2025-05-01 005837.png](screenshots/Screenshot%202025-05-01%20005837.png)

![Screenshot 2025-05-01 005909.png](screenshots/Screenshot%202025-05-01%20005909.png)

Fortunately, the yes/no questions are functioning properly.

I also put in some invalid inputs to see its reaction, it didn't allow them, but it also didn't have an error message, sometimes it didn't even reprint the question, so I typed some of those up, here's the result:

![Screenshot 2025-05-01 012847.png](screenshots/Screenshot%202025-05-01%20012847.png)

---

## Does Each Player Get A Turn

Once player one has chosen an action, it should then switch to asking player two for an action.

### Test Data Used

Ran through the code to make sure it's updating the right variables

### Test Result

![Screenshot 2025-05-01 013909.png](screenshots/Screenshot%202025-05-01%20013909.png)

Yup, you can see here the use of the players name, indicating the turns are functioning properly.

---

## Does The Program Change The Player's Speed Based On What Option They Chose.

When a player chooses accelerate, it should increase their speed, when they choose decelerate, it should decrease etc.

### Test Data Used

I tried all of the different options and printed the speed after each one.

### Test Result

![Screenshot 2025-05-01 014634.png](screenshots/Screenshot%202025-05-01%20014634.png)

![Screenshot 2025-05-01 014701.png](screenshots/Screenshot%202025-05-01%20014701.png)

![Screenshot 2025-05-01 014722.png](screenshots/Screenshot%202025-05-01%20014722.png)

![Screenshot 2025-05-01 014839.png](screenshots/Screenshot%202025-05-01%20014839.png)

All options are functioning as intended, A raises speed by 10, B by 50, C keeps it the same, and D decreases it by 10.

---

## Do The Cars Move

The cars should move forward on the track in the amount of spaces correlating to their speed.

### Test Data Used

Ran the code, set the speed for the cars, and counted the amount of spaces they moved.

### Test Result

![example.png](screenshots/example.png)

Comment on test result. Comment on test result. Comment on test result. Comment on test result. Comment on test result. Comment on test result.

---

## Can the cars go back to the start

Once a car completes a lap, it should be sent back to the start of the track.

### Test Data Used

I ran the code multiple times with the cars going at different speeds.

### Test Result

![Screenshot 2025-04-29 140907.png](screenshots/Screenshot%202025-04-29%20140907.png)

When I tested the results, the program returned that I was out of bounds.
This was because, after the program tries to move the car normally and failing, the spot that used to contain the car 
would remain empty, meaning the car didn't exist, so when I referenced the cars location later, it didn't know what I
was talking about, to fix this, I simply added a line of code to the catch after the try that replaced the car back 
where it should be.

---

## Do The Cars Crash

When a car is going around a corner it should generate a number and based on the outcome, either crash or survive, the higher the number,
the bigger the chance to crash.

### Test Data Used

I drove the cars around corners at various speeds and recorded the outcome.

### Test Result

![example.png](screenshots/example.png)

Comment on test result. Comment on test result. Comment on test result. Comment on test result. Comment on test result. Comment on test result.

---

## Does The Boost Grant Invincibility

Using a boost on a corner should make you immune to crashing.

### Test Data Used

I will approach the corner at a speed which should have a 100% chance of crashing, then use a boost to go around the corner at high speeds.

### Test Result

![example.png](screenshots/example.png)

Comment on test result. Comment on test result. Comment on test result. Comment on test result. Comment on test result. Comment on test result.

---

## Does The Number Of Laps Increase

When a car goes around the track, their number of laps completed should go up by one.

### Test Data Used

Go around the track and print the number of laps.

### Test Result

![example.png](screenshots/example.png)

Comment on test result. Comment on test result. Comment on test result. Comment on test result. Comment on test result. Comment on test result.

---

## Does the track display properly

Once the players complete a round, (Two turns.) the program should print an image of the track with a number 1 and 2 showing where the cars are.

### Test Data Used

Run the code with the cars in different positions to see if everything is where it is meant to be.

### Test Result

![example.png](screenshots/example.png)

Success! The cars all display properly, and the track looks great.

---

## Can You Win

Once a car completes 3 laps, the game should end, and they should be congratulated.

### Test Data Used

Win the race with both drivers and check the resulting message.

### Test Result

![example.png](screenshots/example.png)

Comment on test result. Comment on test result. Comment on test result. Comment on test result. Comment on test result. Comment on test result.

---