<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light margin-bottom10" style="border-bottom: 1px solid #cecece;">
    <div class="container-fluid">
      <a class="navbar-brand" href="/">🧩堂堂程序员</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a class="nav-link" href="/blog">😶博客</a>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/">👨‍🎓作者</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/">🏷标签</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/">📒专题</router-link>
          </li>
          <li class="nav-item" >
            <div class="input-group input-group-sm" style="margin-top: 4.5px;margin-bottom: 4.5px;">
              <input type="text" class="form-control" >
              <button class="btn btn-outline-secondary" type="button" id="button-addon2">Button</button>
            </div>
          </li>
          
        </ul>
        <form class="d-flex">
          
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item" v-if="$store.state.username == ''">
              <router-link class="nav-link" to="/login">🧐登录</router-link>
            </li>
            <li class="nav-item" v-if="$store.state.username != ''">
              <a class="nav-link"  href="/editor">✒投稿</a>
            </li>
            <li class="nav-item" v-if="$store.state.username != ''">
              <keep-alive exclude="a">
                <a class="nav-link" :href="'/author/'+$store.state.username">😀我的</a>
              </keep-alive>
            </li>
          </ul>
        </form>
      </div>
    </div>
  </nav>
  <div class="container-fluid no-lr-padding">
    <router-view/>
  </div>
</template>

<script>
export default {
  name: "home",
  data() {
    return {
    };
  },
  computed: {
    name() {
      return 
    },
  },
  created() {
  },
  methods: {
  },
  mounted(){
  }
};
</script>

<style scoped lang="scss">
.m-r-5-px{
  margin-right: 5px 
}
.date-color{
  color: rgb(0, 40, 90)
}
p{
  margin: 0px;
}

body{
    overflow-y: scroll;
}


</style>