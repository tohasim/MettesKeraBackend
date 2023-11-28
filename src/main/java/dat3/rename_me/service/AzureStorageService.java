package dat3.rename_me.service;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class AzureStorageService {

    private final BlobServiceClient blobServiceClient;
    private final String containerName;

    //Constructor injection for dependencies
    public AzureStorageService(BlobServiceClient blobServiceClient,
                               @Value("${azure.storage.container-name}") String containerName) {
        this.blobServiceClient = blobServiceClient;
        this.containerName = containerName;
    }


    public String uploadFile(MultipartFile file, String directory) {
        try {
            BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(containerName);
            // Generate a unique file name
            String filename = generateUniqueFileName(file.getOriginalFilename());
            String blobName = directory + "/" + filename;

            BlobClient blobClient = containerClient.getBlobClient(blobName);
            blobClient.upload(file.getInputStream(), file.getSize(), true);

            return blobClient.getBlobUrl();
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload file to Azure Blob Storage", e);
        }
    }

    private String generateUniqueFileName(String originalFilename) {
        // You can implement a more robust method to generate a unique file name
        return System.currentTimeMillis() + "_" + URLEncoder.encode(originalFilename, StandardCharsets.UTF_8);
    }
}
