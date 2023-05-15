# recipeapp

## Time Spending Building the Application

- Understand the problem and establish design scope: 1h30min
- Study the Framework ( e-leaning and documentation reading ): 24h
- Development:
  - Domain layer: 2h30min
  - Controller layer: 5h
  - Web Layer: 3h
  - Rest Api: 6h

As I am complete new to Grails and Groovy, on this project I did not spend time writing unit test for this project
and also implementing some json views for not found(404) and internal error(500) for the Rest Api.

to create runnable archives run:
`grails package`

The docker-compose can be used to create a Postgres Database container for the project:
`docker-compose up`

The database diagram can be found here:
https://miro.com/app/board/uXjVMJG_v1o=/?share_link_id=977014047647