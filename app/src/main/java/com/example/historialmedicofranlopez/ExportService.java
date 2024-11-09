package com.example.historialmedicofranlopez;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;

import java.io.File;
import java.util.List;

public class ExportService {
    public static File generateReport(Context context, List<MedicalRecord> records) {
        try {
            File reportFile = new File(context.getExternalFilesDir(null), "medical_report.pdf");
            PdfDocument document = new PdfDocument();
            PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(595, 842, 1).create();
            PdfDocument.Page page = document.startPage(pageInfo);

            Canvas canvas = page.getCanvas();
            Paint paint = new Paint();
            paint.setTextSize(12);

            int y = 25;
            for (MedicalRecord record : records) {
                canvas.drawText("Condición: " + record.getCondition(), 10, y, paint);
                y += 20;
                canvas.drawText("Tratamiento: " + record.getTreatment(), 10, y, paint);
                y += 40;
            }

            document.finishPage(page);
            document.writeTo(new FileOutputStream(reportFile));
            document.close();
            return reportFile;
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context, "Error al generar el informe", Toast.LENGTH_SHORT).show();
            return null;
        }
    }
}
