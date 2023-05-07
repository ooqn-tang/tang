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
					<router-link :to="{name:'author_article',params:{username : item.username}}">{{item.nickname}}
					</router-link>
					<span class="float-end">{{item.createTime}}</span>
				</p>
				{{item.text}}
			</li>
			<li class="list-group-item" v-if="essayList.length != 0">
				<a @click="next()">获取</a>
			</li>
			<li class="list-group-item" v-if="essayList.length == 0">
				加载中...
			</li>
		</ul>

	</div>
</template>
  
<script setup>
import request from "utils/request";
import { onMounted } from "vue";
import { useRouter, useRoute } from "vue-router";
import { useStore } from "vuex";

let router = useRouter();
let route = useRoute();
let store = useStore();

let page = {
	number: 0
};
let essayList = [];
let form = {
	text: ""
};

let loadEssay = () => {
	request({
		url: `/api/essay`,
		method: "get",
		params: { page: page.number }
	}).then((response) => {
		page = response.data;
		essayList = essayList.concat(response.data.content);
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
		page.number += 1;
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