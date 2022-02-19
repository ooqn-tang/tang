package net.ttcxy.tang.portal.controller;

import net.ttcxy.tang.portal.entity.dto.DtsRecordDto;
import net.ttcxy.tang.portal.service.DtsViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/view")
public class DtsViewController {

    @Autowired
    private DtsViewService viewService;

    @GetMapping
    public ResponseEntity<List<DtsRecordDto>> load(){
        return null;
    }
}
