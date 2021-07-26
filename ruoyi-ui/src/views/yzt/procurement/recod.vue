<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="98px">
      <el-form-item label="供应商名称" prop="supplierName">
        <el-select
          v-model="queryParams.supplierId"
          placeholder="请输入供应商名称"
          clearable
          size="small"
          style="width: 200px"
          @change="handleSupplierNameChange"
        >
          <el-option
            v-for="dict in supplierOptions"
            :key="dict.supplierId"
            :label="dict.supplierName"
            :value="dict.supplierId"
          />
        </el-select>
        <!-- <el-input
          v-model="queryParams.supplierId"
          placeholder="请输入供应商名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        /> -->
      </el-form-item>
      <el-form-item label="商品名称" prop="productName">
        <el-select
          v-model="queryParams.productId"
          placeholder="请输入商品名称"
          clearable
          size="small"
          style="width: 200px"
        >
          <el-option
            v-for="dict in productOptions"
            :key="dict.productId"
            :label="dict.productName"
            :value="dict.productId"
          />
        </el-select>
        <!-- <el-input
          v-model="queryParams.productId"
          placeholder="请输入商品名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        /> -->
      </el-form-item>

      <el-form-item label="送货单号" prop="oddNumbers">
        <el-input
          v-model="queryParams.oddNumbers"
          placeholder="请输入送货单号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="送货日期" prop="deliveryTime">
        <el-date-picker clearable size="small" style="width: 200px"
          v-model="queryParams.deliveryTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择送货日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="采购状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择采购状态" clearable size="small">
          <el-option
            v-for="dict in statusOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="cyan" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">

      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['yzt:procurement:export']"
        >导出</el-button>
      </el-col>
	  <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="procurementList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="采购id" align="center" prop="procurementId" />
      <el-table-column label="供应商名称" align="center" prop="supplier.supplierName" />
      <el-table-column label="商品名称" align="center" prop="product.productName" />
      <el-table-column label="商品规格" align="center" prop="product.model" />
      <el-table-column label="单位" align="center" prop="product.unit" />
      <el-table-column label="采购数量" align="center" prop="number" />
      <el-table-column label="单价" align="center" prop="price" />
      <el-table-column label="总价" align="center" prop="totalPrice" />
      <el-table-column label="送货单号" align="center" prop="oddNumbers" />
      <el-table-column label="入库量" align="center" prop="receipt" />
      <el-table-column label="到货日期" align="center" prop="deliveryTime" width="180" />
      </el-table-column>
      <el-table-column label="采购状态" align="center" prop="status" :formatter="statusFormat" />
      <el-table-column label="备注" align="center" prop="procurementNote" />
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改采购管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="600px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="供应商名称" prop="supplierId">
           <el-select v-model="form.supplierId" placeholder="请选择供应商" @change="handleSupplierNameChange">
              <el-option
              v-for="item in supplierOptions"
                  :key="item.supplierId"
                  :label="item.supplierName"
                  :value="item.supplierId"
              ></el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="商品名称" prop="productId">
          <!-- <el-input v-model="form.productId" placeholder="请输入商品id" /> -->
          <el-select v-model="form.productId" placeholder="请选择商品名称" @change="handleProductChange" >
             <el-option
             v-for="item in productOptions"
                 :key="item.productId"
                 :label="item.productName"
                 :value="item.productId"
             ></el-option>
           </el-select>
        </el-form-item>
        <el-form-item label="采购数量" prop="number">
          <!-- <el-form-item label="采购数量" prop="number">
          <el-input-number v-model="form.number" :min='1' :step='1' step-strictly  placeholder="采购数量"></el-input-number>
        </el-form-item> -->
         <el-input v-model="form.number" placeholder="请输入采购数量" />
        </el-form-item>
        <el-form-item label="单价" prop="price">
          <span>{{form.price}}</span>
          <!-- <el-input v-model="form.price" placeholder="请输入单价" :disabled="true" /> -->
        </el-form-item>
        <el-form-item label="总价" prop="totalPrice">
          <span>{{form.number*form.price}}</span>
          <!-- <el-input v-model="form.totalPrice" placeholder="请输入总价" :disabled="true" /> -->
        </el-form-item>
        <el-form-item label="备注" prop="procurementNote">
          <el-input v-model="form.procurementNote" placeholder="请输入备注" />
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
import { listProcurement, getProcurement, delProcurement, addProcurement, updateProcurement, exportProcurement } from "@/api/yzt/procurement";
import { supplierList } from "@/api/yzt/supplier";
import { productList, getProduct } from "@/api/yzt/product";

