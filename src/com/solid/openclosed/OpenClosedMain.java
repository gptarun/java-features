package com.solid.openclosed;

/**
 * ************************ READ ME ************************
 * O — Open/Closed Principle
 * classes should be open for extension but closed for modification
 */
public class OpenClosedMain {
    public static void main(String[] args) {
        FileUploadOnCloud fileUploadOnCloud = new FileUploadOnCloud();
        System.out.println(fileUploadOnCloud.uploadOnCloud("AWS", "my.text"));
        System.out.println(fileUploadOnCloud.uploadOnCloud("Azure", "my.text"));
        System.out.println(fileUploadOnCloud.uploadOnCloud("GCP", "my.text"));
    }
}
