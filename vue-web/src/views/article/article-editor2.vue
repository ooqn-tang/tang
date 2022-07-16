<template>
  <editor :init="{ plugins: 'lists link image table code help wordcount' }" />
</template>

 <script>
import Editor from "@tinymce/tinymce-vue";

export default {
  name: "article-editor2",
  components: {
    editor: Editor,
  },
};
</script>