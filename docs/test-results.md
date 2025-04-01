# Results of Testing

The test results show the actual outcome of the testing, following the [Test Plan](test-plan.md)

---

## Can the cars go back to the start

Once a car completes a lap, it should be sent back to the start of the track.

### Test Data To Use

To test this I'll run the code multiple times with the cars going at different speeds.

### Test Result

![example.png](screenshots/example.png)

When I tested the results, the program returned that I was out of bounds.

This was because, after the program tries to move the car normally and failing, the spot that used to contain the car 
would remain empty, meaning the car didn't exist, so when I referenced the cars location later, it didn't know what I
was talking about, to fix this, I simply added a line of code to the catch after the try that replaced the car back 
where it should be.

---

## Does the track display properly

Example test description. Example test description. Example test description. Example test description. Example test description. Example test description.

### Test Data To Use

Run the code with the cars in different positions to see if everything is where it is meant to be.

### Test Result

![example.png](screenshots/example.png)

Success! The cars all display properly, and the track looks great.

---

## Example Test Name

Example test description. Example test description.Example test description. Example test description.Example test description. Example test description.

### Test Data Used

Details of test data. Details of test data. Details of test data. Details of test data. Details of test data. Details of test data. Details of test data.

### Test Result

![example.png](screenshots/example.png)

Comment on test result. Comment on test result. Comment on test result. Comment on test result. Comment on test result. Comment on test result.

---

