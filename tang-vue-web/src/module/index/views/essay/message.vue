<template>
	<div class="row">
		<div class="col-md-8 mb-2">
			<div class="mb-2">
				<div class="card ">
					<div class="card-body" style="height: 6.5em;">
						<div class="input-group" style="height: 100%;">
							<textarea v-model="form.text" class="form-control" id="textarea"
								style="height: 100%;"></textarea>
							<button class="btn btn-outline-secondary" type="button" id="button-addon2"
								@click="insertEssay">发送</button>
						</div>
					</div>
				</div>
			</div>
			<div class="mb-2" v-for="(item, index) in essayList" :key="index">
				<div class="card ">
					<div class="card-body">
						<p>{{ item.author.nickname }} <span class="float-end">{{item.createTime}}</span></p>
						<div>{{ item.text }}</div>
						<div class="btn-group  btn-group-sm" role="group" aria-label="Basic outlined example" style="width:100%;">
							<button type="button" class="btn btn-outline-secondary">评论</button>
							<button type="button" class="btn btn-outline-secondary">转发</button>
							<button type="button" class="btn btn-outline-secondary">喜欢</button>
							<button type="button" class="btn btn-outline-secondary">转发</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-4 mb-2">
			<ul class="list-group">
				<li class="list-group-item">An item</li>
				<li class="list-group-item">A second item</li>
				<li class="list-group-item">A third item</li>
				<li class="list-group-item">A fourth item</li>
				<li class="list-group-item">And a fifth one</li>
				<li class="list-group-item">An item</li>
				<li class="list-group-item">A second item</li>
				<li class="list-group-item">A third item</li>
				<li class="list-group-item">A fourth item</li>
				<li class="list-group-item">And a fifth one</li>
				<li class="list-group-item">An item</li>
				<li class="list-group-item">A second item</li>
				<li class="list-group-item">A third item</li>
				<li class="list-group-item">A fourth item</li>
				<li class="list-group-item">And a fifth one</li>
				<li class="list-group-item">An item</li>
				<li class="list-group-item">A second item</li>
			</ul>
		</div>
	</div>
</template>
  
<script setup>
import request from "utils/request";
import { onMounted, ref } from "vue";

let page = ref({
	number: 0
});
let essayList = ref([]);
let form = {
	text: ""
};

function loadEssay() {
	request({
		url: `/api/essay`,
		method: "get",
		params: { page: page.value.number }
	}).then((res) => {
		page.value = res.data;
		essayList.value = essayList.value.concat(res.data.content);
	});
};

function insertEssay() {
	request({
		url: `/api/essay`,
		method: "post",
		data: form
	}).then((res) => {
		form = {};
		essayList.value.unshift(res.data);
	});
};

function next() {
	if (!page.last) {
		page.value.number += 1;
		loadEssay();
	}
};

onMounted(() => {
	loadEssay();
});

</script>
  
<style scoped>
strong p,
.card-body p {
	margin: 0px;
}

.red {
	color: red;
}

.t-nav-link {
	margin: 0 20px;
	line-height: 40px;
	float: left;
}

#textarea {

	resize: none;

}</style>