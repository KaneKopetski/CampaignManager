package com.rollforinitiative.campaignmgr.service;

import com.rollforinitiative.campaignmgr.exception.FileStorageException;
import com.rollforinitiative.campaignmgr.model.Image;
import com.rollforinitiative.campaignmgr.repository.ImageRepository;
import com.sun.org.apache.xpath.internal.operations.Mult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@Service
public class ImageService {

    @Autowired
    ImageRepository imageRepository;

    public Image getImageById(String imageId) {
        return imageRepository.getOne(imageId);
    }

    public Image storeImage(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            if(fileName.contains("..")) {
                throw new FileStorageException("Filename contains invalid path sequence " + fileName);
            }
            Image image = new Image(fileName, file.getContentType(), file.getBytes());

            return imageRepository.save(image);

        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public Image updateImage(Image imageToReplace, MultipartFile replacementFile) {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(replacementFile.getOriginalFilename()));

        try {
            if(fileName.contains("..")) {
                throw new FileStorageException("Filename contains invalid path sequence " + fileName);
            }
            imageToReplace.setFileName(fileName);
            imageToReplace.setFileType(replacementFile.getContentType());
            imageToReplace.setData(replacementFile.getBytes());

            return imageRepository.save(imageToReplace);

        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }

    }


}
