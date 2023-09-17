package com.ps.open_cv_andorid;


import android.graphics.Bitmap;

import org.opencv.android.Utils;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfDouble;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

public class CVWrapper {


    public static double calculateVarianceOfLaplacianImage(Bitmap imageBitmap) {
        Mat imageMat = new Mat();
        Utils.bitmapToMat(imageBitmap, imageMat);
        Mat grayImage = new Mat();
        Imgproc.cvtColor(imageMat, grayImage, Imgproc.COLOR_BGR2GRAY);

        Mat laplacianImage = new Mat();
        Imgproc.Laplacian(grayImage, laplacianImage, CvType.CV_64F);

        MatOfDouble mean = new MatOfDouble();
        MatOfDouble stddev = new MatOfDouble();
        Core.meanStdDev(laplacianImage, mean, stddev);

        double variance = Math.pow(stddev.get(0, 0)[0], 2);
        return variance;
    }

    public static double calculateVarianceOfGrayImage(Bitmap imageBitmap) {
        Mat imageMat = new Mat();
        Utils.bitmapToMat(imageBitmap, imageMat);
        Mat grayImage = new Mat();
        Imgproc.cvtColor(imageMat, grayImage, Imgproc.COLOR_BGR2GRAY);

        MatOfDouble mean = new MatOfDouble();
        MatOfDouble stddev = new MatOfDouble();
        Core.meanStdDev(grayImage, mean, stddev);

        double variance = Math.pow(stddev.get(0, 0)[0], 2);
        return variance;
    }

    public static double calculateBrightness(Bitmap imageBitmap) {
        Mat imageMat = new Mat();
        Utils.bitmapToMat(imageBitmap, imageMat);

        Scalar mean = Core.mean(imageMat);
        double brightness = (mean.val[0] + mean.val[1] + mean.val[2]) / 3.0;
        return brightness;
    }
}
