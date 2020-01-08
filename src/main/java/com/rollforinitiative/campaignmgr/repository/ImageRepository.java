package com.rollforinitiative.campaignmgr.repository;

import com.rollforinitiative.campaignmgr.model.Image;
        import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, String> {
}
