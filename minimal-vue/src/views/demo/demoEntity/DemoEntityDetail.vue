<template>
    <div class="app-container">
        <sticky :class-name="'sub-navbar'">
            <el-button @click="submitForm">保存</el-button></sticky>
        <el-form ref="form" :model="form" :rules="rules" label-width="80px" style="margin-top: 20px;">
            <el-row>
                <el-col :span="12">
                    <el-form-item label="测试实体编码" prop="number">
                        <el-input v-model="form.number" placeholder="请输入测试实体编码" :disabled="isBillId(form.id)"/>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="测试实体名称" prop="name" >
                        <el-input v-model="form.name" placeholder="请输入测试实体名称" :disabled="isBillId(form.id)"/>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-form-item label="备注" prop="remark">
                    <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
                </el-form-item>
            </el-row>
        </el-form>
    </div>
</template>

<script>
    import Sticky from '@/components/Sticky/index'
    import { getDemoEntityDict, insertDemoEntity, updateDemoEntity, getDemoEntityById } from '@/api/demo/demoEntity' // 测试实体api

    export default {
        name: 'DemoEntityDetail',
        components: { Sticky },
        data() {
            return {
                // 测试实体数据字典
                demoEntityDict: {},
                // 缓存每列的详细信息 {fieldName:columnInfo}
                columnInfo: {},
                // 缓存每列的数据字典 {fieldName:dictValues}
                dictValues: {},
                // 当前单据信息
                form: {
                    enabled: 1
                }, 
                // 表单校验
                rules: {
                    name: [
                        { required: true, message: '测试实体名称不能为空', trigger: 'blur' }
                    ],
                    number: [
                        { required: true, message: '测试实体编码不能为空', trigger: 'blur' }
                    ]
                }
            }
        },
        mounted() {
            console.log(this.$route.params)
        },
        async created() {
            // 获取或初始化单据信息
            await this.handleModel()
            // 获取数据字典
            await this.handleDict()
        },
        methods: {
            /**
             * 获取或初始化单据信息
             */
            async handleModel() {
                this.form.id = this.$route.params.id
                if (this.isBillId(this.form.id)) {
                    this.form = await getDemoEntityById(this.form.id)
                    this.form.enabled = +this.form.enabled
                } else {
                    
                }
            },
            /**
             * 获取数据字典
             */
            async handleDict() {
                // 获得本单据的详细定义信息
                const dict = await getDemoEntityDict()
                this.demoEntityDict = dict // 本单据的详细定义信息
                const result = this.parseTableMeta(dict) // 解析本单据的详细定义信息
                this.columnInfo = result.columnInfo // 每列的详细信息
                this.dictValues = result.dictValues // 每列的数据字典
            },
            // 表单提交
            submitForm() {
                this.$refs['form'].validate((valid) => {
                    if (valid) {
                        const model = this.form
                        if (this.isBillId(model.id)) {
                            updateDemoEntity(model.id, this.filterModel(model)).then(res => {
                                this.form = res
                                this.form.enabled = +res.enabled
                                this.$notify({
                                    title: '成功',
                                    message: '修改测试实体成功',
                                    type: 'success'
                                })
                            })
                        } else {
                            delete model.id
                            insertDemoEntity(this.filterModel(model)).then(res => {
                                this.form = res
                                this.form.enabled = +res.enabled
                                this.$notify({
                                    title: '成功',
                                    message: '新增测试实体成功',
                                    type: 'success'
                                })
                            })
                        }
                    } else {
                        console.log('error submit!!')
                        return false
                    }
                })
            }
        }
    }
</script>

