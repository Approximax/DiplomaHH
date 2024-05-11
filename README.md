# Test UI automation project for [Head Hunter](https://hh.ru/)
<img alt="cneos logo" src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/79/HeadHunter_logo.png/240px-HeadHunter_logo.png" />

## About Head Hunter
One of the largest job boards that helps people find job opportunities in Russia, Kazakhstan, and Belarus is HeadHunter. It has over 515 thousand companies as clients.

## Contents
- <a href="#technologies">Tools and technologies</a>
- <a href="#testcases">Executed automation test cases</a>
- <a href="#running">Running Autotests</a>
- <a href="#report">Allure Report</a>
- <a href="#testops">Allure TestOps integration</a>
- <a href="#jira">Jira integration</a>
- <a href="#telegram">Telegram notifications via bot</a>
- <a href="#video">Selenoid video of test run</a>

<a id="technologies"></a>
## Tools and technologies
  Java                                                                                                    | IntelliJ  <br>  Idea                                                                                               | GitHub                                                                                                     | JUnit 5                                                                                                           | Gradle                                                                                                     | Selenide                                                                                                         | Selenoid                                                                                                                  | Allure <br> Report                                                                                                         |  Jenkins                                                                                                        |   Jira                                                                                                              | Telegram                                                                                                            |Allure <br> TestOps                                                                                                                |Rest <br> Assured                                                    
|:---------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------:|
| <a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="images/logo/Idea.svg" width="50" height="50"  alt="IDEA"/></a> | <a href="https://github.com/"><img src="images/logo/GitHub.svg" width="50" height="50"  alt="Github"/></a> | <a href="https://junit.org/junit5/"><img src="images/logo/Junit5.svg" width="50" height="50"  alt="JUnit 5"/></a> | <a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a> | <a href="https://selenide.org/"><img src="images/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a> | <a href="https://aerokube.com/selenoid/"><img src="images/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a> | <a href="https://github.com/allure-framework"><img src="images/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a> |<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a> | <a href="https://www.atlassian.com/software/jira/"><img src="images/logo/Jira.svg" width="50" height="50" alt="Java" title="Java"/></a> | <a href="https://web.telegram.org/"><img src="images\logo\Telegram.svg" width="50" height="50" alt="Telegram"/></a> |<a href="https://qameta.io/"><img src="images\logo\Allure_TO.svg" width="50" height="50" alt="Allure_TO"/></a> |<a href="https://rest-assured.io/"><img src="images/logo/Ra.png" width="50" height="50"  alt="Rest-Assured"/></a>  
- To create autotests in this project the <code>[Java](https://www.java.com/)</code> language was used.
- <code>[Gradle](https://gradle.org/)</code> was used as an automatic build system.
- Frameworks <code>[JUnit5](https://junit.org/junit5/)</code> and <code>[Selenide](https://selenide.org/)</code> for automated testing of web applications have been applied.
- Browsers were launched via <code>[Selenoid](https://aerokube.com/selenoid/)</code>.
- To run tests remotely a job was implemented in <code>[Jenkins](https://jenkins.autotests.cloud/job/MaryPimenova-VacancyProjectUnit14/)</code> with the creation of an <code>[Allure-report](https://jenkins.autotests.cloud/job/MaryPimenova-VacancyProjectUnit14/7/allure/)</code> and sending the results to <code>[Telegram](https://web.telegram.org/)</code> using special Telegram bot.
- Integrations with с <code>[Allure TestOps](https://allure.autotests.cloud/project/2434/dashboards)</code> and <code>[Jira](https://jira.autotests.cloud/browse/HOMEWORK-720)</code> were implemented.

<a id="testcases"></a>
## Executed automation test cases
### Ui-tests
#### Authorization
- Authorization with correct credentials
- Authorization with only login input
- Authorization with only password input
#### Main page
- Checking cookies policy banner
- Check the opening of the authorization form.
#### Search page
- Checking search results
- Compensation filter check

### API-tests
#### Vacancies
- Error for deleting favorite vacancy unauthorized user
- Error for adding favorite vacancy unauthorized user
- Error for viewing favorite vacancy unauthorized user
#### User Info
- Error for requesting user info as unauthorized user
#### Employers
- Search results for employers more than 0

<a id="running"></a>
## Running Autotests
To run autotests, you need to run a command specifying the necessary build parameters.

```
clean ${TASK}
-Denvironment=${ENV}
-DbrowserRemoteUrl=${SELENOID_URL}
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-Dusername=${USERNAME}
-Dpassword=${PASSWORD}
```
where:
>- <code>TASK</code> - authorization / main_page / search_page / vacancies_API / user_info_API / employers_API
>- <code>BROWSER</code> - the browser in which the tests will be performed (chrome by default)
>- <code>BROWSER_VERSION</code> - browser version (default is 100.0)
>- <code>BROWSER_SIZE</code> - browser window size (default is 1920x1080)
>- <code>SELENOID_URL</code> - the address for running tests remotely
>- <code>USERNAME</code> - login for running tests involving authorization
>- <code>PASSWORD</code> - password for running tests involving authorization

<a id="report"></a>
## <img alt="Allure Reports" src="images/logo/Allure.svg" width="40" height="40"/> [Allure Report](https://jenkins.autotests.cloud/job/C24_approximax-unit27Diplom/allure/)
<img title="Allure Overview" src="images/attachment/allureOverview.png"> 
<img title="Allure Suites" src="images/attachment/allureSuites.png"> 

<a id="testops"></a>
## <img alt="Allure TestOps" src="images/logo/Allure_TO.svg" width="40" height="40"/> [Allure TestOps integration](https://allure.autotests.cloud/project/4226/dashboards)
<img title="TestOps Results" src="images/attachment/testsOpsResults.png">

<a id="jira"></a>
## <img alt="Jira" src="images/logo/Jira.svg" width="40" height="40"/> [Jira integration](https://jira.autotests.cloud/browse/HOMEWORK-1153)
<img title="Jira integration" src="images/attachment/jira.png"> 

<a id="telegram"></a>
## <img alt="Telegram" src="images/logo/Telegram.svg" width="40" height="40"/>Telegram notifications via bot

<a id="video"></a>
## <img alt="Selenoid" src="images/logo/Selenoid.svg" width="40" height="40"/>Selenoid video of the test run
