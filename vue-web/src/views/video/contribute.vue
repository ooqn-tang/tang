<template>
  <div class="row">
    <div class="col-md-8 pb-5">
        <div class="mb-3">
            <label for="inputPassword" class="col-sm-2 col-form-label">视频标题</label>
            <input class="form-control" id="inputPassword" v-model="formData.title">
        </div>
        <div class="mb-3">
            <label for="inputPassword" class="col-sm-2 col-form-label">描述</label>
            <input class="form-control" id="inputPassword" v-model="formData.describe">
        </div>
        <div class="mb-3">
          <label for="inputPassword" class="col-sm-2 col-form-label">分类</label>
           <select class="form-select" aria-label="Default select example" v-model="formData.classId">
            <option v-for="(item,index) in videoClassList" :key="index" :value="item.classId">{{item.className}}</option>
          </select>
        </div>
        
         <div class="mb-3">
            <label for="formFileDisabled" class="form-label">封面</label>
            <div class="form-control"  v-if="formData.coverUrl">
              <img :src="formData.coverUrl" class=" img-thumbnail" style="height: 150px;" alt="..." onclick="document.getElementById('imageInput').click()">
            </div>
            <div class="mb-3" v-if="!formData.coverUrl">
              <button class="btn btn-primary" style="width:100%" type="button" onclick="document.getElementById('imageInput').click()">上传封面</button>
            </div>
        </div>
        <input type="file" style="display: none;    " id="imageInput" @change="uploadImage">
        <div class="mb-3">
            <label for="formFileDisabled" class="form-label">文件</label>
            <input class="form-control" type="file" id="formFileDisabled" @change="upload">
        </div>
        <button type="submit" class="btn btn-primary" @click="save">投稿</button>
    </div>
  </div>
</template>

<script>
import "highlight.js/styles/github.css";
import request from "utils/request";
export default {
  name: "video_contribute",
  data() {
    return {
      fans: 2,
      loginUsername: this.$store.state.username,
      videoId: this.$route.params.id,
      loading: true,
      recommendList: null,
      commentList: [],
      article: {},
      commentText: "",
      subject: [],
      articleList: [],
      showSubject: false,
      like: 0,
      videoClassList:[],
      formData:{
        coverUrl:""
      }
    };
  },
  components: {},
  methods: {
    uploadImage(e){
      let file = e.target.files[0];
      let param = new FormData(); //创建form对象
      param.append("file", file); //通过append向form对象添加数据
      param.append("type","1")
      console.log(param.get("file")); //FormData私有类对象，访问不到，可以通过get判断值是否传进去
      request({
        url: "/api/file/upload",
        method: "post",
        data:param,
        headers: { "Content-Type": "multipart/form-data" }
      }).then((response) => {
        this.formData.coverUrl = import.meta.env.VITE_BASE_API + "api/file/" + response.data
      }).catch((error) => {
        alert(error.data)
      });
    },
    upload(e) {
      let file = e.target.files[0];
      let param = new FormData(); //创建form对象
      param.append("file", file); //通过append向form对象添加数据
      param.append("type","2")
      console.log(param.get("file")); //FormData私有类对象，访问不到，可以通过get判断值是否传进去
      request({
        url: "/api/file/upload",
        method: "post",
        data:param,
        headers: { "Content-Type": "multipart/form-data" }
      }).then((response) => {
        this.formData.videoUrl = import.meta.env.VITE_BASE_API + "api/file/" + response.data
      });
    },
    save(){
      request({
        url: "/api/video",
        method: "put",
        data:this.formData
      }).then((response) => {
        this.formData.videoUrl = import.meta.env.VITE_BASE_API + "api/file/" + response.data
        this.$router.push("/video/"+this.videoId)
      });
    },
    loadVideoClassList(){
      request({
        url: "/api/class",
        method: "get",
        params: {"type":"video"}
      }).then((response) => {
        this.videoClassList = response.data
      });
    },
    fansClick(username) {
     
    },
    isFans() {
      
    },
    likeClick() {
     
    },
    isLike() {
     
    },
    loadArticleInfo() {
      
    },
    selectSubjectArticleList() {
      
    },
    loadRecommend() {
      
    },
    load() {
      request({
        url: "/api/video/"+this.$route.params.id+"/author",
        method: "get"
      }).then((response) => {
        this.formData = response.data
      });
    },
  },
  mounted() {
    this.load();
    this.loadRecommend();
    this.loadVideoClassList();
  },
  watch: {
    $route: "load",
  },
};
</script>

<style scoped lang="scss">
</style>