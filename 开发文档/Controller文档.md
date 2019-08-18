### Controller返回值
错误示例:
```
ResponseData.error("ParamsIsNull","参数不全");
```
成功示例:
```
Blog blog = new Blog();
...
ResponseData.successful(blog);
```

### 入参是否为null
示例：
```
if (ParamUtil.isNullParams(title,text,username,summary))
            return ResponseData.error("ParamsIsNull","参数不全");
```
你也可以在Model包中创建对象，request包用于存储Controller requestBody 对象，通过注解的方式对参数进行判断。

![输入图片说明](https://images.gitee.com/uploads/images/2019/0818/111138_8bfecf6d_1998317.png "屏幕截图.png")
### 获取当前用户名
示例：
```
@PostMapping("user")
@ResponseBody
public ResponseData getUser(@RequestBody Map<String,String> requestBody, 
                                         Principal principal){

        //获取用户名
        String username = principal.getName();
     
        User user = userService.selectUserByName(username );
        return ResponseData.successful(user);
    }
```