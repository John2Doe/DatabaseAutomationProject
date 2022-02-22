
Feature: Validating Database project

  @database
  Scenario Outline: Validating DB column
    Given User is able to connect to database
    When User sends the "<query>" to database
    Then validate information taken from the database displayed correct with the order
      | Jason    | Mallin     |
      | Michael  | Rogers     |
      | Ki       | Gee        |
      | Hazel    | Philtanker |
      | Kelly    | Chung      |
      | Jennifer | Dilly      |
      | Timothy  | Gates      |
      | Randall  | Perkins    |

    Examples: Query for the database
      | query                                                                                                                         |
      | SELECT first_name, last_name from employees where manager_id = (select employee_id from employees where first_name = 'Payam') |