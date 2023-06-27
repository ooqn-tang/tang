<template>
	<div class="card-body article-list p-0">
		<ul class="list-group">
			<li class="list-group-item">
				<div class="input-group">
					<input v-model="form.text" type="text" class="form-control" placeholder="Recipient's username"
						aria-label="Recipient's username" aria-describedby="button-addon2">
					<button class="btn btn-outline-secondary" type="button" id="button-addon2" @click="insertEssay">发送</button>
				</div>
			</li>
			<li class="list-group-item" v-for="(item, index) in essayList" :key="index">
				<p>
					<router-link :to="{name:'author_article',params:{username : item.author.username}}">{{item.author.nickname}}</router-link>
					<span class="float-end">{{item.essay.createTime}}</span>
				</p>
				{{item.essay.text}}
			</li>
			<li class="list-group-item">
				<a @click="next()">获取</a>
			</li>
			
		</ul>

	</div>
</template>
  
<script setup>
import request from "utils/request";
import { onMounted,ref } from "vue";
import { useRouter, useRoute } from "vue-router";
import { useStore } from "vuex";

let router = useRouter();
let route = useRoute();
let store = useStore();

let page = ref({
	number: 0
});
let essayList = ref([]);
let form = {
	text: ""
};

let loadEssay = () => {
	request({
		url: `/api/essay`,
		method: "get",
		params: { page: page.value.number }
	}).then((response) => {
		page.value = response.data;
		essayList.value = essayList.value.concat(response.data.content);
	});
};

let insertEssay = () => {
	request({
		url: `/api/essay`,
		method: "post",
		data: form
	}).then((response) => {
		form = {};
		essayList.unshift(response.data);
	});
};	

let next = () => {
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
</style>