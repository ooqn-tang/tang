<template>
  <div class="head">
      <input type="text" id="title" placeholder="标题">
      <input type="button" id="save" value="发布" data-toggle="modal" data-target="#myModal">
  </div>
  <div class="body">
      <textarea id="text" v-model="markdown" @keyup="keyup()" @change="keyup()" placeholder="可以输入Markdown文本为内容添加样式"></textarea>
      <div id="content" v-html="blogHtml" class="markdown-body"></div>
  </div>
  <div class="foot">
      <span>文本块</span>
      <span style="float: right;">帮助</span>
  </div>

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">发布</h4>
            </div>
            <div class="modal-body">
                <label for="name">标签：</label>
                <div class="checkbox">
                    <label v-for="(item,index) in tagList" :key="index" style="margin-right: 20px;">
                        <input type="checkbox" v-model="item.value">{{item.name}}
                    </label>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">草稿</button>
                <button type="button" class="btn btn-primary">发布</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

</template>

<script>
import 'https://cdn.bootcdn.net/ajax/libs/marked/1.2.7/marked.min.js'
marked.setOptions({
renderer: new marked.Renderer(),
gfm: true,
tables: true,
breaks: true,
pedantic: false,
smartLists: true,
sanitize:true,
smartypants: false
});


export default {
  name: "editor",
  data() {
    return {
      markdown:"",
      blogHtml:'',
      tagList:[
          {name:"java",value:"java"},
          {name:"python",value:"java"},
          {name:"认识",value:"java"},
          {name:"中国",value:"java"},
           {name:"java",value:"java"},
          {name:"python",value:"java"},
          {name:"认识",value:"java"},
          {name:"中国",value:"java"}
      ],
      classList:[
          {name:"java",value:"java"},
          {name:"python",value:"java"},
          {name:"认识",value:"java"},
          {name:"中国",value:"java"},
           {name:"java",value:"java"},
          {name:"python",value:"java"},
          {name:"认识",value:"java"},
          {name:"中国",value:"java"}]
    };
  },
  methods: {
      keyup(){
        this.blogHtml = marked(this.markdown)
      }
  },mounted(){
       
  },
  created(){
      
  }
};
</script>
<style scoped lang="scss">
img{
    max-width: 100%;
}
.head{
    height: 40px;
}
.body{
    height:-webkit-calc(100% - 80px);
    height:-moz-calc(100% - 80px);
    height:calc(100% - 80px);
    border-bottom: 1px solid black;
    border-top: 1px solid black;
    overflow: auto;
}
.foot{
    height: 40px;
    background: #f4f4f4;
    line-height: 40px;
    padding:0 10px;
    color: rgb(45, 89, 184);
    font-weight:bold
}
#save{
    border-left: 1px #b5adad solid;
    outline: none;
    width: 90px;
    float: right;
    height: 100%;
    background: #337ab7;
    border-radius: 0;
    color: #fff;
}
#title{
    background: #f4f4f4;
    padding-left: 10px;
    padding-right: 10px;
    font-size: 24px;
    line-height: 30px;
    width: -webkit-calc(100% - 90px);
    width: -moz-calc(100% - 90px);
    width: calc(100% - 90px);
    height: 100%;
    outline: none;
}
#content{
    width: 50%;
    height: 100%;
    float: left;
    background: #fff8eb;
    padding: 10px;
    font-size: 18px;
    overflow-y: auto;
}
#text{
    width: 50%;
    height: 100%;
    float:left;
    border-right: 1px solid black;
    background-color: #e2e3e4;
    padding: 10px;
    font-size: 18px;
    overflow-y: auto;
}
@media screen and (max-width: 700px) {
    #text {
        width: 100% !important;
        border-right: 0 !important;
    }
    #content{
        display: none;
    }
}
</style>