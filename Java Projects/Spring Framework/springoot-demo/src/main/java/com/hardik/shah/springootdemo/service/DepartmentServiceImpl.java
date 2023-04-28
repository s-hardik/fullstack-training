package com.hardik.shah.springootdemo.service;

import com.hardik.shah.springootdemo.entity.Department;
import com.hardik.shah.springootdemo.error.DepartmentNotFoundException;
import com.hardik.shah.springootdemo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartementService{
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
       return departmentRepository.insert(department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentsById(Long departmentId) throws DepartmentNotFoundException {
     Optional<Department> department = departmentRepository.findById(departmentId);
     if(!department.isPresent()){
         throw new DepartmentNotFoundException("no department");
     }
     return department.get();
    }

    @Override
    public void  deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department department) {
       Department departmentFromDb = departmentRepository.findById(departmentId).get();

       if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
           departmentFromDb.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            departmentFromDb.setDepartmentCode(department.getDepartmentCode());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            departmentFromDb.setDepartmentAddress(department.getDepartmentAddress());
        }
        return departmentRepository.save(departmentFromDb);
    }

    @Override
    public Department getDepatementsByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
