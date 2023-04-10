package com.example.chatgptdemo.util;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.util.ResourceUtils;

import java.io.IOException;

/**
 * @author sa
 * @date 10.04.2023
 * @time 16:47
 */
public class PDFUtils
{
    public static String readPdfContent(String resourcePath) throws IOException
    {
        String text = null;
        PDDocument document = PDDocument.load(ResourceUtils.getFile(resourcePath));
        if (!document.isEncrypted()) {
            PDFTextStripper stripper = new PDFTextStripper();
            text = stripper.getText(document);
        }
        document.close();
        return text;
    }
}
