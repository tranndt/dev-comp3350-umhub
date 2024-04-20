```
┌──────────────────────────────┬───────────────────────────┬────────────────────────────────────┐
│       UI Layer               │     Logic Layer           │            Data Layer              │
│                              │                           │                                    │
├──────────────────────────────┼───────────────────────────┼────────────────────────────────────┤
│                              │                           │                                    │
│HomeActivity.java             │   ┌──────────────┐        │       ┌───────────────┐            │
│LoginActivity.java            │   │              │        │       │               │            │
│MajorsActivity.java           │   │ application  │        │       │   interfaces  │            │
│ProgramsActivity.java         │   │              │        │       │               │            │
│CoursesActivity.java          │   └──────────────┘        │       └───────────────┘            │
│CourseReviewsActivity.java    │   Services.java           │   ICoursePersistence.java          │
│WriteCourseReviewActivity.java│   SignUpException.java    │   ICourseReviewPersistence.java    │
│TutorsActivity.java           │   UserException.java      │   IMajorPersistence.java           │
│RateTutorsActivity.java       │                           │   IProgramPersistence.java         │
│Messages.java                 │   ┌──────────────┐        │   ITutorPersistence.java           │
│SeeCourseReviewActivity.java  │   │              │        │   IUserPersistence.java            │
│                              │   │   business   │        │                                    │
│                              │   │              │        │        ┌──────────────┐            │
│   ┌──────────┐               │   └──────────────┘        │        │              │            │
│   │          │               │ IAccessCourseReviews.java │        │    sqlite    │            │
│   │ adapters │               │ IAccessCourses.java       │        │              │            │
│   │          │               │ IAccessMajors.java        │        └──────────────┘            │
│   └──────────┘               │ IAccessPrograms.java      │   CourseReviewSQLDB.java           │
│    CourseAdapter.java        │ IAccessTutors.java        │   CourseSQLDB.java                 │
│    MajorAdapter.java         │ IAccessUsers.java         │   DBScriptIter.java                │
│    ProgramAdapter.java       │ ILogin.java               │   DatabaseHelper.java              │
│    ReviewAdapter.java        │ AccessCourseReviews.java  │   DatabaseNotCreatedException.java │
│    TutorAdapter.java         │ AccessCourses.java        │   MajorSQLDB.java                  │
│                              │ AccessMajors.java         │   ProgramSQLDB.java                │
│                              │ AccessPrograms.java       │   TutorSQLDB.java                  │
│                              │ AccessTutors.java         │   UserSQLDB.java                   │
│                              │ AccessUsers.java          │                                    │
│                              │ Login.java                │        ┌───────────────┐           │
│                              │ Utils.java                │        │               │           │
│                              │ courseSorter.java         │        │     stubs     │           │
│                              │ ratingSorter.java         │        │               │           │
│                              │                           │        └───────────────┘           │
│                              │                           │   CoursePersistenceStub.java       │
│                              │                           │   CourseReviewPersistenceStub.java │
│                              │                           │   MajorPersistenceStub.java        │
│                              │                           │   ProgramPersistenceStub.java      │
│                              │                           │   TutorPersistenceStub.java        │
│                              │                           │   UserPersistenceStub.java         │
│                              │                           │                                    │
└──────────────────────────────┴───────────────────────────┴────────────────────────────────────┘
                           Domain Specific Objects
                  Course.java         CourseReview.java
                  Major.java          TutorEntry.java
                  Program.java        TutorRating.java
                  User.java
                  