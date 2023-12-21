package com.stackroute.contentmanagementservice.services;

import java.util.List;
import java.util.Optional;

import com.stackroute.contentmanagementservice.model.Course;
import com.stackroute.contentmanagementservice.repositories.CourseRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.contentmanagementservice.model.ReferenceMaterial;
import com.stackroute.contentmanagementservice.repositories.ReferenceMaterialRepository;

@Service
public class ReferenceMaterialService {

    private final ReferenceMaterialRepository referenceMaterialRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public ReferenceMaterialService(ReferenceMaterialRepository referenceMaterialRepository, CourseRepository courseRepository) {
        this.referenceMaterialRepository = referenceMaterialRepository;
        this.courseRepository=courseRepository;
    }

    public List<ReferenceMaterial> getAllReferenceMaterials() {
        return referenceMaterialRepository.findAll();
    }

    public Optional<ReferenceMaterial> getReferenceMaterialById(int id) {
        return referenceMaterialRepository.findById(id);
    }

    public List<ReferenceMaterial> getReferenceMaterialsByCourseId(int courseId) {
        return referenceMaterialRepository.findByCourseId(courseId);
    }

    public ReferenceMaterial createReferenceMaterial(int courseId, ReferenceMaterial referenceMaterial) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(()->new ResourceNotFoundException("Course not found with id "+courseId));
        referenceMaterial.setCourseId(courseId);
        return referenceMaterialRepository.save(referenceMaterial);
    }

    public ReferenceMaterial updateReferenceMaterial(int id, ReferenceMaterial referenceMaterialDetails) {
        ReferenceMaterial referenceMaterial = referenceMaterialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reference Material not found with id " + id));

        referenceMaterial.setCourseId(referenceMaterialDetails.getCourseId());
        referenceMaterial.setTitle(referenceMaterialDetails.getTitle());
        referenceMaterial.setContent(referenceMaterialDetails.getContent());
        referenceMaterial.setReflinks(referenceMaterial.getReflinks());

        return referenceMaterialRepository.save(referenceMaterial);
    }

    public void deleteReferenceMaterial(int id) {
        ReferenceMaterial referenceMaterial = referenceMaterialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reference Material not found with id " + id));

        referenceMaterialRepository.delete(referenceMaterial);
    }
}