export default {
  name: "Procurement",
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
      // 采购管理表格数据
      procurementList: [],
      //供应商数据
      supplierOptions: [],
      //零件数据
      productOptions: [],
      // 采购状态字典
      statusOptions: [],

      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        supplierId: null,
        supplierName:null,
        productId: null,
        productName: null,
        number: null,
        price: null,
        totalPrice: null,
        oddNumbers: null,
        receipt: null,
        deliveryTime: null,
        procurementNote: null,
        status: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        munber: [{
          required: true,
          message: '采购数量必填',
          trigger: 'blur'
        }],
      }
    };
  },
  created() {
    this.getList();
    this.getSupplierList();
    this.getDicts("sys_yzt_procurement_status").then(response => {
      this.statusOptions = response.data;
    });
  },
  methods: {
    /** 查询采购管理列表 */
    getList() {
      this.loading = true;
      listProcurement(this.queryParams).then(response => {
        this.procurementList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 采购状态字典翻译
    statusFormat(row, column) {
      return this.selectDictLabel(this.statusOptions, row.status);
    },
    /** 查询供应商管理列表 */
    getSupplierList() {
      supplierList().then(response => {
        this.supplierOptions = response.data;
      });
      /* productList().then(response => {
        this.productOptions = response.data;
      }); */

    },

    handleSupplierNameChange(val){
      this.form.productId="";
      this.queryParams.productId="";
      var obj = {};
      obj = this.supplierOptions.find(function(item) {
        return item.supplierId === val;
      });
      console.log( "value为", val);
      if(val !=''){
        var supplierName=obj.supplierName;
        console.log("supplierName:",supplierName)
        productList(supplierName).then(response => {
          this.productOptions = response.data;
        });
      }else{
        this.productOptions = "";
      }
    },

    handleProductChange(val){
      var obj = {};
      obj = this.productOptions.find(function(item) {
        return item.productId === val;
      });
      console.log(obj.productId)
      if(val !=''){
        var productId = obj.productId;
        getProduct(productId).then(response =>{
          this.form = response.data;
          this.$set(this.form,"number",1)
        });
      }
      // this.form.number = 1;
    },

    // handleNumberChange(val){
    //   console.log("数量："+val);
    //   this.form.totalPrice = val * (this.form.price);
    // },

    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        procurementId: null,
        supplierId: null,
        supplierName:null,
        productId: null,
        productName:null,
        number: null,
        price: null,
        totalPrice: null,
        oddNumbers: null,
        receipt: null,
        deliveryTime: null,
        procurementNote: null,
        status: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.procurementId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加采购管理";
      this.getSupplierList();
    },
    /** 退货按钮操作 */
    handleUpdate(row) {
      this.reset();
      const procurementId = row.procurementId || this.ids
      this.form.procurementId = procurementId;
      this.form.status = '2';
      const data = this.form;
      getProcurement(procurementId).then(response => {
        this.form = response.data;
        if(this.form.status == 0){
          this.$confirm('是否确认要退货?', "警告", {
              confirmButtonText: "确定",
              cancelButtonText: "取消",
              type: "warning"
            }).then(function() {
          updateProcurement(data);
        }).then(() => {
          this.getList();
          this.msgSuccess("退货成功");
        })
        }else if(this.form.status == 1){
          this.msgSuccess("已入库");
        }else if(this.form.status == 2){
          this.msgSuccess("已退货");
        }
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.procurementId != null) {
            updateProcurement(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addProcurement(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const procurementIds = row.procurementId || this.ids;
      this.$confirm('是否确认删除采购管理编号为"' + procurementIds + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delProcurement(procurementIds);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有采购管理数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportProcurement(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
    }
  }
};
</script>
