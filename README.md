## Event Tracker Project

#### Created By Zachary Lamb

### Summary
This program was strictly built out a desire to challenge myself. This is a basic flight tracker that I believe an airport would use to keep track of flights coming in and going out. It was only built out to 5 database tables but when thinking of the magnitude that this project could become is astonishing to me. I find it fascinating that there are all of these underlying processes out in the world that we take for granted. This project helped give me a little look at the real world and I am excited to jump into it soon. This project was built just after week 11 of the boot camp meaning I only have 5 more weeks to go until graduation.

### Overview
The premise and goal of this project was to build out an event tracker. We had full control of the project from start to finish. I came up with the idea and coded everything to make it work. I choose a flight tracker which I thought would be fun and challenging.

#### Operation/Description of how the program works:
This program was primarily tested with Postman to ensure that all functionality worked.

#### Technologies/Techniques Used

| Technologies       |
| ------------------ |
| JPA                |
| JDBC               |
| AWS                |
| Develop Database   |
| Sprint Tools Suite |
| Entities           |
| Interface          |
| MAMP               |
| MySQL Workbench    |
| JUnit Jupiter      |
| SpringBoot         |
| Service            |
| Controller         |
| Repositories       |



#### Lessons Learned
- The set up is always the hardest and most important part of any project. If you first don't get it set up right the first time you will have issues down the road or nothing will even work. Down the road if you try to edit and change things it will require a whole reworking of everything.

#### Problems/Issues
- I was having an issue with how the JSon was coming back. It had to do with any of the lists being a part an entity. The solution was to remove the list from the toString of each entity that had a list. Even though I had @JsonIgnore on the lists and the toString list had .size() it was still causing issues.

#### Things we were unable to add or incorporate
- I would have liked to build out more database tables
