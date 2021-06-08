package controller.Użytkownik;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import controller.MainController;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UZakonczenieController {
    private MainController main;
    public void init(MainController main) {
        this.main = main;


        Map<EncodeHintType, ErrorCorrectionLevel> hashMap
                = new HashMap<EncodeHintType,
                                ErrorCorrectionLevel>();

        hashMap.put(EncodeHintType.ERROR_CORRECTION,
                ErrorCorrectionLevel.L);
        try{
           // createQR("Kornelia<3", "C:\\Korneliia.png", "utf-8", hashMap, 200, 200);
            System.out.println("QR Code Generated!!! ");
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
