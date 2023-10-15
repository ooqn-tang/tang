<template>
  <div class="row">
    <div class="col-md-12 mb-2 move-p-lr-0">
      <div class="card mb-2 move-b-lr-0">
        <div class="card-body p-0">
          <nav class="nav">
            <router-link class="nav-link" :to="{name:'essay_message'}">最新</router-link>
            <router-link class="nav-link" :to="{name:'essay_my'}">我的</router-link>
          </nav>
        </div>
      </div>
      <router-view />
    </div>
  </div>
</template>

<script setup>
import notice from 'components/notice.vue';
import info from 'components/info.vue';

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