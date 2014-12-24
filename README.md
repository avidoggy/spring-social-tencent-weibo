spring-social-tencent-weibo 
====================================

## Description
This project is an Spring Social extension for tencent-weibo. Currently, only basic operations are supported:

 - User: get profile by id or username
 - Tweet: add, add_pic, reply and comment
 - Friend: get friend list

If you are using this project, you should probably consider to read the term of use of Weibo

## Installation
Getting started In order to get started with spring-social-tencent-weibo, you have to follow only 3 simple steps.

Step 1: Get the code from GitHub

git clone --recursive git://github.com/avidoggy/spring-social-tencent-weibo.git

Step 2: Use Maven to build project

cd spring-social-tencent-weibo mvn clean install

Step 3: Add spring-social-tencent-weibo as a Maven dependency
### Maven
```xml
<dependency>
    <groupId>studio.bitcat</groupId>
    <artifactId>spring-social-tencent-weibo</artifactId>
    <version>1.0.1-SNAPSHOT </version>
</dependency>
```

## License 
This project is available under the Apache License, Version 2.0.
