package com.mistywillow.researchdb;

import android.util.Log;

import java.io.*;

public class DatabaseManager {

    public static void copyDatabase (InputStream in, OutputStream out) {

            try {
                copyFile(in, out);
            } catch (IOException e) {
                Log.e("tag", "Failed to copy database import file", e);
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        Log.e("CopyAssets", "Failed to close.");
                    }
                }
                if (out != null) {
                    try {
                        out.flush();
                        out.close();
                    } catch (IOException e) {
                        Log.e("CopyAssets", "Failed to flush and close.");
                    }
                }
            }
    }

    private static void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while((read = in.read(buffer)) != -1){
            out.write(buffer, 0, read);
        }
    }
}
