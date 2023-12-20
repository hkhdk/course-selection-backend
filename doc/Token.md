# 登录注册系统设计

## 登录操作 `POST /user/login`
通过登录操作可以得到访问其他接口所需的 token，POST Body 格式如下：
```json
{
  "loginName": "...(string)",
  "sign": "...(string)"
}
```
其中 `loginName` 是用户登录名，`sign` 是签名（不建议用明文密码，
应该使用sha256对密码进行摘要）
如果成功，将返回如下格式：
```json
{
  "token": "...(string)"
}
```
`token` 所指字符串将作为用户令牌，用以访问其他接口，详情请看下文

## 接口访问验证
从前文取得的 token 能够用来访问需要权限验证的接口。在 header 中添加
新的键值对即可：(`token`, "从登录接口获得的 token 字符串")

## 注册操作 `POST /user/register`
注册新的用户，POST Body 格式如下：
```json
{
  "loginName": "...(string)",
  "sign": "...(string)"
}
```
含义与登录接口相同。