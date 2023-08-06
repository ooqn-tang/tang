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

import com.ooqn.core.BaseController;
import com.ooqn.entity.model.UtsAuthor;
import com.ooqn.service.UtsAuthorService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/admin/author")
@Tag(name = "作者管理")
public class AdminAuthorController extends BaseController {

	@Autowired
	private UtsAuthorService authorService;

	@GetMapping
	public List<UtsAuthor> select(@RequestParam(value = "queryData", defaultValue = "") String queryData) {
		return authorService.select(queryData);
	}

	@PostMapping
	public UtsAuthor insert(@RequestBody UtsAuthor author) {
		return authorService.insertAuthor(author);
	}

	@PutMapping
	public void update(@RequestBody UtsAuthor author) {
		authorService.update(author);
	}

	@DeleteMapping("{authorId}")
	public void delete(@PathVariable("authorId") String authorId) {
		authorService.delete(authorId);
	}
}
