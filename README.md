# Tang

#### 介绍
多人博客系统,包含用户段和管理端

### 进度
用户端
```
 首页：完成
 博客显示：完成
 博客评论：完成
 作者首页：完成
 作者推荐：完成
 信息修改：完成
 登录注销注册：完成
 消息通知：未完成
 内容审核：未完成
```
管理端：
```$xslt
 用户管理：完成
 角色管理：完成
 资源管理完成
 授权：未完成
 登录：完成
 博客管理：未完成
 评论管理：未完成
 举报审核：未完成
 数据统计：未完成
```
#### 软件架构
用户系统： `SpringBoot2.3 + MyBatis + SpringSecurity + thymeleaf + Bootstrap3 + MySQL`
管理系统： `SpringBoot2.3 + MyBatis + SpringSecurity + Vue +element-ui + MySQL `
#### 后端模块
```
tang
    - other 
    - tang-admin 管理模块
    - tang-common 公共代码
    - tang-gateway 门户代码
    - tang-generator 代码自动生成
    - tang-security 安全模块
```
#### 主要界面

![](https://images.gitee.com/uploads/images/2020/1011/182328_c6fa13e2_1998317.png "QQ截图20201011182214.png")
![](https://images.gitee.com/uploads/images/2020/1011/182343_ebd7b3bf_1998317.png "QQ截图20201011182202.png")
![](https://images.gitee.com/uploads/images/2020/1011/182354_142d8374_1998317.png "QQ截图20201011182122.png")
![](https://images.gitee.com/uploads/images/2020/1011/182449_16230f9e_1998317.png "QQ截图20201011181903.png")
![](https://images.gitee.com/uploads/images/2020/1011/182501_0ed02e8e_1998317.png "QQ截图20201011181923.png")