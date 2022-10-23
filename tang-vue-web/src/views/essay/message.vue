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
  
<script>
import request from "utils/request";
export default {
	name: "essay_message",
	data() {
		return {
			page: {
				number: 0
			},
			form: {

			},
			essayList: []
		};
	},
	created() { },
	methods: {
		loadEssay() {
			request({
				url: "/api/essay",
				method: "get",
				params: { page: this.page.number }
			}).then((response) => {
				this.page = response.data
				this.essayList = this.essayList.concat(response.data.content)
			});
		},
		insertEssay() {
			request({
				url: "/api/essay",
				method: "post",
				data: this.form
			}).then((response) => {
				this.form = {}
				this.essayList.unshift(response.data)
			});
		},
		next() {
			if (!this.page.last) {
				this.page.number += 1
				this.loadEssay()
			}
		}
	},
	created() {
		this.loadEssay()
	},
};
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