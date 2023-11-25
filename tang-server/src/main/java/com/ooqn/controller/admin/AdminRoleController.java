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
import org.springframework.web.bind.annotation.RestController;

import com.ooqn.core.control.BaseController;
import com.ooqn.core.control.ResponseCode;
import com.ooqn.entity.model.UtsResource;
import com.ooqn.entity.model.UtsRole;
import com.ooqn.service.UtsAuthorService;
import com.ooqn.service.UtsResourceService;
import com.ooqn.service.UtsRoleService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/admin/role")
@Tag(name = "角色管理")
public class AdminRoleController extends BaseController {

	@Autowired
	private UtsRoleService roleService;

	@Autowired
	private UtsAuthorService authorService;

	@Autowired
	private UtsResourceService resourceService;

	@GetMapping
	public Iterable<UtsRole> select() {
		return roleService.select();
	}

	@PostMapping
	public UtsRole insert(@RequestBody UtsRole role) {
		return roleService.insert(role);
	}

	@PutMapping
	public void update(@RequestBody UtsRole role) {
		roleService.update(role);
	}

	@GetMapping("{roleId}")
	public UtsRole select(@PathVariable("roleId") String roleId) {
		return roleService.selectById(roleId);
	}

	@DeleteMapping("{roleId}")
	public void delete(@PathVariable("roleId") String roleId) {
		roleService.delete(roleId);
	}

	@PostMapping("resource/{roleId}")
	public String insertResource(@PathVariable("roleId") String roleId, @RequestBody List<UtsResource> resourceList) {
		roleService.insertResource(roleId, resourceList);
		return ResponseCode.SUCCESS.getMessage();
	}

	@GetMapping("resource/{roleId}")
	public List<UtsResource> selectResourceByRoleId(@PathVariable("roleId") String roleId) {
		return resourceService.selectByRoleId(roleId);
	}

	@GetMapping("author/{authorId}")
	public List<UtsRole> selectRoleListByAuthorId(@PathVariable("authorId") String authorId) {
		return roleService.selectRolesByAuthorId(authorId);
	}

	@PutMapping("author/{authorId}")
	public String updateAuthorRole(@PathVariable("authorId") String authorId, @RequestBody List<String> roleIds) {
		authorService.updateAuthorRole(authorId, roleIds);
		return ResponseCode.SUCCESS.getMessage();
	}
}
