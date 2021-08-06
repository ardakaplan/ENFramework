package com.enerjisa.enframework.helpers;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;

import java.io.IOException;

/**
 * Created by Arda Kaplan at 12.12.2020 - 23:53
 * <p>
 * ardakaplan101@gmail.com
 */
public final class ENBitmapHelpers {

    private ENBitmapHelpers() {

    }

    public static Bitmap rotateImageIfRequired(Bitmap bitmap, Uri selectedImageUri) throws IOException {

        ExifInterface ei = new ExifInterface(selectedImageUri.getPath());

        int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);

        switch (orientation) {

            case ExifInterface.ORIENTATION_ROTATE_90:

                return rotateImage(bitmap, 90);

            case ExifInterface.ORIENTATION_ROTATE_180:

                return rotateImage(bitmap, 180);

            case ExifInterface.ORIENTATION_ROTATE_270:

                return rotateImage(bitmap, 270);

            default:

                return bitmap;
        }
    }

    public static Bitmap rotateImage(Bitmap bitmap, int degree) {

        Matrix matrix = new Matrix();

        matrix.postRotate(degree);

        Bitmap rotatedImg = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);

        bitmap.recycle();

        return rotatedImg;
    }
}
