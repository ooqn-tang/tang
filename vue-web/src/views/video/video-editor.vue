<template>
  <div class="row">
    <div class="col-lg-8">
      <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">标题</label>
        <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com">
      </div>
      <div class="mb-3">
        <label for="exampleFormControlTextarea1" class="form-label">描述</label>
        <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
      </div>
      <div class="mb-3">
        <label for="formFileMultiple" class="form-label">视频</label>
        <input class="form-control" type="file" id="formFileMultiple" @change="upfile($event)" ref="inputer">
      </div>

      <div class="mb-3">
        <label for="formFileMultiple" class="form-label">标签</label>
        <br>
        <div class="form-check form-check-inline" v-for="(item,index) in videoTagList" :key="index">
          <input class="form-check-input" type="checkbox" :id="index" value="option1">
          <label class="form-check-label" :for="index">asdfasdf</label>
        </div>
      </div>

      <div class="mb-3">
        <label for="formFileMultiple" class="form-label">专辑</label>
        <select class="form-select" aria-label="Default select example">
          <option selected>Open this select menu</option>
          <option value="1">One</option>
          <option value="2">Two</option>
          <option value="3">Three</option>
        </select>
      </div>

      <div class="mb-3">
        <button type="submit" class="btn btn-primary">Submit</button>
      </div>
    </div>

    
    <div class="col-lg-4">
    </div>
  </div>
</template>

<script>
import { upload } from "/@/api/file"
export default {
  name: "search_index",
  data() {
    return {
      videoTagList:[{},{},{},{},{},{},{},{},{},{}]
    };
  },
  computed: {
    
  },
  created() {
  },
  methods: {
   upfile(e){
    let file = e.target.files[0]
    let param = new FormData(); //创建form对象
    param.append('file',file);
    let up = upload(param)
    up.then(response => {
      alert(response.data)
    })
   }
  },
  mounted(){
    
  }
};
</script>