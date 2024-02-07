
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

public class QRCode {

    public static File createQRCode(String filePath, int width, int height, String text) throws WriterException, IOException {
        Map<EncodeHintType, Object> hintMap = new EnumMap<>(EncodeHintType.class);
        hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        // Now with zxing version 3.2.1 you could change border size (white border size to just 1)
        hintMap.put(EncodeHintType.MARGIN, 1);
        /* default = 4 */
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix byteMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width,
                height, hintMap);
        final int qWidth = byteMatrix.getWidth();
        final int qHeight = byteMatrix.getHeight();
        BufferedImage image = new BufferedImage(qWidth, qHeight,
                BufferedImage.TYPE_INT_RGB);
        image.createGraphics();

        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, qWidth, qHeight);
        graphics.setColor(Color.BLACK);

        for (int i = 0; i < qWidth; i++) {
            for (int j = 0; j < qWidth; j++) {
                if (byteMatrix.get(i, j)) {
                    graphics.fillRect(i, j, 1, 1);
                }
            }
        }
        File file = new File(filePath);
        String fileType = file.getName().split("\\.")[1];
        ImageIO.write(image, fileType, file);
        return file;
    }

    public static String readQRCode(String filePath, String charset, Map hintMap)
            throws IOException, NotFoundException {
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
                new BufferedImageLuminanceSource(
                        ImageIO.read(Files.newInputStream(Paths.get(filePath))))));
        Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap,
                hintMap);
        return qrCodeResult.getText();
    }

    // Tutorial: http://zxing.github.io/zxing/apidocs/index.html
    public static void main(String[] args) throws WriterException, IOException, NotFoundException {
        if (args.length < 2) {
            Map hintMap = new HashMap();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            String text = readQRCode(args[0], "UTF-8", hintMap);
            System.out.println(text);
        } else if (args.length == 4) {
            File file = createQRCode(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
            System.out.println("You have successfully created QR Code on " + file.getAbsolutePath());
        } else {
            System.err.println("Usage:");
            System.err.println("java QRCode filePath width height message");
            System.err.println("java QRcore imagePath");
        }
    }
}
