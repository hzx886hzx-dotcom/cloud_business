<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="分类" prop="category">
        <el-select
          v-model="queryParams.category"
          placeholder="请选择分类"
          clearable
          @keyup.enter.native="handleQuery"
        >
          <el-option label="游戏" value="0" />
          <el-option label="用户" value="1" />
        </el-select>
      </el-form-item>
      <el-form-item label="平台" prop="platform">
        <el-select
          v-model="queryParams.platform"
          placeholder="请选择平台"
          clearable
          @keyup.enter.native="handleQuery"
        >
          <el-option label="石头岛" value="0" />
          <el-option label="鲸鱼" value="1" />
        </el-select>
      </el-form-item>
      <el-form-item label="接口名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入接口名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="请求方式" prop="method">
        <el-input
          v-model="queryParams.method"
          placeholder="请输入请求方式"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['business:api:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['business:api:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['business:api:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['business:api:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="apiList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键ID" align="center" prop="id" />
      <el-table-column label="分类" align="center" prop="category" />
      <el-table-column label="平台" align="center" prop="platform" />
      <el-table-column label="接口名称" align="center" prop="name" />
      <el-table-column label="接口URL" align="center" prop="api" />
      <el-table-column label="请求方式" align="center" prop="method" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['business:api:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['business:api:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改游戏接口对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="分类" prop="category">
          <el-select v-model="form.category" placeholder="请选择分类">
            <el-option label="游戏" value="0" />
            <el-option label="用户" value="1" />
          </el-select>
        </el-form-item>
        <el-form-item label="平台" prop="platform">
          <el-select v-model="form.platform" placeholder="请选择平台">
            <el-option label="石头岛" value="0" />
            <el-option label="鲸鱼" value="1" />
          </el-select>
        </el-form-item>
        <el-form-item label="接口名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入接口名称" />
        </el-form-item>
        <el-form-item label="接口URL" prop="api">
          <el-input v-model="form.api" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="请求方式" prop="method">
          <el-select v-model="form.method" placeholder="请选择请求方式">
            <el-option label="GET" value="GET" />
            <el-option label="POST" value="POST" />
          </el-select>
        </el-form-item>
        <el-form-item label="代理" prop="proxy">
          <el-input v-model="form.proxy" placeholder="请输入代理" />
        </el-form-item>
        <el-form-item label="超时时间(秒)" prop="timeout">
          <el-input v-model="form.timeout" type="number" placeholder="请输入超时时间(秒)" />
        </el-form-item>
        <el-form-item label="重试次数" prop="retryTimes">
          <el-input v-model="form.retryTimes" type="number" placeholder="请输入重试次数" />
        </el-form-item>
        <el-form-item label="重试间隔(秒)" prop="retryInterval">
          <el-input v-model="form.retryInterval" type="number" placeholder="请输入重试间隔(秒)" />
        </el-form-item>
        <el-form-item label="下次执行间隔(秒)" prop="nextExecuteInterval">
          <el-input v-model="form.nextExecuteInterval" type="number" placeholder="请输入下次执行间隔(秒)" />
        </el-form-item>
        <el-form-item label="响应格式" prop="respFormat">
          <el-input v-model="form.respFormat" placeholder="请输入响应格式" />
        </el-form-item>
        <el-form-item label="期望响应码(多个用逗号分隔)" prop="expectCode">
          <el-input v-model="form.expectCode" placeholder="请输入期望响应码(多个用逗号分隔)" />
        </el-form-item>
        <el-form-item label="排序" prop="sort">
          <el-input v-model="form.sort" type="number" placeholder="请输入排序" />
        </el-form-item>
        <el-form-item label="接口描述" prop="description">
          <el-input v-model="form.description" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listApi, getApi, delApi, addApi, updateApi } from "@/api/business/api"

export default {
  name: "Api",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 游戏接口表格数据
      apiList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        category: null,
        platform: null,
        name: null,
        api: null,
        method: null,
        contentType: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        name: [
          { required: true, message: "接口名称不能为空", trigger: "blur" }
        ],
        api: [
          { required: true, message: "接口URL不能为空", trigger: "blur" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询游戏接口列表 */
    getList() {
      this.loading = true
      listApi(this.queryParams).then(response => {
        this.apiList = response.rows
        this.total = response.total
        this.loading = false
      })
    },
    // 取消按钮
    cancel() {
      this.open = false
      this.reset()
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        category: null,
        platform: null,
        name: null,
        api: null,
        method: null,
        contentType: null,
        headers: null,
        params: null,
        proxy: null,
        timeout: null,
        retryTimes: null,
        retryInterval: null,
        nextExecuteInterval: null,
        respFormat: null,
        expectCode: null,
        status: null,
        sort: null,
        description: null
      }
      this.resetForm("form")
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm")
      this.handleQuery()
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = "添加游戏接口"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const id = row.id || this.ids
      getApi(id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改游戏接口"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateApi(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addApi(this.form).then(response => {
              this.$modal.msgSuccess("新增成功")
              this.open = false
              this.getList()
            })
          }
        }
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids
      this.$modal.confirm('是否确认删除游戏接口编号为"' + ids + '"的数据项？').then(function() {
        return delApi(ids)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('business/api/export', {
        ...this.queryParams
      }, `api_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
