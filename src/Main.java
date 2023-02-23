import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        String input;
        List<String> filePaths = new ArrayList<String>();


        do {
            System.out.print("Enter a file path of an image, or if done enter \"done\": ");
            input = scanner.nextLine();
            filePaths.add(input);
        } while (!input.trim().equalsIgnoreCase("done"));

        filePaths.remove(filePaths.size()-1);

        System.out.print("Enter the output file path (including file extension): ");
        String outputPath = scanner.nextLine();

        PdfDocument pd = new PdfDocument(new PdfWriter(new FileOutputStream(outputPath)));
        Document d = new Document(pd, new PageSize(PageSize.A4));

        for (String s : filePaths) {

            Image i = new Image(ImageDataFactory.create(s));

            d.add(i);


        }

        pd.close();
        d.close();

    }
}