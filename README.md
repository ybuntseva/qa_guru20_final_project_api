<h1 >API Automation Project for <a href="https://reqres.in/">reqres.in</a></h1>

![WB_logo.jpg](images/icons/reqres_logo.png)

### :pushpin: Table of contents:

+ [Stack of technologies](#tools)
+ [Running tests](#test-runs)
    + [Running tests from the Terminal](#gradle-commands)
    + [Running tests in Jenkins](#-testrun-in-jenkins)
+ [Telegram notifications](#-telegram-notifications)
+ [Test run results in Allure Report](#-testrun-results-in-allure-report)
+ [Allure TestOps integration](#allure-testOps-integration)
+ [Jira integration](#jira-integration)

<a id="tools"></a>
### :computer: Технологии и инструменты

<p  align="center">
  <a href="https://www.jetbrains.com/idea/"><code><img width="5%" title="IntelliJ IDEA" src="./images/icons/IDEA-logo.svg"></code>
  <a href="https://www.java.com/"><code><img width="5%" title="Java" src="./images/icons/java-logo.svg"></code>
  <a href="https://gradle.org/"><code><img width="5%" title="Gradle" src="./images/icons/gradle-logo.svg"></code>
  <a href="https://junit.org/junit5/"><code><img width="5%" title="JUnit5" src="./images/icons/junit5-logo.svg"></code>
  <a href="https://rest-assured.io/"><code><img width="5%" title="RestAssured" src="./images/icons/rest-assured-logo.svg"></code>
  <a href="https://github.com/allure-framework/allure2"><code><img width="5%" title="Allure Report" src="./images/icons/allure-Report-logo.svg"></code>
  <a href="https://qameta.io/"><code><img width="5%" title="Allure TestOps" src="./images/icons/allure-ee-logo.svg"></code>
  <a href="https://github.com/"><code><img width="5%" title="Github" src="./images/icons/github-mark.svg"></code>
  <a href="https://www.jenkins.io/"><code><img width="5%" title="Jenkins" src="./images/icons/jenkins-logo.svg"></code>
  <a href="https://www.atlassian.com/ru/software/jira"><code><img width="5%" title="Jira" src="./images/icons/jira-logo.svg"></code>
  <a href="https://web.telegram.org/"><code><img width="5%" title="Telegram" src="./images/icons/Telegram.svg"></code>
</p>

In this project API automation tests are written in `Java` with the help of `REST assured` and `Lombok` libraries.\  
`Gradle` - is used for build automation.  \
`JUnit5` - responsible for test execution.\
`Jenkins` - CI/CD automation server for running tests remotely.\
`Allure Report` - is used to present testrun results.\
`Telegram Bot` - sends notifications to `Telegram`.

[Back to table of contents ⬆](#pushpin-table-of-contents)

## <a name="GradleCommand">Gradle commands</a>

***Running tests from the Terminal:***
```bash  
gradle clean test
```

***Running tests in Jenkins:***
```bash  
clean
"${TASK}"
"-DbaseUrl=${URL}"
```

[Back to table of contents ⬆](#pushpin-table-of-contents)

## <img src="./images/icons/jenkins-logo.svg" title="Jenkins" width="4%"/> <a name="Test execution in Jenkins">Test execution in [Jenkins](https://jenkins.autotests.cloud/job/qa_guru20_api_final_project/)</a>
Build main page:
<p  align="center">
<img src="images/screenshots/jenkins-build.png" width="950">
</p>

Once the build has finished, the results are available in:
>- <code><strong>*Allure Report*</strong></code>
>- <code><strong>*Allure TestOps*</strong></code> - the results are uploaded and test cases can be automatically updated if any changes have been made to the code.

[Back to table of contents ⬆](#pushpin-table-of-contents)

# <img width="4%" style="vertical-align:middle" title="Telegram" src="images/icons/Telegram.svg"> <a>Telegram notification</a>
After test execution <code>Telegram</code> bot sends a notification with test run results.
<p  align="center">
<img src="images/screenshots/telegram-notification.png" width="550">
</p>

[Back to table of contents ⬆](#pushpin-table-of-contents)

# <img width="4%" style="vertical-align:middle" title="AllureReport" src="images/icons/allure-Report-logo.svg"> <a name="AllureReport">Test run results in [Allure Report](https://jenkins.autotests.cloud/job/qa_guru20_api_final_project/4/allure/)</a>

## Allure report main page
Allure main page contains:

>- <code><strong>*ALLURE REPORT*</strong></code> 
>- <code><strong>*TREND*</strong></code>
>- <code><strong>*SUITES*</strong></code>
>- <code><strong>*CATEGORIES*</strong></code>
<p align="center">
  <img src="images/screenshots/allure-overview.png" width="950">
</p>

## List of tests with steps, request and response

<p align="left">
  <img src="images/screenshots/allure-suites.png" alt="AllureResult" width="950">
</p>

[Back to table of contents ⬆](#pushpin-table-of-contents)

# <img width="4%" style="vertical-align:middle" title="Allure TestOps" src="images/icons/allure-ee-logo.svg"> <a>Integration with [Allure TestOps](https://allure.autotests.cloud/project/3656/dashboards)</a>
> Link is available to authorized users only.

<code>Jenkins</code> build is integrated with <code>Allure TestOps</code>.
Test run results are available in <code>Allure TestOps</code>
Dashboard in <code>Allure TestOps</code> contains pie charts with test execution statistics.

## Allure TestOps Dashboard

<p align="center">
  <img src="images/screenshots/test-ops-dashboard.png" alt="AllureTestOps" width="950">
</p>

## Allure TestOps Test Cases

<p align="center">
  <img src="images/screenshots/test-ops-test-cases.png" alt="AllureTestOpsTests" width="950">
</p>

[Back to table of contents ⬆](#pushpin-table-of-contents)

# <img width="4%" style="vertical-align:middle" title="Jira" src="images/icons/jira-logo.svg"> <a>Интеграция с Jira</a>
<code>Allure TestOps</code> is integrated with <code>Jira</code>, Jira tickets contain information about created test cases and test run results.
<p align="center">
  <img src="images/screenshots/jira-integration.png" alt="JiraIntegration" width="950">
</p>

[Back to table of contents ⬆](#pushpin-table-of-contents)




