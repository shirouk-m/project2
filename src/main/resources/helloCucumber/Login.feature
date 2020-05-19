Feature: Is it Friday yet?
  Everybody wants to know when it's Friday

  Scenario: Login Successfully
    Given Open a Browser And Navigate To FaceBookPage
    When user Enter Email and Password
    Then Login in faceBook
    Then Take A Screensot To ensure Login Successfully
    Then Navigate To Victim Url and Login Again
    Then Send Spam Message To Victim
    Then Close Browser And export A report

