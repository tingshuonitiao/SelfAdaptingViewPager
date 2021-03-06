package com.example.tsnt.bitmap.ImageLoader;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.FileDescriptor;

import static android.R.attr.id;

/**
 * Created by ting说你跳 on 2017/4/16.
 */

public class MyImageResizer {
    public static Bitmap compressImage(Resources res, int resId, int reqWidth, int reqHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        //calculate inSampleSize
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, id, options);
        //set inOptions
        setInSampleOptions(reqWidth, reqHeight, options);
        return BitmapFactory.decodeResource(res, id, options);
    }

    public Bitmap decodeSampledBitmapFromFileDescriptor(FileDescriptor fd, int reqWidth, int reqHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        //calculate inSampleSize
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fd, null, options);
        //set inOptions
        setInSampleOptions(reqWidth, reqHeight, options);
        return BitmapFactory.decodeFileDescriptor(fd, null, options);
    }

    private static void setInSampleOptions(int reqWidth, int reqHeight, BitmapFactory.Options options) {
        if (reqWidth == 0 || reqHeight == 0) {
            options.inSampleSize = 1;
        } else {
            int size1 = options.outWidth / reqWidth;
            int size2 = options.outHeight / reqHeight;
            options.inSampleSize = size1 > size2 ? size1 : size2;
        }
        options.inJustDecodeBounds = false;
    }

    //dstWidth和dstHeight分别为目标ImageView的宽高
    public static int calSampleSize(BitmapFactory.Options options, int dstWidth, int dstHeight) {
        int rawWidth = options.outWidth;
        int rawHeight = options.outHeight;
        int inSampleSize = 1;
        if (rawWidth > dstWidth || rawHeight > dstHeight) {
            float ratioHeight = (float) rawHeight / dstHeight;
            float ratioWidth = (float) rawWidth / dstHeight;
            inSampleSize = (int) Math.min(ratioWidth, ratioHeight);
        }
        return inSampleSize;
    }
}
