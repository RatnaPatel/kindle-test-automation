# kindle-test-automation
Test automation for the kindle buy now flow on amazon.ca using selenium web driver with testNG

to build the project, use: mvn clean install

Allure is used for reporting
To view reports - allure serve allure-results
sample screenshot pushed in the project folder.

For parallel test executions, testng.xml can be used 

Testng's ITestListener implementation is used for screenshot on specific events

IRetryAnalyzer implementation is used to retry test on fail
This listeners can be added on suit level or class level, here demonstrated one for suit(ITestListener) and one for class(IRetryAnalyzer) level

Selenium Grid executes our test across multiple browsers, operating systems, and machines. 
to start selenium grid, run command
java -jar selenium-server-4.9.0.jar standalone

The ExtentReports class is used to generates HTML reports based on a path specified.




