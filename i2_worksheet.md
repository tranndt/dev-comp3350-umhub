## Iteration 2 Worksheet

### Paying off technical debt

1) In iteration 0, we implemented the features in brief without providing much detail to them. We paid off this debt by modifying the features to include more functionality.

2) In iteration 0, we had fairly less code without proper testing and inclusion of design principles which led to some code smells. We paid off this debt by including better code, having interfaces, providing better testing by taking into consideration the SOLID design principles.

We identified these debts as deliberate and reckless technical debt because we decided to move forward as quickly as possible without giving atention to all the details.

### SOLID
The SOLID violation observed could be found [here](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-7/gaming-hub/-/issues/76) in A02-group 7's repository.

### Retrospective
Using the retrospective, we implemented the iteration by dividing tasks more uniformily and used dev tasks to progress in this iteration.

In iteration 0, we moved some features to this iteration because of time-management and organization problems we faced as a group. But, in this iteration we managed to be more communicative and organized.
We had fairly good planning for this iteration. We just moved [Dark mode](https://code.cs.umanitoba.ca/3350-winter-2021-a01/umhub-7/-/issues/15) feature to iteration 3.

### Design Patterns
The design patterns used - [Observer Pattern](https://code.cs.umanitoba.ca/3350-winter-2021-a01/umhub-7/-/blob/develop/UMHUB/app/src/main/java/comp3350/umhub/presentation/MajorsActivity.java), where we have used setOnItemClickListener in Adapter View.

### Iteration 1 feedback fixes
The issue opened by the grader can be found [here](https://code.cs.umanitoba.ca/3350-winter-2021-a01/umhub-7/-/issues/48).
The issue suggested that we were setting a major object to null when trying to access it.
We refactored it [here](https://code.cs.umanitoba.ca/3350-winter-2021-a01/umhub-7/-/commit/919de6ddfecab035fa43a67f2465d8885271bc72).