package com.solid.openclosed;

/**
 * ************************ READ ME ************************
 * Here, this class is failing this principle as it requires lots of changes to accomplish upload
 * on GCP or any other cloud services.
 * Instead of handling upload in single class, create UploadServices for each Cloud service
 */
public class FileUploadOnCloud {
    public String uploadOnCloud(String cloudServiceName, String fileName) {
        if (cloudServiceName.equalsIgnoreCase("AWS")) {
            // fetch AWS configurations
            // Read file
            // s3.upload(file)
            return fileName + " uploaded successfully on S3 Bucket";
        } else if (cloudServiceName.equalsIgnoreCase("Azure")) {
            // fetch Azure configurations
            // Read file
            // azure.upload(file)
            return fileName + " uploaded successfully on Azure";
        } else {
            return "Invalid cloud service";
        }
    }
}
