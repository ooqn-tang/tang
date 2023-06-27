<template>
  <div class="row">
    <div class="col-md-9 mb-2 move-p-lr-0">
      <div class="card mb-2 move-b-lr-0">
        <div class="card-body p-0">
          <nav class="nav">
            <router-link class="nav-link" :to="{name:'essay_message'}">最新</router-link>
            <router-link class="nav-link" :to="{name:'essay_my'}">我的</router-link>
          </nav>
        </div>
      </div>
      <div class="card move-b-lr-0">
        <router-view />
      </div>
    </div>
    <div class="col-md-3 mb-2 move-p-lr-0">
      <div class="list-group mb-2 move-b-lr-0">
        <notice></notice>
      </div>
      <div class="card mb-2 move-b-lr-0">
        <info></info>
      </div>
    </div>
  </div>
</template>

<script setup>
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