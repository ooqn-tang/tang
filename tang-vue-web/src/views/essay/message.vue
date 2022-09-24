<template>
    <div class="card-body article-list p-0">
        <ul class="list-group">
            <li class="list-group-item" v-for="(item, index) in essayList" :key="index">
                <p>
                    <router-link :to="{name:'author_article',params:{username : item.username}}">{{item.nickname}}
                    </router-link>
                    <span class="float-end">{{item.createTime}}</span>
                </p>
                {{item.text}}
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
            essayList: []
        };
    },
    created() { },
    methods: {
        clickSelect(text) {
            this.select = text;
        },
        loadEssay() {
            request({
                url: "/api/essay",
                method: "get",
                params: { type: 'essay' }
            }).then((response) => {
                this.essayList = response.data.list
            });
        },
        insertEssay() {
            request({
                url: "/api/essay",
                method: "post",
                data: this.essay
            }).then((response) => {
                this.$refs.close.click();
                this.essayList.unshift(response.data)
                this.essay = {}
            });
        }
    },
    mounted() {
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