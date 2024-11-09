package com.example.historialmedicofranlopez;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import androidx.core.content.FileProvider;

import java.io.File;

public class HealthIntegrationManager {
    public static void shareToHealthService(Context context, File report) {
        if (report != null && report.exists()) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("application/pdf");
            Uri uri = FileProvider.getUriForFile(context, context.getPackageName() + ".provider", report);
            intent.putExtra(Intent.EXTRA_STREAM, uri);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            context.startActivity(Intent.createChooser(intent, "Compartir informe con servicios de salud"));
        } else {
            Toast.makeText(context, "El informe no está disponible", Toast.LENGTH_SHORT).show();
        }
    }
}

