# 权限系统设计

一个用户可以拥有多个权限。

每个 Permission 都有固定的 ID，下表为本系统采用的权限码对照表

| ID | 名字                    | 描述        |
|----|-----------------------|-----------|
| 1  | READ_ALL_STUDENT      | 读取任何学生的信息 |
| 2  | WRITE_ALL_STUDENT     | 修改任何学生的信息 |
| 11 | READ_ALL_TEACHER      | 读取任何教师的信息 |
| 12 | WRITE_ALL_TEACHER     | 修改任何教师的信息 |
| 21 | READ_ALL_DEPARTMENT   | 读取任何院系信息  |
| 22 | WRITE_ALL_DEPARTMENT  | 修改任何院系信息  |
| 31 | READ_ALL_ROLES        | 读取任何角色    |
| 32 | WRITE_ALL_ROLES       | 修改任何角色    |
| 41 | READ_ALL_USER_GROUPS  | 读取任何用户组   |
| 42 | WRITE_ALL_USER_GROUPS | 修改任何用户组   |
| 51 | READ_ALL_USER         | 读取任何用户    |
| 52 | WRITE_ALL_USER        | 修改任何用户    |

权限码在代码中的定义请参考：
[com.xuanke.api.entity.Permission](../src/main/kotlin/com/xuanke/api/entity/Permission.kt)

## 查询用户拥有的权限 `GET /permission/list`
需要在请求 header 中附带token
以下为成功查询时的示例返回结果：
```json
{
  "permissions": [
    1,
    2,
    11,
    12
  ]
}
```


