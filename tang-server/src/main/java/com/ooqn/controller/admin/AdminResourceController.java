package com.ooqn.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ooqn.core.control.BaseController;
import com.ooqn.entity.model.UtsResource;
import com.ooqn.service.UtsResourceService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/admin/resource")
@Tag(name = "资源管理")
public class AdminResourceController extends BaseController {

	@Autowired
	private UtsResourceService resourceService;

	@GetMapping("refresh")
	public void refresh() {
		resourceService.urls();
	}

	@GetMapping
	public List<UtsResource> loadResponseList(@RequestParam(value = "queryData", defaultValue = "") String queryData) {
		return resourceService.select(queryData);
	}

	@PostMapping
	public UtsResource insert(@RequestBody UtsResource resource) {
		return resourceService.insert(resource);
	}

	@PutMapping
	public UtsResource update(@RequestBody UtsResource resource) {
		return resourceService.update(resource);
	}

	@GetMapping("{resourceId}")
	public UtsResource select(@PathVariable("resourceId") String resourceId) {
		return resourceService.selectById(resourceId);
	}

	@DeleteMapping("{resourceId}")
	public void delete(@PathVariable("resourceId") String resourceId) {
		resourceService.delete(resourceId);
	}

	@GetMapping("role/{roleId}")
	public List<UtsResource> selectIdByRole(@PathVariable("roleId") String roleId) {
		return resourceService.selectByRoleId(roleId);
	}
}
