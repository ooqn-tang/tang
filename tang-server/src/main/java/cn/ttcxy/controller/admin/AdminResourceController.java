package cn.ttcxy.controller.admin;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.ttcxy.controller.BaseController;
import cn.ttcxy.entity.model.UtsResource;
import cn.ttcxy.entity.param.UtsResourceParam;
import cn.ttcxy.service.UtsResourceService;
import java.util.Date;
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

@RestController
@RequestMapping("api/admin/resource")
public class AdminResourceController extends BaseController {

	@Autowired
	private UtsResourceService resourceService;

	@GetMapping("refresh")
	public void refresh() {
		resourceService.urls();
	}

	@GetMapping
	public List<UtsResource> loadResponseList(
			@RequestParam(value = "queryData", defaultValue = "") String queryData) {
		return resourceService.select(queryData);
	}

	@PostMapping
	public UtsResource insert(@RequestBody UtsResourceParam resourceParam) {
		UtsResource resource = BeanUtil.toBean(resourceParam, UtsResource.class);
		resource.setResourceId(IdUtil.objectId());
		resource.setCreateTime(new Date());
		return resourceService.insert(resource);
	}

	@PutMapping
	public UtsResource update(@RequestBody UtsResourceParam resourceParam) {
		UtsResource resource = BeanUtil.toBean(resourceParam, UtsResource.class);
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
	public List<String> selectIdByRole(@PathVariable("roleId") String roleId) {
		return resourceService.selectByRoleId(roleId);
	}
}
