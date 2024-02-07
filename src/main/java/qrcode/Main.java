package qrcode;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;

import java.io.File;
import java.io.IOException;

public class Main {

    // Tutorial: http://zxing.github.io/zxing/apidocs/index.html
    public static void main(String[] args) throws WriterException, IOException, NotFoundException, ChecksumException, FormatException {
        final QRCode qrCode = new QRCode();
        if (args.length == 0) {
            System.err.println("Usage:");
            System.err.println("# Create");
            System.err.println("java -jar qrcode.jar filePath width message");
            System.err.println("# Read");
            System.err.println("java -jar qrcode.jar imagePath");
            System.exit(1);
        } else if (args.length < 2) {
            String text = qrCode.read(args[0]);
            System.out.println(text);
        } else if (args.length == 3) {
            File file = qrCode.create(args[0], Integer.parseInt(args[1]), args[2]);
            System.out.println("You have successfully created QR Code on " + file.getAbsolutePath());
        }
    }
}
