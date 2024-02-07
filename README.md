[![Build, Test, and Publish Release](https://github.com/humbertodias/java-qrcode/actions/workflows/release.yml/badge.svg)](https://github.com/humbertodias/java-qrcode/actions/workflows/release.yml)

# Java qrcode.Main Generator

Java Tools for generating qrcode.Main.


## Prerequisites

1. Git 2.6+
2. Maven 3.3+
3. Java 8+


## How to Play

Clone

```shell
git clone https://github.com/humbertodias/java-qrcode.git
```

Build

```shell
cd java-qrcode
mvn package
```

Running

**Writing**

```shell
java -jar target/qrcode-1.0.jar doc/qrcode.png 256 256 'The quieter you become, the more you can hear.'
```

**Arguments**

 Index | Value                                            | Description  
-------|--------------------------------------------------|--------------
 0     | doc/qrcode.png                                   | File path    
 1     | 256                                              | Width Image  
 2     | 256                                              | Height Image 
 3     | 'The quieter you become, the more you can hear.' | Message      

## Output
![Preview](doc/qrcode.png)


**Reading**

```shell
java -jar target/qrcode-1.0.jar doc/qrcode.png
```

Arguments

 Index | Value          | Description 
-------|----------------|-------------
 0     | doc/qrcode.png | File path   


```
[INFO] --- exec-maven-plugin:1.4.0:java (default-cli) @ java-qrcode ---
The quieter you become, the more you can hear.
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 1.832 s
[INFO] Finished at: 2016-06-14T00:57:53-03:00
[INFO] Final Memory: 11M/245M
[INFO] ------------------------------------------------------------------------
```

## Validate

[https://zxing.org/w/decode.jspx](https://zxing.org/w/decode.jspx)

![Preview](doc/decode-succeeded.png)


## References

1. [qrcode.Main](https://en.wikipedia.org/wiki/QR_code)
