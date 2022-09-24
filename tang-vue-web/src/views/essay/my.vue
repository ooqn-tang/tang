<template>
    <div class="card-body article-list p-0">
        my
    </div>
</template>
  
<script>
import request from "utils/request";
export default {
    name: "essay_my",
    data() {
        return {
            essayList: []
        };
    },
    created() { },
    methods: {
        
    },
    mounted() {
       
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