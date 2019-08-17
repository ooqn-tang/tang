### Controller 返回值

##### 失败，
参数一，给电脑看的状态英文字符(开发时可以做一下简单的注释，意思，)

参数二 给人看的，
ResponseData.error("ParamsIsNull","参数不全");

##### 成功
参数为Object，可以放Map，List，String 等

ResponseData.successful("successful")