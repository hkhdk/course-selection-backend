# 用户系统设计

用户系统与登录系统和权限系统是紧密相连的，建议先简单浏览这两个模块的文档
再看这一篇。

用户通过绑定学生/教师来自动获取相应的用户权限。对于未绑定此类信息的用户，
默认不会分配任何权限，除非使用管理员账户进行手动修改。