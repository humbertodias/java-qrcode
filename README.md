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


## Output
![Preview](doc/qrcode.png)


## References

1. Wikipedia
	
	[QRCode](hhttps://en.wikipedia.org/wiki/QR_code)
