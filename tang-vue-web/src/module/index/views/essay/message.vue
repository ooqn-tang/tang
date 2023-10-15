<template>
	<div class="row">
		<div class="col-md-4 mb-2">
			<div class="card move-b-lr-0">
				<div class="card-body"  style="height: 6.5em; ">
					<div class="input-group"  style="height: 100%;">
						<textarea v-model="form.text" class="form-control" id="exampleFormControlTextarea1" style="height: 100%;"></textarea>
						<button class="btn btn-outline-secondary" type="button" id="button-addon2" @click="insertEssay">发送</button>
					</div>
					
				</div>
			</div>
		</div>
		<div class="col-md-4 mb-2" v-for="(item, index) in essayList" :key="index">
			<div class="card move-b-lr-0">
				<div class="card-body" style="height: 6.5em; ">
					<p>{{ item.author.nickname }} <span class="float-end">评:1</span></p>
					<div style="width: 300px; display:-webkit-box; overflow: hidden;  text-overflow: ellipsis; -webkit-box-orient:vertical; -webkit-line-clamp:2;">{{ item.text }}</div>
				</div>
			</div>
		</div>
	</div>
	
</template>
  
<script setup>
import request from "utils/request";
import { onMounted,ref } from "vue";

let page = ref({
	number: 0
});
let essayList = ref([]);
let form = {
	text: ""
};

function loadEssay(){
	request({
		url: `/api/essay`,
		method: "get",
		params: { page: page.value.number }
	}).then((res) => {
		page.value = res.data;
		essayList.value = essayList.value.concat(res.data.content);
	});
};

function insertEssay(){
	request({
		url: `/api/essay`,
		method: "post",
		data: form
	}).then((res) => {
		form = {};
		essayList.value.unshift(res.data);
	});
};	

function next(){
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
/* 第二个list-group-item开始背景色交替 */
.list-group-item:nth-child(2n+1) {
	background-color: #f8f9fa;
}
</style>