package qrcode;

import com.google.zxing.EncodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    // Tutorial: http://zxing.github.io/zxing/apidocs/index.html
    public static void main(String[] args) throws WriterException, IOException, NotFoundException {
        final QRCode qrCode = new QRCode();
        if (args.length == 0) {
            System.err.println("Usage:");
            System.err.println("# Create");
            System.err.println("java -jar qrcode.jar filePath width message");
            System.err.println("# Read");
            System.err.println("java -jar qrcode.jar imagePath");
            System.exit(1);
        } else if (args.length < 2) {
            Map hintMap = new HashMap();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            String text = qrCode.read(args[0], "UTF-8", hintMap);
            System.out.println(text);
        } else if (args.length == 4) {
            File file = qrCode.create(args[0], Integer.parseInt(args[1]), args[3]);
            System.out.println("You have successfully created QR Code on " + file.getAbsolutePath());
        }
    }
}
