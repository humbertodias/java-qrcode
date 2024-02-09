[![Build, Test, and Publish Release](https://github.com/humbertodias/java-qrcode/actions/workflows/release.yml/badge.svg)](https://github.com/humbertodias/java-qrcode/actions/workflows/release.yml)

# QRCode Generator

Java Tools for generating qrcode.


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
java -jar target/qrcode-1.0.jar doc/qrcode.png 256 'The quieter you become, the more you can hear.'
```

**Arguments**

 Index | Value                                            | Description  
-------|--------------------------------------------------|--------------
 0     | doc/qrcode.png                                   | File path    
 1     | 256                                              | Width Image  
 2     | 'The quieter you become, the more you can hear.' | Message      

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
The quieter you become, the more you can hear.
```

## Validate

[https://zxing.org/w/decode.jspx](https://zxing.org/w/decode.jspx)

![Preview](doc/decode-succeeded.png)


## References

1. [qrcode](https://en.wikipedia.org/wiki/QR_code)
