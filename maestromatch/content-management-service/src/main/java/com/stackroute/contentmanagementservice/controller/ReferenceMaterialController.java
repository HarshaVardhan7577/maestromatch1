package com.stackroute.contentmanagementservice.controller;

import com.stackroute.contentmanagementservice.model.Course;
import com.stackroute.contentmanagementservice.model.DbSequence;
import com.stackroute.contentmanagementservice.services.SequenceGeneratorService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.stackroute.contentmanagementservice.model.ReferenceMaterial;
import com.stackroute.contentmanagementservice.services.ReferenceMaterialService;

import java.util.List;

@RestController
@RequestMapping("/content/reference-materials")
@CrossOrigin(origins = "http://localhost:4200")
public class ReferenceMaterialController {
    private final ReferenceMaterialService referenceMaterialService;
    @Autowired
    private SequenceGeneratorService service;
    @Autowired
    public ReferenceMaterialController(ReferenceMaterialService referenceMaterialService) {
        this.referenceMaterialService = referenceMaterialService;
    }

    @GetMapping
    public List<ReferenceMaterial> getAllReferenceMaterials() {
        return referenceMaterialService.getAllReferenceMaterials();
    }

    @GetMapping("/{id}")
    public ReferenceMaterial getReferenceMaterialById(@PathVariable int id) {
        return referenceMaterialService.getReferenceMaterialById(id).orElseThrow(() -> new ResourceNotFoundException("Reference Material not found with id " + id));
    }

    @GetMapping("/course/{courseId}")
    public List<ReferenceMaterial> getReferenceMaterialsByCourseId(@PathVariable int courseId) {
        return referenceMaterialService.getReferenceMaterialsByCourseId(courseId);
    }

    @PostMapping("/course/{courseId}")
    public ReferenceMaterial createReferenceMaterial(@PathVariable int courseId,@RequestBody ReferenceMaterial referenceMaterial) {
        referenceMaterial.setId(service.getSequenceNumber(ReferenceMaterial.SEQUENCE_NAME));

        return referenceMaterialService.createReferenceMaterial(courseId,referenceMaterial);
    }

    @PutMapping("/{id}")
    public ReferenceMaterial updateReferenceMaterial(@PathVariable int id, @RequestBody ReferenceMaterial referenceMaterialDetails) {
        return referenceMaterialService.updateReferenceMaterial(id, referenceMaterialDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteReferenceMaterial(@PathVariable int id) {
        referenceMaterialService.deleteReferenceMaterial(id);
    }
    
}

