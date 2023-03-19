Feature: Test login function

  Scenario Outline: User log in successfully or failed
    Given user is on login page
    And verify login page
    And input valid and invalid value for <email> field
    And input valid and invalid data for <password> field
    When click on login button
    Then <message> is displayed
    Examples:
      | email               | password                                            | message                                                                    |
      | duyetho21@gmail.com | D21092002@m                                         | Login successfully                                                         |
      | duyetho21@gmail.    | D210902@m                                           | Invalid format, please enter again!                                        |
      | duyetho21@          | D210902@m                                           | Invalid format, please enter again!                                        |
      | duyetho21gmail.com  | D210902@m                                           | Invalid format, please enter again!                                        |
      | duyetho21           | D210902@m                                           | Invalid format, please enter again!                                        |
      | @                   | D210902@m                                           | Invalid format, please enter again!                                        |
      | .com                | D210902@m                                           | Invalid format, please enter again!                                        |
      | duyetho21@gmail.com | 12345678912344567891234567892316344567891@duyet4567 | Password must be greater than 8 and less than 50 characters                |
      | duyetho21@gmail.com | D21090m                                             | Password must be greater than 8 and less than 50 characters                |
      | duyetho21@gmail.com | 123456->>                                           | Enter required input for password filed                                    |
      | duyetho21@gmail.com | @#*_______                                          | Password must contain uppercase,lowercase, number, abnd special characters |
      | duyetho21@gmail.com | D210902@m                                           | Email already exists                                                       |




