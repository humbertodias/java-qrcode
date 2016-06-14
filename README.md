# Java QRCode Generator

Java Tools for generating QRCode.


## Prerequires

1. Git 2.6+
2. Maven 3.3+
3. Java 8+


## How to Play

Clone

```
git clone https://github.com/humbertodias/java-qrcode.git
```

Inside the folder

```
cd java-qrcode/src
```

Run

```
mvn compile exec:java \
-Dexec.mainClass="QRCodeGen"  \
-Dexec.args="qrcode.png 512 512 'The quieter you become, the more you can hear.'"
```

**Arguments**

Index | Value  | Description
------------- | ------------- | -------------
0 | qrcode.png | File path
1 | 512 | Width Image 
2 | 512 | Height Image
3 | 'The quieter you become, the more you can hear.' | Message

## Output
![Preview](doc/qrcode.png)


## References

1. [QRCode](https://en.wikipedia.org/wiki/QR_code)
