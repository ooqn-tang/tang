<template>
  <input style="height: 40px;width: calc(100% - 100px); border: 2px solid #eee;border-bottom: 0;padding: 0 10px;" placeholder="请输入文章标题（1 ~ 100字）" maxlength="100"/>
  <button style="width:50px;float: right;border: 2px solid #eee;height: 40px;">发布</button>
  <button style="width:50px;float: right;border: 2px solid #eee;height: 40px">草稿</button>
  <editor id='tinymce' v-model='tinymceHtml' :init='init' style="height:100%"></editor>
</template>

<script>
import tinymce from 'tinymce/tinymce'
import Editor from '@tinymce/tinymce-vue'
import 'tinymce/icons/default/icons'
import 'tinymce/models/dom'
import 'tinymce/themes/silver/theme'
import 'tinymce/plugins/image'
import 'tinymce/plugins/link'
import 'tinymce/plugins/code'
import 'tinymce/plugins/table'
import 'tinymce/plugins/lists'
import 'tinymce/plugins/wordcount'  
export default {
  name: "article-editor-h5",
  data() {
    return {
      tinymceHtml: '',
        init: {
          menubar:false,
          language_url: '/public/zh.js',
          language: 'zh_CN',
          skin_url: '/public/tinymce/skins/ui/oxide',
          content_css: '/public/tinymce/skins/content/default/content.css',
          height: "calc(100% - 40px)",
          plugins: 'image code table codesample ',
          toolbar: 'undo redo blocks bold italic backcolor alignleft aligncenter alignright alignjustify outdent indent removeformat codesample code table image',
          branding: false
        }
    };
  },
  components: {Editor},
  watch: {
  },
  methods: {
  },
  mounted() {
    tinymce.init({})
  },
};
</script>
<style>
.tox-tinymce{
  border-radius: 0px !important;
}
body {
  overflow-y: hidden !important;
}
.tox:not(.tox-tinymce-inline) .tox-editor-header{
  border-bottom: 1px solid #e3e3e3 !important;
    box-shadow: none !important;
}
</style>