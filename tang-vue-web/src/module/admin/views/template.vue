<template>
    
    <div style="display: flex;height: 100%;">
        <div style="width: 30%;">
            <div style="border:1px solid rgb(192, 192, 192);border-radius: 5px;height: 100%;padding:5px;">
                <el-tree :data="data" :props="defaultProps" @node-contextmenu="aaa"/>
            </div>
        </div>
        <div style="width: 70%;height: 100%;">
            <Codemirror style="height: 100%;" border :options="cmOptions">

            </Codemirror>
        </div>
    </div>

    <div ref="mv" style="display: none;">
        <el-button>asdfasdf</el-button>
        <el-button>asdfasdf</el-button>
    </div>
</template>
  
<script setup>
import { ref, getCurrentInstance } from "vue";
import { useRoute, useRouter } from "vue-router";
import { useStore } from "vuex";
import { ElMessageBox } from 'element-plus'
import Codemirror from 'codemirror-editor-vue3';



import "codemirror/addon/display/placeholder.js";
import "codemirror/mode/javascript/javascript.js";
import "codemirror/addon/display/placeholder.js";
import "codemirror/theme/dracula.css";
import "v-contextmenu/dist/themes/default.css";

let router = useRouter();
let route = useRoute();
let store = useStore();

let cmOptions = ref({
    mode: "text/javascript", // Language mode
    theme: "dracula", // Theme
})

let routeName = ref(route.name);
let activeName = ref('first')
let articleList = ref([])
let form = ref({
    state: "",
    name: ""
});
let dialogVisible = ref(false)

const handleClose = () => {
    dialogVisible.value = false
}


let data = ref([
  {
    label: 'Level one 1',
    children: [
      {
        label: 'Level two 1-1',
        children: [
          {
            label: 'Level three 1-1-1',
          },
        ],
      },
    ],
  },
  {
    label: 'Level one 2',
    children: [
      {
        label: 'Level two 2-1',
        children: [
          {
            label: 'Level three 2-1-1',
          },
        ],
      },
      {
        label: 'Level two 2-2',
        children: [
          {
            label: 'Level three 2-2-1',
          },
        ],
      },
    ],
  },
  {
    label: 'Level one 3',
    children: [
      {
        label: 'Level two 3-1',
        children: [
          {
            label: 'Level three 3-1-1',
          },
        ],
      },
      {
        label: 'Level two 3-2',
        children: [
          {
            label: 'Level three 3-2-1',
          },
        ],
      },
    ],
  },
])

let handleNodeClick = (data) => {
   
}

// 获取ref mv
let mv = ref(null)

let aaa = (MouseEvent, object, Node, element) => {
    // 获取鼠标点击的位置
    let x = MouseEvent.clientX;
    let y = MouseEvent.clientY;
    // 获取mv的位置
    let mvX = mv.value.offsetLeft;
    let mvY = mv.value.offsetTop;
    console.log(x,y,mvX,mvY)
    // 设置mv 为固定定位到
    mv.value.style.position = 'fixed'
    // 设置显示
    mv.value.style.display = 'block'
    mv.value.style.left = x+10  + 'px'
    mv.value.style.top = y+10 + 'px'
    // z-index 最上层
    mv.value.style.zIndex = 9999
}

// 点击空白处隐藏
document.addEventListener('click', (e) => {
    try{
    mv.value.style.display = 'none'
  }catch(e){}
})

</script>
<style>

</style>