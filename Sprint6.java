package Sprintt6;

import java.util.Scanner;

public class Sprint6 {

	public static final double ACCELERATION = -9.81; 
    public static void main(String[] args) { 
        Scanner console = new Scanner(System.in); 
        giveIntro(); 
        System.out.print("velocity (meters/second)? "); 
        double velocity = console.nextDouble(); 
        System.out.print("angle (degrees)? "); 
        double angle = Math.toRadians(console.nextDouble()); 
        System.out.print("number of steps to display? "); 
        int steps = console.nextInt(); 
        System.out.println("accuracy of x,y,time (number digits ather decimal point?):"); 
        int points = console.nextInt(); 
        System.out.println();  
        printTable(velocity, angle, steps, points); 
    } 
    public static void printTable(double velocity, double angle, int steps, int points) 
    { 
        double xVelocity = velocity * Math.cos(angle); 
        double yVelocity = velocity * Math.sin(angle); 
        double totalTime = -2.0 * yVelocity / ACCELERATION; 
        double timeIncrement = totalTime / steps; 
        double xIncrement = xVelocity * timeIncrement; 
 
        double x = 0.0; 
        double y = 0.0; 
        double t = 0.0; 
        double maxY = 0.0; 
        double maxTimeY = 0.0; 
        System.out.println("step\tx\ty\ttime"); 
        System.out.println("0\t0.0\t0.0\t0.0"); 
        for (int i = 1; i <= steps; i++) { 
            t += timeIncrement; 
            x += xIncrement; 
            y = displacement(yVelocity, t, ACCELERATION); 
            maxY = Math.max(maxY, y); 
            maxTimeY = Math.max(maxTimeY, y); 
            System.out.println(i + "\t" + round(x, points) + "\t" + round(y, points) + "\t" + round(t, points)); 
        } 
        System.out.println("Maximum height: " + round(maxY, points) + "\n" + "Time: " + maxTimeY); 
    } 
    public static void giveIntro() { 
        System.out.println("This program computes the"); 
        System.out.println("trajectory of a projectile given"); 
        System.out.println("its initial velocity and its"); 
        System.out.println("angle relative to the"); 
        System.out.println("horizontal."); 
        System.out.println(); 
    } 
    public static double displacement(double v, double t, double a) { 
        return v * t + 0.5 * a * t * t; 
    } 
    public static double round(double n, int points) { 
        double multiplier = Math.pow(10, points); 
        return Math.round(n * multiplier) / multiplier; 
    } 
}

