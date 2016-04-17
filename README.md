# 晨曦Android App 简易后台
*  使用SpringBoot 、spring data jpa 、jjwt 、thymeleaf  ，start bootstrap 2.
*  提供了app 注册、登陆、等用户登录等简单的功能
*  [晨曦App地址](https://github.com/QiuMing/ChenXi)


#测试
* 在bash  下使用 下面的curl 命令，注册、登陆成功均返回token 

##模拟注册

* curl -H "Content-Type:application/json" -X POST -d '{"password":"aaa","phone":"safsad"}' http://127.0.0.1:8080/chenxi/user/register

##模拟登陆 
* curl -i -X POST -H "Content-Type:application/json" -d '{"password":"aaa","phone":"aaaaaaa"}' http://127.0.0.1:8080/chenxi/user/login

##接下来想做的事
* 接入spring security
* 晚上ChenXiApp  的代码重构

##推荐
* 发现有人已经在线上使用了spring boot 等技术做了后台并且已经开源，引荐给大家，[MobileEasy](https://github.com/sectong/mobileeasy)

