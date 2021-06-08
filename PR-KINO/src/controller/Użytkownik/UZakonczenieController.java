package controller.Użytkownik;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import controller.MainController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UZakonczenieController {
    private MainController main;
    public AnchorPane anchor;
    public static void createQR(String data, String path,
                                String charset, Map hashMap,
                                int height, int width)
            throws WriterException, IOException
    {

        BitMatrix matrix = new MultiFormatWriter().encode(
                new String(data.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, width, height);

        MatrixToImageWriter.writeToFile(
                matrix,
                path.substring(path.lastIndexOf('.') + 1),
                new File(path));
    }

    public static String readQR(String path, String charset,
                                Map hashMap)
            throws FileNotFoundException, IOException,
            NotFoundException
    {
        BinaryBitmap binaryBitmap
                = new BinaryBitmap(new HybridBinarizer(
                new BufferedImageLuminanceSource(
                        ImageIO.read(
                                new FileInputStream(path)))));

        Result result
                = new MultiFormatReader().decode(binaryBitmap);

        return result.getText();
    }

    public void init(MainController main) {
        this.main = main;


        Map<EncodeHintType, ErrorCorrectionLevel> hashMap
                = new HashMap<EncodeHintType,
                                ErrorCorrectionLevel>();

        hashMap.put(EncodeHintType.ERROR_CORRECTION,
                ErrorCorrectionLevel.L);
        try{
            createQR("teset test test tests tset", "c:\\Windows\\Temp\\qr.png", "utf-8", hashMap, 400, 400);
            System.out.println("QR Code Generated!!! ");
            File file = new File("c:\\Windows\\Temp\\qr.png");
            Image image = new Image(file.toURI().toString(), 400, 400, false, true);
            ImageView imageView = new ImageView();
            imageView.setImage(image);
            imageView.setX(170);
            imageView.setY(140);
            anchor.getChildren().add(imageView);
            //System.out.println(readQR("C:\\Windows\\Temp\\qr.png","utf-8",hashMap));
        } catch (Exception e){
            System.out.println(e);
        }
    }
public void zakoncz(){

}

}
