<template>
  <el-row>
    <el-col :span="8" style="padding: 10px">
      <el-form ref="formRef" :model="form" label-width="120px">
        <el-form-item label="用户名">
          <el-input v-model="form.nickname"></el-input>
        </el-form-item>
        <el-form-item label="视频分类">
          <el-select
            v-model="form.videoClassId"
            placeholder="please select your zone"
            style="width: 100%"
          >
            <el-option
              v-for="(item, index) in classList"
              :key="index"
              :value="item.value"
              :label="item.name"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="发布时间">
          <el-col :span="11">
            <el-date-picker
              v-model="form.date1"
              type="date"
              placeholder="Pick a date"
              style="width: 100%"
            ></el-date-picker>
          </el-col>
          <el-col :span="2" class="text-center">
            <span class="text-gray-500">-</span>
          </el-col>
          <el-col :span="11">
            <el-date-picker
              v-model="form.date2"
              type="date"
              placeholder="Pick a date"
              style="width: 100%"
            ></el-date-picker>
          </el-col>
        </el-form-item>
        <el-form-item label="状态">
          <el-select
            v-model="form.state"
            placeholder="请选择状态"
            style="width: 100%"
          >
            <el-option
              v-for="(item, index) in stateOptions"
              :label="item.label"
              :value="item.value"
              :key="index"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="loadVideoList">搜索</el-button>
          <el-button @click="reset">重置</el-button>
        </el-form-item>
      </el-form>
    </el-col>
    <el-col :span="16" style="padding: 10px">
      <!-- 视频列表 -->
      <el-table v-loading="loading" :data="videoData.list" style="width: 100%" border>
        <el-table-column label="标题">
          <template #default="scope">
            <span @click="openVideo(scope.row)">{{ scope.row.title }}</span>
          </template>
        </el-table-column>
        <el-table-column label="用户" prop="nickname" />
        <el-table-column label="时间" prop="createDate" />
        <el-table-column label="状态" prop="codeName" />
        <el-table-column label="操作" width="145">
          <template #default="scope">
            <el-button
              size="small"
              @click="openVideo(scope.row, scope.$index)"
              type="primary"
              v-if="scope.row.state == '2'"
              >审查</el-button
            >
            <el-button
              size="small"
              @click="openVideo(scope.row, scope.$index)"
              type="primary"
              v-if="scope.row.state == '1'"
              >查看</el-button
            >
            <el-popconfirm
              confirm-button-text="确认"
              cancel-button-text="取消"
              :icon="InfoFilled"
              icon-color="red"
              @confirm="confirmDelete(scope.$index, scope.row)"
              title="是否确认删除?"
            >
              <template #reference>
                <el-button size="small" type="danger">删除</el-button>
              </template>
            </el-popconfirm>
          </template>
        </el-table-column>
      </el-table>
      <br />
      <el-pagination
        background
        layout="prev, pager, next"
        v-model:currentPage="form.page"
        :page-count="videoData.pages"
        @current-change="handleCurrentChange"
        style="text-align: center"
      ></el-pagination>
      <!-- 不通过原因 -->
      <el-dialog v-model="checkDialogVisible" title="不通过原因" width="30%" >
        <el-form ref="formRef" label-width="120px">
          <el-form-item label="不通过原因">
            <el-select
              v-model="ckForm.checkId"
              placeholder="please select your zone"
              style="width: 100%"
            >
              <el-option value="6" label="政治敏感"></el-option>
              <el-option value="7" label="违法内容"></el-option>
              <el-option value="8" label="商业广告"></el-option>
              <el-option value="9" label="不合规广告"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="备注">
            <el-input v-model="ckForm.checkText"></el-input>
          </el-form-item>
        </el-form>
        <template #footer>
          <span class="dialog-footer">
            <el-button @click="checkDialogVisible = false">取消</el-button>
            <el-button type="primary" @click="pass('5')">确认不通过</el-button>
          </span>
        </template>
      </el-dialog>
      <!-- 查看视频 -->
      <el-dialog
        v-model="videoDialogVisible"
        title="视频播放"
        width="90%"
        :before-close="closeVideo"
      >
        <video
          id="videoPlay"
          ref="videoPlay"
          controls
          :src="ckVideo.videoUrl"
          loop="loop"
          style="width: 100%; height: 500px; background: black"
        ></video>
        <template #footer>
          <span class="dialog-footer">
            <el-button @click="(videoDialogVisible = false), closeVideo()"
              >关闭</el-button
            >
            <el-button
              type="primary"
              @click="(videoDialogVisible = false),form.state = '1', pass('1',form.state)"
              v-if="ckVideo.state == '2'"
              >通过</el-button
            >
            <el-button
              type="primary"
              @click="checkDialogVisible = true"
              v-if="ckVideo.state == '2'"
              >不予以通过</el-button
            >
          </span>
        </template>
      </el-dialog>
    </el-col>
  </el-row>
</template>

<script>
import { ElMessage } from "element-plus";
import request from "utils/request";
export default {
  name: "admin_video",
  data() {
    return {
      loading:true,
      checkDialogVisible: false,
      videoDialogVisible: false,
      routeName: this.$route.name,
      videoBfq: null,
      classList: [],
      form: {
        nickname: "",
        region: "",
        name: "",
        state: "2",
        page: 1,
      },
      videoData: {},
      ckIndex: -1,
      ckVideo: {},
      ckForm: {
        dataId:"",
        checkId:'',
        checkText:'',
        state:''
      },
      stateOptions: [
        {
          value: "2",
          label: "待审核",
        },
        {
          value: "1",
          label: "已通过",
        },
        {
          value: "4",
          label: "已删除",
        },
        {
          value: "5",
          label: "未通过",
        },
      ],
    };
  },
  created() {},
  methods: {
    handleClose(){
      
    },
    handleCurrentChange(number) {
      this.loadVideoList();
    },
    confirmDelete(index, video) {
      this.ckVideo = video
      this.pass(index,"4");
    },
    pass(index,state) {
      this.ckForm.state = state
      this.ckForm.dataId = this.ckVideo.videoId
      request({
        url: "/api/admin/video/pass",
        method: "put",
        data: this.ckForm,
      }).then((response) => {
        alert("")
        ElMessage({ type: "success", message: "执行成功" });
        this.checkDialogVisible = false;
        this.videoDialogVisible = false;
        this.ckVideo = {};
        this.ckForm = {};
        this.videoData.list.splice(index, 1);
      });
    },
    loadVideoClassList() {
      request({
        url: "/api/video/class",
        method: "get",
      }).then((response) => {
        this.classList = response.data;
      });
    },
    loadVideoList() {
      this.loading = true
      request({
        url: "/api/admin/video/list",
        method: "get",
        params: this.form,
      }).then((response) => {
        this.videoData = response.data;
        this.loading = false
      });
    },
    reset() {
      this.form = {
        nickname: "",
        region: "",
        name: "",
        state: "2",
        page: 1,
      };
    },
    openVideo(video, index) {
      this.videoDialogVisible = true;
      this.ckIndex = index
      this.ckVideo = video;
      let _this = this;
      this.$nextTick(function () {
        _this.$refs.videoPlay.play();
      });
    },
    closeVideo() {
      this.ckVideo = {};
      this.videoDialogVisible = false;
    },
  },
  mounted() {
    this.loadVideoClassList();
    this.loadVideoList();
  },
};
</script>