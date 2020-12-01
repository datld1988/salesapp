package com.salesapp.customerservice.controller;

import com.salesapp.customerservice.domain.ClIndustry;
import com.salesapp.customerservice.form.DataModelResult;
import com.salesapp.customerservice.form.ResultStatus;
import com.salesapp.customerservice.repository.ClIndustryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;

@RestController
@RequestMapping("/api/clIndustry")
public class ClIndustryController {
    @Autowired
    private EntityManager em;
    @Autowired
    private ClIndustryRepository repository;

    @GetMapping
    public DataModelResult list() {
        DataModelResult model = new DataModelResult();
        try {
            model.setData(em.createNativeQuery("SELECT ID, NAME FROM CL_INDUSTRY ORDER BY DISPLAY_PRIORITY ASC").getResultList());
            model.setResultStatus(ResultStatus.defaultSuccess("success"));
        } catch (Exception e) {
            model.setResultStatus(ResultStatus.defaultFailed(e));
        }
        return model;
    }
    
    @PostMapping
    public DataModelResult create(@RequestBody ClIndustry form) {
        DataModelResult dataModel = new DataModelResult();
        try {
            repository.save(form);
            dataModel.setResultStatus(ResultStatus.defaultSuccess("thêm mới thành công"));
        } catch (Exception e) {
            dataModel.setResultStatus(ResultStatus.defaultFailed(e));
        }
        return dataModel;
    }

    @PutMapping
    public DataModelResult update(@RequestBody ClIndustry form) {
        DataModelResult dataModel = new DataModelResult();
        try {
            ClIndustry dbo = repository.getOne(form.getId());
            BeanUtils.copyProperties(form, dbo, "id, created_date, created_by, modified_date, modified_by");
            repository.save(dbo);
            dataModel.setResultStatus(ResultStatus.defaultSuccess("cập nhật thành công"));
        } catch (Exception e) {
            dataModel.setResultStatus(ResultStatus.defaultFailed(e));
        }
        return dataModel;
    }

    @DeleteMapping
    public DataModelResult delete(@PathVariable String id) {
        DataModelResult dataModel = new DataModelResult();
        try {
            repository.deleteById(id);
            dataModel.setResultStatus(ResultStatus.defaultSuccess("xóa thành công"));
        } catch (Exception e) {
            dataModel.setResultStatus(ResultStatus.defaultFailed(e));
        }
        return dataModel;
    }
}