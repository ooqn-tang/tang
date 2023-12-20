<template>
  <n-space vertical>
    <n-space>
      <NButton type="primary" @click="loadAuthor">查询</NButton>
    </n-space>
    <n-data-table :columns="authorColumns" :data="authorList" :bordered="true" />
  </n-space>

  <n-drawer v-model:show="roleEditDrawer" :width="600">
    <n-drawer-content>
      <template #header>
        角色管理
      </template>
      <n-data-table :columns="roleColumns" :data="roles" :row-key="roleRowKey"
        :default-checked-row-keys="defaultSelectRoles" @update:checked-row-keys="roleCheck" />
      <template #footer>
        <n-space>
          <n-button @click="updateAuthorRole()">保存</n-button>
          <n-button @click="roleEditDrawer = false">取消</n-button>
        </n-space>
      </template>
    </n-drawer-content>
  </n-drawer>
</template>

<script setup>
import request from "@common/request";
import { onMounted, ref, h } from "vue";
import { NButton, NSpace, NDataTable, NDrawer, NDrawerContent } from "naive-ui";
import { loadRolesApi, updateAuthorRoleApi } from "@admin/apis/role"
import { updateAuthorApi, loadRoleByAuthorIdApi, loadAuthorApi } from "@admin/apis/author"

const roleEditDrawer = ref(false);
const authorList = ref([]);
const roles = ref([])
const selectRoleIds = ref([])
const defaultSelectRoles = ref([])
const queryParams = ref({});
const selectAuthorRow = ref({})

const authorColumns = [
  {
    title: "用户名", key: "username"
  },
  {
    title: "昵称", key: "nickname"
  },
  {
    title: "邮箱", key: "mail"
  },
  {
    title: '操作', key: 'actions', width: "250",
    render(row) {
      return h(NSpace, [
        h(
          NButton, {
          size: 'small',
          onClick: async () => {
            defaultSelectRoles.value = []
            loadRoleByAuthorIdApi(row.authorId).then((res) => {
              for (let r of res.data) {
                defaultSelectRoles.value.push(r.roleId)
              }
            })
            selectAuthorRow.value = row
            roleEditDrawer.value = true;
          }
        }, {
          default: () => '角色'
        }
        ), h(
          NButton, {
          size: 'small',
          onClick: () => sendMail(row)
        }, {
          default: () => '编辑'
        }
        )
      ])
    }
  }]

const roleColumns = [
  {
    type: "selection"
  },
  {
    title: "名称", key: "roleName"
  },
  {
    title: "值", key: "roleValue"
  }
]

const roleRowKey = (row) => {
  return row.roleId
}

const loadAuthor = () => {
  loadAuthorApi(queryParams.value).then((res) => {
    authorList.value = res.data;
  });
};

const loadRoles = () => {
  loadRolesApi().then((res) => {
    roles.value = res.data;
  });
}

const roleCheck = (rowKeys) => {
  selectRoleIds.value = rowKeys;
}

const updateAuthorRole = () => {
  updateAuthorRoleApi(selectAuthorRow.value.authorId, selectRoleIds.value)
}

onMounted(async () => {
  loadAuthor();
  loadRoles();
});

</script>