package com.v1.project.service;

import com.v1.project.dao.StatusDAO;
import com.v1.project.model.Status;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    public List<Status> findAll() {
        return StatusDAO.findAll();
    }

    public boolean save(Status status) {
        return StatusDAO.save(status);
    }

    public Status findById(Long id) {
        return StatusDAO.findById(id);
    }

    public boolean update(Status status) {
        return StatusDAO.update(status);
    }

    public boolean delete(Long id) {
        return StatusDAO.delete(id);
    }

}
