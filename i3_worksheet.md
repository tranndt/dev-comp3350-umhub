## Iteration 3 Worksheet

### What technical debt has been cleaned up
In iteration 2, the login accepted every user. In iteration 3, we changed it to accept only the users who have previously signed-up for the system. Other than that, we included a "Continue as a guest" option for the users who do not want to sign-up but still want to access major features of the system. This debt can be categorized as reckless-deliberate. 

[Link to commit where we paid the technical debt](https://code.cs.umanitoba.ca/3350-winter-2021-a01/umhub-7/-/commit/c8b12eeb74811776ab1a0c013bb3567aa9619ed1)

### What technical debt did you leave?
We did not include the UI (did not create new buttons) for some features/user stories such as [Discussion stories](https://code.cs.umanitoba.ca/3350-winter-2021-a01/umhub-7/-/issues/17), [Social Media Group](https://code.cs.umanitoba.ca/3350-winter-2021-a01/umhub-7/-/issues/19) as we pushed them to the Future.


### Discuss a feature or User Story that was cut/re-prioritized
[Dark Mode](https://code.cs.umanitoba.ca/3350-winter-2021-a01/umhub-7/-/issues/15) was cut out of the features. It was one of the Iteration-2 features. A lot of the total estimated time was used up setting the database and other high-priority features, so we couldn't include this one.


### Acceptance Test/end-to-end
One of the tests that we wrote were about adding a professor rating. We tested that the user was able to add the professor rating after they login to the system. To make sure the test was not flaky, we set the input to a fixed value of 3. Also, we turned off some animation settings in developer mode on the emulator, because that too caused flakiness in the tests sometimes.

[Links](b1e8caaf78b7316403dbc478e266038bdfd36326)

### Acceptance Test, untestable
Some implementation changes such as placing the button on the bottom of the page (have to scroll down) caused previously working system tests to fail. 


### Velocity/teamwork
The estimates got better through the course. This is because in the previous iterations, we did not have much experience in examining the time required in some features/user stories, so they ended up taking significantly more/less time than we expected. 

An example could be viewed [here](https://code.cs.umanitoba.ca/3350-winter-2021-a01/umhub-7/-/issues/11)

