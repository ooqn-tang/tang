<template>
  <div class="row">
    <div class="col-md-3 mb-2">
      <div class="col-md-12 mb-2">
        <div class="mb-2">
          <input class="form-control" list="datalistOptions" id="exampleDataList" placeholder="Type to search...">
          <datalist id="datalistOptions">
            <option value="San Francisco"/>
            <option value="New York"/>
            <option value="Seattle"/>
            <option value="Los Angeles"/>
            <option value="Chicago"/>
          </datalist>
        </div>
      </div>
      <div class="col-md-12 mb-2">
        <ul class="list-group">
          <li class="list-group-item">主页</li>
          <li class="list-group-item">探索</li>
          <li class="list-group-item">收藏</li>
          <li class="list-group-item">更多</li>
        </ul>
      </div>
    </div>
    <div class="col-md-9 mb-2">
      <router-view />
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