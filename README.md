# Getting Started

### Introduction

CreditCard Controller that validates CreditCard using Luhn algorithm and returns the output

### REST API Methods
    GET /creditcard/{cardNo}

cardNo - is the Credit Card number

### How to run
Please execute the below commanand to start the server
    gradlew bootRun

After successfull startup, please open the below URL
    http://localhost:8080/creditcard/4111111111111111

### Test Data
Given the following credit cards:
* 4111111111111111
* 4111111111111
* 4012888888881881
* 378282246310005
* 6011111111111117
* 5105105105105100
* 5105 1051 0510 5106
* 9111111111111111

I would expect the following output:
* VISA: 4111111111111111 (valid)
* VISA: 4111111111111 (invalid)
* VISA: 4012888888881881 (valid)
* AMEX: 378282246310005 (valid)
* Discover: 6011111111111117 (valid)
* MasterCard: 5105105105105100 (valid)
* MasterCard: 5105 1051 0510 5106 (invalid)
* Unknown: 9111111111111111 (invalid)

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.1/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.1/gradle-plugin/reference/html/#build-image)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

