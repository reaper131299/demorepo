Feature: Application login


Scenario Outline: home page dedault login
Given initialize driver with chrome
And navigate to "http://www.qaclickacademy.com/"
And lick on login button
When user enter <username> and <password> and click on login
Then verify user is loggedin successfully


Examples:
|username                | password     |
|yrushikesh13@gmail.com  | Pokemon@123  |
|hahaha@haha             | heheheh      |
