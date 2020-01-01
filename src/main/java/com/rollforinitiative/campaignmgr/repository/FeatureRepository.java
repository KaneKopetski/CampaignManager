package com.rollforinitiative.campaignmgr.repository;

import com.rollforinitiative.campaignmgr.model.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository extends JpaRepository<Feature, Long> {
}
