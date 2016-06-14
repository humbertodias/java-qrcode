
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;
import javax.imageio.ImageIO;

public class QRCodeGen {

    public static File generate(String filePath, int width, int height, String text) throws WriterException, IOException {
        Map<EncodeHintType, Object> hintMap = new EnumMap<>(EncodeHintType.class);
        hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        // Now with zxing version 3.2.1 you could change border size (white border size to just 1)
        hintMap.put(EncodeHintType.MARGIN, 1);
        /* default = 4 */
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix byteMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width,
                height, hintMap);
        int CrunchifyWidth = byteMatrix.getWidth();
        BufferedImage image = new BufferedImage(CrunchifyWidth, CrunchifyWidth,
                BufferedImage.TYPE_INT_RGB);
        image.createGraphics();

        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, CrunchifyWidth, CrunchifyWidth);
        graphics.setColor(Color.BLACK);

        for (int i = 0; i < CrunchifyWidth; i++) {
            for (int j = 0; j < CrunchifyWidth; j++) {
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

    // Tutorial: http://zxing.github.io/zxing/apidocs/index.html
    public static void main(String[] args) throws WriterException, IOException {
        if (args.length < 4) {
            System.err.println("Usage: java QRWrite filePath width height message");
            System.exit(-1);
        } else {
            File file = generate(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
            System.out.println("You have successfully created QR Code on " + file.getAbsolutePath());
        }
    }
}
