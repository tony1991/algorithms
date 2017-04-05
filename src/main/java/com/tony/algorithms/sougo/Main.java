package com.tony.algorithms.sougo;

import java.awt.geom.Point2D;
import java.util.Scanner;

public class Main {
    /*
    3
    1.0 1.0002
    3.03 3.023
    0.0 -0.001
    */
    static int[] getClosest(Point2D.Double[] points) {
        int[] result = new int[2];
        /* 在这里补充代码, 注意，要求result[0] < result[1] */
        /* distance = points[0].distance(points[1]) */
        result[0] = 0;
        result[1] = 1;
        double minDistance = 0,distance = 0;
        if (points.length >= 2)  {
            minDistance = points[0].distance(points[1]);
            for(int i=0;i<points.length-1;i++){
                for(int j=i+1;j<points.length;j++){
                    distance = points[i].distance(points[j]);
                    if(distance!=0 && distance<minDistance){
                        minDistance = distance;
                        result[0] = i;
                        result[1] = j;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Point2D.Double[] points;
        Scanner input = new Scanner(System.in);
        {
            int n = input.nextInt();
            input.nextLine();
            points = new Point2D.Double[n];
            for (int i = 0; i < n; ++i) {
                double x = input.nextDouble();
                double y = input.nextDouble();
                input.nextLine();
                points[i] = new Point2D.Double(x, y);
            }
        }
        int[] result = getClosest(points);
        System.out.printf("Closest points: %d, %d\n", result[0], result[1]);
    }
}
